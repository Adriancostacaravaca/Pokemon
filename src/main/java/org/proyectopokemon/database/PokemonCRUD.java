package org.proyectopokemon.database;

import org.proyectopokemon.model.Pokemon;
import org.proyectopokemon.model.Tipo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PokemonCRUD {

    public static List<Pokemon> readPokemon() {
        String query = "SELECT NOM_POKEMON AS NOMBRE, TIPO1 AS TIPO1, TIPO2 AS TIPO2 FROM pokedex";

        PreparedStatement preparedStatement = null;
        LinkedList<Pokemon> listaPokemon = new LinkedList<>();
        try {
            preparedStatement = PokemonConnection.getConnection().prepareStatement(query);
            //preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("NOMBRE");
                String tipo = resultSet.getString("TIPO1");
                String tipo2 = resultSet.getString("TIPO2");
                listaPokemon.add(new Pokemon(name, Tipo.valueOf(tipo),
                        Tipo.valueOf(tipo2)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaPokemon;
    }


}

