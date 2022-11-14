package co.edu.uniquindio.inmobiliaria.modelo;

import co.edu.uniquindio.inmobiliaria.utilidad.Conexion;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class Administrador extends Persona{

    private List<Empleado> empleados;
    private Usuario usuario;

    public Administrador(String nombre, Integer documento, String celular, Usuario usuario) {
        super(nombre, documento, celular);
        this.usuario = usuario;
    }

    public boolean registrarEmpleado(Empleado empleado){
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();
            int user_id = empleado.getUsuario().registrarUsuario(2);

            PreparedStatement st = con.prepareStatement("INSERT INTO empleado (id, nombre, celular, id_usuario) VALUES(?,?,?,?)");
            st.setInt(1, empleado.getDocumento());
            st.setString(2, empleado.getNombre());
            st.setString(3, empleado.getCelular());
            st.setInt(4, user_id);
            st.executeUpdate();
            st.close();

            con.close();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean modificarEmpleado(Empleado empleado) {
        try{
            if(empleado.getUsuario().consultarUsuario(empleado.getUsuario().getCorreo()) > 0) {
                Conexion cx =  new Conexion();
                Connection con = cx.getConexion();

                PreparedStatement st = con.prepareStatement("UPDATE empleado SET nombre = '"+empleado.getNombre()+"', celular = '"+empleado.getCelular()+"'");

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

    public boolean desactivarEmpleado(Empleado empleado) {
        try{
            String correo = empleado.getUsuario().getCorreo();
            if(empleado.getUsuario().consultarUsuario(correo) > 0 && empleado.getUsuario().consultarEstadoUsuario(correo)) {
                Conexion cx =  new Conexion();
                Connection con = cx.getConexion();

                String user_email = empleado.getUsuario().getCorreo();
                int user_id = empleado.getUsuario().consultarUsuario(user_email);

                PreparedStatement st = con.prepareStatement("UPDATE usuario SET estado = '"+empleado.getUsuario().isEstado()+"' WHERE id = "+user_id+"");

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

    public boolean eliminarEmpleado(Empleado empleado) {
        try{
            if(empleado.getUsuario().consultarUsuario(empleado.getUsuario().getCorreo()) > 0) {
                Conexion cx =  new Conexion();
                Connection con = cx.getConexion();

                String user_email = empleado.getUsuario().getCorreo();
                int user_id = empleado.getUsuario().consultarUsuario(user_email);

                PreparedStatement st2 = con.prepareStatement("DELETE FROM empleado WHERE id = "+empleado.getDocumento()+"");

                st2.executeUpdate();
                st2.close();

                PreparedStatement st = con.prepareStatement("DELETE FROM usuario WHERE id = "+user_id+"");

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
}
