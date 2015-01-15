/**
 * 
 */
package com.sh.manage.module.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.sh.manage.constants.Constants;
import com.sh.manage.constants.SessionConstants;
import com.sh.manage.dao.JdbcSpTemplate;

/**
 * 
 * 自定义按钮标签
 * 
 * @author fuzl
 * 
 */
@SuppressWarnings("unused")
public class ButtonTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3130860495480656707L;
	// 按钮map
	private static Map<String,String> BTN_MAP = new HashMap<String,String>();
	// 标签属性用户名
	private String user = null;
	// 标签属性操作url
	private String url = null;
	// 标签属性 js方法
	private String jsmethod = null;
	// 标签属性image 按钮图片
	private String image = null;

	// 标签属性 alt 提示
	private String alt = null;
	// 标签属性操作value 按钮文本
	private String value = null;
	
	// 标签编码
	private String modelCode = null;
	
//	static{
//		BTN_MAP.put("add_btn", "添加");
//		BTN_MAP.put("edit_btn", "修改");
//		BTN_MAP.put("del_btn", "删除");
//		BTN_MAP.put("audit_btn", "审核");
//	}
	
	
	/* 标签初始方法 */
	@SuppressWarnings("static-access")
	public int doStartTag() throws JspTagException {
		
		return super.EVAL_BODY_INCLUDE;
	}

	/* 标签结束方法 */
	@SuppressWarnings({ "rawtypes", "static-access" })
	public int doEndTag() throws JspTagException {
		Boolean b = false;
		List list = new ArrayList();
		//jdbc自定义template
		JdbcSpTemplate spTemplate = new JdbcSpTemplate();
		try {
			
			String username=(String)pageContext.getSession().getAttribute(SessionConstants.LOGIN_USER);
			
		    //先去缓存中查找，如果找不到执行数据库操作，提高性能
//			if(null!=CacheManage.get("key")){
//				
//			}else{
//				list = spTemplate.getRolesBtnByUser(username);
			//此处增加缓存操作
//			}
			
			list = spTemplate.getRolesBtnByUser(username);
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		for (int i = 0; i < list.size(); i++) {
			//是否包含当前按钮编码
			if(list.get(i).equals(modelCode)){
				b=true;
				break;
			}
//			if (p.getUrl().trim().equals(url.trim())) {
//				b = true;
//				// 如果jsmethod属性不为null 则把超链接href改为调用js
//				if (jsmethod != null) {
//					url = jsmethod;
//				}
//			}
		}
		JspWriter out = pageContext.getOut();
		if (b) {
			try {
				// 有权限 显示操作按钮
//				out.println("<a href='" + url + "' class='btn btn-minier btn-info'><img src='"
//						+ image + "' alt='" + alt + "' />" + value + "</a>");
				switch (modelCode) {
				case Constants.ADD_BTN:
					out.println("<a href='" + url + "' class='btn btn-sm btn-info'><img src='"
							+ image + "' alt='" + alt + "' />" + value + "</a>");
					break;
				case Constants.EDIT_BTN:
					out.println("<a href='" + url + "' class='btn btn-sm btn-primary'><img src='"
							+ image + "' alt='" + alt + "' />" + value + "</a>");
					break;
				case Constants.DEL_BTN:
					out.println("<a href='" + url + "' class='btn btn-sm btn-danger'><img src='"
							+ image + "' alt='" + alt + "' />" + value + "</a>");
					break;
				case Constants.QUERY_BTN:
					out.println("<a href='" + url + "' class='btn btn-minier btn-info'><img src='"
							+ image + "' alt='" + alt + "' />" + value + "</a>");
					break;
				default:
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return super.SKIP_BODY;
	}

	/* 释放资源 */
	public void release() {
		super.release();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getJsmethod() {
		return jsmethod;
	}

	public void setJsmethod(String jsmethod) {
		this.jsmethod = jsmethod;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

}
