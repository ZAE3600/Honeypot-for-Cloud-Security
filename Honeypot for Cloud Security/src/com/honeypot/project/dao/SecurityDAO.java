package com.honeypot.project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import com.honeypot.project.bean.Bean;
import com.honeypot.project.db.DbConnection;


public class SecurityDAO extends DbConnection {
	static Connection con=null;
	public SecurityDAO() {
		con=getConnection();
	}
	public ArrayList<Bean> login(Bean b) throws Exception
	{
		
		ArrayList<Bean> al = new ArrayList<>();
		
			PreparedStatement ps = con.prepareStatement("select uid,username,email,ipaddress from userdetails where email=? and password=? and status='active'");
			ps.setString(1, b.getEmail());
			ps.setString(2, b.getPassword());
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Bean value = new Bean();
				value.setUid(rs.getInt(1));
				value.setUname(rs.getString(2));
				value.setEmail(rs.getString(3));
				value.setIpaddress(rs.getString(4));
				al.add(value);
			}
			con.close();
		return al;
	}
	
	public int reg(Bean b) throws Exception
	{
		int i = 0;
			PreparedStatement ps = con.prepareStatement("insert into userdetails(username,password,email,mobile,dob,status,block,address,ipaddress) values(?,?,?,?,?,'inactive','not block',?,?)");
			ps.setString(1, b.getUname());
			ps.setString(2, b.getPassword());
			ps.setString(3, b.getEmail());
			ps.setString(4, b.getMobile());
			String d = b.getDate();
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			Date da = new Date(sd.parse(d).getTime());
			ps.setDate(5, da);
			ps.setString(6, b.getAddress());
			Random rand = new Random();
			String lo =  "192"+"."+"168"+"."+rand.nextInt(255)+"."+rand.nextInt(255);
			ps.setString(7, lo);
			i= ps.executeUpdate();
			con.close();
		return i;	
	}
	
	public int routerCreateNewNetworkforuser(int uid) throws Exception
	{
		int i = 0;
			PreparedStatement ps = con.prepareStatement("update userdetails set status='active' where uid=?");
			ps.setInt(1, uid);
			i= ps.executeUpdate();
			con.close();
		return i;	
	}
	
	public int userUpdateAccountDetails(Bean b) throws Exception
	{
		int i = 0;
			PreparedStatement ps = con.prepareStatement("update userdetails set username=?,mobile=?,address=? where uid=?");
			ps.setString(1, b.getUname());
			ps.setString(2, b.getMobile());
			ps.setString(3, b.getAddress());
			ps.setInt(4, b.getUid());
			i= ps.executeUpdate();
			con.close();
		return i;	
	}
	
	public int userShareFiletoAnotherUser(Bean b) throws Exception
	{
		int i = 0;
		System.out.println("Fname ==>"+b.getFname());
			PreparedStatement ps = con.prepareStatement("insert into fileshare(fid,fromemail,toemail,fromipaddress,toipaddress,invertipaddress,filename,status)values(?,?,?,?,?,?,?,'Waiting in Router')");
			ps.setInt(1, b.getFid());
			ps.setString(2, b.getEmail());
			ps.setString(3, b.getMobile());
			ps.setString(4,b.getAddress());
			ps.setString(5,b.getIpaddress());
			Random rand = new Random();
			String lo =  "192"+"."+"168"+"."+rand.nextInt(255)+"."+rand.nextInt(255);
			ps.setString(6, lo);
			ps.setString(7, b.getFname());
			i= ps.executeUpdate();
			con.close();
		return i;	
	}
	
	public int routerAcceptFileShreRequest(int shareid) throws Exception
	{
		int i = 0;
			PreparedStatement ps = con.prepareStatement("update fileshare set status='Received' where sid=? and status='Waiting in Router'");
			ps.setInt(1, shareid);
			i= ps.executeUpdate();
			con.close();
		return i;	
	}
	
	public int userFeedback(Bean b) throws Exception
	{
		int i = 0;
			PreparedStatement ps = con.prepareStatement("insert into feedback(uname,email,message) values(?,?,?)");
			ps.setString(1, b.getUname());
			ps.setString(2, b.getEmail());
			ps.setString(3, b.getMobile());
			i= ps.executeUpdate();
			con.close();
		return i;	
	}
}