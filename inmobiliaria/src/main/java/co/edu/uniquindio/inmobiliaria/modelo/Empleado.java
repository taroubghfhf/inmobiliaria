package co.edu.uniquindio.inmobiliaria.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Empleado extends Persona {

    private Usuario usuario;

    public Empleado(String nombre, String documeto, String celular, Usuario usuario) {
        super(nombre, documeto, celular);
        this.usuario = usuario;
    }

    public Empleado(String nombre, String documeto, String celular) {
        super(nombre, documeto, celular);
    }
}
