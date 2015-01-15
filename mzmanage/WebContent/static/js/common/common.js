var callBack = function(msgDivId,msg,isCorrect){
	
	alert(msg);
/**
	var clsName = "errormsg";
	if(isCorrect == true){
		clsName = "correctmsg";
	}else{
	}

	$(msgDivId).removeClassName("errormsg");
	$(msgDivId).removeClassName("correctmsg");
	$(msgDivId).addClassName(clsName);	
	$(msgDivId).show();
	$(msgDivId).update(msg);
		
	window.setTimeout(function(){
			$(msgDivId).hide();
			$(msgDivId).removeClassName(clsName);
	}, 3000);
*/
};

var resetMultiple = function(leftSelect, rightSelect){
	var left = document.getElementById(leftSelect);
	var right = document.getElementById(rightSelect);
	left.length = 0;
	right.length = 0;
};

var resetForm = function(formName){
	$(formName).reset();
};

//重新加载url
var loadUrl = function(url){
	window.location = url;
};
//重新加载父窗口的url
var loadFrameUrl = function(url){	
	parent.leftFrame.window.location.reload();
	window.location = url;
};
//点击查询条件
var queryClick = function(divHeight, context){
	//new Dialog.Box('showId');
	
	//变更图片
	changeSearchImg(context);
	
	if($('idHasTabMenu').visible()){
		$('idHasTabMenu').hide();
		return;
	}
	$('idHasTabMenu').setStyle({
		height : divHeight
	});
	$('idHasTabMenu').show();
};
//点击查询条件特殊处理
var queryClickSpecial = function(divHeight,divWidth,context){
	$('idHasTabMenu').setStyle({
		width : divWidth
	});	
	queryClick(divHeight, context);
};
//变更查询条件的图标样式
var changeSearchImg = function(context){
	var searchImg = $('myjquerymenu').down('li').down('img');
	var imgSrc = searchImg.src;

	if(imgSrc.endsWith('ico_serach.gif')){
		searchImg.src = context + "/images/ico_searchup.gif";
	}else{
		searchImg.src = context + "/images/ico_serach.gif";
	}	
}