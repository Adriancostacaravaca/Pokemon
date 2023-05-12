package org.proyectopokemon.model;


public class Entrenamiento {

    public Entrenamiento() {

    }


    public void aplicarEntPesado(){
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setDefensa(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getDefensa() + 5);
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setDefensaEsp(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getDefensaEsp() + 5);
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setVitalidad(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getVitalidad() + 5);
    }
    public void aplicarEntFurioso(){
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setAtaque(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getAtaque() + 5);
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setAtaqueEsp(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getAtaqueEsp() + 5);
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setVelocidad(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getVelocidad() + 5);
    }
    public void aplicarEntFuncional(){
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setVelocidad(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getVelocidad() + 5);
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setAtaque(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getAtaque() + 5);
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setDefensa(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getDefensa() + 5);
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setVitalidad(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getVitalidad() + 5);
    }
    public void aplicarEntOnirico(){
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setVelocidad(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getVelocidad() + 5);
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setAtaqueEsp(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getAtaqueEsp() + 5);
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setDefensaEsp(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getDefensaEsp() + 5);
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setVitalidad(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getVitalidad() + 5);
    }

}
