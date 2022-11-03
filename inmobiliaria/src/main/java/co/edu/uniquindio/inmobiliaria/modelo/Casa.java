package co.edu.uniquindio.inmobiliaria.modelo;

import co.edu.uniquindio.inmobiliaria.utilidad.Conexion;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

@Getter
@Setter
public class Casa extends Vivienda{
    public Casa(String identificador, String direccion, Boolean disponible, Double precio, Empleado empleado, LocalDateTime fechaCreacion, DisposicionPropiedad disposicionPropiedad, Float valorArea, Integer numeroPisos, TipoArea unidadesArea, String tipoPropiedad, Integer numeroHabitaciones, Integer numeroBanos, String material) {
        super(identificador, direccion, disponible, precio, empleado, fechaCreacion, disposicionPropiedad, valorArea, numeroPisos, unidadesArea, tipoPropiedad, numeroHabitaciones, numeroBanos, material);
    }

    public boolean registrarCasa() {
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();

            PreparedStatement st = con.prepareStatement("INSERT INTO casa (id) VALUES(?)");
            st.setString(1, this.getIdentificador());

            st.executeUpdate();
            st.close();

            PreparedStatement st2 = con.prepareStatement("INSERT INTO vivienda (id, numero_habitaciones, numero_banos, id_apartamento) VALUES(?,?,?,?)");
            st2.setString(1, this.getIdentificador());
            st2.setInt(2, this.getNumeroHabitaciones());
            st2.setInt(3, this.getNumeroBanos());
            st2.setString(4, this.getIdentificador());

            st2.executeUpdate();
            st2.close();

            PreparedStatement st3 = con.prepareStatement("UPDATE propiedad SET" +
                    "id_vivienda = "+ this.getIdentificador() +", " +
                    "WHERE id = '"+this.getIdentificador()+"'");

            st3.executeUpdate();
            st3.close();

            con.close();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
