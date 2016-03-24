package com.chengfeng.ne.redis.aop;  

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

 /**  
 * Author: Jeff
 * Date: 2015年7月3日上午9:04:15  
 * Copyright (c) 2015, HNCF All Rights Reserved.  
 *  
 * History: 
 * .......
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AddToRedis {
	String key();
	//缓存字段，一般用来指定hashmap的key
	//String fieldKey() ; 
	//缓存类型
	ReadCacheType cacheType();
	
	Class<?> classType() default Object.class;
	// 默认过期时间，单位秒
	int expireTime() default 0;
}
  
