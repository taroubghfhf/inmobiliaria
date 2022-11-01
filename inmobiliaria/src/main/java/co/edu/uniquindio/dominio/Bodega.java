package co.edu.uniquindio.dominio;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

@Getter
@Setter
public class Bodega extends Propiedad{

    private TipoBodegaLote tipo;

    public Bodega(String identificador, String direccion, Propietario propietario, Boolean disponible, Double precio, Empleado empleado, LocalDateTime fecha, DisposicionPropiedad disposicionPropiedad, Float valorArea, Integer numeroPisos, TipoArea area, String tipoPropiedad, TipoBodegaLote tipo) {
        super(identificador, direccion, propietario, disponible, precio, empleado, fecha, disposicionPropiedad, valorArea, numeroPisos, area, tipoPropiedad);
        this.tipo = tipo;
    }

    public boolean registrarBodega() {
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();

            PreparedStatement st = con.prepareStatement("UPDATE propiedad SET" +
                    "\"tipoBodegaLote\"= "+ this.getTipo() +", " +
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
