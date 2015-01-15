package com.sh.manage.demo.weixin.demo;

import com.sh.manage.demo.weixin.msg.BaseMsg;
import com.sh.manage.demo.weixin.msg.ImageMsg;
import com.sh.manage.demo.weixin.msg.NewsMsg;
import com.sh.manage.demo.weixin.msg.TextMsg;
import com.sh.manage.demo.weixin.msg.req.ImageReqMsg;
import com.sh.manage.demo.weixin.msg.req.TextReqMsg;
import com.sh.manage.demo.weixin.servlet.WeixinServletSupport;

/**
 * demo
 */
public class MyWeixinServlet extends WeixinServletSupport {

	private static final long serialVersionUID = 2934570713761546554L;

	@Override
	protected String getToken() {
		return "myToken";
	}

	protected BaseMsg handleTextMsg(TextReqMsg req) {
		String content = req.getContent();
		if (content.equals("xxx")) {
			// 返回文本消息
			return new TextMsg("nnn");
		} else {
			// 返回图文消息
			NewsMsg msg = new NewsMsg();
			msg.add("标题1", "描述", "picurl", "url");
			msg.add("title2");
			msg.add("title3");

			return msg;
		}
	}

	protected BaseMsg handleImageMsg(ImageReqMsg msg) {
		ImageMsg imageMsg = new ImageMsg("");
		return imageMsg;
	}

}
