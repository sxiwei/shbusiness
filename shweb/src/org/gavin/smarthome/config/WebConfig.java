package org.gavin.smarthome.config;

import org.beetl.ext.jfinal.BeetlRenderFactory;
import org.gavin.smarthome.controller.HomeController;
import org.gavin.smarthome.controller.LoginController;
import org.gavin.smarthome.handler.GlobalHandler;
import org.gavin.smarthome.model.User;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.ext.plugin.shiro.ShiroInterceptor;
import com.jfinal.ext.plugin.shiro.ShiroPlugin;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;

public class WebConfig extends JFinalConfig{

	private Routes route;
	
	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		loadPropertyFile("jfinal.properties");
		me.setDevMode(getPropertyToBoolean("devMode"));
		me.setMainRenderFactory(new BeetlRenderFactory());
	}

	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		this.route = me;
		me.add("/",HomeController.class);
		me.add("/login",LoginController.class);
	}

	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
		String jdbcUrl = getProperty("jdbcUrl");
		String driver = getProperty("driverClass");
		String username = getProperty("username");
		String password = getProperty("password");

		// Druid
		DruidPlugin druidPlugin = new DruidPlugin(jdbcUrl, username, password, driver);
		
		me.add(druidPlugin);

		// ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
		arp.addMapping("sh_user", User.class);
		me.add(arp);

		// 加载Shiro插件
		 me.add(new ShiroPlugin(route));

		// 缓存插件
		me.add(new EhCachePlugin());
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		me.add(new ShiroInterceptor());
	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		me.add(new GlobalHandler());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFinal.start("WebRoot", 90, "/", 5);
	}

}
