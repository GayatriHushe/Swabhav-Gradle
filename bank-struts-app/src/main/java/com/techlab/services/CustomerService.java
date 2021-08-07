package com.techlab.services;

import java.sql.SQLException;
import java.util.List;

import com.techlab.model.BankMaster;
import com.techlab.model.BankTransaction;
import com.techlab.repository.AccountRepository;

public class CustomerService implements IService{
	private AccountRepository repository=new AccountRepository();

	@Override
	public void insertBankMaster(BankMaster bankMaster) {
		repository.insertBankMaster(bankMaster);
		
	}

	@Override
	public void insertBankTransaction(BankTransaction bankTransaction){
		repository.insertBankTransaction(bankTransaction);		
	}

	@Override
	public List<BankTransaction> getTransactions(String name) {
		List<BankTransaction> transactions=repository.getTransactions(name);
		return transactions;
	}

	@Override
	public void updateBankMasterOnDeposit(BankMaster bankMaster) {
		repository.updateBankMasterOnDeposit(bankMaster);
		
	}

	@Override
	public void updateBankMasterOnWithdraw(BankMaster bankMaster) {
		repository.updateBankMasterOnWithdraw(bankMaster);
		
	}

	@Override
	public double getBalance(String name) {
		double bal=repository.getBalance(name);
		return bal;
	}

	@Override
	public double getAccountBalance(String name) throws SQLException {
		double bal=repository.getAccountBalance(name);
		return bal;
	}

}
