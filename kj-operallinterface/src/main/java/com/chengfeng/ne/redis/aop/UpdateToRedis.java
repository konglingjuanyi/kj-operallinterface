package com.chengfeng.ne.redis.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: Jeff 
 * Date: 2015年6月30日下午1:41:52 
 * Copyright (c) 2015, HNCF All Rights Reserved.
 * 
 * History: .......
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UpdateToRedis {
	String key();
	//缓存字段，一般用来指定hashmap的key
	String fieldKey() default ""; 
	//缓存类型
	ReadCacheType cacheType();
	//用于list对象中获取mapkey的方法
	String mapKeymethodName() default "";
	//返回对象类型
	Class<?> classType() default Object.class;
}
