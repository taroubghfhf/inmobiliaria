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
    private Integer numeroPisos;

    public Edificio(String identificador, String direccion, Boolean disponible, Double precio, Empleado empleado, LocalDateTime fechaCreacion, DisposicionPropiedad disposicionPropiedad, Float valorArea, TipoArea unidadesArea, Integer numeroPisos) {
        super(identificador, direccion, disponible, precio, empleado, fechaCreacion, disposicionPropiedad, valorArea, unidadesArea);
        this.numeroPisos = numeroPisos;
    }

    public boolean registrarEdificio(int id_propiedad) {
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();

            PreparedStatement st = con.prepareStatement("INSERT INTO edificio (id, numero_pisos, id_propiedad) VALUES(?,?,?)");
            st.setString(1, this.getIdentificador());
            st.setInt(2, this.numeroPisos);
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
