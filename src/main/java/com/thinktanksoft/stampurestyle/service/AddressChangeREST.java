/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinktanksoft.stampurestyle.service;

import com.thinktanksoft.stampurestyle.Persona;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


/**
 *
 * @author yerson
 */
@Stateless
@Path("changeAddress")
public class AddressChangeREST extends AbstractFacade<Persona> {
    @PersistenceContext(unitName = "com.thinktanksoft_StampUreStyle2.0_war_2.0-SNAPSHOTPU")
    private EntityManager em;

    public AddressChangeREST() {
        super(Persona.class);
    }

    @POST
    @Path("{id}/{newAddress}")
    public void setNewAddress(@PathParam("id") Integer id,
            @PathParam("newAddress") String newAddr){
        
         Persona entity = super.find(id);
        entity.setPerDireccion(newAddr);
        super.edit(entity); 
        
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}

