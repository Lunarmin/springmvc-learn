package com.plf.learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plf.learn.service.OutConfigService;


@RestController
@RequestMapping("/outconfig")
public class OutConfigController {

	private static Logger log = LoggerFactory.getLogger(OutConfigController.class);
	
	@Autowired
	private OutConfigService outConfigService;
	
	//在springmvc.xml导入配置文件，才能获取到值
	@Value("${download_path}")
	private String path;
	
	@RequestMapping("/path")
	public String getPath(){
		log.info("OutConfigController path is -- {}",path);
		outConfigService.getPath();
		return "success";
	}
}
