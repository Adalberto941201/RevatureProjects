package com.example.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.example.dao.ERS_USERS_DAO_IMPL;
import com.pega.models.ERS_USERS;

public class LoginController {
	public final static Logger loggy = Logger.getLogger(LoginController.class);

	public static String Login(HttpServletRequest req) {
		String name = req.getParameter("username");
		String type = req.getParameter("password");
		ERS_USERS_DAO_IMPL p = new ERS_USERS_DAO_IMPL();
		ERS_USERS em = new ERS_USERS();
		em = p.selectByUsername(name);
//		String passCheck = "";
//		try {
//			pEncryption.dcipher = Cipher.getInstance("DES");
//
//			pEncryption.dcipher.init(Cipher.DECRYPT_MODE, pEncryption.key);
//			System.out.println("this is password before decyption" + em.getERS_PASSWORD());
//			passCheck = pEncryption.decrypt(em.getERS_PASSWORD());
//			System.out.println("this is password after encyption" + passCheck);
//			em.setERS_PASSWORD(passCheck);
//		} catch (NoSuchAlgorithmException e) {
//			System.out.println("No Such Algorithm:" + e.getMessage());
//		} catch (NoSuchPaddingException e) {
//			System.out.println("No Such Padding:" + e.getMessage());
//		} catch (Exception e) {
//			System.out.println("issue with password encryption");
//			e.printStackTrace();
//		}
		
//		System.out.println(passCheck);
//		if (name.equals(em.getERS_USERNAME()) && type.equals(passCheck)) {
		System.out.println("password check" + em.getERS_PASSWORD());
		if (name.equals(em.getERS_USERNAME()) && type.equals(em.getERS_PASSWORD())) {
			if (em.getUSER_ROLE_ID_FK() == 1) {
				req.getSession().setAttribute("user", em);
				loggy.info(em.getERS_USERNAME() + " Logged in");
				return "/DashboardE.html";
			} else {
				req.getSession().setAttribute("user", em);
				loggy.info(em.getERS_USERNAME() + " Logged in");
				return "/DashboardS.html";
			}
		}
		loggy.info("An Attempt to login was made with the credentials: username-" + name + " password-" + type);
		return "invalidLogin";
	}
	public static String logout(HttpServletRequest req) {
	   HttpSession session = req.getSession();
		if(session.isNew()) {
			session.invalidate();
			session =req.getSession();
		}
		return "/Login.html";
	}
}
