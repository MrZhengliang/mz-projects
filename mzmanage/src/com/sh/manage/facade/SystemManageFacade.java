package com.sh.manage.facade;

import java.util.List;

import com.sh.manage.entity.AppUser;
import com.sh.manage.entity.SysGroup;
import com.sh.manage.entity.SysRole;
import com.sh.manage.exception.SPlatformServiceException;

public interface SystemManageFacade {

	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<AppUser> findAllUser();

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public boolean addUser(AppUser user);
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	public boolean updateUser(AppUser user);

	/**
	 * 获取单个用户
	 * @param user
	 * @return
	 */
	public AppUser getOneUser(AppUser user);

	public boolean delUser(AppUser user);
	
	/**
	 * 获取所有组
	 */
	public List<SysGroup> findAllGroups() ;

	/**
	 * 获取组对应的角色列表
	 * @param groupIndex
	 * @return
	 */
	public List<SysGroup> getGroupRoles(Integer groupIndex);

	/**
	 * 角色添加
	 * @param role
	 * @throws SPlatformServiceException 
	 */
	public void addRole(SysRole role) throws SPlatformServiceException;
}
