package co.edu.uniquindio.inmobiliaria.modelo;

import co.edu.uniquindio.inmobiliaria.utilidad.Conexion;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.time.LocalDateTime;

@Getter
@Setter
public class Propiedad {
    private String identificador;
    private String direccion;
    private Propietario propietario;
    private Boolean disponible;
    private Double precio;
    private Empleado empleado;
    private LocalDateTime fechaModificacion;
    private LocalDateTime fechaCreacion;
    private DisposicionPropiedad disposicionPropiedad;
    private Float valorArea;
    private Integer numeroPisos;
    private TipoArea unidadesArea;
    private Cliente cliente;

    public Propiedad(String identificador, String direccion, Boolean disponible, Double precio, Empleado empleado, LocalDateTime fechaCreacion, DisposicionPropiedad disposicionPropiedad, Float valorArea, TipoArea unidadesArea) {
        this.identificador = identificador;
        this.direccion = direccion;
        this.disponible = disponible;
        this.precio = precio;
        this.empleado = empleado;
        this.fechaCreacion = fechaCreacion;
        this.disposicionPropiedad = disposicionPropiedad;
        this.valorArea = valorArea;
        this.unidadesArea = unidadesArea;
    }

    public boolean alquilarPropiedad(String id) {
        try{
            if(consultarPropiedad(id) > 0 && consultarDisponibilidadPropiedad(id)) {
                Conexion cx =  new Conexion();
                Connection con = cx.getConexion();

                PreparedStatement st = con.prepareStatement("UPDATE propiedad SET disponible = 'false' WHERE id = '"+id+"'");

                st.executeUpdate();
                st.close();

                PreparedStatement st2 = con.prepareStatement("UPDATE historial_propiedad SET " +
                        "id_cliente = "+this.getCliente().getDocumento()+", " +
                        "fecha_modificacion = '"+this.getFechaModificacion()+"' " +
                        "WHERE id_propiedad = '"+id+"'");

                st2.executeUpdate();
                st2.close();

                con.close();
                return true;
            }
            return false;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean venderPropiedad(String id) {
        try{
            if(consultarPropiedad(id) > 0 && consultarDisponibilidadPropiedad(id)) {
                Conexion cx =  new Conexion();
                Connection con = cx.getConexion();

                PreparedStatement st = con.prepareStatement("UPDATE propiedad SET" +
                                "disposicion_propiedad= "+ this.disposicionPropiedad +", " +
                                "precio= "+ this.getPrecio() +", " +
                                "disponible= 'false'" +
                        "WHERE id = '"+id+"'");

                st.executeUpdate();
                st.close();

                PreparedStatement st2 = con.prepareStatement("UPDATE historial_propiedad SET" +
                        "id_propietario= "+ this.propietario.getDocumento() +", " +
                        "id_cliente= "+ this.cliente.getDocumento() +", " +
                        "fecha_modificacion="+this.getFechaModificacion()+" " +
                        "WHERE id_propiedad = '"+id+"'");

                st2.executeUpdate();
                st2.close();

                con.close();
                return true;
            }
            return false;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean retirarPropiedad(String id) {
        try{
            if(!consultarDisponibilidadPropiedad(id)) {
                Conexion cx =  new Conexion();
                Connection con = cx.getConexion();

                PreparedStatement st = con.prepareStatement("UPDATE propiedad SET" +
                        "disponible= 'false'" +
                        "WHERE id = '"+id+"'");

                st.executeUpdate();
                st.close();

                con.close();
                return true;
            }
            return false;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean consultarDisponibilidadPropiedad(String id) {
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT disponible FROM propiedad WHERE id = '"+id+"'");
            while (rs.next()) {
                return rs.getBoolean(1);
            }
            rs.close();
            st.close();

            con.close();
            return false;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public int consultarPropiedad(String id) {
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();
            int count = 0;

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT count(*) FROM propiedad WHERE id = '"+id+"'");
            while (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
            st.close();

            con.close();
            return count;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int consultarIdPropiedad(String fk) {
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();
            int count = 0;

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT id FROM propiedad WHERE "+fk+" = 2 ORDER BY id DESC LIMIT 1");
            ResultSet rs = st.executeQuery("SELECT count(*) FROM propiedad WHERE id = '"+id+"'");
            while (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
            st.close();

            con.close();
            return count;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
