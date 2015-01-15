/**
 * 
 */
package com.sh.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.manage.dao.SysUserDao;
import com.sh.manage.entity.SysMenu;
import com.sh.manage.entity.SysUser;
import com.sh.manage.pojo.LoginUser;

/**
 * @author
 * 
 */
@Service
public class SystemService extends BaseService {

	@Autowired
	private SysUserDao systemDao;

	public SysUser getUserInfoByUsername(SysUser sysUser) {
		return systemDao.getObject(sysUser);
	}

	/**
	 * 获取用户菜单
	 * @param loginUser
	 * @return
	 */
	public List<SysMenu> getUserMenu(LoginUser loginUser) {
		return systemDao.getUserMenu(loginUser);
	}

	
	
}
