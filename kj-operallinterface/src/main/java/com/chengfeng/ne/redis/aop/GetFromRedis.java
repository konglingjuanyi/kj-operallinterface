package com.chengfeng.ne.redis.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Author: Jeff 
 * Date: 2015年6月30日下午1:41:33 
 * Copyright (c) 2015, HNCF All Rights Reserved.
 * 
 * History: .......
 */
// 表示注解的信息被保留在class文件(字节码文件)中当程序编译时，会被虚拟机保留在运行时,所以他们可以用反射的方式读取
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)//修饰的注解表示该注解只能用来修饰在方法上
public @interface GetFromRedis { //定义个一注解@GetFromRedis，用RetentionPolicy.RUNTIME修饰；
	// 缓存的key的命名空间，如果注解中有一个属性名字叫value,则在应用时可以省略属性名字不写。 
	String key();
	//缓存字段，一般用来指定hashmap的key
	String fieldKey() default ""; 
	//缓存类型
	ReadCacheType cacheType();
	//用于list对象中获取mapkey的方法
	String mapKeymethodName() default "";
	//返回对象类型
	Class<?> classType() default Object.class;
	// 默认过期时间，单位秒
	int expireTime() default 0;

}
