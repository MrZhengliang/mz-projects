/**
 * 
 */
package com.sh.manage.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sh.manage.dao.GroupDao;
import com.sh.manage.entity.AppUser;
import com.sh.manage.entity.SysGroup;
import com.sh.manage.entity.SysRole;
import com.sh.manage.exception.SPlatformServiceException;
import com.sh.manage.module.page.Page;


/**
 * @author 
 *
 */
@Service
public class GroupService extends BaseService{
	
	private Logger logger = Logger.getLogger(GroupService.class);

	@Autowired
	private GroupDao groupDao;
	/**
	 * 查询所有
	 * @return
	 */
	public List<SysGroup> findAll(){
		return groupDao.getAllGroups();
	}

	/**
	 * 添加组
	 * @param group
	 * @return
	 */
	public void addGroup(SysGroup group) {
		//groupDao;
	}
	/**
	 * 更新组
	 * @param group
	 * @return
	 */
	public boolean updateGroup(SysGroup group) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 获取单个组
	 * @param group
	 * @return
	 */
	public AppUser getOneGroup(SysGroup group) {
		return null;
	}

	public boolean delGroup(SysGroup group) {
		return false;
	};
	
	
	
	/**
	 * 获取组对应角色信息
	 */
	public List<SysRole> getGroupRole(SysGroup sysGroup){
		List<SysRole> sysRoleList = groupDao.getRoleRole(sysGroup);
		return sysRoleList;
	}

	/**
	 * 获取对应的角色列表
	 * @param pageSize 
	 * @param pageNo 
	 */
	public Page getGroupRoles(Integer groupIndex, Integer pageNo, int pageSize) {
		Page page = groupDao.getGroupRoles(groupIndex,pageNo,pageSize);
		return page;
	}

	/**
	 * 组织信息i修改
	 * @param group
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {SPlatformServiceException.class})
	public void updateGroupInfo(SysGroup group) {
		groupDao.update(group);
	}
	
	
	/**
	 * 查询组织
	 * @param groupId
	 * @return
	 * @throws SPlatformServiceException 
	 */
	public SysGroup findSysGroup(Integer groupId) throws SPlatformServiceException{
		try {
			List<SysGroup> sysGroupList = groupDao.findSysGroup(groupId);
			//找到了组织
			if(null != sysGroupList){
				return sysGroupList.get(0);
			}
			//找不到组织
			return new SysGroup();
		} catch (Exception e) {
			logger.error("service:查询组织信息出现异常", e);
			throw new SPlatformServiceException("查询组织信息出现异常");
		}
	}

	/**
	 * 获取组织
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page getGroups(Integer pageNo, int pageSize) {
		Page page = groupDao.getGroups(pageNo,pageSize);
		return page;
	}
}
