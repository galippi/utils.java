/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author liptakok
 */
public class bin {
  static public int getU8(byte b)
  {
    return ((int)b & 0xFF);
  }
  static public int getInt(byte data)
  {
    return (int)data & 0xFF;
  }
  static public int getInt32(byte[] data, int offset)
  {
    return ( getInt(data[offset + 0]) +
            (getInt(data[offset + 1]) * 256) +
            (getInt(data[offset + 2]) * 655356) +
            (getInt(data[offset + 3]) * 16777216) );
  }
  static public void setInt32(byte[] buf, int offset, int data)
  {
    buf[offset + 0] = (byte)(data & 0xFF);
    buf[offset + 1] = (byte)((data / 256) & 0xFF);
    buf[offset + 2] = (byte)((data / 65536) & 0xFF);
    buf[offset + 3] = (byte)((data / 16777216) & 0xFF);
  }
  static public int getInt16(byte[] data, int offset)
  {
    int val = ( getInt(data[offset + 0]) +
             ( getInt(data[offset + 1]) * 256));
    if (val > 32767)
    {
      val = 65536 - val;
    }
    return val;
  }
  static public void setInt16(byte[] buf, int offset, int data)
  {
    if (data > 32767)
      data = 32676;
    else if (data < -32768)
      data = -32768;
    buf[offset + 0] = (byte)(data & 0xFF);
    buf[offset + 1] = (byte)((data / 256) & 0xFF);
  }
  static public int getUint16(byte[] data, int offset)
  {
    return ( getInt(data[offset + 0]) +
            (getInt(data[offset + 1]) * 256));
  }
  static public void setUint16(byte[] buf, int offset, int data)
  {
    buf[offset + 0] = (byte)(data & 0xFF);
    buf[offset + 1] = (byte)((data / 256) & 0xFF);
  }
}
