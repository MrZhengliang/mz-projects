﻿<%@page import="com.sh.manage.constants.SessionConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8" />
<title>控制台-Bootstrap后台管理系统</title>
<meta name="keywords" content="Bootstrap模版" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- 引入js -->
<jsp:include page="../static/js/js_inc.jsp"></jsp:include>

<!-- basic styles -->
<link href="<%=path %>/static/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=path %>/static/assets/css/font-awesome.min.css" />

<!--[if IE 7]>
		  <link rel="stylesheet" href="<%=path %>/static/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

<!-- page specific plugin styles -->
<style type="text/css">
.page_c {
	text-align: right;
}
</style>
<!-- fonts -->
<link rel="stylesheet" href="<%=path %>/static/assets/css/font-awesome.min.css" />
<!-- ace styles -->

<link rel="stylesheet" href="<%=path %>/static/assets/css/ace.min.css" />
<link rel="stylesheet" href="<%=path %>/static/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="<%=path %>/static/assets/css/ace-skins.min.css" />

<style type="text/css">
input[type=checkbox].ace.ace-switch.ace-switch-5+.lbl::before {
	content: "OK\a0\a0\a0\a0\a0\a0\a0\a0\a0\a0NO"
}
</style>
<!--[if lte IE 8]>
		  <link rel="stylesheet" href="<%=path %>/static/assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->

