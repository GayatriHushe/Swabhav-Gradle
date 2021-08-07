package com.techlabs.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.model.Department;
import com.techlabs.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository repo;
	
	public DepartmentService() {
		System.out.println("Service created");
	}
	public List<Department> getList() throws ClassNotFoundException, SQLException{
		return repo.getDbList();
	}
	public void addDepartment(Department department) throws SQLException {
		repo.addToDb(department);
	}
	public void editDepartment(Department department) throws SQLException {
		repo.editToDb(department);
	}
	public void deleteDepartment(int deptno) throws SQLException {
		repo.deleteFromDb(deptno);
	}
}
