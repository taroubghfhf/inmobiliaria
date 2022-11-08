package co.edu.uniquindio.inmobiliaria.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdministradorTest {

    @Test
    void registrarEmpleado() {
        Usuario adminUser = new Usuario("admin", "clave", "frase", true);
        Administrador admin = new Administrador("admin", 1, "300", adminUser);
        Usuario empleUsuario = new Usuario("emple1@inmo.com", "clave", "frase", true);
        Empleado empleado = new Empleado("emple1", 1, "300", empleUsuario);
        assertTrue(admin.registrarEmpleado(empleado));
    }

    @Test
    void modificarEmpleado() {
        Usuario adminUser = new Usuario("admin", "clave", "frase", true);
        Administrador admin = new Administrador("admin", 1, "300", adminUser);
        Usuario empleUsuario = new Usuario("emple1@inmo.com", "clave", "frase", true);
        Empleado empleado = new Empleado("empleado1", 1, "300456", empleUsuario);
        assertTrue(admin.modificarEmpleado(empleado));
    }

    @Test
    void desactivarEmpleado() {
        Usuario adminUser = new Usuario("admin", "clave", "frase", true);
        Administrador admin = new Administrador("admin", 1, "300", adminUser);
        Usuario empleUsuario = new Usuario("emple1@inmo.com", "clave", "frase", true);
        Empleado empleado = new Empleado("empleado1", 1, "300456", empleUsuario);
        empleUsuario.setEstado(false);
        assertTrue(admin.desactivarEmpleado(empleado));
    }

    @Test
    void eliminarEmpleado() {
        Usuario adminUser = new Usuario("admin", "clave", "frase", true);
        Administrador admin = new Administrador("admin", 1, "300", adminUser);
        Usuario empleUsuario = new Usuario("emple1@inmo.com", "clave", "frase", true);
        Empleado empleado = new Empleado("empleado1", 1, "300456", empleUsuario);
        assertTrue(admin.eliminarEmpleado(empleado));
    }
}