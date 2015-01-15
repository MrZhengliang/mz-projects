/**
 * 
 */
package com.sh.manage.service;

import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.manage.dao.OperateDao;
import com.sh.manage.entity.SysOperate;
import com.sh.manage.exception.SPlatformServiceException;

/**
 * 
 * 角色服务类
 * 
 * @author
 * 
 */
@Service
public class OperateService extends BaseService {

	private Logger logger = Logger.getLogger(OperateService.class);

	@Autowired
	private OperateDao operateDao;

	/** 每页显示行数 */
	@SuppressWarnings("unused")
	private static final int ROW_CNT_PER_PAGE = 20;
	
	/**
	 * 查找操作
	 * @param operateId
	 */
	public SysOperate findSysOperate(String model_code)throws SPlatformServiceException {
		try {
			List<SysOperate> sysOperateList = operateDao.findSysOperate(model_code);
			//找到了操作
			if(null != sysOperateList){
				return sysOperateList.get(0);
			}
			//找不到操作
			return new SysOperate();
		} catch (Exception e) {
			logger.error("service:查询系统角色信息出现异常", e);
			throw new SPlatformServiceException("查询系统角色信息出现异常");
		}
	}
	
}
