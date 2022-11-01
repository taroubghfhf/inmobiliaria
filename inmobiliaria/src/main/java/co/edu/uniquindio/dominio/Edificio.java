package co.edu.uniquindio.dominio;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

@Setter
@Getter
public class Edificio extends Propiedad{

    public Edificio(String identificador, String direccion, Propietario propietario, Boolean disponible, Double precio, Empleado empleado, LocalDateTime fecha, DisposicionPropiedad disposicionPropiedad, Float valorArea, Integer numeroPisos, TipoArea area, String tipoPropiedad) {
        super(identificador, direccion, propietario, disponible, precio, empleado, fecha, disposicionPropiedad, valorArea, numeroPisos, area, tipoPropiedad);
    }

    public boolean registrarEdificio() {
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();

            PreparedStatement st = con.prepareStatement("UPDATE propiedad SET" +
                    "\"numeroPisos\"= "+ this.getNumeroPisos() +", " +
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
