/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.model;

import com.clinica.baseDatos.SConexion;
import com.clinica.clases.Paciente;
import com.clinica.controller.Controller;
import javax.swing.JTable;

/**
 *
 * @author marcosfa
 */
public class ModelTrabajadores {
    static SConexion singleton = SConexion.getInstance();
    
  public static void mostrarHistorialTrabajadores(String dni, JTable tabla){
      singleton.mostrarHistorialTrabajadores(dni, tabla);
  }
  
  public static void insertarTrabajador(String dni){
      //metodo agregar trabajador
      
  }
  
  public static void eliminarTrabajador(String dni){
      singleton.eliminarRegistroTrabajador(dni);
  }
    
}
