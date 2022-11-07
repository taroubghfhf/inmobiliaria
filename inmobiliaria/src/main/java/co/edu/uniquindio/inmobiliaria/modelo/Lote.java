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
public class Lote extends Propiedad{
    private TipoBodegaLote tipo;

    public Lote(String identificador, String direccion, Boolean disponible, Double precio, Empleado empleado, LocalDateTime fechaCreacion, DisposicionPropiedad disposicionPropiedad, Float valorArea, TipoArea unidadesArea, TipoBodegaLote tipo) {
        super(identificador, direccion, disponible, precio, empleado, fechaCreacion, disposicionPropiedad, valorArea, unidadesArea);
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

            PreparedStatement st2 = con.prepareStatement("INSERT INTO propiedad (direccion, disponible, precio, fecha_creacion, area, unidades_area, disposicion_propiedad, id_lote) VALUES(?,?,?,?,?,?,?,?)");
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

            int id_prop = this.consultarIdPropiedad("id_lote", this.getIdentificador());

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
