package com.his.util;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Password encryption decryption utility class.
 * 
 * @author laksh
 *
 */
public final class PasswordEncryptDecryptUtil {
	private PasswordEncryptDecryptUtil() {
	}

	private static final String KEY = AppConstantHelper.KEY;
	private static final String INITVECTOR = AppConstantHelper.INITVECTOR;

	/**
	 * It returns the encrypted password .
	 * 
	 * @param value
	 * @return
	 */
	public static String getEncryptedPassword(final String value) throws Exception {

		final IvParameterSpec iv = new IvParameterSpec(INITVECTOR.getBytes("UTF-8"));
		final SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes("UTF-8"), "AES");

		final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

		byte[] encrypted = cipher.doFinal(value.getBytes());
		return Base64.getEncoder().encodeToString(encrypted);

	}

	public static String getDecryptedPassword(String encrypted) throws Exception {
		IvParameterSpec iv = new IvParameterSpec(INITVECTOR.getBytes("UTF-8"));
		SecretKeySpec skeySpec = new SecretKeySpec(KEY.getBytes("UTF-8"), "AES");

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
		byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));
		return new String(original);
	}

}
