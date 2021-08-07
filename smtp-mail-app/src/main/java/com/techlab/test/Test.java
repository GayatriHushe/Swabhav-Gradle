package com.techlab.test;

import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Test {

	public static void main(String[] args) {
		
		String host="smtp.gmail.com";
		String senderEmail="gayatrihushe@gmail.com";
		String senderPassword="ybttbirvfwtyhggo";
		String receiverEmail="kannan@swabhavtechlabs.com";
		
		Properties properties=new Properties();
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.host", "smtp.gmail.com");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.debug", "true");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.socketFactory.fallback", "false");
		
		Session session=Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication()
			{
				return new javax.mail.PasswordAuthentication(senderEmail, senderPassword);
			}
		});
		
		try
		{
			MimeMessage msg=new MimeMessage(session);
			msg.setFrom(new InternetAddress(senderEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmail));
			msg.setSubject("Mail from SMTP");
			msg.setText("Gayatri");
			
			Transport.send(msg);
			System.out.println("msg delivered");
			
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}

}
