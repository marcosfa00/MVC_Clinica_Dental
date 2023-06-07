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
    private int edad;
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
     * @param edad
     */
    public Persona(String dni,String nombre,String apellido1,String apellido2, int edad){
        this.dni = dni;
        this.nombre =nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad; 
    }

 /**
     * Obtiene el número de identificación de la persona.
     * @return El número de identificación de la persona.
     */
    public String getDni() {
        return dni;
    }
    
    /**
     * Establece el número de identificación de la persona.
     * @param dni El nuevo número de identificación de la persona.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    /**
     * Obtiene el nombre de la persona.
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el nombre de la persona.
     * @param nombre El nuevo nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene el primer apellido de la persona.
     * @return El primer apellido de la persona.
     */
    public String getApellido1() {
        return apellido1;
    }
    
    /**
     * Establece el primer apellido de la persona.
     * @param apellido1 El nuevo primer apellido de la persona.
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    
    /**
     * Obtiene el segundo apellido de la persona.
     * @return El segundo apellido de la persona.
     */
    public String getApellido2() {
        return apellido2;
    }
    
    /**
     * Establece el segundo apellido de la persona.
     * @param apellido2 El nuevo segundo apellido de la persona.
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    
    /**
     * Obtiene la edad de la persona.
     * @return La edad de la persona.
     */
    public int getEdad() {
        return edad;
    }
    
    /**
     * Establece la edad de la persona.
     * @param edad La nueva edad de la persona.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    /**
     * Devuelve una representación en forma de cadena de caracteres de la persona.
     * @return La representación en forma de cadena de caracteres de la persona.
     */
    @Override
    public String toString() {
        return dni + ", " + nombre + ", " + apellido1 + ", " + apellido2 + ", " + edad + ", ";
    }
}
    
    

