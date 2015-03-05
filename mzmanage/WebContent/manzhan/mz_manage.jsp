<%@page import="com.sh.manage.constants.SessionConstants"%>
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
	line-height: 30px;
	list-style-type: none;
}

</style>

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
						<li><i class="icon-home home-icon"></i> <a href="#">信息管理</a>
						</li>
						<li class="active">漫展管理</li>
					</ul>
					<!-- .breadcrumb -->


				</div>

				<div class="page-content">
					<div class="page-header">
						<form id="auserSearchForm" name="auserSearchForm"
							action="<spring:url value='/aumanage.do' htmlEscape='true'/>"
							method="post" target="_self">
							<i class="icon-hand-right"></i><span>搜索</span> 
							<input name="title" value="${title }" type="text"
								placeholder="输入漫展名" class="ui-autocomplete-input" id="search" autocomplete="off" />
							<input id="startDate" class="span2"
								type="text" name="startDate" value="${startDate }"
								placeholder="开始日期" readonly> 
							<input id="endDate" class="span2" type="text" name="endDate" value="${endDate }"
								placeholder="结束日期" readonly> 
							<select id="auRoleId" name="auRoleId"
								style="height: 33px; width: 120px; background: none repeat scroll 0 0 #f5f5f5 !important;"
								class="chosen-select" id="form-field-select-3" data-placeholder="选择票价方式">
								<option value="1">免费</option>
								<option value="2">收费 </option>
							</select> 
							<select id="status"
								style="height: 33px; width: 80px; background: none repeat scroll 0 0 #f5f5f5 !important;"
								class="chosen-select" id="form-field-select-3" name="status"
								data-placeholder="">
								<option value="0" selected>待审核</option>
								<option value="1" onclick="setAuStatus('1');" <c:if test="${status == 1}">selected</c:if>>已上线</option>
								<option value="9" onclick="setAuStatus('9');" <c:if test="${status == 9}">selected</c:if>>已下线</option>
							</select>
							 <a class="btn btn-xs btn-light" style="height: 28px;"
								onClick="submitSearchForm()"><i class="icon-search"
								style="color: #6fb3e0 !important;"></i></a>
						</form>
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
													<th>漫展标题
													</th>
													<th>举办地</th>
													<th>联系电话</th>
													<!-- <th>QQ</th> -->
													<th>邮箱</th>
													
													<th>开始时间</th>
													<th>结束时间</th>
													<th>漫展来源</th>
													<th>状态</th>
													<th>操作</th>
												</tr>
											</thead>

											<tbody>
												<c:forEach items="${articleContentList}" var="article"
													varStatus="status">
													<tr>
														<td>${article.cid}</td>
														<td>
															<a href="<%=path%>/mzinfo.do?cid=${article.cid}" target="_self">
																${article.title}
															</a>
														</td>
														<td>${article.cityname}</td>
														<td>${article.telephone}</td>
														<%-- <td>${article.qqcode}</td> --%>
														<td>${article.email}</td>
														
														<td>${article.starttime}</td>
														<td>${article.closetime}</td>
														<td>
															<c:if test="${article.idtype == 1}">系统人员</c:if>
															<c:if test="${article.idtype == 2}">网站会员</c:if>
														</td>
														<td>
															<c:if test="${article.status == 0}">待审核</c:if>
															<c:if test="${article.status == 1}">已上线</c:if>
															<c:if test="${article.status == 9}">已下线</c:if>
														</td>
														<td>
															<a data-toggle="modal" href="<%=path %>/toEditMz.do?cid=${article.cid}" 
																href="_self" class="btn btn-xs btn-primary"><i class="icon-edit"></i></a>
															<a data-toggle="modal" href="<%=path %>/toDelMz.do?cid=${article.cid}" 
																href="_self" class="btn btn-xs btn-danger"><i class="icon-trash"></i></a>
														</td>
													</tr>
												</c:forEach>

												<c:if test="${page.totalRowNum>0}">
													<c:if test="${page.totalRowNum >= pageSize}">
														<tr class="page_c">
															<td colspan="10">${page.display}</td>
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
								<a href="<%=path %>/toAddMz.do?uid=${uid}"
									style="text-decoration: none; color: #fff; font-family: 'Open Sans';" target="_self">
									<i class="icon-plus"></i>
									添加</a>
								
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


	<script type="text/javascript">
			window.jQuery || document.write("<script src='<%=path %>/static/assets/js/jquery-2.0.3.min.js'>"+"<"+"script>");
		</script>

	<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='<%=path %>/static/assets/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
		</script>
	<script src="<%=path %>/static/assets/js/bootstrap.min.js"></script>
	<script src="<%=path %>/static/assets/js/typeahead-bs2.min.js"></script>

	<!-- page specific plugin scripts -->

	<script
		src="<%=path %>/static/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="<%=path %>/static/assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="<%=path %>/static/assets/js/jquery.slimscroll.min.js"></script>
	<script src="<%=path %>/static/assets/js/jquery.easy-pie-chart.min.js"></script>
	<script src="<%=path %>/static/assets/js/jquery.sparkline.min.js"></script>
	<script src="<%=path %>/static/assets/js/flot/jquery.flot.min.js"></script>
	<script src="<%=path %>/static/assets/js/flot/jquery.flot.pie.min.js"></script>
	<script
		src="<%=path %>/static/assets/js/flot/jquery.flot.resize.min.js"></script>
	<script src="<%=path %>/static/js/chosen.jquery.min.js"></script>
	<!-- ace scripts -->

	<script src="<%=path %>/static/assets/js/ace-elements.min.js"></script>
	<script src="<%=path %>/static/assets/js/ace.min.js"></script>



