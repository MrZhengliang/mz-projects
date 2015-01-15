package com.sh.manage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sh.manage.dao.LoginDao;
import com.sh.manage.dao.MenuDao;
import com.sh.manage.entity.SysMenu;
import com.sh.manage.entity.SysOperate;
import com.sh.manage.entity.SysUser;
import com.sh.manage.exception.SPlatformServiceException;
import com.sh.manage.module.page.ZTreeNode;
import com.sh.manage.pojo.SysRolePrivilege;
import com.sh.manage.pojo.TSysRole;
import com.sh.manage.utils.StringUtil;

/**
 * 登录的Service. <br>
 * 类详细说明.
 * <p>
 * <p>
 * <p>
 * 
 * @version 1.0.0
 */
@Service
public class LoginService {

	/** 日志记录 */
	private static Log logger = LogFactory.getLog(LoginService.class);

	/** 主数据访问类 */
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private MenuDao menuDao;



	

	/**
	 * 根据用户id，获取菜单列表
	 * 
	 * @param userId
	 *            用户id
	 * @return List<SysMenu>的集合对象
	 */
	@Transactional(readOnly = true)
	public List<SysMenu> getMenuList(Integer userId) {
		if (logger.isDebugEnabled()) {
			logger.info("根据用户id，获取菜单列表开始!");
		}
		List<SysMenu> menuList = new ArrayList<SysMenu>();
		List<Map<String, Object>> mapList = loginDao.getMenuList(userId);
		for (Map<String, Object> object : mapList) {
			SysMenu bean = new SysMenu();
			bean.setId(StringUtil.getInt(object.get("id"),1));
			bean.setMenuCode(StringUtil.getString(object.get("menu_code")));
			bean.setMenuName(StringUtil.getString(object.get("menu_name")));
			bean.setMenuPid(StringUtil.getInt(object.get("menu_pid"),0));
			bean.setMenuUrl(StringUtil.getString(object.get("menu_url")));
			bean.setLeafYn(StringUtil.getInt(object.get("leaf_yn"),0));
			bean.setMenuBtns(StringUtil.getString(object.get("menu_btns")));
			menuList.add(bean);
		}

		if (logger.isDebugEnabled()) {
			logger.info("根据用户id，获取菜单列表开始!");
		}
		return menuList;
	}

	
	/**
	 * 根据用户id，获取权限操作列表
	 * 
	 * @param userId
	 *            用户id
	 * @return List<SysMenu>的集合对象
	 */
	@Transactional(readOnly = true)
	public List<SysOperate> getSoperList(Integer userId) {
		if (logger.isDebugEnabled()) {
			logger.info("根据用户id，获取权限操作列表开始!");
		}
		List<SysOperate> soperList = new ArrayList<SysOperate>();
		List<Map<String, Object>> mapList = loginDao.getSoperList(userId);
		for (Map<String, Object> object : mapList) {
			SysOperate bean = new SysOperate();
			bean.setId(StringUtil.getInt(object.get("id"),1));
			bean.setOperateCode(StringUtil.getString(object.get("operate_code")));
			bean.setOperateName(StringUtil.getString(object.get("operate_name")));
			soperList.add(bean);
		}

		if (logger.isDebugEnabled()) {
			logger.info("根据用户id，获取菜单列表开始!");
		}
		return soperList;
	}
	
	
	/**
	 * 根据用户id,获取菜单信息
	 * 
	 * @param userId
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getMenuMap(Integer userId) {
		if (logger.isDebugEnabled()) {
			logger.info("根据角色id获取菜单列表开始!");
		}
		List<Map<String, Object>> menuList = loginDao.getMenuList(userId);
		if (logger.isDebugEnabled()) {
			logger.info("根据角色id获取菜单列表开始!");
		}
		return menuList;
	}

	/**
	 * 根据用户的角色id，获取角色列表
	 * 
	 * @param roleId
	 *            角色id
	 * @return 返回 角色列表的集合
	 */
	@Transactional(readOnly = true)
	public List<SysRolePrivilege> getRolePrivilegeList(String roleId) {

		if (logger.isDebugEnabled()) {
			logger.info("根据角色id获取角色列表开始!");
		}
		List<SysRolePrivilege> srpList = new ArrayList<SysRolePrivilege>();
		List<Map<String, Object>> list = loginDao.getRolePrivilegeList(roleId);
		for (Map<String, Object> map : list) {
			SysRolePrivilege pribilege = new SysRolePrivilege();
			pribilege.setMenuId(StringUtil.getString(map.get("menu_code")));
			pribilege.setMenuBtn(StringUtil.getString(map.get("menu_btn")));
			srpList.add(pribilege);
		}

		if (logger.isDebugEnabled()) {
			logger.info("根据角色id获取角色列表结束!");
		}
		return srpList;
	}

	

