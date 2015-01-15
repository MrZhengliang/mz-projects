package com.sh.manage.security;

/**
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

public class CByte
{
  private static String[] HexCode = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

  public static String byte2Hex(byte b)
  {
    int n = b;
    if (n < 0) {
      n += 256;
    }
    int d1 = n / 16;
    int d2 = n % 16;
    return HexCode[d1] + HexCode[d2];
  }

  public static int byte2int(byte[] b)
  {
    return b[3] & 0xFF | (b[2] & 0xFF) << 8 | (b[1] & 0xFF) << 16 | (b[0] & 0xFF) << 24;
  }

  public static int byte2int(byte[] b, int offset)
  {
    return b[(offset + 3)] & 0xFF | (b[(offset + 2)] & 0xFF) << 8 | (b[(offset + 1)] & 0xFF) << 16 | (b[offset] & 0xFF) << 24;
  }

  public static long byte2long(byte[] b)
  {
    return b[7] & 0xFF | (b[6] & 0xFF) << 8 | (b[5] & 0xFF) << 16 | (b[4] & 0xFF) << 24 | 
      (b[3] & 0xFF) << 32 | (b[2] & 0xFF) << 40 | (b[1] & 0xFF) << 48 | 
      (b[0] & 0xFF) << 56;
  }

  public static long byte2long(byte[] b, int offset)
  {
    return b[(offset + 7)] & 0xFF | (b[(offset + 6)] & 0xFF) << 8 | (b[(offset + 5)] & 0xFF) << 16 | 
      (b[(offset + 4)] & 0xFF) << 24 | (b[(offset + 3)] & 0xFF) << 32 | (b[(offset + 2)] & 0xFF) << 40 | 
      (b[(offset + 1)] & 0xFF) << 48 | (b[offset] & 0xFF) << 56;
  }

  public static String bytes2Hex(byte[] b)
  {
    String result = "";
    for (int i = 0; i < b.length; i++) {
      result = result + byte2Hex(b[i]);
    }
    return result;
  }

  public static String DecToOther(long iNum, int jz)
    throws Exception
  {
    long consult = 0L;
    long rest = 0L;
    StringBuffer sbBinary = new StringBuffer();
    if (iNum >= jz) {
      do {
        consult = iNum / jz;
        rest = iNum % jz;
        iNum = consult;
        if (jz == 16)
          sbBinary.append(HexCode[(int)rest]);
        else {
          sbBinary.append(rest);
        }
      }
      while (consult >= jz);
      if (jz == 16)
        sbBinary.append(HexCode[(int)consult]);
      else
        sbBinary.append(consult);
    }
    else {
      rest = (int)iNum % jz;
      if (jz == 16)
        sbBinary.append(HexCode[(int)rest]);
      else {
        sbBinary.append(rest);
      }
    }
    sbBinary.reverse();
    return sbBinary.toString();
  }

  public static byte[] hex2Bytes(String s)
  {
    int len = s.length() / 2;
    byte[] bMsg = new byte[len];
    for (int i = 0; i < len; i++) {
      byte x = Byte.parseByte(s.substring(2 * i, 2 * i + 1), 16);
      byte y = Byte.parseByte(s.substring(2 * i + 1, 2 * i + 2), 16);
      int j = x * 16 + y;
      bMsg[i] = (byte)j;
    }
    return bMsg;
  }

  public static byte[] int2byte(int n)
  {
    byte[] b = new byte[4];
    b[0] = (byte)(n >> 24);
    b[1] = (byte)(n >> 16);
    b[2] = (byte)(n >> 8);
    b[3] = (byte)n;
    return b;
  }

  public static void int2byte(int n, byte[] buf, int offset)
  {
    buf[offset] = (byte)(n >> 24);
    buf[(offset + 1)] = (byte)(n >> 16);
    buf[(offset + 2)] = (byte)(n >> 8);
    buf[(offset + 3)] = (byte)n;
  }

  public static byte[] long2byte(long n)
  {
    byte[] b = new byte[8];
    b[0] = (byte)(int)(n >> 56);
    b[1] = (byte)(int)(n >> 48);
    b[2] = (byte)(int)(n >> 40);
    b[3] = (byte)(int)(n >> 32);
    b[4] = (byte)(int)(n >> 24);
    b[5] = (byte)(int)(n >> 16);
    b[6] = (byte)(int)(n >> 8);
    b[7] = (byte)(int)n;
    return b;
  }

  public static void long2byte(long n, byte[] buf, int offset)
  {
    buf[offset] = (byte)(int)(n >> 56);
    buf[(offset + 1)] = (byte)(int)(n >> 48);
    buf[(offset + 2)] = (byte)(int)(n >> 40);
    buf[(offset + 3)] = (byte)(int)(n >> 32);
    buf[(offset + 4)] = (byte)(int)(n >> 24);
    buf[(offset + 5)] = (byte)(int)(n >> 16);
    buf[(offset + 6)] = (byte)(int)(n >> 8);
    buf[(offset + 7)] = (byte)(int)n;
  }

  public static byte[] short2byte(int n)
  {
    byte[] b = new byte[2];
    b[0] = (byte)(n >> 8);
    b[1] = (byte)n;
    return b;
  }

  public static void short2byte(int n, byte[] buf, int offset)
  {
    buf[offset] = (byte)(n >> 8);
    buf[(offset + 1)] = (byte)n;
  }

  public static String ToBin(String sNum, int jz)
    throws Exception
  {
    long tempDecimal = ToDec(sNum, jz);
    return DecToOther(tempDecimal, 2);
  }

  public static long ToDec(String sNum, int jz)
    throws Exception
  {
    long temp = 0L;
    long p = 0L;

    int num = 0;
    for (int i = sNum.length() - 1; i >= 0; i--) {
      char c = sNum.charAt(i);

      if (jz == 16) {
        if (((byte)c >= 97) && ((byte)c <= 102))
          num = c - 'W';
        else if (((byte)c >= 65) && ((byte)c <= 70))
          num = c - 'A';
        else
          num = Integer.parseInt(String.valueOf(c));
      }
      else {
        num = Integer.parseInt(String.valueOf(c));
      }
      temp =(long) (temp + num * Math.pow(jz, p));
      p += 1L;
    }
    return temp;
  }

  public static String ToHex(String sNum, int jz)
    throws Exception
  {
    long tempDecimal = ToDec(sNum, jz);
    return DecToOther(tempDecimal, 16);
  }

  public static String ToOct(String sNum, int jz)
    throws Exception
  {
    long tempDecimal = ToDec(sNum, jz);
    return DecToOther(tempDecimal, 8);
  }
}