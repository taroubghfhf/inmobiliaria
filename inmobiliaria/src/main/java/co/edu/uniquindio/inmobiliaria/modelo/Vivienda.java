package co.edu.uniquindio.inmobiliaria.modelo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Vivienda extends Propiedad {
      private Integer numeroHabitaciones;
      private Integer numeroBanos;
      private String material;

    public Vivienda(String identificador, String direccion, Boolean disponible, Double precio, Empleado empleado, LocalDateTime fechaCreacion, DisposicionPropiedad disposicionPropiedad, Float valorArea, Integer numeroPisos, TipoArea unidadesArea, String tipoPropiedad, Integer numeroHabitaciones, Integer numeroBanos, String material) {
        super(identificador, direccion, disponible, precio, empleado, fechaCreacion, disposicionPropiedad, valorArea, numeroPisos, unidadesArea, tipoPropiedad);
        this.numeroHabitaciones = numeroHabitaciones;
        this.numeroBanos = numeroBanos;
        this.material = material;
    }
}