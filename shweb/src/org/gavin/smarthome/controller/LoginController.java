package org.gavin.smarthome.controller;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.eclipse.jetty.util.log.Log;

import com.jfinal.core.Controller;
import com.jfinal.ext.render.CaptchaRender;
import com.oreilly.servlet.Base64Encoder;

public class LoginController extends Controller{

	private static final Logger log = Logger.getLogger(LoginController.class);
	
	public void index(){
		log.info("转到登录界面");
		render("/common/login.html");
	}
	
	public void doLogin(){
		log.info("---------login-------------");
		String username=getPara("username");
		String password=getPara("password");
		boolean rememberme = Boolean.valueOf(getPara("rememberme"));
		String code = getPara("code");
		log.info(username + "====================" + password + "======" + code + "===========" +  rememberme);
		Subject currentUser = SecurityUtils.getSubject();
		log.info("result:" + CaptchaRender.validate(this, code, "key"));
//		log.info("currentUser.isAuthenticated():" + currentUser.isAuthenticated());
//		log.info("currentUser.isRemembered():" + currentUser.isRemembered());
//		if (!currentUser.isAuthenticated() && currentUser.isRemembered()) {
//            Object principal = currentUser.getPrincipal();
//            if (null != principal) {
//                log.info("缓存中的用户名：" + String.valueOf(principal));
//            }
//        }
		UsernamePasswordToken token = new UsernamePasswordToken(username,
				password);
		token.setRememberMe(rememberme);
		try {
			currentUser.login(token);
			log.info("login success");
			forwardAction("/");
		}catch(AuthenticationException e){
			log.info("login failed");
			render("/common/login.html");
		}
	}
	
	public static void main(String[] args) {
		String str = "hello";
		String en = Base64.encodeToString(str.getBytes());
		String str2 = Base64.decodeToString(en);
		Assert.assertEquals(str, str2);
		
		String salt = "123";
		System.out.println(new Sha256Hash(str,salt).toString());
		
		PasswordService passwordService = new DefaultPasswordService();
		String encryptedPassword = passwordService.encryptPassword("gavin");
		System.out.println("|" +encryptedPassword);
	}
}
