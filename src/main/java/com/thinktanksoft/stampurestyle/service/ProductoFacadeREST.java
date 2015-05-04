/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinktanksoft.stampurestyle.service;

import com.thinktanksoft.stampurestyle.Producto;
import com.thinktanksoft.stampurestyle.component.ShareController;
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
@Path("producto")
public class ProductoFacadeREST extends AbstractFacade<Producto> {
    @PersistenceContext(unitName = "com.thinktanksoft_StampUreStyle2.0_war_2.0-SNAPSHOTPU")
    private EntityManager em;       

    public ProductoFacadeREST() {
        super(Producto.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    public void create(Producto entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") Integer id, Producto entity) {
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
    public Producto find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Producto> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Producto> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
        
        TypedQuery<Integer> query =
            getEntityManager().createNamedQuery("Producto.findNextId", Integer.class);
        int id =query.getSingleResult();
        
        return id;
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
}
