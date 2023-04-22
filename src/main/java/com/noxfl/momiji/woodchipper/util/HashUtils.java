/**
 * 
 */
package com.noxfl.momiji.woodchipper.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Fernando Nathanael
 *
 */
public class HashUtils {

	public static String generateSha1(String input) {

		String output;

		try {

			MessageDigest md = MessageDigest.getInstance("SHA-1");

			byte[] messageDigest = md.digest(input.getBytes());

			BigInteger no = new BigInteger(1, messageDigest);

			String hashtext = no.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}

			output = hashtext;
		}

		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

		return output;

	}

}