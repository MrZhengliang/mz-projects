var gUserCurrency     = null;
var gUserPricePoints  = null;

var gSupportedCurrencies = {};

var gCoinsObjectURL = 'http://apps.facebook.com/' + appNamespace + '/coin.html';

var gUserCountryPricePoints = {
  count: 0,
  default: "US",
  countries: []  
};

var gSupportedCurrencies = {
  'USD':  { symbol: '&#36;',    pre:true },
  'SGD':  { symbol: 'S&#36;',   pre:true },
  'RON':  { symbol: 'LEU',      pre:false },
  'EUR':  { symbol: '&#8364;',  pre:true },
  'TRY':  { symbol: '&#8378;',  pre:true },
  'SEK':  { symbol: 'kr',       pre:false },
  'ZAR':  { symbol: 'R',        pre:true },
  'BHD':  { symbol: 'BD',       pre:true },
  'HKD':  { symbol: 'HK&#36;',  pre:true },
  'CHF':  { symbol: 'Fr.',      pre:false },
  'NIO':  { symbol: 'C&#36;',   pre:true },
  'JPY':  { symbol: '&#165;',   pre:true },
  'ISK':  { symbol: 'kr;',      pre:false },
  'TWD':  { symbol: 'NT&#36;',  pre:true },
  'NZD':  { symbol: 'NZ&#36;',  pre:true },
  'CZK':  { symbol: 'K&#269;',  pre:true },
  'AUD':  { symbol: 'A&#36;',   pre:true },
  'THB':  { symbol: '&#3647;',  pre:true },
  'BOB':  { symbol: 'Bs',       pre:true },
  'BRL':  { symbol: 'B&#36;',   pre:true },
  'MXN':  { symbol: 'Mex&#36;', pre:true },
  'ILS':  { symbol: '&#8362;',  pre:true },
  'JOD':  { symbol: 'JD',       pre:false },
  'HNL':  { symbol: 'L',        pre:true },
  'MOP':  { symbol: 'MOP&#36;', pre:true },
  'COP':  { symbol: '&#36;',    pre:true },
  'UYU':  { symbol: '&#36;U',   pre:true },
  'CRC':  { symbol: '&#8353;',  pre:true },
  'DKK':  { symbol: 'kr',       pre:false },
  'QAR':  { symbol: 'QR',       pre:false },
  'PYG':  { symbol: '&#8370;',  pre:true },
  'EGP':  { symbol: 'E&#163;',  pre:true },
  'CAD':  { symbol: 'C&#36;',   pre:true },
  'LVL':  { symbol: 'Ls',       pre:true },
  'INR':  { symbol: '&#8377;',  pre:true },
  'LTL':  { symbol: 'Lt;',      pre:false },
  'KRW':  { symbol: '&#8361;',  pre:true },
  'GTQ':  { symbol: 'Q',        pre:true },
  'AED':  { symbol: 'AED',      pre:false },
  'VEF':  { symbol: 'Bs.F.',    pre:true },
  'SAR':  { symbol: 'SR',       pre:false },
  'NOK':  { symbol: 'kr',       pre:false },
  'UAH':  { symbol: '&#8372;',  pre:true },
  'DOP':  { symbol: 'RD&#36;',  pre:true },
  'CNY':  { symbol: '&#165;',   pre:true },
  'BGN':  { symbol: 'lev',      pre:false },
  'ARS':  { symbol: '&#36;',    pre:true },
  'PLN':  { symbol: 'z&#322;',  pre:false },
  'GBP':  { symbol: '&#163;',   pre:true },
  'PEN':  { symbol: 'S/.',      pre:false },
  'PHP':  { symbol: 'PhP',      pre:false },
  'VND':  { symbol: '&#8363;',  pre:false },
  'RUB':  { symbol: 'py&#1073;', pre:false },
  'RSD':  { symbol: 'RSD',      pre:false },
  'HUF':  { symbol: 'Ft',       pre:false },
  'MYR':  { symbol: 'RM',       pre:true },
  'CLP':  { symbol: '&#36;',    pre:true },
  'HRK':  { symbol: 'kn',       pre:false },
  'IDR':  { symbol: 'Rp',       pre:true },
}

