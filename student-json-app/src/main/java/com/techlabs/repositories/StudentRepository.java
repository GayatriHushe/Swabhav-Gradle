package com.techlabs.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.techlabs.models.Student;

@Repository
public class StudentRepository {

	private List<Student> studentList;
	
	
	public StudentRepository() {
		studentList = new ArrayList<Student>();
		studentList.add(new Student("GAYATRI", 1, 9.57));
		studentList.add(new Student("DEEPAK", 2, 9.16));
		studentList.add(new Student("SHIVAM", 3, 7.20));
		studentList.add(new Student("NIKHIL", 4, 7.84));
		studentList.add(new Student("RAJ", 5, 6.53));
	}

	public List<Student> getStudents() {
		return this.studentList;
	}

}
