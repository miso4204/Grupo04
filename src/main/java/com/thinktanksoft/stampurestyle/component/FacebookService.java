/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinktanksoft.stampurestyle.component;

/**
 *
 * @author CesarAugusto
 */
public class FacebookService implements ShareService{

    @Override
    public boolean share(long id) {
        System.out.println("Comparti en fb");
        return true;
    }

    @Override
    public String get(long id) {
        return "<div class=\"panel panel-default\">\n" +
                "  <div class=\"panel-heading\" style=\"background-color:#1E4EB2; height: 50px;\"><img src=\"img/utils/fblogo.png\" alt=\"Facebook Icon\" class=\"col-lg-2\" style=\"padding:0\"></div>\n" +
                "  <div class=\"panel-body\">\n" +
                "   <img src=\"img/utils/shirts2.jpg\" alt=\"Icon\" class=\"col-lg-3\" style=\"padding:0\">\n" +
                "   <p class=\"col-lg-9\">  <a href='#'>#YoEstampeMiEstilo</a>, te invito a visitar <a href='#'>StampUreStyle</a> y poner tu firma en lo que usas.<br><span style=\"color:#BDBDBD; font-size:14px\">www.stampurestyle.com</span></p>\n" +
                "  </div>\n" +
                "</div>";       
       
    }
    
}
