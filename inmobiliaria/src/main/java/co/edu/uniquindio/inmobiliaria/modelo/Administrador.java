package co.edu.uniquindio.inmobiliaria.modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Administrador extends Persona{

    private List<Empleado> empleados;
    private Usuario usuario;

    public Administrador(String nombre, Integer documento, String celular, Usuario usuario) {
        super(nombre, documento, celular);
        this.usuario = usuario;
        this.usuario.registrarUsuario(1);
    } 
}
