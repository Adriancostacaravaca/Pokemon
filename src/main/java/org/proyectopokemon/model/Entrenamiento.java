package org.proyectopokemon.model;


public class Entrenamiento {

    private int costeEntrenamiento;

    public Entrenamiento() {

    }


    public void aplicarEntPesado(){
        this.costeEntrenamiento = Entrenador.miEntrenador.getEquipoPrincipal().get(0).getNivel() * 20;
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setDefensa(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getDefensa() + 5);
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setDefensaEsp(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getDefensaEsp() + 5);
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setVitalidad(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getVitalidad() + 5);
        Entrenador.miEntrenador.setPokedollar(Entrenador.miEntrenador.getPokedollar() - costeEntrenamiento);
    }
    public void aplicarEntFurioso(){
        this.costeEntrenamiento = Entrenador.miEntrenador.getEquipoPrincipal().get(0).getNivel() * 30;
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setAtaque(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getAtaque() + 5);
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setAtaqueEsp(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getAtaqueEsp() + 5);
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setVelocidad(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getVelocidad() + 5);
        Entrenador.miEntrenador.setPokedollar(Entrenador.miEntrenador.getPokedollar() - costeEntrenamiento);
    }
    public void aplicarEntFuncional(){
        this.costeEntrenamiento = Entrenador.miEntrenador.getEquipoPrincipal().get(0).getNivel() * 40;
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setVelocidad(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getVelocidad() + 5);
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setAtaque(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getAtaque() + 5);
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setDefensa(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getDefensa() + 5);
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setVitalidad(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getVitalidad() + 5);
        Entrenador.miEntrenador.setPokedollar(Entrenador.miEntrenador.getPokedollar() - costeEntrenamiento);
    }
    public void aplicarEntOnirico(){
        this.costeEntrenamiento = Entrenador.miEntrenador.getEquipoPrincipal().get(0).getNivel() * 40;
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setVelocidad(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getVelocidad() + 5);
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setAtaqueEsp(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getAtaqueEsp() + 5);
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setDefensaEsp(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getDefensaEsp() + 5);
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setVitalidad(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getVitalidad() + 5);
        Entrenador.miEntrenador.setPokedollar(Entrenador.miEntrenador.getPokedollar() - costeEntrenamiento);
    }

}
