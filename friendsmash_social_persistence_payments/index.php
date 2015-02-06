<?php

/**
* Copyright 2013 Facebook, Inc.
*
* You are hereby granted a non-exclusive, worldwide, royalty-free license to
* use, copy, modify, and distribute this software in source code or binary
* form for use in connection with the web services and APIs provided by
* Facebook.
*
* As with any software that integrates with the Facebook platform, your use
* of this software is subject to the Facebook Developer Principles and
* Policies [http://developers.facebook.com/policy/]. This copyright notice
* shall be included in all copies or substantial portions of the software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
* THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
* FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
* DEALINGS IN THE SOFTWARE.
*/
  require 'server/fb-php-sdk/facebook.php';

  // Production
  $app_id = '610913085705460';
  $app_secret = '29e37d7e9b0098322b38504e5aa30a28';
  $app_namespace = 'snailapp';

  $app_url = 'http://happy95.sinaapp.com/' . $app_namespace . '/';
  $scope = 'email,publish_actions';

  // Init the Facebook SDK
  $facebook = new Facebook(array(
    'appId'  => $app_id,
    'secret' => $app_secret,
  ));

  // Get the current user
  $user = $facebook->getUser();

  // If the user has not installed the app, redirect them to the Login Dialog
  if (!$user) {
    $loginUrl = $facebook->getLoginUrl(array(
      'scope' => $scope,
      'redirect_uri' => $app_url,
    ));
    print('<script> top.location.href=\'' . $loginUrl . '\'</script>');
  }
?>

<!DOCTYPE html>
<html>
  <head>
    <title>Friend Smash!</title>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />
    <meta property="og:image" content="http://www.friendsmash.com/images/logo_large.jpg"/>

    <link href="scripts/style.css" rel="stylesheet" type="text/css">

    <script src="scripts/jquery-1.8.3.js"></script>
    <!--[if IE]><script src="scripts/excanvas.js"></script><![endif]-->
    
    <script type="text/javascript" src="//www.parsecdn.com/js/parse-1.2.12.min.js"></script>
  </head>

  <body>
    <div id="fb-root"></div>
    <script src="//connect.facebook.net/en_US/all.js"></script>

    <div id="topbar">
      <img src="images/logo.jpg"/>
    </div>

    <div id="stage">
      <div id="gameboard">
        <canvas id="myCanvas"></canvas>
      </div>
    </div>

    <script>
      var appId = '<?php echo $app_id ?>';
      var appNamespace = '<?php echo $app_namespace ?>';
    </script>

    <script src="scripts/accounting.js"></script>
    <script src="scripts/core.js"></script>
    <script src="scripts/parse.js"></script>
    <script src="scripts/store.js"></script>
    <script src="scripts/game.js"></script>
    <script src="scripts/ui.js"></script>

    <script>
      // Initialize the JS SDK
      FB.init({
        appId: appId,
        frictionlessRequests: true,
        cookie: true,
      });

      Parse.initialize("YOUR_PARSE_APPLICATION_ID", "YOUR_PARSE_JAVASCRIPT_KEY");

      uid = null;

      FB.getLoginStatus(function(response) {
        if( response.authResponse ) {
          uid = response.authResponse.userID;
          Parse.FacebookUtils.logIn(
            getLoginParamsFromAuthResponse(response.authResponse)
          ).then(loginSuccessCallback, loginErrorCallback);
        } else {
          FB.login(init, {scope:'publish_actions'});
        }
      });
    </script>
  </body>
</html>