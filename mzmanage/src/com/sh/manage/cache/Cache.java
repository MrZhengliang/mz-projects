package com.sh.manage.cache;

/**
 * 缓存类. <br>
 * 缓存数据用。
 * <p>
 * <p>
 * Copyright: Copyright (c) 2014年11月30日
 * <p>
 * Company: ff
 * <p>
 * Author: fuzl
 * <p>
 * Version: 1.0
 * <p>
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Cache<T> implements Serializable {

	/**
	 * Version UID
	 */
	private static final long serialVersionUID = 5155143592708080933L;

	/** 容器 */
	public List<T> cacheList = new ArrayList<T>();
	
	/**
	 * 构造函数
	 */
	public Cache() {
		
	}
	
	/**
	 * 清空缓存
	 */
	public void clear() {
		cacheList.clear();
	}
	
	public List<T> getCacheList() {
		return cacheList;
	}
	
	/**
	 * 初始化
	 */
	public abstract void init();

	/**
	 * 刷新缓存
	 */
	public void refresh() {
		clear();
		init();
	}

	public void setCacheList(List<T> cacheList) {
		this.cacheList = cacheList;
	}
}
