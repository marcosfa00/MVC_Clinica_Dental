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
public class MyExceptions extends Exception {
    public static final ImageIcon icono = new ImageIcon(MyExceptions.class.getResource("/imágenes/logo_diente_icon.png"));
    public MyExceptions() {
       
       
    }
    
   public void showException(String msg, String title){
        JOptionPane.showMessageDialog(null, msg, title, 0, (Icon) icono);
   }
    
    
}
