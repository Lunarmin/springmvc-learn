package com.plf.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plf.learn.base.Msg;
import com.plf.learn.dto.EmployeeDto;
import com.plf.learn.service.EmployeeService;

@RestController
@RequestMapping("/employ")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/get/{id}")
	public Msg getEmployeeWithDept(@PathVariable int id){
		EmployeeDto result = employeeService.findEmployWithDeptById(id);
		return Msg.success(result);
	}
}
