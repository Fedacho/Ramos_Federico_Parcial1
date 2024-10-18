/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Fede
 */
public class Sistema {

    private List<Servicio> lstservicio;

    public Sistema() {
        this.lstservicio = new ArrayList<>();
    }

    public List<Servicio> getLstservicio() {
        return lstservicio;
    }

    public void setLstservicio(List<Servicio> lstservicio) {
        this.lstservicio = lstservicio;
    }

    public Servicio traerServicio(String codServicio) throws ExceptionServicio {
        Servicio servicio = null;
        for (Servicio s : lstservicio) {
            if (s.getCodServicio().equals(codServicio)) {
                servicio = s;
            }
        }
        if (servicio == null) {
            throw new ExceptionServicio("El servicio que busca no se encuentra en la lista");
        }
        return servicio;
    }
    
    public List<Servicio> traerServicio(boolean enPromocion){
        List<Servicio> lstServicioPromocion = new ArrayList<>();
            for (Servicio servicio : lstservicio) {
            if (servicio.isEnPromocion() == enPromocion){
                lstServicioPromocion.add(servicio);
            }
        }
        return lstServicioPromocion;
    }
    
    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws ExceptionServicio{
        boolean retorno = false;
        for (Servicio servicio : lstservicio) {
            if (servicio.getCodServicio().equals(codServicio)) {
                throw new ExceptionServicio("El servicio que quiere agregar ya existe");
            }
        }
        Servicio gastro = new Gastronomia(gastronomia,precio,diaSemDesc,codServicio,porcentajeDescuento,enPromocion); 
        lstservicio.add(gastro);
        retorno = true;
        return retorno;
    }
    
    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje,double precioPorNoche) throws ExceptionServicio{
        if (codServicio.length() != 6) {
            throw new ExceptionServicio("El codigo del servicio es invalido");
        }
        boolean retorno = false;
        for (Servicio servicio : lstservicio) {
            if (servicio.getCodServicio().equals(codServicio)){
                throw new ExceptionServicio("El servicio que quiere agregar ya existe");
            }
        }
        Servicio gastro = new Hospedaje(hospedaje,precioPorNoche,codServicio,porcentajeDescuento,enPromocion); 
        lstservicio.add(gastro);
        retorno = true;
        return retorno;
    }
   
    
    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia){
        List<Servicio> lstServicioDia = new ArrayList<>();
        int diaSemanaG = dia.getDayOfWeek().getValue();
        DayOfWeek diaSemana = dia.getDayOfWeek();
            for (Servicio servicio : lstservicio) {
                if (enPromocion == servicio.isEnPromocion()) {                    
                }
                if (servicio instanceof Gastronomia gastronomia){
                    if (diaSemanaG == gastronomia.getDiaSemanaDesc()){
                        lstServicioDia.add(servicio);
                    }
                }else{
                    if ((diaSemana != DayOfWeek.SATURDAY && diaSemana != DayOfWeek.SUNDAY)){
                        lstServicioDia.add(servicio);
                    }
                }
            }
            return lstServicioDia;
    }

    @Override
    public String toString() {
        return "Sistema{" + "lstservicio=" + lstservicio + '}';
    }
    
    
     
    
    
    

}
