package com.chengfeng.interfaces.orders.clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;

import com.chengfeng.common.util.FileCfgUtils;
import com.chengfeng.common.util.FilesUtils;
import com.chengfeng.common.util.MD5Util;
import com.chengfeng.common.util.SpringUtils;
import com.chengfeng.ne.basedata.domain.GlobalConfigVO;
import com.chengfeng.ne.basedata.service.IGlobalConfigService;
import com.chengfeng.ne.opt.orders.domain.OrderinterfaceErrorVO;
import com.chengfeng.ne.opt.orders.service.IOrderinterfaceErrorService;
import com.thinkjf.core.config.GlobalConfig;
import com.thinkjf.dao.entity.PaginationVO;

/**
 * 
 * 功能描述：快捷订单接口内容调用
 * 
 * Copyright: Copyright (c) 2013
 * 
 * Company: 丞风智能科技有限公司
 * 
 * @author Lei.Zhao
 * 
 * @version 2015-9-14
 */
public class OrderMsgClient implements InitializingBean {
	private final Log log = LogFactory.getLog(getClass());

	private static HttpClient client = null;
	
	private static final int maxQueueCount = FileCfgUtils.MAXQUEUECOUNT;
	
	private static final int maxMessageQueueCount = FileCfgUtils.MAXMESSAGEQUEUECOUNT;
	
	private static final int currMessageCount = FileCfgUtils.CURRMESSAGECOUNT;
	
	private List<LinkedBlockingQueue<OrderMessage>> orderQueues;
	
	/**
	 * 获取执行凭证
	 */
	private boolean acquire()
	{
		log.info("acquire......");
	    for (LinkedBlockingQueue<OrderMessage> orderQueue : this.orderQueues)
	    {
	    	log.info("orderQueue.size():"+orderQueue.size());
	        if (maxMessageQueueCount - orderQueue.size() < currMessageCount)
	        {
	            return false;
	        }
	    }
	    log.info("acquired true......");
	    return true;
	}

