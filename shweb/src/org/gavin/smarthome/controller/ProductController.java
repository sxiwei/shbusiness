package org.gavin.smarthome.controller;

import com.jfinal.core.Controller;

public class ProductController extends Controller {

	public void index(){
		render("/product/index.html");
	}
}
