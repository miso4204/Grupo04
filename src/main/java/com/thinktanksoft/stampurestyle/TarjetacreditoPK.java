/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinktanksoft.stampurestyle;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author yerson
 */
@Embeddable
public class TarjetacreditoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "tar_id")
    private int tarId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "per_id")
    private int perId;

    public TarjetacreditoPK() {
    }

    public TarjetacreditoPK(int tarId, int perId) {
        this.tarId = tarId;
        this.perId = perId;
    }

    public int getTarId() {
        return tarId;
    }

    public void setTarId(int tarId) {
        this.tarId = tarId;
    }

    public int getPerId() {
        return perId;
    }

    public void setPerId(int perId) {
        this.perId = perId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) tarId;
        hash += (int) perId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarjetacreditoPK)) {
            return false;
        }
        TarjetacreditoPK other = (TarjetacreditoPK) object;
        if (this.tarId != other.tarId) {
            return false;
        }
        if (this.perId != other.perId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thinktanksoft.stampurestyle.TarjetacreditoPK[ tarId=" + tarId + ", perId=" + perId + " ]";
    }
    
}
