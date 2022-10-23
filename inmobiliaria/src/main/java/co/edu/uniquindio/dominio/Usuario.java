package co.edu.uniquindio.dominio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {

    private String correo;
    private String clave;
    private String fraseSeguridad;

    public Usuario(String correo, String clave, String fraseSeguridad) {
        this.correo = correo;
        this.clave = clave;
        this.fraseSeguridad = fraseSeguridad;
    }
}
