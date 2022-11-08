package co.edu.uniquindio.inmobiliaria.modelo;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import co.edu.uniquindio.inmobiliaria.utilidad.Conexion;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PropiedadTest {

    @Test
    void registrarEmpleado() {
        Usuario adminUser = new Usuario("admin", "clave", "frase", true);
        Administrador admin = new Administrador("admin", 1, "300", adminUser);
        Usuario empleUsuario = new Usuario("emple1@inmo.com", "clave", "frase", true);
        Empleado empleado = new Empleado("emple1", 1, "300", empleUsuario);
        assertTrue(admin.registrarEmpleado(empleado));
    }

    @Test
    void registrarCliente() {
        Usuario empleUser = new Usuario("emple1@inmo.com", "password", "frase_emple", true);
        Empleado empleado = new Empleado("empleado1", 1, "300", empleUser);
        Cliente cliente = new Cliente("cliente1", 1, "300");
        empleado.registrarCliente(cliente);
    }

    @Test
    void registrarPropietario() {
        Usuario empleUser = new Usuario("emple1@inmo.com", "password", "frase_emple", true);
        Empleado empleado = new Empleado("empleado1", 1, "300", empleUser);
        Cliente cliente = new Cliente("cliente1", 1, "300");
        Propietario propietario = new Propietario("propietario1", 1, "300");
        empleado.registrarPropietario(propietario);
    }

    @Test
    void registrarApartamento() {
        Usuario empleUser = new Usuario("emple1@inmo.com", "password", "frase_emple", true);
        Empleado empleado = new Empleado("empleado1", 1, "300", empleUser);
        DisposicionPropiedad dp = DisposicionPropiedad.VENTA;
        TipoArea t = TipoArea.M2;
        LocalDateTime fecha = LocalDateTime.now();
        Apartamento a = new Apartamento("apartamento1", "Calle 123", true, 5000.0, empleado, fecha, dp, 20.5f, t, 2, 2, "material", true, true, 3, 50f, 1);
        assertTrue(a.registrarApartamento());
    }

    @Test
    void registrarCasa() {
        Usuario empleUser = new Usuario("emple1@inmo.com", "password", "frase_emple", true);
        Empleado empleado = new Empleado("empleado1", 1, "300", empleUser);
        DisposicionPropiedad dp = DisposicionPropiedad.VENTA;
        TipoArea t = TipoArea.M2;
        LocalDateTime fecha = LocalDateTime.now();
        Casa c = new Casa("casa1", "Calle 123", true, 5000.0, empleado, fecha, dp, 20.5f, t, 2, 2, 2, "material casa");
        assertTrue(c.registrarCasa());
    }

    @Test
    void registrarChalet() {
        Usuario empleUser = new Usuario("emple1@inmo.com", "password", "frase_emple", true);
        Empleado empleado = new Empleado("empleado1", 1, "300", empleUser);
        DisposicionPropiedad dp = DisposicionPropiedad.VENTA;
        TipoArea t = TipoArea.M2;
        LocalDateTime fecha = LocalDateTime.now();
        Chalet c = new Chalet("chalet1", "Calle 123", true, 5000.0, empleado, fecha, dp, 20.5f, t, 2, 2, 2, "material chalet", false, true, true, true, true, false);
        assertTrue(c.registrarChalet());
    }

    @Test
    void registrarBodega() {
        Usuario empleUser = new Usuario("emple1@inmo.com", "password", "frase_emple", true);
        Empleado empleado = new Empleado("empleado1", 1, "300", empleUser);
        DisposicionPropiedad dp = DisposicionPropiedad.ALQUILER;
        TipoArea t = TipoArea.M2;
        TipoBodegaLote tb = TipoBodegaLote.URBANA;
        LocalDateTime fecha = LocalDateTime.now();
        Bodega b = new Bodega("bodega1", "Calle 123", true, 5000.0, empleado, fecha, dp, 20.5f, t, tb);
        assertTrue(b.registrarBodega());
    }

    @Test
    void registrarEdificio() {
        Usuario empleUser = new Usuario("emple1@inmo.com", "password", "frase_emple", true);
        Empleado empleado = new Empleado("empleado1", 1, "300", empleUser);
        DisposicionPropiedad dp = DisposicionPropiedad.VENTA;
        TipoArea t = TipoArea.M2;
        LocalDateTime fecha = LocalDateTime.now();
        Edificio e = new Edificio("edificio1", "Calle 123", true, 5000.0, empleado, fecha, dp, 20.5f, t, 7);
        assertTrue(e.registrarEdificio());
    }

    @Test
    void registrarLote() {
        Usuario empleUser = new Usuario("emple1@inmo.com", "password", "frase_emple", true);
        Empleado empleado = new Empleado("empleado1", 1, "300", empleUser);
        DisposicionPropiedad dp = DisposicionPropiedad.ALQUILER;
        TipoBodegaLote tb = TipoBodegaLote.URBANA;
        TipoArea t = TipoArea.M2;
        LocalDateTime fecha = LocalDateTime.now();
        Lote l = new Lote("lote1", "Calle 123", true, 5000.0, empleado, fecha, dp, 20.5f, t, tb);
        assertTrue(l.registrarLote());
    }

    @Test
    void registrarParqueadero() {
        Usuario empleUser = new Usuario("emple1@inmo.com", "password", "frase_emple", true);
        Empleado empleado = new Empleado("empleado1", 1, "300", empleUser);
        DisposicionPropiedad dp = DisposicionPropiedad.VENTA;
        TipoArea t = TipoArea.M2;
        LocalDateTime fecha = LocalDateTime.now();
        Parqueadero p = new Parqueadero("parqueadero1", "Calle 123", true, 5000.0, empleado, fecha, dp, 20.5f, t);
        assertTrue(p.registrarParqueadero());
    }

    @Test
    void alquilarPropiedad() {
        Usuario empleUser = new Usuario("emple1@inmo.com", "password", "frase_emple", true);
        Empleado empleado = new Empleado("empleado1", 1, "300", empleUser);
        Cliente cliente = new Cliente("cliente1", 1, "300");
        DisposicionPropiedad dp = DisposicionPropiedad.ALQUILER;
        TipoBodegaLote tb = TipoBodegaLote.URBANA;
        TipoArea t = TipoArea.M2;
        LocalDateTime fecha = LocalDateTime.now();
        Lote l = new Lote("lote1", "Calle 123", true, 5000.0, empleado, fecha, dp, 20.5f, t, tb);
        l.setCliente(cliente);
        l.setDisponible(false);
        l.setFechaModificacion(LocalDateTime.now());
        int consul = l.consultarPropiedad(l.getIdentificador(), "id_lote");
        boolean dispo = l.consultarDisponibilidadPropiedad(l.getIdentificador(), "id_lote");
        if(consul > 0 && dispo) assertTrue(l.alquilarPropiedad(l.getIdentificador(), "id_lote"));
    }

    @Test
    void venderPropiedad() {
        Usuario empleUser = new Usuario("emple1@inmo.com", "password", "frase_emple", true);
        Empleado empleado = new Empleado("empleado1", 1, "300", empleUser);
        Cliente cliente = new Cliente("cliente1", 1, "300");
        Propietario propietario = new Propietario("propietario1", 1, "300");
        DisposicionPropiedad dp = DisposicionPropiedad.VENTA;
        TipoArea t = TipoArea.M2;
        LocalDateTime fecha = LocalDateTime.now();
        Edificio e = new Edificio("edificio1", "Calle 123", true, 5000.0, empleado, fecha, dp, 20.5f, t, 7);
        e.setCliente(cliente);
        e.setPropietario(propietario);
        e.setFechaModificacion(LocalDateTime.now());
        String id = e.getIdentificador();
        int consul = e.consultarPropiedad(e.getIdentificador(), "id_lote");
        boolean dispo = e.consultarDisponibilidadPropiedad(e.getIdentificador(), "id_lote");
        if(consul > 0 && dispo) assertTrue(e.venderPropiedad(id, "id_edificio"));
    }

    @Test
    void retirarPropiedad() {

        Usuario empleUser = new Usuario("emple1@inmo.com", "password", "frase_emple", true);
        Empleado empleado = new Empleado("empleado1", 1, "300", empleUser);
        DisposicionPropiedad dp = DisposicionPropiedad.ALQUILER;
        TipoArea t = TipoArea.M2;
        LocalDateTime fecha = LocalDateTime.now();
        Chalet c = new Chalet("chalet1", "Calle 123", true, 5000.0, empleado, fecha, dp, 20.5f, t, 2, 2, 2, "material chalet", false, true, true, true, true, false);
        c.setFechaModificacion(LocalDateTime.now());
        boolean dispo = c.consultarDisponibilidadPropiedad(c.getIdentificador(), "id_lote");
        if(!dispo) assertTrue(c.retirarPropiedad(c.getIdentificador(), "id_vivienda"));
    }

    @Test
    void consultarDisponibilidadPropiedad() {
        Usuario empleUser = new Usuario("emple1@inmo.com", "password", "frase_emple", true);
        Empleado empleado = new Empleado("empleado1", 1, "300", empleUser);
        DisposicionPropiedad dp = DisposicionPropiedad.ALQUILER;
        TipoArea t = TipoArea.M2;
        LocalDateTime fecha = LocalDateTime.now();
        Casa c = new Casa("casa1", "Calle 123", true, 5000.0, empleado, fecha, dp, 20.5f, t, 2, 2, 2, "material casa");
        assertTrue(c.consultarDisponibilidadPropiedad(c.getIdentificador(), "id_vivienda"));
    }

    @Test
    void consultarPropiedad() {
        Usuario empleUser = new Usuario("emple1@inmo.com", "password", "frase_emple", true);
        Empleado empleado = new Empleado("empleado1", 1, "300", empleUser);
        DisposicionPropiedad dp = DisposicionPropiedad.ALQUILER;
        TipoArea t = TipoArea.M2;
        LocalDateTime fecha = LocalDateTime.now();
        Casa c = new Casa("casa1", "Calle 123", true, 5000.0, empleado, fecha, dp, 20.5f, t, 2, 2, 2, "material casa");
        assertEquals(1, c.consultarPropiedad(c.getIdentificador(), "id_vivienda"));
    }
}