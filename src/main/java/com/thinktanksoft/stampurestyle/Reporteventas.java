/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinktanksoft.stampurestyle;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Julio Cesar
 */
@Entity
@Table(name = "reporteventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reporteventas.findAll", query = "SELECT r FROM Reporteventas r"),
    @NamedQuery(name = "Reporteventas.findByUsuId", query = "SELECT r FROM Reporteventas r WHERE r.usuId = :usuId"),
    @NamedQuery(name = "Reporteventas.findByNombre", query = "SELECT r FROM Reporteventas r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "Reporteventas.findByApellido", query = "SELECT r FROM Reporteventas r WHERE r.apellido = :apellido"),
    @NamedQuery(name = "Reporteventas.findByMes", query = "SELECT r FROM Reporteventas r WHERE r.mes = :mes"),
    @NamedQuery(name = "Reporteventas.findByAno", query = "SELECT r FROM Reporteventas r WHERE r.ano = :ano"),
    @NamedQuery(name = "Reporteventas.findByTotal", query = "SELECT r FROM Reporteventas r WHERE r.total = :total")})
public class Reporteventas implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "usu_id")
    private Integer usuId;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellido")
    private String apellido;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Column(name = "mes")
    private Double mes;
    
    @Column(name = "ano")
    private Double ano;
    
    @Column(name = "total")
    private BigInteger total;

    
    public Reporteventas() {
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Double getMes() {
        return mes;
    }

    public void setMes(Double mes) {
        this.mes = mes;
    }

    public Double getAno() {
        return ano;
    }

    public void setAno(Double ano) {
        this.ano = ano;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }
    
}
