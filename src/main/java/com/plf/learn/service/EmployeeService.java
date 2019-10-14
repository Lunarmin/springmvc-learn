package com.plf.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plf.learn.bean.Employee;
import com.plf.learn.bean.EmployeeExample;
import com.plf.learn.bean.EmployeeExample.Criteria;
import com.plf.learn.dao.EmployeeMapper;
import com.plf.learn.dto.EmployeeDto;
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeMapper employeeMapper;

	public void saveEmp(Employee employee) {
		employeeMapper.insert(employee);
	}
	
	public boolean checkUser(String empName) {
		EmployeeExample example=new EmployeeExample();
		Criteria criteria=example.createCriteria();
		criteria.andEmpNameEqualTo(empName);
		long count=employeeMapper.countByExample(example);
		return count==0;
	}
	
	public Employee getEmp(Integer id) {
		return employeeMapper.selectByPrimaryKey(id);
	}
	
	public List<Employee> getAll() {
		return employeeMapper.selectByExample(null);
	}
	
	public void updateEmp(Employee employee) {
		employeeMapper.updateByPrimaryKeySelective(employee);
	}
	
	public void deleteEmp(Integer id) {
		employeeMapper.deleteByPrimaryKey(id);
	}
	
	public void deleteBatch(List<Integer> del_ids) {
		EmployeeExample example=new EmployeeExample();
		Criteria criteria=example.createCriteria();
		criteria.andEmpIdIn(del_ids);
		employeeMapper.deleteByExample(example);
	}
	
	public EmployeeDto findEmployWithDeptById(Integer id){
		return employeeMapper.selectByPrimaryKeyWithDept(id);
	}
}
