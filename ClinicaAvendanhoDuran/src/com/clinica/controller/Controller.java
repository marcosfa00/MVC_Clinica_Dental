/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.controller;

import com.clinica.baseDatos.SConexion;

import com.clinica.clases.Trabajador;
import com.clinica.excepciones.MyExceptions;

import com.clinica.model.ModelLogin;
import com.clinica.model.ModelRegistro;
import com.clinica.view.View;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author marcosfa
 */
public class Controller {
    
   static SConexion singleton = SConexion.getInstance();
  
    static ModelLogin modelLog = new ModelLogin();
    
    /**
     * MÉTODO LOG IN QUE LLAAM AL MODELO LOG IN PARA DIFERENCIAR CÓMO HACER LA CONEXIÓN CON LA BASE DE DATOS
     * @param user
     * @param pwd
     * @throws SQLException 
     */
    public static void LogIn(String user,String pwd, ArrayList<Trabajador> list) {
       
           list = singleton.obtenerTrabajadores();
           Trabajador worker  = new Trabajador();
         worker=  ModelLogin.loginUser(user, pwd, list);
         if(worker == null){
             //throw new MyExceptions().showException("", "");
             System.out.println("Error al buscar trabajador");
         }else{
             if(worker.getEspecialidad().contains("admin")){
                 System.out.println(worker.getEspecialidad());
                 View.mostrarAdmin();
             }else{
                 View.mostrarDentista();
                 
                
             }
         }
      
        
    }
    
    public static void getConexion(int device) throws SQLException{
        singleton.getConexion();
    }
    
    public static void registrar(String dni,String nombre,String apellido,String apellido2,int edad){
       
        Trabajador work = new Trabajador(dni,nombre,apellido,apellido2,edad);
        
        ModelRegistro.Registrar(work);
    }
    
    public static void cambiarPWD(String dni,String contrasenha){
        singleton.actualizarContrasenha(dni, contrasenha);
        View.pwdUpdated();
    }
      
       
    
    
    
    
    /**
     * METODO MAIN
     * @param args
     * @throws SQLException 
     */
    
    public static void main(String[] args) throws SQLException {

              View.mostrarLogIn();
              ArrayList<Trabajador>lista = new ArrayList<>();
              lista =singleton.obtenerTrabajadores();
              View.mostrarTrabajadores(lista);
               
                
              
              
              
             
              
    }
    
}
