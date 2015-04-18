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
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByProId", query = "SELECT p FROM Producto p WHERE p.proId = :proId"),
    @NamedQuery(name = "Producto.findByProNombre", query = "SELECT p FROM Producto p WHERE p.proNombre = :proNombre"),
    @NamedQuery(name = "Producto.findByProCantidad", query = "SELECT p FROM Producto p WHERE p.proCantidad = :proCantidad"),
    @NamedQuery(name = "Producto.findByProValor", query = "SELECT p FROM Producto p WHERE p.proValor = :proValor"),
    @NamedQuery(name = "Producto.findByProUrl", query = "SELECT p FROM Producto p WHERE p.proUrl = :proUrl"),
    @NamedQuery(name = "Producto.findNextId", query = "SELECT max(p.proId)+1 FROM Producto p")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pro_id")
    private Integer proId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pro_nombre")
    private String proNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pro_cantidad")
    private int proCantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "pro_valor")
    private BigDecimal proValor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "pro_url")
    private String proUrl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proId")
    private Collection<Productodisenado> productodisenadoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proId")
    private Collection<Productotalla> productotallaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proId")
    private Collection<Productocolor> productocolorCollection;
    @JoinColumn(name = "est_id", referencedColumnName = "est_id")
    @ManyToOne(optional = false)
    private Estilos estId;
    @JoinColumn(name = "cat_id", referencedColumnName = "cat_id")
    @ManyToOne(optional = false)
    private Categoria catId;

    public Producto() {
    }

    public Producto(Integer proId) {
        this.proId = proId;
    }

    public Producto(Integer proId, String proNombre, int proCantidad, BigDecimal proValor, String proUrl) {
        this.proId = proId;
        this.proNombre = proNombre;
        this.proCantidad = proCantidad;
        this.proValor = proValor;
        this.proUrl = proUrl;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public int getProCantidad() {
        return proCantidad;
    }

    public void setProCantidad(int proCantidad) {
        this.proCantidad = proCantidad;
    }

    public BigDecimal getProValor() {
        return proValor;
    }

    public void setProValor(BigDecimal proValor) {
        this.proValor = proValor;
    }

    public String getProUrl() {
        return proUrl;
    }

    public void setProUrl(String proUrl) {
        this.proUrl = proUrl;
    }

    @XmlTransient
    public Collection<Productodisenado> getProductodisenadoCollection() {
        return productodisenadoCollection;
    }

    public void setProductodisenadoCollection(Collection<Productodisenado> productodisenadoCollection) {
        this.productodisenadoCollection = productodisenadoCollection;
    }

    @XmlTransient
    public Collection<Productotalla> getProductotallaCollection() {
        return productotallaCollection;
    }

    public void setProductotallaCollection(Collection<Productotalla> productotallaCollection) {
        this.productotallaCollection = productotallaCollection;
    }

    @XmlTransient
    public Collection<Productocolor> getProductocolorCollection() {
        return productocolorCollection;
    }

    public void setProductocolorCollection(Collection<Productocolor> productocolorCollection) {
        this.productocolorCollection = productocolorCollection;
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
        hash += (proId != null ? proId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.proId == null && other.proId != null) || (this.proId != null && !this.proId.equals(other.proId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thinktanksoft.stampurestyle.Producto[ proId=" + proId + " ]";
    }
    
}
