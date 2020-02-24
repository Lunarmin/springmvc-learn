package com.plf.learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ztree")
public class ZtreeController {

	private final static Logger log = LoggerFactory.getLogger(ZtreeController.class);
	
	@RequestMapping("toztree")
	public String toZtree(){
		log.info("进入Ztree测试页面 ");
		return "ztree";
	}
}
