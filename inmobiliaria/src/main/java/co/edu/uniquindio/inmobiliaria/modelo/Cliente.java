package co.edu.uniquindio.inmobiliaria.modelo;


import co.edu.uniquindio.inmobiliaria.utilidad.Conexion;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

@Getter
@Setter
public class Cliente extends Persona {
    public Cliente(String nombre, Integer documento, String celular) {
        super(nombre, documento, celular);
    }

    public void registrarCliente(){
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();

            PreparedStatement st = con.prepareStatement("INSERT INTO cliente (id, nombre, celular) VALUES(?,?,?)");
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
