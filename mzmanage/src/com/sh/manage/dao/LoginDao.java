package com.sh.manage.dao;

/**
 * Title. XX类<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2014年11月30日
 * <p>
 * Company: ff
 * <p>
 * Author: fuzl
 * <p>
 * Version: 1.0
 * <p>
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sh.manage.constants.SessionConstants;
import com.sh.manage.entity.SysMenu;
import com.sh.manage.entity.SysUser;
import com.sh.manage.exception.SPlatformDaoException;
import com.sh.manage.security.MD5;
import com.sh.manage.utils.TimeUtil;

/**
 * 登录的数据操作 <br>
 * 类详细说明.
 * <p>
 * <p>
 * 
 * @author 
 * @version 1.0.0
 */
@Repository
public class LoginDao {

	/** 日志记录者 */
	private static Log logger = LogFactory.getLog(LoginDao.class);

	/** JDBC模板 */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * 获得用户对应的菜单列表
	 * 
	 * @param userId
	 *            为0表示超级管理员
	 * @return
	 */
	public List<Map<String, Object>> getMenuList(Integer userId) {
		StringBuilder sqlBuff = new StringBuilder();
		Object[] params = new Object[] {};

		sqlBuff.append("select id,");
		sqlBuff.append("       menu_name,");
		sqlBuff.append("       menu_code,");
		sqlBuff.append("       menu_pid,");
		sqlBuff.append("       menu_url,");
		sqlBuff.append("       leaf_yn,");
		sqlBuff.append("       menu_btns ");
		sqlBuff.append("  from t_sys_menu");
		sqlBuff.append(" where 1=1 ");// 获得后台管理菜单

		// 如果是超级管理员则可以查看到所有菜单权限
		if (!SessionConstants.SUPER_ADMIN_ID_LIST.contains(userId)) {
			sqlBuff.append(" and id in ( ");
			sqlBuff.append("select distinct menu_id");
			sqlBuff.append("  from t_sys_group_menu");
			sqlBuff.append(" where group_id in (select group_id from t_sys_user_role tur,t_sys_role tr where tur.role_id = tr.id and tur.user_id = ?) ");
			sqlBuff.append(" ) ");

			params = ArrayUtils.add(params, userId);
		}

		sqlBuff.append("order by id ");
		
		//oracle使用
//		sqlBuff.append("  start with   menu_pcode = '0' ");
//		sqlBuff.append("connect by  menu_pcode=PRIOR menu_code ");
//		sqlBuff.append("order by menu_code ");

		return jdbcTemplate.queryForList(sqlBuff.toString(), params);
	}

	
	
	/**
	 * 获得用户对应的权限操作列表
	 * 
	 * @param userId
	 *            为0表示超级管理员
	 * @return
	 */
	public List<Map<String, Object>> getSoperList(Integer userId) {
		StringBuilder sqlBuff = new StringBuilder();
		Object[] params = new Object[] {};

		sqlBuff.append("select id,");
		sqlBuff.append("       operate_code,");
		sqlBuff.append("       operate_name");
		sqlBuff.append("  from t_sys_operate");
		sqlBuff.append(" where 1=1 ");// 获得后台管理菜单

		// 如果是超级管理员则可以查看到所有菜单权限
		if (!SessionConstants.SUPER_ADMIN_ID_LIST.contains(userId)) {
			sqlBuff.append(" and id in ( ");
			sqlBuff.append("select distinct operate_id");
			sqlBuff.append("  from t_sys_role_operate");
			sqlBuff.append(" where role_id in (select role_id from t_sys_user_role tur where tur.user_id = ?) ");
			sqlBuff.append(" ) ");

			params = ArrayUtils.add(params, userId);
		}

		sqlBuff.append("order by id ");
		
		//oracle使用
//		sqlBuff.append("  start with   menu_pcode = '0' ");
//		sqlBuff.append("connect by  menu_pcode=PRIOR menu_code ");
//		sqlBuff.append("order by menu_code ");

		return jdbcTemplate.queryForList(sqlBuff.toString(), params);
	}
	
	
	
	/***************************************************************************
	 * —— 获得角色对应的权限菜单列表
	 * 
	 * @param roleId
	 * @return
	 */
	public List<Map<String, Object>> getRolePrivilegeList(String roleId) {
		StringBuilder sqlBuff = new StringBuilder(500);

		// 获得角色对应权限列表
		sqlBuff.setLength(0);
		sqlBuff.append("select distinct menu_code, menu_btn ");
		sqlBuff.append("  from t_sys_role_list ");
		sqlBuff.append(" where role_id = ? order by menu_code asc ");

		return jdbcTemplate.queryForList(sqlBuff.toString(), roleId);
	}

	

