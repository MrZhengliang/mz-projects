/**
 * 
 */
package com.sh.manage.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sh.manage.dao.RoleDao;
import com.sh.manage.entity.SysRole;
import com.sh.manage.exception.SPlatformServiceException;

/**
 * 
 * 角色服务类
 * 
 * @author
 * 
 */
@Service
public class RoleService extends BaseService {

	private Logger logger = Logger.getLogger(RoleService.class);

	@Autowired
	private RoleDao roleDao;

	/** 每页显示行数 */
	private static final int ROW_CNT_PER_PAGE = 20;
	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<SysRole> findAllRoles() {
		return roleDao.getAllRoles();
	}

	/**
	 * 查找角色
	 * @param sRole
	 */
	public SysRole findSysRole(Integer suRoleId)throws SPlatformServiceException {
		try {
			List<SysRole> sysRoleList = roleDao.findSysRole(suRoleId);
			//找到了角色
			if(null != sysRoleList){
				return sysRoleList.get(0);
			}
			//找不到角色
			return new SysRole();
		} catch (Exception e) {
			logger.error("service:查询系统角色信息出现异常", e);
			throw new SPlatformServiceException("查询系统角色信息出现异常");
		}
	}
	/**
	 * 添加角色
	 * 
	 * @param role
	 */
	public void addRole(SysRole role) throws SPlatformServiceException {
		try {
			roleDao.save(role);
		} catch (Exception e) {
			logger.error("service:添加角色信息出现异常", e);
			throw new SPlatformServiceException("添加角色信息出现异常");
		}
	}

	/**
	 * 编辑角色
	 * 
	 * @param role
	 * @throws SPlatformServiceException 
	 */
	public void editRole(SysRole role) throws SPlatformServiceException {
		try {
			roleDao.update(role);
		} catch (Exception e) {
			logger.error("service:编辑角色信息出现异常", e);
			throw new SPlatformServiceException("编辑角色信息出现异常");
		}
	}
	/**
	 * 删除角色
	 * 
	 * @param role
	 * @throws SPlatformServiceException 
	 */
	public void delRole(SysRole role) throws SPlatformServiceException {
		try {
			roleDao.delete(role);
		} catch (Exception e) {
			logger.error("service:删除角色信息出现异常", e);
			throw new SPlatformServiceException("删除角色信息出现异常");
		}
	}

	/**
	 * 获取会员等级
	 * @return
	 */
	public List<SysRole> findAppUserRole(Integer groupId) {
		return roleDao.findAppUserRole(groupId);
	};
	
	/**
	 * 获取非会员等级角色
	 * @return
	 */
	public List<SysRole> findSysUserRole(Integer groupId) {
		return roleDao.findSysUserRole(groupId);
	};
	
	/**
	 * 获取用户列表
	 * 
	 * @param userId
	 * @return
	 */
	@Transactional(readOnly = true)
	public void getRoleList(String roleName, String startTime, String endTime, String userId, String provId, int page, Map<String, Object> model) {
		if (logger.isDebugEnabled()) {
			logger.info("根据用户id获取角色列表开始!");
		}
		// 获取角色使用的次数
		List<Map<String, Object>> cntList = roleDao.getRoleBeenUsedCnt();
		Map<Object, Integer> rtnVal = new HashMap<Object, Integer>();

		for (Map<String, Object> item : cntList) {
			rtnVal.put(item.get("id"), Integer.parseInt(item.get("cnt").toString()));
		}

		// 获取记录的条数
		int totalCnt = roleDao.getpage(roleName, startTime, endTime, userId, provId);

		// 商户总数和每页显示数
		model.put("tcnt", totalCnt);
		model.put("pcnt", ROW_CNT_PER_PAGE);

		if (totalCnt > 0) {
			// 开始和结束行号
			int startNo = (page - 1) * ROW_CNT_PER_PAGE + 1;
			int endNo = startNo + ROW_CNT_PER_PAGE - 1;

			// 查询列表数据
			List<Map<String, Object>> roleList = roleDao.getRoleList(roleName, startTime, endTime, userId, provId, startNo, endNo);

			// 角色列表
			model.put("roleList", roleList);
			model.put("rtnVal", rtnVal);
		}

		if (logger.isDebugEnabled()) {
			logger.info("根据用户id获取角色列表结束!");
		}

	}
	/**
	 * 获取所有角色列表
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<SysRole> getAllRoleList() {

		if (logger.isDebugEnabled()) {
			logger.info("查询所有角色列表!");
		}

		List<SysRole> roleList = roleDao.getAllRoleList();

		if (logger.isDebugEnabled()) {
			logger.info("查询所有角色列表!");
		}

		return roleList;
	}
	
	
	/**
	 * 获取角色操作按钮
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Object> getRoleBtns(Integer roleId) throws SPlatformServiceException {
		if (logger.isDebugEnabled()) {
			logger.info("查询角色操作按钮!");
		}
		List<Object> roleBtns = roleDao.getRoleBtns(roleId);
		if(null != roleBtns && roleBtns.size() > 0){
			return roleBtns;
		}
		return new ArrayList<Object>(); 
	}

	/**
	 * 修改角色按钮
	 * @param newBtnStr
	 */
	public void editRoleBtns(String newBtnStr) {
		
	}

	
	
}
