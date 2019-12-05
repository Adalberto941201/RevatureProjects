package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.ERS_USERS_DAO_IMPL;
import com.pega.models.ERS_USERS;

public class LoginController {

	public static String Login(HttpServletRequest req) {
		String name = req.getParameter("username");
		String type = req.getParameter("password");
		ERS_USERS_DAO_IMPL p = new ERS_USERS_DAO_IMPL();
		ERS_USERS em = new ERS_USERS();
		em = p.selectByUsername(name);
		
		if (name.equals(em.getERS_USERNAME()) && type.equals(em.getERS_PASSWORD())) {
			if(em.getUSER_ROLE_ID_FK() == 1) {
				req.getSession().setAttribute("user", em);
				return "/DashboardE.html";				
			}
			else {
				req.getSession().setAttribute("user", em);
				return "/DashboardS.html";
			}
	}
		return "invalidLogin";
	}
}
