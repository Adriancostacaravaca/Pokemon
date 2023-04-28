module Pokemon {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.media;
    requires java.sql;
    requires pokeapi;

    opens org.proyectopokemon.model;
    opens org.proyectopokemon.controller;

}