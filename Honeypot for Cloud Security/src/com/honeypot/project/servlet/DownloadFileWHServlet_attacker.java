package com.honeypot.project.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.crypto.Cipher;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.honeypot.project.bean.Bean;
import com.honeypot.project.db.DbConnection;
import com.honeypot.project.util.Encrypt;


@WebServlet("/DownloadFileWHServlet_attacker")
public class DownloadFileWHServlet_attacker extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String withoutHoneyPot = request.getParameter("withoutHoneyPot");
		
		
			int fid = 0;
		String honeypot=null;
		byte[] text = null;
		int chieperMode=0;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		chieperMode=Cipher.DECRYPT_MODE;
		String ipaddress =  request.getParameter("ipaddress");
		Bean b = new Bean();
		Connection con = new DbConnection().getConnection();
		try {
			if(withoutHoneyPot.equals("withoutHoneyPot")) {
		PreparedStatement ps = con.prepareStatement("select fid from fileshare where invertipaddress=?");
		ps.setString(1, ipaddress);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			fid=rs.getInt(1);
		}
		if(fid!=0) 
		{
			PreparedStatement ps1 = con.prepareStatement("select honeypot,file from fileupload where fid=?");
			ps1.setInt(1, fid);
			ResultSet rs1 = ps1.executeQuery();
			while(rs1.next()) {
				honeypot = rs1.getString(1);
				text =  rs1.getBytes(2);
			}
			if(honeypot!=null) 
			{
				b.setFile(text);
				b.setAddress(honeypot);
				chieperMode = new Encrypt().encryptDecrypt(honeypot, chieperMode, b);
			}
			if(chieperMode!=0) 
			{
				System.out.println("File Successfully Decrypted");
				
				String file =  new String(text);
				HttpSession ses = request.getSession();
				ses.setAttribute("file", file);
				RequestDispatcher rd = request.getRequestDispatcher("DownloadFilewh_attacker.jsp");
				rd.include(request, response);
			}
			else 
			{
				RequestDispatcher rd = request.getRequestDispatcher("WithoutHoneyPot_attacker.jsp?status=File Not Downloaded");
				rd.include(request, response);
			}
		}
			}else 
			{
				RequestDispatcher rd = request.getRequestDispatcher("DownloadFile_attacker.jsp");
				rd.include(request, response);
			}
		}catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("WithoutHoneyPot_attacker.jsp?status=Some Internal Error");
		}
	}
	}
