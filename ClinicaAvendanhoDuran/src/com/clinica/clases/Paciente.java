/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.clases;

/**
 *
 * @author marcosfa
 */
/**
 * La clase Paciente representa a un paciente en el sistema.
 * Hereda de la clase Persona y agrega un atributo específico para el historial médico.
 */
public class Paciente extends Persona {
    private String historial_Medico = "Revisión";
    
    /**
     * Constructor vacío de la clase Paciente.
     */
    public Paciente() {
        
    }
    
    /**
     * Constructor de la clase Paciente que inicializa los atributos de un paciente con los valores proporcionados.
     * @param dni El número de identificación del paciente.
     * @param nombre El nombre del paciente.
     * @param apellido1 El primer apellido del paciente.
     * @param apellido2 El segundo apellido del paciente.
     * @param edad La edad del paciente.
     */
    public Paciente(String dni, String nombre, String apellido1, String apellido2, int edad) {
        super(dni, nombre, apellido1, apellido2, edad);
    }
}
