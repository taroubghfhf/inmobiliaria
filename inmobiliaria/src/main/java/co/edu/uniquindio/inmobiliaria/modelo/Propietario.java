package co.edu.uniquindio.inmobiliaria.modelo;

import co.edu.uniquindio.inmobiliaria.utilidad.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Propietario extends Persona{
    public Propietario(String nombre, Integer documento, String celular) {
        super(nombre, documento, celular);
    }

}
