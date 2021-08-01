package com.techlabs.actions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlabs.models.Student;
import com.techlabs.services.StudentService;

public class DisplayAction implements Action {
	@Autowired
	private StudentService service = null;
	private List<Student> studentList;

	@Override
	public String execute() throws Exception {
		setStudentList(service.getStudents());
		
		for(Student stud:studentList) {
			System.out.println(stud.getCgpa());
			System.out.println(stud.getRollNo());
		}
		System.out.println(service.getStudents().size());
		return this.SUCCESS;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
}
