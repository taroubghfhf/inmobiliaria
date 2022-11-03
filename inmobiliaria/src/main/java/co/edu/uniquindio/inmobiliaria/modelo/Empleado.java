package co.edu.uniquindio.inmobiliaria.modelo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Empleado extends Persona {

    private List<Propiedad> propedades;
    private List<Propietario> propietarios;
    private List<Cliente> clientes;
    private Usuario usuario;

    public Empleado(String nombre, String documeto, String celular, List<Propiedad> propedades, List<Propietario> propietarios, List<Cliente> clientes, Usuario usuario) {
        super(nombre, documeto, celular);
        this.propedades = propedades;
        this.propietarios = propietarios;
        this.clientes = clientes;
        this.usuario = usuario;
    }

    public Empleado(String nombre, String documeto, String celular) {
        super(nombre, documeto, celular);
    }
}
