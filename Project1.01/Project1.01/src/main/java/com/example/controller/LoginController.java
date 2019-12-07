package com.example.controller;

import javax.crypto.Cipher;
import javax.servlet.http.HttpServletRequest;

import com.example.dao.ERS_USERS_DAO_IMPL;
import com.example.main.pEncryption;
import com.pega.models.ERS_USERS;

public class LoginController {

	public static String Login(HttpServletRequest req) {
		String name = req.getParameter("username");
		String type = req.getParameter("password");
		ERS_USERS_DAO_IMPL p = new ERS_USERS_DAO_IMPL();
		ERS_USERS em = new ERS_USERS();
		em = p.selectByUsername(name);
		String passCheck = "";
		try {
			pEncryption.dcipher = Cipher.getInstance("DES");

			pEncryption.dcipher.init(Cipher.DECRYPT_MODE, pEncryption.key);
			System.out.println("this is password before decyption" + em.getERS_PASSWORD());
			passCheck = pEncryption.decrypt(em.getERS_PASSWORD());
			System.out.println("this is password after encyption" + passCheck);
			em.setERS_PASSWORD(passCheck);
		} catch (Exception e) {
			System.out.println("issue with password encryption");
			e.printStackTrace();
		}
		
		System.out.println(passCheck);
		if (name.equals(em.getERS_USERNAME()) && type.equals(passCheck)) {
			if (em.getUSER_ROLE_ID_FK() == 1) {
				req.getSession().setAttribute("user", em);
				return "/DashboardE.html";
			} else {
				req.getSession().setAttribute("user", em);
				return "/DashboardS.html";
			}
		}
		return "invalidLogin";
	}
}
