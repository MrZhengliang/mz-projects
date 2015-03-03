package com.sh.manage.controller;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sh.manage.module.page.Page;
import com.sh.manage.service.ManzhanService;


/**
 * 漫展管理控制
 * @author 
 */

@Controller
public class GonggaoController {
	
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(GonggaoController.class);


	/**
	 * 用户会员管理service
	 */
	@Autowired
	private ManzhanService manzhanService;

	

	/** 当前页 */
	private int initPageNo = 1;

	/** 页面大小 */
	private int pageSize = 3;

	/** Page对象 */
	private Page page;

//	/**
//	 * 跳转漫展管理页面
//	 * 
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	@RequestMapping(value = "/mzmanage")
//	public ModelAndView manZhanManagePage(
//			@RequestParam(value = "status", required = false, defaultValue = "") Integer status,
//			@RequestParam(value = "auRoleId", required = false, defaultValue = "") Integer auRoleId,
//			@RequestParam(value = "usercode", required = false, defaultValue = "") String usercode,
//			@RequestParam(value = "startDate", required = false, defaultValue = "") String startDate,
//			@RequestParam(value = "endDate", required = false, defaultValue = "") String endDate,
//			@RequestParam(value = "pageNo", required = false, defaultValue = "") Integer pageNo) {
//		// 获取会员以及等级
//		if (null == pageNo) {
//			pageNo = initPageNo;
//		}
//		//返回会员列表页
//		ModelAndView model = new ModelAndView("/appuser/appuser_manage");
//		model.addObject("status", status);
//		model.addObject("auRoleId", auRoleId);
//		model.addObject("usercode", usercode);
//		model.addObject("startDate", startDate);
//		model.addObject("endDate", endDate);
//		//返回的page对象
//		page = manzhanService.findAllAppUser(auRoleId == null ? 0 : auRoleId,
//				usercode, startDate.replaceAll("-", ""), endDate.replaceAll("-", ""), status == null ? 0 : status,
//				pageNo, pageSize);
//		// 会员列表
//		List<AppUser> appUserList = (List<AppUser>) page.getList();
//
//		// 会员等级
//		List<SysRole> roleList = roleService.findAppUserRole(4);
//		// 翻页带参数
//		if(null!=status && status>0){
//			page.addParam("status",""+status);
//		}
//		if(null!=auRoleId && auRoleId>0){
//			page.addParam("auRoleId",""+auRoleId);
//		}
//		if(null != usercode){
//			page.addParam("usercode",""+usercode);
//		}
//		if(null != startDate){
//			page.addParam("startDate",""+startDate);
//		}
//		if(null != endDate){
//			page.addParam("endDate",""+endDate);
//		}		
//				
//		model.addObject("pageSize", pageSize);
//		model.addObject("page", page);
//		model.addObject("appUserList", appUserList);
//		model.addObject("roleList", roleList);
//		return model;
//	}
//
//	/**
//	 * 当前组织下的会员添加
//	 * @return
//	 */
//	@RequestMapping(value = "/manZhanAdd.do", method = RequestMethod.POST)
//	public ResponseEntity<String> manZhanAdd(
//			@RequestParam(value = "auRoleId", required = false, defaultValue = "0") Integer auRoleId,
//			@RequestParam(value = "startDate", required = false, defaultValue = "") String startDate,
//			@RequestParam(value = "usercode", required = false, defaultValue = "") String usercode,
//			@RequestParam(value = "endDate", required = false, defaultValue = "") String endDate,
//			@RequestParam(value = "password", required = false, defaultValue = "") String password,
//			@RequestParam(value = "terminalId", required = false, defaultValue = "") String terminalId,
//			@RequestParam(value = "email", required = false, defaultValue = "") String email,
//			@RequestParam(value = "remark", required = false, defaultValue = "") String remark,
//			@RequestParam(value = "name", required = false, defaultValue = "") String name,
//			@RequestParam(value = "status", required = false, defaultValue = "0") Integer status,
//			@RequestParam(value = "limitYear", required = false, defaultValue = "0") Integer limitYear,
//			HttpServletRequest request,HttpServletResponse response,
//			Model model) {
//		logger.info("controller:..会员添加!");
//		String msg="";
//		boolean isCorrect = true;
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
//		response.setContentType("text/html;charset=UTF-8");
//
//		//new appUser
//		AppUser aUser = new AppUser();
//		aUser.setEmail(email);
//		aUser.setEndDate(endDate.replaceAll("-", ""));//时间格式化，去掉-
//		aUser.setName(name);
//		aUser.setPassword(password);
//		aUser.setRoleId(auRoleId);
//		aUser.setStartDate(startDate.replaceAll("-", ""));//时间格式化，去掉-
//		aUser.setStatus(status);
//		aUser.setUserName(usercode);
//		aUser.setTerminalId(terminalId);
//		aUser.setLimitYear(limitYear);
//		aUser.setRemark(remark);
//		
//		try{
//			userService.addAppUser(aUser);
//			msg="会员添加成功!";
//		}catch(Exception e){
//			logger.error("controller:会员添加异常!"+usercode,e);
//			msg="会员添加出现异常";
//			model.addAttribute("msg", msg);
//			return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/aumanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
//			
//		}
//		logger.info("controller:会员添加结束!");
//		return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/aumanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
//	}
//	
//	
//	/**
//	 * 当前组织下的会员修改
//	 * @return
//	 */
//	@RequestMapping(value = "/manZhanEdit.do", method = RequestMethod.POST)
//	public ResponseEntity<String> manZhanEdit(
//			@RequestParam(value = "auRoleId", required = false, defaultValue = "0") Integer auRoleId,
//			@RequestParam(value = "startDate", required = false, defaultValue = "") String startDate,
//			@RequestParam(value = "usercode", required = false, defaultValue = "") String usercode,
//			@RequestParam(value = "endDate", required = false, defaultValue = "") String endDate,
//			@RequestParam(value = "terminalId", required = false, defaultValue = "") String terminalId,
//			@RequestParam(value = "email", required = false, defaultValue = "") String email,
//			@RequestParam(value = "remark", required = false, defaultValue = "") String remark,
//			@RequestParam(value = "name", required = false, defaultValue = "") String name,
//			@RequestParam(value = "status", required = false, defaultValue = "0") Integer status,
//			@RequestParam(value = "limitYear", required = false, defaultValue = "0") Integer limitYear,
//			@RequestParam(value = "auid", required = false, defaultValue = "0") Integer auid,
//			HttpServletRequest request,HttpServletResponse response,
//			Model model) {
//		logger.info("controller:..会员修改!");
//		String msg="";
//		boolean isCorrect = true;
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
//		response.setContentType("text/html;charset=UTF-8");
//
//		try{
//			//  get/new appUser
//			AppUser aUser = manzhanService.findAppUser(auid);
//			
//			aUser.setEmail(email);
//			aUser.setEndDate(endDate);
//			aUser.setName(name);
//			aUser.setRoleId(auRoleId);
//			aUser.setStartDate(startDate);
//			aUser.setStatus(status);
//			aUser.setUserName(usercode);
//			aUser.setTerminalId(terminalId);
//			aUser.setLimitYear(limitYear);
//			aUser.setRemark(remark);
//			
//			manzhanService.editAppUser(aUser);
//			
//			msg="会员修改成功!";
//		}catch(Exception e){
//			logger.error("controller:会员修改异常!"+usercode,e);
//			msg="会员修改出现异常";
//			model.addAttribute("msg", msg);
//			return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/aumanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
//			
//		}
//		logger.info("controller:会员修改结束!");
//		return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/aumanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
//	}
//
//	
//	
//	
//	/**
//	 * 当前组织下的会员删除
//	 * @return
//	 */
//	@RequestMapping(value = "/manZhanDel.do", method = RequestMethod.POST)
//	public ResponseEntity<String> manZhanDel(
//			@RequestParam(value = "auid", required = false, defaultValue = "0") Integer auid,
//			HttpServletRequest request,HttpServletResponse response,
//			Model model) {
//		logger.info("controller:..会员删除!");
//		String msg="";
//		boolean isCorrect = true;
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
//		response.setContentType("text/html;charset=UTF-8");
//
//		
//		try{
//		//  get/new appUser
//			AppUser aUser = manzhanService.findAppUser(auid);
//			
//			if(null != aUser){
//				manzhanService.delAppUser(aUser);
//				msg="会员删除成功!";
//			}
//		}catch(Exception e){
//			logger.error("controller:会员删除异常!"+auid,e);
//			msg="会员删除出现异常";
//			model.addAttribute("msg", msg);
//			return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/aumanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
//		}
//		logger.info("controller:会员删除结束!");
//		return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/aumanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
//	}

	
	
	
	
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Page getPage() {
		return page;
	}

	public int getInitPageNo() {
		return initPageNo;
	}

	public void setInitPageNo(int initPageNo) {
		this.initPageNo = initPageNo;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
