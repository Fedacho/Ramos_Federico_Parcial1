/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import models.ExceptionServicio;
import models.Gastronomia;
import models.Hospedaje;
import models.Servicio;
import models.Sistema;

/**
 *
 * @author Fede
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("1-1");
        Servicio gastro1 = null;
        try {
            gastro1 = new Gastronomia("Hamburguesa Criolla", 180.00, 4, "4892", 15.0, true);
        } catch (ExceptionServicio e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("1-2");
        Gastronomia gastro2 = null;
        try {
            gastro2 = new Gastronomia("Hamburguesa Criolla", 180.00, 4, "489235", 15.0, true);
        } catch (ExceptionServicio e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("1-3");
        Servicio hospedaje1 = null;
        try {
            hospedaje1 = new Hospedaje("Cabaña 3 personas", 1500.00, "2872", 10.0, true);
        } catch (ExceptionServicio e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("1-4");
        Servicio hospedaje2 = null;
        try {
            hospedaje2 = new Hospedaje("Cabaña 3 personas", 1500.00, "287282", 10.0, true);
        } catch (ExceptionServicio e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("2-1");
        try {
            System.out.println(gastro2.calcularPrecioFinal(LocalDate.of(2020, Month.of(10), 28)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("2-2");
        try {
            System.out.println(hospedaje2.calcularPrecioFinal(LocalDate.of(2020, Month.of(10), 27)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("3-1");
        Sistema listaServicio = new Sistema();
        
      
        
        try {
            listaServicio.agregarGastronomia("858927", 15.0, true, "Milanesa con pure", 350.0, 3);
        } catch (ExceptionServicio e) {
            System.out.println(e.getMessage());
        }
        
        try {
            listaServicio.agregarHospedaje("489259", 10.0, true, "Habitacion triple",2200.00);
        } catch (ExceptionServicio e) {
            System.out.println(e.getMessage());
        }
        
        try {
            listaServicio.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.00, 3);
        } catch (ExceptionServicio e) {
            System.out.println(e.getMessage());
        }
             
        try {
            listaServicio.agregarHospedaje("758972", 15.0, false, "Habitacion simple",1000.00);
        } catch (ExceptionServicio e) {
            System.out.println(e.getMessage());
        }
        
        // Para comprobar si funciona la Exception de servicios repetidos.
        try {
            listaServicio.agregarHospedaje("758972", 15.0, false, "Habitacion simple",1000.00);
        } catch (ExceptionServicio e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println(listaServicio);
        
        System.out.println("4-1");
        System.out.println(listaServicio.traerServicio(true));
        
        
        System.out.println("4-2");
        System.out.println(listaServicio.traerServicio(true, LocalDate.of(2020, Month.of(10), 28)));
        
        
        System.out.println("Otras comprobaciones");
        // Para comprobar la busqueda correcta de un servicio en especifico.
        try {
            System.out.println(listaServicio.traerServicio("758972"));
        } catch (ExceptionServicio e) {
            System.out.println(e.getMessage());
        }
        
        // Para comprobar si funciona el Exception de solicitar un servicio que no este en lista.
        try {
            System.out.println(listaServicio.traerServicio("758932"));
        } catch (ExceptionServicio e) {
            System.out.println(e.getMessage());
        }
        
       
        
        
    }

}
