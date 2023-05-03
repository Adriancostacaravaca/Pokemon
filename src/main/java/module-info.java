module Pokemon {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.media;
    requires java.sql;

    opens org.proyectopokemon.model;
    opens org.proyectopokemon.controller;

}