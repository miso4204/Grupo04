/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinktanksoft.stampurestyle;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CesarAugusto
 */
@XmlRootElement
public class ResponseComponent {
    public String text;
    public long number;

    public ResponseComponent() {} // JAXB needs this

    public ResponseComponent(String text, int number) {
      this.text = text;
      this.number = number;
    }
}
