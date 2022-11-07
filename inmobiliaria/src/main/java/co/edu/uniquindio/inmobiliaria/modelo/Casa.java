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
public class Casa extends Vivienda{
    public Casa(String identificador, String direccion, Boolean disponible, Double precio, Empleado empleado, LocalDateTime fechaCreacion, DisposicionPropiedad disposicionPropiedad, Float valorArea, TipoArea unidadesArea, Integer numeroPisos, Integer numeroHabitaciones, Integer numeroBanos, String material) {
        super(identificador, direccion, disponible, precio, empleado, fechaCreacion, disposicionPropiedad, valorArea, unidadesArea, numeroHabitaciones, numeroBanos, material);
        this.setNumeroPisos(numeroPisos);
    }

    public boolean registrarCasa() {
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();

            PreparedStatement st = con.prepareStatement("INSERT INTO casa (id) VALUES(?)");
            st.setString(1, this.getIdentificador());

            st.executeUpdate();
            st.close();

            PreparedStatement st2 = con.prepareStatement("INSERT INTO vivienda (id, numero_habitaciones, numero_banos, id_casa) VALUES(?,?,?,?)");
            st2.setString(1, this.getIdentificador());
            st2.setInt(2, this.getNumeroHabitaciones());
            st2.setInt(3, this.getNumeroBanos());
            st2.setString(4, this.getIdentificador());

            st2.executeUpdate();
            st2.close();

            PreparedStatement st3 = con.prepareStatement("INSERT INTO propiedad (id, direccion, disponible, precio, fecha_creacion, area, unidades_area, disposicion_propiedad, id_vivienda) VALUES(?,?,?,?,?,?,?,?,?)");
            st3.setString(1, this.getIdentificador());
            st3.setString(2, this.getDireccion());
            st3.setBoolean(3, this.getDisponible());
            st3.setDouble(4, this.getPrecio());
            st3.setTimestamp(5, Timestamp.valueOf(this.getFechaCreacion()));
            st3.setFloat(6, this.getValorArea());
            st3.setString(7, String.valueOf(this.getUnidadesArea()));
            st3.setString(8, String.valueOf(this.getDisposicionPropiedad()));
            st3.setString(9, this.getIdentificador());
            st3.executeUpdate();
            st3.close();

            PreparedStatement st4 = con.prepareStatement("INSERT INTO historial_propiedad (id_propiedad, id_empleado) VALUES(?,?)");
            st4.setString(1, this.getIdentificador());
            st4.setInt(2, this.getEmpleado().getDocumento());
            st4.executeUpdate();
            st4.close();

            con.close();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
