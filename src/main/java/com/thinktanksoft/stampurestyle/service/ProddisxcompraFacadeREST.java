/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinktanksoft.stampurestyle.service;

import com.thinktanksoft.stampurestyle.Proddisxcompra;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author yerson
 */
@Stateless
@Path("proddisxcompra")
public class ProddisxcompraFacadeREST extends AbstractFacade<Proddisxcompra> {
    @PersistenceContext(unitName = "com.thinktanksoft_StampUreStyle2.0_war_2.0-SNAPSHOTPU")
    private EntityManager em;

    public ProddisxcompraFacadeREST() {
        super(Proddisxcompra.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    public void create(Proddisxcompra entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") Integer id, Proddisxcompra entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Proddisxcompra find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Proddisxcompra> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Proddisxcompra> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }
    
     @GET
    @Path("nextId")
    @Produces("text/plain")
    public int siguienteId() {
        int id =0;
        
        TypedQuery<Integer> query =
            getEntityManager().createNamedQuery("Proddisxcompra.findNextId", Integer.class);
        
        
         if (query.getSingleResult() != null) {
            id = query.getSingleResult();
        }

        return id;
        
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
