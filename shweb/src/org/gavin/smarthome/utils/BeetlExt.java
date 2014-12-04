package org.gavin.smarthome.utils;

import org.apache.log4j.Logger;

public class BeetlExt {

	private static final Logger log = Logger.getLogger(BeetlExt.class);
	
	public String loginMsg(String msg) {
		if(null==msg){
			return null;
		}
		log.info("登录消息转换：" + msg);
		return "登录失败,请重试";
	}
}
