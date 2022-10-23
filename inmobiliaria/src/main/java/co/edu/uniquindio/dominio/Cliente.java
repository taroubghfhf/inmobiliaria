package co.edu.uniquindio.dominio;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente extends Persona {

    private String alias;
    public Cliente(String nombre, String documeto, String celular, String alias) {
        super(nombre, documeto, celular);

    }
}
