package com.example.controller;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pega.models.ERS_REIMBURSEMENT;
public class pendingTicketHomeController {
	public static String pendingTicketHome(HttpServletRequest req, HttpServletResponse res) {
		ArrayList<ERS_REIMBURSEMENT> pendTick = (ArrayList<ERS_REIMBURSEMENT>) req.getSession().getAttribute("pendTick");
		try {
			res.getWriter().write(new ObjectMapper().writeValueAsString(pendTick));
		}catch(JsonProcessingException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}