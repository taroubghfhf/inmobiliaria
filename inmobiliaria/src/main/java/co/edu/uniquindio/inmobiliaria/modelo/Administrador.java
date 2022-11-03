package co.edu.uniquindio.inmobiliaria.modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Administrador extends Persona{

    private List<Empleado> empleados;
    private Usuario usuaro;

    public Administrador(String nombre, String documeto, String celular,
                         List<Empleado> empleados, Usuario usuaro) {
        super(nombre, documeto, celular);
        this.empleados = empleados;
        this.usuaro = usuaro;
    }
}
