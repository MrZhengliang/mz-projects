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
<link href="<%=path %>/static/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="<%=path %>/static/assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="<%=path %>/static/css/bootstrap-select.css">

<style type="text/css">
.page_c {
	text-align: right;
}

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
<!--[if IE 7]>
		  <link rel="stylesheet" href="<%=path %>/static/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

<!-- page specific plugin styles -->

<!-- fonts -->

<link rel="stylesheet"
	href="<%=path %>/static/assets/css/font-awesome.min.css" />

<!-- ace styles -->

<link rel="stylesheet" href="<%=path %>/static/assets/css/ace.min.css" />
<link rel="stylesheet"
	href="<%=path %>/static/assets/css/ace-rtl.min.css" />
<link rel="stylesheet"
	href="<%=path %>/static/assets/css/ace-skins.min.css" />
<link rel="stylesheet"
	href="<%=path %>/static/assets/css/datepicker.css" />
<!--[if lte IE 8]>
		  <link rel="stylesheet" href="<%=path %>/static/assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->
<style type="text/css">
.span2 {
	width: 120px;
}
</style>
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
									src="<%=path %>/static/assets/avatars/avatar.png"
									class="msg-photo" alt="Alex's Avatar" /> <span
									class="msg-body"> <span class="msg-title"> <span
											class="blue">Alex:</span> 不知道写啥 ...
									</span> <span class="msg-time"> <i class="icon-time"></i> <span>1分钟以前</span>
									</span>
								</span>
							</a></li>

							<li><a href="#"> <img
									src="<%=path %>/static/assets/avatars/avatar3.png"
									class="msg-photo" alt="Susan's Avatar" /> <span
									class="msg-body"> <span class="msg-title"> <span
											class="blue">Susan:</span> 不知道翻译...
									</span> <span class="msg-time"> <i class="icon-time"></i> <span>20分钟以前</span>
									</span>
								</span>
							</a></li>

							<li><a href="#"> <img
									src="<%=path %>/static/assets/avatars/avatar4.png"
									class="msg-photo" alt="Bob's Avatar" /> <span class="msg-body">
										<span class="msg-title"> <span class="blue">Bob:</span>
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
							src="<%=path %>/static/assets/avatars/user.jpg"
							alt="Jason's Photo" /> <span class="user-info"> <small>欢迎光临,</small>
								<%=session.getAttribute("username") %>
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
						<li class="active">用户管理</li>
					</ul>
					<!-- .breadcrumb -->


				</div>

				<div class="page-content">
					<div class="page-header" style="padding: 0 auto; margin: 0 auto;">
						<form id="suserSearchForm" name="suserSearchForm"
							action="<spring:url value='/umanage.do' htmlEscape='true'/>"
							method="post" target="_self">
							
						<i class="icon-hand-right"></i><span>搜索</span> 
						<input type="text" placeholder="输入用户名" class="ui-autocomplete-input" 
								id="search" name="username" value="${username }"
							autocomplete="off" /> 
						<input id="startDate" class="span2"
							type="text" name="startDate" value="${startDate }" placeholder="开始日期" readonly>
						<input id="endDate" class="span2" type="text" name="endDate"
							value="${endDate }" placeholder="结束日期" readonly> 
						<a class="btn btn-xs btn-light" style="height: 28px;" onClick="submitSearchForm()">
							<i class="icon-search" style="color: #6fb3e0 !important;"></i>
						</a>
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
													<th>用户名</th>
													<th>姓名</th>
													<th>角色</th>
													<th>有效性</th>
													<th>添加时间</th>
													<th>上次登录时间</th>
													<th>上次访问IP</th>
													<th>操作</th>
												</tr>
											</thead>

											<tbody>
												<c:forEach items="${sysUserList}" var="sysUser"
													varStatus="status">
													<tr>
														<td>${sysUser.uid}</td>
														<td>${sysUser['username']}</td>
														<td>${sysUser.name}</td>
														<td>${sysUser.roleName}</td>
														<td>
															<c:if test="${sysUser.status == 1}">有效</c:if>
															<c:if test="${sysUser.status == 9}">失效</c:if>
														</td>
														<td>${sysUser.createTime}</td>
														<td>${sysUser.lastLoginTime}</td>
														<td>${sysUser.lastLoginIP}</td>
														<td>														
														<c:if test="${sysUser.status == 1}">
															<a data-toggle="modal" href="#suserEdit"
															onClick="editSuser('${sysUser.createTime}','${sysUser.username}','${sysUser.validTime}','${sysUser.terminalId}','${sysUser.email}','${sysUser.name}','${appUser.status}','${sysUser.uid}','${sysUser.roleId }');"
															class="btn btn-xs btn-primary"><i class="icon-edit"></i></a>
															<a data-toggle="modal" href="#suserDel"
																onClick="delSuser('${sysUser.uid}','${sysUser.username}','${sysUser.roleId }');"
																class="btn btn-xs btn-danger"><i class="icon-trash"></i></a>
														</c:if>
															
														<c:if test="${sysUser.status == 9}">
															<a data-toggle="modal" href="#"
															onClick=""
															class="btn btn-xs btn-gray"><i class="icon-edit"></i></a>
															<a data-toggle="modal" href="#"
																onClick=""
																class="btn btn-xs btn-gray"><i class="icon-trash"></i></a>
														</c:if>
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
							<div
								style="display: inline-block; background-repeat: no-repeat; border-width: 4px; font-size: 13px; line-height: 1.39; padding: 4px 9px; background-color: #307ECC;">
								<a href="#modal-table" role="button"
									style="text-decoration: none; color: #fff; font-family: 'Open Sans';"
									data-toggle="modal">添加</a>
							</div>
							<div class="hr hr-18 dotted hr-double"></div>
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


	</div>
	<!-- /.main-container-inner -->

	<a href="#" id="btn-scroll-up"
		class="btn-scroll-up btn btn-sm btn-inverse"> <i
		class="icon-double-angle-up icon-only bigger-110"></i>
	</a>
	</div>
	<!-- /.main-container -->

