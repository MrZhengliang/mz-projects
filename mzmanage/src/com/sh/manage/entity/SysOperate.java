/**
 * 
 */
package com.sh.manage.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 操作实体表
 * @author 
 *
 */
@Entity
@Table(name = "T_SYS_OPERATE", schema = "MZ")
public class SysOperate {
	

	@Id
	@GeneratedValue(generator = "soperGenerator", strategy = GenerationType.AUTO)
	@GenericGenerator(name = "soperGenerator", strategy = "native")
	@Column(name = "id", length = 8)
	private Integer id;
	
	@Column(name = "operate_code", length = 30)
	private String operateCode;
	
	@Column(name = "operate_name", length = 30)
	private String operateName;
	
	
	/**
	 * 操作角色多对多
	 */
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST}, fetch = FetchType.EAGER,
			mappedBy = "operateSet")
	@OrderBy("id ASC")
	private Set<SysRole> roleSet = new HashSet<SysRole>();


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getOperateCode() {
		return operateCode;
	}


	public void setOperateCode(String operateCode) {
		this.operateCode = operateCode;
	}


	public String getOperateName() {
		return operateName;
	}


	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}


	public Set<SysRole> getRoleSet() {
		return roleSet;
	}


	public void setRoleSet(Set<SysRole> roleSet) {
		this.roleSet = roleSet;
	}
}
