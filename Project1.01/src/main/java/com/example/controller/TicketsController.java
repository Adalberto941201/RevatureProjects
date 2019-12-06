package com.example.controller;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.servlet.http.HttpServletRequest;
import com.example.dao.ERS_REIMBURSEMENT_DAO_IMPL;
import com.pega.models.ERS_REIMBURSEMENT;
import com.pega.models.ERS_USERS;

public class TicketsController {
	public static String Tickets(HttpServletRequest req) {
		System.out.println("in past tickets");
		System.out.println(req.getParameter("btn"));
		System.out.println("help");
		ERS_USERS em = (ERS_USERS) req.getSession().getAttribute("user");
		ERS_REIMBURSEMENT_DAO_IMPL ersReimDaoImpl = new ERS_REIMBURSEMENT_DAO_IMPL();
		List<ERS_REIMBURSEMENT> ersReim = new ArrayList<ERS_REIMBURSEMENT>();
		// ersReim = ersReimDaoImpl.selectById(Id);
		ersReim = ersReimDaoImpl.selectAllReimbs();
		ListIterator<ERS_REIMBURSEMENT> iterator = ersReim.listIterator();
		if (em.getUSER_ROLE_ID_FK() == 1) { // removes accounts for specific users to see
			while (iterator.hasNext()) {
				ERS_REIMBURSEMENT temp = iterator.next();
				if (em.getERS_USERS_ID() != temp.getREIMB_AUTHOR_FK()) {
					iterator.remove();
				}
				if (temp.getREIMB_STATUS_ID_FK() == 0) {
					iterator.remove();
				}
			}
		} else {
			while (iterator.hasNext()) { // removes pending accounts
				ERS_REIMBURSEMENT temp = iterator.next();
				if (temp.getREIMB_STATUS_ID_FK() == 0) {
					iterator.remove();
				}
			}
		}
		System.out.println("removed all pending");
		ListIterator<ERS_REIMBURSEMENT> iterator2 = ersReim.listIterator();
		System.out.println(req.getParameter("btn"));
		if(req.getParameter("btn").equals("showApproved")) {
				while (iterator2.hasNext()) { // removes pending accounts
					ERS_REIMBURSEMENT temp = iterator2.next();
					if (temp.getREIMB_STATUS_ID_FK() == 2) {
						iterator2.remove();
					}
				}
			}
			else if(req.getParameter("btn").equals("showDenied")) {
				while (iterator2.hasNext()) { // removes pending accounts
					ERS_REIMBURSEMENT temp = iterator2.next();
					if (temp.getREIMB_STATUS_ID_FK() == 1) {
						iterator2.remove();
					}
				}
			}
			else if(req.getParameter("showId") != null) {
				while (iterator2.hasNext()) { // removes pending accounts
					ERS_REIMBURSEMENT temp = iterator2.next();
					if (temp.getREIMB_AUTHOR_FK() != Integer.valueOf(req.getParameter("showId"))) {
						iterator2.remove();
					}
				}
			}
		System.out.println("This is the erisReim" + ersReim);
		req.getSession().setAttribute("pastTicket", ersReim);
		return "/PastReimbE.html";
	}
}
