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

    /**
     * Este metodo solicita un codigo de servicio, para asi poder compararla con los servicios que esten en la lista principal
     * si el codigo pasado por parametro, coincide con alguna iteracion en la lista, el servicio el cual coincidio su codigo se asigna a la variable servicio
     * para asi despues poder retornarlo, si servicio al finalizar el for sigue en null, se ejecuta una exception sobre la inexistencia del servicio en la lista.
     * @param codServicio
     * @return
     * @throws ExceptionServicio 
     */
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
    
    /**
     * Este metodo solicita un booleano, crea una sublista de la principal donde se van a agregar todos los servicios los cuales tengan el mismo booleano que 
     * el que se paso por parametro.
     * @param enPromocion
     * @return 
     */
    public List<Servicio> traerServicio(boolean enPromocion){
        List<Servicio> lstServicioPromocion = new ArrayList<>();
            for (Servicio servicio : lstservicio) {
            if (servicio.isEnPromocion() == enPromocion){
                lstServicioPromocion.add(servicio);
            }
        }
        return lstServicioPromocion;
    }
    /**
     * El metodo agrega un objeto de gastronomia, pide por parametro los valores que necesita esta subclase para poder crearse,
     * realizando las excepciones requeridas como si el codigo del servicio es distinto a 6 caracteres.
     * La otra excepcion que se realiza es dentro de la iteracion de servicios que ya se encuentran en la lista, si el codigo de un servicio de la lista
     * coincide con el pasado por parametro, se ejecuta la excepcion y devuelve false ya que el resto no se ejecuta. Si no se ejecuta la excepcion, realiza 
     * la creacion del servicio, lo añade a la lista y devuelve un true.
     * @param codServicio
     * @param porcentajeDescuento
     * @param enPromocion
     * @param gastronomia
     * @param precio
     * @param diaSemDesc
     * @return
     * @throws ExceptionServicio 
     */
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
    /**
     * El metodo agrega un objeto de hospedaje, pide por parametro los valores que necesita esta subclase para poder crearse,
     * realizando las excepciones requeridas como si el codigo del servicio es distinto a 6 caracteres.
     * La otra excepcion que se realiza es dentro de la iteracion de servicios que ya se encuentran en la lista, si el codigo de un servicio de la lista
     * coincide con el pasado por parametro, se ejecuta la excepcion y devuelve false ya que el resto no se ejecuta. Si no se ejecuta la excepcion, realiza 
     * la creacion del servicio, lo añade a la lista y devuelve un true.
     * @param codServicio
     * @param porcentajeDescuento
     * @param enPromocion
     * @param hospedaje
     * @param precioPorNoche
     * @return
     * @throws ExceptionServicio 
     */
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
        Servicio hospe = new Hospedaje(hospedaje,precioPorNoche,codServicio,porcentajeDescuento,enPromocion); 
        lstservicio.add(hospe);
        retorno = true;
        return retorno;
    }
   
    /**
     * El metodo crea dos variables una en donde toma el dia como int y otro como DayOfWeek, ya que gastronomia evalua enteros para el dia de la semana
     * y hospedaje evalua los dias de la semana como tal.
     * Despues se recorre la lista de servicios, primero verificando si esta en promocion igual al parametro que le pasamos, luego de esto verifica si el servicio
     * por el cual se encuentra la iteracion esta instanciado como gastronomia, si es asi utiliza la variable del int DiaSemanaG para comprobar si coincide con el dia
     * pasado por parametro, si no esta instanciado como Gastronomia, significa que esta como servicio asi que verificamos que diaSemamaa coincida con el de parametro
     * en cualquiera de los dos casos si coincide es agregado a la lista.
     * Si ningun servicio de la lista coincide se devuelve una lista vacia
     * @param enPromocion
     * @param dia
     * @return 
     */
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
