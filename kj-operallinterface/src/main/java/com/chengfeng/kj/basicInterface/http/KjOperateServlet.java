/**
 * 文件名: KjOperateServlet.java
 * 版 权: Copyright © 2013 - 2016 ThinkJF, Inc. All Rights Reserved
 * 描 述: <描述>
 * 修改人: Bin.Zhang
 * 修改时间: 2016-3-18
 * 跟踪单号: <跟踪单号>
 * 修改单号: <修改单号>
 * 修改内容: <修改内容>
 */
package com.chengfeng.kj.basicInterface.http;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chengfeng.kj.basicInterface.dao.OrdStatusDao;
import com.chengfeng.kj.opt.orders.domain.OrdStatuVO;

/**
 * <p>功能描述：</p>
 * <p>Company: 上海丞风智能科技有限公司</p>
 * @author Bin.Zhang
 * @version 1.0 2016-3-18
 */
public class KjOperateServlet extends KjBaseServlet
{

    /**
     * 
     */
    private static final long serialVersionUID = 1969420361388172762L;

    private OrdStatusDao ordStatusDao;

    private Date currentDate = null;

    private static final String TABLENAME1 = "HS_ORD_STATUS_BI01";

    private static final String TABLENAME2 = "HS_ORD_STATUS_BI02";

    private static final String TABLENAME3 = "HS_ORD_STATUS_BI03";
    
    private  List<String> whiteList;

    /**
     * 注入service和dao
     */
    public void init(ServletConfig servletConfig) throws ServletException
    {
        ServletContext servletContext = servletConfig.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils
                .getWebApplicationContext(servletContext);
        AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext.getAutowireCapableBeanFactory();
        ordStatusDao = (OrdStatusDao) autowireCapableBeanFactory.getBean("ordStatusDao");
        whiteList = new ArrayList<String>();
        
        String white = servletConfig.getInitParameter("whitelist");
        if(white != null || white.length() > 0){
            String[] splits = white.split(",");
            for(String split : splits){
                whiteList.add(split);
            }
        }
        
        
    }
    
    protected boolean visitChk(String reqestIp)
    {
        if (this.whiteList.contains(reqestIp))
        {
            return true;
        }
        return false;
    }

    /**
     * 具体操作
     */
    @Override
    protected String doWork(HttpServletRequest req, HttpServletResponse resp)
    {
        this.currentDate = new Date();
        String parameter = req.getParameter("params");
        /*
         * try
         * StringBuilder sb = new StringBuilder();
         * {
         * BufferedReader reader = req.getReader();
         * char[] buff = new char[1024];
         * int len ;
         * while( (len = reader.read(buff)) != -1){
         * sb.append(buff);
         * }
         * }
         * catch (IOException e)
         * {
         * // TODO Auto-generated catch block
         * e.printStackTrace();
         * }
         */
        if (parameter == null)
        {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", 202);
            jsonObject.put("message", "参数为空");
            return jsonObject.toString();
        }
        else
        {
            return timerInsert(currentDate, parameter);
        }
    }

    /**
     * 导入数据到具体的表中
     * @param currentDate
     * @param parameter
     * @return
     */
    private String timerInsert(Date currentDate, String parameter)
    {
        String tableName = "";
        List<OrdStatuVO> OrdStatusVos = JSON.parseArray(parameter, OrdStatuVO.class);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        long zr = ((Calendar) calendar.clone()).getTimeInMillis();
        calendar.set(Calendar.HOUR_OF_DAY, 4);
        long four = ((Calendar) calendar.clone()).getTimeInMillis();
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        long tw = ((Calendar) calendar.clone()).getTimeInMillis();
        calendar.set(Calendar.HOUR_OF_DAY, 20);
        long tt = ((Calendar) calendar.clone()).getTimeInMillis();
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        long tf = ((Calendar) calendar.clone()).getTimeInMillis();

        long currentTime = currentDate.getTime();
        if (currentTime >= four && currentTime < tw)
        {
            tableName = KjOperateServlet.getTablename1();
        }

        if (currentTime >= tw && currentTime < tt)
        {
            tableName = KjOperateServlet.getTablename2();
        }

        if (currentTime >= tt && currentTime <= tf || currentTime >= zr && currentTime < four)
        {
            tableName = KjOperateServlet.getTablename3();
        }
        boolean insertResult = this.ordStatusDao.insertBatch(tableName, OrdStatusVos);
        JSONObject jsonObject = new JSONObject();

        if (insertResult)
        {
            jsonObject.put("code", 200);
            jsonObject.put("message", "success!");
        }
        else
        {
            jsonObject.put("code", 500);
            jsonObject.put("message", "接收端插入数据故障!");
        }
        return jsonObject.toString();
    }

    public static String getTablename1()
    {
        return TABLENAME1;
    }

    /**
     * @return the tablename2
     */
    public static String getTablename2()
    {
        return TABLENAME2;
    }

    /**
     * @return the tablename3
     */
    public static String getTablename3()
    {
        return TABLENAME3;
    }

}
