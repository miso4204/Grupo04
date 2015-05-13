/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinktanksoft.stampurestyle.service;

import com.thinktanksoft.stampurestyle.component.FacebookService;
import com.thinktanksoft.stampurestyle.component.TwitterService;
import java.io.File;
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
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        //addRestResourceClasses(resources);

        Properties prop = new Properties();

        InputStream input = null;

        try {
            File f = new File("/Users/yerson/NetBeansProjects/StampUreStyle2.0/src/main/java/com/thinktanksoft/stampurestyle/service/showServices.properties");
            input = new FileInputStream(f);
            // load a properties file
            prop.load(input);
            // get the property value

            if (prop.getProperty("facebook").equals("true")) {
                CompartirFacadeREST.shareController.setService(new FacebookService());
                resources.add(com.thinktanksoft.stampurestyle.service.CompartirFacadeREST.class);
            }

            if (prop.getProperty("twitter").equals("true")) {
                CompartirFacadeREST.shareController.setService(new TwitterService());
                resources.add(com.thinktanksoft.stampurestyle.service.CompartirFacadeREST.class);
            }
            if (prop.getProperty("facebook").equals("true")) {
                CompartirFacadeREST.shareController.setService(new FacebookService());
                resources.add(com.thinktanksoft.stampurestyle.service.CompartirFacadeREST.class);
            }
            if (prop.getProperty("changeAddress").equals("true")) {
                resources.add(com.thinktanksoft.stampurestyle.service.AddressChangeREST.class);
            }
            if (prop.getProperty("specialoffers").equals("true")) {
                resources.add(com.thinktanksoft.stampurestyle.service.OfertaFacadeREST.class);
            }
            if (prop.getProperty("changePassword").equals("true")) {
                resources.add(com.thinktanksoft.stampurestyle.service.PasswordChangeREST.class);
            }
            if (prop.getProperty("RateDesigns").equals("true")) {
                resources.add(com.thinktanksoft.stampurestyle.service.RateDesignREST.class);
            }
            if (prop.getProperty("ByArtist").equals("true") || prop.getProperty("ByPeriod").equals("true")) {
                resources.add(com.thinktanksoft.stampurestyle.service.ReporteVentasFacadeREST.class);
            }

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

        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
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
        resources.add(com.thinktanksoft.stampurestyle.service.CompraCCFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.CompraCODFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.CompraFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.CompraPSEFacadeREST.class);
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
        //addRestResourceClasses(resources);
        resources.add(com.thinktanksoft.stampurestyle.service.TarjetacreditoFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.TipopagoFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.UsuarioFacadeREST.class);
        resources.add(com.thinktanksoft.stampurestyle.service.UsuarioxperfilFacadeREST.class);
    }

}
