package co.edu.uniquindio.inmobiliaria.modelo;

import co.edu.uniquindio.inmobiliaria.utilidad.Conexion;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Setter
@Getter
public class Edificio extends Propiedad{

    public Edificio(String identificador, String direccion, Boolean disponible, Double precio, Empleado empleado, LocalDateTime fechaCreacion, DisposicionPropiedad disposicionPropiedad, Float valorArea, TipoArea unidadesArea, Integer numeroPisos) {
        super(identificador, direccion, disponible, precio, empleado, fechaCreacion, disposicionPropiedad, valorArea, unidadesArea);
        this.setNumeroPisos(numeroPisos);
    }

    public boolean registrarEdificio() {
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();

            PreparedStatement st = con.prepareStatement("INSERT INTO edificio (id) VALUES(?)");
            st.setString(1, this.getIdentificador());

            st.executeUpdate();
            st.close();

            PreparedStatement st2 = con.prepareStatement("INSERT INTO propiedad (id, direccion, disponible, precio, fecha_creacion, area, unidades_area, disposicion_propiedad, id_edificio) VALUES(?,?,?,?,?,?,?,?,?)");
            st2.setString(1, this.getIdentificador());
            st2.setString(2, this.getDireccion());
            st2.setBoolean(3, this.getDisponible());
            st2.setDouble(4, this.getPrecio());
            st2.setTimestamp(5, Timestamp.valueOf(this.getFechaCreacion()));
            st2.setFloat(6, this.getValorArea());
            st2.setString(7, String.valueOf(this.getUnidadesArea()));
            st2.setString(8, String.valueOf(this.getDisposicionPropiedad()));
            st2.setString(9, this.getIdentificador());
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
