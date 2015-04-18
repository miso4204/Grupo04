/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinktanksoft.stampurestyle;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yerson
 */
@Entity
@Table(name = "productocolor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productocolor.findAll", query = "SELECT p FROM Productocolor p"),
    @NamedQuery(name = "Productocolor.findByProColId", query = "SELECT p FROM Productocolor p WHERE p.proColId = :proColId")})
public class Productocolor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pro_col_id")
    private Integer proColId;
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id")
    @ManyToOne(optional = false)
    private Producto proId;
    @JoinColumn(name = "col_id", referencedColumnName = "col_id")
    @ManyToOne(optional = false)
    private Color colId;

    public Productocolor() {
    }

    public Productocolor(Integer proColId) {
        this.proColId = proColId;
    }

    public Integer getProColId() {
        return proColId;
    }

    public void setProColId(Integer proColId) {
        this.proColId = proColId;
    }

    public Producto getProId() {
        return proId;
    }

    public void setProId(Producto proId) {
        this.proId = proId;
    }

    public Color getColId() {
        return colId;
    }

    public void setColId(Color colId) {
        this.colId = colId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proColId != null ? proColId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productocolor)) {
            return false;
        }
        Productocolor other = (Productocolor) object;
        if ((this.proColId == null && other.proColId != null) || (this.proColId != null && !this.proColId.equals(other.proColId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thinktanksoft.stampurestyle.Productocolor[ proColId=" + proColId + " ]";
    }
    
}
