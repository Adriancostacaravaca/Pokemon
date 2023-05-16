module Pokemon {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.media;
    requires java.sql;

    opens org.proyectopokemon.pokemon;
    opens org.proyectopokemon.controller;
    opens org.proyectopokemon.enums;
    opens org.proyectopokemon.movements;
    opens org.proyectopokemon.logger;
    opens org.proyectopokemon.shop;

}