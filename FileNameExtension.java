package utils;

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
}
