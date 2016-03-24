package com.chengfeng.ne.redis.service;  

import java.util.List;
import java.util.Map;
import java.util.Set;

 /**  
 * Author: Jeff
 * Date: 2015年6月23日上午11:12:30  
 * Copyright (c) 2015, HNCF All Rights Reserved.  
 *  
 * History: 
 * .......
 */
public interface RedisCommandService {
	//----------------String-------------------
	/**
	 * 给一个 KEY 设置一个 值 ，并且设置有效时间
	 * @param key 存储的KEY
	 * @param value 存储KEY的值
	 * @param expire 有效时间
	 * @return 操作成功完成时返回 OK
	 * @throws Exception 异常
	 */
	public String set(String key, Object value,int expire ) throws Exception;
	/**
	 * 获取 KEY对应的值
	 * @param key 查询的KEY
	 * @param cls 返回的对象类型
	 * @return
	 * @throws Exception 异常
	 */
	public <T> T get(String key, Class<T> cls) throws Exception;

	
	//--------------Set-----------------------
	/**
	 * 返回Set中成员的数量，如果该Key并不存在，返回0。
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Long scard(String key) throws Exception;

	/**
	 * 如果在插入的过程用，参数中有的成员在Set中已经存在，该成员将被忽略，而其它成员仍将会被正常插入。
	 * 如果执行该命令之前，该Key并不存在，该命令将会创建一个新的Set，此后再将参数中的成员陆续插入。
	 * 如果该Key的Value不是Set类型，该命令将返回相关的错误信息。
	 * 
	 * @param key
	 * @param members
	 * @return 本次操作实际插入的成员数量。
	 * @throws Exception 
	 */
	public Long sadd(String key, Object... members) throws Exception;

	/**
	 * 从与Key关联的Set中删除参数中指定的成员，不存在的参数成员将被忽略，如果该Key并不存在，将视为空Set处理。
	 * 
	 * @param key
	 * @param members
	 * @return 从Set中实际移除的成员数量，如果没有则返回0。
	 * @throws Exception 
	 */
	public Long srem(String key, Object... members) throws Exception;

	/**
	 * 查询set 里面的成员
	 * 
	 * @param key
	 * @throws Exception 
	 */
	public <T> Set<T> smembers(String key,Class<T> t ) throws Exception;

	/**
	 * 删除 set key的数据
	 * @throws Exception 
	 */
	public Long sremove(String key) throws Exception;
	
	//--------------Map-----------------------
	/**
	 *  Map集合存储值(为MAP新增key-value)
	 * @param key map的key
	 * @param mapKey map里面value对应的key
	 * @param value 要存储的值
	 * @throws Exception 异常
	 */
	public void setMap(String key, String mapKey, Object value) throws Exception;

	/**
	 *  Map存储List(map(key,List))
	 * @param key map的key
	 * @param mapKey map里面value对应的key
	 * @param value 要存储的值
	 * @throws Exception 异常
	 */
	public void setMapList(String key, String mapKey, List<?> list) throws Exception;
	
	/**
	 * 获取缓存中，map集合中mapkey存放的对象
	 * @param name  以对象形式存储的名字
	 * @param mapKey map中key值
	 * @param t 返回实体对象类型
	 * @throws Exception
	 */
	public <T> T getMapValue(String key, String mapKey, Class<T> t) throws Exception;

	public String getMapValue(String key, String mapKey) throws Exception;
	/**
	 * 获取缓存中，map集合中的值
	 * @param name 以对象形式存储的名字
	 * @param t 返回实体对象类型
	 * @throws Exception
	 */
	public <T> List<T> getMapValues(String key, Class<T> t) throws Exception;
	
	/**
	 * 删除 map里面的某一个值
	 * @param key map的外层key
	 * @param valueKey 值对应的key
	 * @return
	 * @throws Exception
	 */
	public Long removeMap(String key, String valueKey) throws Exception;
	
	/**
	 * 获取 map里面 所有 key对应的 value
	 * @param name 以对象形式存储的key
	 * @throws Exception 
	 */
	public Map<String, String> getMaps(String key) throws Exception;
	
	//--------------List----------------------
	
	//--------------common--------------------
	/**
	 * 删除 KEY -----此处可以删除 任意数据类型的KEY数据
	 * @param key 要删除的KEY
	 * @return 影响的数据行
	 * @throws Exception 异常
	 */
	public Long remove(String key) throws Exception;
	/**
	 * 检测 KEY在缓存中是否存在
	 * @param key 检测的KEY
	 * @return
	 * @throws Exception
	 */
	public boolean exists(String key) throws Exception;
	/**
	 * 设置有效期
	 * @param key 有效期的key
	 * @param seconds 有效时间 秒
	 * @return 影响行
	 */
	public Long expire(String key,int seconds) throws Exception;
    
	/**
	 * 
	* @Title: type 
	* @Description: 返回 key 所储存的值的类型。
	* @param @param key
	* @param @return
	* @param @throws Exception 
	* @return String 	none (key不存在)
						string (字符串)
						list (列表)
						set (集合)
						zset (有序集)
						hash (哈希表)
	* @throws
	 */
	public String type(String key)throws Exception;
    
}
  
