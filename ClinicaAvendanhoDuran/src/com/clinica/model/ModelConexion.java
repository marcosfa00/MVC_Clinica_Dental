/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.model;


import java.sql.Statement;
import java.sql.ResultSet;
import com.clinica.baseDatos.SingletonConexion;
import static com.clinica.baseDatos.SingletonConexion.USUARIOS;
import static com.clinica.baseDatos.SingletonConexion.ADMIN;
import com.clinica.clases.Trabajador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marcosfa
 */
public class ModelConexion {
    static SingletonConexion usuarioBaseDatos  = null;
    private Connection conexion = null;
    private String db="clinicadental"; 
    private String host="localhost";
    private String puerto="5434";
    
     public ArrayList<Trabajador> trabajadores = new ArrayList<>();
    
    
   /**
     * Método para obtener la conexión con la base de datos
     * @return Conexión con la base de datos
     */
    public Connection getConexion(int device) throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            try {
                // Cargar el driver de PostgreSQL
                Class.forName("org.postgresql.Driver");
                
                // Construir la URL de conexión
                String url = "jdbc:postgresql://" + host + ":" + puerto + "/" + db;
                
                // Establecer la conexión
               usuarioBaseDatos = SingletonConexion.getInstance(device);
                conexion = DriverManager.getConnection(url, usuarioBaseDatos.getUsuario(), usuarioBaseDatos.getContrasenha());
                System.out.println("La conexión se ha realizado correctamente");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return conexion;
    }
    
    public void obtenerTrabajadores() {
    try {
        SingletonConexion singletonConexion = SingletonConexion.getInstance(ADMIN);
        Connection conexion = getConexion(ADMIN);

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
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


}
