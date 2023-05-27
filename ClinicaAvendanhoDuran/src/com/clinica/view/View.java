/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.view;

import com.clinica.baseDatos.SingletonConexion;

/**
 *
 * @author marcosfa
 */
public class View {
    
    public static void mostrarLogIn(){
            Login x = new Login();
            x.setVisible(true);
    }
    
    public static void mostrarDentista(){
        Dentista x = new Dentista();
        x.setVisible(true);
    }
    
    public static void infoUser(SingletonConexion x){
       x.toString();
    }
    
    public static void mostrarRegistro(){
        Registro x = new Registro();
        x.setVisible(true);
    }

    public static void mostrarAdmin(){
        Admin x = new Admin();
        x.setVisible(true);
    }
    
   
}
