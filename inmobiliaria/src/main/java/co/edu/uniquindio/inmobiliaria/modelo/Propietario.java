package co.edu.uniquindio.inmobiliaria.modelo;

import co.edu.uniquindio.inmobiliaria.utilidad.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Propietario extends Persona{
    public Propietario(String nombre, Integer documento, String celular) {
        super(nombre, documento, celular);
    }

    public void registrarPropietario(){
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();

            PreparedStatement st = con.prepareStatement("INSERT INTO propietario (id, nombre, celular) VALUES(?,?,?)");
            st.setInt(1, this.getDocumento());
            st.setString(2, this.getNombre());
            st.setString(3, this.getCelular());
            st.executeUpdate();
            st.close();

            con.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
