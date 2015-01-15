/**
 * 
 */
package com.sh.manage.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author fuzl
 * 
 */
public class ValidateDate {
	public static boolean validateUserName(String userName) {
		if (StringUtil.isEmpty(userName)) {
			return false;
		}

		String specialChar = "[a-zA-Z0-9]{6,20}";

		Pattern p = Pattern.compile("[a-zA-Z0-9]{6,20}");
		Matcher m = p.matcher(userName);
		boolean b = m.matches();
		return b;
	}

	public static boolean validatePassword(String password) {
		if (StringUtil.isEmpty(password)) {
			return false;
		}

		String specialChar = "[!@#$%^&*()]";

		Pattern p = Pattern.compile(specialChar);
		Matcher m = p.matcher(password);
		boolean b = m.find();

		if (!b) {
			return b;
		}
		specialChar = "^[A-Za-z]";

		p = Pattern.compile(specialChar);
		m = p.matcher(password);
		b = m.find();

		if ((password.length() < 6) || (password.length() > 20)) {
			b = false;
		}
		return b;
	}

	public static boolean validateRand(String rand) {
		if (StringUtil.isEmpty(rand)) {
			return false;
		}

		String pat = "[A-za-z0-9]{4}";
		Pattern p = Pattern.compile(pat);
		Matcher m = p.matcher(rand);
		boolean b = m.matches();

		return b;
	}

	public static boolean validateMobileRand(String mobileRand) {
		if (StringUtil.isEmpty(mobileRand)) {
			return false;
		}
		String pat = "[A-za-z0-9]{6}";
		Pattern p = Pattern.compile(pat);
		Matcher m = p.matcher(mobileRand);
		boolean b = m.matches();
		return b;
	}
}
