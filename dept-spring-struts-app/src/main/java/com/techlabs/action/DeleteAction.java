package com.techlabs.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlabs.service.DepartmentService;

public class DeleteAction implements Action{
	private int deptno;
	@Autowired
	private DepartmentService service;

	@Override
	public String execute() throws Exception {
		System.out.println(this.deptno);
		service.deleteDepartment(deptno);
		return this.SUCCESS;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

}
