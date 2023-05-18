package org.proyectopokemon.aplicacion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.proyectopokemon.database.PokemonCRUD;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

/**
 * @author Adrian Costa Caravaca
 * @author Francisco Estrada Cuencaa
 * @version 1.0
 */
public class AplicacionPokemon extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaRegistro.fxml")));
        Scene scene = new Scene(root, 419, 491);
        stage.setTitle("Registro - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        PokemonCRUD.readPokemon();
        PokemonCRUD.updatePokemon();
        PokemonCRUD.getListaMovimientos();
        launch();
    }
}