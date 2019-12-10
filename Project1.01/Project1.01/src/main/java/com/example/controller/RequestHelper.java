package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class RequestHelper {
	//public final static Logger loggy = Logger.getLogger(RequestHelper.class);
	/*
	 * used in:
	 * login controller
	 * register controllwr
	 * update controller
	 * submit controller
	 * ticket update controller -> DAO REIMBS
	 */
	public static String process(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("REquest Helper URI" + request.getRequestURI());
		switch (request.getRequestURI()) {
		case "/Project1Sadie/Login.do":
			return LoginController.Login(request);
		case "/Project1Sadie/Register.do":
			return RegisterController.Register(request);
		case "/Project1Sadie/Home.do":
			return HomeController.Home(request, response);
		case "/Project1Sadie/Update.do":
			return ProfileController.Update(request);
		case "/Project1Sadie/Submit.do":
			return SubmitController.Submit(request);
		case "/Project1Sadie/pastTicket.do":
			return TicketsController.Tickets(request);
		case "/Project1Sadie/pastTicketGrab.do":
			return TicketHomeController.TicketHome(request, response);
		case "/Project1Sadie/pendTicket.do":
			System.out.println("----------");
			return PendingTicketController.pendingTickets(request);
		case "/Project1Sadie/pendTicketGrab.do":
			return pendingTicketHomeController.pendingTicketHome(request,response);
		case "/Project1Sadie/accounts.do":
			return AccountsController.accounts(request, response);
		case "/Project1Sadie/accountsGrab.do":
			return AccountsHomeController.accountsGet(request, response);
		case "/Project1Sadie/managerPendTicketGrab.do":
			return ticketUpdateController.update(request);
		case "/Project1Sadie/logout.do":
			return LoginController.logout(request);
		default:
			return "/Login.html";
		// if all else fails this will load up the html login page
		}
	}
}
