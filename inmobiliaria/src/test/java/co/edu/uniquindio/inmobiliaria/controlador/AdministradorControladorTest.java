package co.edu.uniquindio.inmobiliaria.controlador;

import co.edu.uniquindio.inmobiliaria.modelo.Empleado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdministradorControladorTest {

    @Test
    public void registrarEmpleadoExitoso(){
        AdministradorControlador administradorControlador = new AdministradorControlador();
        Empleado empleado = new Empleado("monica","1094584","311481564"
                ,null,null,null,null);
        boolean respuesta = administradorControlador.agregarEmpleado(empleado);
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void registrarEmpleadoFallido(){
        AdministradorControlador administradorControlador = new AdministradorControlador();
        Empleado empleado = new Empleado("juan","123","123",
                null,null,null, null);
        Exception exception = Assertions.assertThrows(RuntimeException.class,
                () -> administradorControlador.agregarEmpleado(empleado));
        String expectedMessage = "El empleado ya existe";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void actualizarEmpleadoExitoso(){
        AdministradorControlador administradorControlador = new AdministradorControlador();
        Empleado empleadoActualizado = new Empleado("juan","123","3104587912",
                null,null,null, null);
        boolean respuesta = administradorControlador.actualizarEmpleado(empleadoActualizado);
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void actualizarEmpleadoFallido(){
        AdministradorControlador administradorControlador = new AdministradorControlador();
        Empleado empleado = new Empleado("juan","45687","123",
                null,null,null, null);
        Exception exception = Assertions.assertThrows(RuntimeException.class,
                () -> administradorControlador.actualizarEmpleado(empleado));
        String expectedMessage = "El empleado no existe";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }


    @Test
    public void bloquearEmpleadoExitoso(){
        AdministradorControlador administradorControlador = new AdministradorControlador();
        boolean respuesta = administradorControlador.bloquearCuentaEmpleado("123");
        Assertions.assertFalse(respuesta);
    }

    @Test
    public void bloquearEmpleadoFallido(){
        AdministradorControlador administradorControlador = new AdministradorControlador();
        Exception exception = Assertions.assertThrows(RuntimeException.class,
                () -> administradorControlador.bloquearCuentaEmpleado("888"));
        String expectedMessage = "El empleado no existe";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void activarEmpleadoExitoso(){
        AdministradorControlador administradorControlador = new AdministradorControlador();
        boolean respuesta = administradorControlador.desbloquearCuentaEmpleado("123");
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void activarEmpleadoFallido(){
        AdministradorControlador administradorControlador = new AdministradorControlador();
        Exception exception = Assertions.assertThrows(RuntimeException.class,
                () -> administradorControlador.desbloquearCuentaEmpleado("888"));
        String expectedMessage = "El empleado no existe";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}
