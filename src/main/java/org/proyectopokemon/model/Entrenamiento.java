package org.proyectopokemon.model;


public class Entrenamiento {

    private int costeEntrenamiento;
    private Pokemon pokemonElegido;

    /**
     * CONSTRUCTOR VACÍO DE ENTRENAMIENTO
     */

    public Entrenamiento() {
        pokemonElegido = Entrenador.miEntrenador.getEquipoPrincipal().get(0);
    }

    public Pokemon getPokemonElegido() {
        return pokemonElegido;
    }

    public void setPokemonElegido(Pokemon pokemonElegido) {
        this.pokemonElegido = pokemonElegido;
    }

    /**
     * MÉTODO PARA APLICAR EL PRIMER ENTRENAMIENTO A UN POKEMON
     */
    public void aplicarEntPesado(){
        this.costeEntrenamiento = pokemonElegido.getNivel() * 20;
        pokemonElegido.setDefensa(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getDefensa() + 5);
        pokemonElegido.setDefensaEsp(pokemonElegido.getDefensaEsp() + 5);
        pokemonElegido.setVitalidad(pokemonElegido.getVitalidad() + 5);
        Entrenador.miEntrenador.setPokedollar(Entrenador.miEntrenador.getPokedollar() - costeEntrenamiento);
    }

    /**
     * MÉTODO PARA APLICAR EL SEGUNDO ENTRENAMIENTO A UN POKEMON
     */
    public void aplicarEntFurioso(){
        this.costeEntrenamiento = pokemonElegido.getNivel() * 30;
        pokemonElegido.setAtaque(pokemonElegido.getAtaque() + 5);
        pokemonElegido.setAtaqueEsp(pokemonElegido.getAtaqueEsp() + 5);
        pokemonElegido.setVelocidad(pokemonElegido.getVelocidad() + 5);
        Entrenador.miEntrenador.setPokedollar(Entrenador.miEntrenador.getPokedollar() - costeEntrenamiento);
    }

    /**
     * MÉTODO PARA APLICAR EL TERCER ENTRENAMIENTO A UN POKEMON
     */
    public void aplicarEntFuncional(){
        this.costeEntrenamiento = pokemonElegido.getNivel() * 40;
        pokemonElegido.setVelocidad(pokemonElegido.getVelocidad() + 5);
        pokemonElegido.setAtaque(pokemonElegido.getAtaque() + 5);
        pokemonElegido.setDefensa(pokemonElegido.getDefensa() + 5);
        pokemonElegido.setVitalidad(pokemonElegido.getVitalidad() + 5);
        Entrenador.miEntrenador.setPokedollar(Entrenador.miEntrenador.getPokedollar() - costeEntrenamiento);
    }

    /**
     * MÉTODO PARA APLICAR EL CUARTO ENTRENAMIENTO A UN POKEMON
     */
    public void aplicarEntOnirico(){
        this.costeEntrenamiento = pokemonElegido.getNivel() * 40;
        pokemonElegido.setVelocidad(pokemonElegido.getVelocidad() + 5);
        pokemonElegido.setAtaqueEsp(pokemonElegido.getAtaqueEsp() + 5);
        pokemonElegido.setDefensaEsp(pokemonElegido.getDefensaEsp() + 5);
        pokemonElegido.setVitalidad(pokemonElegido.getVitalidad() + 5);
        Entrenador.miEntrenador.setPokedollar(Entrenador.miEntrenador.getPokedollar() - costeEntrenamiento);
    }



}
