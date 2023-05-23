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
    
    public void logIn(){
            Clinica x = new Clinica();
            x.setVisible(true);
    }
    
    public void infoUser(SingletonConexion x){
       x.toString();
    }

    
}
