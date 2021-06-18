package com.management.studentmanagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.management.studentmanagement.models.Login;
import com.management.studentmanagement.models.Student;
import com.management.studentmanagement.service.StudentServiceImpl;

@Controller
public class StudentController {
	
	@Autowired 
	private StudentServiceImpl service; 
	
	@GetMapping("login")
	public String loginpage(Model m) {
		
		m.addAttribute("loginob",new Login());
		
		return "login";
		
	}
	@GetMapping("/")
	public String homePage()
	{
		return "home";
	}
	@GetMapping("register")
	public String register(Model m) {
		
		m.addAttribute("student",new Student());
		return "register";
		
	}
	@GetMapping("save")
	public String register(@ModelAttribute Student s,Model m ) {
		Student st=service.insertStudent(s);
		if(st!=null) {
			m.addAttribute("name",st.getSname());
			return "welcome";
		}
		return "register";
	}
	@PostMapping("validatelogin")
	public String loginValidation(@ModelAttribute Login login,Model m ) {
		int i=0;
		Student s=service.getStudent(login.getSid());
		if(s==null)
		{
			return "login";
		}
		if(login.getSid()==s.getSid() && login.getPassword().equals(s.getPassword()))
		{
			i=1;
		}	
		if(i!=0) {
		m.addAttribute("name", s.getSname());
		
		}
		
		return "welcome";
	}
	@GetMapping("allstudents")
	public String getStudents(Model m ) {
		List<Student> s=service.getAllStudents();
		m.addAttribute("list", s);
	    
	     return "welcome";

        }
	@GetMapping("delete")
	public String deleteStudent(@RequestParam Integer id,Model m) {
		service.deleteStudent(id);
		List<Student> s=service.getAllStudents();
		m.addAttribute("list", s);
	return "welcome";
	
       }
	@GetMapping("modify")
	public String modifyStudent(@RequestParam Integer id,Model m) {
		
		
		//service.insertStudent(s);
		System.out.println(id);
		
		m.addAttribute("id", id);
		  m.addAttribute("student",new Student());
		  
//		List<Student> s=service.getAllStudents();
//		
//		m.addAttribute("list", s);
//		System.out.println("deleted doctor id is   ------------>"+id);
	return "edit";
	
       }
	
	@GetMapping("update")
	public String updateStudent(@ModelAttribute Student s,Model m)
	{
		service.insertStudent(s);
		m.addAttribute("name",s.getSname());
		return "welcome";
	}
	
	

}
