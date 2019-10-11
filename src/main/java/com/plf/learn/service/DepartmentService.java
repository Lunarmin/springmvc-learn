package com.plf.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.plf.learn.bean.Department;
import com.plf.learn.dao.DepartmentMapper;


@Service
public class DepartmentService {
	@Autowired
	private DepartmentMapper departmentMapper;

	@Cacheable(value = "myCache")
	public List<Department> getDepts() {
		return departmentMapper.selectByExample(null);
	}
	
}
