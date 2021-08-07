package com.techlab.services;

import java.sql.SQLException;
import java.util.List;

import com.techlab.model.BankMaster;
import com.techlab.model.BankTransaction;

public interface IService {
	public void insertBankMaster(BankMaster bankMaster);
	public void insertBankTransaction(BankTransaction bankTransaction);
	public List<BankTransaction> getTransactions(String name) ;
	public void updateBankMasterOnDeposit(BankMaster bankMaster);
	public void updateBankMasterOnWithdraw(BankMaster bankMaster);
	public double getBalance(String name) ;
	public double getAccountBalance(String name) throws SQLException ;
}
