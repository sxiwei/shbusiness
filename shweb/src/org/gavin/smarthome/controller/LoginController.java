package org.gavin.smarthome.controller;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Sha256Hash;

import com.jfinal.core.Controller;
import com.jfinal.ext.render.CaptchaRender;

public class LoginController extends Controller{

	private static final Logger log = Logger.getLogger(LoginController.class);
	
	public void index(){
		String exceptionClassName = (String)getRequest().getAttribute("shiroLoginFailure");
		log.info("exceptionClassName:" + exceptionClassName);
        String error = null;  
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {  
            error = "用户名/密码错误";  
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {  
            error = "用户名/密码错误";  
        } else if(exceptionClassName != null) {  
            error = "登录失败：" + exceptionClassName;  
        }  
        setAttr("msg", error);  
		render("/common/login.html");
	}
	
	public void captcha(){
		CaptchaRender img = new CaptchaRender("render_key");
		log.info("code in cookie:" + this.getCookie("render_key"));
		render(img);
	}
	
	public void validateCode(){
		log.info("校验验证码");
		String code = getPara("code");
		if(CaptchaRender.validate(this, code.toUpperCase(), "render_key")){
			setAttr("valid", true);
		}else{
			setAttr("valid", false);
		}
		renderJson();
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
