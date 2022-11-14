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
    private TipoArea unidadesArea;
    private Cliente cliente;
    private String tipoPropiedad = this.getClass().getSimpleName();

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

    public int registrarPropiedad() {
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();

            PreparedStatement st = con.prepareStatement("INSERT INTO propiedad (direccion, disponible, precio, fecha_creacion, area, unidades_area, disposicion_propiedad, tipo_propiedad) VALUES(?,?,?,?,?,?,?,?) RETURNING id", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, this.getDireccion());
            st.setBoolean(2, this.getDisponible());
            st.setDouble(3, this.getPrecio());
            st.setTimestamp(4, Timestamp.valueOf(this.getFechaCreacion()));
            st.setFloat(5, this.getValorArea());
            st.setString(6, String.valueOf(this.getUnidadesArea()));
            st.setString(7, String.valueOf(this.getDisposicionPropiedad()));
            st.setString(8, this.getTipoPropiedad());

            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            int id = 0;
            if (rs.next()) id = rs.getInt(1);
            st.close();

            PreparedStatement st2 = con.prepareStatement("INSERT INTO historial_propiedad (id_propiedad, id_empleado) VALUES(?,?)");
            st2.setInt(1, id);
            st2.setInt(2, this.getEmpleado().getDocumento());
            st2.executeUpdate();
            st2.close();

            con.close();
            return id;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
    public boolean alquilarPropiedad(String id, String campo) {
        try{
            int prop_id = consultarIdPropiedad(campo, id);
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();

            PreparedStatement st = con.prepareStatement("UPDATE propiedad SET disponible = 'false' WHERE "+campo+" = '"+id+"'");

            st.executeUpdate();
            st.close();

            PreparedStatement st2 = con.prepareStatement("UPDATE historial_propiedad SET " +
                    "id_cliente = "+this.getCliente().getDocumento()+", " +
                    "fecha_modificacion = '"+this.getFechaModificacion()+"' " +
                    "WHERE id_propiedad = "+prop_id+"");

            st2.executeUpdate();
            st2.close();

            con.close();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean venderPropiedad(String id, String campo) {
        try{
            int prop_id = consultarIdPropiedad(campo, id);
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();

            PreparedStatement st = con.prepareStatement("UPDATE propiedad SET disponible = 'false' WHERE "+campo+" = '"+id+"'");

            st.executeUpdate();
            st.close();

            PreparedStatement st2 = con.prepareStatement("UPDATE historial_propiedad SET" +
                    "id_propietario= "+ this.propietario.getDocumento() +", " +
                    "id_cliente= "+ this.cliente.getDocumento() +", " +
                    "fecha_modificacion="+this.getFechaModificacion()+" " +
                    "WHERE id_propiedad = "+prop_id+"");

            st2.executeUpdate();
            st2.close();

            con.close();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean retirarPropiedad(String id, String campo) {
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();

            PreparedStatement st = con.prepareStatement("UPDATE propiedad SET disponible= 'false' WHERE "+campo+" = '"+id+"'");

            st.executeUpdate();
            st.close();

            con.close();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean consultarDisponibilidadPropiedad(String id, String campo) {
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();
            boolean r = false;

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT disponible FROM propiedad WHERE "+campo+" = '"+id+"'");
            while (rs.next()) {
                r = rs.getBoolean(1);
            }
            rs.close();
            st.close();

            con.close();
            return r;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public int consultarPropiedad(String id, String campo) {
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();
            int count = 0;

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT count(*) FROM propiedad WHERE "+campo+" = '"+id+"'");
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

    public int consultarIdPropiedad(String fk, String fk_id) {
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();
            int count = 0;

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT id FROM propiedad WHERE "+fk+" = '"+fk_id+"'");
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
