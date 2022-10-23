package co.edu.uniquindio.dominio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Casa extends Vivienda{
    public Casa(Integer numeroHabitaciones, Integer numeroBanos, Integer numeroPisos, Bodega material, Boolean internet,
                Boolean aguaPotable, Boolean gasDomiciliario, Boolean alcantarillado, Boolean energia) {
        super(numeroHabitaciones, numeroBanos, numeroPisos, material, internet, aguaPotable, gasDomiciliario,
                alcantarillado, energia);
    }
}
