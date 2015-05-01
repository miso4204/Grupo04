/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinktanksoft.stampurestyle;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cd.montanez10
 */
@Entity
@Table(name = "oferta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oferta.findAll", query = "SELECT o FROM Oferta o"),
    @NamedQuery(name = "Oferta.findByOfeId", query = "SELECT o FROM Oferta o WHERE o.ofeId = :ofeId"),
    @NamedQuery(name = "Oferta.findByOfeNombre", query = "SELECT o FROM Oferta o WHERE o.ofeNombre = :ofeNombre"),
    @NamedQuery(name = "Oferta.findByOfeDescuento", query = "SELECT o FROM Oferta o WHERE o.ofeDescuento = :ofeDescuento"),
    @NamedQuery(name = "Oferta.findByOfeVigente", query = "SELECT o FROM Oferta o WHERE o.ofeVigente = :ofeVigente")})
public class Oferta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ofe_id")
    private Integer ofeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ofe_nombre")
    private String ofeNombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "ofe_descuento")
    private BigDecimal ofeDescuento;
    @Column(name = "ofe_vigente")
    private Boolean ofeVigente;

    public Oferta() {
    }

    public Oferta(Integer ofeId) {
        this.ofeId = ofeId;
    }

    public Oferta(Integer ofeId, String ofeNombre, BigDecimal ofeDescuento) {
        this.ofeId = ofeId;
        this.ofeNombre = ofeNombre;
        this.ofeDescuento = ofeDescuento;
    }

    public Integer getOfeId() {
        return ofeId;
    }

    public void setOfeId(Integer ofeId) {
        this.ofeId = ofeId;
    }

    public String getOfeNombre() {
        return ofeNombre;
    }

    public void setOfeNombre(String ofeNombre) {
        this.ofeNombre = ofeNombre;
    }

    public BigDecimal getOfeDescuento() {
        return ofeDescuento;
    }

    public void setOfeDescuento(BigDecimal ofeDescuento) {
        this.ofeDescuento = ofeDescuento;
    }

    public Boolean getOfeVigente() {
        return ofeVigente;
    }

    public void setOfeVigente(Boolean ofeVigente) {
        this.ofeVigente = ofeVigente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ofeId != null ? ofeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oferta)) {
            return false;
        }
        Oferta other = (Oferta) object;
        if ((this.ofeId == null && other.ofeId != null) || (this.ofeId != null && !this.ofeId.equals(other.ofeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thinktanksoft.stampurestyle.Oferta[ ofeId=" + ofeId + " ]";
    }
    
}
