package com.example.servlets;

/*
 * change the actual values being doPost and doGet
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controller.HomeController;
import com.example.controller.RequestHelper;

public class TestServlets extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestHelper.process(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String targetURL = RequestHelper.process(req, res);
		System.out.println("targetURL in servlet" + targetURL);
		PrintWriter out = res.getWriter();
		if (targetURL.equals("invalid")) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User or email has to be unique');");
			out.println("location='/Project1Sadie/create.html';");
			out.println("</script>");
		} else if (targetURL.equals("invalidLogin")) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Username or password incorrect');");
			out.println("location='/Project1Sadie/Login.html';");
			out.println("</script>");

		} else {
			req.getRequestDispatcher(targetURL).forward(req, res);	
		}
	}
}