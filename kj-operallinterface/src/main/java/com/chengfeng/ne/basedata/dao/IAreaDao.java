package com.chengfeng.ne.basedata.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.chengfeng.ne.basedata.domain.BasicAreaVO;
import com.thinkjf.dao.DaoException;
import com.thinkjf.dao.entity.PaginationVO;
/**
 * <p>功能描述：片区管理数据访问层接口</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Yong
 * @version 1.0 2014-2-12 下午5:43:42
 */
public interface IAreaDao {
	
	/**
	 * 按片区名称
	 * @return List<BasicAreaVO>
	 */
	public List<BasicAreaVO> queryAreaByName(String areaName);
	
	
}
