/**
 * 
 */
package com.sh.manage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sh.manage.entity.SysMenu;
import com.sh.manage.entity.SysUser;
import com.sh.manage.pojo.LoginUser;

/**
 * @author 
 *
 */
@Repository
public class SysUserDao extends AbstractBaseDao<SysUser>{

	@Override
	public void addObject(SysUser clazz) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateObject(SysUser clazz) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteObject(SysUser clazz) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SysUser getObject(SysUser clazz) {
		return this.get("from SysUser s where s.usercode = ? and s.password = ?", new Object[]{clazz.getUsercode(),clazz.getPassword()});
	}

	/**
	 * 查找系统用户
	 * @param uid
	 * @return
	 */
	public List<SysUser> findSysUser(Integer uid) {
		String hql = "from SysUser where uid = ";
		hql += uid;
		return this.find(hql);
	}

	
	/**
	 * 
	 * @param loginUser
	 * @return
	 */
	public List<SysMenu> getUserMenu(LoginUser loginUser) {
		return null;
	}

	

}
