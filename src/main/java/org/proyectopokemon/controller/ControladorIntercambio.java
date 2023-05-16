package org.proyectopokemon.controller;

import javafx.collections.ObservableList;
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
import javafx.stage.Stage;
import org.proyectopokemon.controller.factories.CajaCeldas;
import org.proyectopokemon.controller.factories.EquipoPrincipalCeldas;
import org.proyectopokemon.logger.Logger;
import org.proyectopokemon.pokemon.Entrenador;
import org.proyectopokemon.pokemon.Pokemon;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ControladorIntercambio {
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private Button btnVolver;
    @FXML
    private Button btnEquipoACaja;
    @FXML
    private Button btnCajaAEquipo;
    @FXML
    private Label lblIntercambio;
    @FXML
    private Label lblMiEquipo;
    @FXML
    private Label lblCaja;
    @FXML
    private ListView<Pokemon> listViewCaja;
    @FXML
    private ListView<Pokemon> listViewEquipo;
    @FXML
    private ImageView imageViewFondo;


    public void volverAVentanaPrincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCentroPokemon.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Menú Principal - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public void initialize() throws IOException {
        Logger.write("Estas en la ventana de intercambio entre tu caja y el equipo principal");
        File y = new File("src/main/resources/imagenes/CajaFondo.png");
        Image imagePrincipal = new Image(y.toURI().toString());
        imageViewFondo.setImage(imagePrincipal);
        btnCajaAEquipo.setDisable(true);
        btnEquipoACaja.setDisable(true);
        lblIntercambio.setText("Intercambio");
        lblCaja.setText("Caja");
        lblMiEquipo.setText("Mi equipo");
        listViewCaja.setItems(Entrenador.miEntrenador.getCaja());
        listViewCaja.setCellFactory(new CajaCeldas());

        listViewEquipo.setItems((ObservableList<Pokemon>) Entrenador.miEntrenador.getEquipoPrincipal());
        listViewEquipo.setCellFactory(new EquipoPrincipalCeldas());

        listViewCaja.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                btnEquipoACaja.setDisable(false);

            } else {
                btnEquipoACaja.setDisable(true);
            }
        });
        listViewEquipo.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                btnCajaAEquipo.setDisable(false);
            } else {
                btnCajaAEquipo.setDisable(true);
            }
        });
    }

    @FXML
    public void equipoACaja() throws IOException {
        Pokemon pokemonSelect = listViewEquipo.getSelectionModel().getSelectedItem();

        if (pokemonSelect != null) {
            Entrenador.miEntrenador.moverEquipoACaja(pokemonSelect);
        }
        Logger.write("Has movido un " + pokemonSelect.getNombre() + " a tu caja");
    }
    @FXML
    public void cajaAEquipo() throws IOException {
        Pokemon pokemonSelect = listViewCaja.getSelectionModel().getSelectedItem();
        if (pokemonSelect != null) {
            Entrenador.miEntrenador.moverCajaAEquipo(pokemonSelect);
        }
        Logger.write("Has movido un " + pokemonSelect.getNombre() + " a tu equipo");
    }
}