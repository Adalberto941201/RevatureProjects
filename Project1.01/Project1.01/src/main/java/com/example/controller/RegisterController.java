package com.example.controller;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.example.dao.ERS_USERS_DAO_IMPL;
import com.example.main.Email;
import com.example.main.pEncryption;
import com.pega.models.ERS_USERS;

public class RegisterController {
	public final static Logger loggy = Logger.getLogger(RegisterController.class);

	public static String Register(HttpServletRequest request) {
		/* Unique attributes */
		String userN = request.getParameter("username");
		String email = request.getParameter("email");
		int id = 7;
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");

		int roleId;
		System.out.println(request.getParameter("userRole"));
		if (request.getParameter("userRole").equals("Employee")) {
			roleId = 1;
		} else {
			roleId = 2;
		}
		String password = "";

		ERS_USERS em = new ERS_USERS(id, userN, password, fName, lName, email, roleId);
		password = Email.sendTempPass(em.getUSER_FIRST_NAME(), em.getUSER_LAST_NAME(), em.getUSER_EMAIL());
		em.setERS_PASSWORD(password);
//		try {
//			pEncryption.ecipher = Cipher.getInstance("DES");
//
//			pEncryption.ecipher.init(Cipher.ENCRYPT_MODE, pEncryption.key);
//			password = Email.sendTempPass(em.getUSER_FIRST_NAME(), em.getUSER_LAST_NAME(), em.getUSER_EMAIL());
//			System.out.println("this is password before encyption" + password);
//			password = pEncryption.encrypt(password);
//			em.setERS_PASSWORD(password);
//			System.out.println("this is password after encyption" + password);
//		} catch (NoSuchAlgorithmException e) {
//			System.out.println("No Such Algorithm:" + e.getMessage());
//		} catch (NoSuchPaddingException e) {
//			System.out.println("No Such Padding:" + e.getMessage());
//		} catch (Exception e) {
//			System.out.println("issue with password encryption");
//			e.printStackTrace();
//		}
//
		ERS_USERS_DAO_IMPL d = new ERS_USERS_DAO_IMPL();
		System.out.println(d.isUsernameUnique(userN));
		if (d.isUsernameUnique(userN)) {
			d.insertUser(em);
			System.out.println(em);
			loggy.info(em.getERS_USERNAME() + " Created an account");
			return "/Login.html";
		} else {
			loggy.info("An account with an already existing username was attempted to register");
			return "invalid"; // was not unique re-register
		}
	}
}
