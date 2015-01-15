package com.sh.manage.demo.http;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.TreeSet;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.RandomStringUtils;

/**
 * http请求工具类. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 
 * <p>
 * Company: 
 * <p>
 * 
 * @author 
 * @version 1.0.0
 */
public class HttpURLConnectionUtils {

	/** 加密算法 */
	private static String Algorithm = "DESede";

	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";

		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs.toUpperCase();
	}

	/**
	 * Des 加密
	 * 
	 * @param sourceCode
	 * @return
	 */
	public static String DesEncrpty(String sourceCode, String secKey) {
		byte[] encoded = encryptMode(secKey.getBytes(), sourceCode.getBytes());
		return byte2hex(encoded);
	}

	/**
	 * 签名
	 * 
	 * @param json
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String doSign(JSONObject json, String chey, int num) throws Exception {
		String baseStr = "";
		for (Object key : new TreeSet(json.keySet())) {
			baseStr += ("&" + key + "=" + json.get(key));
		}

		System.out.println("签名前的字符串：" + baseStr.substring(num));

		SecretKeySpec key = new SecretKeySpec((chey).getBytes("UTF-8"), "HmacSHA1");
		Mac mac = Mac.getInstance("HmacSHA1");
		mac.init(key);
		byte[] bytes = mac.doFinal(baseStr.substring(num).getBytes("UTF-8"));
		json.put("signature", new String(Base64.encodeBase64(bytes)));
		System.out.println("签名后的密钥：" + new String(Base64.encodeBase64(bytes)));
		return json.toString();
	}

	/**
	 * 使用desede算法加密
	 * 
	 * @param keybyte
	 * @param src
	 * @return
	 */
	public static byte[] encryptMode(byte[] keybyte, byte[] src) {
		try {
			SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			return c1.doFinal(src);
		}
		catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		}
		catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}

	public static String getNonce() {
		return RandomStringUtils.random(6, false, true);
	}

	/**
	 * @return
	 */
	public static String getTimestamp() {
		return String.valueOf(System.currentTimeMillis());
	}

	/**
	 * 支持http请求的post的方法
	 * 
	 * @param requestUrl
	 *            地址
	 * @param params
	 *            参数
	 * @return
	 * @throws Exception
	 */
	public static String httpURLConnectionByPost(String requestUrl, String params) throws Exception {
		URL url = new URL(requestUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		try {
			//
			connection.setDoInput(true);
			connection.setDoOutput(true);
			// Write Request Content
			{
				byte[] requsetContent = params.getBytes("utf-8");
				// byte[] requsetContent = new byte[1024];
				connection.setRequestProperty("Content-Length", Integer.toString(requsetContent.length));
				OutputStream outputStream = connection.getOutputStream();
				try {
					outputStream.write(requsetContent);
					outputStream.flush();
				}
				catch (Exception ex) {
					throw ex;
				}
				finally {
					outputStream.close();
				}
			}
			// Get Response Code/Message
			int responseCode = connection.getResponseCode();

			if (responseCode == HttpURLConnection.HTTP_OK) {
				// Read Response Content

				ByteArrayOutputStream baos = new ByteArrayOutputStream(1024 * 64);
				InputStream inputStream = connection.getInputStream();
				try {
					byte[] buf = new byte[1024 * 64];
					int n;
					while ((n = inputStream.read(buf)) >= 0) {
						baos.write(buf, 0, n);
					}
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
				finally {
					inputStream.close();
				}
				byte[] responseContent = baos.toByteArray();
				return new String(responseContent);

			} else {
				return null;
			}
		}
		catch (Exception ex) {
			throw ex;
		}
		finally {
			connection.disconnect();
		}
	}

	/**
	 * 支持http请求的get的方法
	 * 
	 * @param requestUrl
	 *            地址
	 * @param params
	 *            参数
	 * @return
	 * @throws Exception
	 */
	public String httpURLConnectionByGet(String requestUrl, String params) throws Exception {

		// 设置url
		URL url = new URL(requestUrl + params);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		try {
			int responseCode = connection.getResponseCode();
			// 如果是404返回null
			if (responseCode == HttpURLConnection.HTTP_OK) {
				InputStreamReader reader = new InputStreamReader(connection.getInputStream());
				// 将读取的字符放到StringBuilder中
				StringBuilder str = new StringBuilder();
				char[] cbuf = new char[1024];
				while (true) {
					int n = reader.read(cbuf);
					if (n < 0) {
						break;
					} else {
						str.append(cbuf, 0, n);
					}
				}
				return str.toString();
			} else {
				return null;
			}
		}
		catch (Exception ex) {
			throw ex;
		}
		finally {
			connection.disconnect();
		}

	}

}
