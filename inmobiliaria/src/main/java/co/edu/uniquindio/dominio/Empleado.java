package co.edu.uniquindio.dominio;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Empleado {

    private List<Propiedad> propedades;
    private List<Propietario> propietarios;
    private List<Cliente> clientes;


    public Empleado(List<Propiedad> propedades, List<Propietario> propietarios, List<Cliente> clientes) {
        this.propedades = propedades;
        this.propietarios = propietarios;
        this.clientes = clientes;
    }
}
