package co.edu.uniquindio.dominio;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
public class Propiedad {
    private String identificador;
    private String direccion;
    private Propietario propietario;
    private Boolean disponible;
    private List<String> fotos;
    private Double precio;
    private Empleado empleado;
    private LocalDateTime fecha;
    private TipoPropiedad tipoPropiedad;

    public Propiedad(String identificador, String direccion, Propietario propietario, Boolean disponible,
                     List<String> fotos, Double precio, Empleado empleado, LocalDateTime fecha, TipoPropiedad tipoPropiedad) {
        this.identificador = identificador;
        this.direccion = direccion;
        this.propietario = propietario;
        this.disponible = disponible;
        this.fotos = fotos;
        this.precio = precio;
        this.empleado = empleado;
        this.fecha = fecha;
        this.tipoPropiedad = tipoPropiedad;
    }
}
