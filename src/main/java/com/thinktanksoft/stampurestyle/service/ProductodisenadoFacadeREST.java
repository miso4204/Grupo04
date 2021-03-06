/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinktanksoft.stampurestyle.service;

import com.thinktanksoft.stampurestyle.Productodisenado;
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
@Path("productodisenado")
public class ProductodisenadoFacadeREST extends AbstractFacade<Productodisenado> {
    @PersistenceContext(unitName = "com.thinktanksoft_StampUreStyle2.0_war_2.0-SNAPSHOTPU")
    private EntityManager em;

    public ProductodisenadoFacadeREST() {
        super(Productodisenado.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Productodisenado entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Productodisenado entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Productodisenado find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Productodisenado> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Productodisenado> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
            getEntityManager().createNamedQuery("Productodisenado.findNextId", Integer.class);
        
        
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
