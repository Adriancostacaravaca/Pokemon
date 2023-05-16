package org.proyectopokemon.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * CLASE DONDE ESTABLECEREMOS NUESTRA CONEXIÓN CON NUESTRA BASE DE DATOS EN LOCAL
 */
public class PokemonConnection {
    private static Connection connection;

    /**
     * CON ESTE MÉTODO NOS CONECTAREMOS A LA BASE DE DATOS
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null)
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon",
                    "root", "");
        return connection;
    }
}
