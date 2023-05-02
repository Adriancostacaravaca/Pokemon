package org.proyectopokemon.model.database;

import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PokemonCRUD {

    public static void IngresarDatos() {

        List<String> generacion1 = new ArrayList<>();
        List<String> generacion1tipos = new ArrayList<>();


        for (int i = 1; i <= 151; i++) {
            Pokemon lista = Pokemon.getById(i);
            generacion1.add(lista.getName());
        }
        System.out.println(generacion1.toString());


        try {
            String consulta = "INSERT INTO pokedex (ID_POKEMON ,NOM_POKEMON) VALUES(?,?)";
            PreparedStatement statement = PokemonConnection.getConnection().prepareStatement(consulta);

            for (int i = 1; i <= 151; i++) {
                statement.setInt(1, i);
                for (int j = 0; j <= 151; j++) {
                    statement.setString(2, generacion1.get(j));

                }
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