<script type="text/javascript"	src="<%=path %>/static/js/zdialog/zDialog.js"></script>
<script type="text/javascript"	src="<%=path %>/static/js/zdialog/zDrag.js"></script>
<script type="text/javascript">
			jQuery(function($) {
				$('#id-disable-check').on('click', function() {
					var inp = $('#form-input-readonly').get(0);
					if(inp.hasAttribute('disabled')) {
						inp.setAttribute('readonly' , 'true');
						inp.removeAttribute('disabled');
						inp.value="This text field is readonly!";
					}
					else {
						inp.setAttribute('disabled' , 'disabled');
						inp.removeAttribute('readonly');
						inp.value="This text field is disabled!";
					}
				});
			
			
				$(".chosen-select").chosen(); 
				$('#chosen-multiple-style').on('click', function(e){
					var target = $(e.target).find('input[type=radio]');
					var which = parseInt(target.val());
					if(which == 2) $('#form-field-select-4').addClass('tag-input-style');
					 else $('#form-field-select-4').removeClass('tag-input-style');
				});
			
			
				$('[data-rel=tooltip]').tooltip({container:'body'});
				$('[data-rel=popover]').popover({container:'body'});
				
				$( "#input-size-slider" ).css('width','200px').slider({
					value:1,
					range: "min",
					min: 1,
					max: 8,
					step: 1,
					slide: function( event, ui ) {
						var sizing = ['', 'input-sm', 'input-lg', 'input-mini', 'input-small', 'input-medium', 'input-large', 'input-xlarge', 'input-xxlarge'];
						var val = parseInt(ui.value);
						$('#form-field-4').attr('class', sizing[val]).val('.'+sizing[val]);
					}
				});
			
				$( "#input-span-slider" ).slider({
					value:1,
					range: "min",
					min: 1,
					max: 12,
					step: 1,
					slide: function( event, ui ) {
						var val = parseInt(ui.value);
						$('#form-field-5').attr('class', 'col-xs-'+val).val('.col-xs-'+val);
					}
				});
				
				
				$( "#slider-range" ).css('height','200px').slider({
					orientation: "vertical",
					range: true,
					min: 0,
					max: 100,
					values: [ 17, 67 ],
					slide: function( event, ui ) {
						var val = ui.values[$(ui.handle).index()-1]+"";
			
						if(! ui.handle.firstChild ) {
							$(ui.handle).append("<div class='tooltip right in' style='display:none;left:16px;top:-6px;'><div class='tooltip-arrow'></div><div class='tooltip-inner'></div></div>");
						}
						$(ui.handle.firstChild).show().children().eq(1).text(val);
					}
				}).find('a').on('blur', function(){
					$(this.firstChild).hide();
				});
				
				$( "#slider-range-max" ).slider({
					range: "max",
					min: 1,
					max: 10,
					value: 2
				});
				
				$( "#eq > span" ).css({width:'90%', 'float':'left', margin:'15px'}).each(function() {
					// read initial values from markup and remove that
					var value = parseInt( $( this ).text(), 10 );
					$( this ).empty().slider({
						value: value,
						range: "min",
						animate: true
						
					});
				});
			
				$('#id-input-file-1 , #id-input-file-2').ace_file_input({
					no_file:'No File ...',
					btn_choose:'Choose',
					btn_change:'Change',
					droppable:false,
					onchange:null,
					thumbnail:false //| true | large
					//whitelist:'gif|png|jpg|jpeg'
					//blacklist:'exe|php'
					//onchange:''
					//
				});
				
				$('#id-input-file-3').ace_file_input({
					style:'well',
					btn_choose:'Drop files here or click to choose',
					btn_change:null,
					no_icon:'icon-cloud-upload',
					droppable:true,
					thumbnail:'small'//large | fit
					//,icon_remove:null//set null, to hide remove/reset button
					
					,
					preview_error : function(filename, error_code) {
						
					}
			
				}).on('change', function(){
					//console.log($(this).data('ace_input_files'));
					//console.log($(this).data('ace_input_method'));
				});
				
			
				//dynamically change allowed formats by changing before_change callback function
				$('#id-file-format').removeAttr('checked').on('change', function() {
					var before_change
					var btn_choose
					var no_icon
					if(this.checked) {
						btn_choose = "Drop images here or click to choose";
						no_icon = "icon-picture";
						before_change = function(files, dropped) {
							var allowed_files = [];
							for(var i = 0 ; i < files.length; i++) {
								var file = files[i];
								if(typeof file === "string") {
									//IE8 and browsers that don't support File Object
									if(! (/\.(jpe?g|png|gif|bmp)$/i).test(file) ) return false;
								}
								else {
									var type = $.trim(file.type);
									if( ( type.length > 0 && ! (/^image\/(jpe?g|png|gif|bmp)$/i).test(type) )
											|| ( type.length == 0 && ! (/\.(jpe?g|png|gif|bmp)$/i).test(file.name) )//for android's default browser which gives an empty string for file.type
										) continue;//not an image so don't keep this file
								}
								
								allowed_files.push(file);
							}
							if(allowed_files.length == 0) return false;
			
							return allowed_files;
						}
					}
					else {
						btn_choose = "Drop files here or click to choose";
						no_icon = "icon-cloud-upload";
						before_change = function(files, dropped) {
							return files;
						}
					}
					var file_input = $('#id-input-file-3');
					file_input.ace_file_input('update_settings', {'before_change':before_change, 'btn_choose': btn_choose, 'no_icon':no_icon})
					file_input.ace_file_input('reset_input');
				});
			
				$('#spinner1').ace_spinner({value:0,min:0,max:200,step:10, btn_up_class:'btn-info' , btn_down_class:'btn-info'})
				.on('change', function(){
					//alert(this.value)
				});
				$('#spinner2').ace_spinner({value:0,min:0,max:10000,step:100, touch_spinner: true, icon_up:'icon-caret-up', icon_down:'icon-caret-down'});
				$('#spinner3').ace_spinner({value:0,min:-100,max:100,step:10, on_sides: true, icon_up:'icon-plus smaller-75', icon_down:'icon-minus smaller-75', btn_up_class:'btn-success' , btn_down_class:'btn-danger'});
			
				/* $('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
					$(this).prev().focus();
				}); */

				$('#simple-colorpicker-1').ace_colorpicker();
				/////////
				$('#modal-form input[type=file]').ace_file_input({
					style:'well',
					btn_choose:'Drop files here or click to choose',
					btn_change:null,
					no_icon:'icon-cloud-upload',
					droppable:true,
					thumbnail:'large'
				})
				
				//chosen plugin inside a modal will have a zero width because the select element is originally hidden
				//and its width cannot be determined.
				//so we set the width after modal is show
				$('#modal-form').on('shown.bs.modal', function () {
					$(this).find('.chosen-container').each(function(){
						$(this).find('a:first-child').css('width' , '210px');
						$(this).find('.chosen-drop').css('width' , '210px');
						$(this).find('.chosen-search input').css('width' , '200px');
					});
				})
			
			});
		</script>



	<!-- 弹出添加页 -->
	<div id="modal-table" class="modal fade" tabindex="-1">
		<div class="modal-dialog" style="width: 420px;">
			<div class="modal-content" style="top: 150px;">
				<div class="modal-header no-padding">
					<div class="table-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">
							<span class="white">&times;</span>
						</button>
						<i class="icon-save"></i>&nbsp;漫展添加
					</div>
				</div>

				<div class="mzinfo_box_l" style="line-height: 50px;">
					<form id="auserAddForm" name="auserAddForm"
						action="<spring:url value='/auserAdd.do' htmlEscape='true'/>"
						method="post" target="targetFrame">
						<ul class="box_l_h_c">
							<li class="box_l_h_c_li">
								<input id="telephone" class="span3" type="text"
									name="telephone" value="" placeholder="联系电话">
							</li>
							<li class="box_l_h_c_li"><input name="email" value="" type="text"
									placeholder="邮箱" class="ui-autocomplete-input" id="email"
									autocomplete="off" /></li>
							<li class="box_l_h_c_li">
								<input id="qqcode" class="span3" type="text"
									name="qqcode" value="" placeholder="QQ" >
							</li>
							
							<li class="box_l_h_c_li">
								<input name="title" id="title" value="" type="text"
									placeholder="漫展名称" class="ui-autocomplete-input" />
							</li>
							
							<li class="box_l_h_c_li">
								<input name="privurl" id="privurl" type="text"
									placeholder="个性域名" class="ui-autocomplete-input" />
							</li>
							<li class="box_l_h_c_li">
								<select id="status"
									style="height:28px;width: 192px; background: none repeat scroll 0 0 #f5f5f5 !important;"
									name="status">
										<option value="0" selected>票价</option>
										<option value="1" onclick="setAuStatus('1');" <c:if test="${status == 1}">selected</c:if>>免费</option>
										<option value="2" onclick="setAuStatus('2');" <c:if test="${status == 2}">selected</c:if>>收费</option>
								</select>
							</li>
							<li class="box_l_h_c_li">
								<input name="startDate" id="sDate" type="text"
									placeholder="开始时间" class="ui-autocomplete-input" />
							</li>
							<li class="box_l_h_c_li">
								<input name="endDate" id="eDate" type="text"
									placeholder="结束时间" class="ui-autocomplete-input" />
							</li>
							<li class="box_l_h_c_li">
								<input name="name" value="" type="text"
									placeholder="输入姓名" class="ui-autocomplete-input" id="name"/>
							</li>
							<li class="box_l_h_c_li">
								<input name="limitYear" value="" type="text" id="limitYear"
									placeholder="开通年限(限数字,0-100)" class="ui-autocomplete-input"/>
							</li>
							<li class="box_l_h_c_li">
								<input name="remark" value="" type="text"
									placeholder="备注" class="ui-autocomplete-input" id=""
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								<select id="status"
									style="height:28px;width: 192px; background: none repeat scroll 0 0 #f5f5f5 !important;"
									name="status">
										<option value="0" selected>状态</option>
										<option value="1" onclick="setAuStatus('1');" <c:if test="${status == 1}">selected</c:if>>有效</option>
										<option value="9" onclick="setAuStatus('9');" <c:if test="${status == 9}">selected</c:if>>失效</option>
								</select>
							</li>
							<div style="text-align: center;clear:both;">
									<button class="btn btn-sm btn-danger"
										aria-hidden="true" data-dismiss="modal" type="button">
										<i class="icon-remove"></i> 取消
									</button>
									<button type="button" class="btn btn-sm btn-success"
										onClick="submitAuserAddForm();">
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
<div id="auserEdit" class="modal fade" tabindex="-1">
		<div class="modal-dialog" style="width: 420px;">
			<div class="modal-content" style="top: 150px;">
				<div class="modal-header no-padding">
					<div class="table-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">
							<span class="white">&times;</span>
						</button>
						<i class="icon-save"></i>&nbsp;会员编辑
					</div>
				</div>

				<div class="mzinfo_box_l" style="line-height: 50px;">
					<form id="auserEditForm" name="auserEditForm"
						action="<spring:url value='/auserEdit.do' htmlEscape='true'/>"
						method="post" target="targetFrame">
						<input type="hidden" id="auidEdit" name="auid"/>
						<ul class="box_l_h_c">
							<li class="box_l_h_c_li">
								<select id="auRoleIdEdit" name="auRoleId"
									style="height:28px;width: 192px; background: none repeat scroll 0 0 #f5f5f5 !important;">
										<option value="0" selected>请选择等级</option>
										<c:forEach items="${roleList}" var="role">
											<option value="${role.id }"
												onclick="setAuRoleId('${role.id }');">${role.roleName}</option>
										</c:forEach>
								</select>
							</li>
							<li class="box_l_h_c_li">
								<input id="createDateEdit" class="span3" type="text"
									name="startDate" value="" placeholder="开始日期" readonly>
							</li>
							<li class="box_l_h_c_li"><input name="username" value="" type="text"
									placeholder="输入用户名" class="ui-autocomplete-input" id="usernameEdit"
									autocomplete="off" readonly="readonly"/></li>
							<li class="box_l_h_c_li">
								<input id="validDateEdit" class="span3" type="text"
									name="endDate" value="" placeholder="结束日期" readonly>
							</li>							
							<li class="box_l_h_c_li">
								<input name="terminalId" id="terminalIdEdit" type="text"
									placeholder="输入手机号" class="ui-autocomplete-input" 
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								<input name="email" id="emailEdit" type="text"
									placeholder="输入邮箱" class="ui-autocomplete-input" 
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								<input name="name" value="" type="text"
									placeholder="输入姓名" class="ui-autocomplete-input" id="nameEdit"
									autocomplete="off"/>
							</li>
							<li class="box_l_h_c_li">
								<input name="limitYear" value="" type="text" id="limitYearEdit"
									placeholder="开通年限(限数字,0-100)" class="ui-autocomplete-input"
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								<input name="remark" value="" type="text"
									placeholder="备注" class="ui-autocomplete-input" id="remarkEdit"
									autocomplete="off" />
							</li>
							<li class="box_l_h_c_li">
								<select id="statusEdit"
									style="height:28px;width: 192px; background: none repeat scroll 0 0 #f5f5f5 !important;"
									name="status">
										<option value="0" selected>状态</option>
										<option value="1" onclick="setAuStatus('1');" <c:if test="${status == 1}">selected</c:if>>有效</option>
										<option value="9" onclick="setAuStatus('9');" <c:if test="${status == 9}">selected</c:if>>失效</option>
								</select>
							</li>
							<div style="text-align: center;clear:both;">
									<button class="btn btn-sm btn-danger"
										aria-hidden="true" data-dismiss="modal" type="button">
										<i class="icon-remove"></i> 取消
									</button>
									<button type="button" class="btn btn-sm btn-success"
										onClick="submitAuserEditForm();">
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
<div id="auserDel" class="modal fade" tabindex="-1">
		<div class="modal-dialog" style="width: 420px;">
			<div class="modal-content" style="top: 150px;">
				<div class="modal-header no-padding">
					<div class="table-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">
							<span class="white">&times;</span>
						</button>
						<i class="icon-save"></i>&nbsp;会员删除
					</div>
				</div>

				<div class="mzinfo_box_l" style="line-height: 50px;">
					<form id="auserDelForm" name="auserDelForm"
						action="<spring:url value='/auserDel.do' htmlEscape='true'/>"
						method="post" target="targetFrame">
						<input type="hidden" id="auidDel" name="auid"/>
						<ul class="box_l_h_c">
							<li class="box_l_h_c_li" style="font-size: 14px;line-height: 55px;width:220px;">
								确认要删除该会员[<span id="usernameDel"></span>]吗?
							</li>

							<div style="text-align: center;clear:both;">
									<button class="btn btn-sm btn-danger"
										aria-hidden="true" data-dismiss="modal" type="button">
										<i class="icon-remove"></i> 取消
									</button>
									<button type="button" class="btn btn-sm btn-success"
										onClick="submitAuserDelForm();">
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


