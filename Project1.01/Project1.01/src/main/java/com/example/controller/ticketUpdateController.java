package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import com.example.dao.ERS_REIMBURSEMENT_DAO_IMPL;
import com.pega.models.ERS_REIMBURSEMENT;
import com.pega.models.ERS_USERS;

public class ticketUpdateController {
	public static String update(HttpServletRequest req) {
		System.out.println("////////////////////");
		System.out.println("in ticket update controller");
		System.out.println(req.getParameter("ticketId"));
		System.out.println(req.getParameter("manBtn"));
		int id = Integer.valueOf(req.getParameter("ticketId"));
		int apid = Integer.valueOf(req.getParameter("manBtn"));
		ERS_USERS em = (ERS_USERS) req.getSession().getAttribute("user");
		System.out.println(em);
		int ResId = em.getERS_USERS_ID();
		System.out.println("before entering dao");
		ERS_REIMBURSEMENT_DAO_IMPL ersDaoImpl = new ERS_REIMBURSEMENT_DAO_IMPL();
		ersDaoImpl.updateUserById(id, apid, ResId);
		//loggy used in the DAO
		System.out.println("updated dao");
		return "/PendingS.html";
	}
}