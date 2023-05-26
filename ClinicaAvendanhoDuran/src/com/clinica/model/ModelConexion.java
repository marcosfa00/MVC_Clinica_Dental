/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.model;

import com.clinica.baseDatos.SingletonConexion;
import static com.clinica.baseDatos.SingletonConexion.USUARIOS;
import static com.clinica.baseDatos.SingletonConexion.ADMIN;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    
    
}
