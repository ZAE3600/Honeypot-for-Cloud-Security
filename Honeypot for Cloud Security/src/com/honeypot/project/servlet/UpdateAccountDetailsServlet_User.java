package com.honeypot.project.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.honeypot.project.bean.Bean;
import com.honeypot.project.dao.SecurityDAO;

/**
 * Servlet implementation class UpdateAccountDetailsServlet_User
 */
@WebServlet("/UpdateAccountDetailsServlet_User")
public class UpdateAccountDetailsServlet_User extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bean b = new Bean();
		HttpSession ses = request.getSession();
		int uid = (Integer)ses.getAttribute("uid");
		String uname =  request.getParameter("uname");
		String mobile = request.getParameter("mobile");
		String location = request.getParameter("location");
		b.setUid(uid);
		b.setUname(uname);
		b.setMobile(mobile);
		b.setAddress(location);
		try {
		int i = new SecurityDAO().userUpdateAccountDetails(b);
		if(i!=0) 
		{
			response.sendRedirect("viewAccount_user.jsp?status=Successfully Updated");
		}
		else 
		{
			response.sendRedirect("viewAccount_user.jsp?status=Not Successfull");
		}
		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("viewAccount_user.jsp?status=Some Internal Error");
		}
	}

}
