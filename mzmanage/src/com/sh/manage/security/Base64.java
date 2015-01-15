package com.sh.manage.security;

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
public class Base64
{
  private static char[] Base64Code = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 
    'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 
    'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/' };

  private static byte[] Base64Decode = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
    -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 63, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, 
    -1, 0, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 
    26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1 };

  public static byte[] decode(String s)
  {
    int fillNum = 0;
    if (s.endsWith("==")) {
      fillNum = 2;
    }
    else if (s.endsWith("=")) {
      fillNum = 1;
    }

    int size = s.length() / 4 * 3 - fillNum;
    byte[] bRet = new byte[size];
    byte[] bAfterBase64Encode = s.getBytes();
    int j = 0;
    for (int i = 3; i < bAfterBase64Encode.length; i += 4) {
      int p0 = bAfterBase64Encode[(i - 3)];
      int p1 = bAfterBase64Encode[(i - 2)];
      int p2 = bAfterBase64Encode[(i - 1)];
      int p3 = bAfterBase64Encode[i];

      bRet[j] = (byte)(Base64Decode[p0] << 2 | (Base64Decode[p1] & 0x30) >>> 4);
      if (j + 1 < size) {
        bRet[(j + 1)] = (byte)((Base64Decode[p1] & 0xF) << 4 | (Base64Decode[p2] & 0x3C) >>> 2);
      }
      if (j + 2 < size) {
        bRet[(j + 2)] = (byte)((Base64Decode[p2] & 0x3) << 6 | Base64Decode[p3] & 0x3F);
      }
      j += 3;
    }
    return bRet;
  }

  public static String encode(byte[] b)
  {
    int fillNum = 0;
    if (b.length % 3 != 0) {
      fillNum = 3 - b.length % 3;
    }

    int size = b.length + b.length / 3 + fillNum;
    StringBuilder sbResult = new StringBuilder(size);
    int cou = 1;
    for (int i = 0; i < b.length; i++) {
      if (cou == 1) {
        sbResult.append(Base64Code[((b[i] & 0xFC) >>> 2)]);
      }
      if (cou == 2) {
        sbResult.append(Base64Code[((b[(i - 1)] & 0x3) << 4 | (b[i] & 0xF0) >>> 4)]);
      }
      if (cou == 3) {
        sbResult.append(Base64Code[((b[(i - 1)] & 0xF) << 2 | (b[i] & 0xC0) >>> 6)]);
        sbResult.append(Base64Code[(b[i] & 0x3F)]);
        cou = 0;
      }
      cou++;
    }
    if (b.length % 3 == 1) {
      sbResult.append(Base64Code[((b[(b.length - 1)] & 0x3) << 4)]);
      sbResult.append("==");
    }
    if (b.length % 3 == 2) {
      sbResult.append(Base64Code[((b[(b.length - 1)] & 0xF) << 2)]);
      sbResult.append("=");
    }

    return sbResult.toString();
  }

  public static String encode(String s)
  {
    return encode(s.getBytes());
  }
}