<script src="<%=path %>/static/assets/js/ace-extra.min.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lt IE 9]>
		<script src="<%=path %>/static/assets/js/html5shiv.js"></script>
		<script src="<%=path %>/static/assets/js/respond.min.js"></script>
		<![endif]-->
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
					<li class="grey"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <i class="icon-tasks"></i> <span
							class="badge badge-grey">4</span>
					</a>

						<ul
							class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
							<li class="dropdown-header"><i class="icon-ok"></i> 还有4个任务完成
							</li>

							<li><a href="#">
									<div class="clearfix">
										<span class="pull-left">软件更新</span> <span class="pull-right">65%</span>
									</div>

									<div class="progress progress-mini ">
										<div style="width: 65%" class="progress-bar "></div>
									</div>
							</a></li>

							<li><a href="#">
									<div class="clearfix">
										<span class="pull-left">硬件更新</span> <span class="pull-right">35%</span>
									</div>

									<div class="progress progress-mini ">
										<div style="width: 35%"
											class="progress-bar progress-bar-danger"></div>
									</div>
							</a></li>

							<li><a href="#">
									<div class="clearfix">
										<span class="pull-left">单元测试</span> <span class="pull-right">15%</span>
									</div>

									<div class="progress progress-mini ">
										<div style="width: 15%"
											class="progress-bar progress-bar-warning"></div>
									</div>
							</a></li>

							<li><a href="#">
									<div class="clearfix">
										<span class="pull-left">错误修复</span> <span class="pull-right">90%</span>
									</div>

									<div class="progress progress-mini progress-striped active">
										<div style="width: 90%"
											class="progress-bar progress-bar-success"></div>
									</div>
							</a></li>

							<li><a href="#"> 查看任务详情 <i class="icon-arrow-right"></i>
							</a></li>
						</ul></li>

					<li class="purple"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <i
							class="icon-bell-alt icon-animated-bell"></i> <span
							class="badge badge-important">8</span>
					</a>

						<ul
							class="pull-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
							<li class="dropdown-header"><i class="icon-warning-sign"></i>
								8条通知</li>

							<li><a href="#">
									<div class="clearfix">
										<span class="pull-left"> <i
											class="btn btn-xs no-hover btn-pink icon-comment"></i> 新闻评论
										</span> <span class="pull-right badge badge-info">+12</span>
									</div>
							</a></li>

							<li><a href="#"> <i
									class="btn btn-xs btn-primary icon-user"></i> 切换为编辑登录..
							</a></li>

							<li><a href="#">
									<div class="clearfix">
										<span class="pull-left"> <i
											class="btn btn-xs no-hover btn-success icon-shopping-cart"></i>
											新订单
										</span> <span class="pull-right badge badge-success">+8</span>
									</div>
							</a></li>

							<li><a href="#">
									<div class="clearfix">
										<span class="pull-left"> <i
											class="btn btn-xs no-hover btn-info icon-twitter"></i> 粉丝
										</span> <span class="pull-right badge badge-info">+11</span>
									</div>
							</a></li>

							<li><a href="#"> 查看所有通知 <i class="icon-arrow-right"></i>
							</a></li>
						</ul></li>

					<li class="green"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <i
							class="icon-envelope icon-animated-vertical"></i> <span
							class="badge badge-success">5</span>
					</a>

						<ul
							class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
							<li class="dropdown-header"><i class="icon-envelope-alt"></i>
								5条消息</li>

							<li><a href="#"> <img
									src="<%=path %>/static/assets/avatars/avatar.png" class="msg-photo"
									alt="Alex's Avatar" /> <span class="msg-body"> <span
										class="msg-title"> <span class="blue">Alex:</span>
											不知道写啥 ...
									</span> <span class="msg-time"> <i class="icon-time"></i> <span>1分钟以前</span>
									</span>
								</span>
							</a></li>

							<li><a href="#"> <img
									src="<%=path %>/static/assets/avatars/avatar3.png" class="msg-photo"
									alt="Susan's Avatar" /> <span class="msg-body"> <span
										class="msg-title"> <span class="blue">Susan:</span>
											不知道翻译...
									</span> <span class="msg-time"> <i class="icon-time"></i> <span>20分钟以前</span>
									</span>
								</span>
							</a></li>

							<li><a href="#"> <img
									src="<%=path %>/static/assets/avatars/avatar4.png" class="msg-photo"
									alt="Bob's Avatar" /> <span class="msg-body"> <span
										class="msg-title"> <span class="blue">Bob:</span>
											到底是不是英文 ...
									</span> <span class="msg-time"> <i class="icon-time"></i> <span>下午3:15</span>
									</span>
								</span>
							</a></li>

							<li><a href="inbox.html"> 查看所有消息 <i
									class="icon-arrow-right"></i>
							</a></li>
						</ul></li>

					<li class="light-blue"><a data-toggle="dropdown" href="#"
						class="dropdown-toggle"> <img class="nav-user-photo"
							src="<%=path %>/static/assets/avatars/user.jpg" alt="Jason's Photo" /> <span
							class="user-info"> <small>欢迎光临,</small> <%=session.getAttribute("username") %>
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
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

					<ul class="breadcrumb">
						<li><i class="icon-home home-icon"></i> <a href="#">系统管理</a>
						</li>
						<li>权限组管理</li>
					</ul>
					<!-- .breadcrumb -->

				</div>

				<div class="page-content">
					<div class="page-header">
						<button class="btn btn-success btn-sm tooltip-success">添加</button>
						<c:forEach items="${groupList}" varStatus="index" var="group">
							<button class="btn btn-sm 
								<c:choose>
									<c:when test="${group.id == groupIndex}">
									btn-yellow
									</c:when>
									<c:otherwise>
									gray
									</c:otherwise>
								</c:choose>" onClick="goExtGroup(${group.id},'${group.groupName}')">
								<i class="normal-icon icon-user gray"></i>${group.groupName}
							</button>
						</c:forEach>
					</div>
					<div style="margin: 6px; margin-bottom: 10px;">
						<span style="margin-left: 6px;">当前组:${gName}</span>
						
						<!-- <button class="btn btn-minier btn-purple"><i class="icon-pencil"></i>菜单设置</button> -->
					</div>
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->

							<div class="row">
								<div class="col-xs-12">
									<div class="table-responsive">
										<table id="sample-table-1"
											class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th class="center">序号</th>
													<th>角色</th>
													<th class="header-color-orange">提醒</th>
													<th style="background-color: #E0AAB7 !important;">任务</th>
													<th>增加</th>
													<th>删除</th>
													<th>修改</th>
													<th>删除</th>
													<th>操作</th>
												</tr>
											</thead>

											<tbody>
												<c:forEach items="${groupRoles}" varStatus="status" var="gRoles">
													<tr>			
														<td>${status.index+1}</td>
														<td>${gRoles[1]['roleName']}</td>
														<td><input type="checkbox" class="ace ace-switch " checked="checked" id="id-button-borders"><span class="lbl"></span></td>
														<td><input type="checkbox" class="ace ace-switch " checked="checked" id="id-button-borders"><span class="lbl"></span></td>
														<td><input type="checkbox" class="ace ace-switch ace-switch-6" checked="checked" id="id-button-borders"><span class="lbl"></span></td>
														<td><input type="checkbox" class="ace ace-switch ace-switch-6" checked="checked" id="id-button-borders"><span class="lbl"></span></td>
														<td><input type="checkbox" class="ace ace-switch ace-switch-6" checked="checked" id="id-button-borders"><span class="lbl"></span></td>
														<td><input type="checkbox" class="ace ace-switch ace-switch-6" checked="checked" id="id-button-borders"><span class="lbl"></span></td>
														<td>
															<a data-toggle="modal" href="#roleEdit" onClick="editRole('${gRoles[1]['roleName']}','${gRoles[1]['id']}');" class="btn btn-xs btn-primary"><i class="icon-edit"></i></a>
														<a data-toggle="modal" href="#roleDel"  onClick="delRole('${gRoles[1]['roleName']}','${gRoles[1]['id']}');" class="btn btn-xs btn-danger"><i class="icon-trash"></i></a>
													</td>
													</tr>
												</c:forEach>
												<c:if test="${page.totalRowNum>0}">
													<c:if test="${page.totalRowNum >= pageSize}">
														<tr class="page_c">
															<td colspan="9">${page.display}</td>
														</tr>
													</c:if>
												</c:if>
											</tbody>
										</table>
									</div>
									<!-- /.table-responsive -->
								</div>
								<!-- /span -->
							</div>
							<!-- /row -->
							<!-- <button class="btn btn-success btn-sm tooltip-success" onclick="addRole('1');">添加</button> -->
							<div style="display:inline-block;background-repeat: no-repeat;
							border-width: 4px;font-size: 13px;line-height: 1.39;padding: 4px 9px;background-color:#307ECC; ">
								<a href="#modal-table" role="button" style="text-decoration: none;color: #fff;font-family: 'Open Sans';"
									data-toggle="modal" >添加角色</a>
							</div>
 
							<div class="hr hr-18 dotted hr-double"></div>

							<!-- 弹出添加页 -->
							<div id="modal-table" class="modal fade" tabindex="-1">
								<div class="modal-dialog" style="width:400px;">
									<div class="modal-content" style="top: 170px;">
										<div class="modal-header no-padding">
											<div class="table-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">
													<span class="white">&times;</span>
												</button>
												<i class="icon-save"></i>&nbsp;角色添加
											</div>
										</div>

										<div style="padding-left:10px;line-height:50px;">
													<form id="roleAddForm" name="roleAddForm" action="<spring:url value='/roleAddExt.do' htmlEscape='true'/>" method="post" target="targetFrame">
														<!-- <legend>Form</legend> -->
														<fieldset>
															<label>当前组织:</label>
															${groupRoles[0][0]['groupName']}
															<input type="hidden" name="groupId" value="${groupRoles[0][0]['id']}">
															<input type="hidden" id='gIndex' name="groupIndex" value="${groupIndex }"/>
														</fieldset>
														<fieldset>
															<label>角色名称:</label>
															<input id="roleName" type="text" name="roleName" placeholder="这里输入角色名称." />
														</fieldset>
														<div style="text-align:center;">
															<button class="btn btn-sm btn-danger" aria-hidden="true" data-dismiss="modal" type="button">
																<i class="icon-remove"></i> 取消
															</button>
															<button type="button" class="btn btn-sm btn-success" onClick="submitRoleAddForm();">
																确认
																<i class="icon-arrow-right icon-on-right"></i>
															</button>
														</div>
													</form>
										</div>

									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
							<!-- PAGE CONTENT ENDS -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
			<!-- /.page-content -->
		</div>
		<!-- /.main-content -->

		
		<!-- /#ace-settings-container -->
	</div>
	<!-- /.main-container-inner -->

	<a href="#" id="btn-scroll-up"
		class="btn-scroll-up btn btn-sm btn-inverse"> <i
		class="icon-double-angle-up icon-only bigger-110"></i>
	</a>
	</div>
	<!-- 角色编辑 -->
