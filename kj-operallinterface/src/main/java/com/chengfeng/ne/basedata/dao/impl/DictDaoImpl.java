package com.chengfeng.ne.basedata.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.chengfeng.common.dao.BaseNeDaoImpl;
import com.chengfeng.ne.basedata.dao.IDictDao;
import com.chengfeng.ne.basedata.domain.BasicDictVO;
import com.chengfeng.ne.redis.aop.AddToRedis;
import com.chengfeng.ne.redis.aop.GetFromRedis;
import com.chengfeng.ne.redis.aop.ReadCacheType;
import com.chengfeng.ne.redis.aop.UpdateToRedis;
import com.chengfeng.ne.redis.utils.RedisBusinessConstant;
import com.thinkjf.core.config.GlobalConfig;
import com.thinkjf.dao.DaoException;

/**
 * 数据字典数据访问层实现类
 * @author Yong
 */
@Repository("dictDao")
public class DictDaoImpl extends BaseNeDaoImpl implements IDictDao {

	/**
	 * 新增
	 * modify by Jeff 2015.07.15
	 */
	@AddToRedis(key=RedisBusinessConstant.BASIC_DICT_CACHE_NAME,cacheType=ReadCacheType.Map,classType=BasicDictVO.class)
	@Override
	public Long doCreateDict(BasicDictVO dict) throws DaoException {
		// TODO Auto-generated method stub
			dict.setCreatedBy(0L);
			dict.setCreatedTime(getCurrentTime());
			dict.setRdStatus(1);
			return (Long)insertRecord("BasicDictVO.doCreateDict", dict);
	}

	/**
	 * 修改
	 * modify by Jeff 2015.07.15
	 */
	@UpdateToRedis(key=RedisBusinessConstant.BASIC_DICT_CACHE_NAME,mapKeymethodName="getDictId",cacheType = ReadCacheType.Map,classType=BasicDictVO.class)
	@Override
	public void doModifyDict(BasicDictVO dict) throws DaoException {
		// TODO Auto-generated method stub
			dict.setModifiedBy(0L);
			dict.setModifiedTime(getCurrentTime());
			updateRecord("BasicDictVO.doModifyDict", dict);
	}

	/**
	 * 保存
	 */
	@Override
	public void doSaveDict(BasicDictVO dict) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 删除
	 * modify by Jeff 2015.07.15
	 */
	@UpdateToRedis(key=RedisBusinessConstant.BASIC_DICT_CACHE_NAME,mapKeymethodName="getDictId",cacheType = ReadCacheType.Map,classType=BasicDictVO.class)
	@Override
	public void doDeleteDict(BasicDictVO dict) throws DaoException {
		// TODO Auto-generated method stub
			dict.setModifiedBy(0L);
			dict.setModifiedTime(getCurrentTime());
			dict.setRdStatus(0);
			updateRecord("BasicDictVO.doDeleteDict", dict);
	}

	/**
	 * 按Id查询
	 * @return BasicDict
	 * modify by Jeff 2015.07.15
	 */
	@GetFromRedis(key = RedisBusinessConstant.BASIC_DICT_CACHE_NAME,fieldKey = "#dictId", cacheType = ReadCacheType.Map,  classType = BasicDictVO.class)	
	@Override
	public BasicDictVO queryDictById(Long dictId) throws DaoException {
		// TODO Auto-generated method stub
		BasicDictVO dict=null;
			Object obj=queryForObject("BasicDictVO.queryDictById", dictId);
			if(obj!=null&&!obj.equals("")){
				dict=(BasicDictVO)obj;
			}
		return dict;
	}

	/**
	 * 按数据字典类型查询 
	 * @return List<BasicDict>
	 * modify by Jeff 2015.07.15
	 */
	@GetFromRedis(key = RedisBusinessConstant.KEY_BASIC_DICT_MAP,fieldKey = "#typeCode", cacheType = ReadCacheType.List,  classType = BasicDictVO.class)		
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BasicDictVO> queryDictByType(String typeCode) throws DaoException {
		// TODO Auto-generated method stub
		List<BasicDictVO> list=null;
		List obj=queryForList("BasicDictVO.queryDictByType", typeCode);
		if(obj!=null&&obj.size()>0){
				list=(List<BasicDictVO>)obj;
			}
		return list;
	}

	/**
	 * 按编号和名称查询 
	 * @return BasicDict
	 */
	@Override
	public BasicDictVO queryDictByIdAndName(BasicDictVO basicDict) throws DaoException {
		// TODO Auto-generated method stub
		BasicDictVO dict=null;
		Object obj=queryForObject("BasicDictVO.queryDictByIdAndName", basicDict);
			if(obj!=null&&!obj.equals("")){
				dict=(BasicDictVO)obj;
			}
		return dict;
	}	

