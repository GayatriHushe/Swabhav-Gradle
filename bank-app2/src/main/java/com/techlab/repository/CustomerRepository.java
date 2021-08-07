package com.techlab.repository;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.techlab.model.Customer;

public class CustomerRepository {
	private Connection con;
	private double accountBalance;
	public CustomerRepository() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?user=root&password=root");
			System.out.println("You are now connected to customer");
		} catch (ClassNotFoundException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}

	}

	public boolean isCustomer(Customer customer) throws SQLException {

		String name=customer.getUserName();
		String password=customer.getPassword();
		System.out.println("Customer : "+customer);

		String hashedPassword=getHash(password);
		if(hashedPassword!=null)
		{
			Statement stmt= (Statement) con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM BANK_MASTER;");

			while(rs.next())
			{
				if(name.equals(rs.getString("NAME")) && hashedPassword.equals(hashedPassword))
				{
					
					return true;
				}
			}
		}
		return false;

	}

	public String getHash(String password) throws SQLException {
		String hashedPassword = null;
		Statement stmt= (Statement) con.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT PASSWORD FROM BANK_MASTER WHERE PASSWORD=PASSWORD('"+password+"');");
		while(rs.next())
			hashedPassword=rs.getString("PASSWORD");
		System.out.println("hashedpass : "+hashedPassword);
		return hashedPassword;
	}

	public double getAccountBalance(String name) throws SQLException {
		
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("SELECT BALANCE FROM BANK_MASTER WHERE NAME=?;");
		ps.setString(1, name);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
			accountBalance=rs.getDouble("BALANCE");
		System.out.println("Account Balance : "+accountBalance);

		return accountBalance;
	}
}
