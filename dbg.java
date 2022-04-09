/**
 *
 * @author Gabor Liptak
 */

package lippiWare.utils;

import lippiWare.utils.Sprintf;

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
    public static void println(int dbg_level, String line)
    {
        if (dbg_level <= level)
        {
            System.out.println(line);
        }
    }
    public static String d_format(String fmt, Object ... arguments)
    {
      // todo: not all c-formatter (e.g. %u) are supported
      //return String.format(fmt, arguments);
      return Sprintf.sprintf(fmt, arguments);
    }

    public static void dprintf(int dbg_level, String fmt, Object ... arguments)
    {
        if (dbg_level <= level)
        {
            System.out.print(Sprintf.sprintf(fmt, arguments));
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
