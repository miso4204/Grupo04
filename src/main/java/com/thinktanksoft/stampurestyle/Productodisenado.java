/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinktanksoft.stampurestyle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yerson
 */
@Entity
@Table(name = "productodisenado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productodisenado.findAll", query = "SELECT p FROM Productodisenado p"),
    @NamedQuery(name = "Productodisenado.findByProDisId", query = "SELECT p FROM Productodisenado p WHERE p.proDisId = :proDisId"),
    @NamedQuery(name = "Productodisenado.findByProDisCantidad", query = "SELECT p FROM Productodisenado p WHERE p.proDisCantidad = :proDisCantidad"),
    @NamedQuery(name = "Productodisenado.findByProDisValor", query = "SELECT p FROM Productodisenado p WHERE p.proDisValor = :proDisValor"),
    @NamedQuery(name = "Productodisenado.findNextId", query = "SELECT max(p.proDisId)+1 FROM Productodisenado p")})
public class Productodisenado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pro_dis_id")
    private Integer proDisId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pro_dis_cantidad")
    private int proDisCantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "pro_dis_valor")
    private BigDecimal proDisValor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proDisId")
    private Collection<Proddisxcompra> proddisxcompraCollection;
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id")
    @ManyToOne(optional = false)
    private Producto proId;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "proDisId")
    private Collection<Disenosxproddis> disenosxproddisCollection;

    public Productodisenado() {
    }

    public Productodisenado(Integer proDisId) {
        this.proDisId = proDisId;
    }

    public Productodisenado(Integer proDisId, int proDisCantidad, BigDecimal proDisValor) {
        this.proDisId = proDisId;
        this.proDisCantidad = proDisCantidad;
        this.proDisValor = proDisValor;
    }

    public Integer getProDisId() {
        return proDisId;
    }

    public void setProDisId(Integer proDisId) {
        this.proDisId = proDisId;
    }

    public int getProDisCantidad() {
        return proDisCantidad;
    }

    public void setProDisCantidad(int proDisCantidad) {
        this.proDisCantidad = proDisCantidad;
    }

    public BigDecimal getProDisValor() {
        return proDisValor;
    }

    public void setProDisValor(BigDecimal proDisValor) {
        this.proDisValor = proDisValor;
    }

    @XmlTransient
    public Collection<Proddisxcompra> getProddisxcompraCollection() {
        return proddisxcompraCollection;
    }

    public void setProddisxcompraCollection(Collection<Proddisxcompra> proddisxcompraCollection) {
        this.proddisxcompraCollection = proddisxcompraCollection;
    }

    public Producto getProId() {
        return proId;
    }

    public void setProId(Producto proId) {
        this.proId = proId;
    }

    @XmlTransient
    public Collection<Disenosxproddis> getDisenosxproddisCollection() {
        return disenosxproddisCollection;
    }

    public void setDisenosxproddisCollection(Collection<Disenosxproddis> disenosxproddisCollection) {
        this.disenosxproddisCollection = disenosxproddisCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proDisId != null ? proDisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productodisenado)) {
            return false;
        }
        Productodisenado other = (Productodisenado) object;
        if ((this.proDisId == null && other.proDisId != null) || (this.proDisId != null && !this.proDisId.equals(other.proDisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thinktanksoft.stampurestyle.Productodisenado[ proDisId=" + proDisId + " ]";
    }
    
}
