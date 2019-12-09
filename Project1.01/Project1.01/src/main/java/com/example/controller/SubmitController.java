package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.ERS_REIMBURSEMENT_DAO_IMPL;
import com.example.dao.ERS_USERS_DAO_IMPL;
import com.pega.models.ERS_REIMBURSEMENT;
import com.pega.models.ERS_USERS;

public class SubmitController {
	public static String Submit(HttpServletRequest request) {
		System.out.println("in submit controller");
		ERS_USERS em = (ERS_USERS) request.getSession().getAttribute("user");
		System.out.println("system controller" + em);
		System.out.println(request.getParameter("amount"));
		System.out.println(request.getParameter("description"));
		System.out.println(request.getParameter("type"));
		float amount = Float.valueOf(request.getParameter("amount"));
		String description = request.getParameter("description");
		String type = request.getParameter("type");
		System.out.println(type);
		int typeN = 0;
		if (type.equals("travel")) {
			typeN = 1;
		}
		else if(type.equals("supplies")) {
			typeN = 1;
		}
		System.out.println(typeN);
		int employeeId = em.getERS_USERS_ID();
		System.out.println("finished up to inserting");
		ERS_REIMBURSEMENT emNew = new ERS_REIMBURSEMENT(amount, description, employeeId, 0, typeN);
		ERS_REIMBURSEMENT_DAO_IMPL d = new ERS_REIMBURSEMENT_DAO_IMPL();
		d.insertReimbursement(emNew);
		System.out.println(emNew);
		RequestHelper.loggy.info(em.getERS_USERNAME() + "  submitted a ticket");
		return "/SubmitE.html";
	}

}