//会员信息修改
var editAuser = function(a,b,c,d,e,f,g,h,i,j,k){
	
	document.getElementById("auRoleIdEdit").value = a;
	document.getElementById("createDateEdit").value = b;
	document.getElementById("usernameEdit").value = c;
	document.getElementById("validDateEdit").value = d;
	document.getElementById("terminalIdEdit").value = e;
	document.getElementById("emailEdit").value = f;
	document.getElementById("nameEdit").value = g;
	document.getElementById("limitYearEdit").value = h;
	document.getElementById("remarkEdit").value = i;
	document.getElementById("statusEdit").value = j;	
	
	document.getElementById("auidEdit").value = k;
}

//提交会员信息修改
var submitAuserEditForm = function(){
	var name = $("#nameEdit").val();
	if(name == ''){
		alert('请输入姓名');
		$("#nameEdit").focus();
		return;
	}
	//年限数字校验
	var rey = /^[1-9]+[0-9]*]*$/;  
	var v_limitYear = $("#limitYearEdit").val();
    if (!rey.test(v_limitYear)){  
        alert("开通年限请输入正整数");  
        $("#limitYearEdit").focus();
        return; 
    }
    if(v_limitYear<0 || v_limitYear >100){
    	alert("开通年限为0-100");  
        $("#limitYearEdit").focus();
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
	
	document.getElementById("auserEditForm").submit();
}


//提交会员删除
var submitAuserDelForm = function(){
	document.getElementById("auserDelForm").submit();
}

//会员信息删除
var delAuser = function(auid,username){
	document.getElementById("auidDel").value = auid;
	document.getElementById("usernameDel").innerHTML = username;
}

</script>

<script type="text/javascript"	src="<%=path %>/static/js/bootstrap-select.js"></script>
<script type="text/javascript"	src="<%=path %>/static/js/date/bootstrap-datetimepicker.js"></script>
<script>
	$('#sDate').datetimepicker({format:'yyyy-mm-dd hh:ii:ss',language: 'ch',autoclose:'true'});
  	$('#eDate').datetimepicker({format:'yyyy-mm-dd hh:ii:ss',language: 'ch',autoclose:'true'});
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

