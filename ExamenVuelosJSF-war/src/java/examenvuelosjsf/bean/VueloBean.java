/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenvuelosjsf.bean;

import examenvuelosjsf.ejb.CityFacade;
import examenvuelosjsf.ejb.FlightFacade;
import examenvuelosjsf.entity.City;
import examenvuelosjsf.entity.Flight;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Adrián
 */
@Named(value = "vueloBean")
@SessionScoped
public class VueloBean implements Serializable {

    @EJB
    private FlightFacade flightFacade;

    @EJB
    private CityFacade cityFacade;

    /**
     * Creates a new instance of VueloBean
     */
    public VueloBean() {
    }

    @PostConstruct
    public void init() {
        this.listaCiudades = this.cityFacade.findAll();
    }
    
    private Flight vuelo;
    private List<Flight> listaVuelos;
    private List<City> listaCiudades;
    //private String ciudadOrigenSeleccionada;
    //private String ciudadDestinoSeleccionada;

    public List<Flight> getListaVuelos() {
        return listaVuelos;
    }

    public void setListaVuelos(List<Flight> listaVuelos) {
        this.listaVuelos = listaVuelos;
    }
    /*
    public String getCiudadDestinoSeleccionada() {
        return ciudadDestinoSeleccionada;
    }

    public void setCiudadDestinoSeleccionada(String ciudadDestinoSeleccionada) {
        this.ciudadDestinoSeleccionada = ciudadDestinoSeleccionada;
    }

    public String getCiudadOrigenSeleccionada() {
        return ciudadOrigenSeleccionada;
    }

    public void setCiudadOrigenSeleccionada(String ciudadOrigenSeleccionada) {
        this.ciudadOrigenSeleccionada = ciudadOrigenSeleccionada;
    }
    */
    public List<City> getListaCiudades() {
        return listaCiudades;
    }

    public void setListaCiudades(List<City> listaCiudades) {
        this.listaCiudades = listaCiudades;
    }

    public Flight getVuelo() {
        return vuelo;
    }

    public void setVuelo(Flight vuelo) {
        this.vuelo = vuelo;
    }

    /*
    public String doEditar(Flight vuelo) {
        this.vuelo = vuelo;
        ciudadOrigenSeleccionada = this.vuelo.getOrigAirport().getAirport();
        ciudadDestinoSeleccionada = this.vuelo.getDestAirport().getAirport();
        //return "editarvuelo";
        return "listadovuelos";
    }
    */
    
    /*
    public String doGuardar() {
        this.vuelo.setOrigAirport(this.cityFacade.find(this.ciudadOrigenSeleccionada));
        this.vuelo.setDestAirport(this.cityFacade.find(this.ciudadDestinoSeleccionada));
        this.flightFacade.edit(vuelo);
        //this.countryBean.cargarListaVuelos();
        this.vuelo = null;
        return "listadovuelos";
    }
    */
    public String doBorrar(Flight vuelo){
        this.listaVuelos.remove(vuelo);
        this.flightFacade.remove(vuelo);
        return "listadovuelos";
    }
    
    public Boolean esVueloAEditar(Flight vuelo){
        return this.vuelo != null && this.vuelo.equals(vuelo);
    }
    
    public String doCancelarEditar(){
        this.vuelo = null;
        return "listadovuelos";
    }
}
