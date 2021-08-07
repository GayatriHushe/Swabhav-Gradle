package com.techlab.repository;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.techlab.model.BankMaster;
import com.techlab.model.BankTransaction;

@Repository
public class AccountRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;	
	
	
//	private Connection con;
//	
//	public AccountRepository()  {
//		
//			try {
//				Class.forName("com.mysql.jdbc.Driver");
//				try {
//					con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?"+"user=root&password=root");
//					System.out.println("You are now connected to bank DB");
//				} catch (SQLException e) {
//					System.out.println("Connection failed...");
//					e.printStackTrace();
//				}
//			} catch (ClassNotFoundException e) {
//				System.out.println("Connection failed...");
//				e.printStackTrace();
//			}
//	}
	
	
	public void insertBankMaster(BankMaster bankMaster) {
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		session.save(bankMaster);
		transaction.commit();
		session.close();
	}
	
//	public void insertBankMaster(BankMaster account) {
//		PreparedStatement ps;
//		try {
//			ps = (PreparedStatement) con.prepareStatement("INSERT INTO BANK_MASTER VALUES(?,?,PASSWORD(?));");
//			ps.setString(1, account.getName());
//			ps.setDouble(2, account.getBalance());
//			ps.setString(3, account.getPassword());
//			System.out.println("Account : "+account);
//			int ans=ps.executeUpdate();
//			if(ans>0)
//				System.out.println("Account inserted in BANK_MASTER");
//		} catch (SQLException e) {
//			System.out.println("Insertion not done");
//			e.printStackTrace();
//		}
//		
//	}
	
	
	public void insertBankTransaction(BankTransaction account) 
	{
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		session.save(account);
		transaction.commit();
		session.close();
	}
	
	
//	public void insertBankTransaction(BankTransaction account) {
//		PreparedStatement ps;
//		try {
//			ps = (PreparedStatement) con.prepareStatement("INSERT INTO BANK_TRANSACTION VALUES(?,?,?,CURRENT_TIMESTAMP());");
//			ps.setString(1, account.getName());
//			ps.setDouble(2, account.getAmount());
//			ps.setString(3, account.getType());
//			System.out.println("Account = "+account.getName());
//			int ans=ps.executeUpdate();
//			if(ans>0)
//				System.out.println("Account inserted in BANK_MASTER");
//		} catch (SQLException e) {
//			System.out.println("Insertion not done");
//			e.printStackTrace();
//		}
//		
//	}
	
//	public List<BankTransaction> getTransactions(String name) 
//	{
//		List<BankTransaction> transactions=new ArrayList<BankTransaction>();
//		
//		Statement stmt;
//		try {
//			
//			PreparedStatement ps=(PreparedStatement) con.prepareStatement("SELECT * FROM BANK_TRANSACTION WHERE NAME=?;");
//			ps.setString(1, name);
//			ResultSet rs=ps.executeQuery();
//						
//			System.out.println("Displaying transactions : ");
//			BankTransaction transaction;
//			while (rs.next()) {
////				transaction = new BankTransaction(rs.getString("NAME"),rs.getInt("AMOUNT"),rs.getString("TYPE"));
//				transaction=new BankTransaction();
//				transaction.setName(rs.getString("NAME"));
//				transaction.setAmount(rs.getDouble("AMOUNT"));
//				transaction.setType(rs.getString("TYPE"));
//				transactions.add(transaction);
//			}
//			System.out.println(transactions);
//			return transactions;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return transactions;
//	}
	
	
	public List<BankTransaction> getTransactions(String name) 
	{
		session=sessionFactory.openSession();
		Query query=session.createQuery("from BankTransaction where name=:n");
		query.setParameter("n",name);
		
		List<BankTransaction> transactionsRaw=query.list();
		List<BankTransaction> transactions=new ArrayList<BankTransaction>(transactionsRaw.size());
		
		for(Object o:transactionsRaw)
		{
			transactions.add((BankTransaction) o);
		}
		System.out.println(transactions);
		return transactions;
	}
	
//	public void updateBankMasterOnDeposit(BankMaster bankMaster) {
//		PreparedStatement ps;
//		try {
//			ps = (PreparedStatement) con.prepareStatement("UPDATE BANK_MASTER SET BALANCE=BALANCE+? WHERE NAME=?;");
//			ps.setDouble(1, bankMaster.getBalance());
//			ps.setString(2, bankMaster.getName());
//			int ans=ps.executeUpdate();
//			if(ans>0) {
//				System.out.println("Bank_Master updated successfully on Deposit");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	public void updateBankMasterOnDeposit(BankMaster bankMaster) {
		System.out.println("master update");
