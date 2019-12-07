package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pega.models.ERS_USERS;

public class AccountsHomeController {
	public static String accountsGet(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("in accounts home controller");
		System.out.println(req.getSession().getAttribute("accounts"));
		ArrayList<ERS_USERS> tick = (ArrayList<ERS_USERS>) req.getSession().getAttribute("accounts");
		System.out.println("accounts controller " + tick);
		try {
			res.getWriter().write(new ObjectMapper().writeValueAsString(tick));
			System.out.println("succeded in accounts home controller writing attirbutes");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
