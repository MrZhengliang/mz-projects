package com.sh.manage.cache;

import org.springframework.beans.factory.annotation.Autowired;

import com.sh.manage.entity.SysRole;
import com.sh.manage.service.RoleService;



/**
 * 角色缓存类. <br>
 * 负责请求的处理。
 * <p>
 * 创建类 <br>
 * <p>
 * Copyright: Copyright (c) 2011-06-22 下午05:36:09
 * <p>
 * Company: 
 * <p>
 * @version 1.0
 */
public class RoleCache extends Cache<SysRole> {

	/**
	 * Version UID
	 */
	private static final long serialVersionUID = 178826298600702622L;

	/** 主数据访问类 */
	private RoleService roleService;
	
	public RoleService getRoleService() {
		return roleService;
	}

	@Override
	public void init() {
		cacheList = roleService.getAllRoleList();
	}

	@Autowired
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
}
