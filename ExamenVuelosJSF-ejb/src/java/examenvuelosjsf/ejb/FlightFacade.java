/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenvuelosjsf.ejb;

import examenvuelosjsf.entity.Flight;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Adrián
 */
@Stateless
public class FlightFacade extends AbstractFacade<Flight> {

    @PersistenceContext(unitName = "ExamenVuelosJSF-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FlightFacade() {
        super(Flight.class);
    }
    
    public List<Flight> buscarVuelosPorAeropuertoOrigen(List<String> listaCountries){
        Query q;
        q = this.em.createQuery("select f from Flight f where f.origAirport.countryIsoCode.countryIsoCode IN :listaCountries");
        q.setParameter("listaCountries", listaCountries);
        return q.getResultList();
    }
    
}
