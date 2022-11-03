package co.edu.uniquindio.inmobiliaria.modelo;

import co.edu.uniquindio.inmobiliaria.utilidad.ConexionBaseDato;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

@Getter
@Setter
public class Parqueadero extends Propiedad{

    public Parqueadero(String identificador, String direccion, Propietario propietario, Boolean disponible, Double precio, Empleado empleado, LocalDateTime fecha, DisposicionPropiedad disposicionPropiedad, Float valorArea, Integer numeroPisos, TipoArea area, String tipoPropiedad) {
        super(identificador, direccion, propietario, disponible, precio, empleado, fecha, disposicionPropiedad, valorArea, numeroPisos, area, tipoPropiedad);
    }

    public boolean registrarParqueadero() {
        try{
            Connection con = ConexionBaseDato.getInstance().getConnection();
            PreparedStatement st = con.prepareStatement("UPDATE propiedad SET" +
                    "\"tipoPropiedad\"= "+this.getTipoPropiedad()+", "+
                    "WHERE id = '"+this.getIdentificador()+"'");

            st.executeUpdate();
            st.close();

            con.close();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
