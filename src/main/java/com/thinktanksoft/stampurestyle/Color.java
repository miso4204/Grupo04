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
@Table(name = "color")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Color.findAll", query = "SELECT c FROM Color c"),
    @NamedQuery(name = "Color.findByColId", query = "SELECT c FROM Color c WHERE c.colId = :colId"),
    @NamedQuery(name = "Color.findByColNombre", query = "SELECT c FROM Color c WHERE c.colNombre = :colNombre")})
public class Color implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "col_id")
    private Integer colId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "col_nombre")
    private String colNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colId")
    private Collection<Productocolor> productocolorCollection;

    public Color() {
    }

    public Color(Integer colId) {
        this.colId = colId;
    }

    public Color(Integer colId, String colNombre) {
        this.colId = colId;
        this.colNombre = colNombre;
    }

    public Integer getColId() {
        return colId;
    }

    public void setColId(Integer colId) {
        this.colId = colId;
    }

    public String getColNombre() {
        return colNombre;
    }

    public void setColNombre(String colNombre) {
        this.colNombre = colNombre;
    }

    @XmlTransient
    public Collection<Productocolor> getProductocolorCollection() {
        return productocolorCollection;
    }

    public void setProductocolorCollection(Collection<Productocolor> productocolorCollection) {
        this.productocolorCollection = productocolorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (colId != null ? colId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Color)) {
            return false;
        }
        Color other = (Color) object;
        if ((this.colId == null && other.colId != null) || (this.colId != null && !this.colId.equals(other.colId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thinktanksoft.stampurestyle.Color[ colId=" + colId + " ]";
    }
    
}
