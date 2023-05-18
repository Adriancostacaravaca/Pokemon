package org.proyectopokemon.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * CLASE LOGGER DONDE HEMOS CREADO LOS METODOS SUFICIENTES PARA ASEGURAR SU FUNCIONAMIENTO EN CUALQUIER CONTROLADOR
 */
public class Logger {
    private static String outputPath;
    private static BufferedWriter bufferedWriter;

    /**
     * METODO PARA CREAR UN LOGGER A LA HORA DE RECOGER LOS DATOS DE LOS MÉTODOS EN UN FICHERO LOG
     * @throws IOException
     */
    public static void create() throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        String dateFormatted = simpleDateFormat.format(new Date());
        String fileName = "log_" + dateFormatted + ".txt";
        String directoryPath = "src/main/logs/";
        outputPath = directoryPath + fileName;
        bufferedWriter = new BufferedWriter(new FileWriter(outputPath, true));
    }

    /**
     * MÉTODO PARA ESCRIBIR UN MENSAJE ESPECÍFICO A LA HORA DE GRABAR LOS DATOS EN UN FICHERO LOG
     * @param msg EL MENSAJE QUE QUEREMOS INTRODUCIR
     * @throws IOException
     */

    public static void write(String msg) throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        String finalMsg = simpleDateFormat.format(new Date()) + "-" + msg + "\n";
        bufferedWriter.write(finalMsg);
        bufferedWriter.flush();
    }

    /**
     * MÉTODO PARA CERRAR EL LOGGER QUE HEMOS CREADO ANTERIORMENTE CON EL MÉTODO WRITE
     * @throws IOException
     */
    public static void close() throws IOException {
        bufferedWriter.close();
    }

}
