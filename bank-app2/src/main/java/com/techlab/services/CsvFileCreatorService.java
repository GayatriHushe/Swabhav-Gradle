package com.techlab.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.techlab.model.BankTransaction;

public class CsvFileCreatorService 
{
	public File createFile(List<BankTransaction> transactions)
	{
		try 
		{
			String name = "C:\\Users\\shobha\\Downloads\\Server\\" 
							+ transactions.get(0).getName() + "-" + transactions.size() + ".csv";
			File file = new File(name);
			if(file.createNewFile())
			{
				BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
				writer.write("Amount, Type, Date \n");
				for (BankTransaction transaction : transactions)
				{
					writer.write(transaction.getAmount() + "," + transaction.getType() + "\n");
				}
				writer.close();
			}
			return file;
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			return null;
		}
	}
}
