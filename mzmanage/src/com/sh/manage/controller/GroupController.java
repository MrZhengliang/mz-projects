package com.sh.manage.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sh.manage.constants.SessionConstants;
import com.sh.manage.entity.SysGroup;
import com.sh.manage.entity.SysMenu;
import com.sh.manage.module.page.Page;
import com.sh.manage.pojo.LoginUser;
import com.sh.manage.service.GroupService;
import com.sh.manage.service.MenuService;
import com.sh.manage.utils.WebUtils;

/**
 * 组管理
 * @author
 * 
 */

@Controller
public class GroupController {
	
	private Logger logger = Logger.getLogger(GroupController.class);

	/**
	 * 注入groupSerice
	 */
	@Autowired
	private GroupService groupService;
	/**
	 * 注入menuService包装
	 */
	@Autowired
	private MenuService menuService;
	
	
	/** 当前页 */
	private int initPageNo = 1;

	/** 页面大小 */
	private int pageSize = 3;

	/** Page对象 */
	private Page page;
	
	/**
	 * 标志位
	 */
	private Integer groupIndex;
	
	
	public Integer getGroupIndex() {
		return groupIndex;
	}

	public void setGroupIndex(Integer groupIndex) {
		this.groupIndex = groupIndex;
	}

	/**
	 * 跳转权限组管理页面
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/gmanage.do")
    public ModelAndView groupManagePage(HttpServletRequest req,
			HttpServletResponse resp,
    		@RequestParam(value = "gIndex", required = false, defaultValue = "") Integer gIndex,
    		@RequestParam(value = "pageNo", required = false, defaultValue = "") Integer pageNo) {
		
		HttpSession session = req.getSession();
		groupIndex = 1;//默认为系统管理组
		//获取会员列表
		if (null == pageNo) {
			pageNo = initPageNo;
		}
		ModelAndView model = new ModelAndView("/system/g_manage");
		/**获取组列表*/
		List<SysGroup> groupList = groupService.findAll();
		
		
		/**获取组对应的角色列表*/
		//List<SysGroup> groupRoles = groupService.getGroupRoles(groupIndex);
		
		//返回的page对象
		page = groupService.getGroupRoles(groupIndex,pageNo, pageSize);
		//会员列表
		List<SysGroup> groupRoles = (List<SysGroup>) page.getList();
		//所有菜单
		String allDtree = menuService.getAllDTree((LoginUser)session.getAttribute(SessionConstants.LOGIN_USER));
		
		
		//获取一级菜单和系统菜单，用于添加新菜单
		
		
		model.addObject("groupList", groupList);
		model.addObject("groupIndex", groupIndex);
		model.addObject("groupRoles", groupRoles);
		model.addObject("allDtree",allDtree);
		model.addObject("pageSize", pageSize);
		model.addObject("page", page);
		
