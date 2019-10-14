package com.plf.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.plf.learn.base.Msg;
import com.plf.learn.bean.Employee;
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
	
	@GetMapping("/get/{pageNumber}/{pageSize}")
	public Msg getEmployeePage(@PathVariable int pageNumber,@PathVariable int pageSize){
		PageHelper.startPage(pageNumber,pageSize);
		List<Employee> list=employeeService.getAll();
		PageInfo<Employee> page=new PageInfo<Employee>(list);
		return Msg.success(page);
	}
}
