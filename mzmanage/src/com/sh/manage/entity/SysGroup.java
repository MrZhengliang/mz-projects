package com.sh.manage.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author
 * 
 */

@Entity
@Table(name = "T_SYS_GROUP", schema = "TEST_SH")
public class SysGroup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7488904616028381006L;

	@Id
	@GeneratedValue(generator="sgroupGenerator",strategy = GenerationType.AUTO)
    @GenericGenerator(name = "sgroupGenerator", strategy = "native")
	@Column(name = "id", length = 8)
	private int id;

	@Column(name = "group_name", length = 18)
	private String groupName;

	@Column(name = "create_time", length = 20)
	private String createTime;
	
	@Column(name = "group_desc", length = 50)
	private String groupDesc;

	/**
	 * 组的角色关系
	 */
	@OneToMany(mappedBy = "groupId",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<SysRole> roles = new HashSet<SysRole>();

	/**
	 * 组的菜单关系
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "t_sys_group_menu", joinColumns = { @JoinColumn(name = "group_id") }, inverseJoinColumns = { @JoinColumn(name = "menu_id") })
	@OrderBy("id ASC")
	private Set<SysMenu> menuSet = new HashSet<SysMenu>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Set<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<SysRole> roles) {
		this.roles = roles;
	}

	public String getGroupDesc() {
		return groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}

	public Set<SysMenu> getMenuSet() {
		return menuSet;
	}

	public void setMenuSet(Set<SysMenu> menuSet) {
		this.menuSet = menuSet;
	}
	

}
