package com.sh.manage.controller;

import java.util.List;

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

import com.sh.manage.constants.SessionConstants;
import com.sh.manage.entity.TMzArticleContent;
import com.sh.manage.module.page.Page;
import com.sh.manage.pojo.LoginUser;
import com.sh.manage.service.ManzhanService;
import com.sh.manage.utils.WebUtils;

/**
 * 漫展管理控制
 * @author 
 */

@Controller
public class ManzhanController {
	
	private Logger logger = Logger.getLogger(ManzhanController.class);


	/**
	 * 漫展管理service
	 */
	@Autowired
	private ManzhanService manzhanService;

	

	/** 当前页 */
	private int initPageNo = 1;

	/** 页面大小 */
	private int pageSize = 5;

	/** Page对象 */
	private Page page;

	/**
	 * 跳转漫展管理页面
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/mzmanage")
	public ModelAndView manZhanManagePage(
			@RequestParam(value = "usercode", required = false, defaultValue = "") String usercode,
			@RequestParam(value = "priceType", required = false, defaultValue = "") Integer priceType,
			@RequestParam(value = "cityName", required = false, defaultValue = "") String cityName,
			@RequestParam(value = "startDate", required = false, defaultValue = "") String startDate,
			@RequestParam(value = "endDate", required = false, defaultValue = "") String endDate,
			@RequestParam(value = "pageNo", required = false, defaultValue = "") Integer pageNo,
			HttpServletRequest request,HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		// 获取漫展
		if (null == pageNo) {
			pageNo = initPageNo;
		}
		//返回漫展列表页
		ModelAndView model = new ModelAndView("/manzhan/mz_manage");
		try {
			
			LoginUser _loginUser  = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
			if(null == _loginUser){
				//用户未登录，重定向到登陆
				return new ModelAndView("redirect:/system/tologin.do");
			}
			
			model.addObject("usercode", usercode);
			model.addObject("priceType", priceType);
			model.addObject("cityName", cityName);
			model.addObject("startDate", startDate);
			model.addObject("endDate", endDate);
			//返回的page对象
			page = manzhanService.findAllTMzArticleContent(cityName, 
					usercode,startDate.replaceAll("-", ""), endDate.replaceAll("-", ""), 
					priceType == null ? 0 : priceType,pageNo, pageSize);
			// 漫展列表
			List<TMzArticleContent> articleContentList = (List<TMzArticleContent>) page.getList();

			
			// 翻页带参数
			if(null!=usercode ){
				page.addParam("usercode",""+usercode);
			}
			if(null!=priceType && priceType>0){
				page.addParam("priceType",""+priceType);
			}
			if(null != cityName){
				page.addParam("cityName",""+cityName);
			}
			if(null != startDate){
				page.addParam("startDate",""+startDate);
			}
			if(null != endDate){
				page.addParam("endDate",""+endDate);
			}		
					
			model.addObject("pageSize", pageSize);
			model.addObject("page", page);
			model.addObject("articleContentList", articleContentList);
			
			model.addObject("uid", _loginUser.getId());//管理员id
		} catch (Exception e) {
			logger.error("ManzhanController--->manZhanManagePage--error");
		}
		return model;
	}

	
	
	/**
	 * 跳转漫展详情页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/mzinfo")
	public ModelAndView manZhanInfoPage(
			@RequestParam(value = "cid", required = false, defaultValue = "") String cid,
			HttpServletRequest request,HttpServletResponse response) {
		logger.info("controller:..漫展详情查询!");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//返回漫展列表页
		ModelAndView model = new ModelAndView("/manzhan/mz_info");
		
		HttpSession session = request.getSession();
		try{
			
			LoginUser _loginUser  = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
			if(null == _loginUser){
				//用户未登录，重定向到登陆
				return new ModelAndView("redirect:/system/tologin.do");
			}
			//  get/new article
			TMzArticleContent article = manzhanService.findArticleContent(Integer.parseInt(cid));
			model.addObject("article", article);
			
		}catch(Exception e){
			logger.error("controller:漫展详情查询异常!"+cid,e);
		}
		return model;
	}
	
	
	/**
	 * 跳转漫展添加页面
	 */
	@RequestMapping(value = "/toAddMz.do", method = RequestMethod.GET)
	public ModelAndView toAddMzPage(
			@RequestParam(value = "uid", required = false, defaultValue = "") Integer uid,
			HttpServletRequest request,HttpServletResponse response) {
		logger.info("controller:..跳转漫展详情添加!");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//返回漫展添加页
		ModelAndView model = new ModelAndView("/manzhan/mz_add");
		
		HttpSession session = request.getSession();
		try{
			
			LoginUser _loginUser  = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
			if(null == _loginUser){
				//用户未登录，重定向到登陆
				return new ModelAndView("redirect:/system/tologin.do");
			}
			
			//new article
			TMzArticleContent article = new TMzArticleContent();
			article.setUid(uid);
			manzhanService.addArticleContent(article);
			//get article
			//TMzArticleContent dbarticle = manzhanService.getArticleContent(article);
			
			model.addObject("article", article);
		}catch(Exception e){
			logger.error("controller:跳转漫展详情添加异常!"+uid,e);
		}
		return model;
	}
	
	
	/**
	 * 当前用户的漫展添加
	 * @return
	 */
	@RequestMapping(value = "/manZhanAdd.do", method = RequestMethod.POST)
	public ResponseEntity<String> manZhanAdd(
			@RequestParam(value = "uid", required = false, defaultValue = "0") Integer uid,
			@RequestParam(value = "idtype", required = false, defaultValue = "1") Integer idtype,
			@RequestParam(value = "telephone", required = false, defaultValue = "") String telephone,
			@RequestParam(value = "qqcode", required = false, defaultValue = "") String qqcode,
			@RequestParam(value = "email", required = false, defaultValue = "") String email,
			@RequestParam(value = "title", required = false, defaultValue = "") String title,
			@RequestParam(value = "privurl", required = false, defaultValue = "") String privurl,
			@RequestParam(value = "cityname", required = false, defaultValue = "") String cityname,
			@RequestParam(value = "lat", required = false, defaultValue = "") String lat,
			@RequestParam(value = "lng", required = false, defaultValue = "") String lng,
			@RequestParam(value = "address", required = false, defaultValue = "") String address,
			@RequestParam(value = "starttime", required = false, defaultValue = "") String starttime,
			@RequestParam(value = "closetime", required = false, defaultValue = "") String closetime,
			@RequestParam(value = "pricetype", required = false, defaultValue = "") Integer pricetype,
			//票价方式 1 免费  2 收费
			@RequestParam(value = "price", required = false, defaultValue = "") double price,
			//订票方式
			@RequestParam(value = "tickettype", required = false, defaultValue = "") String tickettype,
			@RequestParam(value = "netticketaddress", required = false, defaultValue = "") String netticketaddress,
			@RequestParam(value = "content", required = false, defaultValue = "") String content,
			@RequestParam(value = "dateline", required = false, defaultValue = "") String dateline,
			
			@RequestParam(value = "faceimg", required = false, defaultValue = "0") Integer faceimgId,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..漫展添加!");
		String msg="";
		boolean isCorrect = true;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//new article
		TMzArticleContent article = new TMzArticleContent();
		article.setAddress(address);
		article.setCityname(cityname);
		article.setClosetime(closetime.replaceAll("-", ""));
		article.setContent(content);
		article.setDateline(dateline.replaceAll("-", ""));//时间格式化，去掉-
		article.setEmail(email);
		article.setFaceimg(faceimgId);//封面图片id
		article.setIdtype(idtype);
		article.setLat(lat);//经纬度
		article.setLng(lng);
		article.setNetticketaddress(netticketaddress);
		article.setPrice(price);
		article.setPricetype(pricetype);
		article.setPrivurl(privurl);
		article.setQqcode(qqcode);
		article.setStarttime(starttime.replaceAll("-", ""));
		article.setTelephone(telephone);
		article.setTickettype(tickettype);
		article.setTitle(title);
		article.setUid(uid);
		
		
		try{
			manzhanService.addArticleContent(article);
			msg="漫展添加成功!";
		}catch(Exception e){
			logger.error("controller:漫展添加异常!"+title,e);
			msg="漫展添加出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/mzmanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
		}
		logger.info("controller:漫展添加结束!");
		return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/mzmanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
	}
	
	
	/**
	 * 跳转漫展修改页面
	 */
	@RequestMapping(value = "/toEditMz.do", method = RequestMethod.GET)
	public ModelAndView toEditMzPage(
			@RequestParam(value = "cid", required = false, defaultValue = "") Integer cid,
			HttpServletRequest request,HttpServletResponse response) {
		logger.info("controller:..跳转漫展详情修改!");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//返回漫展添加页
		ModelAndView model = new ModelAndView("/manzhan/mz_edit");
		
		HttpSession session = request.getSession();
		try{
			
			LoginUser _loginUser  = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
			if(null == _loginUser){
				//用户未登录，重定向到登陆
				return new ModelAndView("redirect:/system/tologin.do");
			}
			
			//new or get article
			TMzArticleContent article = new TMzArticleContent();
			article.setCid(cid);
			TMzArticleContent dbarticle = manzhanService.getArticleContent(article);
			
			model.addObject("article", dbarticle);
		}catch(Exception e){
			logger.error("controller:跳转漫展详情修改异常!"+cid,e);
		}
		return model;
	}
	
