package com.example.main;

import java.util.Properties;
import java.util.Random;

import javax.mail.Session;
import javax.mail.Transport;

import java.util.*;
import javax.activation.*;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Email {
	public static Random r = new Random();
	public static int tempPass;
	public static Properties prop = new Properties();
	public static final String sub = "Pega Reimbursment System Temporary Password";
	public static String emailTo;
	public static final String emailFrom = "larsonsadie@hotmail.com";
	
	public static Session sess = Session.getInstance(prop, new Authenticator() {
	    @Override
	    protected PasswordAuthentication getPasswordAuthentication() {
	        return new PasswordAuthentication("larsonsadie@hotmail.com", "adoption99");
	    }
	});
	public static void sendTempPass() {
		tempPass = r.nextInt(10000);
		emailTo = "larsonsadie@ucla.edu";

		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.live.com");
		prop.put("mail.smtp.port", "25");
		prop.put("mail.smtp.ssl.trust", "smtp.live.com");
	
		try {
			Message message = new MimeMessage(sess);

			message.setFrom(new InternetAddress(emailFrom));

			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
			message.setSubject(sub);
			String msg = "Your temporary password is: " + tempPass + "Log in at the following link http://localhost:9001/Project1Sadie/Login.html";
			msg += "\n If you have any questions please contact us at our help line: (800) 555-5555";

			MimeBodyPart mbp = new MimeBodyPart();
			System.out.println(msg);
			mbp.setContent(msg, "text/html");

			MimeMultipart mp = new MimeMultipart();
			mp.addBodyPart(mbp);
			message.setContent(mp);
			Transport.send(message);
			System.out.println("success sending");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
