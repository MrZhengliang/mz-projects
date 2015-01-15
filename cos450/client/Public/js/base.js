var top;
var left;
if (document.body && document.body.scrollTop && document.body.scrollLeft){
    top=document.body.scrollTop;
    left=document.body.scrollleft;
}
if (document.documentElement && document.documentElement.scrollTop && document.documentElement.scrollLeft){
    top=document.documentElement.scrollTop;
    left=document.documentElement.scrollLeft;
}


/*切换地区*/

var vHomeURL="http://www.cos450.com/cos450/area";
var areaCodeItems = new Array('31','421','511','441','111','531','422');
var areaNickItems = new Array('sh','wh','cd','gz','bj','km','hs');
var areaNameItems = new Array('上海','武汉','成都','广州','北京','昆明','黄石');
var changeArea=function(code,ename){
	//domian cos405.com
	/**
	$.cookie('the_cookie'); // 读取 cookie
	$.cookie('the_cookie', 'the_value'); // 存储 cookie
	$.cookie('the_cookie', 'the_value', { expires: 7 }); // 存储一个带7天期限的 cookie
	$.cookie('the_cookie', '', { expires: -1 }); // 删除 cookie
	*/

	$.cookie('areaCode', code, {expires:90, path:'/', domain:'.cos450.com'});

	/**var curLocHost = window.location.host;
	var curLocPath = window.location.pathname;
	var host = curLocHost;
	var pos = curLocHost.indexOf(".");
	var re = /\/ticket\/\d+/;
	if (pos >= 0) {
		host = curLocHost.substring(0, pos);
	}*/
	window.location.href=vHomeURL+'/'+ename;
}
/*显示地区切换区域,去除已经显示的地区*/
var showArea = function(){
	var str='';
	var areaCode = $.cookie('areaCode');
	for(i=0;i<areaCodeItems.length;i++){
		if(areaCodeItems[i] == areaCode){
			continue;
		}else{
			str += '<a href="javascript:void(0);" onclick="javascript:changeArea(\''+areaCodeItems[i]+'\',\''+areaNickItems[i]+'\');return false;">'+areaNameItems[i]+'</a>'
		}
	}

	return str;
}

/*显示当前cookie的地区*/
var thisCity = function(){
	var code = $.cookie('areaCode');
	switch(code){
		case '421':
		  return '武汉';
		  break;
		case '511':
		  return '成都';
		  break;
		case '441':
		  return '广州';
		  break;
		case '111':
		  return '北京';
		  break;
		case '531':
		  return '昆明';
		  break;
		case '422':
		  return '黄石';
		  break;
		default:
		  return '上海';
		};
}
/*显示地区信息*/
$(function(){
	$("#area").hover(function(){
		$("#area_locations").show();
		},function(){
			$("#area_locations").hide();
	});


	/*初始化外景图片索引变量*/
	var wjImgIndex = 0;
	/*初始化物品交易图片索引变量*/
	var jyImgIndex = 0;
	//外景图片数量
	var wjImgCount =$(".mz_wj_small-pic").size();
	//物品交易图片数量
	var jyImgCount =$(".mz_jy_small-pic").size();

	//外景图片所有对象
	var $wjImgObj = $(".mz_wj_small-pic");
	//物品交易图片所有对象
	var $jyImgObj = $(".mz_jy_small-pic");
	/*外景左按钮*/
	$(".mz_wj_left_arrow").click(function () {
				if(wjImgIndex-1 >= 0){
					$wjImgObj.eq(wjImgIndex+3).css("display","none");
					$wjImgObj.eq(wjImgIndex-1).css("display","inline");
					wjImgIndex = wjImgIndex - 1;
				}
	});
	/*外景右按钮*/
	$(".mz_wj_right_arrow").click(function () {
				if(wjImgIndex+4 < wjImgCount){
					$wjImgObj.eq(wjImgIndex).css("display","none");
					$wjImgObj.eq(wjImgIndex+4).css("display","inline");
					wjImgIndex = wjImgIndex + 1;
				}
	});

	/*物品交易左按钮*/
	$(".mz_jy_left_arrow").click(function () {
				if(jyImgIndex-1 >= 0){
					$jyImgObj.eq(jyImgIndex+4).css("display","none");
					$jyImgObj.eq(jyImgIndex-1).css("display","inline");
					jyImgIndex = jyImgIndex - 1;
				}
	});
	/*物品交易右按钮*/
	$(".mz_jy_right_arrow").click(function () {
				if(jyImgIndex+5 < jyImgCount){
					$jyImgObj.eq(jyImgIndex).css("display","none");
					$jyImgObj.eq(jyImgIndex+5).css("display","inline");
					jyImgIndex = jyImgIndex + 1;
				}
	});


	//通过监控滚动条，显示底部登陆快捷框

    var topHead = $('#flt_logon_head').position().top;
            $(window).scroll(function() {
	            if ($(window).scrollTop() > topHead) {
				    //由于测试暂时先去掉

				    //$('#login_fldiv').fadeIn(200);
					//$('#yeei_login_ad').fadeIn(100);
					var topHr = $('#login_fldiv').height()+'px';
					//$('#yeei_login_ad').css("bottom",topHr);
				} else {
					$('#login_fldiv').fadeOut(200);
					//$('#yeei_login_ad').fadeOut(100);
				 };
			});
});

/*加入收藏*/
function addBookmark(title,url) {
	if (window.sidebar){
		window.sidebar.addPanel(title,url,"");
	}else if(document.all){
		window.external.AddFavorite(url,title);
	}else if(window.opera && window.print ) {
		return true;
	}
}
