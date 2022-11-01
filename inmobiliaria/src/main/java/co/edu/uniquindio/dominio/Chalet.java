package co.edu.uniquindio.dominio;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

@Getter
@Setter
public class Chalet extends Vivienda{
    private Boolean aguaPotable;
    private Boolean alcantarillado;
    private Boolean pozoSeptico;
    private Boolean internet;
    private Boolean energiaElectrica;
    private Boolean gasDomiciliario;

    public Chalet(String identificador, String direccion, Propietario propietario, Boolean disponible, Double precio, Empleado empleado, LocalDateTime fecha, DisposicionPropiedad disposicionPropiedad, Float valorArea, Integer numeroPisos, TipoArea area, String tipoPropiedad, Integer numeroHabitaciones, Integer numeroBanos, String material, Boolean aguaPotable, Boolean alcantarillado, Boolean pozoSeptico, Boolean internet, Boolean energiaElectrica, Boolean gasDomiciliario) {
        super(identificador, direccion, propietario, disponible, precio, empleado, fecha, disposicionPropiedad, valorArea, numeroPisos, area, tipoPropiedad, numeroHabitaciones, numeroBanos, material);
        this.aguaPotable = aguaPotable;
        this.alcantarillado = alcantarillado;
        this.pozoSeptico = pozoSeptico;
        this.internet = internet;
        this.energiaElectrica = energiaElectrica;
        this.gasDomiciliario = gasDomiciliario;
    }

    public boolean registrarChalet() {
        try{
            Conexion cx =  new Conexion();
            Connection con = cx.getConexion();

            PreparedStatement st = con.prepareStatement("UPDATE propiedad SET" +
                    "\"numeroHabitaciones\"= "+ this.getNumeroHabitaciones() +", " +
                    "\"numeroBanos\"= "+ this.getNumeroBanos() +", " +
                    "material= "+ this.getMaterial()+", " +
                    "\"aguaPotable\"= "+this.getAguaPotable()+", " +
                    "\"alcantarillado\"= "+this.getAlcantarillado()+", "+
                    "\"pozoSeptico\"="+this.getPozoSeptico()+", "+
                    "internet= "+this.getInternet()+", "+
                    "\"energiaElectrica\"="+this.getEnergiaElectrica()+", "+
                    "\"gasDomiciliario\"="+this.getGasDomiciliario()+" " +
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
