package co.edu.uniquindio.dominio;

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

    public String recuperarClave(String correo, String fraseSeguridad){
        if(correo.equals(correo) && fraseSeguridad.equals(fraseSeguridad)){
            return clave;
        }
        throw new RuntimeException("Datos invalidos, intente de nuevo!");
    }

}