var gCountryCodeNames = {
  "AF": "Afghanistan",
  "AX": "Åland Islands",
  "AL": "Albania",
  "DZ": "Algeria",
  "AS": "American Samoa",
  "AD": "Andorra",
  "AO": "Angola",
  "AI": "Anguilla",
  "AQ": "Antarctica",
  "AG": "Antigua And Barbuda",
  "AR": "Argentina",
  "AM": "Armenia",
  "AW": "Aruba",
  "AU": "Australia",
  "AT": "Austria",
  "AZ": "Azerbaijan",
  "BS": "Bahamas",
  "BH": "Bahrain",
  "BD": "Bangladesh",
  "BB": "Barbados",
  "BY": "Belarus",
  "BE": "Belgium",
  "BZ": "Belize",
  "BJ": "Benin",
  "BM": "Bermuda",
  "BT": "Bhutan",
  "BO": "Bolivia",
  "BQ": "Bonaire",
  "BA": "Bosnia And Herzegovina",
  "BW": "Botswana",
  "BV": "Bouvet Island",
  "BR": "Brazil",
  "IO": "British Indian Ocean Territory",
  "BN": "Brunei Darussalam",
  "BG": "Bulgaria",
  "BF": "Burkina Faso",
  "BI": "Burundi",
  "KH": "Cambodia",
  "CM": "Cameroon",
  "CA": "Canada",
  "CV": "Cape Verde",
  "KY": "Cayman Islands",
  "CF": "Central African Republic",
  "TD": "Chad",
  "CL": "Chile",
  "CN": "China",
  "CX": "Christmas Island",
  "CC": "Cocos Islands",
  "CO": "Colombia",
  "KM": "Comoros",
  "CG": "Congo",
  "CD": "Congo, The Democratic Republic Of The",
  "CK": "Cook Islands",
  "CR": "Costa Rica",
  "CI": "Côte D'ivoire",
  "HR": "Croatia",
  "CU": "Curaçao",
  "CY": "Cyprus",
  "CZ": "Czech Republic",
  "DK": "Denmark",
  "DJ": "Djibouti",
  "DM": "Dominica",
  "DO": "Dominican Republic",
  "EC": "Ecuador",
  "EG": "Egypt",
  "SV": "El Salvador",
  "GQ": "Equatorial Guinea",
  "ER": "Eritrea",
  "EE": "Estonia",
  "ET": "Ethiopia",
  "FK": "Falkland Islands (malvinas)",
  "FO": "Faroe Islands",
  "FJ": "Fiji",
  "FI": "Finland",
  "FR": "France",
  "GF": "French Guiana",
  "PF": "French Polynesia",
  "TF": "French Southern Territories",
  "GA": "Gabon",
  "GM": "Gambia",
  "GE": "Georgia",
  "DE": "Germany",
  "GH": "Ghana",
  "GI": "Gibraltar",
  "GR": "Greece",
  "GL": "Greenland",
  "GD": "Grenada",
  "GP": "Guadeloupe",
  "GU": "Guam",
  "GT": "Guatemala",
  "GG": "Guernsey",
  "GN": "Guinea",
  "GW": "Guinea-bissau",
  "GY": "Guyana",
  "HT": "Haiti",
  "HM": "Heard Island And Mcdonald Islands",
  "VA": "Vatican",
  "HN": "Honduras",
  "HK": "Hong Kong",
  "HU": "Hungary",
  "IS": "Iceland",
  "IN": "India",
  "ID": "Indonesia",
  "IR": "Iran",
  "IQ": "Iraq",
  "IE": "Ireland",
  "IM": "Isle Of Man",
  "IL": "Israel",
  "IT": "Italy",
  "JM": "Jamaica",
  "JP": "Japan",
  "JE": "Jersey",
  "JO": "Jordan",
  "KZ": "Kazakhstan",
  "KE": "Kenya",
  "KI": "Kiribati",
  "KP": "Korea, Democratic People's Republic Of",
  "KR": "Korea, Republic Of",
  "KW": "Kuwait",
  "KG": "Kyrgyzstan",
  "LA": "Lao People's Democratic Republic",
  "LV": "Latvia",
  "LB": "Lebanon",
  "LS": "Lesotho",
  "LR": "Liberia",
  "LY": "Libya",
  "LI": "Liechtenstein",
  "LT": "Lithuania",
  "LU": "Luxembourg",
  "MO": "Macao",
  "MK": "Macedonia",
  "MG": "Madagascar",
  "MW": "Malawi",
  "MY": "Malaysia",
  "MV": "Maldives",
  "ML": "Mali",
  "MT": "Malta",
  "MH": "Marshall Islands",
  "MQ": "Martinique",
  "MR": "Mauritania",
  "MU": "Mauritius",
  "YT": "Mayotte",
  "MX": "Mexico",
  "FM": "Micronesia",
  "MD": "Moldova",
  "MC": "Monaco",
  "MN": "Mongolia",
  "ME": "Montenegro",
  "MS": "Montserrat",
  "MA": "Morocco",
  "MZ": "Mozambique",
  "MM": "Myanmar",
  "NA": "Namibia",
  "NR": "Nauru",
  "NP": "Nepal",
  "NL": "Netherlands",
  "NC": "New Caledonia",
  "NZ": "New Zealand",
  "NI": "Nicaragua",
  "NE": "Niger",
  "NG": "Nigeria",
  "NU": "Niue",
  "NF": "Norfolk Island",
  "MP": "Northern Mariana Islands",
  "NO": "Norway",
  "OM": "Oman",
  "PK": "Pakistan",
  "PW": "Palau",
  "PS": "Palestine: State Of",
  "PA": "Panama",
  "PG": "Papua New Guinea",
  "PY": "Paraguay",
  "PE": "Peru",
  "PH": "Philippines",
  "PN": "Pitcairn",
  "PL": "Poland",
  "PT": "Portugal",
  "PR": "Puerto Rico",
  "QA": "Qatar",
  "RE": "Réunion",
  "RO": "Romania",
  "RU": "Russian Federation",
  "RW": "Rwanda",
  "BL": "Saint Barthélemy",
  "SH": "Saint Helena, Ascension And Tristan Da Cunha",
  "KN": "Saint Kitts And Nevis",
  "LC": "Saint Lucia",
  "MF": "Saint Martin",
  "PM": "Saint Pierre And Miquelon",
  "VC": "Saint Vincent And The Grenadines",
  "WS": "Samoa",
  "SM": "San Marino",
  "ST": "Sao Tome And Principe",
  "SA": "Saudi Arabia",
  "SN": "Senegal",
  "RS": "Serbia",
  "SC": "Seychelles",
  "SL": "Sierra Leone",
  "SG": "Singapore",
  "SX": "Sint Maarten",
  "SK": "Slovakia",
  "SI": "Slovenia",
  "SB": "Solomon Islands",
  "SO": "Somalia",
  "ZA": "South Africa",
  "GS": "South Georgia",
  "SS": "South Sudan",
  "ES": "Spain",
  "LK": "Sri Lanka",
  "SD": "Sudan",
  "SR": "Suriname",
  "SJ": "Svalbard And Jan Mayen",
  "SZ": "Swaziland",
  "SE": "Sweden",
  "CH": "Switzerland",
  "SY": "Syrian Arab Republic",
  "TW": "Taiwan",
  "TJ": "Tajikistan",
  "TZ": "Tanzania",
  "TH": "Thailand",
  "TL": "Timor-leste",
  "TG": "Togo",
  "TK": "Tokelau",
  "TO": "Tonga",
  "TT": "Trinidad And Tobago",
  "TN": "Tunisia",
  "TR": "Turkey",
  "TM": "Turkmenistan",
  "TC": "Turks And Caicos Islands",
  "TV": "Tuvalu",
  "UG": "Uganda",
  "UA": "Ukraine",
  "AE": "United Arab Emirates",
  "GB": "United Kingdom",
  "US": "United States",
  "UM": "United States Minor Outlying Islands",
  "UY": "Uruguay",
  "UZ": "Uzbekistan",
  "VU": "Vanuatu",
  "VE": "Venezuela",
  "VN": "Viet Nam",
  "VG": "Virgin Islands, British",
  "VI": "Virgin Islands, U.s.",
  "WF": "Wallis And Futuna",
  "EH": "Western Sahara",
  "YE": "Yemen",
  "ZM": "Zambia",
  "ZW": "Zimbabwe"
};

