package org.proyectopokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.proyectopokemon.controller.factories.TiendaCeldas;
import org.proyectopokemon.logger.Logger;
import org.proyectopokemon.pokemon.Entrenador;
import org.proyectopokemon.pokemon.Mochila;
import org.proyectopokemon.shop.Objeto;
import org.proyectopokemon.shop.Tienda;

import java.io.File;
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
    @FXML
    private Label lblPokedolares;
    @FXML
    private Label lblError;
    @FXML
    private ImageView imagenProfesorOak;
    @FXML
    private ImageView imageViewFondo;
    private Tienda tienda = new Tienda();
    private Mochila mochila = new Mochila();
    private Media musicaTienda = new Media(Paths.get("src/main/resources/musica/tienda.mp3").toUri().toString());
    private MediaPlayer mediaPlayer = new MediaPlayer(musicaTienda);
    @FXML
    private ImageView imageViewFondo;

    public void initialize() throws IOException {
        Logger.write("Has entrado a la tienda Pokémon");
        File x = new File("src/main/resources/imagenes/CentroPokemon.jpeg");
        Image imagePrincipal = new Image(x.toURI().toString());
        imageViewFondo.setImage(imagePrincipal);
        tienda.anyadirObjetosATienda();
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
        File f = new File("src/main/resources/imagenes/ProfesorOak.png");
        Image image = new Image(f.toURI().toString());
        imagenProfesorOak.setImage(image);
        musicaTienda();
    }

    @FXML
    private void musicaTienda() {
        mediaPlayer.play();
    }

    @FXML
    public void volverAVentanaAnterior(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCentroPokemon.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Centro Pokémon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        mediaPlayer.stop();
    }

    // ACTUALIZAMOS NUESTRO DINERO
    public void actualizarDinero() {
        lblPokedolares.setText("Pokedólares: " + Entrenador.miEntrenador.getPokedollar());
    }

    @FXML
    public void comprar() {
        //Guardamos el objeto seleccionado en una variable
        Objeto objetoSelect = listaObjetos.getSelectionModel().getSelectedItem();
        //Comprobamos que no sea nulo
        if (objetoSelect != null) {
            boolean compraHecha = Entrenador.miEntrenador.comprar(objetoSelect);
            //Si la compra ese verdadera actualizamos el dinero, ademas comprobamos si ya tenemos
            //el movimiento en la caja o no, si no es asi lo añadimos si no es asi se procede con la compra
            if (compraHecha) {
                actualizarDinero();
                mochila.anyadirAMochila(objetoSelect);
                for (Objeto i:
                     mochila.getMochila()) {
                }
            } else {
                lblError.setText("No tienes suficiente Pokedolares");
            }
        }
    }
}