		logger.info("..groupList.size:"+groupList.size());
		logger.info("..allDtree:"+allDtree);
        return model;
    }
	
	/**
	 * 跳转客服组管理页面
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/gmanageExt.do")
    public ModelAndView groupManageExtPage(
    		@RequestParam(value = "gIndex", required = false, defaultValue = "") Integer gIndex,
    		@RequestParam(value = "gName", required = false, defaultValue = "") String gName,
    		@RequestParam(value = "pageNo", required = false, defaultValue = "") Integer pageNo,
    		RedirectAttributes attr) {
		
		ModelAndView model = new ModelAndView("/system/g_manage_ext");
		List<SysGroup> groupList = groupService.findAll();
		/**获取组对应的角色列表*/
		groupIndex = gIndex;
		//获取会员列表
		if (null == pageNo) {
			pageNo = initPageNo;
		}
		//返回的page对象
		page = groupService.getGroupRoles(groupIndex,pageNo, pageSize);
		
		//会员列表
		List<SysGroup> groupRoles = (List<SysGroup>) page.getList();
		
		model.addObject("groupList", groupList);
		model.addObject("groupRoles", groupRoles);
		model.addObject("gName", gName);
		model.addObject("pageSize", pageSize);
		model.addObject("page", page);
		
		if(null != gIndex){
			if(gIndex == 1){//系统管理员组
				attr.addAttribute("gIndex", groupIndex);
				//重定向到系统管理员组
				return new ModelAndView("redirect:/gmanage.do");
			}
			if(gIndex == 4){//会员组
				attr.addAttribute("gIndex", groupIndex);
				return new ModelAndView("redirect:/gmanageAuser.do");
			}
			groupIndex = gIndex==0?2:gIndex;
			
			//翻页使用的参数
			page.addParam("gIndex", groupIndex.toString());
			model.addObject("groupIndex", groupIndex);
			logger.info("权限组标志位:"+groupIndex);
		}
		
        return model;
    }
	
	
	/**
	 * 跳转会员组管理页面
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/gmanageAuser.do")
    public ModelAndView groupManageAuserPage(@RequestParam(value = "gIndex", required = false, defaultValue = "") Integer gIndex,
    		@RequestParam(value = "gName", required = false, defaultValue = "") String gName,
    		@RequestParam(value = "pageNo", required = false, defaultValue = "") Integer pageNo) {
		//groupIndex = 1;
		ModelAndView model = new ModelAndView("/system/g_manage_auser");
		/**获取组列表*/
		List<SysGroup> groupList = groupService.findAll();

		/**获取组对应的角色列表*/
		groupIndex = gIndex;
		//获取会员列表
		if (null == pageNo) {
			pageNo = initPageNo;
		}
		//返回的page对象
		page = groupService.getGroupRoles(groupIndex,pageNo, pageSize);
		//会员列表
		List<SysGroup> groupRoles = (List<SysGroup>) page.getList();		
		model.addObject("groupList", groupList);
		model.addObject("groupRoles", groupRoles);
		model.addObject("groupIndex", groupIndex);
		model.addObject("pageSize", pageSize);
		model.addObject("page", page);
		logger.info("..会员groupRoles.size:"+groupRoles.size());
        return model;
    }
	
	
	
	
	
	

	/**
	 * 当前组织下的组织修改
	 * @return
	 */
	@RequestMapping(value = "/groupEdit.do", method = RequestMethod.POST)
	public ResponseEntity<String> groupEdit(
			@RequestParam(value = "groupId", required = false, defaultValue = "0") int groupId,
			@RequestParam(value = "groupName", required = false, defaultValue = "0") String groupName,
			@RequestParam(value = "groupDesc", required = false, defaultValue = "0") String groupDesc,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..组织信息修改!");
		String msg="";
		boolean isCorrect = true;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//new role
		SysGroup group = new SysGroup();
		group.setId(groupId);
		group.setGroupName(groupName);
		group.setGroupDesc(groupDesc);
		
		try{
			groupService.updateGroupInfo(group);
			msg="组织信息修改成功!";
		}catch(Exception e){
			logger.error("controller:组织信息修改异常!"+groupName,e);
			msg="组织信息修改出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/gmanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
			
		}
		logger.info("controller:组织信息修改结束!");
		return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/gmanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
	}

	
	
