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
@Table(name = "talla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Talla.findAll", query = "SELECT t FROM Talla t"),
    @NamedQuery(name = "Talla.findByTalId", query = "SELECT t FROM Talla t WHERE t.talId = :talId"),
    @NamedQuery(name = "Talla.findByTalNombre", query = "SELECT t FROM Talla t WHERE t.talNombre = :talNombre")})
public class Talla implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tal_id")
    private Integer talId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tal_nombre")
    private String talNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "talId")
    private Collection<Productotalla> productotallaCollection;

    public Talla() {
    }

    public Talla(Integer talId) {
        this.talId = talId;
    }

    public Talla(Integer talId, String talNombre) {
        this.talId = talId;
        this.talNombre = talNombre;
    }

    public Integer getTalId() {
        return talId;
    }

    public void setTalId(Integer talId) {
        this.talId = talId;
    }

    public String getTalNombre() {
        return talNombre;
    }

    public void setTalNombre(String talNombre) {
        this.talNombre = talNombre;
    }

    @XmlTransient
    public Collection<Productotalla> getProductotallaCollection() {
        return productotallaCollection;
    }

    public void setProductotallaCollection(Collection<Productotalla> productotallaCollection) {
        this.productotallaCollection = productotallaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (talId != null ? talId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Talla)) {
            return false;
        }
        Talla other = (Talla) object;
        if ((this.talId == null && other.talId != null) || (this.talId != null && !this.talId.equals(other.talId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thinktanksoft.stampurestyle.Talla[ talId=" + talId + " ]";
    }
    
}
