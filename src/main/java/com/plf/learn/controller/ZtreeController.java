package com.plf.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ztree")
public class ZtreeController {

	@RequestMapping("toztree")
	public String toZtree(){
		return "ztree";
	}
}
