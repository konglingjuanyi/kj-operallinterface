package com.chengfeng.ne.basedata.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chengfeng.common.dao.BaseNeDaoImpl;
import com.chengfeng.ne.basedata.dao.IDeptDao;
import com.chengfeng.ne.basedata.domain.BasicDeptVO;
import com.chengfeng.ne.redis.aop.AddToRedis;
import com.chengfeng.ne.redis.aop.ReadCacheType;
import com.chengfeng.ne.redis.utils.RedisBusinessConstant;
import com.thinkjf.dao.DaoException;


/**
 * <p>功能描述：部门数据访问类</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author Yong
 * @version 1.0 2013-12-22 下午5:57:04
 */
@Repository("deptDao")
public class DeptDaoImpl extends BaseNeDaoImpl implements IDeptDao {
	
	/**
	 * 获取部门管理自定义顺序最大值
	 * @return Long
	 */
	@Override
	public Long getMaxDeptOrder() throws DaoException {
		// TODO Auto-generated method stub
		Long order=null;
			Object obj=queryForObject("BasicDeptVO.getMaxDeptOrder");
			if(obj!=null&&!obj.equals("")){
				order=(Long)obj;
			}
		return order;
	}

	/**
	 * 根据部门名称查询
	 * @return BasicDept
	 */
	@Override
	public List<BasicDeptVO> queryDeptByName(String deptName) throws DaoException {
		// TODO Auto-generated method stub
			List<BasicDeptVO> list=queryForList("BasicDeptVO.queryDeptByName",deptName);
			if(list!=null&&list.size()>0){
				return list;
			}else{
				return null;
			}
	}
	
	/**
	 * 根据名称和网点类型查询部门
	 * @param map
	 * @return BasicDeptVO
	 * @throws DaoException
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public BasicDeptVO getDeptByNameAndSiteTypeId(Map map) throws DaoException {
		return queryForObject("BasicDeptVO.getDeptByNameAndSiteTypeId", map);
	}
	
	/**
	 * 新增部门
	 * modify by Jeff 2015.07.15
	 */
	@AddToRedis(key=RedisBusinessConstant.BASIC_DEPT_CACHE_NAME,cacheType=ReadCacheType.Map,classType=BasicDeptVO.class)
	@Override
	public Long doCreateDept(BasicDeptVO dept) throws DaoException{
			dept.setCreatedBy(0L);
			dept.setCreatedTime(getCurrentTime());
			dept.setRdStatus(1);
			return (Long)insertRecord("BasicDeptVO.doCreateDept", dept);
	}
}
