<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8" />
<title>HTML5 - Bootstrap管理后台</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- basic styles -->
<link href="../static/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="../static/css/font-awesome.min.css" />
<link rel="stylesheet" href="../static/assets/css/font-awesome.min.css" />
<!-- ace styles -->
<link rel="stylesheet" href="../static/css/ace.min.css" />
<link rel="stylesheet" href="../static/css/ace-rtl.min.css" />

<link rel="stylesheet" href="../static/css/tip-yellowsimple.css" />

<style type="text/css">
.border,.rain {
	
}
/* Layout with mask */
.rain {
	padding: 10px 12px 12px 10px;
	-moz-box-shadow: 10px 10px 10px rgba(0, 0, 0, 1) inset, -9px -9px 8px
		rgba(0, 0, 0, 1) inset;
	-webkit-box-shadow: 8px 8px 8px rgba(0, 0, 0, 1) inset, -9px -9px 8px
		rgba(0, 0, 0, 1) inset;
	box-shadow: 8px 8px 8px rgba(0, 0, 0, 1) inset, -9px -9px 8px
		rgba(0, 0, 0, 1) inset;
	margin: 80px auto;
}
/* Artifical "border" to clear border to bypass mask */
.border {
	padding: 1px;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
}

.border,.rain,.border.start,.rain.start {
	background-repeat: repeat-x, repeat-x, repeat-x, repeat-x;
	background-position: 0 0, 0 0, 0 0, 0 0;
	/* Starting Color */
	background-color: #f7f7f7;/*#39f;*/
	/* Just do something for IE-suck */
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#00BA1B',
		endColorstr='#00BA1B', GradientType=1);
}

/* Non-keyframe fallback animation */
.border.end,.rain.end {
	-moz-transition-property: background-position;
	-moz-transition-duration: 30s;
	-moz-transition-timing-function: linear;
	-webkit-transition-property: background-position;
	-webkit-transition-duration: 30s;
	-webkit-transition-timing-function: linear;
	-o-transition-property: background-position;
	-o-transition-duration: 30s;
	-o-transition-timing-function: linear;
	transition-property: background-position;
	transition-duration: 30s;
	transition-timing-function: linear;
	background-position: -5400px 0, -4600px 0, -3800px 0, -3000px 0;
}

/* Keyfram-licious animation */
@
-webkit-keyframes colors { 0% {
	background-color: #39f;
}

15%
{
background-color
:
 
#F246C9
;
}
30%
{
background-color
:
 
#4453F2
;
}
45%
{
background-color
:
 
#44F262
;
}
60%
{
background-color
:
 
#F257D4
;
}
75%
{
background-color
:
 
#EDF255
;
}
90%
{
background-color
:
 
#F20006
;
}
100%
{
background-color
:
 
#39f
;
}
}
.border,.rain {
	-webkit-animation-direction: normal;
	-webkit-animation-duration: 20s;
	-webkit-animation-iteration-count: infinite;
	-webkit-animation-name: colors;
	-webkit-animation-timing-function: ease;
}

/* In-Active State Style */
.border.unfocus {
	background: #fff !important;
	-moz-box-shadow: 0px 0px 15px rgba(255, 255, 255, .2);
	-webkit-box-shadow: 0px 0px 15px rgba(255, 255, 255, .2);
	box-shadow: 0px 0px 15px rgba(255, 255, 255, .2);
	-webkit-animation-name: none;
}

.rain.unfocus {
	background: #000 !important;
	-webkit-animation-name: none;
}

.margin120 {
	margin: 120px auto;
}

.emp_ipt {
	display: none;
}
</style>

</head>
<body class="login-layout" style="margin: 0;padding: 0;">
	<div class="login-container margin120 position-relative">
			<div id="login-box"
				class="login-box visible widget-box no-border border start">
				<div class="widget-main">
					<h4 class="header blue lighter bigger">
						<i class="icon-coffee green"></i> 管理员登陆
					</h4>
					<form id="loginForm" name="loginForm" method="post">
						<fieldset>
							<label class="block clearfix" style="margin-bottom: 0px;"> 
								<div id="empname" class="tip-yellowsimple" style="transform: scale(1, 1) translate(0px);visibility: hidden;opacity: 1;">
											<div class="tip-inner tip-bg-image">请输入用户名</div>
											<div class="tip-arrow tip-arrow-top tip-arrow-right tip-arrow-bottom tip-arrow-left" style="visibility: inherit;"></div>
								</div>
							<span class="block input-icon input-icon-right"> <input
									type="text" required="" class="form-control"
									placeholder="Username" id="usercode" name="usercode" title="请输入用户名" /> <i
									class="icon-user"></i>						
							</span>
							</label>
							<label class="block clearfix" style="margin-bottom: 0px;">
								<div id="emppwd" class="tip-yellowsimple" style="transform: scale(1, 1) translate(0px);visibility: hidden;opacity: 1;">
										<div class="tip-inner tip-bg-image">请输入密码</div>
										<div class="tip-arrow tip-arrow-top tip-arrow-right tip-arrow-bottom tip-arrow-left" style="visibility: inherit;"></div>
								</div>
								<span class="block input-icon input-icon-right"> 
								<input type="password" required="" class="form-control"
									placeholder="Password" id="password" name="password" title="请输入密码"/> <i
									class="icon-lock"></i>
								
								</span>
							</label>
