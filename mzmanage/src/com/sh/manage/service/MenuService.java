package com.sh.manage.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.manage.dao.MenuDao;
import com.sh.manage.entity.SysMenu;
import com.sh.manage.exception.SPlatformServiceException;
import com.sh.manage.module.page.DTree;
import com.sh.manage.pojo.LoginUser;

/**
 * 
 * 菜单服务类
 * 
 * @author
 * 
 */
@Service
public class MenuService extends BaseService {

	private Logger logger = Logger.getLogger(MenuService.class);

	@Autowired
	private MenuDao menuDao;

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<SysMenu> findAllMenus() {
		return menuDao.getAllMenus();
	}

	// allDtree = roleBo.getAllDTree(loginUser);
	// logger.info("生成的allDtree:"+allDtree);
	// 所有菜单数据
	public String getAllDTree(LoginUser loginUser) {
		String menuListStr = "";
		try {
			// 所有菜单
			List<SysMenu> menuList = getAllMenuList(loginUser);

			if (null != menuList) {
				// DTree.createRoot(null, null, "管理系统",
				// "javascript:menu_modify(0,1);",
				// "0","fff","",false,false,"e");
				// _icon, _icon2, _title, _link, _oid, _target, _frame,
				// _check,_ischeck, _html
				DTree root = DTree.createRoot(
						"0",
						"-1",
						"H5管理系统", "", 0, "target", "frame", true, false, "");
				// 所有菜单
				for (int i = 0; i < menuList.size(); i++) {
					SysMenu sysMenu = menuList.get(i);

					// 通过code=pcode获取menuList
					List<SysMenu> childMenuList = menuDao
							.getMenuListByPId(sysMenu.getId());

					if (null != childMenuList && !childMenuList.isEmpty()) {
						// 添加叶子菜单 //设置显示checkBox //<a
						// href=\"#\" onclick=\"javascript:menu_modify("+sysMenu.getMenuCode()+","+sysMenu.getLeafYn()+",1);\"><img
						// src=\"images//dtree//add.gif\"//></a>
						addMenuChild(sysMenu, root.appendChild(null, null,
								"<img src=\"static//images//dtree//folder.gif\"/>"
										+ sysMenu.getMenuName(), "",
								sysMenu.getId(), sysMenu.getMenuName(), "",
								true, false, ""));
					}
				}
				menuListStr = DTree.initDefaultTree(root);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menuListStr;
	}

	/**
	 * 添加子菜单
	 * 
	 * @param menu
	 * @param parent
	 * @throws Exception
	 */
	private void addMenuChild(SysMenu sysMenu, DTree parent) throws Exception {
		// 所有菜单
		List<SysMenu> childMenuList = menuDao.getMenuListByPId(sysMenu
				.getId());

		for (SysMenu menu : childMenuList) {

			if (menu.getLeafYn() == 1) {
				// 如果是叶子菜单，查看是否存在子菜单
				List<SysMenu> subSysMenu = menuDao.getMenuListByPId(menu
						.getId());
				if (null != subSysMenu && !subSysMenu.isEmpty()) {
					// 一级叶子存在子菜单
					// 追加子树 //<a
					// href=\"#\" onclick=\"javascript:menu_del("+menu.getMenuCode()+");\"><img
					// src=\"images//dtree//del.gif\"//></a>
					addMenuChild(menu, parent.appendChild(null, null,
							"<img src=\"static//images//dtree//page.gif\"/>"
									+ menu.getMenuName(), "", menu.getId(),
							menu.getMenuName(), "", true, false, ""));
				} else {
					addMenuChild(menu, parent.appendChild(null, null,
							"<img src=\"static//images//dtree//page.gif\"/>"
									+ menu.getMenuName(), "", menu.getId(),
							menu.getMenuName(), "", true, false, ""));
				}
			} else {
				// 不是叶子菜单直接追加到;父节点下 //<a
				// href=\"#\" onclick=\"javascript:menu_del("+menu.getMenuCode()+");\"><img
				// src=\"images//dtree//del.gif\"//></a>
				addMenuChild(menu, parent.appendChild(
						null,
						null,
						"<img src=\"static//images//dtree//page.gif\"/>"
								+ menu.getMenuName(), "", menu.getId(),
						menu.getMenuName(), "", true, false, ""));
			}
		}
	}

	/**
	 * 获取所有菜单数据
	 */
	public List<SysMenu> getAllMenuList(LoginUser loginUser) {
		return menuDao.getMenuList(loginUser);
	};

	/**
	 * 添加菜单
	 * 
	 * @param menu
	 */
	public void addMenu(SysMenu menu) throws SPlatformServiceException {
		try {
			menuDao.save(menu);
		} catch (Exception e) {
			logger.error("service:添加菜单信息出现异常", e);
			throw new SPlatformServiceException("添加菜单信息出现异常");
		}
	}

	/**
	 * 编辑菜单
	 * 
	 * @param menu
	 * @throws SPlatformServiceException
	 */
	public void editMenu(SysMenu menu) throws SPlatformServiceException {
		try {
			menuDao.update(menu);

		} catch (Exception e) {
			logger.error("service:编辑菜单信息出现异常", e);
			throw new SPlatformServiceException("编辑菜单信息出现异常");
		}
	}

	/**
	 * 删除菜单
	 * 
	 * @param menu
	 * @throws SPlatformServiceException
	 */
	public void delRole(SysMenu menu) throws SPlatformServiceException {
		try {
			menuDao.delete(menu);
		} catch (Exception e) {
			logger.error("service:删除菜单信息出现异常", e);
			throw new SPlatformServiceException("删除菜单信息出现异常");
		}
	};
}
