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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yerson
 */
@Entity
@Table(name = "diseno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diseno.findAll", query = "SELECT d FROM Diseno d"),
    @NamedQuery(name = "Diseno.findByDisId", query = "SELECT d FROM Diseno d WHERE d.disId = :disId"),
    @NamedQuery(name = "Diseno.findByDisNombre", query = "SELECT d FROM Diseno d WHERE d.disNombre = :disNombre"),
    @NamedQuery(name = "Diseno.findByDisValor", query = "SELECT d FROM Diseno d WHERE d.disValor = :disValor"),
    @NamedQuery(name = "Diseno.findByDisNumeroVentas", query = "SELECT d FROM Diseno d WHERE d.disNumeroVentas = :disNumeroVentas"),
    @NamedQuery(name = "Diseno.findByDisUrl", query = "SELECT d FROM Diseno d WHERE d.disUrl = :disUrl"),
    @NamedQuery(name = "Diseno.findNextId", query = "SELECT max(d.disId)+1 FROM Diseno d")})
public class Diseno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "dis_id")
    private Integer disId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "dis_nombre")
    private String disNombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "dis_valor")
    private BigDecimal disValor;
    @Column(name = "dis_numero_ventas")
    private Integer disNumeroVentas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "dis_url")
    private String disUrl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disId")
    private Collection<Disenosxproddis> disenosxproddisCollection;
    @JoinColumn(name = "usu_id", referencedColumnName = "usu_id")
    @ManyToOne(optional = false)
    private Usuario usuId;
    @JoinColumn(name = "est_id", referencedColumnName = "est_id")
    @ManyToOne(optional = false)
    private Estilos estId;
    @JoinColumn(name = "cat_id", referencedColumnName = "cat_id")
    @ManyToOne(optional = false)
    private Categoria catId;

    public Diseno() {
    }

    public Diseno(Integer disId) {
        this.disId = disId;
    }

    public Diseno(Integer disId, String disNombre, BigDecimal disValor, String disUrl) {
        this.disId = disId;
        this.disNombre = disNombre;
        this.disValor = disValor;
        this.disUrl = disUrl;
    }

    public Integer getDisId() {
        return disId;
    }

    public void setDisId(Integer disId) {
        this.disId = disId;
    }

    public String getDisNombre() {
        return disNombre;
    }

    public void setDisNombre(String disNombre) {
        this.disNombre = disNombre;
    }

    public BigDecimal getDisValor() {
        return disValor;
    }

    public void setDisValor(BigDecimal disValor) {
        this.disValor = disValor;
    }

    public Integer getDisNumeroVentas() {
        return disNumeroVentas;
    }

    public void setDisNumeroVentas(Integer disNumeroVentas) {
        this.disNumeroVentas = disNumeroVentas;
    }

    public String getDisUrl() {
        return disUrl;
    }

    public void setDisUrl(String disUrl) {
        this.disUrl = disUrl;
    }

    @XmlTransient
    public Collection<Disenosxproddis> getDisenosxproddisCollection() {
        return disenosxproddisCollection;
    }

    public void setDisenosxproddisCollection(Collection<Disenosxproddis> disenosxproddisCollection) {
        this.disenosxproddisCollection = disenosxproddisCollection;
    }

    public Usuario getUsuId() {
        return usuId;
    }

    public void setUsuId(Usuario usuId) {
        this.usuId = usuId;
    }

    public Estilos getEstId() {
        return estId;
    }

    public void setEstId(Estilos estId) {
        this.estId = estId;
    }

    public Categoria getCatId() {
        return catId;
    }

    public void setCatId(Categoria catId) {
        this.catId = catId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (disId != null ? disId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diseno)) {
            return false;
        }
        Diseno other = (Diseno) object;
        if ((this.disId == null && other.disId != null) || (this.disId != null && !this.disId.equals(other.disId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thinktanksoft.stampurestyle.Diseno[ disId=" + disId + " ]";
    }
    
}
