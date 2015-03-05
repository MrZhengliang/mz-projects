﻿<%@page import="com.sh.manage.constants.SessionConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8" />
<title>控制台-漫展信息管理</title>
<meta name="keywords" content="Bootstrap模版" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- 引入js -->
<jsp:include page="../static/js/js_inc.jsp"></jsp:include>

<!-- basic styles -->
<link href="<%=path %>/static/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="<%=path %>/static/assets/css/font-awesome.min.css" />

<!-- fonts -->

<link rel="stylesheet"
	href="<%=path %>/static/assets/css/fonts.googleapis.css" />

<!-- ace styles -->
<link rel="stylesheet" href="<%=path %>/static/assets/css/chosen.css" />
<link rel="stylesheet" href="<%=path %>/static/assets/css/ace.min.css" />
<link rel="stylesheet"
	href="<%=path %>/static/assets/css/ace-rtl.min.css" />
<link rel="stylesheet"
	href="<%=path %>/static/assets/css/ace-skins.min.css" />

<link rel="stylesheet" href="<%=path %>/static/css/bootstrap-select.css">

<link rel="stylesheet" href="<%=path %>/static/css/datepicker.css">

<style type="text/css">
.span2 {
	width: 120px;
}

.span3 {
	width: 191px;
}

.chosen-container-single .chosen-single {
	border-radius: 0;
	color: #939192;
}

.box_l_h_c {
	margin:0 0;
	width: 398px;
	background-color: #EFEFEF;
	border-radius: 3px;
	overflow: hidden;
}

.mzinfo_box_l ul .box_l_h_c_li {
	margin-left: 6px;
	margin-right: 10px;
	width: 180px;
	float: left;
	line-height: 22px;
	list-style-type: none;
}

</style>
<!--[if lte IE 8]>
		  <link rel="stylesheet" href="<%=path %>/static/assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->
<style type="text/css">
.page_c {
	text-align: right;
}
</style>
<!-- ace settings handler -->
<script src="<%=path %>/static/assets/js/ace-extra.min.js"></script>
</head>

