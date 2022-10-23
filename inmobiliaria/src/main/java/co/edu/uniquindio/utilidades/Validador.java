package co.edu.uniquindio.utilidades;

import java.util.Optional;

public class Validador {

    public static void validacionObligatoriedad(Object object,String mensaje){
        if(object == null){
            throw new RuntimeException(mensaje);
        }
    }

    public static void validacionMayorCero(Object object,String mensaje){
        if(Integer.parseInt(object.toString())<=0){
            throw new RuntimeException(mensaje);
        }
    }
}
