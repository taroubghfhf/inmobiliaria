package co.edu.uniquindio.inmobiliaria.controlador;

import co.edu.uniquindio.inmobiliaria.modelo.Cliente;
import co.edu.uniquindio.inmobiliaria.modelo.Propiedad;
import co.edu.uniquindio.inmobiliaria.modelo.Propietario;

import java.util.Optional;

public class EmpleadoControlador {

    public boolean crearPropietario(Propietario propietarioNuevo){
        Optional<Propietario> propietario = buscarPropietario(propietarioNuevo.getDocumeto());
        if(propietario.isPresent()){
            throw new RuntimeException("El propietario ya existe");
        }
        Datos.getIntancia().propietarios.add(propietarioNuevo);
        return true;
    }

    public Optional<Propietario> buscarPropietario(String identificacion){
        return Datos.getIntancia().propietarios.stream()
                .filter(propietario -> propietario.getDocumeto().equals(identificacion)).findFirst();
    }

    public boolean registrarCliente(Cliente clienteNuevo){
        Optional<Cliente> cliente = buscarCliente(clienteNuevo.getDocumeto());
        if(cliente.isPresent()){
            throw new RuntimeException("El cliente ya existe");
        }
        Datos.getIntancia().clientes.add(clienteNuevo);
        return true;
    }

    public Optional<Cliente> buscarCliente(String identificacion){
        return Datos.getIntancia().clientes.stream()
                .filter(cliente -> cliente.getDocumeto().equals(identificacion)).findFirst();
    }

    public void registrarPropiedad(Propiedad propiedad){

    }


}
