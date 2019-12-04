package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	/*
	 * The idea behind the class is to route requests based on the URI that comes
	 * along with the request
	 */

	public static String process(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Hello  in request helper");
		System.out.println("URI" + request.getRequestURI());
		switch(request.getRequestURI()) {
		case "/Project1Sadie/Login.do":
			return LoginController.Login(request);
		case "/Project1Sadie/Register.do":
			System.out.println("in request helper");
			return RegisterController.Register(request);
		case "/Project1Sadie/Home.do":
			return HomeController.Home(request, response);
		default:
			return "/Login.html";
			//if all else fails this will load up the html login page			
		}
	}
}
