package com.plf.learn.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class CustomThreadPoolTask {
	@Autowired
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;
	
	private static Logger log = LoggerFactory.getLogger(CustomThreadPoolTask.class);
	
	public void printSentence(){
		threadPoolTaskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				log.info("===============>CustomThreadPoolTask.printSentence()<===============");
			}
		});
	}
}
