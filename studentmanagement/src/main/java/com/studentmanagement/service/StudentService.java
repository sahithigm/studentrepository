package com.studentmanagement.service;


import java.util.List;

import com.studentmanagement.entities.Student;

public interface StudentService {
	
	public int addStudent(Student student);
	public Student getStudent(int id);
	public List<Student> getAllStudents();
	public void deleteStudent(Integer id);
	public int updateStudent(int id,String name,String branch);
}
