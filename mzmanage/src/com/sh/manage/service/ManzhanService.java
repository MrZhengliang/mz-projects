/**
 * 
 */
package com.sh.manage.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.manage.dao.ManzhanDao;
import com.sh.manage.entity.TMzArticleContent;
import com.sh.manage.exception.SPlatformServiceException;
import com.sh.manage.module.page.Page;

/**
 * ManzhanService
 * @author
 * 
 */
@Service
public class ManzhanService extends BaseService {

	private Logger logger = Logger.getLogger(ManzhanService.class);
	
	@Autowired
	private ManzhanDao manzhanDao;

	/**
	 * 添加漫展
	 * 
	 * @param articleContent
	 * @return
	 */
	public void addArticleContent(TMzArticleContent articleContent) {
		manzhanDao.addObject(articleContent);
	}

	/**
	 * 更新漫展
	 * 
	 * @param articleContent
	 * @return
	 */
	public void updateArticleContent(TMzArticleContent articleContent) {
		manzhanDao.saveOrUpdate(articleContent);
	}

	/**
	 * 获取单个漫展
	 * 
	 * @param articleContent
	 * @return
	 */
	public TMzArticleContent getArticleContent(TMzArticleContent articleContent) {
		return manzhanDao.getObject(articleContent);
	}

	/**
	 * 删除单个漫展
	 * @param articleContent
	 * @return
	 */
	public void delArticleContent(TMzArticleContent articleContent) {
		manzhanDao.delete(articleContent);
	};

	
	/**
	 * 查找漫展
	 * @param aUser
	 */
	public TMzArticleContent findArticleContent(Integer cid)throws SPlatformServiceException {
		try {
			List<TMzArticleContent> articleContentList = manzhanDao.findTMzArticleContentById(cid);
			//找到了漫展
			if(null != articleContentList){
				return articleContentList.get(0);
			}
			//找不到漫展
			return new TMzArticleContent();
		} catch (Exception e) {
			logger.error("service:查询m信息出现异常", e);
			throw new SPlatformServiceException("查询漫展信息出现异常");
		}
	}
	
	/**
	 * 查询所有漫展
	 * @param cityName
	 * @param usercode
	 * @param startDate
	 * @param endDate
	 * @param priceType
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page findAllTMzArticleContent(String cityName, String usercode, String startDate,
			String endDate,Integer priceType, Integer pageNo, int pageSize) {
		return manzhanDao.getAllTMzArticleContent(cityName, startDate, endDate, priceType, pageNo, pageSize);
	}



}
