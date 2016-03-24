package com.chengfeng.ne.basedata.service;

import java.util.Map;

import com.chengfeng.ne.basedata.domain.GlobalConfigVO;
import com.thinkjf.dao.entity.PaginationVO;
import com.thinkjf.service.ServiceException;

/**
 * 
 * 功能描述：系统参数业务层
 *
 * Copyright: Copyright (c) 2016
 *
 * Company: 丞风智能科技有限公司
 * 
 * @author Pippo
 *
 * @version 2016-1-7
 */
public interface IGlobalConfigService {

	/**
	 * 分页查询
	 * @param params
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 * @throws ServiceException   
	 * @author Pippo
	 */
	public PaginationVO<GlobalConfigVO> queryPagedList(Map params,int pageIndex,int pageSize) throws ServiceException;
	
	/**
	 * 修改系统参数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */
	Boolean doModifyGlobalConfig(GlobalConfigVO entity) throws ServiceException;
}
