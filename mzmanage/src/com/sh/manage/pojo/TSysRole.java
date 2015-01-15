package com.sh.manage.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import com.sh.manage.entity.AppUser;
import com.sh.manage.entity.SysUser;
import com.sh.manage.pojo.SysRolePrivilege;

/**
 * @author
 * 
 */
public class TSysRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7488904616028381006L;

	
	private int id;

	private String roleName;

	private String remark;

	private int operateId;

	private String createTime;

	/**
	 * 用户列表
	 */

	private List<SysUser> userList;


	private int groupId;
	
	
	/**
	 * 组的角色关系
	 */
	private Set<AppUser> aUsers = new HashSet<AppUser>();

	
	/**
	 * 该角色具体权限列表
	 */
	private List<SysRolePrivilege> srpList = new ArrayList<SysRolePrivilege>();
	
	
	public List<SysRolePrivilege> getSrpList() {
		return srpList;
	}

	public void setSrpList(List<SysRolePrivilege> srpList) {
		this.srpList = srpList;
	}

	public List<SysUser> getUserList() {
		return userList;
	}

	public void setUserList(List<SysUser> userList) {
		this.userList = userList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getOperateId() {
		return operateId;
	}

	public void setOperateId(int operateId) {
		this.operateId = operateId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public Set<AppUser> getaUsers() {
		return aUsers;
	}

	public void setaUsers(Set<AppUser> aUsers) {
		this.aUsers = aUsers;
	}
	
}
