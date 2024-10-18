/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 *
 * @author Fede
 */
public class Hospedaje extends Servicio {
    private String hospedaje;
    private double precioPorNoche;

    public Hospedaje(String hospedaje, double precioPorNoche, String codServicio, double porcentajeDescuento, boolean enPromocion) throws ExceptionServicio {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
    }

    public String getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(String hospedaje) {
        this.hospedaje = hospedaje;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        double precioFinal = precioPorNoche;
        DayOfWeek diaSemana = dia.getDayOfWeek();
        if (enPromocion == true && (diaSemana != DayOfWeek.SATURDAY && diaSemana != DayOfWeek.SUNDAY)){
            precioFinal -= precioPorNoche * (porcentajeDescuento/100);           
        }
        return precioFinal; 
    }

    @Override
    public String toString() {
        return "Hospedaje{" + "codServicio=" + codServicio + ", porcentajeDescuento=" + porcentajeDescuento + ", enPromocion=" + enPromocion + "hospedaje=" + hospedaje + ", precioPorNoche=" + precioPorNoche + '}';
    }
    
    
    
    
}
