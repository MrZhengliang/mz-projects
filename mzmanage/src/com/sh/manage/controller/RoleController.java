package com.sh.manage.controller;




import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.sh.manage.entity.SysOperate;
import com.sh.manage.entity.SysRole;
import com.sh.manage.service.OperateService;
import com.sh.manage.service.RoleService;
import com.sh.manage.service.UserService;
import com.sh.manage.utils.ResponseUtils;
import com.sh.manage.utils.TimeUtil;
import com.sh.manage.utils.WebUtils;

/**
 * 权限管理
 * @author
 * 
 */

@Controller
public class RoleController {
	
	private Logger logger = Logger.getLogger(RoleController.class);


	@Autowired
	private UserService userService;
	
	/**
	 * 注入roleSerice包装
	 */
	@Autowired
	private RoleService roleService;
	
	/**
	 * 注入operateService包装
	 */
	@Autowired
	private OperateService operateService;
	
    /**
	 * 当前组织下的角色添加
	 * @return
	 */
	@RequestMapping(value = "/roleAdd.do", method = RequestMethod.POST)
	public ResponseEntity<String> roleAdd(
			@RequestParam(value = "groupId", required = false, defaultValue = "0") int groupId,
			@RequestParam(value = "roleName", required = false, defaultValue = "0") String roleName,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..组织角色添加!");
		String msg="";
		boolean isCorrect = true;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//new role
		SysRole role = new SysRole();
		role.setGroupId(groupId);
		role.setCreateTime(TimeUtil.getTime(14));
		role.setRoleName(roleName);
		role.setRemark("测试");
		role.setOperateId(1);//操作人员id，可以通过session获取
		
		try{
			roleService.addRole(role);
			msg="角色添加成功!";
		}catch(Exception e){
			logger.error("controller:添加角色异常!"+roleName,e);
			msg="添加角色出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/gmanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
			
		}
		logger.info("controller:添加角色结束!");
		return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/gmanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
	}
	
	/**
	 * 当前组织下的角色编辑
	 * @return
	 */
	@RequestMapping(value = "/roleEdit.do", method = RequestMethod.POST)
	public ResponseEntity<String> roleEdit(
			@RequestParam(value = "groupId", required = false, defaultValue = "0") int groupId,
			@RequestParam(value = "roleId", required = false, defaultValue = "0") int roleId,
			@RequestParam(value = "roleName", required = false, defaultValue = "0") String roleName,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..组织角色编辑!");
		String msg="";
		boolean isCorrect = true;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//new role
		SysRole role = new SysRole();
		role.setId(roleId);
		role.setGroupId(groupId);
		role.setRoleName(roleName);
		role.setRemark("测试");
		role.setOperateId(1);//操作人员id，可以通过session获取
		
		try{
			roleService.editRole(role);
			msg="角色编辑成功!";
		}catch(Exception e){
			logger.error("controller:编辑角色异常!"+roleName,e);
			msg="编辑角色出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/gmanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
			
		}
		logger.info("controller:编辑角色结束!");
		return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/gmanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
	}
	
	
	/**
	 * 当前组织下的角色删除
	 * @return
	 */
	@RequestMapping(value = "/roleDel.do", method = RequestMethod.POST)
	public ResponseEntity<String> roleDel(
			@RequestParam(value = "groupId", required = false, defaultValue = "0") int groupId,
			@RequestParam(value = "roleId", required = false, defaultValue = "0") int roleId,
			@RequestParam(value = "roleName", required = false, defaultValue = "0") String roleName,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..组织角色删除!");
		String msg="";
		boolean isCorrect = true;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//new role
		SysRole role = new SysRole();
		role.setId(roleId);
		role.setGroupId(groupId);
		role.setRoleName(roleName);
		role.setRemark("测试");
		role.setOperateId(1);//操作人员id，可以通过session获取
		
		try{
			roleService.delRole(role);
			msg="角色删除成功!";
		}catch(Exception e){
			logger.error("controller:删除角色异常!"+roleName,e);
			msg="删除角色出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/gmanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
			
		}
		logger.info("controller:删除角色结束!");
		return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/gmanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
	}

	
	
	
	
