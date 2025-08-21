package homework.homework08.File;

import java.io.*;


public class File {

    private static String path = "src/homework/homework08/File/";

    private static BufferedWriter bufferedWriter;
    private static BufferedReader bufferedReader;

    static {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(path + "output.txt"));
            bufferedReader = new BufferedReader(new FileReader(path + "input.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void outputFile(String str) {
        try {
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String intutFile() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
