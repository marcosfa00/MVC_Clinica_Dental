/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.clases;

/**
 *
 * @author marcosfa
 */
public class Persona{
    /**
     * Declaramos atributos necesarios clase persona
     * El DNI será la clave primaria
     */
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    
    /**
     * Constructor por defcto
     */
    public Persona(){
        
    }
    /**
     * Constructor parametrizado
     * @param dni
     * @param nombre
     * @param apellido1
     * @param apellido2 
     */
    public Persona(String dni,String nombre,String apellido1,String apellido2){
        this.dni = dni;
        this.nombre =nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }
    
    
    
}
