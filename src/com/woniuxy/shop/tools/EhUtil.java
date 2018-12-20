package com.woniuxy.shop.tools;
	

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;

public class EhUtil {
	private static Cache dc;
	static {
		CacheManager manager = CacheManager.create();
		dc = new Cache("shop", 0, false, false, 0, 0);
		CacheConfiguration config = dc.getCacheConfiguration();
		config.setMaxElementsInMemory(10000);
		config.setEternal(false);
		config.setTimeToIdleSeconds(60);
		config.setTimeToLiveSeconds(60);
		config.setMaxElementsOnDisk(10000000);
		config.setDiskExpiryThreadIntervalSeconds(120);
		config.setMemoryStoreEvictionPolicy("LRU");
		manager.addCache(dc);
	}
	
	public Object find(String key){
		Element e = dc.get(key);
		if(null == e){
			return null;
		}else{
			Object o = e.getObjectValue();
			return o;
		}
		
	}
	
	public void put(String key,Object obj){
		Element e = new Element(key, obj);
		dc.put(e);
	}
}
