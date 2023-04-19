package org.proyectopokemon.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static String outputPath = "src/main/logs/";
    private static BufferedWriter bufferedWriter;

    public static void create() throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        outputPath += simpleDateFormat.format(new Date() + ".log");
        bufferedWriter = new BufferedWriter(new FileWriter(outputPath, true));
    }

    public static void write(String msg) throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        String finalMsg = "";
        finalMsg += simpleDateFormat.format(new Date());
        finalMsg += "-" + msg + "\n";
        bufferedWriter.write(finalMsg);
    }

    public static void close() throws IOException {
        bufferedWriter.close();
    }

}
