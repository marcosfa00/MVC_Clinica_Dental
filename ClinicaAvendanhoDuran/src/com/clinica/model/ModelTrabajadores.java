/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.model;

import com.clinica.baseDatos.SConexion;
import com.clinica.clases.Paciente;
import com.clinica.controller.Controller;
import javax.swing.JTable;

/**
 *
 * @author marcosfa
 */
/**
 * La clase ModelTrabajadores proporciona métodos estáticos para realizar operaciones relacionadas con los trabajadores en un sistema.
 * Utiliza una instancia de la clase SConexion para interactuar con los datos y realizar las operaciones.
 */
public class ModelTrabajadores {
    
    static SConexion singleton = SConexion.getInstance();
    
    /**
     * Muestra el historial de un trabajador en una tabla específica.
     * @param dni El número de identificación (DNI) del trabajador.
     * @param tabla La tabla donde se mostrará el historial del trabajador.
     */
    public static void mostrarHistorialTrabajadores(String dni, JTable tabla){
        singleton.mostrarHistorialTrabajadores(dni, tabla);
    }
    
    /**
     * Inserta un nuevo trabajador en el sistema utilizando su número de identificación (DNI).
     * Este método no tiene implementación en el código proporcionado y debe ser implementado según los requisitos del sistema.
     * @param dni El número de identificación del trabajador a insertar.
     */
    public static void insertarTrabajador(String dni){
        // Método para agregar un trabajador.
        // Implementación requerida según los requisitos del sistema.
    }
    
    /**
     * Elimina un trabajador del sistema utilizando su número de identificación (DNI).
     * @param dni El número de identificación del trabajador a eliminar.
     */
    public static void eliminarTrabajador(String dni){
        singleton.eliminarRegistroTrabajador(dni);
    }
}

