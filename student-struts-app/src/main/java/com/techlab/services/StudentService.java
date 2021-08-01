package com.techlab.services;

import java.util.ArrayList;
import java.util.List;

import com.techlabs.model.Student;

public class StudentService {
	private static StudentService serviceInstance;
	private List<Student> studentList;

	public StudentService() {
		setStudentList(new ArrayList<Student>());

		Student stud1 = new Student();
		stud1.setName("Student 1");
		stud1.setRollno(2);
		stud1.setCgpa(7);
		getStudentList().add(stud1);

	}
	
	public static StudentService getInstance() {
		if (serviceInstance == null) {
			serviceInstance = new StudentService();
		}
		return serviceInstance;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void addStudent(Student student) {
		studentList.add(student);
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

}
