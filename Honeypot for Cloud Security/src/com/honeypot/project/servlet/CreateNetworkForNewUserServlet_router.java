package com.honeypot.project.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.honeypot.project.dao.SecurityDAO;

@WebServlet("/CreateNetworkForNewUserServlet_router")
public class CreateNetworkForNewUserServlet_router extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		try {
		int i = new SecurityDAO().routerCreateNewNetworkforuser(uid);
		if(i!=0) 
		{
			response.sendRedirect("CreateNetworkforNewUsers_router.jsp?status=Successfully Created");
		}
		else 
		{
			response.sendRedirect("CreateNetworkforNewUsers_router.jsp?status=Not Successful");
		}
		}catch (Exception e) {
			e.printStackTrace();	
			response.sendRedirect("CreateNetworkforNewUsers_router.jsp?status=some Internal Error");
		}
	}

}
