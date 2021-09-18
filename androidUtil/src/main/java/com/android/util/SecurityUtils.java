package com.android.util;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class SecurityUtils {
//	private static final //logger //logger = //logger.get//logger(SecurityUtils.class);

	public static final String PASSWORD_KEY = "casanube_20180117_plmoknijbhvygctfcrdxeszwaq";
	
	public static final String VIPARA = "0102030405060708";
	
	public static final String PASSWORD_CONFIG_KEY = "casanube_!@#$%^&";

	@RequiresApi(api = Build.VERSION_CODES.FROYO)
	public static String AESEncode(String passwd, String content) {
		try {
			// 1.构造密钥生成器，指定为AES算法,不区分大小写
			KeyGenerator keygen = KeyGenerator.getInstance("AES");
			// 2.根据ecnodeRules规则初始化密钥生成器
			// 生成一个128位的随机源,根据传入的字节数组
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			random.setSeed(passwd.getBytes());
			keygen.init(128, random);
			// 3.产生原始对称密钥
			SecretKey original_key = keygen.generateKey();
			// 4.获得原始对称密钥的字节数组
			byte[] raw = original_key.getEncoded();
			// 5.根据字节数组生成AES密钥
			SecretKey key = new SecretKeySpec(raw, "AES");
			// 6.根据指定算法AES自成密码器
			Cipher cipher = Cipher.getInstance("AES");
			// 7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
			cipher.init(Cipher.ENCRYPT_MODE, key);
			// 8.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
			byte[] byte_encode = content.getBytes("utf-8");
			// 9.根据密码器的初始化方式--加密：将数据加密
			byte[] byte_AES = cipher.doFinal(byte_encode);
			// 10.将加密后的数据转换为字符串
			String AES_encode = Base64.encodeToString(byte_AES,Base64.DEFAULT);
			return AES_encode;
		} catch (NoSuchAlgorithmException e) {
			//logger.error(e);
		} catch (NoSuchPaddingException e) {
			//logger.error(e);
		} catch (InvalidKeyException e) {
			//logger.error(e);
		} catch (IllegalBlockSizeException e) {
			//logger.error(e);
		} catch (BadPaddingException e) {
			//logger.error(e);
		} catch (UnsupportedEncodingException e) {
			//logger.error(e);
		}

		// 如果有错就返加nulll
		return null;
	}

	/*
	 * 解密 解密过程： 1.同加密1-4步 2.将加密后的字符串反纺成byte[]数组 3.将加密内容解密
	 */
	public static String AESDecode(String passwd, String content) {
		try {
			// 1.构造密钥生成器，指定为AES算法,不区分大小写
			KeyGenerator keygen = KeyGenerator.getInstance("AES");
			// 2.根据ecnodeRules规则初始化密钥生成器
			// 生成一个128位的随机源,根据传入的字节数组
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			random.setSeed(passwd.getBytes());
			keygen.init(128, random);
			// 3.产生原始对称密钥
			SecretKey original_key = keygen.generateKey();
			// 4.获得原始对称密钥的字节数组
			byte[] raw = original_key.getEncoded();
			// 5.根据字节数组生成AES密钥
			SecretKey key = new SecretKeySpec(raw, "AES");
			// 6.根据指定算法AES自成密码器
			Cipher cipher = Cipher.getInstance("AES");
			// 7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
			cipher.init(Cipher.DECRYPT_MODE, key);
			// 8.将加密并编码后的内容解码成字节数组
			byte[] byte_content = Base64.decode(content,Base64.DEFAULT);
			/*
			 * 解密
			 */
			byte[] byte_decode = cipher.doFinal(byte_content);
			String AES_decode = new String(byte_decode, "utf-8");
			return AES_decode;
		} catch (NoSuchAlgorithmException e) {
			//logger.error(e);
		} catch (NoSuchPaddingException e) {
			//logger.error(e);
		} catch (InvalidKeyException e) {
			//logger.error(e);
		} catch (IOException e) {
			//logger.error(e);
		} catch (IllegalBlockSizeException e) {
			//logger.error(e);
		} catch (BadPaddingException e) {
			//logger.error(e);
		}

		// 如果有错就返加nulll
		return null;
	}

	public static String MD5(String s) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bytes = md.digest(s.getBytes("utf-8"));
			return toHex(bytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private static void checkPassword(String passwd) {
		if(TextUtils.isEmpty(passwd) || passwd.length() != 16) {
			throw new RuntimeException("密码位数必须是16位");
		}
	}

	public static String AESEncodeAllPlatform(String passwd, String content) {
		checkPassword(passwd);
		Cipher cipher = null;
		byte[] byteContent;
		try {
			byteContent = content.getBytes("UTF-8");
			IvParameterSpec zeroIv = new IvParameterSpec(VIPARA.getBytes());
			SecretKeySpec key = new SecretKeySpec(passwd.getBytes(), "AES");
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
			byte[] encryptedBytes = cipher.doFinal(byteContent);
			String AES_encode = Base64.encodeToString(encryptedBytes,Base64.DEFAULT);
			return AES_encode;
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			//logger.error(e);
			throw new RuntimeException(e);
		}
	}
	
	public static String AESDecodeAllPlatform(String passwd, String content) {
		checkPassword(passwd);
		try {
			IvParameterSpec zeroIv = new IvParameterSpec(VIPARA.getBytes());
			SecretKeySpec key = new SecretKeySpec(passwd.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
			byte[] byteContent = Base64.decode(content,Base64.DEFAULT);
			byte[] byteDecode = cipher.doFinal(byteContent);
			String AES_decode = new String(byteDecode, "utf-8");
			return AES_decode;
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			//logger.error(e);
			throw new RuntimeException(e);
		}
	
	}

	private static String toHex(byte[] bytes) {
		final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
		StringBuilder ret = new StringBuilder(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
			ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
		}
		return ret.toString();
	}

	public static void main(String[] args) {
		String str = AESEncodeAllPlatform(PASSWORD_CONFIG_KEY, "gggggggggggggggggggggggggggggggggggggggggg");
		String content = AESDecodeAllPlatform(PASSWORD_CONFIG_KEY, str);
		System.out.println(str);
		System.out.println(content);
	}
}
