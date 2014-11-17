package org.gavin.smarthome.listener;

import org.apache.log4j.Logger;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

public class WebSessionListener implements SessionListener{

	private static final Logger log = Logger.getLogger(WebSessionListener.class);
	
	@Override
	public void onExpiration(Session arg0) {
		// TODO Auto-generated method stub
		log.info("session 过期了");
	}

	@Override
	public void onStart(Session arg0) {
		// TODO Auto-generated method stub
		log.info("session 创建了");
	}

	@Override
	public void onStop(Session arg0) {
		// TODO Auto-generated method stub
		log.info("session 结束了");
	}

}
