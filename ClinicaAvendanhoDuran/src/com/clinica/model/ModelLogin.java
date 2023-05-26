/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.model;

import com.clinica.clases.Trabajador;
import java.util.ArrayList;

/**
 *
 * @author marcosfa
 */
public class ModelLogin {
    
    
    public Boolean loginAdmin(String user,String pwd){
        
        if (user.contains("postgres")&& pwd.contains("123")) {
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Método para devolver el trabajador conectado a la base de datos
     * @param user
     * @param pwd
     * @param lista
     * @return 
     */
    public Boolean loginUser(String user,String pwd, ArrayList<Trabajador> lista){
        
       
        return true;
        
        
    }
    
    
}
