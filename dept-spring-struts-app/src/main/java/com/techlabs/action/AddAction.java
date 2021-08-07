package com.techlabs.action;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlabs.model.Department;
import com.techlabs.service.DepartmentService;


public class AddAction implements Action{
	@Autowired
	DepartmentService service;
	private Department department;
	

	@Override
	public String execute() throws Exception {
		return null;
	}
	public String add() throws SQLException {
		
		
		if(department.getDeptno()!=0 && department.getDname()!=null && department.getLocation()!=null) {
			service.addDepartment(department);
			return this.SUCCESS;
		}
		else {
			return this.ERROR;
		}
	}
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}


}
