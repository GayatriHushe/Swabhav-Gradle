package com.techlabs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techlabs.model.Student;
import com.techlabs.repository.StudentRepository;

@Service
@Transactional
public class StudentService {
	@Autowired
	private StudentRepository repo;
	
	public StudentService() {
		System.out.println("Student Service");
	}

	public void addStudentToDb(Student student) {
		repo.addStudent(student);
	}

	public List<Student> getStudentFromDb(){
		return repo.getStudents();
	}
	
	public void updateStudentToDb(Student student) {
		repo.updateStudent(student);
	}
	
	public void deleteStudentFromDb(Student student) {
		repo.deleteStudent(student);
	}
}
