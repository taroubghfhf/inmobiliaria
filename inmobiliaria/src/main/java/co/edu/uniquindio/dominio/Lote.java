package co.edu.uniquindio.dominio;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

@Getter
@Setter
public class Lote extends Propiedad{
    private TipoBodegaLote tipo;

    public Lote(String identificador, String direccion, Boolean disponible, Double precio, Empleado empleado, LocalDateTime fechaCreacion, DisposicionPropiedad disposicionPropiedad, Float valorArea, Integer numeroPisos, TipoArea unidadesArea, String tipoPropiedad, TipoBodegaLote tipo) {
        super(identificador, direccion, disponible, precio, empleado, fechaCreacion, disposicionPropiedad, valorArea, numeroPisos, unidadesArea, tipoPropiedad);
        this.tipo = tipo;
    }

    public boolean registrarLote() {
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();

            PreparedStatement st = con.prepareStatement("INSERT INTO lote (id, tipo) VALUES(?,?)");
            st.setString(1, this.getIdentificador());
            st.setString(2, String.valueOf(this.tipo));

            st.executeUpdate();
            st.close();

            PreparedStatement st2 = con.prepareStatement("UPDATE propiedad SET" +
                    "id_lote = "+ this.getIdentificador() +", " +
                    "WHERE id = '"+this.getIdentificador()+"'");

            st2.executeUpdate();
            st2.close();

            con.close();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