//		Session session=(Session) ServletActionContext.getRequest().getSession();
		String name=(String)((HttpSession) session).getAttribute("accountHolderName");
		session= sessionFactory.openSession();
		transaction=session.beginTransaction();
		Query query= session.createQuery("update BankMaster set balance=balance+ :a where name=:n");
		query.setParameter("a", bankMaster.getBalance());
		query.setParameter("n", name);
		int result=query.executeUpdate();
		System.out.println(result);
		session.saveOrUpdate(bankMaster);
//		
		transaction.commit();
		
		
		
		
//		HttpSession session1=ServletActionContext.getRequest().getSession();
//		String name=(String)session1.getAttribute("Admin");
//		session=sessionFactory.openSession();
//		transaction=session.beginTransaction();
//		Query query=session.createQuery("update AccountHolder set balance= balance + :a where name=:n");
//		query.setParameter("a", trans.getAmount());
//		query.setParameter("n", name);
//		int status=query.executeUpdate();
//		System.out.println(status);
//		transaction.commit();
	}
	
//	public void updateBankMasterOnWithdraw(BankMaster bankMaster) {
//		PreparedStatement ps;
//		try {
//			ps = (PreparedStatement) con.prepareStatement("UPDATE BANK_MASTER SET BALANCE=BALANCE-? WHERE NAME=?;");
//			ps.setDouble(1, bankMaster.getBalance());
//			ps.setString(2, bankMaster.getName());
//			int ans=ps.executeUpdate();
//			if(ans>0) {
//				System.out.println("Bank_Master updated successfully on Deposit");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	
	public void updateBankMasterOnWithdraw(BankMaster bankMaster) {
		Session session=(Session) ServletActionContext.getRequest().getSession();
		String name=(String)((HttpSession) session).getAttribute("accountHolderName");
		session= sessionFactory.openSession();
		transaction=session.beginTransaction();
		Query query= (session).createQuery("update BankMaster set balance=balance- :a where name=:n");
		query.setParameter("a", bankMaster.getBalance());
		query.setParameter("n", name);
		int result=query.executeUpdate();
		System.out.println(result);
		transaction.commit();
		
	}
	
//	public double getBalance(String name) {
//		PreparedStatement ps;
//		try {
//			ps = (PreparedStatement) con.prepareStatement("SELECT BALANCE FROM BANK_MASTER WHERE NAME=?;");
//			ps.setString(1, name);
//			ps.executeUpdate();
//			ResultSet rs=ps.executeQuery();
//			System.out.println("Displaying balance of "+name+" : ");
//			double balance=0.0;
//			while (rs.next()) {
//				balance=rs.getDouble(1);
//			}
//			System.out.println(balance);
//			return balance;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return 0;
//		
//	}
	
	
	public double getBalance(String name) {
		
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		Query query=session.createQuery("from BankMaster where name=:n");
		query.setParameter("n", name);
		BankMaster bankMaster=(BankMaster) (query).uniqueResult();
		System.out.println(bankMaster.getName());
		double bal=bankMaster.getBalance();
		System.out.println(bal);
		return bal;
		
	}
	
//	public double getAccountBalance(String name) throws SQLException {
//		double accountBalance = 0;
//		PreparedStatement ps=(PreparedStatement) con.prepareStatement("SELECT BALANCE FROM BANK_MASTER WHERE NAME=?;");
//		ps.setString(1, name);
//		ResultSet rs=ps.executeQuery();
//		while(rs.next())
//			accountBalance=rs.getDouble(1);
//		System.out.println("Account Balance : "+accountBalance); 
//
//		return accountBalance;
//	}
	
	public double getAccountBalance(String name) throws SQLException {
//		session=sessionFactory.openSession();
//		transaction=session.beginTransaction();
//		Query query=session.createQuery("from BankMaster where name=:n");
//		query.setParameter("n", name);
//		BankMaster bankMaster=(BankMaster) (query).uniqueResult();
//		System.out.println(bankMaster.getName());
//		double bal=bankMaster.getBalance();
//		System.out.println(bal);
//		return bal;
		
		
		session=sessionFactory.openSession();
		Query query=session.createQuery("select balance from BankMaster where name=:n");
		query.setParameter("n", name);
		double balance = (double) (query.uniqueResult());
		System.out.println(balance);
		return balance;
	}
}
