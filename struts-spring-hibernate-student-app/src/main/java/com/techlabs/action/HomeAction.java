package com.techlabs.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlabs.model.Student;
import com.techlabs.service.StudentService;

public class HomeAction implements Action{
	@Autowired
	private StudentService service;
	private List<Student> students;

	@Override
	public String execute() throws Exception {
		students=service.getStudentFromDb();
		return this.SUCCESS;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
