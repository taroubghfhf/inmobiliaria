package co.edu.uniquindio.inmobiliaria.modelo;

import co.edu.uniquindio.inmobiliaria.utilidad.Conexion;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

@Getter
@Setter
public class Empleado extends Persona {
    private Usuario usuario;

    public Empleado(String nombre, Integer documento, String celular, Usuario usuario) {
        super(nombre, documento, celular);
        this.usuario = usuario;
    }

    public void registrarCliente(Cliente cliente){
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();

            PreparedStatement st = con.prepareStatement("INSERT INTO cliente (id, nombre, celular) VALUES(?,?,?)");
            st.setInt(1, cliente.getDocumento());
            st.setString(2, cliente.getNombre());
            st.setString(3, cliente.getCelular());
            st.executeUpdate();
            st.close();

            con.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void registrarPropietario(Propietario propietario){
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();

            PreparedStatement st = con.prepareStatement("INSERT INTO propietario (id, nombre, celular) VALUES(?,?,?)");
            st.setInt(1, propietario.getDocumento());
            st.setString(2, propietario.getNombre());
            st.setString(3, propietario.getCelular());
            st.executeUpdate();
            st.close();

            con.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