function buildStore() {
  
  getUserCurrency();
  getCoinPrice();
  
  var store = $('#store')[0];
  
  var storeHeader = document.createElement('div');
  storeHeader.id           = 'store_title';
  store.appendChild(storeHeader);
  
  var storeImage = document.createElement('img');
  storeImage.setAttribute('src', 'images/store64.png');
  storeHeader.appendChild(storeImage);
  
  var storeTitle = document.createElement('h1');
  storeTitle.id         = 'store_title';
  storeTitle.innerHTML  = 'Store';
  storeHeader.appendChild(storeTitle);
  
  var coinsDisplay = document.createElement('div');
  coinsDisplay.className  = 'stats_display';
  coinsDisplay.style.top  = '20px';
  coinsDisplay.style.left = '170px';
  storeHeader.appendChild(coinsDisplay);
  
  var coinsIcon = document.createElement('img');
  coinsIcon.setAttribute('src', 'images/coin40.png');
  coinsDisplay.appendChild(coinsIcon);
  
  var coinsNumber = document.createElement('span');
  coinsNumber.className  = 'player_coins';
  coinsNumber.innerHTML = ''+gPlayerCoins;
  coinsDisplay.appendChild(coinsNumber);
  
  var bombsDisplay = document.createElement('div');
  bombsDisplay.className  = 'stats_display';
  bombsDisplay.style.top  = '20px';
  bombsDisplay.style.left = '260px';
  storeHeader.appendChild(bombsDisplay);
  
  var bombsIcon = document.createElement('img');
  bombsIcon.setAttribute('src', 'images/bomb40.png');
  bombsDisplay.appendChild(bombsIcon);
  
  var bombsNumber = document.createElement('span');
  bombsNumber.className  = 'player_bombs';
  bombsNumber.innerHTML = ''+gPlayerBombs;
  bombsDisplay.appendChild(bombsNumber);
  
  var productsButton = document.createElement('div');
  productsButton.id         = 'products_button';
  productsButton.className  = 'store_button selected';
  productsButton.style.top  = '80px';
  productsButton.style.left = '75px';
  productsButton.setAttribute("onClick","javascript:showProducts()");
  storeHeader.appendChild(productsButton);
  
  var productsIcon = document.createElement('img');
  productsIcon.setAttribute('src', 'images/store64.png');
  productsButton.appendChild(productsIcon);
  
  var productsTag = document.createElement('p');
  productsTag.className   = 'button_tag';
  productsTag.innerHTML   = 'Products';
  productsButton.appendChild(productsTag);
  
  var coinsButton = document.createElement('div');
  coinsButton.id         = 'coins_button';
  coinsButton.className  = 'store_button';
  coinsButton.style.top  = '80px';
  coinsButton.style.left = '230px';
  coinsButton.setAttribute("onClick","javascript:showCoinPackages()");
  storeHeader.appendChild(coinsButton);
  
  var coinsIcon = document.createElement('img');
  coinsIcon.setAttribute('src', 'images/coin_bundle64.png');
  coinsButton.appendChild(coinsIcon);
  
  var coinsTag = document.createElement('p');
  coinsTag.className   = 'button_tag';
  coinsTag.innerHTML   = 'Coins';
  coinsButton.appendChild(coinsTag);
  
  showProducts();
  
}

