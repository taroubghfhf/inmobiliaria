package co.edu.uniquindio.inmobiliaria.modelo;

import co.edu.uniquindio.inmobiliaria.utilidad.Conexion;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

@Getter
@Setter
public class Parqueadero extends Propiedad{

    public Parqueadero(String identificador, String direccion, Boolean disponible, Double precio, Empleado empleado, LocalDateTime fechaCreacion, DisposicionPropiedad disposicionPropiedad, Float valorArea, TipoArea unidadesArea) {
        super(identificador, direccion, disponible, precio, empleado, fechaCreacion, disposicionPropiedad, valorArea, unidadesArea);
    }

    public boolean registrarParqueadero() {
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();

            PreparedStatement st = con.prepareStatement("INSERT INTO parqueadero (id) VALUES(?)");
            st.setString(1, this.getIdentificador());

            st.executeUpdate();
            st.close();

            PreparedStatement st2 = con.prepareStatement("UPDATE propiedad SET" +
                    "id_parqueadero = "+ this.getIdentificador() +" " +
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
