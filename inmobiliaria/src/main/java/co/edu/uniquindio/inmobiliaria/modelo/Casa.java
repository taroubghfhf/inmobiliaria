package co.edu.uniquindio.inmobiliaria.modelo;

import co.edu.uniquindio.inmobiliaria.utilidad.Conexion;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.time.LocalDateTime;

@Getter
@Setter
public class Casa extends Vivienda{
    private Integer numeroPisos;
    public Casa(String identificador, String direccion, Boolean disponible, Double precio, Empleado empleado, LocalDateTime fechaCreacion, DisposicionPropiedad disposicionPropiedad, Float valorArea, TipoArea unidadesArea, Integer numeroPisos, Integer numeroHabitaciones, Integer numeroBanos, String material) {
        super(identificador, direccion, disponible, precio, empleado, fechaCreacion, disposicionPropiedad, valorArea, unidadesArea, numeroHabitaciones, numeroBanos, material);
        this.numeroPisos = numeroPisos;
    }

    public String registrarCasa(int id_vivienda) {
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();

            PreparedStatement st = con.prepareStatement("INSERT INTO casa (id, numero_pisos, id_vivienda) VALUES(?,?,?) RETURNING id", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, this.getIdentificador());
            st.setInt(2, this.getNumeroPisos());
            st.setInt(3, id_vivienda);

            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            String id = "";
            if (rs.next()) id = rs.getString(1);
            st.close();

            con.close();
            return id;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "";
        }
    }
}