function showProducts() {

  $('.store_button').removeClass('selected');
  $('#products_button').addClass('selected');
  
  var store = $('#store')[0];
  
  var storeContents = $('#store_contents')[0] || document.createElement('div');
  storeContents.id = 'store_contents';
  storeContents.innerHTML = "";
  if(store.children.length < 2) store.appendChild(storeContents);
  
  //Bombs
  var buy_bombs1 = document.createElement('div');
  buy_bombs1.className = "store_package";
  buy_bombs1.innerHTML = "<img src='images/bomb_icon.png'/>";
  buy_bombs1.innerHTML += "<h3 class='quantity'>10 bombs</h3>";
  buy_bombs1.innerHTML += "<span></span><img src='images/coin_bundle_icon.png'/>";
  buy_bombs1.innerHTML += "<h3>100 coins</h3>";
  buy_bombs1.innerHTML += "<div class='button_small'>Buy!</div>";
  buy_bombs1.setAttribute("onClick","javascript:buyBombs(10,100)");
  storeContents.appendChild(buy_bombs1);

  var buy_bombs2 = document.createElement('div');
  buy_bombs2.className = "store_package";
  buy_bombs2.innerHTML = "<img src='images/bomb_icon.png'/>";
  buy_bombs2.innerHTML += "<h3 class='quantity'>30 bombs</h3>";
  buy_bombs2.innerHTML += "<span></span><img src='images/coin_bundle_icon.png'/>";
  buy_bombs2.innerHTML += "<h3>270 coins</h3>";
  buy_bombs2.innerHTML += "<div class='button_small'>Buy!</div>";
  buy_bombs2.setAttribute("onClick","javascript:buyBombs(30, 270)");
  storeContents.appendChild(buy_bombs2);

  var buy_bombs3 = document.createElement('div');
  buy_bombs3.className = "store_package";
  buy_bombs3.innerHTML = "<img src='images/bomb_icon.png'/>";
  buy_bombs3.innerHTML += "<h3 class='quantity'>50 bombs</h3>";
  buy_bombs3.innerHTML += "<span></span><img src='images/coin_bundle_icon.png'/>";
  buy_bombs3.innerHTML += "<h3>400 coins</h3>";
  buy_bombs3.innerHTML += "<div class='button_small'>Buy!</div>";
  buy_bombs3.setAttribute("onClick","javascript:buyBombs(50, 400)");
  storeContents.appendChild(buy_bombs3);
  
}