<!-- 							<div class="space"></div>
 -->
							<div class="clearfix">
								<div id="emprand" class="tip-yellowsimple" style="opacity: 1;transform: scale(1, 1) translate(0px);visibility: hidden;">
									<div class="tip-inner tip-bg-image">请输入验证码</div>
									<div class="tip-arrow tip-arrow-left" style="visibility: inherit;"></div>
								</div>
								<label class="inline" > 
								<input type="text"
									id="rand" name="rand" class="txt" maxlength="4" tabindex="2"
									AUTOCOMPLETE="off" id="rand" value=""
									style="margin-right: 5px; width: 66px;" title="请输入验证码"/> 
									<img style="cursor: pointer;" width="58" id="imgCode" height="21" onclick="changeImg();"/>
								
								</label>
								<button type="button"
									class="width-35 pull-right btn btn-sm btn-primary"
									onclick="dologin();">
									<i class="icon-key"></i> 登陆
								</button>
							
							</div>

							<div class="space-4"></div>
						</fieldset>
					</form>
				</div>
				<!-- /widget-body -->
			</div>
			<!-- /position-relative -->
	</div>
	<!-- /.col -->
	
<!-- 提示区 -->


<!-- 引入js -->

<script type="text/javascript" lang="javascript" src="<%=path %>/static/js/jquery.js"></script>
<script type="text/javascript" lang="javascript" src="<%=path %>/static/js/jquery.mobile.custom.min.js"></script>
<script type="text/javascript" lang="javascript" src="<%=path %>/static/js/jquery.poshytip.js"></script>

<!-- inline scripts related to this page -->
<script type="text/javascript" lang="javascript">
/* 	var $$ = jQuery.noConflict();
 */			

 
 			
</script>


<script type="text/javascript" lang="javascript">
//body onload事件处理
$(function(){
	/**
	初始化数据
	*/
	$('#imgCode').attr("title","点击重新获得验证码!");
	$('#imgCode').attr("src","<spring:url value='/authImage' htmlEscape='true'/>");
});

function changeImg(){
	//修改为可以点击图片切换验证码
	document.getElementById("imgCode").setAttribute("src","<spring:url value='/authImage' htmlEscape='true'/>?"+new Date().getTime());
}
</script>




<script type="text/javascript" src="<%=path %>/static/js/common/common.js" ></script>
<script type="text/javascript">
//定义异常信息数组
var arrTips = [
'正在登陆...', //0
'您需要登录后才能继续浏览或操作！', //1
'请输入用户账号！', //2
'请输入密码!', //3
'请输入验证码!', //4
'验证码输入错误!', //5
'账号或密码不正确!请重新输入!', //6
'账号或密码不正确!请重新输入!', //7
'账号已经被锁定，请联系管理员!', //8
'账号已注销，请联系管理员!', //9
'IP异常登录!', //10
'您的帐户已过有效期!', //11
'你的密码超过30天未修改，已经被锁定！', //12
'对不起，你的输入数据格式不合法！', //13
'', //14
'对不起，您的密码输错五次，已经被锁定！', //15
'对不起，您的商户信息未找到！', //16
'对不起，您商户的合同已到期！', //17
'对不起，请确认来源地址是否正确！' //18

];




//登陆
var dologin = function(){
	var usercode = document.getElementById("usercode").value;
	var password = document.getElementById("password").value;
	var rand = document.getElementById("rand").value;
	if(usercode == '' || usercode == null){
		$('#empname').css({'visibility':'inherit'}).fadeIn('slow');
		return;
	}
	if(password == '' || password == null){
		$('#emppwd').css({'visibility':'inherit'}).fadeIn('slow');
		return;
	}
	if(rand == '' || rand == null){
		$('#emprand').css({'visibility':'inherit'}).fadeIn('slow');
		return;
	}
	
	//document.getElementById("loginForm").action="<spring:url value='/system/user_login.do' htmlEscape='true'/>";
	//document.getElementById("loginForm").submit();
	//ajax请求后台，处理
	jQuery.ajax({
		url: "<spring:url value="/system/user_login.do" htmlEscape="true" />",
		method:"post",
		data:{usercode:usercode,password:password,rand:rand},
		success: function(data){
			var result = eval('(' + data + ')');
			//alert(result.msg);
			if(result.data == '0'){
				window.location='<%=path %>/system/index';
			}else{
				alert(arrTips[result.data]);
			}
	     /* var span_new = document.getElementById(spanName);	
		 span_new.style.display = "none";
		 span_new.innerHTML = ""; */
	   }
	});
}

	//隐藏提示
	$('#usercode').focus(function(){
		$('#empname').css({'visibility':'hidden'});
	});
	$('#password').focus(function(){
		$('#emppwd').css({'visibility':'hidden'});
	});
	$('#rand').focus(function(){
		$('#emprand').css({'visibility':'hidden'});
	});

	/*回车事件*/
$("input").keydown(function(e){
	if(e.which == 13){
		dologin();	
	}	
});
</script>
</body>
</html>