<div id="roleEdit" class="modal fade" tabindex="-1">
		<div class="modal-dialog" style="width:400px;">
			<div class="modal-content" style="top: 170px;">
				<div class="modal-header no-padding">
					<div class="table-header">
						<a class="close" data-dismiss="modal" style="font-size:25px;">×</a>
						<i class="icon-save"></i>&nbsp;角色编辑
					</div>
				</div>

				<div style="padding-left:10px;line-height:50px;">
							<form id="roleEditForm" name="roleEditForm" action="<spring:url value='/roleEditExt.do' htmlEscape='true'/>" method="post" target="targetFrame">
								<!-- <legend>Form</legend> -->
								<fieldset>
									<label>当前组织:</label>
									${groupRoles[0][0]['groupName']}
									<input type="hidden" name="groupId" value="${groupRoles[0][0]['id']}">
									<input type="hidden" id="eRoleId" name="roleId" value="">
									<input type="hidden" id='gIndex' name="groupIndex" value="${groupIndex }"/>
								</fieldset>
								<fieldset>
									<label>角色名称:</label>
									<input type="text" id="eRoleName" name="roleName" placeholder="这里输入角色名称." />
								</fieldset>
								<div style="text-align:center;">
									<button class="btn btn-sm btn-danger" aria-hidden="true" data-dismiss="modal" type="button">
										<i class="icon-remove"></i> 取消
									</button>
									<button type="button" class="btn btn-sm btn-success" onClick="submitRoleEditForm();">
										确认
										<i class="icon-arrow-right icon-on-right"></i>
									</button>
								</div>
							</form>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>

