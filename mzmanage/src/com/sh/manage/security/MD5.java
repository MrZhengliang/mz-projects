package com.sh.manage.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * 
 * Title. XX类<br>
 * Description.
 * <p>
 * Copyright: Copyright (c) 2014年11月30日
 * <p>
 * Company: ff
 * <p>
 * Author: fuzl
 * <p>
 * Version: 1.0
 * <p>
 */

public class MD5
{
  @SuppressWarnings("unused")
private static final String algorithm = "MD5";

  public static byte[] digest2Bytes(byte[] bytes)
  {
    MessageDigest md = null;
    try {
      md = MessageDigest.getInstance("MD5");
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
    }

    return md.digest(bytes);
  }

  public static String digest2Str(byte[] bytes)
  {
    return CByte.bytes2Hex(digest2Bytes(bytes));
  }

  public static String digest2Str(String str)
  {
    return digest2Str(str.getBytes());
  }
}