<body>
	<div class="navbar navbar-default" id="navbar">
		<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="#" class="navbar-brand"> <small> <i
						class="icon-leaf"></i> H5后台管理系统
				</small>
				</a>
				<!-- /.brand -->
			</div>
			<!-- /.navbar-header -->

			<div class="navbar-header pull-right" role="navigation">
				<ul class="nav ace-nav">
					

					<li class="light-blue"><a data-toggle="dropdown" href="#"
						class="dropdown-toggle"> <img class="nav-user-photo"
							src="<%=path %>/static/assets/avatars/user.jpg"
							alt="Jason's Photo" /> <span class="user-info"> <small>欢迎光临,</small>
								<%=session.getAttribute("usercode") %>
						</span> <i class="icon-caret-down"></i>
					</a>

						<ul
							class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li><a href="#"> <i class="icon-cog"></i> 设置
							</a></li>

							<li><a href="#"> <i class="icon-user"></i> 个人资料
							</a></li>

							<li class="divider"></li>

							<li><a href="#"> <i class="icon-off"></i> 退出
							</a></li>
						</ul></li>
				</ul>
				<!-- /.ace-nav -->
			</div>
			<!-- /.navbar-header -->
		</div>
		<!-- /.container -->
	</div>

	<div class="main-container" id="main-container">
		<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
			</a>

			<div class="sidebar" id="sidebar">
				<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<button class="btn btn-success">
							<i class="icon-signal"></i>
						</button>

						<button class="btn btn-info">
							<i class="icon-pencil"></i>
						</button>

						<button class="btn btn-warning">
							<i class="icon-group"></i>
						</button>

						<button class="btn btn-danger">
							<i class="icon-cogs"></i>
						</button>
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span> <span class="btn btn-info"></span>

						<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
					</div>
				</div>
				<!-- #sidebar-shortcuts -->

				<%@include file="../main/left.jsp" %>
				<!-- /.nav-list -->

				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="icon-double-angle-left"
						data-icon1="icon-double-angle-left"
						data-icon2="icon-double-angle-right"></i>
				</div>

				<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
			</div>

			<div class="main-content">
				<div class="main_box">
		<div class="main_box_A">
			<div class="left emptyDiv"></div>
			<h1 class="mz_title">发布漫展</h1>
			<form name="mzForm" id="mzForm" class="mz_form left" method="post">
				<input type="hidden" id="userId" name="userId" value="<{$_SESSION['userid']}>"/>
				<div class="left block_n">
					<div class="left block_info">
						 为了保护展方利益，发布后请联系cos450工作人员确认您的展方身份，验证通过后漫展页面正式对外公布。
						<br/>
						cos405媒体合作QQ：
						<span class="blue">XXX</span>
						    媒体合作邮箱：
						<span class="blue">XXX@qq.com</span>
					</div>
					<div class="left block_info_2">
						 请填写您的联系方式（至少一项），让我们的工作人员可以联系到您。<br/>
						<p class="left labelC" style="width:100px;">电话：</p>
						<input class="contact_phone" type="text"  name="contact_phone"><br/>
						<p class="left labelC" style="width:100px;">QQ：</p>
						<input class="contact_qq mr20" type="text" name="contact_qq"><br/>
						<p class="left labelC" style="width:100px;">邮箱：</p>
						<input class="contact_email" type="text" name="contact_email">
					</div>
				</div>
				<h2 class="mz_title2 blue">漫展基本信息</h2>

				<div class="left block_n block_d">
					<div class="left labelC img_div">
						<input type="hidden" value="" name="picture">
						<div class="upload_div">
							<div id="uploadgfs_hint" class="upload_div">
								<div id="gif" class="post_gif" style="top:0"></div>

								<div id="upload_preview" class="upload_div">
									图片预览：
									<div id="divFileProgressContainer">
										<ul id="pic_list" style="margin: 5px;"></ul>
										<div style="clear: both;"></div>
									</div>
									<!-- 需要js控制展示 -->
									<!--div id="prev_64740" class="prev_a left labelC" draggable="true" mid="64740">
										<div class="width100 labelC">
											<img class="prev" alt="" src="http://img5.bcyimg.com/party/expo/picture/f/541adae567533.png/w230" onload="updateH()">
										</div>
										<a href="javascript:void(0)" onclick="delOneTmpPic('#gfs_pic_ids','64740')">删除该图片</a>
									</div-->
								</div>

								<div class="upload_tag">
									<label class="left mgr5" for="etime">上传漫展封面</label>
									<div id="pic_upload" class="upload_btn_cs">
										<div id="pic_upload_button" class="upload_Button">
											<span id="spanButtonPlaceHolder"></span>
										</div>
									</div>

									<input type="hidden" name="faceImg" id="faceImg" value=""/>
								</div>
							</div>
						</div>
					</div>
					<div></div>

					<div class="lh24" style="margin-left:354px;">
						<input type="hidden" name="cid" value="${article.cid }">
						<div class="lwf mb10">
							<div class="left " style="width:120px;">漫展名称：<span class="red">*</span></div>
							<div class="left">
								<input class="" style="width:370px;" name="title" id="title" type="text" value="">
							</div>
						</div>

						<div class="lwf mb10">
							<div class="left " style="width:120px;">个性域名：</div>
							<div class="" style="margin-left:120px;"> http://www.cos450.com/mz/<input class="short-url" name="url" id="url" type="text" value=""></div>
						</div>

						<div class="lwf mb10">
							<div class="left" style="width:120px;">我的位置：<span class="red">*</span></div>
							<div class="left location"><span><a id="mylocation" href="javascript:void(0);" onclick="getMyLocation();">获取我的位置</a></span></div>
						</div>

						<div class="lwf mb10">
							<div class="left" style="width:120px;">城市：<span class="red">*</span>
						</div>
						<div class="left">
							<div class="left"> <input class="" style="width:100px;" name="city" id="city" type="text" value="" disabled> </div>

							<input type="hidden" name="cityname" id="cityname" value=""/>
							<input type="hidden" name="address" id="address" value=""/>
							<input type="hidden" name="lng" id="lng" value=""/>
							<input type="hidden" name="lat" id="lat" value=""/>
						</div>
						</div>
						<div class="lwf mb10">
							<div class="left " style="width:120px;">详细地址：<span class="red">*</span></div>
							<div class="left"> <input class="" style="width:370px;" name="show-address" id="show-address" type="text" value="" disabled> </div>
						</div>

						<div class="lwf mb10">
							<div class="left" style="width:120px;">开始时间：</div>
							<div class="left mr20">
								<input type="text" id="startDate" name="startDate" style="width:120px;" value=""/>
				          		<input type="hidden" name="startTime" id="startTime" value="${startDate}"/>
							</div>
						</div>

						<div class="lwf mb10"> <div class="left" style="width:120px;">结束时间：</div>
							<div class="left">
								<input type="text" id="endDate" name="endDate"  style="width:120px;" value=""/>
				          		<input type="hidden" name="endTime" id="endTime" value="${endDate}" />
				          	</div>
						</div>

						<div class="lwf mb10"> <div class="left" style="width:120px;">票价：</div>
						<div class="left mr20">
								<select name="fee_opt" id="fee_opt" onchange="selectFee(this);">
								<option value="1">免费</option>
								<option value="2">收费</option>
								</select>
						</div>

						<div id="price-control" class="left" style="display:none"> <input style="margin-left:10px;width:50px;" class="left mr" name="price" id="price" type="text" value="" />元 </div>

						</div>
						<div class="lwf mb10">
						<div class="left" style="width:120px;">订票方式：</div>
						<div class="left"> <input class="" style="width:370px;" name="ticket" id="ticket" type="text" value=""> </div> </div>
						<div class="lwf mb10"> <div class="left" style="width:120px;">网络售票地址：</div>
						<div class="" style="margin-left:120px;"> <input class="" style="width:370px;" name="net_sell" id="net_sell" type="text" value="">
						<p class="lwf">注：若不填写则不会显示</p> </div> </div>

						<div class="lwf"> <div class="left" style="width:120px;">漫展简介：<span class="red">*</span></div>
						<div class="left"> <textarea class="" style="width:370px; height:300px;" name="content" id="content" type="content" rows="5"></textarea>
						</div> </div> <div class="lwf">注：带<span class="red">*</span>号为必填项目</div> </div>
						<input class="btn_big mt30" style="" type="button" id="publish_handle" value="提交" />
						<input type="hidden" name="__hash__" value="6eb3965b43fe47e4a29ecb81cdfc88ef" />
				</div>
			</form>

		</div>
	</div>
				<!-- /.page-content -->
			</div>
			<!-- /.page-content -->
		</div>
		<!-- /.main-content -->
	</div>

	<script src="<%=path %>/static/assets/js/bootstrap.min.js"></script>
	<script src="<%=path %>/static/assets/js/typeahead-bs2.min.js"></script>
	<!-- page specific plugin scripts -->

	<script src="<%=path %>/static/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="<%=path %>/static/assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="<%=path %>/static/assets/js/jquery.slimscroll.min.js"></script>
	<script src="<%=path %>/static/assets/js/jquery.easy-pie-chart.min.js"></script>
	<script src="<%=path %>/static/assets/js/jquery.sparkline.min.js"></script>
	<script src="<%=path %>/static/assets/js/flot/jquery.flot.min.js"></script>
	<script src="<%=path %>/static/assets/js/flot/jquery.flot.pie.min.js"></script>
	<script src="<%=path %>/static/assets/js/flot/jquery.flot.resize.min.js"></script>
	<script src="<%=path %>/static/js/chosen.jquery.min.js"></script>
	<!-- ace scripts -->

	<script src="<%=path %>/static/assets/js/ace-elements.min.js"></script>
	<script src="<%=path %>/static/assets/js/ace.min.js"></script>