	/**
	 * KJ订单接口
	 * 
	 * @throws HttpException
	 * @throws IOException
	 */
	public void orderMsgdoBiz() throws HttpException, IOException {
	    if (!acquire())
	    {
	    	log.info("acquired false......");
	        return;
	    }
		if (client == null) {
			client = initHttpClient();
		}
		List<NameValuePair> nameValueList = new ArrayList<NameValuePair>();

		Map<String, Object> map = new HashMap<String, Object>();
		GlobalConfigVO globalConfig = new GlobalConfigVO();
		PostMethod postMethod = new PostMethod(GlobalConfig.getPropertyValue("common.kj.ordorder.web.url"));
		try {
			postMethod.getParams().clear();
			postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
			JSONObject params = new JSONObject();
			JSONObject paramsData = new JSONObject();
			map.put("globalConfigName", "kj_max_order_id");
			
			IGlobalConfigService globalConfigService = SpringUtils.getBean("globalConfigService");
			
			PaginationVO<GlobalConfigVO> vo = globalConfigService.queryPagedList(map, 1, 1);
			if (vo != null) {
				globalConfig = vo.getResult().get(0);
				paramsData.put("OrderId", globalConfig.getGlobalConfigValue());
				params.put("data", paramsData.toString());
				params.put("api", GlobalConfig.getPropertyValue("common.kj.ordorder.web.api.bachId"));
				params.put("userCode", GlobalConfig.getPropertyValue("common.kj.ordorder.web.userCode"));
				params.put("passWord", MD5Util.encryption(GlobalConfig.getPropertyValue("common.kj.ordorder.web.passWord")));
				params.put("data_digest",MD5Util.encryption(paramsData.toString() + GlobalConfig.getPropertyValue("common.kj.ordorder.web.key")));
				nameValueList.add(new NameValuePair("logistics_interface",params.toString()));
				postMethod.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
				postMethod.setRequestBody(nameValueList.toArray(new NameValuePair[nameValueList.size()]));
				postMethod.addRequestHeader("Connection", "close");
				client.executeMethod(postMethod);
				if (postMethod.getStatusLine().getStatusCode() == 200) {
					InputStream inputStream = postMethod.getResponseBodyAsStream();   
					BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
			        StringBuffer stringBuffer = new StringBuffer();   
			        String responsess = "";
			        try {
			        	 String str= "";   
					        while((str = br.readLine()) != null){   
					            stringBuffer .append(str);   
					        } 
					        responsess = stringBuffer.toString();
					} catch (Exception e) {
						log.error("[获取ID接口调用失败]"+e.getMessage(), e);
						throw e;
					} finally {
						br.close();
				        inputStream.close();
					}
					JSONObject jsonresult = JSONObject.fromObject(responsess);

					String result = jsonresult.getString("success");
					String ordIds = jsonresult.getString("OrderIds").replace("[", "").replace("]", "");
					if (result.equals("true") && !"".equals(ordIds)) {
						log.info("获取ID start write txt");
						String logfile = FilesUtils.writeFile(ordIds);
						log.info("获取ID end write txt");
						String orderIds[] = ordIds.split(",");
						int max = orderIds.length;
						if (max > 0)
						{
						    int pageSize = (max + maxQueueCount - 1) / maxQueueCount;
						    for (int queueIndex = 0; queueIndex < maxQueueCount; queueIndex++)
						    {
						        int start = pageSize * queueIndex;
						        int end = (pageSize * (queueIndex + 1));
						        end = (end > max ? max : end);
						        LinkedBlockingQueue<OrderMessage> orderQueue = this.orderQueues.get(queueIndex);
						        log.info("Order Queue ['" + queueIndex + "'] add order id index form [start:'" + start + "'] to [end:'"  + end + "']" );
						        log.info("Order Queue ['" + queueIndex + "'] add order id form ['" + orderIds[start] + "'] to ['"  + orderIds[end] + "']" );
						        for (int orderIndex = start; orderIndex < end; orderIndex++)
						        {
						        	orderQueue.offer(new OrderMessage(orderIds[orderIndex], logfile));
						        }
						    }
						    globalConfig.setGlobalConfigValue(orderIds[max - 1]);
							globalConfigService.doModifyGlobalConfig(globalConfig);
						}
					} else {
						String errorCode = jsonresult.getString("errorCode");
						String errorMsg = jsonresult.getString("errorMsg");
						log.error("errorCode:" + errorCode + "    errorMsg:" + errorMsg);
					}
				} else {
					log.error("[Error:调用接口失败]");
				}
			}
		} catch (Exception e) {
			log.error("[Error:调用接口失败]", e);
			e.printStackTrace();
		}finally {
            postMethod.releaseConnection();
            client.getHttpConnectionManager().closeIdleConnections(0);
        }
	}

	/**
	 * 控制httpclient连接数
	 * 
	 * @return
	 */
	private static HttpClient initHttpClient() {
		HttpConnectionManagerParams params = new HttpConnectionManagerParams();
		// 指定向每个host发起的最大连接数，默认是2，太少了
		params.setDefaultMaxConnectionsPerHost(1000);
		// 指定总共发起的最大连接数，默认是20，太少了
		params.setMaxTotalConnections(5000);
		// 连接超时时间-10s
		params.setConnectionTimeout(60 * 1000);
		// 读取数据超时时间-60s
		params.setSoTimeout(60 * 1000);

		MultiThreadedHttpConnectionManager manager = new MultiThreadedHttpConnectionManager();
		manager.setParams(params);

		return new HttpClient(manager);
	}

