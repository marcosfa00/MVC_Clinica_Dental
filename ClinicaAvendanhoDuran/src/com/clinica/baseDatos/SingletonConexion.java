
package com.clinica.baseDatos;

import java.sql.Connection;

/**
 *
 * @author marcosfa
 */
public class SingletonConexion {
    /**
     * Declaramos los tipos de usuariso que queremos
     */
    public static final int DENTISTA =0; 
    public static final int RECEPCIONISTA =1; 
    //vamos a crear un usuario Admin por si en un futuro queremos añadir elementos como configuración de la base de datos
    public static final int ADMIN=2;
    
    /**
     * Atributos para realizar la conexión con la base de datos
     */
    
   
    private String usuario="";
    private String contrasenha="";
   
   
    /**
     * Declaramos objeto conexion para hacer Singleton
     */
    private static SingletonConexion instance = null;
    
    /**
     * Constructor bloqueado con private
     */
    private SingletonConexion(){
        
    }
    
    private static String getUser(int device){
        
        switch(device){
            case DENTISTA:
                return "dentista*dent1";
               
            case RECEPCIONISTA:
                return "recepcion*recep1";
            case ADMIN:
                return "postgres*postgres";
               
        }
        return null;
    }
    
    /**
     * Creamos un método GetInstance para devolver siempre el mismo objeto 
     * @return objeto singleton --> Conexión
     */
    public static SingletonConexion getInstance(int user){
         if (instance == null) {
                instance = new SingletonConexion();
         }
         String []username = getUser(user).split("\\*");//En java la barra invertida \\ se emplea para indicar que estas buscando un caracter literal 
         instance.usuario = username[0];
         instance.contrasenha = username[1];
           System.out.println("Instance: " + instance);
            return instance;
          

         }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    
    
    @Override
    public String toString() {
        return "SingletonConexion{ usuario=" + usuario + ", contrasenha=" + contrasenha + '}';
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    
}
