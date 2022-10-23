package co.edu.uniquindio.dominio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Apartamento extends Vivienda {
    private Boolean balcon;
    private Boolean ascensor;
    private Float valorAdministracion;
    private Integer numeroParqueaderos;

    public Apartamento(Integer numeroHabitaciones, Integer numeroBanos, Integer numeroPisos, Bodega material,
                       Boolean internet, Boolean aguaPotable, Boolean gasDomiciliario, Boolean alcantarillado,
                       Boolean energia, Boolean balcon, Boolean ascensor, Float valorAdministracion,
                       Integer numeroParqueaderos) {
        super(numeroHabitaciones, numeroBanos, numeroPisos, material, internet, aguaPotable, gasDomiciliario,
                alcantarillado, energia);
        this.balcon = balcon;
        this.ascensor = ascensor;
        this.valorAdministracion = valorAdministracion;
        this.numeroParqueaderos = numeroParqueaderos;
    }
}
