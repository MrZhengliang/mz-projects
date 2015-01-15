/**
 * 
 */
package com.sh.manage.dao;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.sh.manage.entity.AppUser;
import com.sh.manage.entity.SysRole;
import com.sh.manage.entity.SysUser;
import com.sh.manage.module.page.Page;

/**
 * 用户数据访问类
 * 
 * @author
 * 
 */
@Repository
public class AppUserDao extends AbstractBaseDao<AppUser> {

	
	
	/**
	 * 获取全部会员
	 * @param pageSize 
	 * @param pageNo 
	 * 
	 * @return
	 */
	public Page getAllAppUser(Integer roleId,String username,String startDate,String endDate,int status,int pageNo, int pageSize) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("select rt.* from (select s.auid,s.email,s.name,s.username,s.password,s.terminal_id,r.role_name roleName,s.status,s.start_date,s.end_date,r.id role_id,s.last_login_ip,s.limit_year,s.remark from t_sh_user s,t_sys_role r ");
		sbf.append(" where 1 = 1 and s.role_id = r.id ");
		
		Object[] params = new Object[]{};
		
		if(!StringUtils.isEmpty(username)){
			params = ArrayUtils.add(params, username);
			sbf.append(" and s.username = ?");
		}
		if(!StringUtils.isEmpty(startDate)){
			params = ArrayUtils.add(params, startDate);
			sbf.append(" and s.start_date >= ?");
		}
		if(!StringUtils.isEmpty(endDate)){
			params = ArrayUtils.add(params, endDate);
			sbf.append(" and s.end_date <= ?");
		}
		if(status > 0){
			params = ArrayUtils.add(params, status);
			sbf.append(" and s.status = ?");
		}
		if(roleId > 0){
			params = ArrayUtils.add(params, roleId);
			sbf.append(" and s.role_id = ?");
		}
		sbf.append(") as rt");
		return this.queryModelListByPage(sbf.toString(), params, pageNo, pageSize, AppUser.class);
	}

	/**
	 * 获取全部系统用户
	 * @param username
	 * @param startDate
	 * @param endDate
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page getAllSysUser(String usercode, String startDate,
			String endDate, Integer pageNo, int pageSize) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("select rt.* from (select s.uid,s.email,s.name,s.usercode,s.password,s.terminal_id,s.valid_time,s.create_time,s.change_pwd_time,s.status,s.lock_status,s.last_login_time,s.last_login_ip,r.role_name roleName,r.id roleId from t_sys_user s left join t_sys_user_role sr on s.uid = sr.user_id left join t_sys_role r on sr.role_id = r.id");
		sbf.append(" where 1 = 1 ");//有效的用户and s.status = 1
		Object[] params = new Object[]{};
		
		if(!StringUtils.isEmpty(usercode)){
			//params = ArrayUtils.add(params, username);
			sbf.append(" and s.username like '%"+usercode+"%'");
		}
		if(!StringUtils.isEmpty(startDate)){
			params = ArrayUtils.add(params, startDate);
			sbf.append(" and s.create_time >= ?");
		}
		if(!StringUtils.isEmpty(endDate)){
			params = ArrayUtils.add(params, endDate);
			sbf.append(" and s.valid_time <= ?");
		}

		sbf.append(") as rt");
		return this.queryModelListByPage(sbf.toString(), params, pageNo, pageSize, SysUser.class);
	}
	
	
	
	
	
	
	@Override
	public void addObject(AppUser user) {
		this.getCurrentSession().save(user);
	}

	@Override
	public void updateObject(AppUser user) {
		this.getCurrentSession().save(user);
	}

	@Override
	public void deleteObject(AppUser user) {
		this.getCurrentSession().delete(user);
	}

	@Override
	public AppUser getObject(AppUser user) {
		String hql = "from User where email=?";
		hql += user.getEmail();
		Query query = this.getCurrentSession().createQuery(hql);
		return (AppUser) query.list().get(0);
	}

	/**
	 * 用户角色列表
	 */
	public List<SysRole> getUserRole(SysUser sysUser) {
		return null;
	}

	/**
	 * 查找某个会员
	 * @param auid
	 */
	public List<AppUser> findAppUser(Integer auid) {
		String hql = "from AppUser where auid = ";
		hql += auid;
		return this.find(hql);
	}
	
}
