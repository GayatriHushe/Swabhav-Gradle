package com.techlabs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.models.Student;
import com.techlabs.repositories.StudentRepository;

@Service("studentSvc")
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public StudentService() {
		System.out.println("Service Created");
	}
	
	public List<Student> get(){
		return repo.getStudents();
	}
}
