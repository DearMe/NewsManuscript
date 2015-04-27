package com.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/*
 * 
 * 
 * 
 */
public class MD5 {

	public static String getResult32(String sourceStr) {
		return MD5(sourceStr);
	}


	public static String getResult16(String sourceStr) {
		String result = MD5(sourceStr);
		return result == null ? null : result.substring(8, 24);
	}
	
	private static String MD5(String sourceStr){
		String result = "";
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(sourceStr.getBytes());
			byte[] b = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for(int offset = 0; offset < b.length; offset++){
				i = b[offset];
				if(i < 0) i += 256;
				if(i < 16) buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			result = buf.toString();
			return result;
		}catch(NoSuchAlgorithmException e){
			System.out.println(e.toString());
			return null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(MD5.getResult16("aa"));
		System.out.println(MD5.getResult32("aa"));
	}

}