	/**
	 * 按名称查询 
	 * @return List<BasicDict>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BasicDictVO> queryDictByName(String typeName) throws DaoException {
		// TODO Auto-generated method stub
		List<BasicDictVO> list=null;
			List obj=queryForList("BasicDictVO.queryDictByName", typeName);
			if(obj!=null&&obj.size()>0){
				list=(List<BasicDictVO>)obj;
			}
		return list;
	}
	
	/**
	 * 按名称查询 
	 * @return List<BasicDict>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BasicDictVO queryDictByNameAndTypeCode(String typeName,String typeCode) throws DaoException {
		Map map = new HashMap();
		map.put("dictName", typeName);
		map.put("typeCode", typeCode);
		return queryForObject("BasicDictVO.queryDictByNameAndTypeCode", map);
	}
	
	/**
	 * 按编号模糊查询 
	 * @return List<BasicDict>
	 *
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BasicDictVO> queryDictByCode(String dictCode) throws DaoException {
		// TODO Auto-generated method stub
		List<BasicDictVO> list=null;
			List obj=queryForList("BasicDictVO.queryDictByCode", dictCode);
			if(obj!=null&&obj.size()>0){
				list=(List<BasicDictVO>)obj;
			}
		return list;
	}
	
	/**
	 * 按编号 名称 拼音模糊查询 
	 * @return List<BasicDict>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BasicDictVO> queryDictByPNC(String pnc,String typeCode) throws DaoException {
		// TODO Auto-generated method stub
		List<BasicDictVO> list=null;
		String str=GlobalConfig.getPropertyValue("common.search.listbox.datasize");
		Integer rownum=Integer.parseInt(str);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("dictName", pnc);
		map.put("dictPinyin", pnc.toUpperCase());
		map.put("rownum", rownum);
		map.put("typeCode", typeCode);
		List obj=queryForList("BasicDictVO.queryDictByPNC", map);
		if(obj!=null&&obj.size()>0){
			list=(List<BasicDictVO>)obj;
		}
		return list;
	}

	/**
	 * 获取数据字典自定义顺序最大值
	 * @return Long
	 */
	public Long getMaxDictOrder() throws DaoException{
		Long dictOrder=null;
			Object obj=queryForObject("BasicDictVO.getMaxDictOrder");
			if(obj!=null&&!obj.equals("")){
				dictOrder=(Long)obj;
			}
		return dictOrder;
	}
	
	/**
	 * 按字典类型和编号查询 
	 * @return BasicDict
	 */
	@Override
	public BasicDictVO getDictByCode(BasicDictVO basicDict) throws DaoException {
		// TODO Auto-generated method stub
		BasicDictVO dict=null;
			Object obj=queryForObject("BasicDictVO.getDictByCode", basicDict);
			if(obj!=null&&!obj.equals("")){
				dict=(BasicDictVO)obj;
			}
		return dict;
	}
	
	/**
	 * 按字典类型和名称查询 
	 * @return BasicDict
	 */
	@Override
	public BasicDictVO getDictByName(BasicDictVO basicDict) throws DaoException {
		// TODO Auto-generated method stub
		BasicDictVO dict=null;
			Object obj=queryForObject("BasicDictVO.getDictByName", basicDict);
			if(obj!=null&&!obj.equals("")){
				dict=(BasicDictVO)obj;
			}
		return dict;
	}
	
	/**
	 * modify by Jeff 2015.07.14
	 */
	@GetFromRedis(key = RedisBusinessConstant.BASIC_DICT_CACHE_NAME, cacheType = ReadCacheType.Maps, mapKeymethodName="getDictId",classType = BasicDictVO.class)
	@Override
	public List<BasicDictVO> queryDicts() throws DaoException {
		// TODO Auto-generated method stub
		return queryForList("BasicDictVO.queryDicts");
	}

	/**
	 * 根据字典类型和时间获取问题类型
	 * @param searchMap
	 * @return List
	 * @throws DaoException
	 */
	@Override
	public List<BasicDictVO> queryDictByTypeAndDate(Map<String, Object> searchMap) throws DaoException{
		return queryForList("BasicDictVO.queryDictByTypeAndDate", searchMap);
	}
	
	/**
	 * @desc:根据条件查询数据字典id集合
	 * @param map
	 * @return
	 */
	@Override
	public List<Long> queryDictIdsByLike(Map<String, Object> map)
			throws DaoException{
		return queryForList("BasicDictVO.queryDictIdsByLike", map);
	}

	/**
	 * 按类型查询
	 * @return List<BasicDict>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BasicDictVO> queryDictByMap(Map map) {
		List<BasicDictVO> list=null;
		List obj=queryForList("BasicDictVO.queryDictByMap", map);
		if(obj!=null&&obj.size()>0){
				list=(List<BasicDictVO>)obj;
			}
		return list;
	}

}
