/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinktanksoft.stampurestyle.service;

import com.thinktanksoft.stampurestyle.Compra;
import com.thinktanksoft.stampurestyle.Diseno;
import com.thinktanksoft.stampurestyle.ResponseComponent;
import com.thinktanksoft.stampurestyle.component.ShareController;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author CesarAugusto
 */

@Stateless
@Path("comparte")
public class CompartirFacadeREST extends AbstractFacade<Compra> {    
    
    public static ShareController shareController= new ShareController();
    
    @PersistenceContext(unitName = "com.thinktanksoft_StampUreStyle2.0_war_2.0-SNAPSHOTPU")
    private EntityManager em;
    
    public CompartirFacadeREST(){
        super(Compra.class);
    }
    
    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public ResponseComponent get(@PathParam("id") Integer id) { 
       return new ResponseComponent(shareController.getInfo(id), 0);
    }
    @PUT
    @Path("{id}")
    public void share(@PathParam("id") Integer id) {
        Compra entity = super.find(id);
        entity.setComObserv(shareController.share(id));
        super.edit(entity);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
