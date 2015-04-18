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
@Table(name = "usuarioxperfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarioxperfil.findAll", query = "SELECT u FROM Usuarioxperfil u"),
    @NamedQuery(name = "Usuarioxperfil.findByUsuperId", query = "SELECT u FROM Usuarioxperfil u WHERE u.usuperId = :usuperId")})
public class Usuarioxperfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuper_id")
    private Integer usuperId;
    @JoinColumn(name = "usu_id", referencedColumnName = "usu_id")
    @ManyToOne(optional = false)
    private Usuario usuId;
    @JoinColumn(name = "per_id", referencedColumnName = "per_id")
    @ManyToOne(optional = false)
    private Perfil perId;

    public Usuarioxperfil() {
    }

    public Usuarioxperfil(Integer usuperId) {
        this.usuperId = usuperId;
    }

    public Integer getUsuperId() {
        return usuperId;
    }

    public void setUsuperId(Integer usuperId) {
        this.usuperId = usuperId;
    }

    public Usuario getUsuId() {
        return usuId;
    }

    public void setUsuId(Usuario usuId) {
        this.usuId = usuId;
    }

    public Perfil getPerId() {
        return perId;
    }

    public void setPerId(Perfil perId) {
        this.perId = perId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuperId != null ? usuperId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarioxperfil)) {
            return false;
        }
        Usuarioxperfil other = (Usuarioxperfil) object;
        if ((this.usuperId == null && other.usuperId != null) || (this.usuperId != null && !this.usuperId.equals(other.usuperId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thinktanksoft.stampurestyle.Usuarioxperfil[ usuperId=" + usuperId + " ]";
    }
    
}
