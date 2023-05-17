package org.proyectopokemon.database;

import javafx.scene.image.Image;
import org.proyectopokemon.enums.Estado;
import org.proyectopokemon.movements.MovimientoAtaque;
import org.proyectopokemon.movements.MovimientoEstado;
import org.proyectopokemon.movements.MovimientoMejora;
import org.proyectopokemon.pokemon.Pokedex;
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

/**
 * CLASE DONDE ESTABLECEREMOS CUALQUIER BÚSQUEDA DE DATOS EN LA BASE DE DATOS
 */
public class PokemonCRUD {
    public static void readPokemon() {
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
                Pokedex.getPokedex().add(new Pokemon(name, Tipo.valueOf(tipo),
                        Tipo.valueOf(tipo2),new Image(imgURL2.toURI().toString())));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Movimiento> getListaMovimientos() throws SQLException {
        List<Movimiento> movimientos = new ArrayList<>();

        String query = "SELECT p.NOM_POKEMON AS NOMBRE,m1.nombre AS NOMATK1, m1.Potencia AS POTENCIATK1, m1.Estado AS ESTADOATK1, m1.Mejora AS MEJORATK1" +
                " from pokedex as p JOIN movimientos as m1 on Primer_Ataque = m1.id_movimiento";

        PreparedStatement preparedStatement = null;

        preparedStatement = PokemonConnection.getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            String nombre = resultSet.getString("NOMATK1");
            int potencia = resultSet.getInt("POTENCIATK1");
            String estado = resultSet.getString("ESTADOATK1");
            int mejora = resultSet.getInt("MEJORATK1");


            if(estado == null && mejora == 0){
                movimientos.add(new MovimientoAtaque(nombre,potencia));
            }
            if(mejora == 0 && potencia == 0){
                movimientos.add(new MovimientoEstado(nombre, Estado.valueOf(estado)));
            }
            if(potencia == 0 && estado == null){
                movimientos.add(new MovimientoMejora(nombre,mejora));
            }
            System.out.println(movimientos.toString());

        }
        return movimientos;
    }

        public static void updatePokemon() {
    }

    public static boolean deletePokemon() {
        return true;
    }

    }

