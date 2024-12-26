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
    static int levelMasked;
    static int moduleMasked;
    static int levelMask = 0x7FFFFFFF;
    static int moduleMask = 0;

    public dbg()
    {
       set(0);
    }
    public dbg(int level)
    {
       set(level);
    }

    public static void setLevelMask(int levelMask)
    {
        dbg.levelMask = levelMask;
        dbg.moduleMask = ~levelMask;
        dprintf(level, "Info: dbg.LevelMask(%d)!\n", levelMask);
    }

    public static void set(int level_new)
    {
        if (level != level_new) {
            level = level_new;
            levelMasked = level & levelMask;
            moduleMasked = level & moduleMask;
            dprintf(level, "Info: dbg.set(%d)!\n", level);
        }
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
        if ((dbg_level & moduleMask) != 0) {
            if ((dbg_level & moduleMasked) == 0)
                return;
            dbg_level = dbg_level & levelMask;
        }
        if (dbg_level <= levelMasked)
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
        if ((dbg_level & moduleMask) != 0) {
            if ((dbg_level & moduleMasked) == 0)
                return;
            dbg_level = dbg_level & levelMask;
        }
        if (dbg_level <= levelMasked)
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
        if ((dbg_level & moduleMask) != 0) {
            if ((dbg_level & moduleMasked) == 0)
                return false;
            dbg_level = dbg_level & levelMask;
        }
        return (dbg_level <= levelMasked);
    }
}
