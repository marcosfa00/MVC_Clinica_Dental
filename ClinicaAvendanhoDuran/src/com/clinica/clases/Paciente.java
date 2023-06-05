/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.clases;

/**
 *
 * @author marcosfa
 */
public class Paciente extends Persona {
    
    String historial_Medico ="Revisión";

    public Paciente() {
    }

    public Paciente(String dni, String nombre, String apellido1, String apellido2, int edad) {
        super(dni, nombre, apellido1, apellido2, edad);
    }
    
    
    
}
