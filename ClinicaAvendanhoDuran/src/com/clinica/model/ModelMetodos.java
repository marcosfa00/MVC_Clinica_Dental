/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.model;

/**
 *
 * @author marcosfa
 */
public class ModelMetodos {
    
    
    public Boolean login(String user,String pwd){
        
        if (user.contains("user1")&& pwd.contains("123")) {
            return true;
        }
        else{
            return false;
        }
    }
    
}
