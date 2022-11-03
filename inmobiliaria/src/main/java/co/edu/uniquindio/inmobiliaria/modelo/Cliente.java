package co.edu.uniquindio.inmobiliaria.modelo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente extends Persona {

    public Cliente(String nombre, String documeto, String celular) {
        super(nombre, documeto, celular);

    }
}
