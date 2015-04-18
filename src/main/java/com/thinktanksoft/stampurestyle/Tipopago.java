/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinktanksoft.stampurestyle;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "tipopago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipopago.findAll", query = "SELECT t FROM Tipopago t"),
    @NamedQuery(name = "Tipopago.findByTipPagId", query = "SELECT t FROM Tipopago t WHERE t.tipPagId = :tipPagId"),
    @NamedQuery(name = "Tipopago.findByTipPagNombre", query = "SELECT t FROM Tipopago t WHERE t.tipPagNombre = :tipPagNombre")})
public class Tipopago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tip_pag_id")
    private Integer tipPagId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tip_pag_nombre")
    private String tipPagNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipPagId")
    private Collection<Compra> compraCollection;

    public Tipopago() {
    }

    public Tipopago(Integer tipPagId) {
        this.tipPagId = tipPagId;
    }

    public Tipopago(Integer tipPagId, String tipPagNombre) {
        this.tipPagId = tipPagId;
        this.tipPagNombre = tipPagNombre;
    }

    public Integer getTipPagId() {
        return tipPagId;
    }

    public void setTipPagId(Integer tipPagId) {
        this.tipPagId = tipPagId;
    }

    public String getTipPagNombre() {
        return tipPagNombre;
    }

    public void setTipPagNombre(String tipPagNombre) {
        this.tipPagNombre = tipPagNombre;
    }

    @XmlTransient
    public Collection<Compra> getCompraCollection() {
        return compraCollection;
    }

    public void setCompraCollection(Collection<Compra> compraCollection) {
        this.compraCollection = compraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipPagId != null ? tipPagId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipopago)) {
            return false;
        }
        Tipopago other = (Tipopago) object;
        if ((this.tipPagId == null && other.tipPagId != null) || (this.tipPagId != null && !this.tipPagId.equals(other.tipPagId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thinktanksoft.stampurestyle.Tipopago[ tipPagId=" + tipPagId + " ]";
    }
    
}
