/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinktanksoft.stampurestyle.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author yerson
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.thinktanksoft.stampurestyle.service.CategoriaFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.ColorFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.CompraFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.DisenoFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.DisenosxproddisFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.EstilosFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.PerfilFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.PersonaFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.ProddisxcompraFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.ProductoFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.ProductocolorFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.ProductodisenadoFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.ProductotallaFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.TallaFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.TarjetacreditoFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.TipopagoFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.UsuarioFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.UsuarioxperfilFacadeREST.class);
    }
    
}
