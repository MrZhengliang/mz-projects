
// These two lines are required to initialize Express in Cloud Code.
var express = require('express');
var app = express();

var APP_ACCESS_TOKEN = 'YOUR_APP_ACCESS_TOKEN';

// Global app configuration section
app.use(express.bodyParser());    // Middleware for reading request body

app.all('/callback', function(req,res) {
  if( req.param('hub.verify_token') ) {
    if( req.param('hub.verify_token') == 'YOUR_VERIFY_TOKEN' ) {
      res.send( req.param('hub.challenge') );
    } else {
      res.send(403);
    }
    return;
  }
 
  if (!req.body.object || req.body.object !== 'payments') {
    console.log('Error parsing RTU payments object.');
    console.log(req.body);
    res.send(500);
    return;
  }
 
  Parse.Cloud.httpRequest({
    url: 'https://graph.facebook.com/'+req.body.entry[0].id+'?access_token=' + APP_ACCESS_TOKEN
  }).then(function(response){
    var query = new Parse.Query(Parse.User);
    query.equalTo('fbid', response.data.user.id);
    return query.first({ useMasterKey : true });
  }).then(function(user){
    console.log(user);
    if (!user) {
      return Parse.Promise.error({
        message: 'No user object found for this payment uid'
      });
    } else {
      return Parse.User.become(user.getSessionToken())
    }
  }).then(function(result) {
    return Parse.Cloud.run('fulfillPayment', { payment_id: req.body.entry[0].id });
  }).then(function() {
    res.send(200);
  }, function(error) {
    console.log(error.message);
    res.send(500);
  });
});

// Attach the Express app to Cloud Code.
app.listen();