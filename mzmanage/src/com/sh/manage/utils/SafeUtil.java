/**
 * 
 */
package com.sh.manage.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;



/**
 * 
 * 特别将其中的帐号字符串验证、 字符串长度验证、服务端来源页面地址校验、客户段登录IP地址校验。<br/>
 * 
 * @author fuzl
 * 
 */
public class SafeUtil {
	public static final String CHECK_DATA_PAGE = "../home/index.jsp";

	// 0 成功，1 密码错误，2 帐号长时间没改密码被锁定，3 登录成功而且提示修改密码，4 帐号已经锁定
	public static final int COMP_ERR_Code_0 = 0;

	public static final int COMP_ERR_Code_1 = 1;

	public static final int COMP_ERR_Code_2 = 2;

	public static final int COMP_ERR_Code_3 = 3;

	public static final int COMP_ERR_Code_4 = 4;

	public static final int ERR_Code_0 = 0; // 正常

	public static final int ERR_Code_1 = 1; // 字符串验证异常

	public static final int ERR_Code_2 = 2; // 服务端来源地址校验异常

	public static final int ERR_Code_3 = 3; // 客户段登录IP地址校验异常

	public static final String PASSWORD_KEY = "password"; // 密码

	public static final String RAND_KEY = "rand"; // 认证码

	public static final String USER_NAME_KEY = "username"; // 用户名表单字符串

	public static SafeUtil util = null;

	public static SafeUtil instance() {
		if (util == null) {
			util = new SafeUtil();
		}
		return util;
	}

	/**
	 * 将错误码，转译成可识别的汉字！该方法主要是针对老版的验证：如登录密码错误，用户不存在等。 错误码转译：0 成功，1 密码错误，2
	 * 帐号长时间没改密码被锁定，3 登录成功而且提示修改密码，4 帐号已经锁定
	 * 
	 * @param errCode
	 *            错误码
	 * @return 返回错误对应的错误信息
	 */
	public String getCompatibleMessgeByErrCode(int errCode) {
		String msg = "";
		switch (errCode) {
		case COMP_ERR_Code_1:
			msg = "对不起，您的用户名密码错误，登录失败，一天之内输入错误密码5次帐户将被锁定！！";
			break;
		case COMP_ERR_Code_2:
			msg = "对不起，您超过90天没有修改密码，帐户已被锁定，请联系管理员！！";
			break;
		case COMP_ERR_Code_4:
			msg = "帐户已被锁定，请联系管理员！";
			break;
		default:
			msg = "";
			break;
		}

		return msg;
	}

	/**
	 * 生成页面的隐藏域
	 * 
	 * @param request
	 * @return
	 */
	public String getHideElStr(HttpServletRequest request) {
		StringBuffer body = new StringBuffer();
		// 取基础数据
		String userName = request.getParameter(USER_NAME_KEY); // 用户名
		String passwd = request.getParameter(PASSWORD_KEY); // 密码
		String rand = request.getParameter(RAND_KEY); // 验证码

		body.append("<input type='hidden' name=" + USER_NAME_KEY + " value='"
				+ userName + "'>");
		body.append("<input type='hidden' name=" + PASSWORD_KEY + " value='"
				+ passwd + "'>");
		body.append("<input type='hidden' name=" + RAND_KEY + " value='" + rand
				+ "'>");

		return body.toString();
	}

	/**
	 * 将错误码，转译成可识别的汉字！
	 * 
	 * @param errCode
	 *            错误码
	 * @return 返回错误对应的错误信息
	 */
	public String getMessgeByErrCode(int errCode) {
		String msg = "";
		switch (errCode) {
		case ERR_Code_1:
			msg = "对不起，您输入的数据格式有误，请检查后重新输入！";
			break;
		case ERR_Code_2:
			msg = "对不起，您的服务地址非法！";
			break;
		case ERR_Code_3:
			msg = "对不起，您的IP地址非法！";
			break;
		default:
			msg = "";
			break;
		}

		return msg;
	}

	/**
	 * 提示信息提取。
	 * 
	 * @param request
	 * @return
	 */
	public String getNoticeMsgInSession(HttpServletRequest request) {
		Object noticeObj = request.getSession().getAttribute("noticeMsg");
		String msg = noticeObj == null ? "" : String.valueOf(noticeObj);
		return msg;
	}

//	/**
//	 * 判断是否需要手机验证，并且手机验证是否已经通过。
//	 * 
//	 * @param request
//	 * @return true:验证通过 false:验证不通过。
//	 */
//	public boolean isMobileRand(HttpServletRequest request) {
//		boolean flag = true;
//		if (isNeedMobileRand(request)) {
//			String mobilerand = String.valueOf(request.getSession()
//					.getAttribute("mobilerand"));
//			if (StringUtils.isEmpty(mobilerand)
//					|| !StringUtils.equals(mobilerand, "true")) {
//				flag = false;
//			}
//		}
//		return flag;
//	}

//	/**
//	 * 判断登录用户是否需启用手机验证码验证。
//	 * 
//	 * @return true : 需要验证 false:不需要验证
//	 */
//	public boolean isNeedMobileRand(HttpServletRequest request) {
//		return isNeedMobileRand(request.getParameter(USER_NAME_KEY));
//	}

//	/**
//	 * 判断登录用户是否需启用手机验证码验证。
//	 * 
//	 * @param userName
//	 *            登录用户名
//	 * @return true : 需要验证 false:不需要验证
//	 */
//	public boolean isNeedMobileRand(String userName) {
//		SafeProcess safePro = new SafeProcessImpl();
//		return StringUtils.isNotEmpty(safePro.isSendMobile(userName));
//	}

