package com.techlabs.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.techlabs.models.Student;

@Repository
public class StudentRepository {

	private List<Student> StudentList;

	private Connection con = null;

	public boolean addStudent(Student student) {
		boolean isStudentAdded = false;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?"+"user=root&password=root");
			con.setAutoCommit(false);

			PreparedStatement stmt = con.prepareStatement("INSERT INTO student_info VALUES(?,?,?,?,?)");
			stmt.setString(1, student.getId());
			stmt.setInt(2, student.getRollNo());
			stmt.setString(3, student.getName());
			stmt.setDouble(4, student.getCgpa());
			stmt.setString(5, student.getLocation());
			int count = stmt.executeUpdate();
			System.out.println("count : " + count);
//			if () {
//				throw new Exception("Add Student Query Failed");
//			}
			con.commit();
			isStudentAdded = true;
			System.out.println("Added Student Successfully");

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return isStudentAdded;
	}

	public boolean editStudent(Student student) {
		boolean isStudentUpdated = false;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?"+"user=root&password=root");
			con.setAutoCommit(false);

			PreparedStatement stmt = con
					.prepareStatement("UPDATE student_info SET name = ?,roll_no = ?,cgpa=?,location=?  WHERE id = ?");
			stmt.setString(1, student.getName());
			stmt.setInt(2, student.getRollNo());
			stmt.setDouble(3, student.getCgpa());
			stmt.setString(4, student.getLocation());
			stmt.setString(5, student.getId());
			int count = stmt.executeUpdate();
			System.out.println("update : " + count);
			if (count == 0) {
				throw new Exception("Edit Student Query Failed");
			}
			con.commit();
			isStudentUpdated = true;
			System.out.println("Edited Student Successfully");

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return isStudentUpdated;
	}

	public List<Student> getStudents() {
		StudentList = new ArrayList<Student>();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?"+"user=root&password=root");
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from student_info ORDER BY name");
			while (rs.next()) {
				Student student = new Student(rs.getString(3), rs.getInt(2), rs.getDouble(4), rs.getString(5));
				student.setId(rs.getString(1));
				StudentList.add(student);
			}

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return StudentList;
	}

	public boolean deleteStudent(String id) {
		boolean isdeletedStudent = false;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?"+"user=root&password=root");
			con.setAutoCommit(false);

			PreparedStatement stmt = con.prepareStatement("DELETE FROM student_info WHERE id = ?");
			stmt.setString(1, id);

			if (stmt.executeUpdate() == 0) {
				throw new Exception("Edit Student Query Failed");
			}
			con.commit();
			isdeletedStudent = true;
			System.out.println("Edited Student Successfully");

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return isdeletedStudent;
	}

	public Student getStudent(String id) {
		Student student = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?"+"user=root&password=root");

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM student_info WHERE id = ?");
			stmt.setString(1, id);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				student = new Student(rs.getString(3), rs.getInt(2), rs.getDouble(4), rs.getString(5));
				student.setId(rs.getString(1));
			} else {
				System.out.println("No Student found with id: " + id);
			}

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return student;
	}

}
