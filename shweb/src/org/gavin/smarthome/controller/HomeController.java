package org.gavin.smarthome.controller;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import com.jfinal.core.Controller;

public class HomeController extends Controller{

	private static final Logger log = Logger.getLogger(HomeController.class);
	
	public void index(){
		
		render("/login");
	}
}
