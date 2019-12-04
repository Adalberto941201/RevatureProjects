package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.ERS_USERS_DAO_IMPL;
import com.pega.models.ERS_USERS;

public class RegisterController {

	public static String Register(HttpServletRequest request) {
		/* Unique attributes */

		String userN = request.getParameter("username");
		String email = request.getParameter("email");

		int id = 7;
		String password = request.getParameter("password");
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");

		int roleId;
		System.out.println(request.getParameter("userRole"));
		if (request.getParameter("userRole").equals("Employee")) {
			roleId = 1;
		} else {
			roleId = 2;
		}

		ERS_USERS em = new ERS_USERS(id, userN, password, fName, lName, email, roleId);
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
