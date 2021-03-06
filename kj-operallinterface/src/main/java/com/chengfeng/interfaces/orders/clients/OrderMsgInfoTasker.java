/**
 * 文件名: OrderMsgInfoTasker.java
 * 版    权: Copyright © 2013 - 2016 ThinkJF, Inc. All Rights Reserved
 * 描    述: <描述>
 * 修改人: WeiQiang.Fan
 * 修改时间: 2016年2月26日
 * 跟踪单号: <跟踪单号>
 * 修改单号: <修改单号>
 * 修改内容: <修改内容>
 */
package com.chengfeng.interfaces.orders.clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

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

import com.chengfeng.common.util.MD5Util;
import com.chengfeng.common.util.SpringUtils;
import com.chengfeng.common.util.ThreadPoolUtils;
import com.chengfeng.ne.opt.orders.domain.OrderinterfaceErrorVO;
import com.chengfeng.ne.opt.orders.service.IOrderinterfaceErrorService;
import com.thinkjf.core.config.GlobalConfig;
import com.thinkjf.service.ServiceException;

/**
 * <p>功能描述：</p>
 * <p>Company: 上海丞风智能科技有限公司</p>
 * @author WeiQiang.Fan
 * @version 1.0 2016年2月26日
 */
public class OrderMsgInfoTasker implements Runnable
{
    private final Log log = LogFactory.getLog(getClass());
    
    private final LinkedBlockingQueue<OrderMessage> queue;
    
    private HttpClient client = null;
    
    private AtomicLong count= new AtomicLong(0);
    
    public OrderMsgInfoTasker(LinkedBlockingQueue<OrderMessage> queue)
    {
        this.queue = queue;
        
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

        this.client = new HttpClient(manager);
    }

    @Override
    public void run()
    {
        while(true)
        {
            OrderMessage orderMsg = null;
            if (null != (orderMsg = this.queue.poll()))
            {
            	long cut = count.incrementAndGet();
            	log.info("poll message:"+cut);
                consumeMesage(orderMsg);
            }
            else
            {
                try
                {
                    log.info("no data pull from kj order message!");
                    Thread.sleep(5000);
                }
                catch (InterruptedException e)
                {
                    log.error("sleep error!", e);
                }
            }
        }
    }
    
    private void consumeMesage(OrderMessage orderMsg)
    {
        // 每调用一次自增1
        String orderId = orderMsg.getOrderId();
        int num = 1;
        String orderErrorMessage = "";
        while (num < 6) {
            try {
                queryOrderContentById(orderId);
                return;
            } catch (Exception e1) {
                log.error("orderIds:" + orderId + "[Error:调用接口失败]" + System.currentTimeMillis() + "num:"+num, e1);
                orderErrorMessage = e1.getMessage();
                try {
                    num++;
                    Thread.sleep(100);//休眠0.1秒后重新调用
                } catch (InterruptedException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
        //当接口调用超过5次未成功不再调用接口，将订单ID保存至数据库表中，后续定时任务重新扫描调用接口
        try {
            OrderinterfaceErrorVO orderinterfaceErrorVO = new OrderinterfaceErrorVO();
            orderinterfaceErrorVO.setOrderId(Long.valueOf(orderId));
            orderinterfaceErrorVO.setOrderDatatype(0);
            orderinterfaceErrorVO.setOrderStatus(0);
            orderinterfaceErrorVO.setOrderErrorMessage(orderErrorMessage);
            
            IOrderinterfaceErrorService opt_orderinterfaceErrorService = SpringUtils.getBean("opt_orderinterfaceErrorService");
            
            opt_orderinterfaceErrorService.doCreateOrderinterfaceError(orderinterfaceErrorVO);
        } catch (ServiceException e) {
            log.error("订单超时记录保存失败。"+e.getMessage(),e);
            e.printStackTrace();
        }
    }
    
    /**
     * 快捷接口：获取订单内容
     * 
     * @param orderIds
     * @return
     * @throws HttpException
     * @throws IOException
     */
    public String queryOrderContentById(String orderIds) throws Exception{
        List<NameValuePair> nameValueList = new ArrayList<NameValuePair>();
        PostMethod postMethod = new PostMethod(GlobalConfig.getPropertyValue("common.kj.ordorder.web.url"));
        try {
            postMethod.getParams().clear();
            postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");

            JSONObject params = new JSONObject();

            JSONObject paramsData = new JSONObject();
            paramsData.put("OrderId", orderIds);

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
                    throw e;
                } finally {
                    br.close();
                    inputStream.close();
                }
                JSONObject jsonresult = JSONObject.fromObject(responsess);
                String result = jsonresult.getString("success");
                if (result.equals("true")) {
                    String orderInfo = jsonresult.getString("OrderInfo");
                    orderInfo = orderInfo.substring(1,orderInfo.length() - 1);
                    IOrderinterfaceErrorService opt_orderinterfaceErrorService = SpringUtils.getBean("opt_orderinterfaceErrorService");
                    opt_orderinterfaceErrorService.orderCreatedToInterFace(orderInfo,Long.valueOf(orderIds),false);
                } else {
                    String errorCode = jsonresult.getString("errorCode");
                    String errorMsg = jsonresult.getString("errorMsg");
                    log.error("errorCode:" + errorCode + "    errorMsg:" + errorMsg + " orderIds:"+ orderIds);
                }
            } else {
                log.error("orderIds:" + orderIds + "[Error:调用接口失败]" + System.currentTimeMillis());
            }
        } catch (Exception e) {
            throw e;
        }finally {
            // 释放连接
            postMethod.releaseConnection();
            client.getHttpConnectionManager().closeIdleConnections(0);
        }
        return null;
    }
}
