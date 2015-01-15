/**
 * 
 */
package com.sh.manage.dao;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.sh.manage.constants.SessionConstants;
import com.sh.manage.entity.SysMenu;
import com.sh.manage.pojo.LoginUser;

/**
 * 角色数据访问类
 * @author 
 * 
 */
@Repository
public class MenuDao extends AbstractBaseDao<SysMenu> {

	/**
	 * 获取全部用户
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SysMenu> getAllMenus() {
		String hql = "from SysGroup order by id asc";
		Query query = this.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public void addObject(SysMenu menu) {
		this.getCurrentSession().save(menu);
		this.getCurrentSession().flush();
	}

	@Override
	public void updateObject(SysMenu menu) {
		this.getCurrentSession().save(menu);
	}

	@Override
	public void deleteObject(SysMenu menu) {
		this.getCurrentSession().delete(menu);
	}

	@Override
	public SysMenu getObject(SysMenu menu) {
		String hql = "from SysMenu where id=?";
		hql+=menu.getId();
		Query query = this.getCurrentSession().createQuery(hql);
		return (SysMenu) query.list().get(0);
	}

	/**
	 * 获取所有菜单数据
	 */
	@SuppressWarnings("unchecked")
	public List<SysMenu> getMenuList(LoginUser loginUser) {
		StringBuffer sql = new StringBuffer();
		Object[] params = new Object[] {};
		sql.append("select m.id,m.menu_code,m.menu_name,m.menu_pid,m.menu_url,m.leaf_yn,m.menu_btns");
		sql.append(" from t_sys_menu m");
		sql.append(" where 1=1");
		//后台菜单
		//params = ArrayUtils.add(params, Const.SYS_TYPE_0);
		
		//不是超级管理员需要查询属于自己权限的菜单
		if(!SessionConstants.SUPER_ADMIN_ID_LIST.contains(loginUser.getId())){
			sql.append(" and m.id in(");
			sql.append(" select distinct menu_id from t_sys_group_menu");
			sql.append(" where group_id is not null and group_id in(");
			sql.append(" select tr.group_id from t_sys_user_role tur,t_sys_role tr where tur.role_id = tr.id and tur.user_id = ?)");
			sql.append(" )");
			params = ArrayUtils.add(params, loginUser.getId());
		}else{
			//logger.info("超级管理员...");
		}		
		// 如果是超级管理员则可以查看到所有菜单权限
		//oracle专用
//		sql.append(" start with m.menu_pid = '0'");
//		sql.append(" connect by m.menu_pid = PRIOR m.id");
		sql.append(" order by m.id");		 
		
		return (List<SysMenu>) this.queryModelSqlList(sql.toString(), params,SysMenu.class);
	}

	/**
	 * 根据Pid查询子菜单
	 */
	@SuppressWarnings("unchecked")
	public List<SysMenu> getMenuListByPId(int i) {
		StringBuffer sql = new StringBuffer();
		Object[] params = new Object[] {};
		sql.append("select m.id,m.menu_code,m.menu_name,m.menu_pid,m.menu_url,m.leaf_yn,m.menu_btns");
		sql.append(" from t_sys_menu m");
		sql.append(" where 1=1");
		sql.append(" and m.menu_pid = ?");
		//后台菜单
//		params = ArrayUtils.add(params, Const.SYS_TYPE_0);
		params = ArrayUtils.add(params, i);
		
		return (List<SysMenu>) queryModelSqlList(sql.toString(),params,SysMenu.class);
	}
}
