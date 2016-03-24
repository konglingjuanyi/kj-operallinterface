package com.chengfeng.ne.redis.aop;  

 /**  
 * Author: Jeff
 * Date: 2015年6月30日下午4:55:45  
 * Copyright (c) 2015, HNCF All Rights Reserved.  
 *  
 * History: 
 * .......
 */
public enum ReadCacheType {
	List,//[key,map[key,List<Object>]]
	Set,//
	Map,//从MAP里面根据mapkey返回一个对象
	Maps,//dao中返回List结果集时
	String
}
