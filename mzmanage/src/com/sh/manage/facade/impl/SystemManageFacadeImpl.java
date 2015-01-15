package com.sh.manage.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.manage.entity.AppUser;
import com.sh.manage.entity.SysGroup;
import com.sh.manage.entity.SysRole;
import com.sh.manage.exception.SPlatformServiceException;
import com.sh.manage.facade.SystemManageFacade;
import com.sh.manage.service.GroupService;
import com.sh.manage.service.RoleService;
import com.sh.manage.service.UserService;

/**
 * 外观模式的使用
 * @author fuzl
 *
 */
@Service
public class SystemManageFacadeImpl implements SystemManageFacade{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GroupService groupService;
	
	@Autowired
	private RoleService roleService;

	@Override
	public List<AppUser> findAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addUser(AppUser user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(AppUser user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AppUser getOneUser(AppUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delUser(AppUser user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SysGroup> findAllGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysGroup> getGroupRoles(Integer groupIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRole(SysRole role) throws SPlatformServiceException {
		// TODO Auto-generated method stub
		
	}
	
	
}
