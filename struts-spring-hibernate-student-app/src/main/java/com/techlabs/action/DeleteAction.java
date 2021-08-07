package com.techlabs.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlabs.model.Student;
import com.techlabs.service.StudentService;

public class DeleteAction implements Action{
	@Autowired
	private StudentService service;
	private Student student;
	private int id;
	private String name;
	private double cgpa;

	@Override
	public String execute() throws Exception {
		(this.student=new Student()).setId(id);
		this.student.setName(name);
		this.student.setCgpa(cgpa);
		service.deleteStudentFromDb(this.student);
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

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

}
