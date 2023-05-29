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
import java.sql.PreparedStatement;

public class SConexion {
    private static SConexion instance = null;
    private static Connection conexion = null;
    private static final String db = "clinicadental";
    private static final String host = "localhost";
    private static final String puerto = "5434";
    public ArrayList<Trabajador> trabajadores = new ArrayList<>();
    
    
    
    
      private SConexion() {
        // Constructor privado para evitar la creación de instancias directamente
    }

    public static  SConexion getInstance() {
        if (instance == null) {
            instance = new SConexion();
        }
        return instance;
    }

    public  Connection getConexion() throws SQLException {
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

    private  void mostrarSearchPath(Statement statement) {
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

    public  ArrayList<Trabajador> obtenerTrabajadores() {
        

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

                Trabajador trabajador = new Trabajador(dni, nombre, apellido1, apellido2, edad);
                trabajador.setEspecialidad(especialidad);
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
    
    
    public  void insertarTrabajador(Trabajador trabajador) {
    try {
        Connection conexion = (Connection) getConexion();

        // Crear la sentencia SQL para la inserción
        String sql = "INSERT INTO clinica.trabajadores (dni, nombre, apellido1, apellido2, edad, especialidad) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        // Preparar la sentencia
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setString(1, trabajador.getDni());
        statement.setString(2, trabajador.getNombre());
        statement.setString(3, trabajador.getApellido1());
        statement.setString(4, trabajador.getApellido2());
        statement.setInt(5, trabajador.getEdad());
        statement.setString(6, trabajador.getEspecialidad());

        // Ejecutar la sentencia
        int filasAfectadas = statement.executeUpdate();

        // Cerrar el PreparedStatement y la conexión después de usarlos
        statement.close();
        conexion.close();

        if (filasAfectadas > 0) {
            System.out.println("Inserción exitosa");
        } else {
            System.out.println("Error al insertar el trabajador");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    }
    
    
    
    public void actualizarContrasenha(String dni, String contrasenha) {
    try {
        Connection conexion = getConexion();

        // Crear una sentencia SQL para actualizar la contraseña del trabajador
        String sql = "UPDATE clinica.trabajadores SET contrasenha = ? WHERE dni = ?";
        PreparedStatement statement = conexion.prepareStatement(sql);

        // Establecer los valores de los parámetros en la sentencia SQL
        statement.setString(1, contrasenha);
        statement.setString(2, dni);

        // Ejecutar la consulta SQL para actualizar la contraseña
        int filasAfectadas = statement.executeUpdate();

        // Verificar si se actualizó correctamente la contraseña
        if (filasAfectadas > 0) {
            System.out.println("Contraseña actualizada correctamente");
        } else {
            System.out.println("No se pudo actualizar la contraseña");
        }

        // Cerrar el Statement y la conexión después de usarlos
        statement.close();
        conexion.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
