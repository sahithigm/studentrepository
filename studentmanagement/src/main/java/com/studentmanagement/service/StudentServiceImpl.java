package com.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.entities.Student;
import com.studentmanagement.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentRepo repo;
	
	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
		int i=0;
		Student s=repo.save(student);
		if(s!=null) {
			i=s.getStdId();
		}
		return i;
	}

	@Override
	public Student getStudent(int id) {
		Student s=repo.getById(id);
		return s;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> ls=repo.findAll();
		return ls;
	}

	@Override
	public void deleteStudent(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public int updateStudent(int id,String name,String branch) {
		// TODO Auto-generated method stub
		Student s1=repo.getById(id);
		s1.setName(name);
		s1.setBranch(branch);
		int i=addStudent(s1);
		return i;
	}
}
