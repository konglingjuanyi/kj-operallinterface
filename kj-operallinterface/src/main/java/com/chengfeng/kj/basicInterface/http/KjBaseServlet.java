/**
 * 文件名: KjBaseServlet.java
 * 版 权: Copyright © 2013 - 2016 ThinkJF, Inc. All Rights Reserved
 * 描 述: <描述>
 * 修改人: Bin.Zhang
 * 修改时间: 2016-3-18
 * 跟踪单号: <跟踪单号>
 * 修改单号: <修改单号>
 * 修改内容: <修改内容>
 */
package com.chengfeng.kj.basicInterface.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * <p>功能描述：</p>
 * <p>Company: 上海丞风智能科技有限公司</p>
 * @author Bin.Zhang
 * @version 1.0 2016-3-18
 */
public abstract class KjBaseServlet extends HttpServlet
{

    /**
     * 
     */
    private static final long serialVersionUID = 4114645252738971013L;

    private static final Log logger = LogFactory.getLog(KjBaseServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        PrintWriter out = null;
        out = resp.getWriter();
        String contentType = "application/x-www-form-urlencoded;charset=UTF-8";
        resp.setContentType(contentType);
        try
        {
            String reqestIp = this.getRequestIp(req);
            if (visitChk(reqestIp))
            {
                String doWorkResult = doWork(req, resp);
                out.write(doWorkResult);
            }
            else
            {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code", 405);
                jsonObject.put("message", "非合法主机！");
                out.write(jsonObject.toString());
            }

        }
        catch (Exception e)
        {
            logger.error("错误：", e);
            JSONObject jsonObject = new JSONObject();
            if (req.getRequestURI() != null)
            {
                jsonObject.put("code", 500);
                jsonObject.put("message", "服务器故障:" + e.getMessage());
            }
            else
            {
                jsonObject.put("code", 400);
                jsonObject.put("message", "系统故障:" + e.getMessage());
            }
            out.write(jsonObject.toString());
        }

    }

    /**
     * @param reqr
     * @param resp
     */
    protected abstract String doWork(HttpServletRequest req, HttpServletResponse resp);

    /**
     * @param reqestIp
     * @return
     */
    protected abstract boolean visitChk(String reqestIp);

    /**
     * @return
     */
    private String getRequestIp(HttpServletRequest req)
    {
        if (req.getHeader("x-forwarded-for") == null)
        {
            return req.getRemoteAddr();
        }
        return req.getHeader("x-forwarded-for");
    }

}
