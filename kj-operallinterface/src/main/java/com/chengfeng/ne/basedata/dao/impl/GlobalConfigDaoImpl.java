package com.chengfeng.ne.basedata.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chengfeng.common.dao.BaseNeDaoImpl;
import com.chengfeng.ne.basedata.dao.IGlobalConfigDao;
import com.chengfeng.ne.basedata.domain.GlobalConfigVO;
import com.thinkjf.dao.DaoException;
import com.thinkjf.dao.entity.PaginationVO;

@Repository("globalConfigDao")
public class GlobalConfigDaoImpl extends BaseNeDaoImpl implements IGlobalConfigDao {

	@Override
	public PaginationVO<GlobalConfigVO> queryPagedList(Map params,
			int pageIndex, int pageSize) throws DaoException {
		return super.queryPagedList(GlobalConfigVO.class,params, pageIndex, pageSize);
	}

	@Override
	public GlobalConfigVO selectByPrimaryKey(Long globalConfigId) {
		GlobalConfigVO record = (GlobalConfigVO) queryForObject("GlobalConfigVO.selectByPrimaryKey", globalConfigId);
        return record;
	}

	@Override
	public GlobalConfigVO getGlobalConfigByName(String globalConfigName) {
		GlobalConfigVO globalConfig=null;
		Object obj=queryForObject("GlobalConfigVO.getGlobalConfigByName", globalConfigName);
		if(obj!=null&&!obj.equals("")){
			globalConfig=(GlobalConfigVO)obj;
		}
		return globalConfig;
	}

	@Override
	public GlobalConfigVO getGlobalConfigByCode(String globalConfigCode) {
		GlobalConfigVO globalConfig=null;
		Object obj=queryForObject("GlobalConfigVO.getGlobalConfigByCode", globalConfigCode);
		if(obj!=null&&!obj.equals("")){
			globalConfig=(GlobalConfigVO)obj;
		}
	return globalConfig;
	}

	@Override
	public void updateByPrimaryKey(GlobalConfigVO record) {
		record.setModifiedBy(record.getCreatedBy());
    	record.setModifiedTime(getCurrentTime());
        updateRecord("GlobalConfigVO.updateByPrimaryKey", record);
	}

}
