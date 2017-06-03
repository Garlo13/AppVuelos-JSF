/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenvuelosjsf.bean;

import examenvuelosjsf.ejb.CountryFacade;
import examenvuelosjsf.ejb.FlightFacade;
import examenvuelosjsf.entity.Country;
import examenvuelosjsf.entity.Flight;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Adrián
 */
@Named(value = "countryBean")
@RequestScoped
public class CountryBean {

    @EJB
    private FlightFacade flightFacade;

    @EJB
    private CountryFacade countryFacade;

    @Inject
    private VueloBean vueloBean;
    
    
    /**
     * Creates a new instance of CountryBean
     */
    public CountryBean() {

    }

    @PostConstruct
    public void init() {

    }

    private List<Country> listaCountries;
    private String[] countriesSeleccionados;
    private List<Flight> listaVuelos;

    public List<Flight> getListaVuelos() {
        return listaVuelos;
    }

    public void setListaVuelos(List<Flight> listaVuelos) {
        this.listaVuelos = listaVuelos;
    }

    public void recargarListaCountries() {
        this.listaCountries = this.countryFacade.findAll();
    }

    public String[] getCountriesSeleccionados() {
        return countriesSeleccionados;
    }

    public void setCountriesSeleccionados(String[] countriesSeleccionados) {
        this.countriesSeleccionados = countriesSeleccionados;
    }

    public List<Country> getListaCountries() {
        this.recargarListaCountries();
        return listaCountries;
    }

    public void setListaCountries(List<Country> listaCountries) {
        this.listaCountries = listaCountries;
    }

    public void cargarListaVuelos() {
        if (countriesSeleccionados.length == 0) {
            this.listaVuelos = this.flightFacade.findAll();
        } else {
            this.listaVuelos = this.flightFacade.buscarVuelosPorAeropuertoOrigen(Arrays.asList(countriesSeleccionados));
        }
    }

    public String doEnviarCountries() {
        this.cargarListaVuelos();
        this.vueloBean.setVuelo(null);
        this.vueloBean.setListaVuelos(listaVuelos);
        return "listadovuelos";
    }

}
