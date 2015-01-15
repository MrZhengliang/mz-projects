package com.sh.manage.cache;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * K-V缓存类. <br>
 * K-V缓存数据用。
 * <p>
 * 创建类 <br>
 * <p>
 * <p>
 * <p>
 * @version 1.0
 */
public abstract class MapCache<K, V> implements Serializable {

	/**
	 * Version UID
	 */
	private static final long serialVersionUID = 2781808873194577184L;

	/** 容器 */
	public Map<K, V> cacheMap = new HashMap<K, V>();
	
	/**
	 * 构造函数
	 */
	public MapCache() {
		
	}
	
	/**
	 * 清空缓存
	 */
	public void clear() {
		cacheMap.clear();
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
}
