package com.honeypot.project.util;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import com.honeypot.project.bean.Bean;
import com.honeypot.project.db.DbConnection;


public class Encrypt extends DbConnection {
	static Connection con;
	Cipher ecipher;
	
	public Encrypt() {
		con=getConnection();
	}
	
	public static int   encryptDecrypt(String key, int chieperMode,Bean b) throws Exception, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IOException
	{
		
		int i = 0;
		DESKeySpec deskey = new DESKeySpec(key.getBytes());
		SecretKeyFactory se = SecretKeyFactory.getInstance("DES");
		SecretKey secretkey  = se.generateSecret(deskey);
		Cipher chiper =Cipher.getInstance("DES/ECB/PKCS5Padding");
		if(chieperMode == Cipher.ENCRYPT_MODE)
		{
			chiper.init(Cipher.ENCRYPT_MODE,secretkey,SecureRandom.getInstance("SHA1PRNG"));
			PreparedStatement ps = con.prepareStatement("insert into fileupload(uid,email,filename,file,honeypot)values(?,?,?,?,?)");
			ps.setInt(1, b.getUid());
			ps.setString(2, b.getEmail());
			ps.setString(3, b.getFname());
			ps.setBytes(4, b.getFile());
			ps.setString(5, key);
			i=ps.executeUpdate();
		}
		else if(chieperMode == Cipher.DECRYPT_MODE)
		{
			chiper.init(Cipher.DECRYPT_MODE,secretkey,SecureRandom.getInstance("SHA1PRNG"));
			//CipherOutputStream cos  = new CipherOutputStream(fo, chiper);
			//write(fi, cos);
		}
		return chieperMode;
	}
}