/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Fede
 */
public class ExceptionServicio extends Exception{

    /**
     * Esta excepcion esta creada para todos los casos en los que hay algun problema ya sea 
     * con la creacion de un servicio, con su agregado alguna lista o con su busqueda en alguna lista.
     * @param message 
     */
    
    public ExceptionServicio(String message) {
        super(message);
    }
    
}
