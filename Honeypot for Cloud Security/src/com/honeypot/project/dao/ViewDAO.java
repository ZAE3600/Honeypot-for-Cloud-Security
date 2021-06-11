package com.honeypot.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.honeypot.project.bean.Bean;
import com.honeypot.project.db.DbConnection;

public class ViewDAO extends DbConnection {
	static Connection con = null;
	public ViewDAO() {
		con=getConnection();
	}
	
	public ArrayList<Bean> routerViewNewUsers() throws Exception
	{
		ArrayList<Bean> al = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("select uid,username,email,mobile from userdetails where status='inactive' and block='not block'");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			Bean b = new Bean();
			b.setUid(rs.getInt(1));
			b.setUname(rs.getString(2));
			b.setEmail(rs.getString(3));
			b.setMobile(rs.getString(4));
			al.add(b);
		}
		return al;
	}
	
	public ArrayList<Bean> routerViewAcceptedUsers() throws Exception
	{
		ArrayList<Bean> al = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("select uid,username,email,ipaddress from userdetails where status='active'");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			Bean b = new Bean();
			b.setUid(rs.getInt(1));
			b.setUname(rs.getString(2));
			b.setEmail(rs.getString(3));
			b.setIpaddress(rs.getString(4));
			al.add(b);
		}
		return al;
	}
	
	public ArrayList<Bean> userViewAccountDetails(int uid) throws Exception
	{
		ArrayList<Bean> al = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("select uid,username,email,mobile,address from userdetails where status='active' and uid=?");
		ps.setInt(1, uid);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			Bean b = new Bean();
			b.setUid(rs.getInt(1));
			b.setUname(rs.getString(2));
			b.setEmail(rs.getString(3));
			b.setMobile(rs.getString(4));
			b.setAddress(rs.getString(5));
			al.add(b);
		}
		return al;
	}
	
	public ArrayList<Bean> userFileForDownload(int uid) throws Exception
	{
		ArrayList<Bean> al = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("select fid,filename from fileupload where uid=?");
		ps.setInt(1, uid);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			Bean b = new Bean();
			b.setFid(rs.getInt(1));
			b.setFname(rs.getString(2));
			al.add(b);
		}
		return al;
	}
	
	public ArrayList<Bean> userViewEmailToSendFile(int uid) throws Exception
	{
		ArrayList<Bean> al = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("select email from userdetails where not uid=?");
		ps.setInt(1, uid);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			Bean b = new Bean();
			b.setEmail(rs.getString(1));
			al.add(b);
		}
		return al;
	}
	
	public ArrayList<Bean> userViewFiles(int uid) throws Exception
	{
		ArrayList<Bean> al = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("select fid,filename from fileupload where uid=?");
		ps.setInt(1, uid);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			Bean b = new Bean();
			b.setFid(rs.getInt(1));
			b.setFname(rs.getString(2));
			al.add(b);
		}
		return al;
	}
	
	public ArrayList<Bean> userViewSharedFiles(String email) throws Exception
	{
		ArrayList<Bean> al = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("select sid,fid,filename,toemail,status from fileshare where fromemail=?");
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			Bean b = new Bean();
			b.setUid(rs.getInt(1));
			b.setFid(rs.getInt(2));
			b.setFname(rs.getString(3));
			b.setEmail(rs.getString(4));
			b.setStatus(rs.getString(5));
			al.add(b);
		}
		return al;
	}
	
	public ArrayList<Bean> routerViewSharedFiles() throws Exception
	{
		ArrayList<Bean> al = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("select sid,fid,filename,fromipaddress,toipaddress,invertipaddress from fileshare where status='Waiting in Router'");
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			Bean b = new Bean();
			b.setUid(rs.getInt(1));
			b.setFid(rs.getInt(2));
			b.setFname(rs.getString(3));
			b.setIpaddress(rs.getString(4));
			b.setAddress(rs.getString(5));
			b.setMobile(rs.getString(6));
			al.add(b);
		}
		return al;
	}
	
	public ArrayList<Bean> routerViewFiles() throws Exception
	{
		ArrayList<Bean> al = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("select sid,fid,filename,fromipaddress,toipaddress,invertipaddress from fileshare where status='Received'");
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			Bean b = new Bean();
			b.setUid(rs.getInt(1));
			b.setFid(rs.getInt(2));
			b.setFname(rs.getString(3));
			b.setIpaddress(rs.getString(4));
			b.setAddress(rs.getString(5));
			b.setMobile(rs.getString(6));
			al.add(b);
		}
		return al;
	}
	
	public ArrayList<Bean> userReceivedFiles(String tomail) throws Exception
	{
		ArrayList<Bean> al = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("select sid,fid,filename from fileshare where toemail=? and status='Received'");
		ps.setString(1, tomail);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			Bean b = new Bean();
			b.setUid(rs.getInt(1));
			b.setFid(rs.getInt(2));
			b.setFname(rs.getString(3));
			al.add(b);
		}
		return al;
	}
	
	public ArrayList<Bean> attackerViewUnusedIpAddress() throws Exception
	{
		ArrayList<Bean> al = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("select invertipaddress from fileshare where status='Waiting in Router'");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			Bean b = new Bean();
			b.setIpaddress(rs.getString(1));
			al.add(b);
		}
		return al;
	}
	
	public ArrayList<Bean> routerViewFeedBack() throws Exception
	{
		ArrayList<Bean> al = new ArrayList<>();
		PreparedStatement ps = con.prepareStatement("select fedid,uname,email,message from feedback");
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			Bean b = new Bean();
			b.setFid(rs.getInt(1));
			b.setUname(rs.getString(2));
			b.setEmail(rs.getString(3));
			b.setAddress(rs.getString(4));
			al.add(b);
		}
		return al;
	}
}