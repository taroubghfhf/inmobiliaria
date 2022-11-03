package co.edu.uniquindio.inmobiliaria.controlador;

import co.edu.uniquindio.inmobiliaria.modelo.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Datos {

    public List<Usuario> usuarios;
    public List<Empleado> empleados;
    public List<ReportePropiedad> reportes;
    public List<Propietario> propietarios;
    public List<Cliente> clientes;
    public Administrador administrador;

    private static Datos intancia;


    private Datos(){
        cargarDatosUsuario();
        cargarAdministrador();
        cargarEmpleado();
        cargarPropietarios();
        cargarClientes();
    }

    public void cargarDatosUsuario(){
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("jdsanchez@gmail.com","123","Un dia",true));
        usuarios.add(new Usuario("jdperez@gmail.com","1234","Un perro",true));
        usuarios.add(new Usuario("cplopez@gmail.com","12345","Un gato",false));
        usuarios.add(new Usuario("maflorez@gmail.com","123456","Un pez",true));
        usuarios.add(new Usuario("pedro@gmail.com","predro123","admin",true));
    }

    public void cargarAdministrador(){
        administrador = new Administrador("pedro","10235486","326468",usuarios.get(4));
    }
    public void cargarEmpleado(){
        empleados = new ArrayList<>();
        empleados.add(new Empleado("juan","123","123", usuarios.get(2)));
    }

    public void cargarReportes(){
        reportes = new ArrayList<>();


    }
    public void cargarPropietarios(){
        propietarios = new ArrayList<>();
        propietarios.add(new Propietario("propietario1","1111","1111"));
        propietarios.add(new Propietario("propietario2","2222","2222"));
        propietarios.add(new Propietario("propietario3","3333","3333"));
    }

    public void cargarClientes(){
        clientes = new ArrayList<>();
        clientes.add(new Cliente("cliente1","1111","1111"));
        clientes.add(new Cliente("cliente2","2222","2222"));
        clientes.add(new Cliente("cliente3","3333","3333"));
    }



    public static Datos getIntancia(){
        if (intancia == null) {
            intancia = new Datos();
        }
        return intancia;
    }

}
