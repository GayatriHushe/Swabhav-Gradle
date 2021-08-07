package com.techlabs.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlabs.model.Department;
import com.techlabs.service.DepartmentService;

public class HomeAction implements Action{
	@Autowired
	private DepartmentService service;
	private List<Department> departments;
	
	@Override
	public String execute() throws Exception {
		setDepartments(service.getList());
		return this.SUCCESS;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	
}
