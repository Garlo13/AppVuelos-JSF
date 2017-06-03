/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenvuelosjsf.ejb;

import examenvuelosjsf.entity.Airline;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Adrián
 */
@Stateless
public class AirlineFacade extends AbstractFacade<Airline> {

    @PersistenceContext(unitName = "ExamenVuelosJSF-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AirlineFacade() {
        super(Airline.class);
    }
    
}
