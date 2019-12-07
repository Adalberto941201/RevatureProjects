package com.example.controller;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.servlet.http.HttpServletRequest;

import com.example.dao.ERS_USERS_DAO_IMPL;
import com.example.main.Email;
import com.example.main.pEncryption;
import com.pega.models.ERS_USERS;

public class ProfileController {

	public static String Update(HttpServletRequest request) {
		System.out.println("entered profile controller");
		ERS_USERS em2 = (ERS_USERS) request.getSession().getAttribute("user");
		if (em2 == null) {
			String name = request.getParameter("username");
			String type = request.getParameter("OldPassword");
			ERS_USERS_DAO_IMPL p = new ERS_USERS_DAO_IMPL();
			ERS_USERS em1 = new ERS_USERS();
			em1 = p.selectByUsername(name);
			System.out.println(name);
			System.out.println(em1.getERS_USERNAME());
			System.out.println(type);
			String passCheck = "";
			try {
				pEncryption.ecipher = Cipher.getInstance("DES");

				pEncryption.ecipher.init(Cipher.DECRYPT_MODE, pEncryption.key);
				System.out.println("this is password before encryption" + em1.getERS_PASSWORD());
				passCheck = pEncryption.encrypt(em1.getERS_PASSWORD());
				System.out.println("this is password after encyption" + passCheck);
			} catch (Exception e) {
				System.out.println("issue with password encryption");
				e.printStackTrace();
			}
			System.out.println(passCheck);

			if (name.equals(em1.getERS_USERNAME()) && type.equals(passCheck)) {
				request.getSession().setAttribute("user", em1);
			} else {
				return "/PasswordSetup.html";
			}
			ERS_USERS em = (ERS_USERS) request.getSession().getAttribute("user");
			System.out.println(em.toString());
			if (request.getParameter("password") != null) {
				System.out.println("This is password change" + request.getParameter("password"));
				String pass = request.getParameter("password");
				String password = "";
				try {
					pEncryption.ecipher = Cipher.getInstance("DES");

					pEncryption.ecipher.init(Cipher.ENCRYPT_MODE, pEncryption.key);
					password = Email.sendTempPass(em.getUSER_FIRST_NAME(), em.getUSER_LAST_NAME(), em.getUSER_EMAIL());
					System.out.println("this is password before encyption" + password);
					password = pEncryption.encrypt(password);
					em.setERS_PASSWORD(password);
					System.out.println("this is password after encyption" + password);
				} catch (Exception e) {
					System.out.println("issue with password encryption");
					e.printStackTrace();
				}
				em.setERS_PASSWORD(password);
			} else {
				return "/PasswordSetup.html";
			}

			System.out.println("after pulling and looking for dao " + em);
			ERS_USERS_DAO_IMPL d = new ERS_USERS_DAO_IMPL();
			d.updateUser(em);
			request.getSession().setAttribute("user", em);
			System.out.println("in proile controller at end");
			if (em.getUSER_ROLE_ID_FK() == 1) {
				System.out.println("hello in profile controller em");
				return "/DashboardE.html";
			} else {
				System.out.println("hello in profile controller fm");
				return "/DashboardS.html";
			}

		}
		ERS_USERS em = (ERS_USERS) request.getSession().getAttribute("user");
		System.out.println(em.toString());
		if (request.getParameter("password") != null) {
			System.out.println("This is password change" + request.getParameter("password"));
			String pass = request.getParameter("password");
			em.setERS_PASSWORD(pass);
		} else if (request.getParameter("fName") != null) {
			System.out.println("This is fName change" + request.getParameter("fName"));
			String fName = request.getParameter("fName");
			em.setUSER_FIRST_NAME(fName);
		} else if (request.getParameter("lName") != null) {
			System.out.println("This is last naem change" + request.getParameter("lName"));
			String lName = request.getParameter("lName");
			em.setUSER_LAST_NAME(lName);
		} else if (request.getParameter("email") != null) {
			System.out.println("This is email change" + request.getParameter("email"));
			String email = request.getParameter("email");
			em.setUSER_EMAIL(email);
		}

		System.out.println("after pulling and looking for dao " + em);
		ERS_USERS_DAO_IMPL d = new ERS_USERS_DAO_IMPL();
		d.updateUser(em);
		request.getSession().setAttribute("user", em);
		System.out.println("in proile controller at end");
		if (em.getUSER_ROLE_ID_FK() == 1) {
			System.out.println("hello in profile controller em");
			return "/InfoE.html";
		} else {
			System.out.println("hello in profile controller fm");
			return "/InfoSP.html";
		}
	}
}
