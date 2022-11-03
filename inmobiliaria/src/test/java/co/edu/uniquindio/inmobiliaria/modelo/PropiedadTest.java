package co.edu.uniquindio.inmobiliaria.modelo;

import org.junit.jupiter.api.Test;
import co.edu.uniquindio.inmobiliaria.utilidad.Conexion;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PropiedadTest {

    @Test
    void registrarPropiedad() {
        Empleado empleado = new Empleado("empleado1", "1", "300");
        DisposicionPropiedad dp = DisposicionPropiedad.ALQUILER;
        TipoArea t = TipoArea.M2;
        LocalDateTime fecha = LocalDateTime.now();
        Propiedad p = new Propiedad("1", "Calle 123", true, 5000.0, empleado, fecha, dp, 20.5f, t);
        assertTrue(p.registrarPropiedad());
    }

    @Test
    void alquilarPropiedad() {
        Empleado empleado = new Empleado("empleado1", "1", "300");
        Cliente cliente = new Cliente("cliente1", "1", "300");
        DisposicionPropiedad dp = DisposicionPropiedad.ALQUILER;
        TipoArea t = TipoArea.M2;
        LocalDateTime fecha = LocalDateTime.now();
        Propiedad p = new Propiedad("1", "Calle 123", true, 5000.0, empleado, fecha, dp, 20.5f, t);
        //p.registrarPropiedad();
        p.setFechaModificacion(LocalDateTime.now());
        assertTrue(p.alquilarPropiedad(p.getIdentificador()));
    }

    @Test
    void venderPropiedad() {
    }

    @Test
    void retirarPropiedad() {
    }

    @Test
    void consultarDisponibilidadPropiedad() {
    }

    @Test
    void consultarPropiedad() {
        Empleado empleado = new Empleado("empleado1", "1", "300");
        DisposicionPropiedad dp = DisposicionPropiedad.ALQUILER;
        TipoArea t = TipoArea.M2;
        LocalDateTime fecha = LocalDateTime.now();
        Propiedad p = new Propiedad("1", "Calle 123", true, 5000.0, empleado, fecha, dp, 20.5f, t);
        assertEquals(1, p.consultarPropiedad(p.getIdentificador()));
    }
}