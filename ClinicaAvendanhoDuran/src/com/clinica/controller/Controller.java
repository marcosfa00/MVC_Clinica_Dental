/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.controller;

import com.clinica.baseDatos.SingletonConexion;
import static com.clinica.baseDatos.SingletonConexion.ADMIN;
import static com.clinica.baseDatos.SingletonConexion.DENTISTA;
import static com.clinica.baseDatos.SingletonConexion.RECEPCIONISTA;
import com.clinica.model.ModelConexion;
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
    public static void main(String[] args) throws SQLException {
       
      
       
      
              vista.logIn();
              SingletonConexion usrDentist = SingletonConexion.getInstance(DENTISTA);
              SingletonConexion userRecepcion  = SingletonConexion.getInstance(RECEPCIONISTA);
              System.out.println("info de ambos objetos instaciados");
              vista.infoUser(userRecepcion);
              vista.infoUser(usrDentist);
              //Mconexion.getConexion(DENTISTA);
              Mconexion.getConexion(ADMIN);
              
    }
    
}
