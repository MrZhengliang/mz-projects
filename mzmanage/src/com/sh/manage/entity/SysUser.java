package com.sh.manage.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author
 * 
 */

@Entity
@Table(name = "T_SYS_USER", schema = "TEST_SH")
public class SysUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7488904616028381006L;

	@Id
	@GeneratedValue(generator = "suserGenerator", strategy = GenerationType.AUTO)
	@GenericGenerator(name = "suserGenerator", strategy = "native")
	@Column(name = "uid", length = 8)
	private Integer uid;

	/**
	 * 邮箱
	 * 
	 * */
	@Column(name = "email", length = 100)
	private String email;
	/**
	 * 姓名
	 * 
	 * */
	@Column(name = "name", length = 32)
	private String name;
	/**
	 * 用户名
	 * 
	 * */
	@Column(name = "usercode", length = 32)
	private String usercode;
	/**
	 * 密码
	 * 
	 * */
	@Column(name = "password", length = 100)
	private String password;
	/**
	 * 手机号
	 * 
	 * */
	@Column(name = "terminal_id", length = 20)
	private String terminalId;

	/**
	 * 创建时间
	 * 
	 * */
	@Column(name = "create_time", length = 14)
	private String createTime;
	/**
	 * 密码修改时间
	 * 
	 * */
	@Column(name = "change_pwd_time", length = 14)
	private String changePwdTime;
	/**
	 * 有效期
	 * 
	 * */
	@Column(name = "valid_time", length = 14)
	private String validTime;
	/**
	 * 锁定状态 1 未锁定 2锁定
	 */
	@Column(name = "lock_status", length = 1)
	private Integer lockStatus;
	/**
	 * 有效性 1 有效，9失效
	 */
	@Column(name = "status", length = 1)
	private Integer status;
	
	@Column(name = "last_login_ip", length = 100)
	private String lastLoginIP;
	
	@Column(name = "last_login_time", length = 14)
	private String lastLoginTime;
	
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 角色id
	 */
	private Integer roleId;
	
	
	
	/**
	 * 用户列表
	 */
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST},fetch = FetchType.LAZY)
	@JoinTable(name = "t_sys_user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	@OrderBy("id ASC")
	private List<SysRole> roleList = new ArrayList<SysRole>();

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SysRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getChangePwdTime() {
		return changePwdTime;
	}

	public void setChangePwdTime(String changePwdTime) {
		this.changePwdTime = changePwdTime;
	}

	public String getValidTime() {
		return validTime;
	}

	public void setValidTime(String validTime) {
		this.validTime = validTime;
	}

	public Integer getLockStatus() {
		return lockStatus;
	}

	public void setLockStatus(Integer lockStatus) {
		this.lockStatus = lockStatus;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLastLoginIP() {
		return lastLoginIP;
	}

	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
	

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
}
