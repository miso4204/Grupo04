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
@Table(name = "productotalla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productotalla.findAll", query = "SELECT p FROM Productotalla p"),
    @NamedQuery(name = "Productotalla.findByProTalId", query = "SELECT p FROM Productotalla p WHERE p.proTalId = :proTalId")})
public class Productotalla implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pro_tal_id")
    private Integer proTalId;
    @JoinColumn(name = "tal_id", referencedColumnName = "tal_id")
    @ManyToOne(optional = false)
    private Talla talId;
    @JoinColumn(name = "pro_id", referencedColumnName = "pro_id")
    @ManyToOne(optional = false)
    private Producto proId;

    public Productotalla() {
    }

    public Productotalla(Integer proTalId) {
        this.proTalId = proTalId;
    }

    public Integer getProTalId() {
        return proTalId;
    }

    public void setProTalId(Integer proTalId) {
        this.proTalId = proTalId;
    }

    public Talla getTalId() {
        return talId;
    }

    public void setTalId(Talla talId) {
        this.talId = talId;
    }

    public Producto getProId() {
        return proId;
    }

    public void setProId(Producto proId) {
        this.proId = proId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proTalId != null ? proTalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productotalla)) {
            return false;
        }
        Productotalla other = (Productotalla) object;
        if ((this.proTalId == null && other.proTalId != null) || (this.proTalId != null && !this.proTalId.equals(other.proTalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thinktanksoft.stampurestyle.Productotalla[ proTalId=" + proTalId + " ]";
    }
    
}
