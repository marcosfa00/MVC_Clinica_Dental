/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.model;

import com.clinica.baseDatos.SConexion;
import com.clinica.clases.Paciente;
import javax.swing.JTable;

/**
 *
 * @author marcosfa
 */
public class ModelDentista {
    static SConexion singleton = SConexion.getInstance();
   /**
    * Muestra el historial médico
    * @param dni
    * @param tabla  en la que se va a mostrar el historial
    */ 
  public static void mostrarHistorialMedico(String dni, JTable tabla){
      singleton.mostrarHistorialMedico(dni, tabla);
  }
    
}
