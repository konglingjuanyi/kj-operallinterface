package com.chengfeng.ne.redis.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.chengfeng.ne.redis.service.RedisCommandService;
import com.chengfeng.ne.redis.utils.RedisBusinessConstant;
import com.thinkjf.core.config.GlobalConfig;

/**
 * 缓存AOP类 Author: Jeff Date: 2015年6月30日下午2:22:00 Copyright (c) 2015, HNCF All
 * Rights Reserved.
 * 
 * History: .......
 */
@Component
@Aspect
public class RedisCacheInterceptor {
	private Logger logger = Logger.getLogger(this.getClass());

	private final String GET = "@annotation(GetFromRedis)";
	private final String UPDATE = "@annotation(UpdateToRedis)";
	private final String ADD = "@annotation(AddToRedis)";
	private final String DELETE = "@annotation(DeleteToRedis)";

	@Autowired
	private RedisCommandService redisCommandService;

	private Boolean cacheEnable = Boolean.parseBoolean(GlobalConfig
			.getPropertyValue("jedis.cacheEnable"));

	@Around(GET)
	public Object get(ProceedingJoinPoint pjp) throws Throwable {
		// 判断是否开启缓存
		if (!cacheEnable) {
			return pjp.proceed();
		}

		// 取注解参数
		GetFromRedis anno = getAnnotation(pjp, GetFromRedis.class);
		// 取命名空间
		String key = anno.key();
		// 缓存mapkey
		String fieldKey = anno.fieldKey();

		// 缓存类型
		ReadCacheType cacheType = anno.cacheType();
		// 如果DAO查询返回的是LIST，则需要指定获取mapkey的方法名称
		String mapKeyMethodName = anno.mapKeymethodName();

		// System.out.println("GetFromRedis注解中的参数key：" + key);
		// System.out.println("GetFromRedis注解中的参数fieldKey：" + fieldKey);
		// System.out.println("GetFromRedis注解中的参数mapKeyMethodName："
		// + mapKeyMethodName);
		// System.out.println("GetFromRedis注解中的参数cacheType：" +
		// anno.cacheType());

		// 获取方法的返回类型,让缓存可以返回正确的类型
		// Class returnType = ((MethodSignature) pjp.getSignature())
		// .getReturnType();
		Object value = null;
		// 查缓存
		if (cacheType == ReadCacheType.List) {
			value = getRedisCacheList(pjp, key, fieldKey, anno.classType());
		} else {
			value = getRedisCacheInfo(pjp, key, cacheType, fieldKey,
					mapKeyMethodName, anno.classType());
		}
		return value;

	}

	@Around(ADD)
	public Object add(ProceedingJoinPoint pjp) throws Throwable {

		// 判断是否开启缓存
		if (!cacheEnable) {
			return pjp.proceed();
		}

		// 取注解参数
		AddToRedis anno = getAnnotation(pjp, AddToRedis.class);
		// 取命名空间
		String key = anno.key();
		// 缓存mapkey
		// String fieldKey = anno.fieldKey();
		// 缓存类型
		ReadCacheType cacheType = anno.cacheType();

		// System.out.println("AddToRedis注解中的参数nameSpace：" + key);
		// System.out.println("AddToRedis注解中的参数cacheType：" + anno.cacheType());
		Object value = null;
		value = pjp.proceed();
		if (value != null) {
			// 访问目标方法的参数：
			Object[] args = pjp.getArgs();
			if (args != null && args.length > 0 && args[0] != null
					&& args[0].getClass() == anno.classType()) {
				addRedisCacheInfo(pjp, key, cacheType, value.toString(),
						args[0]);
				logger.info("INFO[RedisCacheInterceptor.add]:添加数据到缓存成功");
			}
		}
		return value;
	}

