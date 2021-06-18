package com.management.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.studentmanagement.models.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

}
