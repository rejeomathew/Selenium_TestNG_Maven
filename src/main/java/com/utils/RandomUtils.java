package com.utils;

import java.security.SecureRandom;

public class RandomUtils {
	
	private RandomUtils() {
		
	}
	
	private static final SecureRandom random= new SecureRandom();
	
	public static String generateRandomString(int length) {
		String text = "ABDCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder(length);
		for( int i = 0; i < length; i++ ) 
			sb.append( text.charAt( random.nextInt(text.length())));
		return sb.toString();

	}
}
