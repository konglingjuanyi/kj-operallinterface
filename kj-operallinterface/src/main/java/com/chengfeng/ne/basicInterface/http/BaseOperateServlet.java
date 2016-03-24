package com.chengfeng.ne.basicInterface.http;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.chengfeng.ne.basicInterface.service.IBasicInterfaceService;
/**
 * 接口测试servlet
 * <p>功能描述：</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 丞风智能科技有限公司</p>
 * @author FengQing
 * @version 1.0 2015-8-22 下午3:31:37
 */
public class BaseOperateServlet extends BaseServlet  {
	private static final long serialVersionUID = -2396556511575352668L;
	public static final String EMPSYNC = "emp";    //同步员工数据
	public static final String SITESYNC = "site";    //同步网点数据
    
	public IBasicInterfaceService basicInterfaceService;
	
    private static final Log logger = LogFactory
			.getLog(BaseOperateServlet.class);
    
    /**
     * 注入service和dao
     */
    public void init(ServletConfig servletConfig) throws ServletException {
    	ServletContext servletContext = servletConfig.getServletContext();
		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext
				.getAutowireCapableBeanFactory();
		basicInterfaceService= (IBasicInterfaceService) autowireCapableBeanFactory
				.getBean("basicInterfaceService");
		
    }
    
    
    
	@Override
	public String doBiz(HttpServletRequest request, HttpServletResponse response) {
		String methodName = (String) request.getAttribute("methodName");
		String params = (String) request.getParameter("params");
		if(params==null){
			JSONObject obj = new JSONObject();
	        obj.put("code", 202);
	        obj.put("message", "参数为空");
	        return obj.toString();
		}
		if(EMPSYNC.equals(methodName)){
			params = (String) request.getAttribute("params");
		}else if(SITESYNC.equals(methodName)){
			params = (String) request.getAttribute("params");
		}
		logger.info("方法名为：" + methodName);
		logger.info("参数为：" + params);
		if (methodName == null) {
            JSONObject obj = new JSONObject();
            obj.put("code", 201);
            obj.put("message", "方法名错误");
            return obj.toString();
		}
		
		if (methodName.equals(EMPSYNC)) {
			return this.getEmployeeInfo(params);
		} else if (methodName.equals(SITESYNC)) {
			return this.getSiteInfo(params);
		}
		
		JSONObject obj = new JSONObject();
        obj.put("code", 201);
        obj.put("message", "方法名错误");
        return obj.toString();
	}

	/**
	 * 获取网点信息
	 * @param params
	 * @author FengQing
	 * @date 2015-8-22 下午3:34:53
	 */
	public String getSiteInfo(String params){
		logger.info("传入的参数" + params);
		//返回结果
		JSONObject resultJson=new JSONObject();
		if(params==null){
			resultJson.put("code", 202);
			resultJson.put("message", "参数错误");
			return resultJson.toString();
		}
		
		try{
			List<String> err = basicInterfaceService.parserSiteInfo(params);
			resultJson.put("code", 200);
			resultJson.put("message", "同步网点信息成功,失败的有:"+err);
			logger.info("同步网点信息成功,失败的有:"+err);
			return resultJson.toString();
		}catch(Exception e){
			logger.error("[error:同步网点信息失败]", e);
			//返回失败结果
			resultJson.put("code", 203);
			resultJson.put("message", "参数错误："+e.getMessage());
			return resultJson.toString();
		}
	}

	/**
	 * 获取员工信息
	 * @author 旷娣
	 * @param params
	 * @return String
	 */

    public String getEmployeeInfo(String params){	
    	//返回结果
    	JSONObject resultJson=new JSONObject();
    	if(params==null){
			resultJson.put("code", 202);
			resultJson.put("message", "参数错误");
			return resultJson.toString();
		}
		try{
			List<String> err = basicInterfaceService.ParseEmployeeInfo(params);
			//返回成功结果
			resultJson.put("code", 200);
			resultJson.put("message", "同步员工信息成功，错误的有："+err);
			logger.info("同步员工信息成功，错误的有："+err);
			return resultJson.toString();
		} catch(Exception e){
			logger.error("[Error:]同步员工信息失败",e);
			//返回失败结果
			resultJson.put("code", 500);
			resultJson.put("message", "服务器错误:"+e.getMessage());
			return resultJson.toString();
		} 

    }
}