	/**
	 * 根据用户的UserCode，获取用户对象的信息
	 * 
	 * @param userCode
	 *            用户账号
	 * @return 返回用户对象
	 */
	public SysUser getUserByCode(String userCode) {
		StringBuilder sqlBuff = new StringBuilder(500);

		sqlBuff.setLength(0);
		sqlBuff.append("select id, ");
		sqlBuff.append("user_code, ");
		sqlBuff.append("user_pwd, ");
		sqlBuff.append("user_name, ");
		sqlBuff.append("terminal_id, ");
		sqlBuff.append("email, ");
		sqlBuff.append("remark, ");
		sqlBuff.append("valid_time, ");
		sqlBuff.append("create_time, ");
		sqlBuff.append("change_pwd_time, ");
		sqlBuff.append("update_time, ");
		sqlBuff.append("update_user_id, ");
		sqlBuff.append("lock_status, ");
		sqlBuff.append("status, ");
		sqlBuff.append("flag, ");
		sqlBuff.append("unit_id ");
		sqlBuff.append("from t_sys_user ");
		sqlBuff.append("where user_code = ?");

		List<SysUser> userList = null;
		try {
			userList = jdbcTemplate.query(sqlBuff.toString(), new RowMapper<SysUser>() {

				public SysUser mapRow(ResultSet rs, int rowNum) throws SQLException {
					SysUser user = new SysUser();
					user.setUid(Integer.parseInt(rs.getString("uid")));
					user.setPassword(rs.getString("password"));
					user.setUsercode(rs.getString("usercode"));
					user.setTerminalId(rs.getString("terminal_id"));
					user.setEmail(rs.getString("email"));
					user.setValidTime(rs.getString("valid_time"));
					user.setCreateTime(rs.getString("create_time"));
					user.setChangePwdTime(rs.getString("change_pwd_time"));
					user.setLockStatus(Integer.parseInt(rs.getString("lock_status")));
					user.setStatus(Integer.parseInt(rs.getString("status")));
					return user;
				}
			}, userCode);
		}
		catch (DataAccessException e) {
			if (logger.isErrorEnabled()) {
				logger.error("查询用户信息。", e);
			}

			throw new SPlatformDaoException("查询用户信息。", e);
		}

		if (userList == null || userList.size() == 0) {
			return null;
		} else {
			return userList.get(0);
		}
	}

	/**
	 * 根据用户ID获得该用户对应的角色列表
	 * 
	 * @param userId
	 *            用户id
	 * @return
	 */
	public List<Map<String, Object>> getUserRoleList(String userId) {
		StringBuilder sqlBuff = new StringBuilder(500);

		// 获得用户所有角色列表
		sqlBuff.setLength(0);
		sqlBuff.append("select id, role_name, remark, operate_id, create_time,group_id ");
		sqlBuff.append("  from t_sys_role ");
		sqlBuff.append(" where id in (select role_id from t_sys_user_role where user_id = ?) ");

		List<Map<String, Object>> list = jdbcTemplate.queryForList(sqlBuff.toString(), new Object[] { userId });

		return list;
	}

	/**
	 * 获得用户所有角色对应的权限菜单列表
	 * 
	 * @param roleId
	 * @return
	 */
	public List<Map<String, Object>> getUserRolePrivilegeList(String userId) {
		// 获得角色对应权限列表
		StringBuilder sqlBuff = new StringBuilder(500);
		sqlBuff.setLength(0);
		sqlBuff.append("select distinct menu_id, menu_btns ");
		sqlBuff.append("  from t_sys_role_menu ");
		sqlBuff.append(" where role_id in (select role_id from t_sys_user_role where user_id = ?) ");
		sqlBuff.append(" order by menu_id ");

		List<Map<String, Object>> list = jdbcTemplate.queryForList(sqlBuff.toString(), new Object[] { userId });
		return list;
	}

//	/**
//	 * 记录系统日志
//	 * 
//	 * @param sl
//	 * @return
//	 */
//	public boolean insertData(SysLog sl) {
//		StringBuilder sql = new StringBuilder(500);
//		sql.setLength(0);
//		sql.append("insert into t_sys_log ");
//		sql.append("  (id, user_id, op_type, remark, ip, op_time, sys_type, module) ");
//		sql.append("values ");
//		sql.append("  (seq_sys_log.nextval, ?, ?, ?, ?, ?, 0, ?) ");
//		Object[] p = new Object[] { sl.getUserId(), sl.getOptType(), sl.getRemark(), sl.getIp(), TimeUtil.now(), sl.getModule() };
//		int ret = jdbcTemplate.update(sql.toString(), p);
//		return (-1 == ret) ? false : true;
//	}

