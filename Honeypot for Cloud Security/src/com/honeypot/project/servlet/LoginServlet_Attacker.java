package com.honeypot.project.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.honeypot.project.bean.Bean;
import com.honeypot.project.dao.SecurityDAO;

/**
 * Servlet implementation class LoginServlet_Attacker
 */
@WebServlet("/LoginServlet_Attacker")
public class LoginServlet_Attacker extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int  uid = 0;
		String uname = null;
		String mail = null;
		
		Bean b = new Bean();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		b.setEmail(email);
		b.setPassword(password);
		try {
		ArrayList<Bean> al = new SecurityDAO().login(b);
		System.out.println("Al -->"+al);
		for(Bean value:al) 
		{
			uid =  value.getUid();
			mail = value.getEmail();
			uname = value.getUname();
		}
		if(!al.isEmpty()) 
		{
				HttpSession ses = request.getSession();
				ses.setAttribute("uid", uid);
				ses.setAttribute("mail", mail);
				ses.setAttribute("uname", uname);
			RequestDispatcher rd = request.getRequestDispatcher("attackerHome.jsp?status=Welcome as "+uname);
			rd.include(request, response);
		}
		if(al.isEmpty())
		{
			RequestDispatcher rd = request.getRequestDispatcher("attackerlogin.jsp?status=Email and Password Not Matched");
			rd.include(request, response);
		}
		}catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("attackerlogin.jsps?status=Some Internal Error");
			rd.include(request, response);
		}
		}
	}
