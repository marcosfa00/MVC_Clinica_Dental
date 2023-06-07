/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.model;

import com.clinica.baseDatos.SConexion;
import com.clinica.clases.Paciente;
import com.clinica.clases.Trabajador;
import java.util.Observable;





/**
 *
 * @author marcosfa
 */
/**
 * La clase ModelRegistro proporciona métodos estáticos para registrar trabajadores y pacientes en un sistema.
 * Utiliza una instancia de la clase SConexion para realizar las operaciones de inserción y eliminación.
 */
public class ModelRegistro{
    
    static SConexion singleton = SConexion.getInstance();
    
    /**
     * Registra un objeto Trabajador en el sistema.
     * @param work El objeto Trabajador a registrar.
     */
    public static void Registrar(Trabajador work){
        singleton.insertarTrabajador(work);
    }
    
    /**
     * Registra un objeto Paciente en el sistema.
     * @param p El objeto Paciente a registrar.
     */
    public static void registroPacientes(Paciente p){
        singleton.insertarPaciente(p);
    }
    
    /**
     * Elimina un paciente del sistema utilizando su número de identificación (DNI).
     * También se eliminan los registros asociados al historial médico del paciente.
     * @param dni El número de identificación del paciente a eliminar.
     */
    public static void eliminarPacientes(String dni){
        singleton.eliminarRegistroHistorial_medico(dni);
        singleton.eliminarRegistroPacientes(dni);
    }
}
