package com.chengfeng.ne.basedata.dao;

import java.util.Map;

import com.chengfeng.ne.basedata.domain.GlobalConfigVO;
import com.thinkjf.dao.DaoException;
import com.thinkjf.dao.entity.PaginationVO;
import com.thinkjf.service.ServiceException;

/**
 * 
 * 功能描述：系统参数数据层
 *
 * Copyright: Copyright (c) 2016
 *
 * Company: 丞风智能科技有限公司
 * 
 * @author Pippo
 *
 * @version 2016-1-7
 */
public interface IGlobalConfigDao {
	/**
	 * 资源分页查询
	 * @param params
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings("rawtypes")
	PaginationVO<GlobalConfigVO> queryPagedList(Map params,int pageIndex,int pageSize) throws DaoException;
	
	/**
	 * 根据主键查询
	 * @param globalConfigId
	 */
    GlobalConfigVO selectByPrimaryKey(Long globalConfigId);
    
    /**
	 * 按系统参数名称
	 * @return
	 */
	public GlobalConfigVO getGlobalConfigByName(String areaName);
	
	/**
	 * 按系统参数编号查询
	 * @return
	 */
	public GlobalConfigVO getGlobalConfigByCode(String areaCode);
	
	/**
	 * 修改
	 * @param record
	 */
    void updateByPrimaryKey(GlobalConfigVO record);
}
