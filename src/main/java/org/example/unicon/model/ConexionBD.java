package org.example.unicon.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    public static void main(String[] args) {
        Connection conexion = null;

        try {
            // Cargar el driver JDBC
            Class.forName("org.postgresql.Driver");

            // Establecer la conexión a la base de datos
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String usuario = "postgres";
            String contraseña = "admin";
            conexion = DriverManager.getConnection(url, usuario, contraseña);

            if (conexion != null) {
                System.out.println("Conexión exitosa a la base de datos PostgreSQL");
                // Aquí puedes realizar consultas, inserciones, actualizaciones, etc.
            } else {
                System.out.println("No se pudo conectar a la base de datos");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error: no se encontró el driver JDBC");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error: conexión fallida");
            e.printStackTrace();
        } finally {
            try {
                if (conexion != null && !conexion.isClosed()) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
