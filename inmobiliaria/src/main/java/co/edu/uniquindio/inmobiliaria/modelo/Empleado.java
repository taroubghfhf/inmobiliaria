package co.edu.uniquindio.inmobiliaria.modelo;

import co.edu.uniquindio.inmobiliaria.utilidad.Conexion;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

@Getter
@Setter
public class Empleado extends Persona {
    private Usuario usuario;

    public Empleado(String nombre, Integer documento, String celular, Usuario usuario) {
        super(nombre, documento, celular);
        this.usuario = usuario;
    }

}
