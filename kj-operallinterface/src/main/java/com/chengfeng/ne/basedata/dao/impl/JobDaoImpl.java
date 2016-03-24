package com.chengfeng.ne.basedata.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chengfeng.common.dao.BaseNeDaoImpl;
import com.chengfeng.ne.basedata.dao.IJobDao;
import com.chengfeng.ne.basedata.domain.BasicDeptJobVO;
import com.chengfeng.ne.basedata.domain.BasicJobVO;
import com.chengfeng.ne.redis.aop.AddToRedis;
import com.chengfeng.ne.redis.aop.ReadCacheType;
import com.chengfeng.ne.redis.utils.RedisBusinessConstant;
import com.thinkjf.dao.DaoException;
import com.thinkjf.dao.entity.PaginationVO;


/**
 * 
 * <p>功能描述：岗位管理数据访问层实现类</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Yong
 * @version 1.0 2013-12-23 下午3:52:50
 */
@Repository("jobDao")
public class JobDaoImpl extends BaseNeDaoImpl implements IJobDao {
	
	/**
	 * 增加岗位
	 * modify by Jeff 2015.07.15
	 */
	@AddToRedis(key=RedisBusinessConstant.BASIC_JOB_CACHE_NAME,cacheType=ReadCacheType.Map,classType=BasicJobVO.class)	
	@Override
	public Long doCreateJob(BasicJobVO job) throws DaoException{
		Long l=null;
			job.setCreatedBy(0L);
			job.setCreatedTime(getCurrentTime());
			  Object obj=insertRecord("BasicJobVO.doCreateJob", job);
			  l= (Long)obj;
		return l;
	}



	/**
	 * 获取数据字典自定义顺序最大值
	 * @return Long
	 */
	@Override
	public Long getMaxJobOrder() throws DaoException {
		Long dictOrder=null;
			Object obj=queryForObject("BasicJobVO.getMaxJobOrder");
			if(obj!=null&&!obj.equals("")){
				dictOrder=(Long)obj;
			}
		return dictOrder;
	}

	/**
	 * 新增岗位部门关系到部门岗位关系表
	 */
	@Override
	public Long doCreateDeptJob(BasicDeptJobVO deptJob) throws DaoException {
			return insertRecord("BasicDeptJobVO.doCreateDeptJob", deptJob);		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public BasicDeptJobVO queryDeptJobByEntity(BasicDeptJobVO entity)
			throws DaoException {
		BasicDeptJobVO obj=null;
		List ob=queryForList("BasicDeptJobVO.queryDeptJobByEntity",entity);
		if(ob!=null&&ob.size()>0){
			List<BasicDeptJobVO> list=(List<BasicDeptJobVO>)ob;
			obj=list.get(0);
		}
		return obj;
	}


}
