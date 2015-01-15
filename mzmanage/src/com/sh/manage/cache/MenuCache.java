package com.sh.manage.cache;

import com.sh.manage.constants.SessionConstants;
import com.sh.manage.entity.SysMenu;
import com.sh.manage.service.LoginService;



/**
 * 菜单缓存类. <br>
 * 负责菜单的处理。
 * <p>
 * 创建类 <br>
 * <p>
 * Copyright: Copyright (c) 2011-06-22 下午05:36:09
 * <p>
 * Company: 
 * <p>
 * @author 
 * @version 1.0
 */
public class MenuCache extends Cache<SysMenu> {

	/**
	 * Version UID
	 */
	private static final long serialVersionUID = -8312387103066500321L;

	/** 主数据访问类 */
	private LoginService loginService;

	/**
	 * 私有构造函数
	 */
	public MenuCache() {

	}

	public LoginService getLoginService() {
		return loginService;
	}

	/**
	 * 从列表中根据MenuCode获得菜单对象
	 * 
	 * @param menuCode 菜单代码
	 * @return
	 */
	public SysMenu getMenu(String menuCode) {
		for (SysMenu bean : cacheList) {
			if (menuCode.equals(bean.getMenuCode())) {
				return bean;
			}
		}
		
		return null;
	}

	/**
	 * 根据modelCode获得系统菜单表中唯一菜单记录
	 * 
	 * @param modelCode 菜单代码
	 * @return
	 */
	public SysMenu getMenuByModelCode(String modelCode) {
		if ((modelCode == null) || modelCode.equals("")) {
			return null;
		}
		
		for (SysMenu bean : cacheList) {
			if (modelCode.equalsIgnoreCase(bean.getMenuCode())) {
				return bean;
			}
		}
		
		return null;
	}

	/**
	 * 初始化
	 */
	public void init() {
		cacheList = loginService.getMenuList(Integer.parseInt(SessionConstants.SUPER_ADMIN_ID));
	}
	
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
}
