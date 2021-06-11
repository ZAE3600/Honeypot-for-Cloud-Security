package com.honeypot.project.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.honeypot.project.bean.Bean;
import com.honeypot.project.util.Encrypt;

@WebServlet("/UploadFileServlet_User")
public class UploadFileServlet_User extends HttpServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession ses = request.getSession();
	String target = "uploadfile_customer.jsp?status=File Not Available";
	String email = (String)ses.getAttribute("mail");
	int uid = (Integer)ses.getAttribute("uid");
	String extension = "";
	Bean b = new Bean();
	DiskFileItemFactory factory = new DiskFileItemFactory();
	ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			int ciphermode =  Cipher.ENCRYPT_MODE;

			List fileItems = upload.parseRequest(request);
			Iterator i = fileItems.iterator();
			int k = 0;
			File f = null;
			FileItem file =  (FileItem)fileItems.get(0);
			String fname = file.getName();
			System.out.println("File name--->"+fname);
			extension = fname.substring(fname.lastIndexOf("."));
			if(extension.equals(".txt"))
			{
				 b.setFile(file.get());
				 b.setEmail(email);
				 b.setUid(uid);
				 b.setFname(fname);
				 Random ra = new Random();
				 Long lo = (long)ra.nextInt(100000000);
				 String skey =  lo.toString();
				 System.out.println("Skey--->"+skey);
				 ciphermode =  new Encrypt().encryptDecrypt(skey.toString(),ciphermode,b);
				 
				 if(ciphermode!=0)
				 {
					 RequestDispatcher rd = request.getRequestDispatcher("UploadFile_user.jsp?status=Uploded Successfull");
					 rd.include(request, response);
				 }
				 else
				{
					 RequestDispatcher rd = request.getRequestDispatcher("UploadFile_user.jsp?status=Faild to Uploaded");
					 rd.include(request, response);
				}
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("UploadFile_user.jsp?status=Upload file only in text(.txt) fromat");
				 rd.include(request, response);
			}				
}catch (Exception e) {
	e.printStackTrace();
	RequestDispatcher rd = request.getRequestDispatcher("uploadfile_customer.jsp?status=Some Internal Error");
	 rd.include(request, response);
}
}

}
