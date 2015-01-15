package com.sh.manage.pojo;

/**
 * @Title. 角色具体权限列表<br>
 * @Description.
 *         <p>
 *             <p>
 *           <p>
 * @Author: fu
 *          <p>
 * @Version: 1.0
 *           <p>
 * @History:
 *           <p>
 */
public class SysRolePrivilege {

	/**
	 * 菜单功能详细权限，例如添加、删除、修改等
	 */
	private String menuBtn;

	/**
	 * 菜单编码
	 */
	private String menuId;

	public String getMenuBtn() {
		return menuBtn;
	}
	public void setMenuBtn(String menuBtn) {
		this.menuBtn = menuBtn;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	
}