package co.edu.uniquindio.dominio;

import java.time.LocalDateTime;

public class Chalet extends Vivienda{
    private Boolean aguaPotable;
    private Boolean alcantarillado;
    private Boolean pozoSeptico;
    private Boolean internet;
    private Boolean energiaElectrica;
    private Boolean gasDomiciliario;

    public Chalet(String identificador, String direccion, Propietario propietario, Boolean disponible, Double precio, Empleado empleado, LocalDateTime fecha, DisposicionPropiedad disposicionPropiedad, Float valorArea, Integer numeroPisos, TipoArea area, String tipoPropiedad, Integer numeroHabitaciones, Integer numeroBanos, String material, Boolean aguaPotable, Boolean alcantarillado, Boolean pozoSeptico, Boolean internet, Boolean energiaElectrica, Boolean gasDomiciliario) {
        super(identificador, direccion, propietario, disponible, precio, empleado, fecha, disposicionPropiedad, valorArea, numeroPisos, area, tipoPropiedad, numeroHabitaciones, numeroBanos, material);
        this.aguaPotable = aguaPotable;
        this.alcantarillado = alcantarillado;
        this.pozoSeptico = pozoSeptico;
        this.internet = internet;
        this.energiaElectrica = energiaElectrica;
        this.gasDomiciliario = gasDomiciliario;
    }
}