<!-- 弹出添加页 -->
<div id="modal-table" class="modal fade" tabindex="-1">
		<div class="modal-dialog" style="width: 420px;">
			<div class="modal-content" style="top: 150px;">
				<div class="modal-header no-padding">
					<div class="table-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true" style="font-size:25px;">
							<span class="white">&times;</span>
						</button>
						<i class="icon-save"></i>&nbsp;用户添加
					</div>
				</div>

				<div class="mzinfo_box_l" style="line-height: 50px;">
					<form id="suserAddForm" name="suserAddForm"
						action="<spring:url value='/suserAdd.do' htmlEscape='true'/>"
						method="post" target="targetFrame">
						<ul class="box_l_h_c">
							<li class="box_l_h_c_li">
								<select id="suRoleId" name="suRoleId"
									style="height:28px;width: 192px; background: none repeat scroll 0 0 #f5f5f5 !important;">
										<option value="0" selected>请选择角色</option>
										<c:forEach items="${roleList}" var="role">
											<option value="${role.id }"
												onclick="setSuRoleId('${role.id }','${role.roleName}');"
											>${role.roleName}</option>
										</c:forEach>
								</select>
							</li>
							<li class="box_l_h_c_li">
								<input id="createDate" class="span3" type="text"
									name="startDate" value="" placeholder="开始日期" readonly>
							</li>
							<li class="box_l_h_c_li"><input name="username" value="" type="text"
									placeholder="输入用户名" class="ui-autocomplete-input span3" id=""
									autocomplete="off" /></li>
							<li class="box_l_h_c_li">
								<input id="validDate" class="span3" type="text"
									name="endDate" value="" placeholder="结束日期" readonly>
							</li>
							
							<li class="box_l_h_c_li">
								<input name="password" id="password" value="" type="password"
									placeholder="输入密码" class="ui-autocomplete-input span3" 
									autocomplete="off" />
							</li>
							
							<li class="box_l_h_c_li">
								<input name="terminalId" id="terminalId" type="text"
									placeholder="输入手机号" class="ui-autocomplete-input span3" 
									autocomplete="off" />
							</li>
							
							<li class="box_l_h_c_li">
								<input name="repassword" id="repassword" value="" type="password"
									placeholder="确认密码" class="ui-autocomplete-input span3" 
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								<input name="email" id="email" type="text"
									placeholder="输入邮箱" class="ui-autocomplete-input span3" 
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								<input name="name" value="" type="text"
									placeholder="输入姓名" class="ui-autocomplete-input span3" id="name"
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								<select id="status"
									style="height:28px;width: 192px; background: none repeat scroll 0 0 #f5f5f5 !important;"
									name="status">
										<option value="0">状态</option>
										<option value="1" selected onclick="setSuStatus('1');">有效</option>
										<option value="9" onclick="setSuStatus('9');">失效</option>
								</select>
							</li>
							<div style="text-align: center;clear:both;">
									<button class="btn btn-sm btn-danger" data-dismiss="modal">
										<i class="icon-remove"></i> 取消
									</button>
									<button type="button" class="btn btn-sm btn-success"
										onClick="submitSuserAddForm();">
										确认 <i class="icon-arrow-right icon-on-right"></i>
									</button>
							</div>
						</ul>
						
					</form>
				</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	
