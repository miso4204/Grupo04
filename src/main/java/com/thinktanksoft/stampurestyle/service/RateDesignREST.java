/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinktanksoft.stampurestyle.service;

import com.thinktanksoft.stampurestyle.Diseno;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author cd.montanez10
 */
@Stateless
@Path("rateDesign")
public class RateDesignREST extends AbstractFacade<Diseno>{
    
    @PersistenceContext(unitName = "com.thinktanksoft_StampUreStyle2.0_war_2.0-SNAPSHOTPU")
    private EntityManager em;
     
     public RateDesignREST() {
        super(Diseno.class);
    }
    
    @POST
    @Path("{id}/{rate}")
    public void setRate(@PathParam("id") Integer id, @PathParam("rate") Integer rate) {
        Diseno entity = super.find(id);
        entity.setDisNumeroVentas(entity.getDisNumeroVentas()+rate);
        super.edit(entity);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
