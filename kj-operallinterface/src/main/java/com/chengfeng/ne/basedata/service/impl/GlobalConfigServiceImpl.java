package com.chengfeng.ne.basedata.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chengfeng.ne.basedata.dao.IGlobalConfigDao;
import com.chengfeng.ne.basedata.domain.GlobalConfigVO;
import com.chengfeng.ne.basedata.service.IGlobalConfigService;
import com.thinkjf.dao.entity.PaginationVO;
import com.thinkjf.service.ServiceException;

@Service("globalConfigService")
public class GlobalConfigServiceImpl implements IGlobalConfigService {

	@Resource(name="globalConfigDao")
	private IGlobalConfigDao globalConfigDao;
	
	@Override
	public PaginationVO<GlobalConfigVO> queryPagedList(Map params,
			int pageIndex, int pageSize) throws ServiceException {
		return globalConfigDao.queryPagedList(params, pageIndex, pageSize);
	}

	@Override
	public Boolean doModifyGlobalConfig(GlobalConfigVO entity)
			throws ServiceException {
		Long id = entity.getGlobalConfigId();	
		GlobalConfigVO object = globalConfigDao.selectByPrimaryKey(id);
		if(object==null){
			return false;
		}
		GlobalConfigVO obj = globalConfigDao.getGlobalConfigByName(entity.getGlobalConfigName());
		if(obj!=null){
			if(!object.getGlobalConfigName().equals(entity.getGlobalConfigName())){
			return false;
			}
		}
		GlobalConfigVO ob = globalConfigDao.getGlobalConfigByCode(entity.getGlobalConfigCode());
		if(ob!=null){
			if(!object.getGlobalConfigCode().equals(entity.getGlobalConfigCode())){
			return false;
			}
		}
		globalConfigDao.updateByPrimaryKey(entity);
		return true;
	}

}
