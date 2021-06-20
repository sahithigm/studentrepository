package com.employeemanagement.service;

import java.util.List;

import com.employeemanagement.entities.Employee;

public interface EmployeeSevice {
	public int insertEmployee(Employee eid);
	public  Employee getEmployee(int id);
	public List<Employee> getAllEmployee();
	public void deleteEmployee(Integer id);
	public  int modifyEmployee(int id,String name,String dept);
}
