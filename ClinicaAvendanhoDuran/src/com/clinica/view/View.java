/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.view;

import com.clinica.baseDatos.SConexion;
import com.clinica.clases.Paciente;
import com.clinica.clases.Trabajador;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marcosfa
 */
public class View {
    
    public static void mostrarLogIn(){
            Login x = new Login();
            x.setVisible(true);
    }
    
    public static void mostrarDentista(){
        Dentista x = new Dentista();
        x.setVisible(true);
    }
    
    public static void infoUser(SConexion x){
       x.toString();
    }
    
    public static void mostrarRegistro(){
        Registro x = new Registro();
        x.setVisible(true);
    }
    
    public static void mostrarRegistroPacientes(){
        RegistroPacientes x = new RegistroPacientes();
        x.setVisible(true);
    }

    public static void mostrarAdmin(){
        Admin x = new Admin();
        x.setVisible(true);
    }
    
    public static void mostrarTrabajadores(ArrayList<Trabajador> lista){
         int i = 0;
        for (Trabajador trabajador : lista) {
           
            i++;
            System.out.println("Trabajador " + i+": " + trabajador);
        }
    }
    
    public static void mostrarActualizarP(){
         UpdatePWD x = new UpdatePWD();
        x.setVisible(true);
    }
    
    public static void pwdUpdated(){
        System.out.println("Joptionpane actualizado");
    }
   
    
    public static void mostrarPacientesEnTabla(ArrayList<Paciente> pacientes, JTable tabla) {
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("DNI");
    modelo.addColumn("Nombre");
    modelo.addColumn("Apellido1");
    modelo.addColumn("Apellido2");
    modelo.addColumn("Edad");

    for (Paciente paciente : pacientes) {
        Object[] fila = new Object[5];
        fila[0] = paciente.getDni();
        fila[1] = paciente.getNombre();
        fila[2] = paciente.getApellido1();
        fila[3] = paciente.getApellido2();
        fila[4] = paciente.getEdad();
        modelo.addRow(fila);
    }

    tabla.setModel(modelo);
}
    
    /**
     * muestra los trabajadores en la tabla
     * @param pacientes
     * @param tabla 
     */
    public static void mostrarTrabajadoresTabla(ArrayList<Trabajador> trabajadores, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Edad");

        for (Trabajador trabajador : trabajadores) {
            Object[] fila = new Object[4];
            fila[0] = trabajador.getDni();
            fila[1] = trabajador.getNombre();
            fila[2] = trabajador.getApellido1();
            fila[3] = trabajador.getEdad();
            modelo.addRow(fila);
        }
        tabla.setModel(modelo);
    }
    
    

}
