package com.example.main;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;

public class pEncryption {

	public static Cipher ecipher;
	public static Cipher dcipher;
	public static SecretKey key;
	public static boolean createdKey = false;
	// create new key

	static {
		if (createdKey == false) {
			try {
				System.out.println("created key");
				key = KeyGenerator.getInstance("DES").generateKey();
			} catch (Exception e) {

			} finally {
				createdKey = true;
			}
		} else {
			System.out.println("running key generation block again");
		}
	}

	public static void main(String[] args) {

	}

	public static String encrypt(String str) {

		try {
			System.out.println("keyShow: " + key);
			byte[] utf8 = str.getBytes("UTF8");

			byte[] enc = ecipher.doFinal(utf8);
			enc = BASE64EncoderStream.encode(enc);
			// encode to base64

			return new String(enc);
		}

		catch (Exception e) {

			e.printStackTrace();

		}

		return null;

	}

	public static String decrypt(String str) {

		try {

			// decode with base64 to get bytes
			System.out.println("keyShow: " + key);
			byte[] dec = BASE64DecoderStream.decode(str.getBytes());

			byte[] utf8 = dcipher.doFinal(dec);

			// create new string based on the specified charset

			return new String(utf8, "UTF8");

		}

		catch (Exception e) {

			e.printStackTrace();

		}

		return null;

	}

}
