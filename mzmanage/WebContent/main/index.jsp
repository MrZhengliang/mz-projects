﻿<%@page import="com.sh.manage.constants.SessionConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/include.jsp"%>
<html lang="zh-CN">
	<head>
		<meta charset="utf-8" />
		<title>控制台-Bootstrap后台管理系统</title>
		<meta name="keywords" content="Bootstrap模版" />
		<meta name="description" content="" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<!-- basic styles -->
		<link href="<%=path %>/static/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="<%=path %>/static/assets/css/font-awesome.min.css" />

		<!--[if IE 7]>
		  <link rel="stylesheet" href="<%=path %>/static/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!-- page specific plugin styles -->

		<!-- fonts -->

<link rel="stylesheet" href="<%=path %>/static/assets/css/font-awesome.min.css" />
		<!-- ace styles -->

		<link rel="stylesheet" href="<%=path %>/static/assets/css/ace.min.css" />
		<link rel="stylesheet" href="<%=path %>/static/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="<%=path %>/static/assets/css/ace-skins.min.css" />

		<link rel="stylesheet" href="<%=path %>/static/css/zTreeStyle/zTreeStyle.css" />
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
					<a href="#" class="navbar-brand">
						<small>
							<i class="icon-leaf"></i>
							H5后台管理系统
						</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->

				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="grey">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="icon-tasks"></i>
								<span class="badge badge-grey">4</span>
							</a>

							<ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="icon-ok"></i>
									还有4个任务完成
								</li>

								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">软件更新</span>
											<span class="pull-right">65%</span>
										</div>

										<div class="progress progress-mini ">
											<div style="width:65%" class="progress-bar "></div>
										</div>
									</a>
								</li>

								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">硬件更新</span>
											<span class="pull-right">35%</span>
										</div>

										<div class="progress progress-mini ">
											<div style="width:35%" class="progress-bar progress-bar-danger"></div>
										</div>
									</a>
								</li>

								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">单元测试</span>
											<span class="pull-right">15%</span>
										</div>

										<div class="progress progress-mini ">
											<div style="width:15%" class="progress-bar progress-bar-warning"></div>
										</div>
									</a>
								</li>

								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">错误修复</span>
											<span class="pull-right">90%</span>
										</div>

										<div class="progress progress-mini progress-striped active">
											<div style="width:90%" class="progress-bar progress-bar-success"></div>
										</div>
									</a>
								</li>

								<li>
									<a href="#">
										查看任务详情
										<i class="icon-arrow-right"></i>
									</a>
								</li>
							</ul>
						</li>

						<li class="purple">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="icon-bell-alt icon-animated-bell"></i>
								<span class="badge badge-important">8</span>
							</a>

							<ul class="pull-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="icon-warning-sign"></i>
									8条通知
								</li>

								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-pink icon-comment"></i>
												新闻评论
											</span>
											<span class="pull-right badge badge-info">+12</span>
										</div>
									</a>
								</li>

								<li>
									<a href="#">
										<i class="btn btn-xs btn-primary icon-user"></i>
										切换为编辑登录..
									</a>
								</li>

								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-success icon-shopping-cart"></i>
												新订单
											</span>
											<span class="pull-right badge badge-success">+8</span>
										</div>
									</a>
								</li>

								<li>
									<a href="#">
										<div class="clearfix">
											<span class="pull-left">
												<i class="btn btn-xs no-hover btn-info icon-twitter"></i>
												粉丝
											</span>
											<span class="pull-right badge badge-info">+11</span>
										</div>
									</a>
								</li>

								<li>
									<a href="#">
										查看所有通知
										<i class="icon-arrow-right"></i>
									</a>
								</li>
							</ul>
						</li>

						<li class="green">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="icon-envelope icon-animated-vertical"></i>
								<span class="badge badge-success">5</span>
							</a>

							<ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="icon-envelope-alt"></i>
									5条消息
								</li>

								<li>
									<a href="#">
										<img src="<%=path %>/static/assets/avatars/avatar.png" class="msg-photo" alt="Alex's Avatar" />
										<span class="msg-body">
											<span class="msg-title">
												<span class="blue">Alex:</span>
												不知道写啥 ...
											</span>

											<span class="msg-time">
												<i class="icon-time"></i>
												<span>1分钟以前</span>
											</span>
										</span>
									</a>
								</li>

								<li>
									<a href="#">
										<img src="<%=path %>/static/assets/avatars/avatar3.png" class="msg-photo" alt="Susan's Avatar" />
										<span class="msg-body">
											<span class="msg-title">
												<span class="blue">Susan:</span>
												不知道翻译...
											</span>

											<span class="msg-time">
												<i class="icon-time"></i>
												<span>20分钟以前</span>
											</span>
										</span>
									</a>
								</li>

								<li>
									<a href="#">
										<img src="<%=path %>/static/assets/avatars/avatar4.png" class="msg-photo" alt="Bob's Avatar" />
										<span class="msg-body">
											<span class="msg-title">
												<span class="blue">Bob:</span>
												到底是不是英文 ...
											</span>

											<span class="msg-time">
												<i class="icon-time"></i>
												<span>下午3:15</span>
											</span>
										</span>
									</a>
								</li>

								<li>
									<a href="inbox.html">
										查看所有消息
										<i class="icon-arrow-right"></i>
									</a>
								</li>
							</ul>
						</li>

						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="<%=path %>/static/assets/avatars/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>欢迎光临,</small>
									<%=session.getAttribute("usercode") %>
								</span>

								<i class="icon-caret-down"></i>
							</a>

							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="icon-cog"></i>
										设置
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-user"></i>
										个人资料
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="<%=path%>/system/user_logout.do">
										<i class="icon-off"></i>
										退出
									</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.ace-nav -->
				</div><!-- /.navbar-header -->
			</div><!-- /.container -->
		</div>

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
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
							<span class="btn btn-success"></span>

							<span class="btn btn-info"></span>

							<span class="btn btn-warning"></span>

							<span class="btn btn-danger"></span>
						</div>
					</div><!-- #sidebar-shortcuts -->

					<%@include file="left.jsp" %>
					
					<div>
						
					</div>
					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
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
							<li>
								<i class="icon-home home-icon"></i>
								<a href="#">首页</a>
							</li>
							<li class="active">控制台</li>
						</ul><!-- .breadcrumb -->

						
					</div>

					<div class="page-content">
						<h3>欢迎<%=session.getAttribute("usercode") %>登陆管理系统，现在您可以维护本平台下您拥有的功能了!</h3>
					</div><!-- /.page-content -->
				</div><!-- /.main-content -->

			</div><!-- /.main-container-inner -->

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->



		<div id="tree" class="ztree" style="height:100%;clear: both;left: 200px;position: relative;"></div>
		<!-- basic scripts -->

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

		<script src="<%=path %>/static/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="<%=path %>/static/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="<%=path %>/static/assets/js/jquery.slimscroll.min.js"></script>
		<script src="<%=path %>/static/assets/js/jquery.easy-pie-chart.min.js"></script>
		<script src="<%=path %>/static/assets/js/jquery.sparkline.min.js"></script>


		<!-- ace scripts -->

		<script src="<%=path %>/static/assets/js/ace-elements.min.js"></script>
		<script src="<%=path %>/static/assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->

		
		
		<script src="<%=path %>/static/js/ztree/jquery.ztree.core-3.5.min.js"></script>
		<script src="<%=path %>/static/js/ztree/jquery.ztree.excheck-3.5.min.js"></script>
		<script src="<%=path %>/static/js/ztree/jquery.ztree.exedit-3.5.js"></script>
		<script src="<%=path %>/static/js/ztree/jquery.ztree.exhide-3.5.js"></script>
		
		<script type="text/javascript">
		var setting = {
							};

		var zNodes =[{ name:"父节点1 - 展开", open:true,
		 				children: [
		 					{ name:"父节点11 - 折叠",
		 						children: [
		 							{ name:"叶子节点111"},
		 							{ name:"叶子节点112"},
		 							{ name:"叶子节点113"},
		 							{ name:"叶子节点114"}
		 						]},
		 					{ name:"父节点12 - 折叠",
		 						children: [
		 							{ name:"叶子节点121"},
		 							{ name:"叶子节点122"},
		 							{ name:"叶子节点123"},
		 							{ name:"叶子节点124"}
		 						]},
		 					{ name:"父节点13 - 没有子节点", isParent:true}
		 				]},
		 			{ name:"父节点2 - 折叠",
		 				children: [
		 					{ name:"父节点21 - 展开", open:true,
		 						children: [
		 							{ name:"叶子节点211"},
		 							{ name:"叶子节点212"},
		 							{ name:"叶子节点213"},
		 							{ name:"叶子节点214"}
		 						]},
		 					{ name:"父节点22 - 折叠",
		 						children: [
		 							{ name:"叶子节点221"},
		 							{ name:"叶子节点222"},
		 							{ name:"叶子节点223"},
		 							{ name:"叶子节点224"}
		 						]},
		 					{ name:"父节点23 - 折叠",
		 						children: [
		 							{ name:"叶子节点231"},
		 							{ name:"叶子节点232"},
		 							{ name:"叶子节点233"},
		 							{ name:"叶子节点234"}
		 						]}
		 				]},
		 			{ name:"父节点3 - 没有子节点", isParent:true}

		 		];
			//var zTree;
			//var treeNodes;
			$(document).ready(function(){
				$.fn.zTree.init($("#tree"), setting, <%=session.getAttribute("ztreeNodes") %>);
			});
			/* $(function(){
				$.ajax({
					async : false,
					cache:false,
					type: 'POST',
					dataType : "json",
					url: root+"/ospm/loginInfo/doGetPrivilegeTree.action",//请求的action路径
					error: function () {//请求失败处理函数
						alert('请求失败');
					},
					success:function(data){ //请求成功后处理函数。  
						alert(data);
						treeNodes = data;   //把后台封装好的简单Json格式赋给treeNodes
					}
				});

				zTree = $("#tree").zTree(setting, ztreeNodes);
			}); */
		</script>
</body>
</html>

