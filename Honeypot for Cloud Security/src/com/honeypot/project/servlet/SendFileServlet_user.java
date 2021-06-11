package com.honeypot.project.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.honeypot.project.bean.Bean;
import com.honeypot.project.dao.SecurityDAO;
import com.honeypot.project.db.DbConnection;

@WebServlet("/SendFileServlet_user")
public class SendFileServlet_user extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ipaddress = null;
		String fname = null;
		Bean b = new Bean();
		HttpSession ses = request.getSession();
		b.setEmail((String)ses.getAttribute("mail"));
		b.setAddress((String)ses.getAttribute("ipaddress"));
		
		int fid = Integer.parseInt(request.getParameter("receiverfile"));
		System.out.println("Fid===>"+fid);
		String remail = request.getParameter("receivermail");
		
		Connection con = new DbConnection().getConnection();
		try {
		PreparedStatement ps = con.prepareStatement("select ipaddress from userdetails where email=?");
		ps.setString(1, remail);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			ipaddress = rs.getString(1);
		}
		if(ipaddress!=null) 
		{
			PreparedStatement ps1 = con.prepareStatement("select filename from fileupload where fid=?");
			ps1.setInt(1, fid);
			ResultSet rs1 = ps1.executeQuery();
			while(rs1.next()) 
			{
				fname = rs1.getString(1);
			}
		}
		if(fname!=null) {
		b.setFname(fname);
		b.setIpaddress(ipaddress);
		b.setMobile(remail);
		b.setFid(fid);
		int i = new SecurityDAO().userShareFiletoAnotherUser(b);
		if(i!=0) 
		{
			response.sendRedirect("SendFile_user.jsp?status=Sended and Waiting at Router for checking");
		}
		}
		else 
		{
			response.sendRedirect("SendFile_user.jsp?status=Send Unsuccessful");
		}
		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("SendFile_user.jsp?status=Some Internal Error");
		}
	}
}