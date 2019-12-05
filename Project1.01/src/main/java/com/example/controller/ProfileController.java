package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.ERS_USERS_DAO_IMPL;
import com.pega.models.ERS_USERS;

public class ProfileController {

	public static String Update(HttpServletRequest request) {
		System.out.println("entered profile controller");
		ERS_USERS em = (ERS_USERS) request.getSession().getAttribute("user");
		System.out.println(em.toString());
		if (request.getParameter("password")!= null) {
			System.out.println("This is password change" + request.getParameter("password"));
			String pass = request.getParameter("password");
			em.setERS_PASSWORD(pass);
		} else if (request.getParameter("fName")!=null) {
			System.out.println("This is fName change" + request.getParameter("fName"));
			String fName = request.getParameter("fName");
			em.setUSER_FIRST_NAME(fName);
		} else if (request.getParameter("lName")!= null) {
			System.out.println("This is last naem change" + request.getParameter("lName"));
			String lName = request.getParameter("lName");
			em.setUSER_LAST_NAME(lName);
		} else if (request.getParameter("email")!=null) {
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
			return "/InfoS.html";
		}
	}
}