	@Around(UPDATE)
	public Object update(ProceedingJoinPoint pjp) throws Throwable {

		// 判断是否开启缓存
		if (!cacheEnable) {
			return pjp.proceed();
		}

		// 取注解参数
		UpdateToRedis anno = getAnnotation(pjp, UpdateToRedis.class);
		// 取命名空间
		String key = anno.key();
		// 缓存mapkey
		String fieldKey = anno.fieldKey();
		// 缓存类型
		ReadCacheType cacheType = anno.cacheType();
		String mapKeyMethodName = anno.mapKeymethodName();

		// System.out.println("UpdateToRedis注解中的参数nameSpace：" + key);
		// System.out.println("UpdateToRedis注解中的参数fieldKey：" + fieldKey);
		// System.out.println("UpdateToRedis注解中的参数cacheType：" +
		// anno.cacheType());

		Object value = null;
		value = pjp.proceed();

		// 访问目标方法的参数：
		Object[] args = pjp.getArgs();
		if (args != null && args.length > 0 && args[0] != null
				&& args[0].getClass() == anno.classType()) {
			updateRedisCacheInfo(pjp, key, cacheType, mapKeyMethodName,
					args[0], anno.classType());
			logger.info("INFO[RedisCacheInterceptor.add]:update数据到缓存成功");
		}

		return value;
	}

	@Around(DELETE)
	public Object delete(ProceedingJoinPoint pjp) throws Throwable {

		// 判断是否开启缓存
		if (!cacheEnable) {
			return pjp.proceed();
		}

		// 取注解参数
		DeleteToRedis anno = getAnnotation(pjp, DeleteToRedis.class);
		// 取命名空间
		String key = anno.key();
		// 缓存mapkey
		String fieldKey = anno.fieldKey();
		// 缓存类型
		ReadCacheType cacheType = anno.cacheType();

		// System.out.println("DeleteToRedis注解中的参数nameSpace：" + key);
		// System.out.println("DeleteToRedis注解中的参数fieldKey：" + fieldKey);
		// System.out.println("DeleteToRedis注解中的参数cacheType：" +
		// anno.cacheType());

		Object value = null;
		value = pjp.proceed();
		if (value != null) {
			deleteRedisCacheInfo(pjp, key, cacheType, fieldKey);
			logger.info("INFO[RedisCacheInterceptor.add]:从缓存[" + key + "]中删除["
					+ fieldKey + "]成功");
		}
		return value;
	}

	/**
	 * 
	 * @Title: getAnnotation
	 * @Description: 获得Annotation对象
	 * @param <T>
	 * @param jp
	 * @param clazz
	 * @return T
	 * @throws
	 */
	private <T extends Annotation> T getAnnotation(ProceedingJoinPoint jp,
			Class<T> clazz) {
		MethodSignature joinPointObject = (MethodSignature) jp.getSignature();
		Method method = joinPointObject.getMethod();
		return method.getAnnotation(clazz);
	}

