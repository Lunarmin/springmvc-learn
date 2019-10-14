package com.plf.learn.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/download")
public class DownLoadController {
	
	@GetMapping("/image")
	public ResponseEntity<byte[]> download(){
		String path="E:/temp/";
		String filename="9.jpg";
		File file = new File(path+filename);
		HttpHeaders headers = new HttpHeaders();
		String downloadFileName = "default.jpg";
		try {
			//防止中文乱码
			downloadFileName = new String(filename.getBytes("UTF-8"),"ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//通知浏览器以attachment(下载方式)打开图片
		headers.setContentDispositionFormData("attachment", downloadFileName);
		//application/octet-stream 二进制流数据
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		
		try {
			return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
					headers,HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
