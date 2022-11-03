package co.edu.uniquindio.inmobiliaria.controlador;
import co.edu.uniquindio.inmobiliaria.modelo.Cliente;
import co.edu.uniquindio.inmobiliaria.modelo.Propietario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmpleadoControladorTest {

    @Test
    public void registrarPropietarioExitoso(){
        EmpleadoControlador empleadoControlador = new EmpleadoControlador();
        Propietario propietario = new Propietario("administradorTest","1094584","311481564");
        boolean respuesta = empleadoControlador.crearPropietario(propietario);
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void registrarPropietarioFallido(){
        EmpleadoControlador empleadoControlador = new EmpleadoControlador();
        Propietario propietario = new Propietario("administradorTest","1111","311481564");
        Exception exception = Assertions.assertThrows(RuntimeException.class,
                () -> empleadoControlador.crearPropietario(propietario));
        String expectedMessage = "El propietario ya existe";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void registrarClienteExitoso(){
        EmpleadoControlador empleadoControlador = new EmpleadoControlador();
        Cliente cliente = new Cliente("clienteTest","1094584","311481564");
        boolean respuesta = empleadoControlador.registrarCliente(cliente);
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void registrarClienteFallido(){
        EmpleadoControlador empleadoControlador = new EmpleadoControlador();
        Cliente cliente = new Cliente("clienteTest","1111","311481564");
        Exception exception = Assertions.assertThrows(RuntimeException.class,
                () -> empleadoControlador.registrarCliente(cliente));
        String expectedMessage = "El cliente ya existe";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}
