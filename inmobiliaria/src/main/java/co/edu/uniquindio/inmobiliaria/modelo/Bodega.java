package co.edu.uniquindio.inmobiliaria.modelo;

import co.edu.uniquindio.inmobiliaria.utilidad.Conexion;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
public class Bodega extends Propiedad {

    private TipoBodegaLote tipo;

    public Bodega(String identificador, String direccion, Boolean disponible, Double precio, Empleado empleado, LocalDateTime fechaCreacion, DisposicionPropiedad disposicionPropiedad, Float valorArea, TipoArea unidadesArea, TipoBodegaLote tipo) {
        super(identificador, direccion, disponible, precio, empleado, fechaCreacion, disposicionPropiedad, valorArea, unidadesArea);
        this.tipo = tipo;
    }

    public boolean registrarBodega(int id_propiedad) {
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();

            PreparedStatement st = con.prepareStatement("INSERT INTO bodega (id, tipo, id_propiedad) VALUES(?,?,?)");
            st.setString(1, this.getIdentificador());
            st.setString(2, String.valueOf(this.tipo));
            st.setInt(3, id_propiedad);

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
