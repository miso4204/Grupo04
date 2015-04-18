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
@Table(name = "perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p"),
    @NamedQuery(name = "Perfil.findByPerId", query = "SELECT p FROM Perfil p WHERE p.perId = :perId"),
    @NamedQuery(name = "Perfil.findByPerNombre", query = "SELECT p FROM Perfil p WHERE p.perNombre = :perNombre")})
public class Perfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "per_id")
    private Integer perId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "per_nombre")
    private String perNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perId")
    private Collection<Usuarioxperfil> usuarioxperfilCollection;

    public Perfil() {
    }

    public Perfil(Integer perId) {
        this.perId = perId;
    }

    public Perfil(Integer perId, String perNombre) {
        this.perId = perId;
        this.perNombre = perNombre;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    @XmlTransient
    public Collection<Usuarioxperfil> getUsuarioxperfilCollection() {
        return usuarioxperfilCollection;
    }

    public void setUsuarioxperfilCollection(Collection<Usuarioxperfil> usuarioxperfilCollection) {
        this.usuarioxperfilCollection = usuarioxperfilCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perId != null ? perId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thinktanksoft.stampurestyle.Perfil[ perId=" + perId + " ]";
    }
    
}
