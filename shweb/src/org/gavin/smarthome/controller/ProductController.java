package org.gavin.smarthome.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.gavin.smarthome.model.IPCProduct;

import com.jfinal.core.Controller;

public class ProductController extends Controller {

	private static final Logger log = Logger.getLogger(ProductController.class);
	
	public void index(){
		
		String ipcsortid = getPara(0);
		if(null == ipcsortid){
			ipcsortid = "1";
		}
		log.info("ipcsortid=" + ipcsortid);
		String sql = "select * from ipc_products where ipc_sortid=" + ipcsortid + " order by addtime desc ";
		List<IPCProduct> ipclist = IPCProduct.dao.find(sql);
		setAttr("ipclist", ipclist);
		render("/product/index.html");
	}
}
