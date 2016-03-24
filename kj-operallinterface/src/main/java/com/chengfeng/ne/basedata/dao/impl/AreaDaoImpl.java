package com.chengfeng.ne.basedata.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chengfeng.common.dao.BaseNeDaoImpl;
import com.chengfeng.ne.basedata.dao.IAreaDao;
import com.chengfeng.ne.basedata.domain.BasicAreaVO;
import com.thinkjf.core.config.GlobalConfig;
import com.thinkjf.dao.DaoException;
import com.thinkjf.dao.entity.PaginationVO;



/**
 * 片区管理dao层实现类
 * @author Yong
 *
 */
@Repository("areaDao")
public class AreaDaoImpl extends BaseNeDaoImpl implements IAreaDao{
	
	
	/**
	 * 按片区名称模糊查询
	 * @return List<BasicArea>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BasicAreaVO> queryAreaByName(String areaName) throws DaoException {
		List<BasicAreaVO> list=null;
			List obj=queryForList("BasicAreaVO.queryAreaByName", areaName);
			if(obj!=null&&obj.size()>0){
				list=(List<BasicAreaVO>)obj;
			}
		return list;
	}
	
	
}
