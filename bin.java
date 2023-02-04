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

  public static String byte2HexString(byte[] objectData, int pos, int size) {
      char[] line = new char[size*3];
      for (int i = pos, idx = 0; (size != 0); i++)
      {
          int val = (int)objectData[i] & 0xFF;
          line[idx++] = byte2HexDigit(((int)(val >> 4)) & 0x0F);
          line[idx++] = byte2HexDigit(((int)(val     )) & 0x0F);
          line[idx++] = ' ';
          size--;
      }
      String result = new String(line);
      return result;
  }

    public static String byte2String(byte[] objectData, int pos, int size) {
        String result = "";
        final int lineLength = 16;
        char[] line = new char[lineLength*3 + 1 + lineLength];
        int linePos = pos % lineLength;
        while (size > 0)
        {
            java.util.Arrays.fill(line, ' ');
            for (int i = linePos; (i < lineLength) && (size != 0); i++)
            {
                int val = (int)objectData[pos] & 0xFF;
                line[i * 3 + 0] = byte2HexDigit(((int)(val >> 4)) & 0x0F);
                line[i * 3 + 1] = byte2HexDigit(((int)(val     )) & 0x0F);
                char c;
                if ((val < 32) || (val > 127))
                    c = '.';
                else
                    c = (char)val;
                line[lineLength*3 + 1 +i] = c;
                pos++;
                size--;
            }
            result = result + new String(line) + "\n";
            linePos = 0;
        }
        return result;
    }

    static char byte2HexDigit(int i) {
        if (i < 10)
            return (char)('0' + i);
        else
            return (char)('A' - 10 + i);
    }

    public static String toString(byte[] data) {
        return toString(data, 0, data.length);
    }
    public static String toString(byte[] data, int length) {
        return toString(data, 0, length);
    }
    public static String toString(byte[] data, int pos, int length) {
        String result = "";
        while (length > 0)
        {
            int val = ((int)data[pos]) & 0xFF;
            result = result + byte2HexDigit(((int)(val >> 4)) & 0x0F) + 
                              byte2HexDigit(((int)(val     )) & 0x0F);
            pos++;
            length--;
            if (length > 0)
                result = result + " ";
        }
        return result;
    }
}
