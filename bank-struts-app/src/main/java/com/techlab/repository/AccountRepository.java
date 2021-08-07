package com.techlab.repository;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.techlab.model.BankMaster;
import com.techlab.model.BankTransaction;

public class AccountRepository {
	private Connection con;
	
	public AccountRepository()  {
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				try {
					con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?"+"user=root&password=root");
					System.out.println("You are now connected to bank DB");
				} catch (SQLException e) {
					System.out.println("Connection failed...");
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				System.out.println("Connection failed...");
				e.printStackTrace();
			}
			
			
		
	}
	
	public void insertBankMaster(BankMaster account) {
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement("INSERT INTO BANK_MASTER VALUES(?,?,PASSWORD(?));");
			ps.setString(1, account.getName());
			ps.setDouble(2, account.getBalance());
			ps.setString(3, account.getPassword());
			System.out.println("Account : "+account);
			int ans=ps.executeUpdate();
			if(ans>0)
				System.out.println("Account inserted in BANK_MASTER");
		} catch (SQLException e) {
			System.out.println("Insertion not done");
			e.printStackTrace();
		}
		
	}
	
	public void insertBankTransaction(BankTransaction account) {
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement("INSERT INTO BANK_TRANSACTION VALUES(?,?,?,CURRENT_TIMESTAMP());");
			ps.setString(1, account.getName());
			ps.setDouble(2, account.getAmount());
			ps.setString(3, account.getType());
			System.out.println("Account = "+account.getName());
			int ans=ps.executeUpdate();
			if(ans>0)
				System.out.println("Account inserted in BANK_MASTER");
		} catch (SQLException e) {
			System.out.println("Insertion not done");
			e.printStackTrace();
		}
		
	}
	
	public List<BankTransaction> getTransactions(String name) 
	{
		List<BankTransaction> transactions=new ArrayList<BankTransaction>();
		
		Statement stmt;
		try {
			
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("SELECT * FROM BANK_TRANSACTION WHERE NAME=?;");
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
						
			System.out.println("Displaying transactions : ");
			BankTransaction transaction;
			while (rs.next()) {
//				transaction = new BankTransaction(rs.getString("NAME"),rs.getInt("AMOUNT"),rs.getString("TYPE"));
				transaction=new BankTransaction();
				transaction.setName(rs.getString("NAME"));
				transaction.setAmount(rs.getDouble("AMOUNT"));
				transaction.setType(rs.getString("TYPE"));
				transactions.add(transaction);
			}
			System.out.println(transactions);
			return transactions;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transactions;
		
		
	}
	
	public void updateBankMasterOnDeposit(BankMaster bankMaster) {
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement("UPDATE BANK_MASTER SET BALANCE=BALANCE+? WHERE NAME=?;");
			ps.setDouble(1, bankMaster.getBalance());
			ps.setString(2, bankMaster.getName());
			int ans=ps.executeUpdate();
			if(ans>0) {
				System.out.println("Bank_Master updated successfully on Deposit");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateBankMasterOnWithdraw(BankMaster bankMaster) {
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement("UPDATE BANK_MASTER SET BALANCE=BALANCE-? WHERE NAME=?;");
			ps.setDouble(1, bankMaster.getBalance());
			ps.setString(2, bankMaster.getName());
			int ans=ps.executeUpdate();
			if(ans>0) {
				System.out.println("Bank_Master updated successfully on Deposit");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public double getBalance(String name) {
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement("SELECT BALANCE FROM BANK_MASTER WHERE NAME=?;");
			ps.setString(1, name);
			ps.executeUpdate();
			ResultSet rs=ps.executeQuery();
			System.out.println("Displaying balance of "+name+" : ");
			double balance=0.0;
			while (rs.next()) {
				balance=rs.getDouble(1);
			}
			System.out.println(balance);
			return balance;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
public double getAccountBalance(String name) throws SQLException {
		double accountBalance = 0;
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("SELECT BALANCE FROM BANK_MASTER WHERE NAME=?;");
		ps.setString(1, name);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
			accountBalance=rs.getDouble(1);
		System.out.println("Account Balance : "+accountBalance); 

		return accountBalance;
	}
}
