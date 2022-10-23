package co.edu.uniquindio.dominio;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
public class Parqueadero extends Propiedad{

    public Parqueadero(String identificador, String direccion, Propietario propietario, Boolean disponible,
                       List<String> fotos, Double precio, Empleado empleado, LocalDateTime fecha,
                       TipoPropiedad tipoPropiedad) {
        super(identificador, direccion, propietario, disponible, fotos, precio, empleado, fecha, tipoPropiedad);
    }
}