	/**
	 * 根据用户的用户名，锁定用户账号
	 * 
	 * @param userCode
	 *            用户名
	 * @return
	 */
	public int lockUser(String userCode) {
		int affCnt = 0;
		StringBuilder sql = new StringBuilder(500);
		sql.setLength(0);
		sql.append("update t_sys_user set lock_status='1' where user_code=? ");
		try {
			affCnt = jdbcTemplate.update(sql.toString(), userCode);
		}
		catch (DataAccessException e) {
			if (logger.isErrorEnabled()) {
				logger.error("锁定用户出现异。", e);
			}

			throw new SPlatformDaoException("锁定用户出现异。", e);
		}

		return affCnt;
	}

//	/**
//	 * 记录用户登录日志
//	 * 
//	 * @param userId
//	 *            用户ID
//	 * @param userCode
//	 *            用户编码
//	 * @param userName
//	 *            用户姓名
//	 * @param ip
//	 *            IP地址
//	 * @param loginTime
//	 *            登陆时间
//	 */
//	public int log(String userId, String userCode, String userName, String ip, String loginTime) {
//		int affCnt = 0;
//		StringBuilder sqlBuff = new StringBuilder(500);
//		sqlBuff.append("insert into t_sys_login_log ");
//		sqlBuff.append("  (id, user_id, user_code, user_name, ip, login_time,sys_type) ");
//		sqlBuff.append("values ");
//		sqlBuff.append("  (seq_sys_log.nextval, ?, ?, ?, ?, ?,?) ");
//
//		try {
//			affCnt = jdbcTemplate.update(sqlBuff.toString(), new Object[] { userId, userCode, userName, ip, loginTime });
//
//		}
//		catch (DataAccessException e) {
//			if (logger.isErrorEnabled()) {
//				logger.error("锁定用户出现异。", e);
//			}
//
//			throw new SPlatformDaoException("锁定用户出现异。", e);
//		}
//		return affCnt;
//	}

	/**
	 * 记录用户登录错误的信息
	 * 
	 * @param userCode
	 *            用户名
	 * @param ip
	 *            ip地址
	 * @return
	 */
	public int logErr(String userCode, String ip) {
		StringBuilder sql = new StringBuilder(500);
		sql.append("insert into t_sys_logon_log ");
		sql.append("  (id, user_code, logon_ip, logon_time,success_tag) ");
		sql.append("values ");
		sql.append("  (seq_sys_log.nextval, ?, ?, ?, '0') ");

		return jdbcTemplate.update(sql.toString(), new Object[] { userCode, ip, TimeUtil.now() });
	}

	/**
	 * @param userCode
	 * @return
	 */
	public int logonErrTimes(String userCode) {
		StringBuilder sqlBuff = new StringBuilder(500);
		sqlBuff.append("select count(*) ");
		sqlBuff.append("  from t_sys_logon_log ");
		sqlBuff.append(" where success_tag = '0' ");
		sqlBuff.append("   and user_code = ? ");
		sqlBuff.append("   and substr(logon_time, 0, 8) = ? ");
		int num = jdbcTemplate.queryForInt(sqlBuff.toString(), userCode, TimeUtil.nowDate());
		return num;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 修改密码
	 * 
	 * @param userId
	 *            用户id
	 * @param pwd
	 *            用户的新密码
	 * @return 返回int值
	 */
	public int updateUserPwd(String userId, String pwd) {
		StringBuilder sqlBuff = new StringBuilder(500);
		sqlBuff.setLength(0);
		sqlBuff.append(" update t_sys_user set user_pwd=?,change_pwd_time=? ");
		sqlBuff.append("  where id = ? ");
		int affCnt = jdbcTemplate.update(sqlBuff.toString(), MD5.digest2Str(pwd), TimeUtil.now(), userId);
		return affCnt;

	}

	/**
	 * 通过pId获取menu
	 * @param id
	 * @return
	 */
	public List<SysMenu> getMenuListByPId(Integer id) {
		
		return null;
	}
}
