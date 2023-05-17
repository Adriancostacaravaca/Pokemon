package org.proyectopokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.proyectopokemon.logger.Logger;
import org.proyectopokemon.pokemon.Entrenador;
import org.proyectopokemon.pokemon.Pokemon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ControladorCrianza {

    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private Button btnVolver;
    @FXML
    private CheckBox check1;
    @FXML
    private CheckBox check2;
    @FXML
    private CheckBox check3;
    @FXML
    private CheckBox check4;
    @FXML
    private CheckBox check5;
    @FXML
    private CheckBox check6;
    @FXML
    private Button btnCriar;
    @FXML
    private ImageView imageViewPokemon1;
    @FXML
    private ImageView imageViewPokemon2;
    @FXML
    private Label lblCoste;
    @FXML
    private Label lblPokemon1;
    @FXML
    private Label lblPokemon2;
    @FXML
    private Label lblMensaje;
    @FXML
    private Label lblPokedolares;
    private List<CheckBox> botones;
    private Pokemon[] seleccionados;
    private ControladorVentanaEmergente controladorVentanaEmergente;

    public void initialize() throws IOException {
        Logger.write("Estás en la ventana de crianza");
        actualizarDinero();
        controladorVentanaEmergente = new ControladorVentanaEmergente();
        seleccionados = new Pokemon[2];
        botones = new ArrayList<>();
        botones.add(this.check1);
        botones.add(this.check2);
        botones.add(this.check3);
        botones.add(this.check4);
        botones.add(this.check5);
        botones.add(this.check6);

        for (int i = 0; i < Entrenador.miEntrenador.getEquipoPrincipal().size(); i++) {
            if (Entrenador.miEntrenador.getEquipoPrincipal().get(i) != null) {
                botones.get(i).setText(Entrenador.miEntrenador.getEquipoPrincipal().get(i).getNombre());
            }
        }
        for (CheckBox checkBox : botones) {
            if (checkBox.getText().equals("CheckBox")) {
                checkBox.setDisable(true);
            }
            checkBox.setOnAction(event -> {
                        int contador = 0;
                        for (CheckBox cb : botones) {
                            if (cb.isSelected()) {
                                contador++;
                            }
                        }
                        for (CheckBox cb : botones) {
                            if (!cb.isSelected()) {
                                cb.setDisable(contador >= 2);
                            }
                        }
                        mostrarImg();
                    }
            );
        }

    }

    @FXML
    public void volverAVentanaAnterior(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCentroPokemon.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Pokemon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        actualizarDinero();
    }

    // ACTUALIZAMOS NUESTRO DINERO
    public void actualizarDinero() {
        if(Entrenador.miEntrenador.getPokedollar() < 800){
            btnCriar.setDisable(true);
            lblMensaje.setText("No tienes suficientes pokedólares");
        }
        lblCoste.setText("Coste: 800");
        lblPokedolares.setText("Pokedólares: " + Entrenador.miEntrenador.getPokedollar());
    }

    // MÉTODO PARA REALIZAR LA CRIANZA ENTRE DOS POKÉMON
    public void crianza() throws IOException {

        if (imageViewPokemon1.getImage() == null || imageViewPokemon2.getImage() == null) {
            lblMensaje.setText("Elige 2 pokemones para continuar");
        } else {
            vaciarSeleccionados();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VentanaEmergenteAsignarNombrePokemon.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 500, 250);
            Stage stage2 = new Stage();
            stage2.setResizable(false);
            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.setScene(scene);
            stage2.showAndWait();
            actualizarDinero();
            enviarPokemonesAImage();
            Entrenador.miEntrenador.getCaja().add(Entrenador.miEntrenador.criar(seleccionados));
            actualizarDinero();
        }

    }

    public void enviarPokemonesAImage() {
        for (int i = 0; i < Entrenador.miEntrenador.getEquipoPrincipal().size(); i++) {
            if (imageViewPokemon1.getImage() == Entrenador.miEntrenador.getEquipoPrincipal().get(i).getImage() ) {
                seleccionados[0] = Entrenador.miEntrenador.getEquipoPrincipal().get(i);
            }
            if(imageViewPokemon2.getImage() == Entrenador.miEntrenador.getEquipoPrincipal().get(i).getImage()){
                seleccionados[1] = Entrenador.miEntrenador.getEquipoPrincipal().get(i);
            }

        }
    }
    public void vaciarSeleccionados(){
        for(int i = 0; i < seleccionados.length; i++){
            seleccionados[i] = null;
        }
    }

    public void mostrarImg() {
        int contador = 0;
        for (int i = 0; i < Entrenador.miEntrenador.getEquipoPrincipal().size(); i++) {
            if (botones.get(i).isSelected()) {
                contador++;
                if (contador == 1 && botones.get(i).getText() == Entrenador.miEntrenador.getEquipoPrincipal().get(i).getNombre()) {
                    imageViewPokemon1.setImage(Entrenador.miEntrenador.getEquipoPrincipal().get(i).getImage());
                    lblPokemon1.setText(Entrenador.miEntrenador.getEquipoPrincipal().get(i).getNombre());

                } else if (contador == 2 && botones.get(i).getText() == Entrenador.miEntrenador.getEquipoPrincipal().get(i).getNombre()) {
                    imageViewPokemon2.setImage(Entrenador.miEntrenador.getEquipoPrincipal().get(i).getImage());
                    lblPokemon2.setText(Entrenador.miEntrenador.getEquipoPrincipal().get(i).getNombre());
                }
            }

        }
    }

}
