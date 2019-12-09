package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.ERS_USERS_DAO_IMPL;
import com.pega.models.ERS_USERS;

public class AccountsController {
	public static String accounts(HttpServletRequest req, HttpServletResponse res) {
		ERS_USERS_DAO_IMPL p = new ERS_USERS_DAO_IMPL();
		List<ERS_USERS> em2 = new ArrayList<ERS_USERS>();
		em2 = p.selectAllUsers();
		System.out.println("in accounts controller" + em2);
		req.getSession().setAttribute("accounts", em2);
		return "/InfoS.html";	
	}
}
