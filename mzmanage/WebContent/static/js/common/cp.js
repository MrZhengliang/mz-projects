/*
 * Cp.js
 * Copyright(c) 2008, .
 * js，包含常用方法。需Prototype1.6支持
 */


Cp = {
  
  
  version: '1.0',
  
  
  load: function() {
    var js = /cp\.js(\?.*)?$/;
  },

  
  rnd: function(max, min) {
    if (!max) { max = 99999; }
    if (!min) { min = 0; }
    return Math.floor(Math.random()*(max - min + 1) + min);
  }
  
};

(function(){
  
  // var a = '123';
  
  Object.extend(Cp, {
    
    
    
  });
  
})();

Cp.load();


Cp.Str = {

  
  leftPad : function(val, size, ch) {
    var result = new String(val);
    if (!ch) {
      ch = " ";
    }
    while (result.length < size) {
      result = ch + result;
    }
    return result.toString();
  },
  
  
  toEscapeParams: function(val, separator) {
    var match = val.strip().match(/([^?#]*)(#.*)?$/);
    if (!match) return { };

    return match[1].split(separator || '&').inject({ }, function(hash, pair) {
      if ((pair = pair.split('='))[0]) {
        var key = decodeURIComponent(pair.shift());
        var value = pair.length > 1 ? pair.join('=') : pair[0];
        if (value != undefined) value = escape(escape(decodeURIComponent(value)));

        if (key in hash) {
          if (!Object.isArray(hash[key])) hash[key] = [hash[key]];
          hash[key].push(value);
        }
        else hash[key] = value;
      }
      return hash;
    });
  }

};

Object.extend(String.prototype, {

      
      leftPad : function(size, ch) {
        return Cp.Str.leftPad(this, size, ch);
      },
      
      
      toEscapeParams : function(separator) {
        return Cp.Str.toEscapeParams(this, separator);
      }

    });

Cp.Val = {

  
  blank : function(val) {
    return /^\s*$/.test(val);
  },

  
  digits : function(val) {
    return /^[\d]+$/.test(val);
  },

  
  alphanum : function(val) {
    return /^[a-zA-Z0-9]+$/.test(val);
  },
  
  
  alpha : function(val) {
    return /^[a-zA-Z]+$/.test(val);
  },
  
  
  mobile : function(val) {
    return /^(13[4-9]|15[012789]|188)[0-9]{8}$/.test(val);
  }

};
Cp.Date = {

  
  parse : function(str) {
    if (str instanceof Date) {
      return str;
    }
    if (typeof str == 'string') {
      var results = str.match(/^ *(\d{4})(\d{2})(\d{2}) *$/);
      if (results && results.length > 3)
        return new Date(parseInt(results[1]), parseInt(results[2]) - 1, parseInt(results[3]));
      
      results = str.match(/^ *(\d{4})(\d{2})(\d{2})(\d{2})(\d{2})(\d{2}) *$/);
      if (results && results.length > 6)
        return new Date(parseInt(results[1]), parseInt(results[2]) - 1, parseInt(results[3]), parseInt(results[4]), parseInt(results[5]), parseInt(results[6]));
      
      results = str.match(/^ *(\d{4})-(\d{1,2})-(\d{1,2}) *$/);
      if (results && results.length > 3)
        return new Date(parseInt(results[1]), parseInt(results[2]) - 1, parseInt(results[3]));

      results = str.match(/^ *(\d{4})-(\d{1,2})-(\d{1,2}) +(\d{1,2}):(\d{1,2}) *$/);
      if (results && results.length > 5)
        return new Date(parseInt(results[1]), parseInt(results[2]) - 1, parseInt(results[3]), parseInt(results[4]), parseInt(results[5]));

      results = str.match(/^ *(\d{4})-(\d{1,2})-(\d{1,2}) +(\d{1,2}):(\d{1,2}):(\d{1,2}) *$/);
      if (results && results.length > 6)
        return new Date(parseInt(results[1]), parseInt(results[2]) - 1, parseInt(results[3]), parseInt(results[4]), parseInt(results[5]), parseInt(results[6]));
      
      results = str.match(/^ *(\d{4})-(\d{1,2})-(\d{1,2}) +(\d{1,2}):(\d{1,2}):(\d{1,2})\.(\d{1,9}) *$/);
      if (results && results.length > 7)
        return new Date(parseInt(results[1]), parseInt(results[2]) - 1, parseInt(results[3]), parseInt(results[4]), parseInt(results[5]), parseInt(results[6]), parseInt(results[7]));

    }
    return null;
  },

  
  format : function(v, fmt) {
    if (typeof v == 'string')
      v = this.parse(v);
    if (v instanceof Date) {
      fmt = (!fmt) ? 'yyyy-MM-dd' : fmt;
      var o = { 
        "M+" : v.getMonth()+1,                 // 月份
        "d+" : v.getDate(),                    // 日
        "h+" : v.getHours(),                   // 小时
        "m+" : v.getMinutes(),                 // 分
        "s+" : v.getSeconds(),                 // 秒
        "q+" : Math.floor((v.getMonth()+3)/3), // 季度
        "S"  : v.getMilliseconds()             // 毫秒
      }; 
      if(/(y+)/.test(fmt)) 
        fmt=fmt.replace(RegExp.$1, (v.getFullYear()+"").substr(4 - RegExp.$1.length)); 
      for(var k in o) 
        if(new RegExp("("+ k +")").test(fmt)) 
          fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length))); 
      return fmt; 
    }
    return '';
  },
  
  
  isLeapYear : function(date) {
    var year = date.getFullYear();
    return !!((year & 3) == 0 && (year % 100 || (year % 400 == 0 && year)));
  },
  
  
  between : function(date, start, end){
    date = this.parse(date); start = this.parse(start); end = this.parse(end);
    if (date && start && end) { 
      var t = date.getTime();
      return start.getTime() <= t && t <= end.getTime();
    }
    return null;
  },
  
  
  compare : function(date1, date2) {
    date1 = this.parse(date1); date2 = this.parse(date2);
    if (date1 && date2) return date1.getTime() - date2.getTime();
    return null;
  }
  
};

