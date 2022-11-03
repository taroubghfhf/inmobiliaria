package co.edu.uniquindio.inmobiliaria.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {

    private String correo;
    private String clave;
    private String fraseSeguridad;
    private boolean estado;

    public Usuario(String correo, String clave, String fraseSeguridad, boolean estado) {
        this.correo = correo;
        this.clave = clave;
        this.fraseSeguridad = fraseSeguridad;
        this.estado = estado;
    }
}
