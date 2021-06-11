package com.honeypot.project.servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.honeypot.project.bean.Bean;
import com.honeypot.project.dao.SecurityDAO;



@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bean b = new Bean();
		b.setUname(request.getParameter("name"));
		b.setPassword(request.getParameter("password"));
		b.setEmail(request.getParameter("email"));
		
		String mobile = request.getParameter("mobile");
		b.setMobile(mobile);
		b.setDate(request.getParameter("dob"));
		b.setAddress(request.getParameter("address"));
		try {
		int i = new SecurityDAO().reg(b);
		if(i!=0) 
		{
			response.sendRedirect("newuserRegister.jsp?status=Registred Successful");
		}
		else 
		{
			response.sendRedirect("newuserRegister.jsp?status=Registred Faild");
		}
		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("newuserRegister.jsp?status=Some Internal Error");
		}
	}
}