Cp.Form = {

  
  getCheckBoxs : function(name) {
    return $$('input[type="checkbox"][name="' + name + '"]');
  },

  
  getRadios : function(name) {
    return $$('input[type="radio"][name="' + name + '"]');
  },
  
  
  selCheckBoxByVal : function(name, vals) {
    this.getCheckBoxs(name).each(function(i) {
          i.checked = (vals.indexOf(i.value) != -1)
        });
  },

    
  selCheckBox : function(name, checked) {
    if (checked == undefined) {
      checked = true;
    }
    this.getCheckBoxs(name).each(function(i) {
          i.checked = checked
        });
  },
  
    
  getSelCheckBox : function(name) {
    return this.getCheckBoxs(name).select(function(i) {
          return i.checked
        });
  },

    
  getSelCheckBoxVal : function(name) {
    var ret = [];
    this.getCheckBoxs(name).each(function(i) {
          if (i.checked)
            ret.push(i.value)
        });
    return ret;
  },

    
  selRadioByVal : function(name, val) {
    this.getRadios(name).each(function(i) {
          i.checked = (i.value == val)
        });
  },

  
  getSelRadio : function(name) {
    return this.getRadios(name).find(function(i) {
          return i.checked
        });
  },

  
  getSelRadioVal : function(name) {
    var sel = this.getRadios(name).find(function(i) {
          return i.checked
        });
    return (sel == undefined) ? sel : sel.value;
  },
  
  submitForm : function(formName) {
  		var f = $(formName);
		var updateframe = f.ownerDocument.createElement('iframe');
		updateframe.id = 'uploadIframe';
		updateframe.name = 'uploadIframe';
		updateframe.style.display = 'none';
		f.ownerDocument.body.appendChild(updateframe);
		iwin = updateframe.contentWindow;
		iwin.name = updateframe.name;
		var to = window.setInterval(function(){
			if(iwin && iwin.location != 'about:blank'){
				try{
			   		window.clearInterval(to);
			  	}catch(e){
			   		window.clearInterval(to);
			  	}
			}
		  } , 200);
			
		f.target = updateframe.name;
		f.submit();
  }

};

Cp.Diag = {

  
  
  
  open: function(url, width, height, callback) {
    showPopWin(url, width, height, callback);
  },
  
  
  
  close : function(callReturnFunc) {
    if (!callReturnFunc) callReturnFunc = true;
    return Try.these(
      function() { return window.parent.parent.hidePopWin(callReturnFunc); },
      function() { return window.parent.hidePopWin(callReturnFunc); },
      function() { return hidePopWin(callReturnFunc); }
    ) || false;
  }
  
};

Cp.Page = {
  
  
  toPage : function(page) {
    var url = this.addUrlParam('curPage', (page == null ? 1 : page));
    // 为什么要移除 INFO? 注释掉
    //url = this.removeParam('INFO', url);
    window.location.href = url;
  },
  
  
  toPageByInput : function() {
    var e = document.getElementById("PageTxxx");
    var n;
    try {
      n = parseInt(e.value);
      if (n >= 1)
        this.toPage(n);
    } catch (e) {
    }
  },

  
  addUrlParam : function(param, value, surl) {
    if (!surl) {
      surl = window.location.href;
    }
    var pos = surl.indexOf("#");
    if (pos != -1) {
      surl = surl.substring(0, pos);
    }
    pos = surl.indexOf("?");
    if (pos == -1 || pos == surl.length - 1) {
      if (param != null) {
        surl += "?" + param + "=" + (value ? value : "");
      }
      return surl;
    }
    var sNewURL = surl.substring(0, pos) + "?";
    surl = surl.substring(pos + 1);
    var aParam = surl.split("&");
    var bParamFound = false;
    var bFirstParam = true;
    for (var i = 0; i < aParam.length; i++) {
      if (aParam[i].length == 0 || aParam[i].indexOf("=") == -1) {
        continue;
      } else if (param == null) {
        sNewURL += (bFirstParam ? "" : "&") + aParam[i];
      } else if (aParam[i].toUpperCase().indexOf(param.toUpperCase() + "=") == 0) {
        sNewURL += (bFirstParam ? "" : "&") + param + "=" + (value ? value : "");
        bParamFound = true;
      } else {
        sNewURL += (bFirstParam ? "" : "&") + aParam[i];
      }
      bFirstParam = false;
    }
    if (!bParamFound && param) {
      sNewURL += "&" + param + "=" + (value ? value : "");
    }
    return sNewURL;
  },

  
  removeParam : function(name, url) {
    if (!url) {
      url = window.location.href;
    }

    var pos = url.indexOf("#");
    if (pos != -1) {
      url = url.substring(0, pos);
    }

    // 没有参数
    pos = url.indexOf("?");
    if (pos == -1) {
      return url;
    }

    // 问号前面的字符，包括问号
    var prefix = url.substring(0, pos + 1);
    var suffix = url.substring(pos + 1);

    var params = suffix.split("&");
    suffix = "";
    for (var i = 0; i < params.length; i++) {
      var param = params[i];

      if (param != name && param.indexOf(name + "=") == -1) {
        if (suffix.length > 0)
          suffix += "&";

        suffix += param;
      }
    }

    return prefix + suffix;
  }
};


NagivatePage = function(page) {
  Cp.Page.toPage(page)
};


NagivatePageByInput = function() {
  Cp.Page.toPageByInput();
};
