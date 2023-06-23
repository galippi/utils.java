package lippiWare.utils;

import java.io.File;

public class FileNameExtension {
    public static String set(String baseFileName, String fileNameExtension)
    {
        dbg.dprintf(9, "FileNameExtension.set(%s, %s)!\n", baseFileName, fileNameExtension);
        int dotIndex = baseFileName.lastIndexOf('.');
        int pathSeparatorIndex = baseFileName.lastIndexOf(File.separatorChar);
        String newFileName;
        if ((dotIndex >= 0) && (pathSeparatorIndex < dotIndex))
        {
            newFileName = baseFileName.substring(0, dotIndex + 1) + fileNameExtension;
        }else
        { // no extension of data file
            newFileName = baseFileName + "." + fileNameExtension;
        }
        dbg.dprintf(9, "FileNameExtension.set(%s, %s)=%s!\n", baseFileName, fileNameExtension, newFileName);
        return newFileName;
    }

    static public String get(String filename)
    {
        int idx0 = filename.lastIndexOf('/');
        int idx1 = filename.lastIndexOf('\\');
        if (idx0 >= 0)
        {
            if (idx1 > idx0)
                idx0 = idx1;
        }else if (idx1 >= 0)
        {
            idx0 = idx1;
        }
        if (idx0 >= 0)
            filename = filename.substring(idx0 + 1);
        idx0 = filename.lastIndexOf('.');
        if (idx0 >= 0)
        {
            filename = filename.substring(idx0 + 1);
            return filename;
        }
        return "";
    }

    public static boolean check(String baseFileName, String fileNameExtension) {
        String ext = get(baseFileName);
        return fileNameExtension.equalsIgnoreCase(ext);
    }
}
