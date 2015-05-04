/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinktanksoft.stampurestyle.service;

import com.thinktanksoft.stampurestyle.Usuario;
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
@Path("changePassword")
public class PasswordChangeREST extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "com.thinktanksoft_StampUreStyle2.0_war_2.0-SNAPSHOTPU")
    private EntityManager em;

    public PasswordChangeREST () {
        super(Usuario.class);
    }
    
    @POST
    @Path("{id}/{newPassword}")
    public void setNewPassword(@PathParam("id") Integer id, @PathParam("newPassword") String newPass){
        
       Usuario entity=super.find(id);
        entity.setUsuContrasena(newPass);
        super.edit(entity);     
      
    }
    
   @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
