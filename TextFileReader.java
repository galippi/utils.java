package lippiWare.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {
    public TextFileReader(String _filename) throws FileNotFoundException {
        filename = _filename;
        fin = new BufferedReader(new FileReader(filename));
    }

    public String readLine() throws IOException {
        String line;
        while ((line = fin.readLine()) != null) {
            lineNum++;
            if (line.isEmpty() || line.startsWith("//"))
                continue;
            return line;
        }
        return null;
    }

    public void close() throws IOException {
        fin.close();
        fin = null;
    }

    public int getLineNumber() {
        return lineNum;
    }

    String filename;
    BufferedReader fin;
    int lineNum = 0;
}
