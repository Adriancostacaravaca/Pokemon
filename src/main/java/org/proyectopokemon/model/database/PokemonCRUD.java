package org.proyectopokemon.model.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PokemonCRUD {

    public static void IngresarDatos() {


        try {
            String consulta = "INSERT INTO pokedex (ID_POKEMON ,NOM_POKEMON) VALUES(?,?)";
            PreparedStatement statement = PokemonConnection.getConnection().prepareStatement(consulta);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}