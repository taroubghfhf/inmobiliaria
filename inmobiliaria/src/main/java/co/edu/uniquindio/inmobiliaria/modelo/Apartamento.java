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
public class Apartamento extends Vivienda {
    private Boolean balcon;
    private Boolean ascensor;
    private Integer piso;
    private Float valorAdministracion;
    private Integer numeroParqueaderos;

    public Apartamento(String identificador, String direccion, Boolean disponible, Double precio, Empleado empleado, LocalDateTime fechaCreacion, DisposicionPropiedad disposicionPropiedad, Float valorArea, TipoArea unidadesArea, Integer numeroHabitaciones, Integer numeroBanos, String material, Boolean balcon, Boolean ascensor, Integer piso, Float valorAdministracion, Integer numeroParqueaderos) {
        super(identificador, direccion, disponible, precio, empleado, fechaCreacion, disposicionPropiedad, valorArea, unidadesArea, numeroHabitaciones, numeroBanos, material);
        this.balcon = balcon;
        this.ascensor = ascensor;
        this.piso = piso;
        this.valorAdministracion = valorAdministracion;
        this.numeroParqueaderos = numeroParqueaderos;
    }

    public boolean registrarApartamento(int id_vivienda) {
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();

            PreparedStatement st = con.prepareStatement("INSERT INTO apartamento (id, balcon, piso, valor_administracion, numero_parqueaderos, ascensor, id_vivienda) VALUES(?,?,?,?,?,?,?)");
            st.setString(1, this.getIdentificador());
            st.setBoolean(2, this.balcon);
            st.setInt(3, this.piso);
            st.setFloat(4, this.valorAdministracion);
            st.setInt(5, this.numeroParqueaderos);
            st.setBoolean(6, this.ascensor);
            st.setInt(7, id_vivienda);

            st.executeUpdate();
            st.close();

            con.close();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
