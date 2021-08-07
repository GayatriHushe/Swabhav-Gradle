package com.techlabs.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mysql.jdbc.PreparedStatement;
import com.techlabs.model.Department;

@Repository
public class DepartmentRepository {
	
		private Connection con;
		public DepartmentRepository() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/department?" +
						 "user=root&password=root");
				System.out.println("connection succesull");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	
		}
		public List<Department> getDbList() throws ClassNotFoundException, SQLException{
			List<Department> departmentList=new ArrayList<Department>();
			
			Statement stmt = (Statement) con.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT DEPTNO,DNAME,LOCATION FROM DEPARTMENT");
	        
	        while(rs.next()) {
	        	Department department=new Department(rs.getInt("DEPTNO"),rs.getString("DNAME"),rs.getString("LOCATION"));
	        	departmentList.add(department);
	        }
			return departmentList;
		}
		public void addToDb(Department department) throws SQLException {
			String sql="INSERT INTO DEPARTMENT (DEPTNO,DNAME,LOCATION) VALUES(?,?,?)";
			PreparedStatement statement=(PreparedStatement) con.prepareStatement(sql);
			
			statement.setInt(1, department.getDeptno());
			statement.setString(2, department.getDname());
			statement.setString(3, department.getLocation());
			
			int result=statement.executeUpdate();
			if(result>0) {
				System.out.println("Row Inserted");
			}
		}
		public void editToDb(Department department) throws SQLException {
			String sql="UPDATE DEPARTMENT SET DNAME=?,LOCATION=? WHERE DEPTNO=?";
			PreparedStatement statement=(PreparedStatement) con.prepareStatement(sql);
			statement.setString(1, department.getDname());
			statement.setString(2, department.getLocation());
			statement.setInt(3, department.getDeptno());
			System.out.println(department.getDeptno());
			System.out.println(department.getDname());
			int result=statement.executeUpdate();
			if(result>0) {
				System.out.println("Row Inserted");
			}
		}
		public void deleteFromDb(int deptno) throws SQLException {
			String sql="DELETE FROM DEPARTMENT WHERE DEPTNO="+deptno+";";
			PreparedStatement statement=(PreparedStatement) con.prepareStatement(sql);
			
			int result=statement.executeUpdate();
			if(result>0) {
				System.out.println("Row Deleted");
			}
			
		}
}
