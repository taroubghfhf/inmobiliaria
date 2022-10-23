package co.edu.uniquindio.dominio;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
public class Lote extends Propiedad{
    private TipoLote tipoLote;

    public Lote(String identificador, String direccion, Propietario propietario, Boolean disponible, List<String> fotos,
                Double precio, Empleado empleado, LocalDateTime fecha, TipoPropiedad tipoPropiedad, TipoLote tipoLote) {
        super(identificador, direccion, propietario, disponible, fotos, precio, empleado, fecha, tipoPropiedad);
        this.tipoLote = tipoLote;
    }
}
