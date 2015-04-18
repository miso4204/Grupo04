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
@Table(name = "disenosxproddis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disenosxproddis.findAll", query = "SELECT d FROM Disenosxproddis d"),
    @NamedQuery(name = "Disenosxproddis.findByDisProdisId", query = "SELECT d FROM Disenosxproddis d WHERE d.disProdisId = :disProdisId"),
    @NamedQuery(name = "Disenosxproddis.findByDisProdisPosicion", query = "SELECT d FROM Disenosxproddis d WHERE d.disProdisPosicion = :disProdisPosicion")})
public class Disenosxproddis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "dis_prodis_id")
    private Integer disProdisId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dis_prodis_posicion")
    private int disProdisPosicion;
    @JoinColumn(name = "pro_dis_id", referencedColumnName = "pro_dis_id")
    @ManyToOne(optional = false)
    private Productodisenado proDisId;
    @JoinColumn(name = "dis_id", referencedColumnName = "dis_id")
    @ManyToOne(optional = false)
    private Diseno disId;

    public Disenosxproddis() {
    }

    public Disenosxproddis(Integer disProdisId) {
        this.disProdisId = disProdisId;
    }

    public Disenosxproddis(Integer disProdisId, int disProdisPosicion) {
        this.disProdisId = disProdisId;
        this.disProdisPosicion = disProdisPosicion;
    }

    public Integer getDisProdisId() {
        return disProdisId;
    }

    public void setDisProdisId(Integer disProdisId) {
        this.disProdisId = disProdisId;
    }

    public int getDisProdisPosicion() {
        return disProdisPosicion;
    }

    public void setDisProdisPosicion(int disProdisPosicion) {
        this.disProdisPosicion = disProdisPosicion;
    }

    public Productodisenado getProDisId() {
        return proDisId;
    }

    public void setProDisId(Productodisenado proDisId) {
        this.proDisId = proDisId;
    }

    public Diseno getDisId() {
        return disId;
    }

    public void setDisId(Diseno disId) {
        this.disId = disId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (disProdisId != null ? disProdisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disenosxproddis)) {
            return false;
        }
        Disenosxproddis other = (Disenosxproddis) object;
        if ((this.disProdisId == null && other.disProdisId != null) || (this.disProdisId != null && !this.disProdisId.equals(other.disProdisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thinktanksoft.stampurestyle.Disenosxproddis[ disProdisId=" + disProdisId + " ]";
    }
    
}