<!-- 弹出修改页 -->
<div id="suserEdit" class="modal fade" tabindex="-1">
		<div class="modal-dialog" style="width: 420px;">
			<div class="modal-content" style="top: 150px;">
				<div class="modal-header no-padding">
					<div class="table-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true" style="font-size:25px;">
							<span class="white">&times;</span>
						</button>
						<i class="icon-save"></i>&nbsp;用户修改
					</div>
				</div>

				<div class="mzinfo_box_l" style="line-height: 50px;">
					<form id="suserEditForm" name="suserEditForm"
						action="<spring:url value='/suserEdit.do' htmlEscape='true'/>"
						method="post" target="targetFrame">
						<input type="hidden" id="uidEdit" name="uid"/>
						<input type="hidden" id="suRoleIdEdit" name="suRoleId"/>
						
						
						<ul class="box_l_h_c">
							<li class="box_l_h_c_li">
								<select id="suRoleIdEdit"
									style="height:28px;width: 192px; background: none repeat scroll 0 0 #f5f5f5 !important;">
										<option value="0" selected>请选择角色</option>
										<c:forEach items="${roleList}" var="role">
											<option value="${role.id }"
												onclick="setSuRoleIdEdit('${role.id }');"	
											>${role.roleName}</option>
										</c:forEach>
								</select>
							</li>
							<input type="hidden" id="roleName" name="roleName" value=""/>
							<li class="box_l_h_c_li">
								<input id="createDateEdit" class="span3" type="text"
									name="startDate" value="" placeholder="开始日期" readonly>
							</li>
							<li class="box_l_h_c_li"><input name="username" value="" type="text"
									placeholder="输入用户名" class="ui-autocomplete-input span3" id="usernameEdit"
									autocomplete="off" /></li>
							<li class="box_l_h_c_li">
								<input id="validDateEdit" class="span3" type="text"
									name="endDate" value="" placeholder="结束日期" readonly>
							</li>
							
							<li class="box_l_h_c_li">
								<input name="terminalId" id="terminalIdEdit" type="text"
									placeholder="输入手机号" class="ui-autocomplete-input span3" 
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								<input name="email" id="emailEdit" type="text"
									placeholder="输入邮箱" class="ui-autocomplete-input span3" 
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								<input name="name" value="" type="text"
									placeholder="输入姓名" class="ui-autocomplete-input span3" id="nameEdit"
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								<select id="statusEdit"
									style="height:28px;width: 192px; background: none repeat scroll 0 0 #f5f5f5 !important;"
									name="status">
										<option value="0">状态</option>
										<option value="1" selected onclick="setSuStatus('1');">有效</option>
										<option value="9" onclick="setSuStatus('9');">失效</option>
								</select>
							</li>
							<div style="text-align: center;clear:both;">
									<button class="btn btn-sm btn-danger" aria-hidden="true" data-dismiss="modal">
										<i class="icon-remove"></i> 取消
									</button>
									<button type="button" class="btn btn-sm btn-success"
										onClick="submitSuserEditForm();">
										确认 <i class="icon-arrow-right icon-on-right"></i>
									</button>
							</div>
						</ul>
					</form>
				</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>	
<!-- 弹出删除页 -->
<div id="suserDel" class="modal fade" tabindex="-1">
		<div class="modal-dialog" style="width: 420px;">
			<div class="modal-content" style="top: 150px;">
				<div class="modal-header no-padding">
					<div class="table-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">
							<span class="white">&times;</span>
						</button>
						<i class="icon-save"></i>&nbsp;用户删除
					</div>
				</div>

				<div class="mzinfo_box_l" style="line-height: 50px;">
					<form id="suserDelForm" name="suserDelForm"
						action="<spring:url value='/suserDel.do' htmlEscape='true'/>"
						method="post" target="targetFrame">
						<input type="hidden" id="uidDel" name="uid"/>
						<input type="hidden" id="suRoleIdDel" name="suRoleId"/>
						<ul class="box_l_h_c">
							<li class="box_l_h_c_li" style="font-size: 14px;line-height: 55px;width:220px;">
								确认要删除该用户[<span id="usernameDel"></span>]吗?
							</li>

							<div style="text-align: center;clear:both;">
									<button class="btn btn-sm btn-danger"
										aria-hidden="true" data-dismiss="modal" type="button">
										<i class="icon-remove"></i> 取消
									</button>
									<button type="button" class="btn btn-sm btn-success"
										onClick="submitSuserDelForm();">
										确认 <i class="icon-arrow-right icon-on-right"></i>
									</button>
							</div>
						</ul>
						
					</form>
				</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
</div>	

<!-- 隐藏iframe -->
<iframe name="targetFrame" style="width: 0%; display: none;"></iframe>

<!-- basic scripts -->
<script type="text/javascript">
//用户信息新增
var submitSuserAddForm = function(){
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
	
	document.getElementById("suserAddForm").submit();
}


