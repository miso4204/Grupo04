/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinktanksoft.stampurestyle.service;

import com.thinktanksoft.stampurestyle.component.ShareController;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author CesarAugusto
 */

@Stateless
@Path("comparte")
public class CompartirFacadeREST { 
    
    
    public static ShareController shareController= new ShareController();
    
    @GET
    @Path("social/{id}")
    @Produces("application/json")
    public String get(@PathParam("id") long id) {
       return shareController.getInfo(id);
    }
    @GET
    @Path("{id}")
    @Produces("text/plain")
    public boolean share(@PathParam("id")Long id) {
       return shareController.share(id);
    }
}
