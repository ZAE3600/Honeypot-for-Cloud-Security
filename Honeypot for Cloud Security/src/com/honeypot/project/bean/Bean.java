package com.honeypot.project.bean;

import java.sql.Blob;

public class Bean {
private String uname;
private String password;
private String email;
private String mobile;
private String date;
private String utype;
private int uid;
private String card;
private String address;
private String ipaddress;
private byte[] file ;
private String fname; 
private int fid;
private Blob blob;
private String status;

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Blob getBlob() {
	return blob;
}
public void setBlob(Blob blob) {
	this.blob = blob;
}
public int getFid() {
	return fid;
}
public void setFid(int fid) {
	this.fid = fid;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public byte[] getFile() {
	return file;
}
public void setFile(byte[] file) {
	this.file = file;
}
public String getIpaddress() {
	return ipaddress;
}
public void setIpaddress(String ipaddress) {
	this.ipaddress = ipaddress;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCard() {
	return card;
}
public void setCard(String card) {
	this.card = card;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getUtype() {
	return utype;
}
public void setUtype(String utype) {
	this.utype = utype;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
}
