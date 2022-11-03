package co.edu.uniquindio.inmobiliaria.modelo;

import lombok.Getter;
import lombok.Setter;
import static co.edu.uniquindio.inmobiliaria.utilidad.Validador.validacionObligatoriedad;

@Getter
@Setter
public class Persona {
    private final static String NOMBRE_INVALIDO="Debe ingresar un nombre";

    private final static String DOCUMENTO_INVALIDO="Debe ingresar su numero de documento";
    private String nombre;
    private String documeto;
    private String celular;

    public Persona(String nombre, String documeto, String celular) {
        validacionObligatoriedad(nombre,NOMBRE_INVALIDO );
        validacionObligatoriedad(documeto,DOCUMENTO_INVALIDO);
        this.nombre = nombre;
        this.documeto = documeto;
        this.celular = celular;
    }
}