function showCoinPackages() {

  $('.store_button').removeClass('selected');
  $('#coins_button').addClass('selected');
  
  var store = $('#store')[0];
  
  var storeContents = $('#store_contents')[0] || document.createElement('div');
  storeContents.id = 'store_contents';
  storeContents.innerHTML = "";
  if(store.children.length < 2) store.appendChild(storeContents);
  
  if (!gUserCurrency) {
    getUserCurrency(showCoinPackages);
    storeContents.innerHTML = "<h1>Loading...</h1>";
    storeContents.innerHTML += "<img src='images/loading.gif'>";
  }
  else {
    var quantities = [10, 50, 100, 200, 500];
    
    for (var x=0; x<5; x++) {
      var unit;
      var price;
      
      if (gSupportedCurrencies[gUserCurrency.user_currency].price) {
         unit = gSupportedCurrencies[gUserCurrency.user_currency].price;
         price = parseInt(unit*quantities[x]*100)/100;
      }
      else {
        unit = gSupportedCurrencies["USD"].price;
        price = parseInt(unit*quantities[x]*gUserCurrency.usd_exchange_inverse*100)/100;
      }
      
      var buy_coins = document.createElement('div');
      buy_coins.className = "store_package";
      buy_coins.innerHTML = "<img src='images/coin_bundle_icon.png'/>";
      buy_coins.innerHTML += "<h3 class='quantity'>"+quantities[x]+" coins</h3>";
      buy_coins.innerHTML += "<span></span>";

      buy_coins.innerHTML += "<h3>" + accounting.formatMoney(price, 
        { symbol: gSupportedCurrencies[gUserCurrency.user_currency].symbol, 
          format: gSupportedCurrencies[gUserCurrency.user_currency].pre ? "%s %v" : "%v %s",
          precision: 2
        }) + "</h3>";     

      buy_coins.innerHTML += "<div class='button_small'>Buy!</div>";
      buy_coins.setAttribute("onClick","javascript:buyCoins("+quantities[x]+")");
      storeContents.appendChild(buy_coins);
    }
    
    // Adding the dedicated pay with mobile button
    var mobileButton = document.createElement('div');
    mobileButton.id           = 'mobile_button';
    mobileButton.className    = 'store_button';
    mobileButton.style.top    = '290px';
    mobileButton.style.left   = '120px';
    mobileButton.style.width  = '170px';
    mobileButton.setAttribute("onClick","javascript:showMobile()");
    storeContents.appendChild(mobileButton);

    var mobileIcon = document.createElement('img');
    mobileIcon.setAttribute('src', 'images/mobile64.png');
    mobileButton.appendChild(mobileIcon);

    var mobileTag = document.createElement('p');
    mobileTag.className   = 'button_tag';
    mobileTag.innerHTML   = 'Pay with Mobile';
    mobileButton.appendChild(mobileTag);
  }
}

