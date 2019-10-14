package com.plf.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plf.learn.base.Msg;
import com.plf.learn.config.CustomThreadPoolTask;

@RestController
@RequestMapping("/custom")
public class CustomController {

	@Autowired
	private CustomThreadPoolTask customThreadPoolTask;
	
	@GetMapping("/print")
	public Msg threadPoolPrint(){
		customThreadPoolTask.printSentence();
		return Msg.success();
	}
}
