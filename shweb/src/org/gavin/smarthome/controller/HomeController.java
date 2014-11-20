package org.gavin.smarthome.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.gavin.smarthome.model.IndexCarousel;
import org.gavin.smarthome.model.IndexColumn;

import com.jfinal.core.Controller;
import com.jfinal.ext.render.CaptchaRender;

public class HomeController extends Controller{

	private static final Logger log = Logger.getLogger(HomeController.class);
	
	public void index(){
		String carouselSql = "select * from sh_index_carousel where usable=1 order by addTime desc";
		String columnSql = "select * from sh_index_column where 1=1 order by addTime desc";
		List<IndexCarousel> carouselList = IndexCarousel.dao.find(carouselSql);
		List<IndexColumn> columnList = IndexColumn.dao.find(columnSql);
		setAttr("carouselList", carouselList);
		setAttr("columnList", columnList);
		log.info("HomeController......index");
		render("/common/index.html");
	}
	
}