	/**
	 * 保存手机验证结果，防止非法登录
	 * 
	 * @param request
	 */
	public void saveMobileRandResult(HttpServletRequest request) {
		request.getSession().setAttribute("mobilerand", "true");
	}

	/**
	 * 保存会话消息。
	 * 
	 * @param request
	 */
	public void saveNoticeMsgSession(HttpServletRequest request) {
		// 保存会话
		saveNoticeMsgSession(request, "您的密码已经超过25天未修改了，请尽快修改，以保证密码安全！");
	}

	/**
	 * 保存会话消息。
	 * 
	 * @param request
	 */
	public void saveNoticeMsgSession(HttpServletRequest request, String msg) {
		// 保存会话
		request.getSession().setAttribute("noticeMsg", msg);
	}

//	/**
//	 * 发送短信提醒信息。
//	 * 
//	 * @param request
//	 */
//	public void sendNotice(HttpServletRequest request) {
//		String userName = request.getParameter(USER_NAME_KEY); // 用户名
//		SafeProcess safePro = new SafeProcessImpl();
//		safePro.sendMobile(request, safePro.isSendMobile(userName));
//	}

	/**
	 * 以脚本的形式显示消息。
	 * 
	 * @return
	 */
	public String showScriptMsg(String msg) {
		String scriptmsg = "";

		if (StringUtils.isNotEmpty(msg)) {
			scriptmsg += "<script>";
			scriptmsg += "alert('" + msg + "');";
			scriptmsg += "</script>";
		}
		return scriptmsg;
	}

	/**
	 * 验证用户登录时的输入是否合法。
	 * 
	 * @param userName
	 *            用户名
	 * @param passwd
	 *            密码
	 * @param rand
	 *            验证码
	 * @return true：输入合法 false：输入不合法。
	 */
	private boolean validateInputData(String userName, String passwd,
			String rand) {
		boolean flag = true;
		// 用户名验证
		if (StringUtils.isNotEmpty(userName)) {
			if (!ValidateDate.validateUserName(userName)) {
				flag = false;
			}
		}

		// 密码验证
		if (flag == true && StringUtils.isNotEmpty(passwd)) {
			if (!ValidateDate.validatePassword(passwd)) {
				flag = false;
			}
		}

		// 验证码
		if (flag == true && StringUtils.isNotEmpty(rand)) {
			if (!ValidateDate.validateRand(rand)) {
				flag = false;
			}
		}

		return flag;
	}

	/**
	 * @param request
	 * @return errCode定义说明： 0:正常
	 *         <p>
	 *         1:字符串验证异常
	 * 
	 */
	public int vlidate(HttpServletRequest request) {
		int flag = 0;
		// 取基础数据
		String userName = request.getParameter(USER_NAME_KEY); // 用户名
		String passwd = request.getParameter(PASSWORD_KEY); // 密码
		String rand = request.getParameter(RAND_KEY); // 验证码

		// 输入验证;目前不加输入校验
//		if (!validateInputData(userName, passwd, rand)) {
//			flag = ERR_Code_1;
//		}

		return flag;
	}

//	/**
//	 * @param request
//	 * @return errCode定义说明： 0:正常
//	 *         <p>
//	 *         1:校验客户端ip地址
//	 * 
//	 */
//	public int vlidateIP(HttpServletRequest request) {
//		int flag = 0;
//		// 取基础数据
//		String userName = request.getParameter(USER_NAME_KEY); // 用户名
//
//		SafeProcess safePro = new SafeProcessImpl();
//		// 来源地址校验
//		System.out.println(safePro.checkReferer(request) + ","
//				+ safePro.isIp(userName) + "," + request.getHeader("referer")
//				+ "," + request.getRemoteAddr());
//
//		// 客户段IP校验
//		if (safePro.isIp(userName)) {
//			if (flag == 0 && !safePro.checkIp(request)) {
//				flag = ERR_Code_3;
//			}
//		}
//
//		return flag;
//	}

//	/**
//	 * @param request
//	 * @return errCode定义说明： 0:正常
//	 *         <p>
//	 *         1:检测服务端地址是不是正确
//	 * 
//	 */
//	public int vlidateServer(HttpServletRequest request) {
//		int flag = 0;
//
//		SafeProcess safePro = new SafeProcessImpl();
//		// 来源地址校验
//
//		if (flag == 0 && !safePro.checkReferer(request)) {
//			flag = ERR_Code_2;
//		}
//
//		return flag;
//	}
}
