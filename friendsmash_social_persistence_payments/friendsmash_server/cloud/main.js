require('cloud/app.js');

var APP_ACCESS_TOKEN = 'YOUR_APP_ACCESS_TOKEN';

var Payment = Parse.Object.extend('Payment');

Parse.Cloud.define('fulfillPayment', function(request, response) {
  Parse.Cloud.httpRequest({
    url: 'https://graph.facebook.com/'+request.params.payment_id+'?access_token=' + APP_ACCESS_TOKEN
  }).then( function(httpResponse) {
    var paymentJSON = httpResponse.data;
    
    if( !paymentJSON.actions 
      || !paymentJSON.actions[0] 
      || paymentJSON.actions[0].type != 'charge'
      || paymentJSON.actions[0].status != 'completed' ) {
      return Parse.Promise.error({message: 'Payment not completed'});
    }

    if( !request.user 
      || !request.user.get('fbid')
      || request.user.get('fbid') != paymentJSON.user.id ) {
      return Parse.Promise.error({message: 'User didn\'t match'});
    }

    if ( paymentJSON.actions.length == 1 ) {
      var payment = new Payment({
        payment_id: paymentJSON.id,
        user: request.user,
        latest_action: paymentJSON.actions[0].type,
        status: paymentJSON.actions[0].status,
        item: paymentJSON.items[0].product,
        quantity: paymentJSON.items[0].quantity,
        currency: paymentJSON.actions[0].currency,
        currency: paymentJSON.actions[0].amount
      });
      return payment.save();
    } else {
      var query = new Parse.Query(Payment);
      query.equalTo('payment_id', request.object.get('payment_id'));
      return query.first();
    }
  }, function(httpError){
    return Parse.Promise.error({message: 'Graph API error: ' + httpError.data.error.message });
  }).then( function(payment) {
    if( payment.get('latest_action') == 'charge' ) {
      request.user.increment('coins', payment.get('quantity'));  
      return request.user.save();
    } else {
      console.log( 'Payment with id ' + payment.get('payment_id') + ' has new action ' + payment.get('latest_action') );
      return Parse.Promise.as(request.user);
    }
  }, function(error) {
    return Parse.Promise.error({message: 'Payment wasn\'t saved: ' + error.message });
  }).then( function(user) {
    response.success('Payment fulfilled!');
  }, function(error) {
    response.error('Payment not fulfilled: ' + error.message);
  });
});

Parse.Cloud.beforeSave(Payment, function(request, response) {
  if (!request.object.get('payment_id')) {
    response.error('A Payment must have a payment_id.');
  } else {
    var query = new Parse.Query(Payment);
    query.equalTo('payment_id', request.object.get('payment_id'));
    query.first().then( function(object) {
      if(object) {
        response.error("A Payment with this payment_id already exists.");
      } else {
        response.success();
      }
    }, function(error){
      response.error("Could not validate uniqueness for this Payment.");
    });
  }
});