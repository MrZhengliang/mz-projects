package com.sh.manage.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author
 * 
 */

@Entity
@Table(name = "T_SH_USER", schema = "TEST_SH")
public class AppUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7488904616028381006L;

	@Id
	@GeneratedValue(generator = "auserGenerator", strategy = GenerationType.AUTO)
	@GenericGenerator(name = "auserGenerator", strategy = "native")
	@Column(name = "auid", length = 8)
	private String auid;

	@Column(name = "email", length = 100)
	private String email;

	@Column(name = "name", length = 32)
	private String name;

	@Column(name = "username", length = 32)
	private String userName;

	@Column(name = "password", length = 100)
	private String password;

	@Column(name = "terminal_id", length = 20)
	private String terminalId;

	@Column(name = "role_id", length = 8)
	private Integer roleId;

	@Column(name = "status", length = 1)
	private Integer status;
	
	@Column(name = "start_date", length = 20)
	private String startDate;
	
	@Column(name = "end_date", length = 20)
	private String endDate;

	@Column(name = "last_login_ip", length = 100)
	private String lastLoginIP;

	@Column(name = "limit_year", length = 1)
	private Integer limitYear;
	
	@Column(name = "remark", length = 255)
	private String remark;
	
	public String getLastLoginIP() {
		return lastLoginIP;
	}

	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}

	private String roleName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getAuid() {
		return auid;
	}

	public void setAuid(String auid) {
		this.auid = auid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getLimitYear() {
		return limitYear;
	}

	public void setLimitYear(Integer limitYear) {
		this.limitYear = limitYear;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