	/**
	 * 
	 * @Title: getRedisCacheInfo
	 * @Description: 从缓存里面取值，没查询到则去数据库查询
	 * @param pjp
	 * @param key
	 *            缓存KEY
	 * @param cacheType
	 *            缓存类型
	 * @param keyField
	 * @param clazz
	 *            返回对象的class类型
	 * @return T
	 * @throws
	 */
	public <T> T getRedisCacheInfo(ProceedingJoinPoint pjp, String key,
			ReadCacheType cacheType, String keyField, String mapKeyMethodName,
			Class<T> clazz) throws Throwable {
		Object value = null;

		if (cacheType == ReadCacheType.Set) {
			value = redisCommandService.smembers(key, clazz);
			if (value == null) {
				logger.info("[RedisCacheInterceptor.getRedisCacheInfo.set]INFO:缓存中未查到["
						+ key + "],进入数据库查询");
				value = pjp.proceed();
				if (value != null) {
					logger.info("[RedisCacheInterceptor.getRedisCacheInfo.set]INFO:查询数据成功，添加至缓存!");
					redisCommandService.sadd(key, value);
				}
			}
		}
		// 从MAP里面根据mapkey返回一个对象，常见：public Hs_Basic_DictqueryDictById(Integer
		// dict_Id)
		else if (cacheType == ReadCacheType.Map) {
			if (keyField != null && !"".equals(keyField)) {
				String fieldKey = null;
				if (pjp.getArgs()[0] != null) {
					fieldKey = parseKey(keyField, getMethod(pjp), pjp.getArgs());
					value = redisCommandService.getMapValue(key, fieldKey,
							clazz);
				}
				if (value == null) {
					logger.info("[RedisCacheInterceptor.getRedisCacheInfo.map]INFO:缓存["
							+ key + "]中未查到[" + fieldKey + "],进入数据库查询");
					value = pjp.proceed();
					if (value != null) {
						logger.info("[RedisCacheInterceptor.getRedisCacheInfo.map]INFO:查询数据成功，添加至缓存!");
						redisCommandService.setMap(key, fieldKey, value);
					}
				}
			}
		}
		// 简单[key,map(keyField,value)]
		else if (cacheType == ReadCacheType.String) {
			if (keyField != null && !"".equals(keyField)) {
				value = redisCommandService.getMapValue(key, keyField, clazz);
				if (value == null) {
					logger.info("[RedisCacheInterceptor.getRedisCacheInfo.map]INFO:缓存["
							+ key + "]中未查到[" + keyField + "],进入数据库查询");
					value = pjp.proceed();
					if (value != null) {
						logger.info("[RedisCacheInterceptor.getRedisCacheInfo.map]INFO:查询数据成功，添加至缓存!");
						redisCommandService.setMap(key, keyField, value);
					}
				}
			}
		}
		// dao中返回List结果集时
		else if (cacheType == ReadCacheType.Maps) {
			value = redisCommandService.getMapValues(key, clazz);
			if (value == null) {
				logger.info("[RedisCacheInterceptor.getRedisCacheInfo.maps]INFO:缓存中未查到["
						+ key + "],进入数据库查询");
				value = pjp.proceed();
				if (value != null) {
					logger.info("[RedisCacheInterceptor.getRedisCacheInfo.maps]INFO:查询数据成功，添加至缓存!");
					if (value instanceof List<?>) {
						List<T> list = (List<T>) value;
						for (int i = 0; i < list.size(); i++) {
							T t = (T) list.get(i);
							Class c = t.getClass();
							Method m = c.getMethod(mapKeyMethodName);
							String pk = m.invoke(t, null).toString();
							redisCommandService.setMap(key, pk, list.get(i));
						}
					}

				}
			}
		} else if (cacheType == ReadCacheType.List) {
			if (keyField != null && !"".equals(keyField)) {
				String fieldKey = null;
				if (pjp.getArgs()[0] != null) {
					fieldKey = parseKey(keyField, getMethod(pjp), pjp.getArgs());
					value = JSONArray.parseArray(
							redisCommandService.getMapValue(key, fieldKey),
							clazz);
				}
				if (value == null) {
					logger.info("[RedisCacheInterceptor.getRedisCacheInfo.List]INFO:缓存["
							+ key + "]中未查到[" + fieldKey + "],进入数据库查询");
					value = pjp.proceed();
					if (value != null) {
						logger.info("[RedisCacheInterceptor.getRedisCacheInfo.map]INFO:查询数据成功，添加至缓存!");
						redisCommandService.setMapList(key, fieldKey,
								(List<T>) value);
					}
				}
			}
		}
		return (T) value;
	}

	public List<?> getRedisCacheList(ProceedingJoinPoint pjp, String key,
			String keyField, Class clazz) throws Throwable {
		Object value = null;
		if (keyField != null && !"".equals(keyField)) {
			String fieldKey = null;
			if (pjp.getArgs()[0] != null) {
				fieldKey = parseKey(keyField, getMethod(pjp), pjp.getArgs());
				value = JSONArray.parseArray(
						redisCommandService.getMapValue(key, fieldKey), clazz);
			}
			if (value == null) {
				logger.info("[RedisCacheInterceptor.getRedisCacheInfo.List]INFO:缓存["
						+ key + "]中未查到[" + fieldKey + "],进入数据库查询");
				value = pjp.proceed();
				if (value != null) {
					logger.info("[RedisCacheInterceptor.getRedisCacheInfo.map]INFO:查询数据成功，添加至缓存!");
					if(fieldKey!=null){
						redisCommandService.setMapList(key, fieldKey,
								(List<?>) value);
					}
					
				}
			}
		}
		return (List<?>) value;
	}

	/**
	 * 
	 * @Title: addRedisCacheInfo
	 * @Description: TODO
	 * @param pjp
	 * @param key
	 * @param cacheType
	 * @param keyField
	 * @param value
	 * @param @throws Throwable
	 * @return void
	 * @throws
	 */
	public void addRedisCacheInfo(ProceedingJoinPoint pjp, String key,
			ReadCacheType cacheType, String keyField, Object value)
			throws Throwable {
		if (cacheType == ReadCacheType.Set) {

		} else if (cacheType == ReadCacheType.Map) {
			redisCommandService.setMap(key, keyField, value);
		} else if (cacheType == ReadCacheType.Maps) {

		}
	}

