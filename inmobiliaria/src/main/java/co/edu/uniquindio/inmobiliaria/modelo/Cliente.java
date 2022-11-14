package co.edu.uniquindio.inmobiliaria.modelo;


import co.edu.uniquindio.inmobiliaria.utilidad.Conexion;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

@Getter
@Setter
public class Cliente extends Persona {
    public Cliente(String nombre, Integer documento, String celular) {
        super(nombre, documento, celular);
    }

}
