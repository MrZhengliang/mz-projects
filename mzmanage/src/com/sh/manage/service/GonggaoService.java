/**
 * 
 */
package com.sh.manage.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.manage.dao.AppUserDao;
import com.sh.manage.dao.SysUserDao;
import com.sh.manage.entity.AppUser;
import com.sh.manage.entity.SysRole;
import com.sh.manage.entity.SysUser;
import com.sh.manage.exception.SPlatformServiceException;
import com.sh.manage.module.page.Page;

/**
 * @author
 * 
 */
@Service
public class GonggaoService extends BaseService {

	private Logger logger = Logger.getLogger(GonggaoService.class);
	
	@Autowired
	private AppUserDao appUserDao;

	@Autowired
	private SysUserDao sysUserDao;

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean addUser(AppUser user) {
		return false;
	}

	/**
	 * 更新用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean updateUser(AppUser user) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 获取单个用户
	 * 
	 * @param user
	 * @return
	 */
	public AppUser getOneUser(AppUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delUser(AppUser user) {
		// TODO Auto-generated method stub
		return false;
	};

	/**
	 * 获取对应角色权限信息
	 */
	@SuppressWarnings("unused")
	public List<SysRole> getUserRole(SysUser sysUser) {
		List<SysRole> sysRoleList = appUserDao.getUserRole(sysUser);
		return null;
	}

	/**
	 * 查找会员
	 * @param aUser
	 */
	public AppUser findAppUser(Integer auid)throws SPlatformServiceException {
		try {
			List<AppUser> appUserList = appUserDao.findAppUser(auid);
			//找到了会员
			if(null != appUserList){
				return appUserList.get(0);
			}
			//找不到会员
			return new AppUser();
		} catch (Exception e) {
			logger.error("service:查询会员信息出现异常", e);
			throw new SPlatformServiceException("查询会员信息出现异常");
		}
	}
	
	/**
	 * 添加会员
	 * @param aUser
	 */
	public void addAppUser(AppUser aUser)throws SPlatformServiceException {
		try {
			appUserDao.save(aUser);
		} catch (Exception e) {
			logger.error("service:添加会员信息出现异常", e);
			throw new SPlatformServiceException("添加会员信息出现异常");
		}
	}
	/**
	 * 查询所有会员
	 * @param pageSize 
	 * @param pageNo 
	 * 
	 * @return
	 */
	public Page findAllAppUser(Integer roleId,String username,String startDate,String endDate,int status,int pageNo, int pageSize) {
		return appUserDao.getAllAppUser(roleId,username,startDate,endDate,status,pageNo,pageSize);
	}
	
	/**
	 * 查询所有系统用户
	 * @param pageSize 
	 * @param pageNo 
	 * 
	 * @return
	 */
	public Page findAllSysUser(String usercode, String startDate,
			String endDate, Integer pageNo, int pageSize) {
		return appUserDao.getAllSysUser(usercode,startDate,endDate,pageNo,pageSize);
	}

	/**
	 * 会员信息修改
	 * @param aUser
	 */
	public void editAppUser(AppUser aUser) {
		appUserDao.update(aUser);
	}

	/**
	 * 会员信息删除
	 * @param aUser
	 */
	public void delAppUser(AppUser aUser) {
		appUserDao.delete(aUser);
	}

	
	
	/**
	 * 查找系统用户
	 * @param sUser
	 */
	public SysUser findSysUser(Integer uid)throws SPlatformServiceException {
		try {
			List<SysUser> sysUserList = sysUserDao.findSysUser(uid);
			//找到了用户
			if(null != sysUserList){
				return sysUserList.get(0);
			}
			//找不到用户
			return new SysUser();
		} catch (Exception e) {
			logger.error("service:查询系统用户信息出现异常", e);
			throw new SPlatformServiceException("查询系统用户信息出现异常");
		}
	}
	/**
	 * 系统用户添加
	 * @param sUser
	 */
	public void addSysUser(SysUser sUser) {
		sysUserDao.save(sUser);
	}
	/**
	 * 系统用户修改
	 * @param sUser
	 */
	public void editSysUser(SysUser sUser) {
		sysUserDao.update(sUser);
	}

	/**
	 * 系统用户删除
	 * @param sUser
	 */
	public void delSysUser(SysUser sUser) {
		sysUserDao.delete(sUser);
	}

}