	/**
	 * 
	 * @Title: deleteRedisCacheInfo
	 * @Description: TODO
	 * @param pjp
	 * @param key
	 * @param cacheType
	 * @param keyField
	 * @throws Throwable
	 * @return void
	 * @throws
	 */
	public void deleteRedisCacheInfo(ProceedingJoinPoint pjp, String key,
			ReadCacheType cacheType, String keyField) throws Throwable {
		if (cacheType == ReadCacheType.Set) {

		} else if (cacheType == ReadCacheType.Map) {
			if (keyField != null && !"".equals(keyField)) {
				String fieldKey = null;
				if (pjp.getArgs()[0] != null) {
					fieldKey = parseKey(keyField, getMethod(pjp), pjp.getArgs());
					redisCommandService.removeMap(key, fieldKey);
				}
			}

		} else if (cacheType == ReadCacheType.Maps) {

		}
	}

	/**
	 * 
	 * @Title: updateRedisCacheInfo
	 * @Description: TODO
	 * @param pjp
	 * @param key
	 * @param cacheType
	 * @param keyField
	 * @param value
	 * @throws Throwable
	 * @return void
	 * @throws
	 */
	public <T> T updateRedisCacheInfo(ProceedingJoinPoint pjp, String key,
			ReadCacheType cacheType, String mapKeyMethodName, Object value,
			Class<T> clazz) throws Throwable {
		if (cacheType == ReadCacheType.Set) {

		} else if (cacheType == ReadCacheType.Map) {
			T t = (T) value;
			Class c = t.getClass();
			Method m = c.getMethod(mapKeyMethodName);
			String pk = m.invoke(t, null).toString();
			redisCommandService.setMap(key, pk, value);
		} else if (cacheType == ReadCacheType.Maps) {

		}

		return (T) null;
	}

	/**
	 * 
	 * @Title: getCacheKey
	 * @Description: TODO
	 * @param jp
	 * @param nameSpace
	 * @param fieldKey
	 * @return String
	 * @throws
	 */
	// public String getCacheKey(ProceedingJoinPoint jp, String nameSpace,
	// String fieldKey) {
	// StringBuffer sb = new StringBuffer();
	// if (nameSpace != null && !"".equals(nameSpace)) {
	// sb.append(nameSpace);
	// sb.append(":" + jp.getSignature().getName());
	// if (fieldKey != null && "".equals(nameSpace)) {
	// sb.append(":" + fieldKey);
	// }
	// System.out.println("-----getcacheKey:" + sb.toString());
	// return sb.toString();
	// } else {
	// System.out.println("----命名空间不能为空------");
	// return null;
	// }
	// }

	/**
	 * 获取缓存的key key 定义在注解上，支持SPEL表达式
	 * 
	 * @param pjp
	 * @return
	 */
	private String parseKey(String key, Method method, Object[] args) {

		// 获取被拦截方法参数名列表(使用Spring支持类库)
		LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
		String[] paraNameArr = u.getParameterNames(method);
		HashMap paramMap = new HashMap();
		// 把方法参数放入SPEL上下文中
		for (int i = 0; i < paraNameArr.length; i++) {
			paramMap.put("#" + paraNameArr[i], args[i]);
		}
		return paramMap.get(key).toString();
	}

	/**
	 * 获取被拦截方法对象
	 * 
	 * MethodSignature.getMethod() 获取的是顶层接口或者父类的方法对象 而缓存的注解在实现类的方法上
	 * 所以应该使用反射获取当前对象的方法对象
	 */
	public Method getMethod(ProceedingJoinPoint pjp) {
		Method method = null;
		try {
			// 获取参数的类型
			Object[] args = pjp.getArgs();
			Class[] argTypes = new Class[pjp.getArgs().length];
			for (int i = 0; i < args.length; i++) {
				argTypes[i] = args[i].getClass();
			}
			method = pjp.getTarget().getClass()
					.getMethod(pjp.getSignature().getName(), argTypes);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return method;

	}
}
