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
@Table(name = "proddisxcompra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proddisxcompra.findAll", query = "SELECT p FROM Proddisxcompra p"),
    @NamedQuery(name = "Proddisxcompra.findByProdisComId", query = "SELECT p FROM Proddisxcompra p WHERE p.prodisComId = :prodisComId")})
public class Proddisxcompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prodis_com_id")
    private Integer prodisComId;
    @JoinColumn(name = "pro_dis_id", referencedColumnName = "pro_dis_id")
    @ManyToOne(optional = false)
    private Productodisenado proDisId;
    @JoinColumn(name = "com_id", referencedColumnName = "com_id")
    @ManyToOne(optional = false)
    private Compra comId;

    public Proddisxcompra() {
    }

    public Proddisxcompra(Integer prodisComId) {
        this.prodisComId = prodisComId;
    }

    public Integer getProdisComId() {
        return prodisComId;
    }

    public void setProdisComId(Integer prodisComId) {
        this.prodisComId = prodisComId;
    }

    public Productodisenado getProDisId() {
        return proDisId;
    }

    public void setProDisId(Productodisenado proDisId) {
        this.proDisId = proDisId;
    }

    public Compra getComId() {
        return comId;
    }

    public void setComId(Compra comId) {
        this.comId = comId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodisComId != null ? prodisComId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proddisxcompra)) {
            return false;
        }
        Proddisxcompra other = (Proddisxcompra) object;
        if ((this.prodisComId == null && other.prodisComId != null) || (this.prodisComId != null && !this.prodisComId.equals(other.prodisComId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thinktanksoft.stampurestyle.Proddisxcompra[ prodisComId=" + prodisComId + " ]";
    }
    
}
