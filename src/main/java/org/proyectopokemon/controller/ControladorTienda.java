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
import javafx.stage.Stage;
import org.proyectopokemon.controller.factories.TiendaCeldas;
import org.proyectopokemon.model.Entrenador;
import org.proyectopokemon.model.Objeto;

import java.io.IOException;
import java.util.Objects;

public class ControladorTienda {
    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    private Button btnVolver;
    @FXML
    private Button btnComprar;
    //Creamos una observanle list para que asi se pueda enlazar con nuestra listViwe
    ObservableList<Objeto> objetosTienda = FXCollections.observableArrayList();
    @FXML
    private ListView<Objeto> listaObjetos;
    private Entrenador entrenadorPrincipal = new Entrenador("Juan");
    @FXML
    private Label lblDinero;

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
    // ACTUALIZAMOS NUESTRO DINERO MEDIANTE UN MÉTODO
    public void actualizarDinero(){
        lblDinero.setText("Dinero: " + entrenadorPrincipal.getPokedollar());
    }
    // UTILIZAMOS INITIALIZE PARA EJECUTAR EL MÉTODO UNA VEZ ENTRAMOS EN LA ESCENA
    public void initialize() {
        objetosTienda.add(new Objeto("Pesa",0.2,0.2,250, "Aumenta el ataque y la defensa un 20%, pero disminuye su velocidad un 20%"));
        objetosTienda.add(new Objeto("Pluma",0.3,0.2,250, "Aumenta la velocidad un 30%, pero disminuye la defensa y la defensa\n" +
                "especial en un 20%"));
        objetosTienda.add(new Objeto("Chaleco",0.2,0.15,250,"Aumenta la defensa y la defensa especial un 20%, pero disminuye la\n" +
                "velocidad y el ataque un 15%."));
        objetosTienda.add(new Objeto("Baston",0.2,0.15,350,"Aumenta la estamina un 20%, pero disminuye en un 15% la velocidad."));
        objetosTienda.add(new Objeto("Pilas",0.5,0.3,300,"Aumenta la recuperación de estamina en un 50%, pero disminuye la defensa\n" +
                "especial un 30%."));
        listaObjetos.setItems(objetosTienda);
        //Con este metodo podemos personalizar la apariencia de las listas en este caso una listView
        listaObjetos.setCellFactory(new TiendaCeldas());

        //Este codigo habilita o desahabilita el boton comprar si se HA seleccionado o no un elemento de la lista

        listaObjetos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                btnComprar.setDisable(false);
            } else {
                btnComprar.setDisable(true);
            }
        });
        actualizarDinero();
    }
    @FXML
    public void comprar(){
            //guardamos el objeto seleccionado en una variable
            Objeto objetoSelect = listaObjetos.getSelectionModel().getSelectedItem();
            //Comprobamos que no sea nulo
            if (objetoSelect != null) {
                boolean compraHecha = entrenadorPrincipal.comprar(objetoSelect);
                //Si la compra ese verdadera actualizamos el dinero, ademas comprobamos si ya tenemos
                //el movimiento en la caja o no, si no es asi lo añadimos si no es asi se procede con la compra
                if(compraHecha){
                    actualizarDinero();
                    System.out.println("Compra hecha");
                    for(Objeto i : entrenadorPrincipal.getCajaObjetos()){
                        if(objetoSelect == i){
                            System.out.println("Ya tienes este objeto");
                        }else{
                            entrenadorPrincipal.getCajaObjetos().add(objetoSelect);
                        }
                    }
                }else{
                    System.out.println("Te falta dinero");
                }
            }

    }
}
