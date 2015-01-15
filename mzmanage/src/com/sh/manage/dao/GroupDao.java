/**
 * 
 */
package com.sh.manage.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.sh.manage.entity.SysGroup;
import com.sh.manage.entity.SysRole;
import com.sh.manage.module.page.Page;

/**
 * 组数据访问类
 * 
 * @author
 * 
 */
@Repository
public class GroupDao extends AbstractBaseDao<SysGroup> {

	/**
	 * 获取全部用户
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SysGroup> getAllGroups() {
		String hql = "from SysGroup order by id asc";
		Query query = this.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public void addObject(SysGroup group) {
		this.getCurrentSession().save(group);
	}

	@Override
	public void updateObject(SysGroup group) {
		this.getCurrentSession().save(group);
	}

	@Override
	public void deleteObject(SysGroup group) {
		this.getCurrentSession().delete(group);
	}

	@Override
	public SysGroup getObject(SysGroup group) {
		String hql = "from SysGroup where id=?";
		hql += group.getId();
		Query query = this.getCurrentSession().createQuery(hql);
		return (SysGroup) query.list().get(0);
	}

	/**
	 * 获取当前组下的角色数量
	 * 
	 * @param sysGroup
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SysRole> getRoleRole(SysGroup sysGroup) {
		// select s from Student s left join s.clazzs c where c.id=:id
		String hql = "from SysRole where id=?";
		hql += sysGroup.getId();
		Query query = this.getCurrentSession().createQuery(hql);
		return (List<SysRole>) query.list();
	}

	/**
	 * 获取对应角色列表
	 * 
	 * @param groupIndex
	 * @param pageSize 
	 * @param pageNo 
	 * @return
	 */
	public Page getGroupRoles(Integer groupIndex, Integer pageNo, int pageSize) {
		String hql = "from SysGroup g join g.roles r where g.id=?";
		
		Object[] paras = new Object[]{groupIndex};
		return this.queryList(hql, paras,pageNo,pageSize);
	}

	
	/**
	 * 查询某个组织
	 * @param groupId
	 * @return
	 */
	public List<SysGroup> findSysGroup(Integer groupId) {
		String hql = "from SysGroup where id = ";
		hql += groupId;
		return this.find(hql);
	}

	/**
	 * 获取组织
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page getGroups(Integer pageNo, int pageSize) {
		String hql = "from SysGroup where 1=1 ";
		
		Object[] paras = new Object[]{};
		return this.queryList(hql, paras,pageNo,pageSize);
	}
}
