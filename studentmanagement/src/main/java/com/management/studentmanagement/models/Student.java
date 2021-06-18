package com.management.studentmanagement.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Student {
	
	
	@Id
	@GeneratedValue
	private int sid;
	
	private String sname;
	private String password;
	private String course;

}
