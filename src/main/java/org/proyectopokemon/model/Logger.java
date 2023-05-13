package org.proyectopokemon.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static String outputPath = "src/main/logs/";
    private static BufferedWriter bufferedWriter;

    /**
     * METODO PARA CREAR UN LOGGER A LA HORA DE RECOGER LOS DATOS DE LOS MÉTODOS EN UN FICHERO LOG
     * @throws IOException
     */
    public static void create() throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        outputPath += simpleDateFormat.format(new Date() + ".log");
        bufferedWriter = new BufferedWriter(new FileWriter(outputPath, true));
    }

    /**
     * MÉTODO PARA ESCRIBIR UN MENSAJE ESPECÍFICO A LA HORA DE GRABAR LOS DATOS EN UN FICHERO LOG
     * @param msg EL MENSAJE QUE QUEREMOS INTRODUCIR
     * @throws IOException
     */

    public static void write(String msg) throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        String finalMsg = "";
        finalMsg += simpleDateFormat.format(new Date());
        finalMsg += "-" + msg + "\n";
        bufferedWriter.write(finalMsg);
    }

    /**
     * MÉTODO PARA CERRAR EL LOGGER QUE HEMOS CREADO ANTERIORMENTE CON EL MÉTODO WRITE
     * @throws IOException
     */
    public static void close() throws IOException {
        bufferedWriter.close();
    }

}