<script type="text/javascript"	src="<%=path %>/static/js/date/bootstrap-datetimepicker.js"></script>

<script type="text/javascript"	src="<%=path %>/static/js/zdialog/zDialog.js"></script>
<script type="text/javascript"	src="<%=path %>/static/js/zdialog/zDrag.js"></script>




	
	<iframe name="targetFrame" style="width: 0%; display: none;"></iframe>
<script type="text/javascript">
				
				//提交搜索
				var setAuRoleId = function(auRoleId){
					document.getElementById("auRoleId").value=auRoleId;
				}
				var setAuStatus = function(auStatus){
					document.getElementById("status").value=auStatus;
				}
				var submitSearchForm = function(){
					document.getElementById("auserSearchForm").submit();
				}
</script>
<script type="text/javascript">
//会员信息新增
var submitAuserAddForm = function(){
	var username = $("#username").val();
	var name = $("#name").val();
	if(username == '' || name == ''){
		alert('请输入用户名和姓名');
		$("input[type='text'][name='username']").focus();
		return;
	}
	//密码确认校验
	var pwd = $("#password").val();
	var rePwd = $("#repassword").val();
	if(pwd != rePwd ){
		alert('两次输入密码不一致,请确认');
		$("input[type='text'][name='password']").focus();
		return;
	}
	if(pwd == '' || rePwd ==''){
		alert('请输入密码和确认密码');
		$("input[type='text'][name='password']").focus();
		return;
	}
	//年限数字校验
	var rey = /^[1-9]+[0-9]*]*$/;  
	var v_limitYear = $("#limitYear").val();
    if (!rey.test(v_limitYear)){  
        alert("开通年限请输入正整数");  
        $("input[type='text'][name='limitYear']").focus();
        return; 
    }
    if(v_limitYear<0 || v_limitYear >100){
    	alert("开通年限为0-100");  
        $("input[type='text'][name='limitYear']").focus();
        return; 
    }
	//邮箱校验
	//邮箱正则
	var emailReg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	var v_email = $("#email").val();
	if(v_email !=''){
		if(!emailReg.test(v_email)){
			alert('请输入有效的E_mail！');
	        $("input[type='text'][name='email']").focus();
	        return;
		}
	}else{
		alert('请输入E_mail！');
        $("input[type='text'][name='email']").focus();
        return;
	}
	
	//手机号校验
	var v_ter = $("#terminalId").val();
	if(v_ter==""||v_ter.length<11){
		alert("请输入正确的手机号码!");
		$("input[type='text'][name='terminalId']").focus();
		return;
	}
	
	document.getElementById("auserAddForm").submit();
}

</script>
<script type="text/javascript">
       $(window).on('load', function () {

           $('.selectpicker').selectpicker({
               'selectedText': 'cat'
           });

       })
</script>
<script>
	$('#startDate').datetimepicker({format:'yyyy-mm-dd hh:ii:ss',language: 'ch',autoclose:'true'});
  	$('#endDate').datetimepicker({format:'yyyy-mm-dd hh:ii:ss',language: 'ch',autoclose:'true'});

 	
  	function open20()
  	{
  		var diag = new Dialog();
  		diag.Width = 600;
  		diag.Height = 300;
  		diag.Title = "新建站点";
  		diag.URL = "bigform.html";
  		diag.OKEvent = function(){Dialog.alert("点击确定可以提交表单");diag.close();};
  		diag.MessageTitle = "大表单";
  		diag.Message = '如果表单比较大需要用户拖动滚动条，建议表单分步填写';
  		diag.show();
  	}
 </script>
</body>
</html>

