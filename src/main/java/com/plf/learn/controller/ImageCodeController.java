package com.plf.learn.controller;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.plf.learn.utils.CodeImage;


@Controller
@RequestMapping("/vertify")
public class ImageCodeController {
	private final static Logger log = LoggerFactory.getLogger(ZtreeController.class);
	
	@RequestMapping("getCode")
	public void  getCodeImage(HttpServletRequest request, HttpServletResponse response,HttpSession session){
		Map<String,Object> map = CodeImage.getCodeImage();
		log.info("获取到Code为{}",map.get("code"));
		session.setAttribute("vertifycode", map.get("code"));
		try {
			ImageIO.write((RenderedImage) map.get("image"), "JPEG", response.getOutputStream());
	        response.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