/****************************************************************
 ****************************************************************
 ***************************************************************/	
	
	
	/**
	 * 当前组织下的菜单设置
	 * @return
	 */
	@RequestMapping(value = "/gMenuEdit.do", method = RequestMethod.POST)
	public ResponseEntity<String> gMenuEdit(
			@RequestParam(value = "groupId", required = false, defaultValue = "0") Integer groupId,
			@RequestParam(value = "menuStr", required = false, defaultValue = "") String menuStr,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..菜单设置!");
		String msg="";
		boolean isCorrect = true;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		try{
			
			/* new/get sysGroup */
			SysGroup sysGroup = groupService.findSysGroup(groupId);
			
			//原有的菜单关系
			Set<SysMenu> oldMenuSet = sysGroup.getMenuSet();
			//删除之前的菜单关系
			Set<SysMenu> delMenuSet = new HashSet<SysMenu>();
			
			//Iterator<SysMenu> iter = oldMenuSet.iterator();

			/*拆分菜单id*/
			String[] menuArr = menuStr.split(",");
			/*前台传来的组织对应菜单*/
			Set<SysMenu> newMenuSet = new HashSet<SysMenu>();
			for(String menuId:menuArr){
				SysMenu sysMenu = new SysMenu();
				if(oldMenuSet.size() > 0){
					//判断原有菜单关系
					for(SysMenu oSysMenu:oldMenuSet){
						//新增菜单关系
						//排除之前存在的但是这次未添加的菜单;准备删除
						if(Integer.parseInt(menuId) != oSysMenu.getId()){
							delMenuSet.add(oSysMenu);
						}else{
							sysMenu.setId(Integer.parseInt(menuId));
							//之前不存在，这次新增的菜单
							newMenuSet.add(sysMenu);
							continue;
						}
					}
				}
				sysMenu.setId(Integer.parseInt(menuId));
				//之前不存在，这次新增的菜单
				newMenuSet.add(sysMenu);
			}
				
						
			//操作组织下的菜单，先删后增
			sysGroup.getMenuSet().removeAll(delMenuSet);
			sysGroup.setMenuSet(newMenuSet);//设置组织对应的菜单
			
			//更新组织
			groupService.updateGroupInfo(sysGroup);
			
			msg="菜单设置成功!";
		}catch(Exception e){
			logger.error("controller:菜单设置异常!"+menuStr,e);
			msg="菜单设置出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/gmanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
			
		}
		logger.info("controller:菜单设置结束!");
		return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/gmanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
	}
	
	
	
	/**
	 * 跳转权限组管理页面
	 * @return
	 */
	@RequestMapping(value="/groupManage.do")
    public ModelAndView toGroupManagePage(HttpServletRequest req,
			HttpServletResponse resp,
    		@RequestParam(value = "gIndex", required = false, defaultValue = "") Integer gIndex,
    		@RequestParam(value = "pageNo", required = false, defaultValue = "") Integer pageNo) {
		
		groupIndex = 1;//默认为系统管理组
		//获取会员列表
		if (null == pageNo) {
			pageNo = initPageNo;
		}
		ModelAndView model = new ModelAndView("/group/group_manage");

		//返回的page对象
		page = groupService.getGroups(pageNo, pageSize);
		
		
		
		model.addObject("groupIndex", groupIndex);
		model.addObject("pageSize", pageSize);
		model.addObject("page", page);
		
        return model;
    }
	
	/**
	 * /**
	 * 商户失效
	 * @param busiCode
	 * * @param model
	 * @param request
	 * @param response
	 * @return 窗口
	 *//*
	@RequestMapping(value = "/invalidBusiInfo.do", method ={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String invalidBusiInfo( Model model,
       @RequestParam(value = "busiCode", required = false, defaultValue = "") String busiCode,
        HttpServletRequest request,HttpServletResponse response) {
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "text/html;charset=GBK");
		response.setContentType("text/html;charset=GBK");
		LoginUser loginUser =null;
		loginUser=(LoginUser)request.getSession().getAttribute(Const.SESS_LOGIN_USER);
		String msg = "";
		BusiSendEntity entity=null;
		String responseBody="";
		String flag="";
		String updateTime=TimeUtil.now();
		List<TMetaBusiRates>  tMetaBusiRatesList=new ArrayList<TMetaBusiRates>();
		//boolean isCorrect = true;
		logger.info("controller:失效商户开始!");
		if(loginUser==null){
			msg="用户没有登录";
			return ResponseUtils.newJsonBADResp(msg);	
			//return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/logout.do")+"'</script>",responseHeaders, HttpStatus.CREATED);	
		}
		try{
			entity=busiInfoSynService.getBusiInfoById(busiCode);
			TMetaBusiInfo busiInfo=new TMetaBusiInfo();
			if(entity !=null){
			busiInfo.setId( Long.parseLong(entity.getSubMerId()));
			}
			busiInfo.setBusiCode(busiCode);
			busiInfo.setUpdateTime(updateTime);
			busiInfo.setStatus(QjsConstants.INVALID);
			int num=busiInfoService.updateInvalidBusiInfo(busiInfo);
			msg="失效商户成功";	
			if(num>0){
				int synShopCount = busiInfoService.querySynCount(busiCode);
				if(synShopCount>0){
					if(entity.getSynType().equals("1")){///表示必须已经同步成功的结算商户才可以使用下面的代码
						
						TMetaBusiRates rate=new TMetaBusiRates();
						rate.setBusiCode(busiCode);
						tMetaBusiRatesList=busiInfoSynService.getRateList(rate);
						BusiInfoSendLdkj busiSendLdkj=new BusiInfoSendLdkj();
						*//**与联动交互**//*
						responseBody=busiSendLdkj.sendXmlMessage(entity, tMetaBusiRatesList,ldkjConstants.SUBMERCHANGEDELTYPE);
						flag=ldkjSynUtil.getResponseStatus(responseBody);
						
						
						
						//int synNum=1;
						String synType="1";
						if(flag.equals("1")){
							msg=msg+";子商户同步删除联动清结算平台成功！";
							////增加内容
							synType="1";
						}else{
							msg=msg+";子商户同步删除联动清结算平台失败！";
							synType="-1";
						}												
						
						TMetaBusiInfo ldBusiInfo=new TMetaBusiInfo();
						//ldBusiInfo.setSynNum(synNum);
						ldBusiInfo.setUpdateTime(updateTime);
						ldBusiInfo.setSynType(synType);
						ldBusiInfo.setSynFlag(synType);
						ldBusiInfo.setBusiCode(busiCode);
						busiInfoService.updateLdFlag(ldBusiInfo);//修改同步状态	
					}
						
					int synCount = busiInfoService.querySynCount(busiCode);
					if(synCount > 0){
						//获取新增结算商户ID
						TMetaBusiInfo viewBusi = busiInfoService.viewBusiInfo(busiCode);
						String id = String.valueOf(viewBusi.getId());
						
						//调用同步接口,同步结算商户到方正码平台						
						JSONObject reqJson = new JSONObject();
						reqJson.put("channel", "1");
						reqJson.put("operType", "2");
						reqJson.put("id", id);
						String ret = HttpURLConnectionUtils.httpURLConnectionByPost("http://172.17.0.207:8885/othersBusises/foundsync", String.valueOf(reqJson));
						JSONObject resultJson = JSONObject.fromObject(ret);
						String result = String.valueOf(resultJson.get("code"));
						String reMsg = String.valueOf(resultJson.get("msg"));
						if(result.equals("1000")){
							msg+=",同步方正码平台删除成功!";
							logger.info("清结算商户"+id+"同步方正码平台删除成功!");
						}else{
							msg+=",同步方正码平台删除失败!";
							logger.info("清结算商户:"+id+",同步方正码平台删除失败:"+reMsg);
						}						
					}						
				}else{
					msg+="请先删除业务商户,再删除结算商户!";
					logger.info("请先删除业务商户并同步方正后,再失效结算商户!");				
				}							
			}
			
		}catch(Exception e){
			msg="失效商户出现错误";
			logger.error("controller:失效商户异常!"+busiCode,e);
			msg = "失效商户出现错误！";
			return ResponseUtils.newJsonBADResp(msg);	
			//return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/errorCatch.do")+"'</script>",responseHeaders, HttpStatus.CREATED);	
		}
		logger.info("controller:失效商户结束!");
		model.addAttribute("userCode", loginUser.getUserCode());
		model.addAttribute("method", "init");
		///msg="失效商户成功！！！";
		return ResponseUtils.newJsonOKResp(msg);
		//return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/initManageBusi.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
	}
	
	*//**
	 * 商户信息查看
	 * @param busiCode
	 * @param model
	 * @param request
	 * @param response
	 * @return 窗口
	 *//*
	@RequestMapping(value = "/viewBusiInfo.do", method = RequestMethod.GET)
	public String viewBusiInfo(
			@RequestParam(value = "busiCode", required = false, defaultValue = "0") String busiCode,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:商户信息查看开始!");
		String msg="";
		TMetaBusiInfo busiInfo=new TMetaBusiInfo();
		List<TMetaLog> logList=new ArrayList<TMetaLog>();
		Map<Long,TMetaGoodsResources> result = null;
		TMetaGoodsResources tMetaGoodsResources=new TMetaGoodsResources();
		tMetaGoodsResources.setGoodsCode(busiCode);
		TMetaBusiRates rateInfo = new TMetaBusiRates();
		String cd = "";
		try{
		busiInfo=busiInfoService.viewBusiInfo(busiCode);
		if(busiInfo.getAgentCode() == null || "".equals(busiInfo.getAgentCode())){
			// 普通展示
			cd = "0";
		} else {
			// 代理商展示
			cd = "1";
		}
		result=busiResourceService.queryGoodsResourcesMap(tMetaGoodsResources);
		logList=logService.getLogInfoList(QjsConstants.BUSIMANAGELOG, busiCode);
		if("1".equals(cd)) {
			rateInfo = busiRateService.viewBusiRate(busiCode);
			busiInfo.setRateStartDate(rateInfo.getRateStartDate());
			busiInfo.setRateEndDate(rateInfo.getRateEndDate());
		}
		}catch(Exception e){
			logger.error("controller:商户信息查看异常!"+busiCode);
			msg="查询商户信息出现异常";
			model.addAttribute("msg", msg);
			return "/error/exception1";	
			
		}
		
		model.addAttribute("cd", cd);
		model.addAttribute("logList", logList);
		model.addAttribute("resourceMap", result);
		model.addAttribute("resultObject", busiInfo);
		logger.info("controller:商户信息查看结束!");
		return "/qjs/busi/busi_view";
	}
	
	*//**
	 * 商户信息显示
	 * 
	 * @param busiCode
     * @param model
	 * @param request
	 * @param response
	 * @return 窗口
	 *//*
	@RequestMapping(value = "/editBusiInfo.do", method = RequestMethod.GET)
	public String editBusiInfo(
			@RequestParam(value = "busiCode", required = false, defaultValue = "0") String busiCode,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:商户信息编辑查看开始!");
		String msg="";
		Map<Long,TMetaGoodsResources> result = null;
		TMetaBusiInfo busiInfo=new TMetaBusiInfo();
		TMetaGoodsResources tMetaGoodsResources=new TMetaGoodsResources();
		tMetaGoodsResources.setGoodsCode(busiCode);
		
		TMetaBusiRates rateInfo = new TMetaBusiRates();
		// 0:无代理商 1:有代理商
		String cd = "";
		try{
		busiInfo=busiInfoService.viewBusiInfo(busiCode);
		result=busiResourceService.queryGoodsResourcesMap(tMetaGoodsResources);
		List<SysArea> areaList = areaService.getAreaByProv(Long.parseLong(busiInfo.getProvId()));
		if(busiInfo.getAgentCode() == null || "".equals(busiInfo.getAgentCode())){
			// 普通展示
			cd = "0";
		} else {
			// 代理商展示
			cd = "1";
			rateInfo = busiRateService.viewBusiRate(busiCode);
			busiInfo.setRateStartDate(rateInfo.getRateStartDate());
			busiInfo.setRateEndDate(rateInfo.getRateEndDate());
			busiInfo.setRateId(rateInfo.getId());
		}

		model.addAttribute("areaList", areaList);
		model.addAttribute("resourceMap", result);
		}catch(Exception e){
			logger.error("controller:商户信息编辑查看异常!"+busiCode,e);
			msg="查询商户信息出现异常";
			model.addAttribute("msg", msg);
			return "/error/exception1";	
			
		}
		///version.setUpdateTime(CTime.formattime(version.getUpdateTime()));
		logger.info("controller:商户信息编辑查看结束!");
		model.addAttribute("rateInfo", rateInfo);
		model.addAttribute("cd", cd);
		model.addAttribute("resultObject", busiInfo);
		return "/qjs/busi/busi_edit";
	}
	
	*//**
	 * 更新商户信息
	 *            
     * @param model
	 * @param request
	 * @param response
	 * @return 窗口
	 *//*
	
	
	@RequestMapping(value = "/updateBusiInfo.do", method = RequestMethod.POST)
	public ResponseEntity<String> updateBusiInfo(
	Model model, HttpServletResponse response, HttpServletRequest request)  {
		
		logger.info("controller:更新商户信息开始!");
		TMetaLog log=new TMetaLog();
		String logInfo=""; 
		String msg = "";
		boolean isCorrect = true;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "text/html;charset=GBK");
		response.setContentType("text/html;charset=GBK");
		LoginUser loginUser =null;
		loginUser=(LoginUser)request.getSession().getAttribute(Const.SESS_LOGIN_USER);
		if(loginUser==null){
			msg="用户没有登录";
			return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/logout.do")+"'</script>",responseHeaders, HttpStatus.CREATED);	
		}
		
		// 设置回应的头信息
		
		logger.info("修改商户信息开始");
		// 磁盘文件项工厂
		FileItemFactory factory = new DiskFileItemFactory();

		// 上传类
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 表单字段
		Map<String, String> formFields = new HashMap<String, String>();
		// 解析请求
		List<FileItem> items;
		try {
			items = upload.parseRequest(request);
		}
		catch (Exception e) {
			msg="数据解析出现异常";
			logger.error("controller:更新商户信息异常!",e);
			return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/errorCatch.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
		}
		
	
		// 循环字段
		
		for (FileItem item : items) {
			if (item.isFormField()) {
				try {
					formFields.put(item.getFieldName(), StringUtils.trim(item.getString(QjsConstants.CHARSET_GBK)));
				}
				catch (UnsupportedEncodingException e) {
					logger.error("controller:更新商户信息异常!",e);
					return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/errorCatch.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
				}
			}
		}
		*//**商户编号**//*
		 String busiCode; 

		*//**商户名称**//*
		 String busiName;
		*//**商户所在的省**//*
		 String provId;
		*//**商户地市编码**//*
		 String areaCode;
		*//**商户电话**//*
		 String busiTel;
		*//**商户地址**//*
		 String busiAddr;

		*//**商户邮政编码**//*
		 String busiZipCode;
		
		*//**商户邮箱**//*
		 String busiEmail;
		*//**联系人**//*
		 String contactMan;
		*//**联系人电话**//*
		 String contactManTel;
		*//**联系人邮箱**//*
		 String contactManEmail;
		*//**备注**//*
		 String busiComment;

		*//**收款账户号**//*
		 String busiAccountCode;
		*//**收款账户名**//*
		 String busiAccountName;
		*//**联行编号**//*
		 String busiAccountBankCode;
		*//**开户行**//*
		 String busiAccountBankName;
		
		*//**修改时间**//*
		 String updateTime=TimeUtil.now();
		 
		 *//**周期类型**//*
		 String cycleType;
			
		*//**周期数**//*
		 int cycleNum;
			
		*//**是否单表结算**//*
		 String isSingleSettleMent;
			
		*//**区间计算类型**//*
		 String extEndCptType;
		 
		 *//**手续费最大值限制**//*	
	 	int maxVal;
		
		*//**手续费最小值限制**//*
		 int minVal;
		 
		 *//**商户类别**//*
		 String subMerType;
		 *//**商户服务类型**//*
		 String serviceType;
		 
		 *//**普通商户/代理商商户区分**//*
		 String cd;
		 
		 *//**商户等级**//*
		 String busiLevel;
		 
		 *//**代理商编号**//*
		 String agentCode;
		 
		// 代理商费率
		*//**商户费率类型**//*
		 String rateType;
		 
		*//**商户费率开始日期**//*
		 String rateStartDate;
		 
		*//**商户费率结束日期**//*
		 String rateEndDate;
		 
		*//**商户费率值**//*
		 double rateData;
		*//**商户费率区间最大值**//*
		 int rateMaxData;

		*//**商户费率区间最小值**//*
		 int rateMinData;
		 
		*//**商户费率ID**//*
		 Long rateId;
			 
			 
		
		if(formFields !=null){
			TMetaBusiInfo parmObject=new TMetaBusiInfo();
			busiCode =TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("busiCode")), 32);
			parmObject.setBusiCode(busiCode);
			busiName = TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("busiName")), 64);
			parmObject.setBusiName(busiName);
			provId=TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("provId")), 4);
			parmObject.setProvId(provId);
			areaCode=TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("areaCode")), 4);
			parmObject.setAreaCode(areaCode);
			busiTel=TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("busiTel")), 24);
			parmObject.setBusiTel(busiTel);
			busiAddr=TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("busiAddr")), 64);
			parmObject.setBusiAddr(busiAddr);
			busiZipCode=TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("busiZipCode")), 6);
			parmObject.setBusiZipCode(busiZipCode);
			busiEmail=TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("busiEmail")), 64);
			parmObject.setBusiEmail(busiEmail);
			contactMan=TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("contactMan")), 16);
			parmObject.setContactMan(contactMan);
			contactManTel=TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("contactManTel")), 24);
			parmObject.setContactManTel(contactManTel);
			contactManEmail=TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("contactManEmail")), 64);
			parmObject.setContactManEmail(contactManEmail);
			busiComment=TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("busiComment")), 128);
			parmObject.setBusiComment(busiComment);
			busiAccountCode=TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("busiAccountCode")), 32);
			parmObject.setBusiAccountCode(busiAccountCode);
			busiAccountName=TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("busiAccountName")), 64);
			parmObject.setBusiAccountName(busiAccountName);
			busiAccountBankCode=TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("busiAccountBankCode")), 12);
			parmObject.setBusiAccountBankCode(busiAccountBankCode);
			busiAccountBankName=TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("busiAccountBankName")), 64);
			parmObject.setBusiAccountBankName(busiAccountBankName);
			parmObject.setStatus(QjsConstants.PENGDING);
			parmObject.setUpdateTime(updateTime);//
			parmObject.setRegOper(loginUser.getUserCode());
			

			cycleType=TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("cycleType")), 2);
			parmObject.setCycleType(cycleType);
			
			if(!"".equals(TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("cycleNum")), 9))){

				cycleNum =Integer.valueOf(TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("cycleNum")), 9));
				parmObject.setCycleNum(cycleNum);
			}
			
			
			isSingleSettleMent=TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("isSingleSettleMent")), 2);
			parmObject.setIsSingleSettleMent(isSingleSettleMent);
			
			extEndCptType=TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("extEndCptType")), 2);
			parmObject.setExtEndCptType(extEndCptType);
			
			if(!"".equals(TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("maxVal")), 9))){

				maxVal =Integer.parseInt(TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("maxVal")), 9));
				parmObject.setMaxVal(maxVal);
			}
			
			if(!"".equals(TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("minVal")), 9))){

				minVal =Integer.parseInt(TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("minVal")), 9));
				parmObject.setMinVal(minVal);
			}
			
			subMerType=TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("subMerType")), 32);
			parmObject.setSubMerType(subMerType);
			serviceType=TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("serviceType")), 32);
			parmObject.setServiceType(serviceType);
			
			agentCode = TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("agentCode")), 32);
			parmObject.setAgentCode(agentCode);
			
			busiLevel = TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("busiLevel")), 10);
			parmObject.setBusiLevel(busiLevel);
			
			cd = TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("cd")), 10);
			
			// 代理商商户费率
			TMetaBusiRates rateObject = new TMetaBusiRates();
			if("1".equals(cd)) {
				
				busiCode =TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("busiCode")), 32);
				rateObject.setBusiCode(busiCode);
				busiName = TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("busiName")), 64);
				rateObject.setBusiName(busiName);
				rateObject.setRegOper(loginUser.getUserCode());
				rateType=TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("rateType")), 10);
				rateObject.setRateType(rateType);
				rateStartDate=TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("rateStartDate")), 20);
				rateObject.setRateStartDate(StringUtils.replace(rateStartDate, "-", ""));
				rateEndDate=TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("rateEndDate")), 20);
				rateObject.setRateEndDate(StringUtils.replace(rateEndDate, "-", ""));
				if(!"".equals(TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("rateData")), 10))){

					rateData =Double.parseDouble(TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("rateData")), 10));
					rateObject.setRateData(new BigDecimal(rateData));
				}
				if(!"".equals(TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("rateMinData")), 10))){

					rateMinData =Integer.parseInt(TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("rateMinData")), 10));
					rateObject.setRateMinData(rateMinData);
				}
				if(!"".equals(TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("rateMaxData")), 10))){

					rateMaxData =Integer.parseInt(TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("rateMaxData")), 10));
					rateObject.setRateMaxData(rateMaxData);
				}
				rateId = Long.valueOf(TextUtils.cutTxtLenByDouble(TextUtils.escapeHTML(formFields.get("rateId")), 10));
				rateObject.setId(rateId);
				rateObject.setUpdateTime(updateTime);//插入数据的时候，修改时间就是创建时间
			}
			
			try{
				busiInfoService.updateBusiInfo(parmObject);
				// 代理商商户费率
				if("1".equals(cd)) {
					busiRateService.updateBusiRate(rateObject);
				}
				logInfo="修改商户成功";
				msg = "修改商户信息成功！";
			}catch(Exception e){
				msg = "修改商户信息出现异常！";
				logInfo="修改商户失败";
				logger.error("controller:更新商户信息异常!",e);
				isCorrect = false;
				return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + "); parent.close();parent.location.href='" + WebUtils.formatURI(request, "/errorCatch.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
			}finally{
				try {
					log.setRelateName("商户管理--修改");
					log.setLogInfo(logInfo);
					log.setUserCode(loginUser.getUserCode());
					String logDate=TimeUtil.now();
					log.setLogDate(logDate);
					log.setRelateId(busiCode);
					log.setFlagObj(QjsConstants.BUSIMANAGELOG);
	                logService.addLogInfo(log);
                }
                catch (Exception e) {
	                e.printStackTrace();
	                return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + "); parent.close();parent.location.href='" + WebUtils.formatURI(request, "/errorCatch.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
                }
			}
		
		}
		logger.info("修改商户信息结束");
		return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/initManageBusi.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
		
	}
	 */
}
