package com.techlabs.actions;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.techlab.services.StudentService;
import com.techlabs.model.Student;

public class AddAction implements Action{

	private Student student;
	private StudentService service;
	private List<Student> studentList;

	@Override
	public String execute() throws Exception {
		return null;
	}

	public String add() {

		return this.SUCCESS;
	}

	public String doAdd() {
		System.out.println(student.getName());
		System.out.println(student.getRollno());
		System.out.println(student.getCgpa());
		System.out.println(this.validateStudent());
		if (this.validateStudent()) {
			return this.SUCCESS;
		}
		return this.ERROR;
	}

	public String addToList() {
		service = StudentService.getInstance();

		if (this.validateStudent()) {
			service.addStudent(student);
			this.studentList = service.getStudentList();
			return this.SUCCESS;
		}

		return this.SUCCESS;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public boolean validateStudent() {
		if (student.getName().length() == 0) {
			return false;
		}

		if (student.getRollno() == 0) {
			return false;
		}

		if (student.getCgpa() == 0) {
			return false;
		}
		return true;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}


}
