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

    private List<Propiedad> propedades;
    private List<Propietario> propietarios;
    private List<Cliente> clientes;
    private Usuario usuario;

    public Empleado(String nombre, Integer documento, String celular, Usuario usuario) {
        super(nombre, documento, celular);
        this.usuario = usuario;
    }

    public void registrarEmpleado(){
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();

            PreparedStatement st = con.prepareStatement("INSERT INTO empleado (id, nombre, celular, id_usuario) VALUES(?,?,?,?)");
            st.setInt(1, this.getDocumento());
            st.setString(2, this.getNombre());
            st.setString(3, this.getCelular());
            st.setInt(4, this.usuario.registrarUsuario(2));
            st.executeUpdate();
            st.close();

            con.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
