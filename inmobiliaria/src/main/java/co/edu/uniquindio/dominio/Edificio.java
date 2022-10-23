package co.edu.uniquindio.dominio;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Edificio {
    private Integer numeroPisos;

    public Edificio(Integer numeroPisos) {
        this.numeroPisos = numeroPisos;
    }
}