function showMobile() {

  $('.store_button').removeClass('selected');
  $('#coins_button').addClass('selected');
  
  var store = $('#store')[0];
  
  var storeContents = $('#store_contents')[0] || document.createElement('div');
  storeContents.id = 'store_contents';
  storeContents.innerHTML = "";
  if(store.children.length < 2) store.appendChild(storeContents);
  
  if (!gUserPricePoints) { 
    getUserPricePoints(showMobile);
    storeContents.innerHTML = "<h1>Loading...</h1>";
    storeContents.innerHTML += "<img src='images/loading.gif'>";
  }
  else {
    
    var title = document.createElement('h2');
    title.innerHTML = 'Use your mobile phone to buy coins!';
    title.style.width = '100%';
    title.style.textAlign = 'center';
    title.style.font = '20pt "Arial Narrow", Arial, sans-serif';
    title.style.marginBottom = '10px';
    
    storeContents.appendChild(title);
    
    var country_selector = document.createElement('select');
    country_selector.id = "country_selector";
    country_selector.style.width = "90px";
    
    for (var country_id in gUserCountryPricePoints.countries) {
      if (typeof(gUserCountryPricePoints.countries[country_id]) == "function") continue;
      var country_option = document.createElement("option");
      country_option.value = country_id;
      country_option.innerHTML = gCountryCodeNames[country_id];
      country_selector.appendChild(country_option);
    }
    
    var select_text = document.createElement("h3");
    select_text.innerHTML = "Select your country:  ";
    
    storeContents.appendChild(select_text);
    storeContents.appendChild(country_selector);
    
    $("select").change(updatePricePointsCountry);
    $("#country_selector").val(gUserCountryPricePoints.default);
    updatePricePointsCountry();
  }
}

function updatePricePointsCountry() {
  
  var pricepoints   = gUserCountryPricePoints.countries[$("#country_selector")[0].value];
  var storeContents = $('#store_contents')[0];
  
  $(".store_package").remove();
  
  for (var x in pricepoints) {
    if (typeof(pricepoints[x]) == "function") continue;
    
    var price     = pricepoints[x].payer_amount;
    var currency  = pricepoints[x].currency;
    var unit;
    
    if (gSupportedCurrencies[currency].price) {
      unit = gSupportedCurrencies[currency].price;     
    }
    else {
      unit = parseInt(gSupportedCurrencies["USD"].price*gUserCurrency.usd_exchange_inverse*100)/100;
    }
    
    var quantity = Math.round(pricepoints[x].payout_base_amount/unit);
    if (quantity <= 0) quantity = 1;
    
    var buy_coins = document.createElement('div');
    buy_coins.className = "store_package";
    buy_coins.innerHTML = "<img src='images/coin_bundle_icon.png'/>";
    buy_coins.innerHTML += "<h3 class='quantity'>"+quantity+" coins</h3>";
    buy_coins.innerHTML += "<span></span>";
    
    if (gSupportedCurrencies[currency].pre) {
      buy_coins.innerHTML += "<h3>" + gSupportedCurrencies[currency].symbol + price + "</h3>";
    }
    else {
      buy_coins.innerHTML += "<h3>" + price + gSupportedCurrencies[currency].symbol + "</h3>";
    }
    
    buy_coins.innerHTML += "<div class='button_small'>Buy!</div>";
    buy_coins.setAttribute("onClick","javascript:buyCoinsMobile("+x+")");
    storeContents.appendChild(buy_coins);

  }
}

function getUserCurrency(callback) {
  FB.api('/me/?fields=currency', function(data) {
      if (!data || data.error) {
          // handle errors
          console.error("Error fetching user currency");
      } else {
          console.log("User currency data:");
          console.log(data);
          gUserCurrency = data.currency;

          if (callback) callback();
      }
  });
}

function getCoinPrice() {
  FB.api('', 'post', {
      id: gCoinsObjectURL, 
      scrape: true
    }, function(response){
    if (response && !response.error) {
      if (response.data && response.data.price) {
        for (var x in response.data.price) {
          var pricepoint = response.data.price[x];
          if ( typeof(pricepoint) != 'object' ) continue;
          gSupportedCurrencies[pricepoint.currency].price = pricepoint.amount;
        }
      }
    }
  });
}

