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
    
    
   
    
    /**
     * Método para devolver el trabajador conectado a la base de datos
     * @param user USUARIO ESCRITO
     * @param pwd CONTRASEÑA ESCRITA
     * @param lista QUE CONTIENE TODOS LOS TRABAJADORES
     * @return Boolean
     */
   public static Trabajador loginUser(String user, String pwd, ArrayList<Trabajador> lista) {
    for (Trabajador trabajador : lista) {
        if (trabajador.getDni().equals(user) && trabajador.getPwd().equals(pwd)) {
           return trabajador;
        }
    }
    
    return null; // No se encontró ningún trabajador con las credenciales proporcionadas
}


    
    
}
