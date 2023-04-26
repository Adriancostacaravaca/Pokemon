package org.proyectopokemon.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.proyectopokemon.controller.factories.TiendaCeldas;
import org.proyectopokemon.model.Entrenador;
import org.proyectopokemon.model.Mochila;
import org.proyectopokemon.model.Objeto;
import org.proyectopokemon.model.Tienda;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

public class ControladorTienda {
    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    private Button btnVolver;
    @FXML
    private Button btnComprar;
    @FXML
    private ListView<Objeto> listaObjetos;
    private Entrenador entrenadorPrincipal = new Entrenador("Juan");
    @FXML
    private Label lblDinero;
    private Tienda tienda = new Tienda();
    private Mochila mochila = new Mochila();
    private Media musicaTienda = new Media(Paths.get("src/main/resources/musica/tienda.mp3").toUri().toString());
    private MediaPlayer mediaPlayer = new MediaPlayer(musicaTienda);

    public void initialize() {
        tienda.añadirObjetosATienda();
        listaObjetos.setItems(tienda.getObjetosTienda());
        listaObjetos.setCellFactory(new TiendaCeldas());

        listaObjetos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                btnComprar.setDisable(false);
            } else {
                btnComprar.setDisable(true);
            }
        });
        actualizarDinero();
        musicaTienda();
    }

    @FXML
    private void musicaTienda() {
        mediaPlayer.play();
    }

    @FXML
    public void volverAVentanaPrincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menuprincipal.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Pokemon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        mediaPlayer.stop();
    }

    // ACTUALIZAMOS NUESTRO DINERO MEDIANTE UN MÉTODO
    public void actualizarDinero() {
        lblDinero.setText("Pokedólares: " + entrenadorPrincipal.getPokedollar());
    }

    // UTILIZAMOS INITIALIZE PARA EJECUTAR EL MÉTODO UNA VEZ ENTRAMOS EN LA ESCENA

    @FXML
    public void comprar() {
        //guardamos el objeto seleccionado en una variable
        Objeto objetoSelect = listaObjetos.getSelectionModel().getSelectedItem();
        //Comprobamos que no sea nulo
        if (objetoSelect != null) {
            boolean compraHecha = entrenadorPrincipal.comprar(objetoSelect);
            //Si la compra ese verdadera actualizamos el dinero, ademas comprobamos si ya tenemos
            //el movimiento en la caja o no, si no es asi lo añadimos si no es asi se procede con la compra
            if (compraHecha) {
                actualizarDinero();
                mochila.añadirAMochila(objetoSelect);
                for (Objeto i:
                     mochila.getMochila()) {
                    System.out.println(mochila.getMochila().toString());

                }
            } else {
                System.out.println("No tienes suficiente Pokedólares para comprar ese objeto");
            }
        }

    }
}
