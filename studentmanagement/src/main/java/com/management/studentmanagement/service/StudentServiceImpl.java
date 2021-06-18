package com.management.studentmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.studentmanagement.models.Student;
import com.management.studentmanagement.repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired 
	private StudentRepository repo;
	
	@Override
	public Student insertStudent(Student s) {
      
		Student st=repo.save(s);
	
		
		return st;
	}

	public Student getStudent(int sId) {
          Student s=repo.getById(sId);
		return s;
	}

	public List<Student> getAllStudents() {
		
		return repo.findAll();
	}

	public void deleteStudent(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

}
