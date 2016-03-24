package com.chengfeng.ne.basicInterface.http;


import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * <p>功能描述:提供接口的父类</p>
 * <p>Copyright:Copyright (c) 2015</p>
 * <p>Company:丞风智能科技有限公司</p>
 * @author 旷娣
 * @version 1.0 2015-8-22 下午2:38:22
 */
public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = -5950564776385104080L;

	private static final Log  logger = LogFactory.getLog(BaseServlet.class);
    private String method="";
    @Override
    public void service(ServletRequest request, ServletResponse response)  {
    	PrintWriter out = null;
    	try{
    		request.setCharacterEncoding("UTF-8");
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            //String CONTENT_TYPE = "text/html;charset=UTF-8";
            String CONTENT_TYPE = "application/x-www-form-urlencoded;charset=UTF-8";
            res.setContentType(CONTENT_TYPE);
            out = res.getWriter();
            String params = req.getParameter("params");// 参数
            String requestIp = getReomteIpFromRequest(req);// 请求IP
            logger.info("params:"+params);
            logger.info("requestIp:"+requestIp);
            String reqUri = req.getRequestURI().toString();
            String uriStr[] = reqUri.split("/");
            String uritemp = uriStr[uriStr.length-1];
            String bizOperStr[] = uritemp.split("\\.");
            String methodName = bizOperStr[0];
            method = methodName; 
        	req.setAttribute("methodName", methodName);
        	req.setAttribute("params", params);
            String result = this.doBiz(req,res);
            out.println(result);
    	}catch(Exception e){
    		logger.error("错误信息:",e);
    		//返回结果
    		if((BaseOperateServlet.EMPSYNC.equals(method))||BaseOperateServlet.SITESYNC.equals(method)){
    			JSONObject resultJson=new JSONObject();
    			resultJson.put("code", 500);
    			resultJson.put("message", "服务器错误："+e.getMessage());
	            out.println(resultJson.toString());
    		}else{
    			JSONObject resultJson=new JSONObject();
    			resultJson.put("code", 400);
    			resultJson.put("message", "系统异常："+e.getMessage());
	            out.println(resultJson.toString());
    		}
    	}
    	

    }
    
    /**
     * 执行业务操作
     * @author 旷娣
     * @param request
     * @param response
     * @return String
     */
    public abstract String doBiz(HttpServletRequest request,HttpServletResponse response);

    /**
     * 取得IP
     * @author 旷娣
     * @param request
     * @return
     */
    public static String getReomteIpFromRequest(HttpServletRequest request) {
        String ip = null;
        if (request.getHeader("ORIG_CLIENT_IP") != null) {
            ip = request.getHeader("ORIG_CLIENT_IP");
        }

        if (ip == null && request.getHeader("x-forwarded-for") != null) {
            ip = request.getHeader("x-forwarded-for");

            if (ip != null) {
                ip = ip.split("\\s*,\\s*")[0];
            }
        }

        if (ip == null) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
