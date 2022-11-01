package co.edu.uniquindio.dominio;

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
    private LocalDateTime fecha;
    private LocalDateTime fechaCreacion;
    private DisposicionPropiedad disposicionPropiedad;
    private Float valorArea;
    private Integer numeroPisos;
    private TipoArea area;
    private String tipoPropiedad = this.getClass().getSimpleName();
    private Cliente cliente;

    public Propiedad(String identificador, String direccion, Propietario propietario, Boolean disponible, Double precio, Empleado empleado, LocalDateTime fechaCreacion, DisposicionPropiedad disposicionPropiedad, Float valorArea, Integer numeroPisos, TipoArea area, String tipoPropiedad) {
        this.identificador = identificador;
        this.direccion = direccion;
        this.propietario = propietario;
        this.disponible = disponible;
        this.precio = precio;
        this.empleado = empleado;
        this.fechaCreacion = fechaCreacion;
        this.disposicionPropiedad = disposicionPropiedad;
        this.valorArea = valorArea;
        this.numeroPisos = numeroPisos;
        this.area = area;
        this.tipoPropiedad = tipoPropiedad;
    }


    public boolean registrarPropiedad(){
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();

            PreparedStatement st = con.prepareStatement("INSERT INTO propiedad (id, direccion, disponible, precio, \"fechaCreacion\", area, \"tipoArea\", \"disposicionPropiedad\") VALUES(?,?,?,?,?,?,?,?)");
            st.setString(1, this.identificador);
            st.setString(2, this.direccion);
            st.setBoolean(3, this.disponible);
            st.setDouble(4, this.precio);
            st.setTimestamp(5, Timestamp.valueOf(this.fechaCreacion));
            st.setFloat(6, this.valorArea);
            st.setString(7, String.valueOf(this.area));
            st.setString(8, String.valueOf(this.disposicionPropiedad));
            st.executeUpdate();
            st.close();

            PreparedStatement st2 = con.prepareStatement("INSERT INTO \"PropiedadEmpleadoPropietario\" (\"idPropiedad\", \"idEmpleado\") VALUES(?,?)");
            st2.setString(1, this.identificador);
            st2.setString(2, this.empleado.toString());
            st2.executeUpdate();
            st2.close();

            con.close();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean alquilarPropiedad(String id) {
        try{
            if(consultarPropiedad(id) > 0) {
                Conexion cx =  new Conexion();
                Connection con = cx.getConexion();

                PreparedStatement st = con.prepareStatement("UPDATE propiedad SET" +
                        "\"disposicionPropiedad\"= "+ this.disposicionPropiedad +", " +
                        "precio= "+ this.getPrecio() +", " +
                        "fecha="+this.getFecha()+" " +
                        "WHERE id = '"+id+"'");

                st.executeUpdate();
                st.close();

                PreparedStatement st2 = con.prepareStatement("UPDATE \"PropiedadEmpleadoPropietario\" SET" +
                        "\"idCliente\"= "+ this.cliente.getDocumeto() +" " +
                        "WHERE \"idPropiedad\" = '"+id+"'");

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
            if(consultarPropiedad(id) > 0) {
                if(consultarDisponibilidadPropiedad(id)) {
                    Conexion cx =  new Conexion();
                    Connection con = cx.getConexion();

                    PreparedStatement st = con.prepareStatement("UPDATE propiedad SET" +
                                    "\"disposicionPropiedad\"= "+ this.disposicionPropiedad +", " +
                                    "precio= "+ this.getPrecio() +", " +
                                    "fecha="+this.getFecha()+", " +
                                    "disponible= 'FALSE'" +
                            "WHERE id = '"+id+"'");

                    st.executeUpdate();
                    st.close();

                    PreparedStatement st2 = con.prepareStatement("UPDATE \"PropiedadEmpleadoPropietario\" SET" +
                            "\"idCliente\"= "+ this.cliente.getDocumeto() +" " +
                            "WHERE \"idPropiedad\" = '"+id+"'");

                    st2.executeUpdate();
                    st2.close();

                    con.close();
                    return true;
                }
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
            ResultSet rs = st.executeQuery("SELECT disponible FROM propiedad WHERE id = '\"+id+\"'");
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
            ResultSet rs = st.executeQuery("SELECT count(*) FROM propiedad WHERE id = '\"+id+\"'");
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
