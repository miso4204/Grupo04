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
public class ShareController {
    
    private ShareService shareService;
    
    public void setService(ShareService service){
        shareService = service;        
    }
    
    public String share(long id){
        return shareService.share(id);
    }
    
    public String getInfo(long id){
        return shareService.get(id);
    }
    
}
