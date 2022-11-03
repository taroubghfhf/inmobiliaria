package co.edu.uniquindio.inmobiliaria.modelo;

import co.edu.uniquindio.inmobiliaria.utilidad.ConexionBaseDato;
import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

@Getter
@Setter
public class Casa extends Vivienda{
    public Casa(String identificador, String direccion, Propietario propietario, Boolean disponible, Double precio, Empleado empleado, LocalDateTime fecha, DisposicionPropiedad disposicionPropiedad, Float valorArea, Integer numeroPisos, TipoArea area, String tipoPropiedad, Integer numeroHabitaciones, Integer numeroBanos, String material) {
        super(identificador, direccion, propietario, disponible, precio, empleado, fecha, disposicionPropiedad, valorArea, numeroPisos, area, tipoPropiedad, numeroHabitaciones, numeroBanos, material);
    }

    public boolean registrarCasa() {
        try{
            Connection con = ConexionBaseDato.getInstance().getConnection();

            PreparedStatement st = con.prepareStatement("UPDATE propiedad SET" +
                    "\"numeroHabitaciones\"= "+ this.getNumeroHabitaciones() +", " +
                    "\"numeroBanos\"= "+ this.getNumeroBanos() +", " +
                    "\"numeroPisos\"= "+ this.getNumeroPisos() +", " +
                    "material= "+ this.getMaterial()+" " +
                    "\"tipoPropiedad\"= "+this.getTipoPropiedad()+", "+
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
