package com.chengfeng.ne.redis.utils;  

import com.thinkjf.core.config.GlobalConfig;

 /**  Redis业务常量类
  * Key Role[表名/业务名称:数据类型:行为]
  * 如：
  * 	dict:hm:id.object
 * Author: Jeff
 * Date: 2015年6月23日下午8:01:42  
 * Copyright (c) 2015, HNCF All Rights Reserved.  
 *  
 * History: 
 * .......
 */
public class RedisBusinessConstant {
	 //本项目redis key使用的命名空间
	public static final String NAMESPACE = "KJ";
	// 顶级菜单
	public static final String KEY_MENU_TOP = NAMESPACE+"_"+"topMenus"; 
	//菜单以及子菜单键值对 parentMenuId : childMenueList
	public static final String KEY_MENU_MAP = NAMESPACE+"_"+"menuMap"; 
	//顶级菜单键值对id:menu
	public static final String KEY_MENU_TOP_MAP = NAMESPACE+"_"+"topMenuMap"; 
	
	/**
	 * BS菜单
	 */
	public static final String KEY_BS_MENUS = NAMESPACE+"_"+"bsMenus";
	
	/**
	 * BS菜单Map
	 */
	public static final String KEY_BS_MENUS_MAP = NAMESPACE+"_"+"bsMenuMap";
	
	/**
	 * BS菜单
	 */
	public static final String KEY_BS_TOP_MENUS = NAMESPACE+"_"+"bsTopMenus";
	
	/**
	 * BS菜单
	 */
	public static final String KEY_BS_TOP_MENUS_MAP = NAMESPACE+"_"+"bsTopMenusMap";
	
	/**
	 * BS菜单
	 */
	public static final String KEY_BS_SUB_MENUS = NAMESPACE+"_"+"bsSubMenus";
	/**
	 * BS菜单Map
	 */
	public static final String KEY_BS_SUB_MENUS_MAP = NAMESPACE+"_"+"bsSubMenuMap";
	
	/**
	 * 数据字典map typeCode:dict
	 */
	public static final String KEY_BASIC_DICT_MAP = NAMESPACE+"_"+"basicDictMap";  
	/**
	 * 所有国家list
	 */
	public static final String KEY_BASIC_COUNTRY_LIST = NAMESPACE+"_"+"basicCountryList";
	/**
	 * 所有省份list
	 */
	public static final String KEY_BASIC_PROVINCE_LIST = NAMESPACE+"_"+"basicProvinceList";
	
	/**
	 * 省份map countryId:province
	 */
	public static final String KEY_BASIC_PROVINCE_MAP = NAMESPACE+"_"+"basicProvinceMap";
	
	/**
	 * 所有城市list
	 */
	public static final String KEY_BASIC_CITY_LIST = NAMESPACE+"_"+"basicCityList";
	
	/**
	 * 城市map provinceId:city
	 */
	public static final String KEY_BASIC_CITY_MAP = NAMESPACE+"_"+"basicCityMap";

	/**
	 * 所有区县list
	 */
	public static final String KEY_BASIC_COUNTY_LIST = NAMESPACE+"_"+"basicCountyList";
	/**
	 * 区县map cityId:county
	 */
	public static final String KEY_BASIC_COUNTY_MAP = NAMESPACE+"_"+"basicCountyMap";
	
	/**
	 *  费用项目
	 */
	public static final String KEY_BASIC_CHARGE_ITEM_MAP = NAMESPACE+"_"+"basicChargeItemMap";
	
    /**
     * 用户Cache名称
     */
    public static final String USER_CACHE_NAME = NAMESPACE+"_"+"userCache";

    /**
     * 根网点ID
     */
    public static final String ROOT_SITE_ID = NAMESPACE+"_"+"rootSiteId";
    
    /**
     * 数据字典Cache名称
     */
    public static final String BASIC_DICT_CACHE_NAME = NAMESPACE+"_"+"basicDictCache";
    
    /**
     * 网点Cache名称
     */
    public static final String BASIC_SITE_CACHE_NAME = NAMESPACE+"_"+"basicSiteCache";
    
    /**
     * 部门Cache名称
     */
    public static final String BASIC_DEPT_CACHE_NAME = NAMESPACE+"_"+"basicDeptCache";
    /**
     * 岗位Cache名称
     */
    public static final String BASIC_JOB_CACHE_NAME = NAMESPACE+"_"+"basicJobCache";
    
    /**
     * 员工Cache名称
     */
    public static final String BASIC_EMPLOYEE_CACHE_NAME = NAMESPACE+"_"+"basicEmployeeCache";
    /**
     * 国家Cache名称
     */
    public static final String BASIC_COUNTRY_CACHE_NAME = NAMESPACE+"_"+"basicCountryCache";
    
    /**
     * 省份Cache名称
     */
    public static final String BASIC_PROVINCE_CACHE_NAME = NAMESPACE+"_"+"basicProvinceCache";
    /**
     * 城市Cache名称
     */
    public static final String BASIC_CITY_CACHE_NAME = NAMESPACE+"_"+"basicCityCache";
    /**
     * 区县Cache名称
     */
    public static final String BASIC_COUNTY_CACHE_NAME = NAMESPACE+"_"+"basicCountyCache";
    /**
     * 费用项目Cache名称
     */
    public static final String BASIC_CHARGE_ITEM_NAME = NAMESPACE+"_"+"basicChargeItemCache";
    /**
     * 片区Cache名称
     */
    public static final String BASIC_AREA_CACHE_NAME = NAMESPACE+"_"+"basicAreaCache";
}
  
