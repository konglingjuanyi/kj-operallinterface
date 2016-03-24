/**
 * 文件名: OrderMessage.java
 * 版    权: Copyright © 2013 - 2016 ThinkJF, Inc. All Rights Reserved
 * 描    述: <描述>
 * 修改人: WeiQiang.Fan
 * 修改时间: 2016年2月26日
 * 跟踪单号: <跟踪单号>
 * 修改单号: <修改单号>
 * 修改内容: <修改内容>
 */
package com.chengfeng.interfaces.orders.clients;

/**
 * <p>功能描述：</p>
 * <p>Company: 上海丞风智能科技有限公司</p>
 * @author WeiQiang.Fan
 * @version 1.0 2016年2月26日
 */
public class OrderMessage
{
    // 订单ID
    private final String orderId;
    
    // 订单ID所在的日志文件
    private final String logFile;

    /**
     * @param orderId
     * @param logFile
     */
    public OrderMessage(String orderId, String logFile)
    {
        this.orderId = orderId;
        this.logFile = logFile;
    }

    /**
     * @return the orderId
     */
    public String getOrderId()
    {
        return orderId;
    }

    /**
     * @return the logFile
     */
    public String getLogFile()
    {
        return logFile;
    }
}
