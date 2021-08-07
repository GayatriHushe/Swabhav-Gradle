package com.techlabs.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlabs.model.Student;
import com.techlabs.service.StudentService;

public class EditAction implements Action{
	@Autowired
	private StudentService service;
	private Student student;
	private int id;
	private String name;
	private double cgpa;
	
	public String doEdit() {
		if(student.getId()==0 && student.getName()!=null && student.getCgpa()==0) {
			return this.ERROR;
		}
		service.updateStudentToDb(student);
		return this.SUCCESS;
	}

	@Override
	public String execute() throws Exception {
		(this.student=new Student()).setId(id);
		this.student.setName(name);
		this.student.setCgpa(cgpa);
		return this.SUCCESS;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(int cgpa) {
		this.cgpa = cgpa;
	}

}
