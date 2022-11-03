package co.edu.uniquindio.inmobiliaria.controlador;

import co.edu.uniquindio.inmobiliaria.modelo.Administrador;
import co.edu.uniquindio.inmobiliaria.modelo.Empleado;
import co.edu.uniquindio.inmobiliaria.modelo.Usuario;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Datos {

    public List<Usuario> usuarios;
    public List<Empleado> empleados;
    public Administrador administrador;

    private static Datos intancia;


    private Datos(){
        cargarDatosUsuario();
        cargarAdministrador();
        cargarEmpleado();
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
        administrador = new Administrador("pedro","10235486","326468",null,usuarios.get(4));
    }
    public void cargarEmpleado(){
        empleados = new ArrayList<>();
        empleados.add(new Empleado("juan","123","123",null,null,null, usuarios.get(2)));
    }



    public static Datos getIntancia(){
        if (intancia == null) {
            intancia = new Datos();
        }
        return intancia;
    }

}