<!-- 角色删除 -->
<div id="roleDel" class="modal fade" tabindex="-1">
		<div class="modal-dialog" style="width:400px;">
			<div class="modal-content" style="top: 170px;">
				<div class="modal-header no-padding">
					<div class="table-header">
						<a class="close" data-dismiss="modal" style="font-size:25px;">×</a>
						<i class="icon-save"></i>&nbsp;角色删除
					</div>
				</div>

				<div style="padding-left:10px;line-height:50px;">
							<form id="roleDelForm" name="roleDelForm" action="<spring:url value='/roleDelExt.do' htmlEscape='true'/>" method="post" target="targetFrame">
								<!-- <legend>Form</legend> -->
								<fieldset>
									<input type="hidden" id='gIndex' name="groupIndex" value="${groupIndex }"/>
									<input type="hidden" name="groupId" value="${groupRoles[0][0]['id']}">
									<input type="hidden" id="dRoleId" name="roleId" value="">
									<input type="hidden" id="dRoleName" name="roleName" value="">
									确认是否删除该角色[<span id="drName"></span>]
								</fieldset>
								<div style="text-align:center;">
									<button class="btn btn-sm btn-danger" aria-hidden="true" data-dismiss="modal" type="button">
										<i class="icon-remove"></i> 取消
									</button>
									<button type="button" class="btn btn-sm btn-success" onClick="submitRoleDelForm();">
										确认
										<i class="icon-arrow-right icon-on-right"></i>
									</button>
								</div>
							</form>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>


<form name="opForm" id="opForm" action="<spring:url value="/gmanageExt.do" htmlEscape="true" />" method="post" target="_self">
	<input type="hidden" id="ggIndex" name="gIndex" value=""/>
	<input type="hidden" id="gName" name="gName" />
</form>


<!-- 菜单编辑form -->
<form name="opMenuForm" id="opMenuForm" action="<spring:url value="/gMenuEdit.do" htmlEscape="true" />" method="post" target="targetFrame">
	<input type="hidden" id='groupId' name="groupId" value="${groupIndex}"/>
	<!-- menuStr 格式为1,3,4,由后台处理 -->
	<input type="hidden" id='menuStr' name="menuStr" />
</form>
	<!--[if !IE]> -->

	<script type="text/javascript">
			window.jQuery || document.write("<script src='<%=path %>/static/assets/js/jquery-2.0.3.min.js'>"+"<"+"script>");
		</script>

	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='<%=path %>/static/assets/js/jquery-1.10.2.min.js'>"+"<"+"script>");