	/**
	 * 定时扫描订单接口异常表数据，获取接口数据
	 *    
	 * @author Pippo
	 */
	public void getOrderInfoByInterFace(){
		Map<String,Object> searchMap = new HashMap<String, Object>();
		try {
			searchMap.put("orderDatatype", 0);
			searchMap.put("orderStatus", 0);
			searchMap.put("rownum",GlobalConfig.getPropertyValue("common.kj.ordorder.web.retryCount"));
			IOrderinterfaceErrorService opt_orderinterfaceErrorService = SpringUtils.getBean("opt_orderinterfaceErrorService");
			List<OrderinterfaceErrorVO> list =  opt_orderinterfaceErrorService.queryOrderinterfaceErrorList(searchMap);
			if(list == null || list.size() < 1){
				System.out.println("未扫描到订单接口异常表数据");
				return;
			}
			for(OrderinterfaceErrorVO orderinterfaceErrorVO : list){
				List<NameValuePair> nameValueList = new ArrayList<NameValuePair>();
				if (client == null) {
					client = initHttpClient();
				}
				PostMethod postMethod = new PostMethod(GlobalConfig.getPropertyValue("common.kj.ordorder.web.url"));
				try {
					postMethod.getParams().clear();
					postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");

					JSONObject params = new JSONObject();

					JSONObject paramsData = new JSONObject();
					paramsData.put("OrderId", orderinterfaceErrorVO.getOrderId());

					params.put("data", paramsData.toString());
					params.put("api", GlobalConfig.getPropertyValue("common.kj.ordorder.web.api.info"));
					params.put("userCode", GlobalConfig.getPropertyValue("common.kj.ordorder.web.userCode"));
					params.put("passWord", MD5Util.encryption(GlobalConfig.getPropertyValue("common.kj.ordorder.web.passWord")));
					params.put("data_digest", MD5Util.encryption(paramsData.toString()+ GlobalConfig.getPropertyValue("common.kj.ordorder.web.key")));
					nameValueList.add(new NameValuePair("logistics_interface", params.toString()));

					postMethod.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
					postMethod.setRequestBody(nameValueList.toArray(new NameValuePair[nameValueList.size()]));
					postMethod.addRequestHeader("Connection", "close");
					client.executeMethod(postMethod);
					if (postMethod.getStatusLine().getStatusCode() == 200) {
						InputStream inputStream = postMethod.getResponseBodyAsStream();   
						BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
				        StringBuffer stringBuffer = new StringBuffer();   
				        String responsess = "";
				        try {
				        	String str= "";   
					        while((str = br.readLine()) != null){   
					            stringBuffer .append(str);   
					        } 
					        responsess = stringBuffer.toString();
						} catch (Exception e) {
							postMethod.releaseConnection();
							log.error("[获取ID接口调用失败]"+e.getMessage(), e);
							e.printStackTrace();
						} finally {
							br.close();
					        inputStream.close();
						}
						JSONObject jsonresult = JSONObject.fromObject(responsess);
						String result = jsonresult.getString("success");
						if (result.equals("true")) {
							String orderInfo = jsonresult.getString("OrderInfo");
							orderInfo = orderInfo.substring(1,orderInfo.length() - 1);
							boolean flag = opt_orderinterfaceErrorService.orderCreatedToInterFace(orderInfo,orderinterfaceErrorVO.getOrderId(),true);
						} else {
							String errorCode = jsonresult.getString("errorCode");
							String errorMsg = jsonresult.getString("errorMsg");
							log.error("errorCode:" + errorCode + "    errorMsg:" + errorMsg + " orderIds:"+ orderinterfaceErrorVO.getOrderId());
						}
					} else {
						log.error("orderIds:" + orderinterfaceErrorVO.getOrderId() + "[Error:调用接口失败]" + System.currentTimeMillis());
					}
				} catch (Exception e) {
					log.error("orderIds:" + orderinterfaceErrorVO.getOrderId() + "[Error:调用接口失败]" + System.currentTimeMillis(), e);
					e.printStackTrace();
				}finally {
		            // 释放连接
		            postMethod.releaseConnection();
		            client.getHttpConnectionManager().closeIdleConnections(0);
		        }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    @Override
    public void afterPropertiesSet() throws Exception
    {
        this.orderQueues = new ArrayList<LinkedBlockingQueue<OrderMessage>>();
        
        for (int index = 0; index < maxQueueCount; index++)
        {
            this.orderQueues.add(new LinkedBlockingQueue<OrderMessage>(maxMessageQueueCount));
        }
        
        for (int index = 0; index < maxQueueCount; index++)
        {
            new Thread(new OrderMsgInfoTasker(this.orderQueues.get(index))).start();
        }
    }
}