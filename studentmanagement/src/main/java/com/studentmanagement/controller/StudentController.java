package com.studentmanagement.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentmanagement.entities.Login;
import com.studentmanagement.entities.Student;
import com.studentmanagement.service.StudentServiceImpl;

@Controller
@RequestMapping("student")
public class StudentController {
	@Autowired
	private StudentServiceImpl studentServiceImpl;

	@GetMapping("reg")
	public String registerPage(@ModelAttribute("student") Student student, Model model) {
		model.addAttribute("msg", "This is Student Registration Page");
		return "registerpage";
	}

	@PostMapping("save")
	public String registerStudent(@ModelAttribute("student") Student student, Model model) {
		int i = studentServiceImpl.addStudent(student);
		if (i != 0) {
			model.addAttribute("student", new Student());
			model.addAttribute("msg", "Registration successful.Your Registration Id is " + i);
		}

		return "registerpage";
	}

	@GetMapping("loginpage")
	public String loginpage(Model m) {

		m.addAttribute("loginob", new Login());
		// m.addAttribute("msg","this is registration page");

		return "login";

	}

	@PostMapping("validatelogin")
	public String loginValidation(@ModelAttribute Login login, Model m) {
		int i = 0;

		Student s = studentServiceImpl.getStudent(login.getStdId());

		if (login.getStdId() == s.getStdId() && login.getName().equalsIgnoreCase(s.getName()))
			i = 1;

		if (i != 0) {
			m.addAttribute("name", login.getName());
		}
		return "welcome";

	}

	@GetMapping("allstudents")
	public String getAllStudents(Model m) {

		List<Student> d = studentServiceImpl.getAllStudents();

		m.addAttribute("list", d);
		System.out.println(d);
		return "welcome";

	}

	@GetMapping("delete")
	public String deleteStudent(@RequestParam Integer id, Model m) {

		studentServiceImpl.deleteStudent(id);

		List<Student> d = studentServiceImpl.getAllStudents();

		m.addAttribute("list", d);
		System.out.println("deleted student id is   ------------>" + id);
		return "welcome";

	}
	@GetMapping("modify")
	public String showUpdatePage(@ModelAttribute Student student,@RequestParam Integer id,Model model) {
		model.addAttribute("msg", "Update Page for Id "+id);
		model.addAttribute("id", id);
		return "updatepage";
	}
	@PostMapping("modify")
	public String updateStudent(@RequestParam Integer id,@ModelAttribute Student student,Model model) {
		int i=studentServiceImpl.updateStudent(id,student.getName(),student.getBranch());
		if(i!=0) {
//			model.addAttribute("name", student.getName());
			model.addAttribute("msg", "update successful");
		}
		System.out.println(i);
		return "redirect:allstudents";
	}
//	@ModelAttribute("list")
//	public List<Student> getAllstd(){
//		return studentServiceImpl.getAllStudents()
//	}
}

