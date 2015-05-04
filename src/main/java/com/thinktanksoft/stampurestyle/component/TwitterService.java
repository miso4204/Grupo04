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
public class TwitterService implements ShareService{

    
    @Override
    public boolean share(long id) {
        System.out.println("Comparti en tw");
        return true;
    }

    @Override
    public String get(long id) {
        return "<div class=\"panel panel-default\">\n" +
                "  <div class=\"panel-body\"><img src=\"img/utils/twitter_icon.jpg\" alt=\"Twitter Icon\" class=\"col-lg-3\" style=\"padding:0\"></div>\n" +
                "  <div class=\"panel-body\">\n" +
                "  <a href='#'>#YoEstampeMiEstilo</a>, te invito a visitar <a href='#'>@StampUreStyle</a> y poner tu firma en lo que usas.\n" +
                "  </div>\n" +
                "</div>";
    }
}
