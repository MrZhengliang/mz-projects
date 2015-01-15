<%@page import="com.sh.manage.constants.SessionConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String cpath=this.getServletContext().getContextPath();
%>
<ul class="nav nav-list">
		<li class="active">
			<a href="<%=cpath%>/system/index">
				<i class="icon-dashboard"></i>
				<span class="menu-text"> 管理系统 </span>
			</a>
		</li>
						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-desktop"></i>
								<span class="menu-text">系统管理</span>
								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li >
								<a href="<%=cpath%>/gmanage.do">
									<i class="icon-double-angle-right"></i> 权限组管理
								</a>
								</li>
								<li <c:if test="1==1">class="active"</c:if>>
									<a href="<%=cpath%>/umanage.do">
										<i class="icon-double-angle-right"></i>
										用户管理
									</a>
								</li>
								<li>
									<a href="<%=cpath%>/mumanage.do">
										<i class="icon-double-angle-right"></i>
										会员管理
									</a>
								</li>
							</ul>
						</li>
					
						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-exchange"></i>
								<span class="menu-text">信息管理</span>
								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li class="active"><a href="<%=cpath%>/mzmanage.do">
									<i class="icon-double-angle-right"></i> 漫展管理
								</a>
								</li>
								<li>
									<a href="<%=cpath%>/umanage.do">
										<i class="icon-double-angle-right"></i>
										公告管理
									</a>
								</li>
								<li>
									<a href="<%=cpath%>/aumanage.do">
										<i class="icon-double-angle-right"></i>
										广告管理
									</a>
								</li>
							</ul>
						</li>
		</ul><!-- /.nav-list -->