package com.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employeemanagement.entities.Employee;
import com.employeemanagement.entities.Login;
//import org.springframework.web.bind.annotation.RequestMethod;
import com.employeemanagement.service.EmployeeServiceImpl;

@Controller
@RequestMapping("employee")
public class RegisterController {

	@Autowired
	private EmployeeServiceImpl service;

	@GetMapping("reg")
	// @RequestMapping(value="reg", method=RequestMethod.GET)
	public String register(Model m) {

		m.addAttribute("employee", new Employee());
		return "Register";

	}

	@GetMapping("save")
	public String registerDoctor(@ModelAttribute Employee emp, Model m) {

		System.out.println("Employee id :" + emp.getEmp_id());
		System.out.println("Employee name: " + emp.getEmp_name());
		System.out.println("Department " + emp.getDepartment());

		int i = service.insertEmployee(emp);

		if (i != 0) {
			m.addAttribute("employee", new Employee());
			m.addAttribute("msg", "Registration success. Registration id is: " + i);
		}
		return "Register";

	}

	@GetMapping("loginpage")
	public String loginpage(Model m) {

		m.addAttribute("loginob", new Login());
		m.addAttribute("msg","Register Here");

		return "login";

	}

	@PostMapping("validatelogin")
	public String loginValidation(@ModelAttribute Login login, Model m) {
		int i = 0;

		Employee d = service.getEmployee(login.getEmp_id());

		if (login.getEmp_id() == d.getEmp_id() && login.getEmp_name().equalsIgnoreCase(d.getEmp_name()))
			i = 1;

		if (i != 0) {
			m.addAttribute("name", login.getEmp_name());

		}
		return "welcome";

	}

	@GetMapping("allemployees")
	public String getAllDoctors(Model m) {

		List<Employee> d = service.getAllEmployee();
		m.addAttribute("list", d);
		System.out.println(d);
		return "welcome";

	}

	@GetMapping("delete")
	public String deleteDoctor(@RequestParam Integer id, Model m) {

		service.deleteEmployee(id);

		List<Employee> d = service.getAllEmployee();

		m.addAttribute("list", d);
		System.out.println("deleted employee id is: " + id);
		return "welcome";

	}
	
	@GetMapping("modify")
	public String showUpdatePage(@ModelAttribute Employee employee,@RequestParam Integer id,Model model) {
		model.addAttribute("msg", "Update Page for Id "+id);
		model.addAttribute("id", id);
		return "update";
	}
	
	@PostMapping("modify")
	public String modifyDoctor(@RequestParam Integer id,@ModelAttribute Employee employee,Model model) {
		int i=service.modifyEmployee(id,employee.getEmp_name(),employee.getDepartment());
				
		if(i!=0) {
//			model.addAttribute("name", student.getName());
			model.addAttribute("msg", "update successful");
		}
		System.out.println(i);
		return "redirect:allemployees";
	}

}
