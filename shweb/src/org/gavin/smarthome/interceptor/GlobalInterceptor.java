package org.gavin.smarthome.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;

/**
 */
public class GlobalInterceptor implements Interceptor {
	
	private static final Logger log = Logger.getLogger(GlobalInterceptor.class);
    @Override
    public void intercept(ActionInvocation ai) {
        Controller controller = ai.getController();
        HttpServletRequest req = controller.getRequest();
        String path = req.getRequestURI();
        log.info("path:" + path);
        String queryStr = req.getQueryString();
        log.info("queryStr:" + queryStr);
        ai.invoke();
    }
}
