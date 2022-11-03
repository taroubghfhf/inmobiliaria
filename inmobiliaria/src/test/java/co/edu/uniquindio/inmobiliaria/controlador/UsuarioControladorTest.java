package co.edu.uniquindio.inmobiliaria.controlador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UsuarioControladorTest {

    @Test
    public void recuperarClaveCorreoInvalido(){
        UsuarioControlador usuarioControlador = new UsuarioControlador();
        Exception exception = Assertions.assertThrows(RuntimeException.class,
                () -> usuarioControlador.recuperarClave("maflorez@gmail.com","aa"));
        String expectedMessage = "Datos invalidos, intente de nuevo!";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void recuperarClaveFraseDeSeguridadInvalida(){
        UsuarioControlador usuarioControlador = new UsuarioControlador();
        Exception exception = Assertions.assertThrows(RuntimeException.class,
                () -> usuarioControlador.recuperarClave("maflo@gmail.com","Un pez"));
        String expectedMessage = "Datos invalidos, intente de nuevo!";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void recuperarClaveExitoso(){
        UsuarioControlador usuarioControlador = new UsuarioControlador();
        String clave = usuarioControlador.recuperarClave("maflorez@gmail.com","Un pez");
        Assertions.assertTrue(clave.contains("123456"));
    }
}
