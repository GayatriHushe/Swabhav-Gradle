package com.techlabs.actions;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlabs.models.StudentView;
import com.techlabs.services.StudentService;

public class AddAction implements Action {
	@Autowired
	private StudentService service = null;
	private StudentView student;

	@Override
	public String execute() throws Exception {
		//		service.addStudent(student);
		return this.SUCCESS;
	}

	public String addStudent() 
	{
		if (service.addStudent(student)) 
		{
			System.out.println("added");
			return this.SUCCESS;
		}
		System.out.println("Error");
		return this.ERROR;
	}


	public StudentView getStudent() {
		return student;
	}

	public void setStudent(StudentView student) {
		this.student = student;
	}

}
