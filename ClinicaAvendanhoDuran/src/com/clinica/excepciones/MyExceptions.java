/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clinica.excepciones;

import com.clinica.imagenes.icon;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author marcosfa
 */
/**
 * La clase MyExceptions es una clase personalizada que extiende la clase Exception.
 * Proporciona métodos para mostrar excepciones personalizadas en forma de diálogos emergentes.
 */
public class MyExceptions extends Exception {

    /**
     * La imagen de icono asociada a las excepciones.
     */
    public static final ImageIcon icono = new ImageIcon(MyExceptions.class.getResource("/imágenes/logo_diente_icon.png"));

    /**
     * Constructor por defecto de la clase MyExceptions.
     */
    public MyExceptions() {
        // Constructor vacío
    }

    /**
     * Muestra una excepción personalizada en forma de diálogo emergente.
     * @param msg El mensaje de la excepción.
     * @param title El título del diálogo emergente.
     */
    public void showException(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, 0, (Icon) icono);
    }
}