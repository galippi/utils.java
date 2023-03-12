package lippiWare.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabor Liptak
 */
//import java.io.*;

public class dbg {
    static int level;
    public dbg()
    {
       level = 0; 
    }
    public dbg(int level)
    {
       set(level);
    }
    public static void set(int level_new)
    {
        level = level_new;
        dprintf(level, "Info: dbg.set(%d)!\n", level);
    }

    static void printlnLocal(int dbg_level, String str)
    {
        if (dbg_level <= 1)
            System.err.println(str);
        else
            System.out.println(str);
    }

    public static void println(int dbg_level, String line)
    {
        if (dbg_level <= level)
        {
            printlnLocal(dbg_level, line);
        }
    }
    public static String d_format(String fmt, Object ... arguments)
    {
      // todo: not all c-formatter (e.g. %u) are supported
      //return String.format(fmt, arguments);
      return Sprintf.sprintf(fmt, arguments);
    }

    static void print(int dbg_level, String str)
    {
        if (dbg_level <= 1)
            System.err.print(str);
        else
            System.out.print(str);
    }

    public static void dprintf(int dbg_level, String fmt, Object ... arguments)
    {
        if (dbg_level <= level)
        {
            print(dbg_level, Sprintf.sprintf(fmt, arguments));
        }
    }
    public static int get()
    {
        return level;
    }
    public static boolean get(int dbg_level)
    {
        return (dbg_level <= level);
    }
}
