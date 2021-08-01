package com.techlabs.actions;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlabs.models.StudentView;
import com.techlabs.services.StudentService;

public class EditAction implements Action{
	@Autowired
	private StudentService service = null;
	private StudentView student;
	private String id;

	@Override
	public String execute() throws Exception 
	{
		student = service.getStudent(id);
		return this.SUCCESS;
	}

	public String EditStudent() {
		this.setStudent(service.getStudent(id));
		System.out.println(this.getStudent().getName());
		System.out.println(this.getStudent().getId());
		
		return this.SUCCESS;
	}

	public String doEditStudent() 
	{
		System.out.println("ID: is " + this.getStudent().getId());
		System.out.println("here");
		System.out.println(student.getName());
		if (service.editStudent(this.getStudent())) {
			return this.SUCCESS;
		}
		return this.ERROR;
	}

	public StudentView getStudent() {
		return student;
	}

	public void setStudent(StudentView student) {
		this.student = student;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
