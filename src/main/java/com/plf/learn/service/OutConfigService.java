package com.plf.learn.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OutConfigService {
	
	//在spring.xml中引入即可读取
	@Value("${download_path}")
	private String path;
	
	private static Logger log = LoggerFactory.getLogger(OutConfigService.class);
	
	public void getPath(){
		log.info("OutConfigService path is -- {}",path);
	}
}
