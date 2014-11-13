package org.gavin.smarthome.controller;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.gavin.smarthome.model.User;

import com.jfinal.core.Controller;

public class LoginController extends Controller{

	private static final Logger log = Logger.getLogger(LoginController.class);
	
	public void index(){
		log.info("---------login-------------");
		Subject currentUser = SecurityUtils.getSubject();
		log.info("currentUser.isAuthenticated():" + currentUser.isAuthenticated());
		log.info("currentUser.isRemembered():" + currentUser.isRemembered());
		if(currentUser.isAuthenticated()){
			log.info("用户已经认证了");
			render("/index.html");
			return;
		}
		if (!currentUser.isAuthenticated() && currentUser.isRemembered()) {
            Object principal = currentUser.getPrincipal();
            if (null != principal) {
                log.info("缓存中的用户名：" + String.valueOf(principal));
            }
        }
		UsernamePasswordToken token = new UsernamePasswordToken("gavin",
				"gavin");
		token.setRememberMe(true);
		try {
			currentUser.login(token);
			log.info("login success");
		}catch(AuthenticationException e){
			log.info("login failed");
		}
		render("/index.html");
	}
}
