package com.techlabs.action;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlabs.model.Department;
import com.techlabs.service.DepartmentService;

public class EditAction implements Action{
	@Autowired
	DepartmentService service;
	private Department department;
	private int deptno;
	private String dname;
	private String location;

	@Override
	public String execute() throws Exception {
		(this.department= new Department()).setDeptno(deptno);
		this.department.setDname(dname);
		this.department.setLocation(location);
		return this.SUCCESS;
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String doEdit() throws SQLException {
		if(department.getDeptno()==0 && department.getDname()==null && department.getLocation()==null) {
			return this.ERROR;
		}
		this.service.editDepartment(this.department);
		return this.SUCCESS;
	}


}
