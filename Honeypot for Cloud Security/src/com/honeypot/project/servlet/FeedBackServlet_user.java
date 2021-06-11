package com.honeypot.project.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.honeypot.project.bean.Bean;
import com.honeypot.project.dao.SecurityDAO;


@WebServlet("/FeedBackServlet_user")
public class FeedBackServlet_user extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bean b = new Bean();
		b.setUname(request.getParameter("name"));
		b.setEmail(request.getParameter("email"));
		b.setMobile(request.getParameter("message"));
		try {
		int  i = new SecurityDAO().userFeedback(b);
		if(i!=0) 
		{
			response.sendRedirect("contact.jsp?status=Submited Successful");
		}
		else 
		{
			response.sendRedirect("contact.jsp?status=Not Successful");
		}
		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("contact.jsp?status=Some Internal Error");
		}
	}
}