package org.proyectopokemon.controller.factories;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import org.proyectopokemon.model.MovimientoAtaque;
import org.proyectopokemon.model.Objeto;

public class ElegirMovimientoCeldas implements Callback<ListView<MovimientoAtaque>, ListCell<MovimientoAtaque>> {

    @Override
    public ListCell<MovimientoAtaque> call(ListView<MovimientoAtaque> param) {
        return new ListCell<MovimientoAtaque>() {
            @Override
            protected void updateItem(MovimientoAtaque movimientoAtaque, boolean empty) {
                super.updateItem(movimientoAtaque, empty);
                if (empty || movimientoAtaque == null) {
                    setText(null);
                } else {
                    setText("Nombre: " + movimientoAtaque.getNombre() + "\n"
                            + "Potencia: " + movimientoAtaque.getPotencia() + "\n"
                            + "Tipo: " + movimientoAtaque.getTipo() + "\n");
                }
            }
        };
    }
}
