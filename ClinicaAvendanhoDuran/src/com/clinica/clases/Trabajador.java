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
import java.util.Random;

/**
 * La clase Trabajador representa a un trabajador en el sistema.
 * Hereda de la clase Persona y agrega atributos y comportamientos específicos de un trabajador.
 */
public class Trabajador extends Persona {
    private String especialidad = "Dentista";
    private String pwd;
    
    /**
     * Constructor vacío de la clase Trabajador.
     */
    public Trabajador() {
        
    }
    
    /**
     * Constructor de la clase Trabajador que inicializa los atributos de un trabajador con los valores proporcionados.
     * @param dni El número de identificación del trabajador.
     * @param nombre El nombre del trabajador.
     * @param apellido1 El primer apellido del trabajador.
     * @param apellido2 El segundo apellido del trabajador.
     * @param edad La edad del trabajador.
     */
    public Trabajador(String dni, String nombre, String apellido1, String apellido2, int edad) {
        super(dni, nombre, apellido1, apellido2, edad);
        this.especialidad = obtenerEspecialidadAleatoria();
        this.pwd = "123";
    }
    
    /**
     * Obtiene la especialidad del trabajador.
     * @return La especialidad del trabajador.
     */
    public String getEspecialidad() {
        return especialidad;
    }
    
    /**
     * Establece la especialidad del trabajador.
     * @param especialidad La nueva especialidad del trabajador.
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    /**
     * Establece la contraseña del trabajador.
     * @param pwd La nueva contraseña del trabajador.
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    /**
     * Obtiene la contraseña del trabajador.
     * @return La contraseña del trabajador.
     */
    public String getPwd() {
        return this.pwd;
    }
    
    /**
     * Genera una especialidad aleatoria para el trabajador a partir de una lista predefinida.
     * @return La especialidad aleatoria del trabajador.
     */
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
    
    /**
     * Devuelve una representación en forma de cadena de caracteres del trabajador.
     * @return La representación en forma de cadena de caracteres del trabajador.
     */
    @Override
    public String toString() {
        return super.toString() + especialidad + ", " + pwd;
    }
}