</script>
<![endif]-->

	<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='<%=path %>/static/assets/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
		</script>
	<script src="<%=path %>/static/assets/js/bootstrap.min.js"></script>
	<script src="<%=path %>/static/assets/js/typeahead-bs2.min.js"></script>

	<!-- page specific plugin scripts -->

	<!--[if lte IE 8]>
		  <script src="<%=path %>/static/assets/js/excanvas.min.js"></script>
		<![endif]-->

	<script src="<%=path %>/static/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="<%=path %>/static/assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="<%=path %>/static/assets/js/jquery.slimscroll.min.js"></script>
	<script src="<%=path %>/static/assets/js/jquery.easy-pie-chart.min.js"></script>
	<script src="<%=path %>/static/assets/js/jquery.sparkline.min.js"></script>
	<script src="<%=path %>/static/assets/js/flot/jquery.flot.min.js"></script>
	<script src="<%=path %>/static/assets/js/flot/jquery.flot.pie.min.js"></script>
	<script src="<%=path %>/static/assets/js/flot/jquery.flot.resize.min.js"></script>

	<!-- ace scripts -->

	<script src="<%=path %>/static/assets/js/ace-elements.min.js"></script>
	<script src="<%=path %>/static/assets/js/ace.min.js"></script>



	<script type="text/javascript">
		/* var addRole = function(gId){
			alert(gId);
			$('#modal-table').css('display','block');
		} */
		
		//其他组跳转
		var goExtGroup = function(gIndex,gName){
			
			document.getElementById("ggIndex").value = gIndex;
			document.getElementById("gName").value = gName;
			document.getElementById("opForm").action="<spring:url value='/gmanageExt.do' htmlEscape='true'/>";
			document.getElementById("opForm").submit();
		}
		
		//提交角色添加
		var submitRoleAddForm = function(){
			
			var roleName = document.getElementById("roleName").value;
			if(roleName == null || roleName == ''){
				alert('请填写角色名称');
				return;
			}
			document.getElementById("roleAddForm").submit();
		}
		
		//修改赋值给弹出层
		var editRole = function(roleName,roleId){
			//alert(roleName);
			document.getElementById("eRoleName").value = roleName;
			document.getElementById("eRoleId").value = roleId;
			
		}
		
		//提交角色修改
		var submitRoleEditForm = function(){
			
			var roleName = document.getElementById("eRoleName").value;
			if(roleName == null || roleName == ''){
				alert('请填写角色名称');
				return;
			}
			document.getElementById("roleEditForm").submit();
		}
		
		//删除角色赋值
		var delRole = function(roleName,roleId){
			//alert(roleName);
			document.getElementById("dRoleName").value = roleName;
			document.getElementById("dRoleId").value = roleId;
			document.getElementById("drName").innerHTML = roleName;
		}
		//提交角色删除
		var submitRoleDelForm = function(){
			document.getElementById("roleDelForm").submit();
		}
	</script>
	<!-- inline scripts related to this page -->

	<script type="text/javascript">
			jQuery(function($) {
				$('.easy-pie-chart.percentage').each(function(){
					var $box = $(this).closest('.infobox');
					var barColor = $(this).data('color') || (!$box.hasClass('infobox-dark') ? $box.css('color') : 'rgba(255,255,255,0.95)');
					var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)' : '#E2E2E2';
					var size = parseInt($(this).data('size')) || 50;
					$(this).easyPieChart({
						barColor: barColor,
						trackColor: trackColor,
						scaleColor: false,
						lineCap: 'butt',
						lineWidth: parseInt(size/10),
						animate: /msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase()) ? false : 1000,
						size: size
					});
				})
			
				$('.sparkline').each(function(){
					var $box = $(this).closest('.infobox');
					var barColor = !$box.hasClass('infobox-dark') ? $box.css('color') : '#FFF';
					$(this).sparkline('html', {tagValuesAttribute:'data-values', type: 'bar', barColor: barColor , chartRangeMin:$(this).data('min') || 0} );
				});
			
			
			
			
			  var placeholder = $('#piechart-placeholder').css({'width':'90%' , 'min-height':'150px'});
			  var data = [
				{ label: "social networks",  data: 38.7, color: "#68BC31"},
				{ label: "search engines",  data: 24.5, color: "#2091CF"},
				{ label: "ad campaigns",  data: 8.2, color: "#AF4E96"},
				{ label: "direct traffic",  data: 18.6, color: "#DA5430"},
				{ label: "other",  data: 10, color: "#FEE074"}
			  ]
			  function drawPieChart(placeholder, data, position) {
			 	  $.plot(placeholder, data, {
					series: {
						pie: {
							show: true,
							tilt:0.8,
							highlight: {
								opacity: 0.25
							},
							stroke: {
								color: '#fff',
								width: 2
							},
							startAngle: 2
						}
					},
					legend: {
						show: true,
						position: position || "ne", 
						labelBoxBorderColor: null,
						margin:[-30,15]
					}
					,
					grid: {
						hoverable: true,
						clickable: true
					}
				 })
			 }
			 drawPieChart(placeholder, data);
			
			 /**
			 we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically
			 so that's not needed actually.
			 */
			 placeholder.data('chart', data);
			 placeholder.data('draw', drawPieChart);
			
			
			
			  var $tooltip = $("<div class='tooltip top in'><div class='tooltip-inner'></div></div>").hide().appendTo('body');
			  var previousPoint = null;
			
			  placeholder.on('plothover', function (event, pos, item) {
				if(item) {
					if (previousPoint != item.seriesIndex) {
						previousPoint = item.seriesIndex;
						var tip = item.series['label'] + " : " + item.series['percent']+'%';
						$tooltip.show().children(0).text(tip);
					}
					$tooltip.css({top:pos.pageY + 10, left:pos.pageX + 10});
				} else {
					$tooltip.hide();
					previousPoint = null;
				}
				
			 });
			
			
			
			
			
			
				var d1 = [];
				for (var i = 0; i < Math.PI * 2; i += 0.5) {
					d1.push([i, Math.sin(i)]);
				}
			
				var d2 = [];
				for (var i = 0; i < Math.PI * 2; i += 0.5) {
					d2.push([i, Math.cos(i)]);
				}
			
				var d3 = [];
				for (var i = 0; i < Math.PI * 2; i += 0.2) {
					d3.push([i, Math.tan(i)]);
				}
				
			
				var sales_charts = $('#sales-charts').css({'width':'100%' , 'height':'220px'});
				$.plot("#sales-charts", [
					{ label: "Domains", data: d1 },
					{ label: "Hosting", data: d2 },
					{ label: "Services", data: d3 }
				], {
					hoverable: true,
					shadowSize: 0,
					series: {
						lines: { show: true },
						points: { show: true }
					},
					xaxis: {
						tickLength: 0
					},
					yaxis: {
						ticks: 10,
						min: -2,
						max: 2,
						tickDecimals: 3
					},
					grid: {
						backgroundColor: { colors: [ "#fff", "#fff" ] },
						borderWidth: 1,
						borderColor:'#555'
					}
				});
			
			
				$('#recent-box [data-rel="tooltip"]').tooltip({placement: tooltip_placement});
				function tooltip_placement(context, source) {
					var $source = $(source);
					var $parent = $source.closest('.tab-content')
					var off1 = $parent.offset();
					var w1 = $parent.width();
			
					var off2 = $source.offset();
					var w2 = $source.width();
			
					if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
					return 'left';
				}
			
			
				$('.dialogs,.comments').slimScroll({
					height: '300px'
			    });
				
				
				//Android's default browser somehow is confused when tapping on label which will lead to dragging the task
				//so disable dragging when clicking on label
				var agent = navigator.userAgent.toLowerCase();
				if("ontouchstart" in document && /applewebkit/.test(agent) && /android/.test(agent))
				  $('#tasks').on('touchstart', function(e){
					var li = $(e.target).closest('#tasks li');
					if(li.length == 0)return;
					var label = li.find('label.inline').get(0);
					if(label == e.target || $.contains(label, e.target)) e.stopImmediatePropagation() ;
				});
			
				$('#tasks').sortable({
					opacity:0.8,
					revert:true,
					forceHelperSize:true,
					placeholder: 'draggable-placeholder',
					forcePlaceholderSize:true,
					tolerance:'pointer',
					stop: function( event, ui ) {//just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
						$(ui.item).css('z-index', 'auto');
					}
					}
				);
				$('#tasks').disableSelection();
				$('#tasks input:checkbox').removeAttr('checked').on('click', function(){
					if(this.checked) $(this).closest('li').addClass('selected');
					else $(this).closest('li').removeClass('selected');
				});
				
			
				
				
				
			})
		</script>
<iframe name="targetFrame" style="width:0%;display: none;"></iframe>

</body>
</html>

