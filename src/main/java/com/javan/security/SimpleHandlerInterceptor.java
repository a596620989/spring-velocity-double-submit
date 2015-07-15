package com.javan.security;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 */
public class SimpleHandlerInterceptor extends HandlerInterceptorAdapter {
    
    private static final Logger logger = Logger.getLogger(SimpleHandlerInterceptor.class);
    
    //<reqestUrl, timestamp>的序列, 用来表示某次请求最后一次的
    private static Map<String, Long> requestTimestamp = new HashMap<String, Long>();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

	    logger.debug("enter interceptor");

		if (request.getMethod().equalsIgnoreCase("GET")) {
			// GET - allow the request
			return true;
		} else {
		    /**
		     * 计算两次相同请求的间隔.
		     * 每次请求会sleep 1秒, 如果我们检测到两次相同请求的间隔时间小于3秒, 则判定为重复提交.
		     * 同时打开两个相同的窗口并提交请求不在考虑范围内.
		     * 请不要在一秒内快速刷新页面多次, 不然会误报.
		     */
		    
		    String servletPath = request.getServletPath();
            
		    Long previousRequest = requestTimestamp.get(servletPath);
		    
		    //first request
		    if(previousRequest==null){
		        previousRequest = 0L;
		    }
		    
		    Long interval = System.currentTimeMillis() - previousRequest;
		    
		    if(interval < 1000){
		        logger.error("detect double submit" + servletPath);
		    }
		    
		    requestTimestamp.put(servletPath, System.currentTimeMillis());
		}
		
		return true;
	}

}
