/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinktanksoft.stampurestyle.service;

import com.thinktanksoft.stampurestyle.Tarjetacredito;
import com.thinktanksoft.stampurestyle.TarjetacreditoPK;
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
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author yerson
 */
@Stateless
@Path("tarjetacredito")
public class TarjetacreditoFacadeREST extends AbstractFacade<Tarjetacredito> {
    @PersistenceContext(unitName = "com.thinktanksoft_StampUreStyle2.0_war_2.0-SNAPSHOTPU")
    private EntityManager em;

    private TarjetacreditoPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;tarId=tarIdValue;perId=perIdValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.thinktanksoft.stampurestyle.TarjetacreditoPK key = new com.thinktanksoft.stampurestyle.TarjetacreditoPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> tarId = map.get("tarId");
        if (tarId != null && !tarId.isEmpty()) {
            key.setTarId(new java.lang.Integer(tarId.get(0)));
        }
        java.util.List<String> perId = map.get("perId");
        if (perId != null && !perId.isEmpty()) {
            key.setPerId(new java.lang.Integer(perId.get(0)));
        }
        return key;
    }

    public TarjetacreditoFacadeREST() {
        super(Tarjetacredito.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    public void create(Tarjetacredito entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") PathSegment id, Tarjetacredito entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.thinktanksoft.stampurestyle.TarjetacreditoPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Tarjetacredito find(@PathParam("id") PathSegment id) {
        com.thinktanksoft.stampurestyle.TarjetacreditoPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Tarjetacredito> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Tarjetacredito> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
            getEntityManager().createNamedQuery("Tarjetacredito.findNextId", Integer.class);
        int id =query.getSingleResult();
        
        return id;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
