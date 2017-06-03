/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenvuelosjsf.bean;

import examenvuelosjsf.ejb.CityFacade;
import examenvuelosjsf.ejb.FlightFacade;
import examenvuelosjsf.entity.Flight;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Adrián
 */
@Named(value = "modificarVueloBean")
@RequestScoped
public class ModificarVueloBean {

    @EJB
    private FlightFacade flightFacade;

    @EJB
    private CityFacade cityFacade;

    @Inject
    private VueloBean vueloBean;
    
    
    /**
     * Creates a new instance of ModificarVueloBean
     */
    public ModificarVueloBean() {
    }
    
    private String ciudadOrigenSeleccionada;
    private String ciudadDestinoSeleccionada;

    public String getCiudadOrigenSeleccionada() {
        return ciudadOrigenSeleccionada;
    }

    public void setCiudadOrigenSeleccionada(String ciudadOrigenSeleccionada) {
        this.ciudadOrigenSeleccionada = ciudadOrigenSeleccionada;
    }

    public String getCiudadDestinoSeleccionada() {
        return ciudadDestinoSeleccionada;
    }

    public void setCiudadDestinoSeleccionada(String ciudadDestinoSeleccionada) {
        this.ciudadDestinoSeleccionada = ciudadDestinoSeleccionada;
    }
    
    public String doEditar(Flight vuelo) {
        this.vueloBean.setVuelo(vuelo);
        ciudadOrigenSeleccionada = this.vueloBean.getVuelo().getOrigAirport().getAirport();
        ciudadDestinoSeleccionada = this.vueloBean.getVuelo().getDestAirport().getAirport();
        //return "editarvuelo";
        return "listadovuelos";
    }
    
    public String doGuardar() {
        if (!this.ciudadOrigenSeleccionada.equals(this.vueloBean.getVuelo().getOrigAirport().getAirport())){
            this.vueloBean.getListaVuelos().remove(this.vueloBean.getVuelo());
        } 
        this.vueloBean.getVuelo().setOrigAirport(this.cityFacade.find(this.ciudadOrigenSeleccionada));
        this.vueloBean.getVuelo().setDestAirport(this.cityFacade.find(this.ciudadDestinoSeleccionada));
        this.flightFacade.edit(this.vueloBean.getVuelo());
        this.vueloBean.setVuelo(null);
        return "listadovuelos";
    }
}
