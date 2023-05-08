package org.proyectopokemon.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PokemonConnection {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null)
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemon",
                    "root", "");
        return connection;
    }
}
