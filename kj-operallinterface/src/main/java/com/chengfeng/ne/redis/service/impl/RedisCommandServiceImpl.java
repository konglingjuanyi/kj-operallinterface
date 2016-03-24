package com.chengfeng.ne.redis.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisCluster;

import com.alibaba.fastjson.JSON;
import com.chengfeng.ne.redis.service.RedisCommandService;

/**
 * Author: Jeff 
 * Date: 2015年6月23日下午3:59:52 
 * Copyright (c) 2015, HNCF All Rights Reserved.
 * 
 * History: .......
 */
@Service("redisCommandService")
public class RedisCommandServiceImpl implements RedisCommandService {
	@Autowired
	public JedisCluster jedisCluster;

	@Override
	public String set(String key, Object value, int expire) throws Exception {
		try {
			String result = jedisCluster.set(key, JSON.toJSONString(value));
			if (expire > 0)
				jedisCluster.expire(key, expire);
			return result;
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public <T> T get(String key, Class<T> cls) throws Exception {
		try {
			String jsonValue = jedisCluster.get(key);
			return JSON.parseObject(jsonValue, cls);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Long scard(String key) throws Exception {
		Long count = 0l;
		try {
			count = jedisCluster.scard(key);
		} catch (Exception e) {
			throw e;
		}

		return count;
	}

	@Override
	public Long sadd(String key, Object... members) throws Exception {
		Long rows = 0l;
		try {
			String[] item = new String[members.length];
			int i = 0;
			for (Object obj : members) {
				item[i] = JSON.toJSONString(obj);
				i++;
			}
			rows = jedisCluster.sadd(key, item);
		} catch (Exception e) {
			throw e;
		}

		return rows;
	}

	@Override
	public Long srem(String key, Object... members) throws Exception {
		Long rows = 0l;
		try {
			String[] item = new String[members.length];
			int i = 0;
			for (Object obj : members) {
				item[i] = JSON.toJSONString(obj);
				i++;
			}
			rows = jedisCluster.srem(key, item);
		} catch (Exception e) {
			throw e;
		}
		return rows;
	}

	@Override
	public <T> Set<T> smembers(String key, Class<T> t) throws Exception {
		try {
			Set<String> sItem = jedisCluster.smembers(key);

			Set<T> result = new HashSet<T>();
			Iterator<String> rt = sItem.iterator();
			while (rt.hasNext()) {
				result.add(JSON.parseObject(rt.next(), t));
			}
			return result;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Long sremove(String key) throws Exception {
		Long result = 0L;
		try {
			result = jedisCluster.del(key);
		} catch (Exception e) {
			throw e;
		}
		return result;
	}

	// -------------------map--------------------------
	@Override
	public void setMap(String key, String mapKey, Object value)
			throws Exception {
		try {
			String jsonValue = JSON.toJSONString(value);
			jedisCluster.hset(key, mapKey, jsonValue);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void setMapList(String key, String mapKey, List<?> list)
			throws Exception {
		try {
			jedisCluster.hset(key, mapKey, JSON.toJSONString(list));
		} catch (Exception e) {
			throw e;
		}		
	}

	@Override
	public <T> T getMapValue(String key, String mapKey, Class<T> t)
			throws Exception {
		List<String> list = null;
		try {

			list = jedisCluster.hmget(key, mapKey);
		} catch (Exception e) {
			throw e;
		}
		if (list == null || list.size() == 0) {
			return null;
		}

		String value = list.get(0);
		if (value != null) {
			return JSON.parseObject(value, t);
		}
		return null;
	}

	
	
	@Override
	public String getMapValue(String key, String mapKey) throws Exception {
		// TODO Auto-generated method stub
		String value = null;
		try {
			value = jedisCluster.hget(key, mapKey);
		} catch (Exception e) {
			throw e;
		}
		return value;
	}

	@Override
	public <T> List<T> getMapValues(String key, Class<T> t) throws Exception {
		List<String> list = new ArrayList<String>();
		List<T> rList = null;

		try {

			list = jedisCluster.hvals(key);
		} catch (Exception e) {
			throw e;
		}

		if (list != null && list.size()>0) {
			rList = new ArrayList<T>();
			for (int i = 0; i < list.size(); i++) {
				rList.add(JSON.parseObject(list.get(i), t));
			}
		}

		return rList;
	}

	@Override
	public Long removeMap(String key, String valueKey) throws Exception {
		Long result = 0L;

		try {
			result = jedisCluster.hdel(key, valueKey);
		} catch (Exception e) {
			throw e;
		}
		return result;
	}

	@Override
	public Map<String, String> getMaps(String key) throws Exception {

		Map<String, String> rList = new HashMap<String, String>();
		try {

			rList = jedisCluster.hgetAll(key);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return rList;
	}

	// -------------------common--------------------------
	@Override
	public Long remove(String name) throws Exception {
		Long result = 0L;

		try {

			result = jedisCluster.del(name);
		} catch (Exception e) {
			throw e;
		}
		return result;
	}

	@Override
	public boolean exists(String key) throws Exception {

		try {

			return jedisCluster.exists(key);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Long expire(String key, int seconds) throws Exception {
		try {
			return jedisCluster.expire(key, seconds);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public String type(String key) throws Exception {
		try {
			return jedisCluster.type(key);
		} catch (Exception e) {
			throw e;
		}
	}

}
