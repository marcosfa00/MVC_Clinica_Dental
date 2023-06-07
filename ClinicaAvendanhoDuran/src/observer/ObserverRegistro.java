/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

/**
 * clase que define los metodos que se ejecutan despues de que se ejecuten los metodos
 * que tienen los observable
 *
 * @author marcosfa
 */
public class ObserverRegistro implements Observer{

    @Override
    public void update(Observable o, Object arg) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        JOptionPane.showMessageDialog(null,"Se ha eliminado el registro correctamente");
    }
    
}
