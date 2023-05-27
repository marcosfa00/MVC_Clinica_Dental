/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.clases;

/**
 *
 * @author marcosfa
 */
public class Trabajador extends Persona{
   private String especialidad;

    public Trabajador(String especialidad) {
        this.especialidad = especialidad;
    }

    public Trabajador(String especialidad, String dni, String nombre, String apellido1, String apellido2, int edad) {
        super(dni, nombre, apellido1, apellido2, edad);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return super.toString() +"Trabajador{" + "especialidad=" + especialidad + '}';
    }

   
   
    
    
}
