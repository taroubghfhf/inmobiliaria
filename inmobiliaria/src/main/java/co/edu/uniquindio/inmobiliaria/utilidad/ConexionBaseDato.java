package co.edu.uniquindio.inmobiliaria.utilidad;

import lombok.Getter;

import java.sql.*;

public class ConexionBaseDato {
    private static ConexionBaseDato instance;
    @Getter
    private Connection connection;
    private String url= "jdbc:postgresql://localhost:5432/inmobiliaria";
    private String username = "postgres";
    private String password = "password";

    private ConexionBaseDato() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public static ConexionBaseDato getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConexionBaseDato();
        } else if (instance.getConnection().isClosed()) {
            instance = new ConexionBaseDato();
        }

        return instance;
    }
}
