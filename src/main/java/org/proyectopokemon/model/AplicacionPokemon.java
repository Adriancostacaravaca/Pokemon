package org.proyectopokemon.model;

import com.github.oscar0812.pokeapi.models.resources.NamedAPIResourceList;
import com.github.oscar0812.pokeapi.utils.Client;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.sql.*;

public class AplicacionPokemon extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaLogin.fxml")));
        Scene scene = new Scene(root, 400, 450);
        stage.setTitle("Pokemon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/pokemon";
        String usuario = "root";
        String password = "";
        String consulta = "SELECT * FROM pokedex";
        Client Client = null;
        NamedAPIResourceList listaPokemones = Client.getGenerationList(151,1);
        System.out.println(listaPokemones);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, usuario, password);
            Statement statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(consulta);

            while(resultado.next()){
                System.out.println(resultado.getString("NOMBRE"));
            }
            System.out.println("Conectado");
        } catch (SQLException e) {
            System.out.println("Error");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}