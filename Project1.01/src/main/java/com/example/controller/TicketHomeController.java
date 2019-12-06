package com.example.controller;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pega.models.ERS_REIMBURSEMENT;
import com.pega.models.ERS_USERS;
public class TicketHomeController {
	public static String TicketHome(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("in Tickethome controller");
		System.out.println(req.getSession().getAttribute("pastTicket"));
		ArrayList<ERS_REIMBURSEMENT> tick = (ArrayList<ERS_REIMBURSEMENT>) req.getSession().getAttribute("pastTicket");
		System.out.println("home controller " + tick);
		try {
			res.getWriter().write(new ObjectMapper().writeValueAsString(tick));
			System.out.println("succeded in ticket home controller writing attirbutes");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}