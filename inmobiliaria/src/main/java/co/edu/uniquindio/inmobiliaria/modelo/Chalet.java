package co.edu.uniquindio.inmobiliaria.modelo;

import co.edu.uniquindio.inmobiliaria.utilidad.Conexion;
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

    public Chalet(String identificador, String direccion, Boolean disponible, Double precio, Empleado empleado, LocalDateTime fechaCreacion, DisposicionPropiedad disposicionPropiedad, Float valorArea, TipoArea unidadesArea, Integer numeroHabitaciones, Integer numeroBanos, String material, Boolean aguaPotable, Boolean alcantarillado, Boolean pozoSeptico, Boolean internet, Boolean energiaElectrica, Boolean gasDomiciliario) {
        super(identificador, direccion, disponible, precio, empleado, fechaCreacion, disposicionPropiedad, valorArea, unidadesArea, numeroHabitaciones, numeroBanos, material);
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

            PreparedStatement st = con.prepareStatement("INSERT INTO chalet (id, agua_potable, alcantarillado, pozo_septico, internet, energia_electrica, gas_domiciliario) VALUES(?,?,?,?,?,?,?)");
            st.setString(1, this.getIdentificador());
            st.setBoolean(2, this.aguaPotable);
            st.setBoolean(3, this.alcantarillado);
            st.setBoolean(4, this.pozoSeptico);
            st.setBoolean(5, this.internet);
            st.setBoolean(6, this.energiaElectrica);
            st.setBoolean(7, this.gasDomiciliario);

            st.executeUpdate();
            st.close();

            PreparedStatement st2 = con.prepareStatement("INSERT INTO vivienda (id, numero_habitaciones, numero_banos, id_apartamento) VALUES(?,?,?,?)");
            st2.setString(1, this.getIdentificador());
            st.setInt(2, this.getNumeroHabitaciones());
            st.setInt(3, this.getNumeroBanos());
            st2.setString(4, this.getIdentificador());

            st2.executeUpdate();
            st2.close();

            PreparedStatement st3 = con.prepareStatement("UPDATE propiedad SET" +
                    "id_vivienda= "+ this.getIdentificador() +" " +
                    "WHERE id = '"+this.getIdentificador()+"'");

            st3.executeUpdate();
            st3.close();

            con.close();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
