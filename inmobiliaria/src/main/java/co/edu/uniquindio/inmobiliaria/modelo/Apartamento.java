package co.edu.uniquindio.inmobiliaria.modelo;

import co.edu.uniquindio.inmobiliaria.utilidad.ConexionBaseDato;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

@Getter
@Setter
public class Apartamento extends Vivienda {
    private Boolean balcon;
    private Boolean ascensor;
    private Integer piso;
    private Float valorAdministracion;
    private Integer numeroParqueaderos;

    public Apartamento(String identificador, String direccion, Propietario propietario, Boolean disponible, Double precio, Empleado empleado, LocalDateTime fecha, DisposicionPropiedad disposicionPropiedad, Float valorArea, Integer numeroPisos, TipoArea area, String tipoPropiedad, Integer numeroHabitaciones, Integer numeroBanos, String material, Boolean balcon, Boolean ascensor, Integer piso, Float valorAdministracion, Integer numeroParqueaderos) {
        super(identificador, direccion, propietario, disponible, precio, empleado, fecha, disposicionPropiedad, valorArea, numeroPisos, area, tipoPropiedad, numeroHabitaciones, numeroBanos, material);
        this.balcon = balcon;
        this.ascensor = ascensor;
        this.piso = piso;
        this.valorAdministracion = valorAdministracion;
        this.numeroParqueaderos = numeroParqueaderos;
    }

    public boolean registrarApartamento() {
        try{
            Connection con = ConexionBaseDato.getInstance().getConnection();

            PreparedStatement st = con.prepareStatement("UPDATE propiedad SET" +
                    "\"numeroHabitaciones\"= "+ this.getNumeroHabitaciones() +", " +
                    "\"numeroBanos\"= "+ this.getNumeroBanos() +", " +
                    "balcon= "+ this.getBalcon()+", " +
                    "ascensor= "+ this.getAscensor()+", " +
                    "piso= "+ this.getPiso()+", " +
                    "\"valorAdministracion\"= "+ this.getValorAdministracion()+", " +
                    "\"tipoPropiedad\"= "+this.getTipoPropiedad()+", "+
                    "\"numeroParqueaderos\"= "+ this.getNumeroParqueaderos()+" " +
                    "WHERE id = '"+this.getIdentificador()+"'");

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
