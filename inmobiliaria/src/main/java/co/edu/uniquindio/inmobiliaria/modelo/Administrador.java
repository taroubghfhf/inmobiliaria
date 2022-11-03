package co.edu.uniquindio.inmobiliaria.modelo;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Administrador extends Persona{

    private Usuario usuaro;

    public Administrador(String nombre, String documeto, String celular,
                         Usuario usuaro) {
        super(nombre, documeto, celular);
        this.usuaro = usuaro;
    }
}
