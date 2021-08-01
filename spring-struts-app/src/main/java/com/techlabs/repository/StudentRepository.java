package com.techlabs.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.techlabs.model.Student;

@Repository
public class StudentRepository {
	private List<Student> students=new ArrayList<Student>();
	
	public StudentRepository() {
		System.out.println("Repository created");
		students.add(new Student(1,"abc"));
		students.add(new Student(2,"def"));
		students.add(new Student(3,"ghi"));
		
	}
	
	public List<Student> getStudents() {
		return students;
	}
}
