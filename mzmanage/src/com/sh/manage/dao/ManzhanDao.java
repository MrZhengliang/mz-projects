/**
 * 
 */
package com.sh.manage.dao;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;


import com.sh.manage.entity.TMzArticleContent;
import com.sh.manage.module.page.Page;

/**
 * 用户数据访问类
 * 
 * @author
 * 
 */
@Repository
public class ManzhanDao extends AbstractBaseDao<TMzArticleContent> {


	/**
	 * 获取全部漫展信息
	 * @param cityName  发布城市
	 * @param startDate 开始时间
	 * @param endDate   结束时间
	 * @param priceType 价格类型
	 * @param pageNo    页码
	 * @param pageSize  每页条数
	 * @return
	 */
	public Page getAllTMzArticleContent(String cityName, String startDate,
			String endDate,Integer priceType, Integer pageNo, int pageSize) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("select rt.* from (select m.cid,m.uid,m.idtype,m.telephone,m.qqcode,m.email,m.title,m.privurl,m.cityname,m.lat,m.lng,m.address,m.starttime,m.closetime,m.pricetype,m.price,m.tickettype,m.netticketaddress,m.content,m.dateline,m.faceimg,m.status from t_mz_articlecontent m");
		sbf.append(" where 1 = 1 ");
		Object[] params = new Object[]{};
		
		if(!StringUtils.isEmpty(cityName)){
			sbf.append(" and m.cityname like '%"+cityName+"%'");
		}
		if(!StringUtils.isEmpty(startDate)){
			params = ArrayUtils.add(params, startDate);
			sbf.append(" and m.starttime >= ?");
		}
		if(!StringUtils.isEmpty(endDate)){
			params = ArrayUtils.add(params, endDate);
			sbf.append(" and m.closetime <= ?");
		}
		if(priceType > 0 ){
			params = ArrayUtils.add(params, priceType);
			sbf.append(" and m.pricetype = ?");
		}

		sbf.append(") as rt");
		return this.queryModelListByPage(sbf.toString(), params, pageNo, pageSize, TMzArticleContent.class);
	}
	
	
	
	
	
	/**
	 * 增加
	 */
	@Override
	public void addObject(TMzArticleContent articleContent) {
		this.getCurrentSession().save(articleContent);
	}
	/**
	 * 更新
	 */
	@Override
	public void updateObject(TMzArticleContent articleContent) {
		this.getCurrentSession().saveOrUpdate(articleContent);
	}

	/**
	 * 删除
	 */
	@Override
	public void deleteObject(TMzArticleContent articleContent) {
		this.getCurrentSession().delete(articleContent);
	}

	/**
	 * 查询
	 */
	@Override
	public TMzArticleContent getObject(TMzArticleContent articleContent) {
		String hql = "from TMzArticleContent where cid=";
		hql += articleContent.getCid();
		Query query = this.getCurrentSession().createQuery(hql);
		return (TMzArticleContent) query.list().get(0);
	}

	

	/**
	 * 查找某个漫展信息
	 * @param auid
	 */
	public List<TMzArticleContent> findTMzArticleContentById(Integer cid) {
		String hql = "from TMzArticleContent where cid = ";
		hql += cid;
		return this.find(hql);
	}
	
}
