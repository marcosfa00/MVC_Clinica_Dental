/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.baseDatos;

/**
 *
 * @author marcosfa
 */
import com.clinica.clases.Trabajador;
import com.clinica.view.View;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SConexion {
    private static SConexion instance = null;
    private static Connection conexion = null;
    private static final String db = "clinicadental";
    private static final String host = "localhost";
    private static final String puerto = "5434";
    
    
    
    
    
      private SConexion() {
        // Constructor privado para evitar la creación de instancias directamente
    }

    public static SConexion getInstance() {
        if (instance == null) {
            instance = new SConexion();
        }
        return instance;
    }

    public static Connection getConexion() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            try {
                // Cargar el driver de PostgreSQL
                Class.forName("org.postgresql.Driver");

                // Construir la URL de conexión
                String url = "jdbc:postgresql://" + host + ":" + puerto + "/" + db;

                // Establecer la conexión
                conexion = DriverManager.getConnection(url, "postgres", "postgres");

                // Establecer el esquema "clinica"
                Statement statement = conexion.createStatement();
                mostrarSearchPath(statement);

                System.out.println("La conexión se ha realizado correctamente");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return conexion;
    }

    private static void mostrarSearchPath(Statement statement) {
        try {
            // Crear una consulta para obtener el valor actual del "search_path"
            String sql = "SHOW search_path";
            ResultSet resultSet = statement.executeQuery(sql);

            // Leer el resultado de la consulta
            if (resultSet.next()) {
                String searchPath = resultSet.getString(1);
                System.out.println("Search Path actual: " + searchPath);
            }

            // Cerrar el ResultSet después de usarlo
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Trabajador> obtenerTrabajadores() {
        ArrayList<Trabajador> trabajadores = new ArrayList<>();

        try {
            Connection conexion = getConexion();

            // Crear una sentencia SQL para obtener los trabajadores de la tabla
            String sql = "SELECT * FROM clinica.trabajadores";

            // Ejecutar la consulta SQL
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Recorrer el resultado y construir la lista de trabajadores
            while (resultSet.next()) {
                String dni = resultSet.getString("dni");
                String nombre = resultSet.getString("nombre");
                String apellido1 = resultSet.getString("apellido1");
                String apellido2 = resultSet.getString("apellido2");
                int edad = resultSet.getInt("edad");
                String especialidad = resultSet.getString("especialidad");

                Trabajador trabajador = new Trabajador(especialidad, dni, nombre, apellido1, apellido2, edad);
                trabajadores.add(trabajador);
            }

            // Cerrar el ResultSet, el Statement y la conexión después de usarlos
            resultSet.close();
            statement.close();
            conexion.close();

            System.out.println("\nLISTA ACTUAL DE TRABAJADORES: \n");
            View.mostrarTrabajadores(trabajadores);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return trabajadores;
    }
}
