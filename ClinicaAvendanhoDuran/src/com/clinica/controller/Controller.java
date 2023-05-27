/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.controller;

import com.clinica.baseDatos.SingletonConexion;
import static com.clinica.baseDatos.SingletonConexion.ADMIN;
import static com.clinica.baseDatos.SingletonConexion.USUARIOS;
import com.clinica.excepciones.MyExceptions;
import com.clinica.model.ModelConexion;
import com.clinica.model.ModelLogin;
import com.clinica.view.View;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author marcosfa
 */
public class Controller {
    
    static View vista = new View();
    static ModelConexion Mconexion = new ModelConexion();
    static ModelLogin modelLog = new ModelLogin();
    
    /**
     * MÉTODO LOG IN QUE LLAAM AL MODELO LOG IN PARA DIFERENCIAR CÓMO HACER LA CONEXIÓN CON LA BASE DE DATOS
     * @param user
     * @param pwd
     * @throws SQLException 
     */
    public static void LogIn(String user,String pwd) throws SQLException{
       if( modelLog.loginAdmin(user, pwd)){
           Mconexion.getConexion(ADMIN);
           vista.mostrarAdmin();
       }else if(modelLog.loginAdmin(user, pwd)){
           Mconexion.getConexion(USUARIOS);
           
       }
       else{
           System.out.println("Error en el log in");
       }
        
    }
    
    public static void getConexion(int device) throws SQLException{
        Mconexion.getConexion(device);
    }
    
      
       
    
    
    
    
    /**
     * METODO MAIN
     * @param args
     * @throws SQLException 
     */
    
    public static void main(String[] args) throws SQLException {

              vista.mostrarLogIn();
              
              
              
              
             
              
    }
    
}
