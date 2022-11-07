package co.edu.uniquindio.inmobiliaria.modelo;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import co.edu.uniquindio.inmobiliaria.utilidad.Conexion;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PropiedadTest {

    @Test
    void registrarPropiedad() {
        Usuario empleUser = new Usuario("emple1@inmo.com", "password", "frase_emple", true);
        Empleado empleado = new Empleado("empleado1", 1, "300", empleUser);
        empleado.registrarEmpleado();
        DisposicionPropiedad dp = DisposicionPropiedad.ALQUILER;
        TipoArea t = TipoArea.M2;
        LocalDateTime fecha = LocalDateTime.now();
        Propiedad p = new Propiedad("Calle 123", true, 5000.0, empleado, fecha, dp, 20.5f, t);
        assertTrue(p.registrarPropiedad());
    }

    @Test
    void registrarCasa() {
        Usuario empleUser = new Usuario("emple1@inmo.com", "password", "frase_emple", true);
        Empleado empleado = new Empleado("empleado1", 1, "300", empleUser);
        DisposicionPropiedad dp = DisposicionPropiedad.VENTA;
        TipoArea t = TipoArea.M2;
        LocalDateTime fecha = LocalDateTime.now();
        Apartamento a = new Apartamento("Calle 123", true, 5000.0, empleado, fecha, dp, 20.5f, t, 2, 2, "material", true, true, 3, 50f, 1);
        Casa c = new Casa("Calle 123", true, 5000.0, empleado, fecha, dp, 20.5f, t, 2, 2, "material");
        assertTrue(a.registrarApartamento());
    }

    @Test
    void alquilarPropiedad() {
        Usuario empleUser = new Usuario("emple1@inmo.com", "password", "frase_emple", true);
        Empleado empleado = new Empleado("empleado1", 1, "300", empleUser);
        Cliente cliente = new Cliente("cliente1", 1, "300");
        cliente.registrarCliente();
        DisposicionPropiedad dp = DisposicionPropiedad.ALQUILER;
        TipoArea t = TipoArea.M2;
        LocalDateTime fecha = LocalDateTime.now();
        Propiedad p = new Propiedad("Calle 123", false, 5000.0, empleado, fecha, dp, 20.5f, t);
        p.setCliente(cliente);
        p.setFechaModificacion(LocalDateTime.now());
        int id = p.getIdentificador();
        assertTrue(p.alquilarPropiedad(id));
    }

    @Test
    void venderPropiedad() {
        Usuario empleUser = new Usuario("emple1@inmo.com", "password", "frase_emple", true);
        Empleado empleado = new Empleado("empleado1", 1, "300", empleUser);
        Cliente cliente = new Cliente("cliente1", 1, "300");
        Propietario propietario = new Propietario("propietario1", 1, "300");
        propietario.registrarPropietario();
        DisposicionPropiedad dp = DisposicionPropiedad.VENTA;
        TipoArea t = TipoArea.M2;
        LocalDateTime fecha = LocalDateTime.now();
        Propiedad p = new Propiedad("Calle 123", false, 5000.0, empleado, fecha, dp, 20.5f, t);
        p.setCliente(cliente);
        p.setPropietario(propietario);
        p.setFechaModificacion(LocalDateTime.now());
        int id = p.getIdentificador();
        assertTrue(p.venderPropiedad(id));
    }

    @Test
    void retirarPropiedad() {

        Usuario empleUser = new Usuario("emple1@inmo.com", "password", "frase_emple", true);
        Empleado empleado = new Empleado("empleado1", 1, "300", empleUser);
        DisposicionPropiedad dp = DisposicionPropiedad.ALQUILER;
        TipoArea t = TipoArea.M2;
        LocalDateTime fecha = LocalDateTime.now();
        Propiedad p = new Propiedad("Calle 123", true, 5000.0, empleado, fecha, dp, 20.5f, t);
        p.registrarPropiedad();
        assertTrue(p.retirarPropiedad(p.getIdentificador()));
    }

    @Test
    void consultarDisponibilidadPropiedadTrue() {
        Usuario empleUser = new Usuario("emple1@inmo.com", "password", "frase_emple", true);
        Empleado empleado = new Empleado("empleado1", 1, "300", empleUser);
        DisposicionPropiedad dp = DisposicionPropiedad.ALQUILER;
        TipoArea t = TipoArea.M2;
        LocalDateTime fecha = LocalDateTime.now();
        Propiedad p = new Propiedad("Calle 123", true, 5000.0, empleado, fecha, dp, 20.5f, t);
        assertTrue(p.consultarDisponibilidadPropiedad(p.getIdentificador()));
    }

    @Test
    void consultarDisponibilidadPropiedadFalse() {
        Usuario empleUser = new Usuario("emple1@inmo.com", "password", "frase_emple", true);
        Empleado empleado = new Empleado("empleado1", 1, "300", empleUser);
        DisposicionPropiedad dp = DisposicionPropiedad.ALQUILER;
        TipoArea t = TipoArea.M2;
        LocalDateTime fecha = LocalDateTime.now();
        Propiedad p = new Propiedad("Calle 123", false, 5000.0, empleado, fecha, dp, 20.5f, t);
        assertFalse(p.consultarDisponibilidadPropiedad(p.getIdentificador()));
    }

    @Test
    void consultarPropiedad() {
        Usuario empleUser = new Usuario("emple1@inmo.com", "password", "frase_emple", true);
        Empleado empleado = new Empleado("empleado1", 1, "300", empleUser);
        DisposicionPropiedad dp = DisposicionPropiedad.ALQUILER;
        TipoArea t = TipoArea.M2;
        LocalDateTime fecha = LocalDateTime.now();
        Propiedad p = new Propiedad("Calle 123", true, 5000.0, empleado, fecha, dp, 20.5f, t);
        assertEquals(1, p.consultarPropiedad(p.getIdentificador()));
    }
}