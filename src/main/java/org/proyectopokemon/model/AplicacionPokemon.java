package org.proyectopokemon.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AplicacionPokemon extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaRegistro.fxml")));
        Scene scene = new Scene(root, 459, 533);
        stage.setTitle("Registro - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        /*System.out.println(Tipo.valueOf("AGUA"));
        LinkedList<Pokemon> miLista = (LinkedList<Pokemon>) PokemonCRUD.readPokemon();
        for (Pokemon p:miLista) {
            Pokedex.getPokedexx().add(p);
        }
        System.out.println(Pokedex.getPokedex().toString());
        PokemonCRUD.updatePokemon();
*/
        launch();
    }
}