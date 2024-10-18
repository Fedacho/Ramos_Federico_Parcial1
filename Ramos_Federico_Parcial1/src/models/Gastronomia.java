/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;


import java.time.LocalDate;

/**
 *
 * @author Fede
 */
public class Gastronomia extends Servicio {
    private String gastronomia;
    private double precio;
    private int diaSemanaDesc;

    public Gastronomia(String gastronomia, double precio, int diaSemanaDesc, String codServicio, double porcentajeDescuento, boolean enPromocion) throws IllegalArgumentException, ExceptionServicio {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemanaDesc = diaSemanaDesc;
    }

    public String getGastronomia() {
        return gastronomia;
    }

    public void setGastronomia(String gastronomia) {
        this.gastronomia = gastronomia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDiaSemanaDesc() {
        return diaSemanaDesc;
    }

    public void setDiaSemanaDesc(int diaSemanaDesc) {
        this.diaSemanaDesc = diaSemanaDesc;
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {       
        double precioFinal = precio;
        int diaSemana = dia.getDayOfWeek().getValue();
        if (diaSemana == diaSemanaDesc) {
            precioFinal -= precio * (porcentajeDescuento/100);
        }
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Gastronomia{" + "codServicio=" + codServicio + ", porcentajeDescuento=" + porcentajeDescuento + ", enPromocion=" + enPromocion + "gastronomia=" + gastronomia + ", precio=" + precio + ", diaSemanaDesc=" + diaSemanaDesc + '}';
    }
    
    
    
}
