package com.plf.learn.dto;

import com.plf.learn.bean.Employee;

public class EmployeeDto extends Employee{

	private String deptName;

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
}