	/**
	 * 当前组织下的角色添加
	 * @return
	 */
	@RequestMapping(value = "/roleAddExt.do", method = RequestMethod.POST)
	public ResponseEntity<String> roleAddExt(
			@RequestParam(value = "groupIndex", required = false, defaultValue = "") Integer gIndex,
			@RequestParam(value = "groupId", required = false, defaultValue = "0") int groupId,
			@RequestParam(value = "roleName", required = false, defaultValue = "0") String roleName,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..组织角色添加!");
		String msg="";
		boolean isCorrect = true;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//new role
		SysRole role = new SysRole();
		role.setGroupId(groupId);
		role.setCreateTime(TimeUtil.getTime(14));
		role.setRoleName(roleName);
		role.setRemark("测试");
		role.setOperateId(1);//操作人员id，可以通过session获取
		
		try{
			roleService.addRole(role);
			msg="角色添加成功!";
		}catch(Exception e){
			logger.error("controller:添加角色异常!"+roleName,e);
			msg="添加角色出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/gmanageExt.do?gIndex="+gIndex)+"'</script>",responseHeaders, HttpStatus.CREATED);
			
		}
		logger.info("controller:添加角色结束!");
		return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/gmanageExt.do?gIndex="+gIndex)+"'</script>",responseHeaders, HttpStatus.CREATED);
	}
	
	/**
	 * 当前组织下的角色编辑
	 * @return
	 */
	@RequestMapping(value = "/roleEditExt.do", method = RequestMethod.POST)
	public ResponseEntity<String> roleEditExt(
			@RequestParam(value = "groupIndex", required = false, defaultValue = "") Integer gIndex,
			@RequestParam(value = "groupId", required = false, defaultValue = "0") int groupId,
			@RequestParam(value = "roleId", required = false, defaultValue = "0") int roleId,
			@RequestParam(value = "roleName", required = false, defaultValue = "0") String roleName,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..组织角色编辑!");
		String msg="";
		boolean isCorrect = true;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//new role
		SysRole role = new SysRole();
		role.setId(roleId);
		role.setGroupId(groupId);
		role.setRoleName(roleName);
		role.setRemark("测试");
		role.setOperateId(1);//操作人员id，可以通过session获取
		
		try{
			roleService.editRole(role);
			msg="角色编辑成功!";
		}catch(Exception e){
			logger.error("controller:编辑角色异常!"+roleName,e);
			msg="编辑角色出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/gmanageExt.do?gIndex="+gIndex)+"'</script>",responseHeaders, HttpStatus.CREATED);
			
		}
		logger.info("controller:编辑角色结束!");
		return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/gmanageExt.do?gIndex="+gIndex)+"'</script>",responseHeaders, HttpStatus.CREATED);
	}
	
	
	/**
	 * 当前组织下的角色删除
	 * @return
	 */
	@RequestMapping(value = "/roleDelExt.do", method = RequestMethod.POST)
	public ResponseEntity<String> roleDelExt(
			@RequestParam(value = "groupIndex", required = false, defaultValue = "") Integer gIndex,
			@RequestParam(value = "groupId", required = false, defaultValue = "0") int groupId,
			@RequestParam(value = "roleId", required = false, defaultValue = "0") int roleId,
			@RequestParam(value = "roleName", required = false, defaultValue = "0") String roleName,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..组织角色删除!");
		String msg="";
		boolean isCorrect = true;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//new role
		SysRole role = new SysRole();
		role.setId(roleId);
		role.setGroupId(groupId);
		role.setRoleName(roleName);
		role.setRemark("测试");
		role.setOperateId(1);//操作人员id，可以通过session获取
		
		try{
			roleService.delRole(role);
			msg="角色删除成功!";
		}catch(Exception e){
			logger.error("controller:删除角色异常!"+roleName,e);
			msg="删除角色出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/gmanageExt.do?gIndex="+gIndex)+"'</script>",responseHeaders, HttpStatus.CREATED);
			
		}
		logger.info("controller:删除角色结束!");
		return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/gmanageExt.do?gIndex="+gIndex)+"'</script>",responseHeaders, HttpStatus.CREATED);
	}
	
	
	
	/**
	 * 当前组织下的角色添加
	 * @return
	 */
	@RequestMapping(value = "/roleAddExtAu.do", method = RequestMethod.POST)
	public ResponseEntity<String> roleAddExtAu(
			@RequestParam(value = "groupIndex", required = false, defaultValue = "") Integer gIndex,
			@RequestParam(value = "groupId", required = false, defaultValue = "0") int groupId,
			@RequestParam(value = "roleName", required = false, defaultValue = "0") String roleName,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..组织角色添加!");
		String msg="";
		boolean isCorrect = true;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//new role
		SysRole role = new SysRole();
		role.setGroupId(groupId);
		role.setCreateTime(TimeUtil.getTime(14));
		role.setRoleName(roleName);
		role.setRemark("测试");
		role.setOperateId(1);//操作人员id，可以通过session获取
		
		try{
			roleService.addRole(role);
			msg="角色添加成功!";
		}catch(Exception e){
			logger.error("controller:添加角色异常!"+roleName,e);
			msg="添加角色出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/gmanageAuser.do?groupIndex="+gIndex)+"'</script>",responseHeaders, HttpStatus.CREATED);
			
		}
		logger.info("controller:添加角色结束!");
		return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/gmanageAuser.do?groupIndex="+gIndex)+"'</script>",responseHeaders, HttpStatus.CREATED);
	}
	
	/**
	 * 当前组织下的角色编辑
	 * @return
	 */
	@RequestMapping(value = "/roleEditExtAu.do", method = RequestMethod.POST)
	public ResponseEntity<String> roleEditExtAu(
			@RequestParam(value = "groupIndex", required = false, defaultValue = "") Integer gIndex,
			@RequestParam(value = "groupId", required = false, defaultValue = "0") int groupId,
			@RequestParam(value = "roleId", required = false, defaultValue = "0") int roleId,
			@RequestParam(value = "roleName", required = false, defaultValue = "0") String roleName,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..组织角色编辑!");
		String msg="";
		boolean isCorrect = true;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//new role
		SysRole role = new SysRole();
		role.setId(roleId);
		role.setGroupId(groupId);
		role.setRoleName(roleName);
		role.setRemark("测试");
		role.setOperateId(1);//操作人员id，可以通过session获取
		
		try{
			roleService.editRole(role);
			msg="角色编辑成功!";
		}catch(Exception e){
			logger.error("controller:编辑角色异常!"+roleName,e);
			msg="编辑角色出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/gmanageAuser.do?groupIndex="+gIndex)+"'</script>",responseHeaders, HttpStatus.CREATED);
			
		}
		logger.info("controller:编辑角色结束!");
		return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/gmanageAuser.do?groupIndex="+gIndex)+"'</script>",responseHeaders, HttpStatus.CREATED);
	}
	
	
	/**
	 * 当前组织下的角色删除
	 * @return
	 */
	@RequestMapping(value = "/roleDelExtAu.do", method = RequestMethod.POST)
	public ResponseEntity<String> roleDelExtAu(
			@RequestParam(value = "groupIndex", required = false, defaultValue = "") Integer gIndex,
			@RequestParam(value = "groupId", required = false, defaultValue = "0") int groupId,
			@RequestParam(value = "roleId", required = false, defaultValue = "0") int roleId,
			@RequestParam(value = "roleName", required = false, defaultValue = "0") String roleName,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..组织角色删除!");
		String msg="";
		boolean isCorrect = true;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//new role
		SysRole role = new SysRole();
		role.setId(roleId);
		role.setGroupId(groupId);
		role.setRoleName(roleName);
		role.setRemark("测试");
		role.setOperateId(1);//操作人员id，可以通过session获取
		
		try{
			roleService.delRole(role);
			msg="角色删除成功!";
		}catch(Exception e){
			logger.error("controller:删除角色异常!"+roleName,e);
			msg="删除角色出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/gmanageAuser.do?groupIndex="+gIndex)+"'</script>",responseHeaders, HttpStatus.CREATED);
			
		}
		logger.info("controller:删除角色结束!");
		return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/gmanageAuser.do?groupIndex="+gIndex)+"'</script>",responseHeaders, HttpStatus.CREATED);
	}
	
	
	
	
	
	/*******************************************************************
	 *********************功能分割***************************
	 ********************************************************************/
	
	/**
	 * 当前组织下的角色按钮设置
	 * @return
	 */
	@RequestMapping(value = "/addRoleBtn.do", method = RequestMethod.POST)
	public @ResponseBody String editRoleBtn(
			@RequestParam(value = "roleId", required = false, defaultValue = "") Integer roleId,
			@RequestParam(value = "operateId", required = false, defaultValue = "") Integer operateId,
			@RequestParam(value = "model_code", required = false, defaultValue = "0") String model_code,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..角色按钮编辑!");
		String msg="";
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		try{
			/*通过model_code查询某个操作实体*/
			SysOperate sysOperate = operateService.findSysOperate(model_code);
			
			SysRole sysRole = roleService.findSysRole(roleId);//获取角色
			Set<SysOperate> operSet = sysRole.getOperateSet();//操作集合
			
			Set<SysOperate> oldOperSet = new HashSet<SysOperate>();//之前的操作集合
			Set<SysOperate> newOperSet = new HashSet<SysOperate>();//新的操作集合
			for(SysOperate sysOper:operSet){
				//循环处理操作按钮
				if(!sysOper.getOperateCode().equals(sysOperate.getOperateCode())){
					//添加进去新的
					newOperSet.add(sysOperate);
				}else{
					//添加之前的
					newOperSet.add(sysOper);
					oldOperSet.add(sysOper);
				}
			}
			
			//追加新的操作按钮
			sysRole.getOperateSet().addAll(newOperSet);
			roleService.editRole(sysRole);
			msg="按钮编辑完成";
		}catch(Exception e){
			logger.error("controller:角色按钮编辑异常!"+roleId+","+model_code,e);
			msg="角色按钮编辑出现异常";
			model.addAttribute("msg", msg);
			return ResponseUtils.newJsonOKResp(msg);
			
		}
		logger.info("controller:角色按钮编辑结束!");
		return ResponseUtils.newJsonOKResp(msg);
	}
	
	/**
	 * 当前组织下的角色按钮删除
	 * @return
	 */
	@RequestMapping(value = "/delRoleBtn.do", method = RequestMethod.POST)
	public @ResponseBody String delRoleBtn(
			@RequestParam(value = "roleId", required = false, defaultValue = "") Integer roleId,
			@RequestParam(value = "model_code", required = false, defaultValue = "0") String model_code,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..角色按钮删除!");
		String msg="";
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		try{
			/*通过model_code查询某个操作实体*/
			SysOperate sysOperate = operateService.findSysOperate(model_code);
			
			SysRole sysRole = roleService.findSysRole(roleId);//获取角色
			Set<SysOperate> operSet = sysRole.getOperateSet();//操作集合
			
			Set<SysOperate> oldOperSet = new HashSet<SysOperate>();//之前的操作集合
			Set<SysOperate> delOperSet = new HashSet<SysOperate>();//新的操作集合
			for(SysOperate sysOper:operSet){
				//循环处理操作按钮
				if(sysOper.getOperateCode().equals(sysOperate.getOperateCode())){
					//存在当前按钮
					delOperSet.add(sysOperate);
				}else{
					//添加之前的
					oldOperSet.add(sysOper);
				}
			}
			
			//追加新的操作按钮
			sysRole.getOperateSet().removeAll(delOperSet);
			sysRole.getOperateSet().addAll(oldOperSet);
			roleService.editRole(sysRole);
			msg="按钮取消完成";
		}catch(Exception e){
			logger.error("controller:角色按钮删除异常!"+roleId+","+model_code,e);
			msg="角色按钮删除出现异常";
			model.addAttribute("msg", msg);
			return ResponseUtils.newJsonOKResp(msg);
			
		}
		logger.info("controller:角色按钮删除结束!");
		return ResponseUtils.newJsonOKResp(msg);
	}
	
}
