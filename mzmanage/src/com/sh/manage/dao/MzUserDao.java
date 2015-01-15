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
import com.sh.manage.entity.TMzUser;
import com.sh.manage.module.page.Page;

/**
 * 用户数据访问类
 * 
 * @author
 * 
 */
@Repository
public class MzUserDao extends AbstractBaseDao<TMzUser> {

	
	
	/**
	 * 获取全部会员
	 * @param pageSize 
	 * @param pageNo 
	 * 
	 * @return
	 */
	public Page getAllMzUser(Integer roleId,String username,String startDate,String endDate,int status,int pageNo, int pageSize) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("select rt.* from (select s.uid,s.email,s.nickname,s.username,s.password,s.status,s.emailstatus,s.avatarstatus,s.grade,s.adminid,s.groupid,s.credits,s.regdate,s.timeoffset,s.conisbind,s.provincecode"
				+ ",s.provincename,s.citycode,s.cityname,s.sex,s.userintro,g.name groupName from t_mz_user s,t_mz_group g ");
		sbf.append(" where 1 = 1 and s.groupid = g.id ");
		
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
		return this.queryModelListByPage(sbf.toString(), params, pageNo, pageSize, TMzUser.class);
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
	public void addObject(TMzUser user) {
		this.getCurrentSession().save(user);
	}

	@Override
	public void updateObject(TMzUser user) {
		this.getCurrentSession().save(user);
	}

	@Override
	public void deleteObject(TMzUser user) {
		this.getCurrentSession().delete(user);
	}

	@Override
	public TMzUser getObject(TMzUser user) {
		String hql = "from User where email=?";
		hql += user.getEmail();
		Query query = this.getCurrentSession().createQuery(hql);
		return (TMzUser) query.list().get(0);
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
	public List<TMzUser> findMzUser(Integer auid) {
		String hql = "from TMzUser where uid = ";
		hql += auid;
		return this.find(hql);
	}
	
}
