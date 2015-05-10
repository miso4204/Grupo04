/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinktanksoft.stampurestyle.service;

import com.thinktanksoft.stampurestyle.component.FacebookService;
import com.thinktanksoft.stampurestyle.component.TwitterService;
import java.io.FileInputStream;
import java.util.Set;
import javax.ws.rs.core.Application;
import java.util.Properties;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
        CompartirFacadeREST.shareController.setService(new TwitterService());
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        /*boolean rateDesigns=false;
        Properties prop = new Properties();
	
        InputStream input = null;
        
	try {
		input = this.getClass().getResourceAsStream("showServices.properties");
		// load a properties file
		prop.load(input);
		// get the property value
		rateDesigns = prop.getProperty("RateDesign").equals("true");
		
	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
        //System.out.println(rateDesigns);
        //El archivo de propiedades indica si habilitar el servicio
       if (rateDesigns) {
            resources.add(com.thinktanksoft.stampurestyle.service.RateDesignREST.class);
        }*/
        
        resources.add(com.thinktanksoft.stampurestyle.service.AddressChangeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.CategoriaFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.ColorFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.CompartirFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.CompraFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.DisenoFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.DisenosxproddisFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.EstilosFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.OfertaFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.PasswordChangeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.PerfilFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.PersonaFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.ProddisxcompraFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.ProductoFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.ProductocolorFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.ProductodisenadoFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.ProductotallaFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.RateDesignREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.ReporteVentasFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.TallaFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.TarjetacreditoFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.TipopagoFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.UsuarioFacadeREST.class);
        //addRestResourceClasses(resources);
        resources.add(com.thinktanksoft.stampurestyle.service.UsuarioxperfilFacadeREST.class);
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
   
    
}
