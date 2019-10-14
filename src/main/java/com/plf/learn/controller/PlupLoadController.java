package com.plf.learn.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plf.learn.service.PluploadService;
import com.plf.learn.vo.Plupload;


@RestController
@RequestMapping("/plup")
public class PlupLoadController{

	@PostMapping("/upload")
	public void UpContent(Plupload plupload,HttpServletRequest request,HttpServletResponse response) {
		if(plupload!=null){
			plupload.setRequest(request);
			PluploadService.upload(plupload, new File("E://upload"));
		}
	}
}
