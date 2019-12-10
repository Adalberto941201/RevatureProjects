package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import com.example.dao.ERS_REIMBURSEMENT_DAO_IMPL;
import com.pega.models.ERS_REIMBURSEMENT;
import com.pega.models.ERS_USERS;
import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;

public class PendingTicketController {
	public static String pendingTickets(HttpServletRequest req) {
		System.out.println("in pending controller");
		ERS_USERS em = (ERS_USERS) req.getSession().getAttribute("user");
		ERS_REIMBURSEMENT_DAO_IMPL ersReimDaoImpl = new ERS_REIMBURSEMENT_DAO_IMPL();
		List<ERS_REIMBURSEMENT> ersReim = new ArrayList<ERS_REIMBURSEMENT>();
		ersReim = ersReimDaoImpl.selectPendingReimbs();
		java.util.ListIterator<ERS_REIMBURSEMENT> iterator = ersReim.listIterator();
		if (em.getUSER_ROLE_ID_FK() == 1) {
			while (iterator.hasNext()) {
				ERS_REIMBURSEMENT temp = iterator.next();
				if (em.getERS_USERS_ID() != temp.getREIMB_AUTHOR_FK()) {
					iterator.remove();
				}
			}
		}
		System.out.println(ersReim.toString());
		req.getSession().setAttribute("pendTick", ersReim);
		return "/PastReimbE.html";
	}
}