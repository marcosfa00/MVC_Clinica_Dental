/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.clases;

import java.util.Random;

/**
 *
 * @author marcosfa
 */
public class Trabajador extends Persona{
   private String especialidad = "Dentista";

    public Trabajador() {
        
    }

    public Trabajador( String dni, String nombre, String apellido1, String apellido2, int edad) {
        super(dni, nombre, apellido1, apellido2, edad);
        this.especialidad = obtenerEspecialidadAleatoria();
    }

    public String getEspecialidad() {
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }


     public static String obtenerEspecialidadAleatoria() {
        String[] especialidades = {
            "Odontología general",
            "Ortodoncia",
            "Periodoncia",
            "Endodoncia",
            "Odontopediatría",
            "Cirugía oral y maxilofacial",
            "Odontología estética"
        };

        Random random = new Random();
        int indiceAleatorio = random.nextInt(especialidades.length);
        
        return especialidades[indiceAleatorio];
    }
     
    @Override
    public String toString() {
        return super.toString() +"Trabajador{" + "especialidad=" + especialidad + '}';
    }

   
   
    
    
}
