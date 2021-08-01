package com.techlab.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techlab.model.BankTransaction;
import com.techlab.services.CsvFileCreatorService;

@WebServlet("/export")
public class ExportPassbookController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public ExportPassbookController() 
    {
    	System.out.println("created export");
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println(" get export");
        response.setHeader("Content-disposition", "passbook");
        HttpSession session = request.getSession();
        List<BankTransaction> transactions = (List<BankTransaction>) session.getAttribute("transactions");
        CsvFileCreatorService fileCreator = new CsvFileCreatorService();
        File file = fileCreator.createFile(transactions);
        MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
        String path = file.getAbsolutePath();
        System.out.println(path);
        String mimeType = mimeTypesMap.getContentType(file.getName());
        response.setContentType(mimeType);
        OutputStream out = response.getOutputStream();
        FileInputStream in = new FileInputStream(path);
        byte[] buffer = new byte[4096];
        int length;
        while ((length = in.read(buffer)) > 0) {
            out.write(buffer, 0, length);
        }
        in.close();
        out.flush();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
