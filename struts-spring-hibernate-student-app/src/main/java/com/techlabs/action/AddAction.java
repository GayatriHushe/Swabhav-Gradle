package com.techlabs.action;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlabs.model.Student;
import com.techlabs.service.StudentService;

public class AddAction implements Action{
	@Autowired
	private StudentService service;
	private Student student;
	

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public String add(){
		System.out.println(student);
		if(student.getId()==0 && student.getName()==null && student.getCgpa()==0) {
			return this.ERROR;
		}
		service.addStudentToDb(student);
		return this.SUCCESS;
	}

	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}

}
