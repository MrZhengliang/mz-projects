package com.sh.manage.demo.weixin.msg.req;

/**
 * 事件基础类
 * @author fuzl
 *
 */
public class BaseEvent extends BaseReq {

	private String event;

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public BaseEvent() {
		setMsgType(ReqType.EVENT);
	}

}
