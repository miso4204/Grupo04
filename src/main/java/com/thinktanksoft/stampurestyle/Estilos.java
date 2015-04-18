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
@Table(name = "estilos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estilos.findAll", query = "SELECT e FROM Estilos e"),
    @NamedQuery(name = "Estilos.findByEstId", query = "SELECT e FROM Estilos e WHERE e.estId = :estId"),
    @NamedQuery(name = "Estilos.findByEstNombre", query = "SELECT e FROM Estilos e WHERE e.estNombre = :estNombre")})
public class Estilos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "est_id")
    private Integer estId;
    @Size(max = 20)
    @Column(name = "est_nombre")
    private String estNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estId")
    private Collection<Producto> productoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estId")
    private Collection<Diseno> disenoCollection;

    public Estilos() {
    }

    public Estilos(Integer estId) {
        this.estId = estId;
    }

    public Integer getEstId() {
        return estId;
    }

    public void setEstId(Integer estId) {
        this.estId = estId;
    }

    public String getEstNombre() {
        return estNombre;
    }

    public void setEstNombre(String estNombre) {
        this.estNombre = estNombre;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    @XmlTransient
    public Collection<Diseno> getDisenoCollection() {
        return disenoCollection;
    }

    public void setDisenoCollection(Collection<Diseno> disenoCollection) {
        this.disenoCollection = disenoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estId != null ? estId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estilos)) {
            return false;
        }
        Estilos other = (Estilos) object;
        if ((this.estId == null && other.estId != null) || (this.estId != null && !this.estId.equals(other.estId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thinktanksoft.stampurestyle.Estilos[ estId=" + estId + " ]";
    }
    
}
