/**
 * 
 */
package com.sh.manage.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sh.manage.constants.SessionConstants;
import com.sh.manage.pojo.LoginUser;

/**
 * 安全验证 过滤器
 * 登陆校验filter
 * 
 * @author fuzl
 * 
 */
public class LoginFilter implements Filter {
	/** 不做权限验证的地址列表。可以使前缀路径或是具体的url */
	private final Set<String> AUTHOR_IGNORE_URLS = new HashSet<String>();

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) req;
		HttpServletResponse httpResponse = (HttpServletResponse) resp;
		// 不过滤的uri
		String[] notFilter = new String[] { "/static/js", "/static/css",
				"/static/font", "/static/images", "/static/assets",
				"/system/tologin", "/system/tologin.do",
				"/system/checkPassword.do", "authImage",
				"/system/user_login.do" };
		// 请求的uri
		String uri = httpRequest.getRequestURI();

		// 获取session中是否存在该用户
		if (!(req instanceof HttpServletRequest)
				|| !(resp instanceof HttpServletResponse)) {
			throw new ServletException(
					"OncePerRequestFilter just supports HTTP requests");
		}

		// 是否过滤
		boolean doFilter = true;
		for (String s : notFilter) {
			if (uri.contains(s)) {
				// 如果uri中包含不过滤的uri，则不进行过滤
				doFilter = false;
				break;
			}
		}

		// 登陆过滤
		if (doFilter) {
			// 获取会话
			HttpSession session = httpRequest.getSession(true);
			// 获取会话中的用户
			Object object = session.getAttribute(SessionConstants.LOGIN_USER);

			LoginUser loginUser = object == null ? null : (LoginUser) object;
			if (null == loginUser) {
				// boolean isAjaxRequest = isAjaxRequest(httpRequest);
				// if (isAjaxRequest) {
				// httpResponse.setCharacterEncoding("UTF-8");
				// httpResponse.sendError(HttpStatus.UNAUTHORIZED.value(),
				// "您已经太长时间没有操作,请刷新页面");
				// }
//				String toUrl = "";
//				toUrl = new StringBuilder().append(httpRequest.getScheme()).append("://").append(httpRequest.getServerName()).append(":")
//		        .append(httpRequest.getServerPort()).append(httpRequest.getContextPath()).toString();

				
				httpResponse.sendRedirect("/mzmanage/system/tologin.do");
				return;
			}
		}
		chain.doFilter(req, resp);
		return;
	}

	/**
	 * 初始化操作
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		AUTHOR_IGNORE_URLS.add("/");
		AUTHOR_IGNORE_URLS.add("/js/");
		AUTHOR_IGNORE_URLS.add("/css/");
		AUTHOR_IGNORE_URLS.add("/images/");
		AUTHOR_IGNORE_URLS.add("/uniteLogon.do");
		AUTHOR_IGNORE_URLS.add("/getGoodsInfoJsonList.xhtml");
		AUTHOR_IGNORE_URLS.add("/getBusiInfoJsonList.xhtml");
		AUTHOR_IGNORE_URLS.add("/login.do");
		AUTHOR_IGNORE_URLS.add("/code.do");
		AUTHOR_IGNORE_URLS.add("/index.jsp");
		AUTHOR_IGNORE_URLS.add("/uniteLogout.do");
		AUTHOR_IGNORE_URLS.add("/unite_index.jsp");
	}

	/**
	 * 判断访问链接是否在set范围内
	 * 
	 * @param req
	 *            HttpServletRequest
	 * @param set
	 *            Set
	 * @return 是 True,否 False
	 */
	@SuppressWarnings("unused")
	private boolean inSet(HttpServletRequest req, Set<String> set) {
		String url = req.getServletPath();
		String s = url.substring(0, url.lastIndexOf("/"));

		if (set.contains(url) || set.contains(s)) {
			return true;
		}

		return false;
	}

	/**
	 * 判断是否为Ajax请求
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return 是true, 否false
	 */
	public static boolean isAjaxRequest(HttpServletRequest request) {
		return request.getRequestURI().startsWith("/api");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}
