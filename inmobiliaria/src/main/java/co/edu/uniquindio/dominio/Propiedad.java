package co.edu.uniquindio.dominio;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Propiedad {
    private String identificador;
    private String direccion;
    private Propietario propietario;
    private Boolean disponible;
    private Double precio;
    private Empleado empleado;
    private LocalDateTime fecha;
    private DisposicionPropiedad disposicionPropiedad;
    private Float valorArea;
    private Integer numeroPisos;
    private TipoArea area;
    private String tipoPropiedad = this.getClass().getSimpleName();

    public Propiedad(String identificador, String direccion, Propietario propietario, Boolean disponible, Double precio, Empleado empleado, LocalDateTime fecha, DisposicionPropiedad disposicionPropiedad, Float valorArea, Integer numeroPisos, TipoArea area, String tipoPropiedad) {
        this.identificador = identificador;
        this.direccion = direccion;
        this.propietario = propietario;
        this.disponible = disponible;
        this.precio = precio;
        this.empleado = empleado;
        this.fecha = fecha;
        this.disposicionPropiedad = disposicionPropiedad;
        this.valorArea = valorArea;
        this.numeroPisos = numeroPisos;
        this.area = area;
        this.tipoPropiedad = tipoPropiedad;
    }
}
