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

            PreparedStatement st2 = con.prepareStatement("INSERT INTO propiedad (direccion, disponible, precio, fecha_creacion, area, unidades_area, disposicion_propiedad, id_parqueadero) VALUES(?,?,?,?,?,?,?,?)");
            st2.setString(1, this.getDireccion());
            st2.setBoolean(2, this.getDisponible());
            st2.setDouble(3, this.getPrecio());
            st2.setTimestamp(4, Timestamp.valueOf(this.getFechaCreacion()));
            st2.setFloat(5, this.getValorArea());
            st2.setString(6, String.valueOf(this.getUnidadesArea()));
            st2.setString(7, String.valueOf(this.getDisposicionPropiedad()));
            st2.setString(8, this.getIdentificador());
            st2.executeUpdate();
            st2.close();

            int id_prop = this.consultarIdPropiedad("id_parqueadero", this.getIdentificador());

            PreparedStatement st3 = con.prepareStatement("INSERT INTO historial_propiedad (id_propiedad, id_empleado) VALUES(?,?)");
            st3.setInt(1, id_prop);
            st3.setInt(2, this.getEmpleado().getDocumento());
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
