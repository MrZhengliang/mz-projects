package com.sh.manage.pojo;

import java.util.ArrayList;
import java.util.List;


import com.sh.manage.constants.Constants;
import com.sh.manage.entity.SysMenu;
import com.sh.manage.entity.SysOperate;
import com.sh.manage.entity.SysRole;


/**
 * @Title.登录用户bean，存入session <br>
 * @Description.
 *                           <p>
 * @Copyright: Copyright (c) Apr 13,
 *             <p>
 * @Company: 
 *           <p>
 * @Author: 
 *          <p>
 * @Version: 1.0
 *           <p>
 * @History:
 *           <p>
 */
public class LoginUser {

	/** 全国管理员 */
	public static final int LOGIN_USER_COUNTRY_ADMIN = 0;
	
	/** 省管理员 */
	public static final int LOGIN_USER_PROV_ADMIN = 1;
	
	/** 普通用户 */
	public static final int LOGIN_USER_COMMON_USER = 2;


	/**
	 * [0]:超级管理员, [1]:平台管理员, [2]:运营商管理员, [3]CP ,[4]:客服
	 */
	private String flag = "0";

	/**
	 * 登录用户ID，常用来标识一个用户
	 */
	private Integer id;

	/**
	 * 登录用户所具有的全新菜单对象列表 注意：针对超级管理员system帐户，roleList和srpList都没有值，但是menuList肯定有值
	 */
	private List<SysMenu> menuList = new ArrayList<SysMenu>();

	/**
	 * 该用户所分配的角色列表
	 */
	private List<SysRole> roleList = new ArrayList<SysRole>();

	/**
	 * 该用户具有的所有权限菜单的对象列表
	 */
	private List<SysRolePrivilege> srpList = new ArrayList<SysRolePrivilege>();
	
	
	/**
	 * 获取角色对应操作权限
	 */
	private List<SysOperate> soperList = new ArrayList<SysOperate>();

	/**
	 * 用户归属单位ID
	 */
	private String unitId;

	/**
	 * 登录用户帐号
	 */
	private String userCode;

	/**
	 * 登录用户名
	 */
	private String userName;

	/**
	 * 登录用户密码
	 */
	private String userPwd;

	/**
	 * 姓名
	 * 
	 * */
	private String name;
	/**
	 * 用户类型：[0:全国管理员, 1:省管理员, 2:普通用户]
	 */
	private int userType;

	/**
	 * 获取 标识
	 * 
	 * @return 标识
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * 获取 ID
	 * 
	 * @return ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 获取 登录用户所具有的全新菜单对象列表
	 * 
	 * @return 登录用户所具有的全新菜单对象列表
	 */
	public List<SysMenu> getMenuList() {
		return menuList;
	}

	/**
	 * 获取 该用户所分配的角色列表
	 * 
	 * @return 该用户所分配的角色列表
	 */
	public List<SysRole> getRoleList() {
		return roleList;
	}

	/**
	 * 获取 用户具有的所有权限菜单的对象列表
	 * 
	 * @return 用户具有的所有权限菜单的对象列表
	 */
	public List<SysRolePrivilege> getSrpList() {
		return srpList;
	}


	/**
	 * 获取 单位ID
	 * 
	 * @return 单位ID
	 */
	public String getUnitId() {
		return unitId;
	}

	/**
	 * 获取 用户代码
	 * 
	 * @return 用户代码
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * 获取 用户名
	 * 
	 * @return 用户名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 获取 用户密码
	 * 
	 * @return 用户密码
	 */
	public String getUserPwd() {
		return userPwd;
	}

	/**
	 * 判断用户状态是否是超级用户
	 * 
	 * @param flag
	 * @return
	 */
	public boolean isSuperAdmin() {
		return Constants.SUPER_ADMIN_ID_LIST.contains(id) ? true : false;
	}


	/**
	 * 设置 标识
	 * 
	 * @param flag
	 *            标识
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * 设置 ID
	 * 
	 * @param id
	 *            ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 设置 登录用户所具有的全新菜单对象列表
	 * 
	 * @param menuList
	 *            登录用户所具有的全新菜单对象列表
	 */
	public void setMenuList(List<SysMenu> menuList) {
		this.menuList = menuList;
	}

	/**
	 * 设置 用户所分配的角色列表
	 * 
	 * @param roleList
	 *            该用户所分配的角色列表
	 */
	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}

	/**
	 * 设置 用户具有的所有权限菜单的对象列表
	 * 
	 * @param srpList
	 *            用户具有的所有权限菜单的对象列表
	 */
	public void setSrpList(List<SysRolePrivilege> srpList) {
		this.srpList = srpList;
	}

	/**
	 * 设置 用户单位ID
	 * 
	 * @param unitId
	 *            用户单位ID
	 */
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	/**
	 * 设置 用户代码
	 * 
	 * @param userCode
	 *            用户代码
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * 设置 用户名
	 * 
	 * @param userName
	 *            用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 设置 用户密码
	 * 
	 * @param userPwd
	 *            用户密码
	 */
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SysOperate> getSoperList() {
		return soperList;
	}

	public void setSoperList(List<SysOperate> soperList) {
		this.soperList = soperList;
	}

}
