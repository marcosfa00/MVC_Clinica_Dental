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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return  dni + ", " + nombre + ", " + apellido1 + ", " + apellido2 + ", " + edad+ ", ";
    }
    
    
    
}
