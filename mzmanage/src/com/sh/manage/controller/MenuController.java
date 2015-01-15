/**
 * 
 */
package com.sh.manage.controller;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sh.manage.service.GroupService;


/**
 * 菜单控制
 * @author fuzl
 *
 */
@Controller
public class MenuController {

	/**
	 * 日志记录
	 */
	@SuppressWarnings("unused")
	private final Logger logger = Logger.getLogger(MenuController.class);
	

	/**
	 * 组织服务
	 */
	@Autowired
	private GroupService groupService;
	
	
}
