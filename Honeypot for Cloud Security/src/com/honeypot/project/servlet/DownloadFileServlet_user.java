package com.honeypot.project.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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


@WebServlet("/DownloadFileServlet_user")
public class DownloadFileServlet_user extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String honeypot=null;
		byte[] text = null;
		int chieperMode=0;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		chieperMode=Cipher.DECRYPT_MODE;
		Bean b = new Bean();
	int uid = Integer.parseInt(request.getParameter("uid"));
	int fid = Integer.parseInt(request.getParameter("fid"));
	Connection con=  new DbConnection().getConnection();
	try {
	PreparedStatement ps = con.prepareStatement(" select honeypot,file from fileupload where uid=? and fid=?");
	ps.setInt(1, uid);
	ps.setInt(2, fid);
	ResultSet rs = ps.executeQuery();
	while(rs.next()) {
		honeypot = rs.getString(1);
		text =  rs.getBytes(2);
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
		RequestDispatcher rd = request.getRequestDispatcher("DownloadedFile_user.jsp");
		rd.include(request, response);
	}
	else 
	{
		RequestDispatcher rd = request.getRequestDispatcher("DownloadFile_user.jsp?status=File Not Downloaded");
		rd.include(request, response);
	}
	}catch (Exception e) {
		e.printStackTrace();
		RequestDispatcher rd = request.getRequestDispatcher("DownloadedFile_user.jsp?status=Some Internal Error");
		rd.include(request, response);
	}
	}
}