	@Transactional(readOnly = true)
	public SysUser getUserByCode(String userCode) {
		if (logger.isDebugEnabled()) {
			logger.info("获取用户信息开始!");
		}
		SysUser user = loginDao.getUserByCode(userCode);

		if (logger.isDebugEnabled()) {
			logger.info("获取用户信息结束!");
		}
		return user;
	}

	/**
	 * 根据用户id，获取用户的角色列表
	 * 
	 * @param userId
	 *            用户id
	 * @return 返回 用户的角色列表的集合
	 */
	@Transactional(readOnly = true)
	public List<TSysRole> getUserRoleList(String userId) {
		if (logger.isDebugEnabled()) {
			logger.info("获取用户角色开始!");
		}
		List<TSysRole> roleList = new ArrayList<TSysRole>();

		List<Map<String, Object>> list = loginDao.getUserRoleList(userId);
		for (Map<String, Object> dMap : list) {
			TSysRole role = new TSysRole();
			role.setId(Integer.parseInt(StringUtil.getString(dMap.get("ID"))));
			role.setRoleName(StringUtil.getString(dMap.get("ROLE_NAME")));
			role.setRemark(StringUtil.getString(dMap.get("REMARK")));
			role.setOperateId(Integer.parseInt(StringUtil.getString(dMap.get("OPERATE_ID"))));
			role.setCreateTime(StringUtil.getString(dMap.get("CREATE_TIME")));

			// 获得该角色对应的权限菜单列表
			role.setSrpList(getRolePrivilegeList(""+role.getId()));

			roleList.add(role);
		}

		if (logger.isDebugEnabled()) {
			logger.info("获取用户角色结束!");
		}
		return roleList;

	}

	/**
	 * 根据用户id，获取用户菜单的权限列表
	 * 
	 * @param userId
	 *            用户id
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<SysRolePrivilege> getUserRolePrivilegeList(String userId) {
		if (logger.isDebugEnabled()) {
			logger.info("根据用户id，获取用户的权限列表开始!");
		}
		List<SysRolePrivilege> list = new ArrayList<SysRolePrivilege>();
		List<Map<String, Object>> mapList = loginDao
				.getUserRolePrivilegeList(userId);
		for (Map<String, Object> object : mapList) {
			SysRolePrivilege bean = new SysRolePrivilege();
			bean.setMenuId(StringUtil.getString(object.get("menu_id")));
			bean.setMenuBtn(StringUtil.getString(object.get("menu_btn")));
			list.add(bean);
		}

		if (logger.isDebugEnabled()) {
			logger.info("根据用户id，获取用户的权限列表结束!");
		}
		return list;
	}

	/**
	 * 根据用户名，锁定用户账号
	 * 
	 * @param userCode
	 *            用户名
	 */
	public void lockUser(String userCode) {
		if (logger.isDebugEnabled()) {
			logger.info("锁定用户信息开始!");
		}
		loginDao.lockUser(userCode);

		if (logger.isDebugEnabled()) {
			logger.info("锁定用户信息结束!");
		}

	}

	/**
	 * 记录日志信息
	 * 
	 * @param user
	 *            用户对象
	 * @param request
	 *            request请求
	 */
//	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
//	public void log(SysUser user, HttpServletRequest request) {
//		if (logger.isDebugEnabled()) {
//			logger.info("获取登录的信息开始!");
//		}
//		loginDao.log(user.getUid(), user.getUserCode(), user.getUserName(),
//				request.getRemoteHost(), TimeUtil.now());
//
//		if (logger.isDebugEnabled()) {
//			logger.info("获取登录的信息开始!");
//		}
//	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void logErr(String userCode, String ip) {
		if (logger.isDebugEnabled()) {
			logger.info("记录登录错误信息开始!");
		}
		loginDao.logErr(userCode, ip);

