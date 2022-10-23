package co.edu.uniquindio.dominio;
import static co.edu.uniquindio.utilidades.Validador.validacionMayorCero;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Vivienda {
      private Integer numeroHabitaciones;
      private Integer numeroBanos;
      private Integer numeroPisos;
      private String material;
      private Boolean internet;
      private Boolean aguaPotable;
      private Boolean gasDomiciliario;
      private Boolean alcantarillado;
      private Boolean energia;

    public Vivienda(Integer numeroHabitaciones, Integer numeroBanos, Integer numeroPisos, String material,
                    Boolean internet, Boolean aguaPotable, Boolean gasDomiciliario, Boolean alcantarillado, Boolean energia) {
        
        this.numeroHabitaciones = numeroHabitaciones;
        this.numeroBanos = numeroBanos;
        this.numeroPisos = numeroPisos;
        this.material = material;
        this.internet = internet;
        this.aguaPotable = aguaPotable;
        this.gasDomiciliario = gasDomiciliario;
        this.alcantarillado = alcantarillado;
        this.energia = energia;
    }
}
