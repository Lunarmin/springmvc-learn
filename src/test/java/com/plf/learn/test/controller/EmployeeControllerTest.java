package com.plf.learn.test.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:springmvc.xml" })
public class EmployeeControllerTest {
	// 传入Springmvc的IOC
	@Autowired
	WebApplicationContext context;

	// 虚拟mvc请求
	MockMvc mockMvc;

	@Before
	public void initMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testPage() throws Exception {
		// 模拟请求拿到返回值
		/*MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/employ/get/1/5")).andReturn();
		MockHttpServletResponse reponse = result.getResponse();
		System.out.println(reponse.getContentAsString());*/
		try {
			mockMvc.perform(MockMvcRequestBuilders
				.get("/employ/get/1/5") //请求的url,请求的方法是get
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())//打印出请求和相应的内容
				.andReturn().getResponse().getContentAsString(); //将相应的数据转换为字符串
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