function getUserPricePoints(callback) {
  FB.api('/me/?fields=payment_mobile_pricepoints', function(data) {
      if (!data || data.error) {
          // handle errors
          console.error("ERROR GETTING USER PRICEPOINTS");
          console.log(data);
      } else {

          gUserPricePoints = data.payment_mobile_pricepoints;
          
          //GET DIFFERENT COUNTRIES PRICEPOINTS
          for (var i in gUserPricePoints.pricepoints) {
            var pricepoint = gUserPricePoints.pricepoints[i];
            if (typeof(pricepoint) == "function") continue;
            
            if (!gUserCountryPricePoints.countries[pricepoint.country]) {
              gUserCountryPricePoints.countries[pricepoint.country] = [];
              gUserCountryPricePoints.count++;
            }
            
            gUserCountryPricePoints.countries[pricepoint.country].push(pricepoint);
          }
          
          if (gUserPricePoints.predicted_mobile_country) 
            gUserCountryPricePoints.default = gUserPricePoints.predicted_mobile_country
          else gUserCountryPricePoints.default = gUserPricePoints.pricepoints[0].country;
          
          if (callback) callback();
      }
  });
}

function buyBombs(quantity, price) {
  if (price <= gPlayerCoins) {
    gPlayerBombs += parseInt(quantity);
    gPlayerCoins -= parseInt(price);
    updatePlayerUI();
    closeStore();
    var success = showPopUp({img:'bomb64.png', title:'Bombs!'});
    success.innerHTML = "You bought "+quantity+" bombs!<br>Let's smash some friends!";
  }
  else alert("Not enough coins!");
}

function buyCoins(quantity) {
  var requestID = hash(64);
  console.log("Constructing Request ID: " + requestID);
  
  FB.ui({
      method: 'pay',
      action: 'purchaseitem',
      product: gCoinsObjectURL,
      request_id: requestID,
      quantity: quantity
    },
    verifyPayment
  );
}

function buyCoinsMobile(pricepointNumber) {
  var pricepoints;
  
  if ($("#country_selector").length > 0) {
    pricepoints = gUserCountryPricePoints.countries[$("#country_selector")[0].value];
  }
  else pricepoints = gUserCountryPricePoints.countries[gUserCountryPricePoints.default];
  
  var current_pricepoint = pricepoints[pricepointNumber];
  var currency  = current_pricepoint.currency;
  var unit;
  
  var requestID = hash(64);
  console.log("Constructing Request ID: " + requestID);
  
  if (gSupportedCurrencies[currency].price) {
    unit = gSupportedCurrencies[currency].price;     
  }
  else {
    unit = parseInt(gSupportedCurrencies["USD"].price*gUserCurrency.usd_exchange_inverse*100)/100;
  }
  
  var quantity = Math.round(current_pricepoint.payout_base_amount/unit);
  if (quantity <= 0) quantity = 1;  
  
  FB.ui({
      method: 'pay',
      action: 'purchaseitem',
      product: gCoinsObjectURL,
      request_id: requestID,
      pricepoint_id: current_pricepoint.pricepoint_id,
      quantity: quantity,
      quantity_min: 1,
      quantity_max: 1500
    },
    verifyPayment
  );
}

function verifyPayment(data) {
  if(!data) {
    alert("There was an error processing your payment. Please try again!");
    return;
  }
  
  console.log("Payment verification complete");
  console.log(data);
  
  if(data.error_code) {
    if(data.error_code != 1383010) {
      alert("There was an error processing your payment."+data.error_message+" Error code:"+data.error_code);
    }
    return;
  }

  closeStore();
  gPlayerCoins = parseInt(gPlayerCoins) + parseInt(data.quantity);
        
  var success = showPopUp({img:'coin_bundle64.png', title:'Coins!'});
  success.innerHTML = "You bought " + data.quantity + " coins!<br>Let's smash some friends!";

  $('.player_coins').html(gPlayerCoins);
}

function hash(s){
  var n;
  if (typeof(s) == 'number' && s === parseInt(s, 10)){
    s = Array(s + 1).join('x');
  }
  return s.replace(/x/g, function(){
    var n = Math.round(Math.random() * 61) + 48;
    n = n > 57 ? (n + 7 > 90 ? n + 13 : n + 7) : n;
    return String.fromCharCode(n);
  });
} 
