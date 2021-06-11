package com.honeypot.project.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.honeypot.project.dao.SecurityDAO;


@WebServlet("/AcceptFileShareServlet_router")
public class AcceptFileShareServlet_router extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int shareid = Integer.parseInt(request.getParameter("sid"));
		try {
		 int i =  new SecurityDAO().routerAcceptFileShreRequest(shareid);
		 if(i!=0) 
		 {
		
			response.sendRedirect("AcceptFiles_router.jsp?status=Successfully Updated");
		 }		
		else 
		{
			response.sendRedirect("AcceptFiles_router.jsp?status=Not Successful");
		}
		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("AcceptFiles_router.jsp?status=Some Internal Error");
			
		}
	}

	

}
