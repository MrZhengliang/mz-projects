/**
 * 
 */
package com.sh.manage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sh.manage.entity.SysRole;
import com.sh.manage.exception.SPlatformDaoException;
import com.sh.manage.utils.SQLPagingUtils;
import com.sun.istack.internal.logging.Logger;

/**
 * 角色数据访问类
 * 
 * @author
 * 
 */
@Repository
public class RoleDao extends AbstractBaseDao<SysRole> {

	private Logger logger = Logger.getLogger(RoleDao.class);

	/**
	 * 获取全部用户
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SysRole> getAllRoles() {
		String hql = "from SysGroup order by id asc";
		Query query = this.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public void addObject(SysRole role) {
		this.getCurrentSession().save(role);
		this.getCurrentSession().flush();
	}

	@Override
	public void updateObject(SysRole role) {
		this.getCurrentSession().save(role);
	}

	@Override
	public void deleteObject(SysRole role) {
		this.getCurrentSession().delete(role);
	}

	@Override
	public SysRole getObject(SysRole role) {
		String hql = "from SysRole where id = ";
		hql += role.getId();
		Query query = this.getCurrentSession().createQuery(hql);
		return (SysRole) query.list().get(0);
	}

	/**
	 * 获取会员等级
	 * 
	 * @return
	 */
	public List<SysRole> findAppUserRole(Integer groupId) {
		// from SysGroup g join g.roles r where g.id=?
		String hql = "from SysRole where groupId = ";
		hql += groupId;
		return this.find(hql);
	}
	/**
	 * 获取非会员等级角色
	 * 
	 * @return
	 */
	public List<SysRole> findSysUserRole(Integer groupId) {
		// from SysGroup g join g.roles r where g.id=?
		String hql = "from SysRole where groupId <> ";
		hql += groupId;
		return this.find(hql);
	}

	/**
	 * 获取角色被使用次数
	 */
	public List<Map<String, Object>> getRoleBeenUsedCnt() {
		StringBuilder sqlBuff = new StringBuilder(500);
		sqlBuff.setLength(0);
		sqlBuff.append("select a.id, nvl(b.cnt, 0) as cnt ");
		sqlBuff.append("  from t_sys_role a ");
		sqlBuff.append("  left join (select role_id, count(1) cnt ");
		sqlBuff.append("               from t_sys_user_role ");
		sqlBuff.append("              group by role_id) b on a.id = b.role_id");

		List<Map<String, Object>> list = jdbcTemplate.queryForList(sqlBuff
				.toString());

		return list;
	}

	/**
	 * 获取角色用户的个数
	 * 
	 * @param roleName
	 * @param startTime
	 * @param endTime
	 * @param userId
	 * @return
	 */
	public int getpage(String roleName, String startTime, String endTime,
			String userId, String provId) {
		// 登录用户对象
		StringBuilder sqlBuff = new StringBuilder(500);

		sqlBuff.setLength(0);
		sqlBuff.append("select count(1) ");
		sqlBuff.append("  from t_sys_role ");
		sqlBuff.append(" where 1=1 ");

		Object[] p = new Object[] {};

		// // 加入登录用户查看角色列表限制,超级管理员可以看到全部
		// if (!Const.SUPER_ADMIN_ID_LIST.contains(userId)) {
		// sqlBuff.append(" and update_user_id = ? ");
		// p = ArrayUtils.add(p, userId);
		// }

		if (StringUtils.isNotBlank(roleName)) {
			sqlBuff.append(" and ( name like ? or remark like ? )");
			p = ArrayUtils.add(p, "%" + roleName + "%");
			p = ArrayUtils.add(p, "%" + roleName + "%");
		}

		if (StringUtils.isNotBlank(startTime)) {
			sqlBuff.append(" and update_time >= ?");
			p = ArrayUtils.add(p, startTime + "000000");
		}

		if (StringUtils.isNotBlank(endTime)) {
			sqlBuff.append(" and update_time <= ?");
			p = ArrayUtils.add(p, endTime + "235959");
		}
		if (StringUtils.isNotBlank(provId)) {
			sqlBuff.append(" and rel_prov = ?");
			p = ArrayUtils.add(p, provId);
		}

		int num = jdbcTemplate.queryForInt(sqlBuff.toString(), p);
		return num;
	}

