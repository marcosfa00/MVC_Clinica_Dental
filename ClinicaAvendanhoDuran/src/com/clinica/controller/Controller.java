/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.controller;

import com.clinica.baseDatos.SConexion;
import com.clinica.clases.Paciente;

import com.clinica.clases.Trabajador;
import com.clinica.excepciones.MyExceptions;
import com.clinica.model.ModelDentista;

import com.clinica.model.ModelLogin;
import com.clinica.model.ModelRegistro;
import com.clinica.model.ModelTrabajadores;
import com.clinica.view.View;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JTable;

/**
 *
 * @author marcosfa
 */
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import com.clinica.observer.ObserverRegistro;

/**
 * La clase Controller es la clase principal que actúa como controlador en el sistema.
 * Proporciona métodos estáticos para manejar la lógica de negocio y la interacción entre el modelo y la vista.
 */
public class Controller {
    
    static SConexion singleton = SConexion.getInstance();
    static ModelLogin modelLog = new ModelLogin();
    
    /**
     * Realiza el inicio de sesión utilizando el modelo de inicio de sesión para autenticar las credenciales del usuario.
     * @param user El nombre de usuario proporcionado.
     * @param pwd La contraseña proporcionada.
     * @param list La lista de trabajadores en la cual se buscará al usuario autenticado.
     */
    public static void LogIn(String user, String pwd, ArrayList<Trabajador> list) {
        list = singleton.trabajadores;
        Trabajador worker = new Trabajador();
        worker = ModelLogin.loginUser(user, pwd, list);
        
        if (worker == null) {
            //throw new MyExceptions().showException("", "");
            System.out.println("Error al buscar trabajador");
        } else {
            if (worker.getEspecialidad().contains("admin")) {
                System.out.println(worker.getEspecialidad());
                View.mostrarAdmin();
                System.out.println("Se ejecuta vista de admin");
            } else {
                View.mostrarDentista();
                System.out.println("No se ejecuta vista de admin");
            }
        }
    }
    
    /**
     * Obtiene una conexión a la base de datos según el dispositivo especificado.
     * @param device El dispositivo para el cual se solicita la conexión.
     * @throws SQLException Si ocurre un error al obtener la conexión.
     */
    public static void getConexion(int device) throws SQLException {
        singleton.getConexion();
    }
    
    /**
     * Registra un nuevo trabajador en el sistema utilizando los detalles proporcionados.
     * @param dni El número de identificación del trabajador.
     * @param nombre El nombre del trabajador.
     * @param apellido El primer apellido del trabajador.
     * @param apellido2 El segundo apellido del trabajador.
     * @param edad La edad del trabajador.
     */
    public static void registrar(String dni, String nombre, String apellido, String apellido2, int edad) {
        Trabajador work = new Trabajador(dni, nombre, apellido, apellido2, edad);
        ModelRegistro.Registrar(work);
    }
    
    /**
     * Registra un nuevo paciente en el sistema utilizando los detalles proporcionados.
     * @param dni El número de identificación del paciente.
     * @param nombre El nombre del paciente.
     * @param apellido El primer apellido del paciente.
     * @param apellido2 El segundo apellido del paciente.
     * @param edad La edad del paciente.
     */
    
   
    public static void registrarPacientes(String dni, String nombre, String apellido, String apellido2, int edad) {
        Paciente p = new Paciente(dni, nombre, apellido, apellido2, edad);
        ModelRegistro.registroPacientes(p);
    }
    
    /**
     * Registra un nuevo trabajador en el sistema utilizando los detalles proporcionados, incluyendo especialidad y contraseña.
     * @param dni El número de identificación del trabajador.
     * @param nombre El nombre del trabajador.
     * @param apellido El primer apellido del trabajador.
     * @param apellido2 El segundo apellido del trabajador.
     * @param edad La edad del trabajador.
     * @param especialidad La especialidad del trabajador.
     * @param contrasenha La contraseña del trabajador.
     */
    public static void registrarTrabajdores(String dni, String nombre, String apellido, String apellido2, int edad, String especialidad, String contrasenha) {
        Trabajador work = new Trabajador(dni, nombre, apellido, apellido2, edad);
        ModelRegistro.Registrar(work);
    }
    
    /**
     * Cambia la contraseña de un trabajador utilizando su número de identificación (DNI).
     * @param dni El número de identificación del trabajador.
     * @param contrasenha La nueva contraseña para el trabajador.
     */
    public static void cambiarPWD(String dni, String contrasenha) {
        singleton.actualizarContrasenha(dni, contrasenha);
        View.pwdUpdated();
        View.mostrarTrabajadores(singleton.trabajadores);
    }
    
    /**
     * Muestra la lista de pacientes en una tabla específica.
     * @param tabla La tabla donde se mostrará la lista de pacientes.
     */
    public static void mostrarPaciente(JTable tabla) {
        View.mostrarPacientesEnTabla(singleton.getPacientes(), tabla);
    }
    
    /**
     * Muestra la lista de trabajadores en una tabla específica.
     * @param tabla La tabla donde se mostrará la lista de trabajadores.
     */
    public static void mostrarTrabajadores(JTable tabla) {
        View.mostrarTrabajadoresTabla(singleton.mostrarTrabajadores(), tabla);
    }
    
    /**
     * Muestra el historial médico de un paciente en una tabla específica.
     * @param dni El número de identificación del paciente.
     * @param tabla La tabla donde se mostrará el historial médico.
     */
    public static void mostrarHistorialMedico(String dni, JTable tabla) {
        ModelDentista.mostrarHistorialMedico(dni, tabla);
    }
    
    /**
     * Muestra el historial de un trabajador en una tabla específica.
     * @param dni El número de identificación del trabajador.
     * @param tabla La tabla donde se mostrará el historial del trabajador.
     */
    public static void mostrarHistorialTrabajadores(String dni, JTable tabla) {
        ModelTrabajadores.mostrarHistorialTrabajadores(dni, tabla);
    }
    
    /**
     * Elimina un paciente del sistema utilizando su número de identificación (DNI).
     * @param dni El número de identificación del paciente a eliminar.
     * @param tabla La tabla donde se mostrará la lista actualizada de pacientes después de la eliminación.
     */
    public static void eliminarPaciente(String dni, JTable tabla) {
        ModelRegistro.eliminarPacientes(dni);
    }
    
    /**
     * Elimina un trabajador del sistema utilizando su número de identificación (DNI).
     * @param dni El número de identificación del trabajador a eliminar.
     * @param tabla La tabla donde se mostrará la lista actualizada de trabajadores después de la eliminación.
     */
    public static void eliminarTrabajador(String dni, JTable tabla) {
        ModelTrabajadores.eliminarTrabajador(dni);
    }
    
    /**
     * Añade un tratamiento al historial médico de un paciente utilizando su número de identificación (DNI) y una descripción del tratamiento.
     * @param dni El número de identificación del paciente.
     * @param descripcion La descripción del tratamiento.
     */
    public static void anhadirTratamiento(String dni, String descripcion) {
        singleton.insertarHistorialMedico(dni, descripcion);
    }
    
    /**
     * Método main para ejecutar la aplicación.
     * @param args Los argumentos de la línea de comandos.
     * @throws SQLException Si ocurre un error relacionado con la base de datos.
     */
    public static void main(String[] args) throws SQLException {
        ObserverRegistro obxO = new ObserverRegistro();
        singleton.addObserver(obxO);
        
        View.mostrarLogIn();
        
        ArrayList<Trabajador> lista = new ArrayList<>();
        lista = singleton.getTrabajadores();
        View.mostrarTrabajadores(lista);
    }
}
