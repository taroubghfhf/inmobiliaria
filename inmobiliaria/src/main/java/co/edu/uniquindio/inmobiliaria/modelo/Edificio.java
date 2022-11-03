package co.edu.uniquindio.inmobiliaria.modelo;

import co.edu.uniquindio.inmobiliaria.utilidad.Conexion;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

@Setter
@Getter
public class Edificio extends Propiedad{

    public Edificio(String identificador, String direccion, Boolean disponible, Double precio, Empleado empleado, LocalDateTime fechaCreacion, DisposicionPropiedad disposicionPropiedad, Float valorArea, Integer numeroPisos, TipoArea unidadesArea, String tipoPropiedad) {
        super(identificador, direccion, disponible, precio, empleado, fechaCreacion, disposicionPropiedad, valorArea, numeroPisos, unidadesArea, tipoPropiedad);
    }

    public boolean registrarEdificio() {
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();

            PreparedStatement st = con.prepareStatement("INSERT INTO edificio (id) VALUES(?)");
            st.setString(1, this.getIdentificador());

            st.executeUpdate();
            st.close();

            PreparedStatement st2 = con.prepareStatement("UPDATE propiedad SET" +
                    "id_edificio = "+ this.getIdentificador() +", " +
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