		if (logger.isDebugEnabled()) {
			logger.info("记录登录错误信息结束!");
		}
	}

	/**
	 * 根据用户名，获取当天用户登录错误的次数
	 * 
	 * @param userCode
	 *            用户名
	 * @return 返回错误的登录次数
	 */
	@Transactional(readOnly = true)
	public int logonErrTimes(String userCode) {
		if (logger.isDebugEnabled()) {
			logger.info("获取登录错误的信息开始!");
		}
		int num = loginDao.logonErrTimes(userCode);

		if (logger.isDebugEnabled()) {
			logger.info("获取登录错误的信息开始!");
		}
		return num;
	}

	
	@Autowired
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	/**
	 * 修改密码
	 * 
	 * @param userId
	 *            用户id
	 * @param pwd
	 *            新密码
	 * @return 返回 布尔值
	 * @throws SPlatformServiceException
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean updateUserPwd(String userId, String pwd)
			throws SPlatformServiceException {
		boolean flag = true;
		if (logger.isDebugEnabled()) {
			logger.info("修改密码开始!");
		}
		int num = loginDao.updateUserPwd(userId, pwd);

		if (num == 0) {
			flag = false;
			throw new SPlatformServiceException("系统忙，请稍候重试...");
		}

		if (logger.isDebugEnabled()) {
			logger.info("修改密码结束!");
		}
		return flag;
	}


	
	/**
	 * 通过用户的权限菜单生成对应的Ztree树
	 * @param userMenuList
	 * @return
	 */
	public List<ZTreeNode> generUserZtreeNode(List<SysMenu> userMenuList) {
		List<ZTreeNode> nodes = new ArrayList<ZTreeNode>();
		for(SysMenu menu : userMenuList){
			//获取节点
			//是否是叶子菜单，0不是；1是
			ZTreeNode node = new ZTreeNode();
			
			//追加子树
			//ZTreeNode _n = node.appendChild(menu.getId(), menu.getMenuName(), menu.getMenuPid(), "", menu.getLeafYn()==0?true:false, children);
//			if(menu.getLeafYn()==0){			
//				node.setId(menu.getId());
//				node.setName(menu.getMenuName());
//				node.setParentId(menu.getMenuPid());
//				node.setIsHasChild(menu.getLeafYn()==0?true:false);
//				node.setChildren(node.getChildren());
//			}else{
//				node.setId(menu.getId());
//				node.setName(menu.getMenuName());
//				node.setParentId(menu.getMenuPid());
//				node.setIsHasChild(false);
//				node.setChildren(node.getChildren());
//			}
//			nodes.add(node);
		}
		return nodes;
	}
	
	/**
	 * 通过所有权限菜单生成对应的Ztree树
	 * @param userMenuList
	 * @return
	 */
	public List<ZTreeNode> generAllZtreeNode() {
		List<ZTreeNode> nodes = new ArrayList<ZTreeNode>();
		try {
			SysMenu rootMenu = new SysMenu();
			rootMenu.setId(0);//根节点菜单
			ZTreeNode node = new ZTreeNode();
			
			addMenuChild(rootMenu, node);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		//for(SysMenu menu : userMenuList){
			//获取节点
			//是否是叶子菜单，0不是；1是
			
			
			//追加子树
			//ZTreeNode _n = node.appendChild(menu.getId(), menu.getMenuName(), menu.getMenuPid(), "", menu.getLeafYn()==0?true:false, children);
//			if(menu.getLeafYn()==0){			
//				node.setId(menu.getId());
//				node.setName(menu.getMenuName());
//				node.setParentId(menu.getMenuPid());
//				node.setIsHasChild(menu.getLeafYn()==0?true:false);
//				node.setChildren(node.getChildren());
//			}else{
//				node.setId(menu.getId());
//				node.setName(menu.getMenuName());
//				node.setParentId(menu.getMenuPid());
//				node.setIsHasChild(false);
//				node.setChildren(node.getChildren());
//			}
//			nodes.add(node);
		//}
		return nodes;
	}
	
	
	/**
	 * 添加子菜单
	 * @param menu
	 * @param parent
	 * @throws Exception
	 */
	private void addMenuChild(SysMenu sysMenu, ZTreeNode parent) throws Exception{
		//所有菜单
		List<SysMenu> childMenuList = menuDao.getMenuListByPId(sysMenu.getId());
		
		for(SysMenu menu:childMenuList){
			if(menu.getLeafYn()==1){
			    //如果是叶子菜单，查看是否存在子菜单
				List<SysMenu> subSysMenu = menuDao.getMenuListByPId(menu.getId());
				if(null != subSysMenu && !subSysMenu.isEmpty()){
					//一级叶子存在子菜单
					//追加子树						
					addMenuChild(menu,parent.appendChild(menu.getId(), menu.getMenuName(), menu.getMenuPid(), "", menu.getLeafYn()==0?true:false, parent));
				}
			}else{
			    //不是叶子菜单直接追加到;父节点下
				addMenuChild(menu,parent.appendChild(menu.getId(), menu.getMenuName(), menu.getMenuPid(), "", menu.getLeafYn()==0?true:false, parent));
			}
		}
	}
}
