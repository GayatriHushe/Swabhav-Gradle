package com.techlab.repository;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.techlab.model.BankMaster;
import com.techlab.model.Customer;
import com.techlab.services.Encryption;

@Repository
public class CustomerRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	
//	private Connection con;
//	private double accountBalance;
//	public CustomerRepository() throws SQLException {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?user=root&password=root");
//			System.out.println("You are now connected to customer");
//		} catch (ClassNotFoundException e) {
//			System.out.println("Connection failed");
//			e.printStackTrace();
//		}
//
//	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public boolean isCustomer(Customer customer) throws SQLException {

		String name=customer.getUsername();
		String password= customer.getPassword();
		System.out.println("Pass : "+customer.getPassword());
		System.out.println("Encrypted : "+password);
		System.out.println("Customer : "+customer.getUsername());
		// name id?
		System.out.println(sessionFactory);
		Session session = sessionFactory.openSession();
	    BankMaster customer1 = (BankMaster) session.get(BankMaster.class, name);//no need
	    session.close();
	    System.out.println("customer 1 pass : " + customer1.getPassword());
	    if (customer1 != null && customer1.getPassword().equals(password))
	    {
	      return true;
	    }
	    return false;
//		Session session=sessionFactory.openSession();
//	    transaction=session.beginTransaction();
		
//		if(customer !=null && customer.getPassword().equals(password))
//			return true;
//		return false;
		
//	    Query query=session.createQuery("from BankMaster where name=:usern and password=:pass");//ithe error yetoy jo
//	    query.setParameter("usern", name);
//	    query.setParameter("pass", password);
//	    BankMaster bankMaster=(BankMaster)(query).uniqueResult();
//	    if(bankMaster!=null) {
//	    	return true;
//	    }
//	    session.close();
//	    return false;
	    
	}

//	public String getHash(String password) throws SQLException {
//		String hashedPassword = null;
//		Statement stmt= (Statement) con.createStatement();
//		ResultSet rs=stmt.executeQuery("SELECT PASSWORD FROM BANK_MASTER WHERE PASSWORD=PASSWORD('"+password+"');");
//		while(rs.next())
//			hashedPassword=rs.getString("PASSWORD");
//		System.out.println("hashedpass : "+hashedPassword);
//		return hashedPassword;
//	}
	
	
//	public String getHash(String password) throws SQLException {
//		
//		
//		String hashedPassword = null;
//		hashedPassword=Encryption.encrypt(password);
//		System.out.println("hashedpass : "+hashedPassword);
//		return hashedPassword;
//	}
//	
//	
//	
//
	public double getAccountBalance(String name) throws SQLException {
		
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		Query query=(Query) session.createQuery("from BankMaster where name=:n");
		query.setParameter("n", name);
		BankMaster bankMaster=(BankMaster) ((org.hibernate.Query) query).uniqueResult();
		System.out.println(bankMaster.getName());
		double bal=bankMaster.getBalance();
		System.out.println(bal);
		return bal;
	}
}
