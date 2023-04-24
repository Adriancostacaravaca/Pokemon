package org.proyectopokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.proyectopokemon.model.Login;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ControladorBienvenida {

    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    private Button btnEntrar;
    @FXML
    private Label lblUsuario;
    @FXML
    private TextField txtUsuario;
    @FXML
    private Label lblContraseña;
    @FXML
    private TextField txtContraseña;
    @FXML
    private ImageView imagenUsuario;
    private Login login = new Login();

    public void initialize() {
        File f = new File("src/main/resources/imagenes/iconoUsuario.png"); // FIXME: RESPONSIVE, CAMBIAR ATRIBUTO PRESERVE RATIO EN SCENE BUILDER
        Image image = new Image(f.toURI().toString());
        imagenUsuario.setImage(image);
    }

    @FXML
    public void irAVentanaAplicacion(ActionEvent event) throws IOException {
        System.out.println(login.comprobarCredenciales(txtUsuario, txtContraseña));
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menuprincipal.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("The Crüe - Menú Principal");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }



}
