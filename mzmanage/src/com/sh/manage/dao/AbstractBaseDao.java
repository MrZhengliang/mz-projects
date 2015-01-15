package com.sh.manage.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sh.manage.exception.SPlatformDaoException;
import com.sh.manage.module.page.Page;

/**
 * @author dao抽象基础类 已经实现了一些基础功能
 * 
 */
@Repository
public abstract class AbstractBaseDao<T> {

	// hibernate3使用
	// protected AnnotationSessionFactoryBean sessionFactory;
	//
	// public AnnotationSessionFactoryBean getSessionFactory() {
	// return sessionFactory;
	// }
	//
	// @Autowired
	// public void setSessionFactory(AnnotationSessionFactoryBean
	// sessionFactory) {
	// this.sessionFactory = sessionFactory;
	// }
	@Autowired
	protected SessionFactory sessionFactory;

	// hibernate 4 使用  不用继承HibernateDaoSupport,也没有HibernateDaoSupport
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();// 还是可以得到session
	}

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public abstract void addObject(T clazz);

	public abstract void updateObject(T clazz);

	public abstract void deleteObject(T clazz);

	public abstract T getObject(T clazz);

	public Serializable save(T o) {
		Serializable result = this.getCurrentSession().save(o);
		this.getCurrentSession().flush();
		return result;
	}

	/**
	 * 删除
	 * @param o
	 */
	public void delete(T o) {
		this.getCurrentSession().delete(o);
		this.getCurrentSession().flush();
	}
	/**
	 * 更新
	 * @param o
	 */
	public void update(T o) {
		this.getCurrentSession().update(o);
		this.getCurrentSession().flush();
	}
	/**
	 * 保存或者更新
	 * @param o
	 */
	public void saveOrUpdate(T o) {
		this.getCurrentSession().saveOrUpdate(o);
		this.getCurrentSession().flush();
	}

	/**
	 * 执行hql返回list
	 * 
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> find(String hql) {
		return this.getCurrentSession().createQuery(hql).list();
	}

	/**
	 * 查询集合
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> find(String hql, Object[] param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}

	/**
	 * 查询集合
	 * 
	 * @param hql
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> find(String hql, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.list();
	}

	/**
	 * 查询集合(带分页)
	 * 
	 * @param hql
	 * @param param
	 * @param page
	 *            查询第几页
	 * @param rows
	 *            每页显示几条记录
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> find(String hql, Object[] param, Integer page, Integer rows) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}

		Query q = this.getCurrentSession().createQuery(hql);

		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	/**
	 * 查询集合(带分页)
	 * 
	 * @param hql
	 * @param param
	 * @param page
	 * @param rows
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> find(String hql, List<Object> param, Integer page,
			Integer rows) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	/**
	 * 获得一个对象
	 * 
	 * @param c
	 *            对象类型
	 * @param id
	 * @return Object
	 */
	@SuppressWarnings("unchecked")
	public T get(Class<T> c, Serializable id) {
		return (T) this.getCurrentSession().get(c, id);
	}

	public T get(String hql, Object[] param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	public T get(String hql, List<Object> param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	public Long count(String hql) {
		return (Long) this.getCurrentSession().createQuery(hql).uniqueResult();
	}

	public Long count(String hql, Object[] param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return (Long) q.uniqueResult();
	}

	public Long count(String hql, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return (Long) q.uniqueResult();
	}

	public Integer executeHql(String hql) {
		return this.getCurrentSession().createQuery(hql).executeUpdate();
	}

	public Integer executeHql(String hql, Object[] param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.executeUpdate();
	}

	public Integer executeHql(String hql, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.executeUpdate();
	}

	/**
	 * sql查询 分页查询列表
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> querySqlList(final String sqlStr,
			final Object[] paras, final int pageNo, final int pageSize)
			throws SPlatformDaoException {
		List<Object[]> objList = new ArrayList<Object[]>();

		Query query = this.getCurrentSession().createSQLQuery(sqlStr);

		if (null != paras && paras.length > 0) {
			int count = 0;
			for (Object para : paras) {
				query.setParameter(count++, para);
			}
		}
		query.setFirstResult((pageNo - 1) * pageSize);
		query.setMaxResults(pageSize);
		objList = query.list();

		return objList;
	}

	/**
	 * 根据条件查询，返回结果数量
	 */
	public int getCount(String sqlStr, Object[] paras)
			throws SPlatformDaoException {
		try {
			Long count;
			sqlStr = "select count(*) "
					+ sqlStr.substring(sqlStr.indexOf("from"));

			Query query = this.getCurrentSession().createQuery(sqlStr);
			int i = 0;
			if (null != paras && paras.length > 0) {
				for (Object para : paras) {
					query.setParameter(i++, para);
				}
			}
			count = Long.parseLong(query.uniqueResult().toString());
			return Integer.parseInt(count.toString());
		} catch (Exception e) {
			throw new SPlatformDaoException("通过条件获得总数量失败", e);
		}
	}

	/**
	 * 查询数据的列表
	 */
	@SuppressWarnings("unchecked")
	public List<T> queryList(final String sqlStr, final Object[] paras)
			throws SPlatformDaoException {
		List<T> objList = new ArrayList<>();
		int count = 0;
		Query query = this.getCurrentSession().createSQLQuery(sqlStr);
		if (null != paras && paras.length > 0) {
			for (Object para : paras) {
				query.setParameter(count++, para);
			}
		}
		objList = query.list();
		return objList;
	}

	/**
	 * 查询数据的列表
	 */
	@SuppressWarnings("unchecked")
	public List<Object> querysqlList(final String sqlStr, final Object[] paras)
			throws SPlatformDaoException {
		List<T> objList = new ArrayList<>();
		int count = 0;
		Query query = this.getCurrentSession().createSQLQuery(sqlStr);
		if (null != paras && paras.length > 0) {
			for (Object para : paras) {
				query.setParameter(count++, para);
			}
		}
		objList = query.list();
		return (List<Object>) objList;
	}

	// /**
	// * 分页查询列表
	// */
	// @SuppressWarnings("unchecked")
	// public List<Object[]> querySqlList(final String sqlStr, final Object[]
	// paras, final int pageNo, final int pageSize) throws DAOException {
	// List<T> objList = new ArrayList<>();
	//
	// int count = 0;
	//
	// Query query = this.getCurrentSession().createSQLQuery(sqlStr);
	//
	// if (null != paras && paras.length > 0) {
	// for (Object para : paras) {
	// query.setParameter(count++, para);
	// }
	// }
	// query.setFirstResult((pageNo - 1) * pageSize);
	// query.setMaxResults(pageSize);
	// objList = query.list();
	// return objList;
	// }

	/**
	 * 查询数据的列表
	 */
	@SuppressWarnings("unchecked")
	public List<T> queryhqlList(final String sqlStr, final Object[] paras)
			throws SPlatformDaoException {
		List<T> objList = new ArrayList<>();
		int count = 0;
		Query query = this.getCurrentSession().createQuery(sqlStr);
		if (null != paras && paras.length > 0) {
			for (Object para : paras) {
				query.setParameter(count++, para);
			}
		}
		objList = query.list();
		return objList;
	}

	/**
	 * 分页查询列表
	 */
	@SuppressWarnings("unchecked")
	public Page queryList(final String sqlStr, final Object[] paras,
			final int pageNo, final int pageSize) throws SPlatformDaoException {
		List<T> objList = new ArrayList<>();
		int count = 0;
		Query query = this.getCurrentSession().createQuery(sqlStr);
		if (null != paras && paras.length > 0) {
			for (Object para : paras) {
				query.setParameter(count++, para);
			}
		}
		query.setFirstResult((pageNo - 1) * pageSize);
		query.setMaxResults(pageSize);
		objList = query.list();
		int resCount = this.getCount(sqlStr, paras);
		Page page = new Page();
		page.setPageSize(pageSize);
		page.search(resCount);
		page.turnToPage(pageNo);
		page.setList(objList);
		return page;
	}

	/**
	 * 分页查询纯Sql
	 */

	@SuppressWarnings("unchecked")
	public Page querySqlListByPage(final String sqlStr, final Object[] paras,
			final int pageNo, final int pageSize) {
		List<T> objList = new ArrayList<>();
		int count = 0;
		Query query = this.getCurrentSession().createSQLQuery(sqlStr);
		if (null != paras && paras.length > 0) {
			for (Object para : paras) {
				query.setParameter(count++, para);
			}
		}
		query.setFirstResult((pageNo - 1) * pageSize);
		query.setMaxResults(pageSize);
		objList = query.list();
		int resCount = this.getCountBySql(sqlStr, paras);
		Page page = new Page();
		page.setPageSize(pageSize);
		page.search(resCount);
		page.turnToPage(pageNo);
		page.setList(objList);
		return page;
	}

	/**
	 * 分页查询纯Sql
	 * 
	 * @param sqlStr
	 *            sql查询语句
	 * @param paras
	 *            sql语句中需要传递的参数
	 * @return
	 * @throws
	 * @history add by fuzl
	 */
	@SuppressWarnings("unchecked")
	public Page queryModelListByPage(final String sqlStr, final Object[] paras,
			final int pageNo, final int pageSize, @SuppressWarnings("rawtypes") final Class clazz) {
		List<T> objList = new ArrayList<>();
		int count = 0;
		Query query = this.getCurrentSession().createSQLQuery(sqlStr)
				.addEntity(clazz);

		if (null != paras && paras.length > 0) {
			for (Object para : paras) {
				query.setParameter(count++, para);
			}
		}
		query.setFirstResult((pageNo - 1) * pageSize);
		query.setMaxResults(pageSize);
		objList = query.list();

		int resCount = this.getCountBySql(sqlStr, paras);
		Page page = new Page();
		page.setPageSize(pageSize);
		page.search(resCount);
		page.turnToPage(pageNo);
		page.setList(objList);
		return page;
	}

	// /**
	// * 分页查询纯Sql
	// */
	//
	// @SuppressWarnings("unchecked")
	// public OtherPage querySqlListByOtherPage(final String sqlStr, final
	// Object[] paras, final int pageNo, final int pageSize) {
	// // TODO Auto-generated method stub
	// List<T> objList = getHibernateTemplate().executeFind(new
	// HibernateCallback<List<?>>() {
	//
	//
	// public List<?> doInHibernate(Session session) throws DataAccessException
	// {
	// int count = 0;
	//
	// Query query = session.createSQLQuery(sqlStr);
	//
	// if (null != paras && paras.length > 0) {
	// for (Object para : paras) {
	// query.setParameter(count++, para);
	// }
	// }
	// query.setFirstResult((pageNo - 1) * pageSize);
	// query.setMaxResults(pageSize);
	// return query.list();
	// }
	// });
	// int count = this.getCountBySql(sqlStr, paras);
	// OtherPage page = new OtherPage();
	// page.setPageSize(pageSize);
	// page.search(count);
	// page.turnToPage(pageNo);
	// page.setList(objList);
	// return page;
	// }

	/**
	 * 分页查询列表
	 */
	@SuppressWarnings("unchecked")
	public List<T> queryForList(final String sqlStr, final Object[] paras,
			final int pageNo, final int pageSize) throws SPlatformDaoException {
		List<T> objList = new ArrayList<>();
		int count = 0;
		Query query = this.getCurrentSession().createQuery(sqlStr);
		if (null != paras && paras.length > 0) {
			for (Object para : paras) {
				query.setParameter(count++, para);
			}
		}
		query.setFirstResult((pageNo - 1) * pageSize);
		query.setMaxResults(pageSize);
		objList = query.list();

		return objList;
	}

	/**
	 * 查询配置文件中的sql语句
	 */

	public String querySql(final String sqlName) throws SPlatformDaoException {
		String result = "";
		result = this.getCurrentSession().getNamedQuery(sqlName)
				.getQueryString();
		return result;
	}

	/**
	 * 执行sql命令
	 */
	public int executeSqlQuery(final String sqlStr, final Object[] paras)
			throws SPlatformDaoException {
		int result = 0;
		int count = 0;
		Query query = this.getCurrentSession().createSQLQuery(sqlStr);
		if (null != paras && paras.length > 0) {
			for (Object para : paras) {
				query.setParameter(count++, para);
			}
		}
		result = query.executeUpdate();
		return result;
	}

	/**
	 * 根据查询语句返回从结果数
	 */
	public int getCountBySql(String sqlStr, Object[] paras) {
		Long count;
		//sqlStr = "select count(*) from (" + sqlStr + ")";
		sqlStr = "select count(*) from (" + sqlStr + ") as cnt";//mysql需要加上别名
		Query query = this.getCurrentSession().createSQLQuery(sqlStr);
		int i = 0;
		if (null != paras && paras.length > 0) {
			for (Object para : paras) {
				query.setParameter(i++, para);
			}
		}
		count = Long.parseLong(query.uniqueResult().toString());
		return Integer.parseInt(count.toString());
	}

	/**
	 * 查询某个Model的数据的列表
	 * 
	 * @param sqlStr
	 *            sql查询语句
	 * @param paras
	 *            sql语句中需要传递的参数
	 * @return
	 * @throws DataAccessException
	 * @history add by fuzl
	 */
	@SuppressWarnings("rawtypes")
	protected List<?> queryModelSqlList(final String sqlStr,
			final Object[] paras, final Class clazz) throws DataAccessException {
		List<?> objList = new ArrayList<>();
		int count = 0;
		Query query = this.getCurrentSession().createSQLQuery(sqlStr)
				.addEntity(clazz);
		if (null != paras && paras.length > 0) {
			for (Object para : paras) {
				query.setParameter(count++, para);
			}
		}
		objList = query.list();
		return objList;
	}
}
