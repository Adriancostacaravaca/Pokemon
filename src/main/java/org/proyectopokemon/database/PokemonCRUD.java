package org.proyectopokemon.database;

import javafx.scene.image.Image;
import org.proyectopokemon.pokemon.Pokemon;
import org.proyectopokemon.enums.Tipo;
import org.proyectopokemon.movements.Movimiento;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PokemonCRUD {
    public static List<Pokemon> readPokemon() {
        String query = "SELECT NOM_POKEMON AS NOMBRE, TIPO1, TIPO2, IMG_URL FROM pokedex";

        PreparedStatement preparedStatement = null;
        LinkedList<Pokemon> listaPokemon = new LinkedList<>();
        try {
            preparedStatement = PokemonConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("NOMBRE");
                String tipo = resultSet.getString("TIPO1").trim();
                String tipo2 = resultSet.getString("TIPO2").trim();
                String imgURL = resultSet.getString("IMG_URL");
                File imgURL2 = new File(imgURL);
                listaPokemon.add(new Pokemon(name, Tipo.valueOf(tipo),
                        Tipo.valueOf(tipo2),new Image(imgURL2.toURI().toString())));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPokemon;
    }

    public static List<Pokemon> readPokemon(int id) {
        String query = "SELECT NOM_POKEMON AS NOMBRE, TIPO1, TIPO2, IMG_URL FROM pokedex where id = ?";

        PreparedStatement preparedStatement = null;
        LinkedList<Pokemon> listaPokemon = new LinkedList<>();
        try {
            preparedStatement = PokemonConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("NOMBRE");
                String tipo = resultSet.getString("TIPO1").trim();
                String tipo2 = resultSet.getString("TIPO2").trim();
                String imgURL = resultSet.getString("IMG_URL");
                File imgURL2 = new File(imgURL);
                listaPokemon.add(new Pokemon(name, Tipo.valueOf(tipo),
                        Tipo.valueOf(tipo2),new Image(imgURL2.toURI().toString())));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPokemon;
    }

    public static List<Movimiento> getListaMovimientos(int pokemonId) throws SQLException {
        List<Movimiento> movimientos = new ArrayList<>();

        String query = "JOIN ";

        PreparedStatement preparedStatement = null;

        preparedStatement = PokemonConnection.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, pokemonId);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            String nameMovement = resultSet.getString("NOMBRE");
            String power = resultSet.getString("TIPO1").trim();
            String state = resultSet.getString("TIPO2").trim();
            String type = resultSet.getString("IMG_URL");
            String improve = resultSet.getString("IMG_URL");

            Movimiento movimiento = new Movimiento();
            movimientos.add(movimiento);
        }
        return movimientos;
    }

        public static void updatePokemon() {
    }

    public static boolean deletePokemon() {
        return true;
    }

    }

