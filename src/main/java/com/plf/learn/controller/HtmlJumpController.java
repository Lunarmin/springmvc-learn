package com.plf.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jump")
public class HtmlJumpController {

	@RequestMapping("/image")
	public String toImageHtml(){
		return "image";
	}
	
	@RequestMapping("/plupload")
	public String toPlupload(){
		return "plupload";
	}
}
