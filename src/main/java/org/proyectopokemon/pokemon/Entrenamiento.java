package org.proyectopokemon.pokemon;

/**
 * CLASE ENTRENAMIENTO DONDE CREAREMOS CUALQUIER METODO QUE REQUIERA LA INTERVENCION DE ESTA CLASE
 */
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
        pokemonElegido.setDefensa(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getDefensa() + 5f);
        pokemonElegido.setDefensaEsp(pokemonElegido.getDefensaEsp() + 5f);
        pokemonElegido.setVitalidad(pokemonElegido.getVitalidad() + 5f);
        Entrenador.miEntrenador.setPokedollar(Entrenador.miEntrenador.getPokedollar() - costeEntrenamiento);
    }

    /**
     * MÉTODO PARA APLICAR EL SEGUNDO ENTRENAMIENTO A UN POKEMON
     */
    public void aplicarEntFurioso(){
        this.costeEntrenamiento = pokemonElegido.getNivel() * 30;
        pokemonElegido.setAtaque(pokemonElegido.getAtaque() + 5f);
        pokemonElegido.setAtaqueEsp(pokemonElegido.getAtaqueEsp() + 5f);
        pokemonElegido.setVelocidad(pokemonElegido.getVelocidad() + 5f);
        Entrenador.miEntrenador.setPokedollar(Entrenador.miEntrenador.getPokedollar() - costeEntrenamiento);
    }

    /**
     * MÉTODO PARA APLICAR EL TERCER ENTRENAMIENTO A UN POKEMON
     */
    public void aplicarEntFuncional(){
        this.costeEntrenamiento = pokemonElegido.getNivel() * 40;
        pokemonElegido.setVelocidad(pokemonElegido.getVelocidad() + 5f);
        pokemonElegido.setAtaque(pokemonElegido.getAtaque() + 5f);
        pokemonElegido.setDefensa(pokemonElegido.getDefensa() + 5f);
        pokemonElegido.setVitalidad(pokemonElegido.getVitalidad() + 5f);
        Entrenador.miEntrenador.setPokedollar(Entrenador.miEntrenador.getPokedollar() - costeEntrenamiento);
    }

    /**
     * MÉTODO PARA APLICAR EL CUARTO ENTRENAMIENTO A UN POKEMON
     */
    public void aplicarEntOnirico(){
        this.costeEntrenamiento = pokemonElegido.getNivel() * 40;
        pokemonElegido.setVelocidad(pokemonElegido.getVelocidad() + 5f);
        pokemonElegido.setAtaqueEsp(pokemonElegido.getAtaqueEsp() + 5f);
        pokemonElegido.setDefensaEsp(pokemonElegido.getDefensaEsp() + 5f);
        pokemonElegido.setVitalidad(pokemonElegido.getVitalidad() + 5f);
        Entrenador.miEntrenador.setPokedollar(Entrenador.miEntrenador.getPokedollar() - costeEntrenamiento);
    }



}
