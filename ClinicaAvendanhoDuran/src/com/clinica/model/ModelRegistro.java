/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.model;

import com.clinica.baseDatos.SConexion;
import com.clinica.clases.Paciente;
import com.clinica.clases.Trabajador;





/**
 *
 * @author marcosfa
 */
public class ModelRegistro {
    static SConexion singleton = SConexion.getInstance();

public static void Registrar(Trabajador work){
    singleton.insertarTrabajador(work);
    
}

public static void registroPacientes(Paciente p){
    singleton.insertarPaciente(p);
    
}

public static void eliminarPacientes(String dni){
    singleton.eliminarRegistroHistorial_medico(dni);
    singleton.eliminarRegistroPacientes(dni);
}
    
}
