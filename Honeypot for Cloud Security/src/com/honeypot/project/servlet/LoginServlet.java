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



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int  uid = 0;
		String uname = null;
		String mail = null;
		String utype = null;
		String ipaddress = null;
		
		Bean b = new Bean();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(email.equalsIgnoreCase("router@gmail.com")&&password.equalsIgnoreCase("router")) 
		{
				RequestDispatcher rd = request.getRequestDispatcher("routerhome.jsp?status=Welcome to Router Home Page");
				rd.include(request, response);
		}
		else {
		b.setEmail(email);
		b.setPassword(password);
		try {
		ArrayList<Bean> al = new SecurityDAO().login(b);
		for(Bean value:al) 
		{
			uid =  value.getUid();
			mail = value.getEmail();
			uname = value.getUname();
			utype = value.getUtype();
			ipaddress = value.getIpaddress();
		}
		if(!al.isEmpty()) 
		{
				HttpSession ses = request.getSession();
				ses.setAttribute("uid", uid);
				ses.setAttribute("mail", mail);
				ses.setAttribute("uname", uname);
				ses.setAttribute("ipaddress", ipaddress);
			RequestDispatcher rd = request.getRequestDispatcher("userhome.jsp?status=Welcome "+uname);
			rd.include(request, response);
		}
		if(al.isEmpty())
		{
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp?status=Email and Password Not Matched");
			rd.include(request, response);
		}
		}catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp?status=Some Internal Error");
			rd.include(request, response);
		}
		}
	}
}