//用户信息修改
var editSuser = function(a,b,c,d,e,f,g,h){
	
	//document.getElementById("suRoleIdEdit").value = ;
	document.getElementById("createDateEdit").value = a;
	document.getElementById("usernameEdit").value = b;
	document.getElementById("validDateEdit").value = c;
	document.getElementById("terminalIdEdit").value = d;
	document.getElementById("emailEdit").value = e;
	document.getElementById("nameEdit").value = f;
	document.getElementById("statusEdit").value = g;
	
	document.getElementById("uidEdit").value = h;
	
	document.getElementById("suRoleIdEdit").value = g;
}

//提交用户信息修改
var submitSuserEditForm = function(){
	var roleId = $("#suRoleIdEdit").val();
	if(roleId = null || roleId == 0){
		alert('请选择角色');
		return;
	}
	
	var name = $("#nameEdit").val();
	if(name == ''){
		alert('请输入姓名');
		$("#nameEdit").focus();
		return;
	}
	//邮箱校验
	//邮箱正则
	var emailReg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	var v_email = $("#emailEdit").val();
	if(v_email !=''){
		if(!emailReg.test(v_email)){
			alert('请输入有效的E_mail！');
	        $("#emailEdit").focus();
	        return;
		}
	}else{
		alert('请输入E_mail！');
        $("#emailEdit").focus();
        return;
	}
	
	//手机号校验
	var v_ter = $("#terminalIdEdit").val();
	if(v_ter==""||v_ter.length<11){
		alert("请输入正确的手机号码!");
		$("#terminalIdEdit").focus();
		return;
	}
	
	document.getElementById("suserEditForm").submit();
}


//删除用户信息设置
var delSuser = function(uid,username,uRoleId){
	document.getElementById("suRoleIdDel").value = uRoleId;
	document.getElementById("uidDel").value = uid;
	document.getElementById("usernameDel").innerHTML = username;
}
//提交用户删除
var submitSuserDelForm = function(){
	document.getElementById("suserDelForm").submit();
}


</script>
	
	
	<script type="text/javascript">
			window.jQuery || document.write("<script src='<%=path %>/static/assets/js/jquery-2.0.3.min.js'>"+"<"+"script>");
		</script>

	<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='<%=path %>/static/assets/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
		</script>
	<script src="<%=path %>/static/assets/js/bootstrap.min.js"></script>
	<script src="<%=path %>/static/assets/js/typeahead-bs2.min.js"></script>

	<!-- page specific plugin scripts -->

	<!--[if lte IE 8]>
		  <script src="<%=path %>/static/assets/js/excanvas.min.js"></script>
		<![endif]-->

	<script
		src="<%=path %>/static/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="<%=path %>/static/assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="<%=path %>/static/assets/js/jquery.slimscroll.min.js"></script>
	<script src="<%=path %>/static/assets/js/jquery.easy-pie-chart.min.js"></script>
	<script src="<%=path %>/static/assets/js/jquery.sparkline.min.js"></script>


	<!-- ace scripts -->

	<script src="<%=path %>/static/assets/js/ace-elements.min.js"></script>
	<script src="<%=path %>/static/assets/js/ace.min.js"></script>
	<script
		src="<%=path %>/static/assets/js/date-time/bootstrap-datepicker.js"></script>

<script type="text/javascript"	src="<%=path %>/static/js/bootstrap-select.js"></script>
	<!-- inline scripts related to this page -->

<script type="text/javascript">
		$('#startDate').datepicker({format:"yyyy-mm-dd"});
		$('#endDate').datepicker({format:"yyyy-mm-dd"});
		$('#createDate').datepicker({format:"yyyy-mm-dd"});
		$('#validDate').datepicker({format:"yyyy-mm-dd"});
		$('#createDateEdit').datepicker({format:"yyyy-mm-dd"});
		$('#validDateEdit').datepicker({format:"yyyy-mm-dd"});
		
		//提交搜索
		var setSuRoleId = function(suRoleId,roleName){
			document.getElementById("suRoleId").value=suRoleId;
			document.getElementById("roleName").value=roleName;
		}
		var setSuStatus = function(suStatus){
			document.getElementById("status").value=suStatus;
		}
		var submitSearchForm = function(){
			document.getElementById("suserSearchForm").submit();
		}
		
		
		//修改设置角色id
		var setSuRoleIdEdit = function(suRoleId){
			document.getElementById("suRoleIdEdit").value=suRoleId;
		}
</script>
<script type="text/javascript">
     $(window).on('load', function () {

         $('.selectpicker').selectpicker({
             'selectedText': 'cat'
         });

     })
</script>
</body>
</html>

