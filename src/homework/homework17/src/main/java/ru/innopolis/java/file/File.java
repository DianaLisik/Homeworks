package ru.innopolis.java.file;

import java.io.*;

public class File {

    private static String path = "src\\homework\\homework17\\src\\main\\java\\ru\\innopolis\\java\\car\\file\\";

    private static BufferedWriter bufferedWriter;
    private static BufferedReader carReader;
    private static BufferedReader showCarReader;
    private static BufferedReader performanceCarReader;

    static {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(path + "output.txt"));
            carReader = new BufferedReader(new FileReader(path + "car.txt"));
            showCarReader = new BufferedReader(new FileReader(path + "showCar.txt"));
            performanceCarReader = new BufferedReader(new FileReader(path + "performanceCar.txt"));
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

    public static String carFile() {
        try {
            return carReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String showCarFile() {
        try {
            return showCarReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String performanceCarFile() {
        try {
            return performanceCarReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