	/**
	 * 当前下的漫展修改
	 * @return
	 */
	@RequestMapping(value = "/manZhanEdit.do", method = RequestMethod.POST)
	public ResponseEntity<String> manZhanEdit(
			@RequestParam(value = "cid", required = false, defaultValue = "0") Integer cid,
			@RequestParam(value = "uid", required = false, defaultValue = "0") Integer uid,
			@RequestParam(value = "idtype", required = false, defaultValue = "1") Integer idtype,
			@RequestParam(value = "telephone", required = false, defaultValue = "") String telephone,
			@RequestParam(value = "qqcode", required = false, defaultValue = "") String qqcode,
			@RequestParam(value = "email", required = false, defaultValue = "") String email,
			@RequestParam(value = "title", required = false, defaultValue = "") String title,
			@RequestParam(value = "privurl", required = false, defaultValue = "") String privurl,
			@RequestParam(value = "cityname", required = false, defaultValue = "") String cityname,
			@RequestParam(value = "lat", required = false, defaultValue = "") String lat,
			@RequestParam(value = "lng", required = false, defaultValue = "") String lng,
			@RequestParam(value = "address", required = false, defaultValue = "") String address,
			@RequestParam(value = "starttime", required = false, defaultValue = "") String starttime,
			@RequestParam(value = "closetime", required = false, defaultValue = "") String closetime,
			@RequestParam(value = "pricetype", required = false, defaultValue = "") Integer pricetype,
			//票价方式 1 免费  2 收费
			@RequestParam(value = "price", required = false, defaultValue = "") double price,
			//订票方式
			@RequestParam(value = "tickettype", required = false, defaultValue = "") String tickettype,
			@RequestParam(value = "netticketaddress", required = false, defaultValue = "") String netticketaddress,
			@RequestParam(value = "content", required = false, defaultValue = "") String content,
			@RequestParam(value = "dateline", required = false, defaultValue = "") String dateline,
			
			@RequestParam(value = "faceimg", required = false, defaultValue = "0") Integer faceimgId,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..漫展修改!");
		String msg="";
		boolean isCorrect = true;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		try{
			//  get/new article
			TMzArticleContent article = manzhanService.findArticleContent(cid);
			
			article.setAddress(address);
			article.setCityname(cityname);
			article.setClosetime(closetime.replaceAll("-", ""));
			article.setContent(content);
			article.setDateline(dateline.replaceAll("-", ""));//时间格式化，去掉-
			article.setEmail(email);
			article.setFaceimg(faceimgId);//封面图片id
			article.setIdtype(idtype);
			article.setLat(lat);//经纬度
			article.setLng(lng);
			article.setNetticketaddress(netticketaddress);
			article.setPrice(price);
			article.setPricetype(pricetype);
			article.setPrivurl(privurl);
			article.setQqcode(qqcode);
			article.setStarttime(starttime.replaceAll("-", ""));
			article.setTelephone(telephone);
			article.setTickettype(tickettype);
			article.setTitle(title);
			article.setUid(uid);
			
			manzhanService.updateArticleContent(article);
			
			msg="漫展修改成功!";
		}catch(Exception e){
			logger.error("controller:漫展修改异常!"+title,e);
			msg="漫展修改出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/mzmanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
		}
		logger.info("controller:漫展修改结束!");
		return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/mzmanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
	}

	
	
	
	/**
	 * 当前下的漫展删除
	 * @return
	 */
	@RequestMapping(value = "/manZhanDel.do", method = RequestMethod.POST)
	public ResponseEntity<String> manZhanDel(
			@RequestParam(value = "cid", required = false, defaultValue = "0") Integer cid,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..漫展删除!");
		String msg="";
		boolean isCorrect = true;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		
		try{
			//  get/new article
			TMzArticleContent article = manzhanService.findArticleContent(cid);
			
			if(null != article){
				manzhanService.delArticleContent(article);
				msg="漫展删除成功!";
			}
		}catch(Exception e){
			logger.error("controller:漫展删除异常!"+cid,e);
			msg="漫展删除出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/mzmanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
		}
		logger.info("controller:漫展删除结束!");
		return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/mzmanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
	}

	
	
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
