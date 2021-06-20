package com.employeemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employeemanagement.entities.Employee;
import com.employeemanagement.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeSevice {

	@Autowired
	EmployeeRepo repo;	
	
	@Override
	public int insertEmployee(Employee empl) {
		// TODO Auto-generated method stub
		int i=0;
		Employee d=repo.save(empl);
		if(d!=null) {
			i=d.getEmp_id();
		}
		return i;
	}

	@Override
	public Employee getEmployee(int id) {

		Employee e=repo.getById(id);		
		return e;
	}	

	public List<Employee> getAllEmployee() {
		
		List<Employee> list=repo.findAll();		
		return list;
	}

	public void deleteEmployee(Integer id) {

	  repo.deleteById(id);
	}

	@Override
	public int modifyEmployee(int id, String name, String dept) {
		Employee e=repo.getById(id);
		e.setEmp_name(name);
		e.setDepartment(dept);		
		int i=insertEmployee(e);
		return i;
	}
}
