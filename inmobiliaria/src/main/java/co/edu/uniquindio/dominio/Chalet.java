package co.edu.uniquindio.dominio;

public class Chalet extends Vivienda{
    private Boolean pozoSeptico;


    public Chalet(Integer numeroHabitaciones, Integer numeroBanos, Integer numeroPisos, Bodega material,
                  Boolean internet, Boolean aguaPotable, Boolean gasDomiciliario, Boolean alcantarillado,
                  Boolean energia, Boolean pozoSeptico) {
        super(numeroHabitaciones, numeroBanos, numeroPisos, material, internet, aguaPotable, gasDomiciliario,
                alcantarillado, energia);
        this.pozoSeptico = pozoSeptico;
    }
}
