package org.proyectopokemon.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.proyectopokemon.controller.factories.ElegirMovimientoCeldas;
import org.proyectopokemon.controller.factories.TiendaCeldas;
import org.proyectopokemon.model.MovimientoAtaque;
import org.proyectopokemon.model.Objeto;
import org.proyectopokemon.model.Pokemon;
import org.proyectopokemon.model.Tipo;

import java.io.IOException;
import java.util.Objects;

public class ControladorElegirMovimiento {
    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    private Button btnVolver;
    private MovimientoAtaque movimientoAtaque;
    private Pokemon pokemon;
    @FXML
    private Button btnAprender;
    ObservableList<MovimientoAtaque> movimientos = FXCollections.observableArrayList();
    @FXML
    private ListView<MovimientoAtaque> opcionesMovimientos;

    @FXML
    public void volverAVentanaPrincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menuprincipal.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Pokemon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() {
        movimientos.add(new MovimientoAtaque("Impactrueno",1,15, Tipo.ELECTRICO));
        movimientos.add(new MovimientoAtaque("Chispa",1,13,Tipo.ELECTRICO));
        movimientos.add(new MovimientoAtaque("Chispazo",1,20,Tipo.ELECTRICO));
        opcionesMovimientos.setItems(movimientos);
        opcionesMovimientos.setCellFactory(new ElegirMovimientoCeldas());


        opcionesMovimientos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                btnAprender.setDisable(false);
            } else {
                btnAprender.setDisable(true);
            }
        });
    }

    @FXML
    public void aprender(){
        MovimientoAtaque movimientoSelected = opcionesMovimientos.getSelectionModel().getSelectedItem();
        pokemon.getListaCuatroAtaques().add(movimientoSelected);
    }

}
