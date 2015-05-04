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
        return "<div>Twitter</div>";
    }
}
