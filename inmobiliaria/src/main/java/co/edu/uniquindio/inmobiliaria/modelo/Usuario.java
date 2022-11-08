package co.edu.uniquindio.inmobiliaria.modelo;

import co.edu.uniquindio.inmobiliaria.utilidad.Conexion;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Getter
@Setter
public class Usuario {

    private String correo;
    private String clave;
    private String fraseSeguridad;
    private boolean estado;

    public Usuario(String correo, String clave, String fraseSeguridad, boolean estado) {
        this.correo = correo;
        this.clave = clave;
        this.fraseSeguridad = fraseSeguridad;
        this.estado = estado;
    }

    public boolean registrarUsuario(int rol) {
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();

            PreparedStatement st = con.prepareStatement("INSERT INTO usuario (email, password, id_rol, frase) VALUES(?,?,?,?)");
            st.setString(1, this.getCorreo());
            st.setString(2, this.getClave());
            st.setInt(3, rol);
            st.setString(4, this.getFraseSeguridad());
            st.executeUpdate();
            st.close();

            con.close();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public int consultarUsuario(String correo) {
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();
            int count = 0;

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT id FROM usuario WHERE email = '"+correo+"'");
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

    public String recuperarClave(String correo, String frase) {
        try{
            if(consultarUsuario(correo) > 0 && verificarFrase(correo, frase)) {
                Conexion cx =  new Conexion();
                Connection con = cx.getConexion();
                String clave = "";

                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT password FROM usuario WHERE email = '"+correo+"'");
                while (rs.next()) {
                    clave = rs.getString(1);
                }
                rs.close();
                st.close();

                con.close();
                return clave;
            }
            return "";
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "";
        }
    }

    public boolean verificarFrase(String correo, String frase) {
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();
            String frase_db = "";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT frase FROM usuario WHERE email = '"+correo+"'");
            while (rs.next()) {
                frase_db += rs.getString(1);
            }
            rs.close();
            st.close();

            con.close();

            return frase_db.equals(frase);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
