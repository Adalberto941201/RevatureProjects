package com.example.controller;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.servlet.http.HttpServletRequest;

import com.example.dao.ERS_USERS_DAO_IMPL;
import com.example.main.Email;
import com.example.main.pEncryption;
import com.pega.models.ERS_USERS;

public class RegisterController {
	
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
		
		
		try {
		pEncryption.ecipher = Cipher.getInstance("DES");

		pEncryption.ecipher.init(Cipher.ENCRYPT_MODE, pEncryption.key);
		password = Email.sendTempPass(em.getUSER_FIRST_NAME(), em.getUSER_LAST_NAME(), em.getUSER_EMAIL());
		System.out.println("this is password before encyption" + password);
		password = pEncryption.encrypt(password);
		em.setERS_PASSWORD(password);
		System.out.println("this is password after encyption" +password);
		} catch(Exception e) {
			System.out.println("issue with password encryption");
			e.printStackTrace();
		}

		ERS_USERS_DAO_IMPL d = new ERS_USERS_DAO_IMPL();
		System.out.println(d.isUsernameUnique(userN));
		if (d.isUsernameUnique(userN)) {
			d.insertUser(em);
			System.out.println(em);
			return "/Login.html";
		} else {
			return "invalid"; // was not unique re-register
		}
	}
}
