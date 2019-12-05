package com.example.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pega.models.ERS_USERS;

public class HomeController {
	public static String Home(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("in home controller");
		ERS_USERS em = (ERS_USERS)req.getSession().getAttribute("user");
		System.out.println("home controller " + em);

		try {
			res.getWriter().write(new ObjectMapper().writeValueAsString(em));
			System.out.println("succeded in home controller writing attirbutes");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}