	/**
	 * 获取角色列表信息
	 * 
	 * @param roleName
	 * @param startTime
	 * @param endTime
	 * @param userId
	 * @return
	 */
	public List<Map<String, Object>> getRoleList(String roleName,
			String startTime, String endTime, String userId, String provId,
			int startNo, int endNo) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// 登录用户对象
		StringBuilder sqlBuff = new StringBuilder(500);

		sqlBuff.setLength(0);

		sqlBuff.append("select role.id, ");
		sqlBuff.append("       role.name, ");
		sqlBuff.append("       role.remark, ");
		sqlBuff.append("       role.update_user_id, ");
		sqlBuff.append("       role.update_time, ");
		sqlBuff.append("       prov.prov_name ");
		sqlBuff.append("  from t_sys_role role, t_sys_province prov ");
		sqlBuff.append(" where 1 = 1 ");
		sqlBuff.append("   and prov.id = role.rel_prov");

		Object[] p = new Object[] {};
		//
		// // 加入登录用户查看角色列表限制,超级管理员可以看到全部
		// if (!Const.SUPER_ADMIN_ID_LIST.contains(userId)) {
		// sqlBuff.append(" and role.update_user_id = ? ");
		// p = ArrayUtils.add(p, userId);
		// }

		if (StringUtils.isNotBlank(roleName)) {
			sqlBuff.append(" and ( role.name like ? or role.remark like ? )");
			p = ArrayUtils.add(p, "%" + roleName + "%");
			p = ArrayUtils.add(p, "%" + roleName + "%");
		}

		if (StringUtils.isNotBlank(startTime)) {
			sqlBuff.append(" and role.update_time >= ?");
			p = ArrayUtils.add(p, startTime + "000000");
		}

		if (StringUtils.isNotBlank(endTime)) {
			sqlBuff.append(" and role.update_time <= ?");
			p = ArrayUtils.add(p, endTime + "235959");
		}
		if (StringUtils.isNotBlank(provId)) {
			sqlBuff.append(" and role.rel_prov like ? ");
			p = ArrayUtils.add(p, provId);
		}
		sqlBuff.append(" order by id desc ");

		// 加上分页参数
		p = ArrayUtils.add(p, endNo);
		p = ArrayUtils.add(p, startNo);

		try {
			list = jdbcTemplate.queryForList(
					SQLPagingUtils.getPagingSQL(sqlBuff.toString()), p);
		} catch (DataAccessException e) {
			logger.info("查询角色列表出现异常。", e);
			throw new SPlatformDaoException("查询角色列表出现异常。", e);
		}

		if (list == null) {
			list = new ArrayList<Map<String, Object>>();
		}
		return list;
	}

	/**
	 * 获取所有角色列表信息
	 * 
	 * @return 角色列表
	 */
	public List<SysRole> getAllRoleList() {

		// 角色列表
		List<SysRole> roleList = new ArrayList<SysRole>();

		// 登录用户对象
		StringBuilder sqlBuff = new StringBuilder(500);

		sqlBuff.setLength(0);
		sqlBuff.append("select id, name, remark, update_user_id, update_time, rel_prov");
		sqlBuff.append("  from t_sys_role ");

		try {
			roleList = jdbcTemplate.query(sqlBuff.toString(),
					new RowMapper<SysRole>() {

						public SysRole mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							SysRole role = new SysRole();

//							role.setId(rs.getString("id"));
//							role.setName(rs.getString("name"));
//							role.setRemark(rs.getString("remark"));
//							role.setUpdateUserId(rs.getString("update_user_id"));
//							role.setRelProv(rs.getLong("rel_prov"));
							return role;
						}
					});
		} catch (DataAccessException e) {
			logger.info("查询地市信息。", e);
			throw new SPlatformDaoException("查询地市信息。", e);
		}

		return roleList;
	}

	/**
	 * 查找角色
	 * @param sRole
	 */
	public List<SysRole> findSysRole(Integer suRoleId) {
		String hql = "from SysRole where id = ";
		hql += suRoleId;
		return this.find(hql);
	}

	
	/**
	 * 获取角色对应操作的按钮
	 * @param roleId
	 * @return
	 */
	public List<Object> getRoleBtns(Integer roleId) {
		String sql = "select o.operate_code from t_sys_role_operate ro,t_sys_operate o where ro.operate_id = o.id and ro.role_id = ?";
		Object[] params = new Object[]{roleId};
		return this.querysqlList(sql, params);
	}
	
	

}
