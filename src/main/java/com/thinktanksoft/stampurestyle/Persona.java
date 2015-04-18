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
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByPerId", query = "SELECT p FROM Persona p WHERE p.perId = :perId"),
    @NamedQuery(name = "Persona.findByPerTipoDocumento", query = "SELECT p FROM Persona p WHERE p.perTipoDocumento = :perTipoDocumento"),
    @NamedQuery(name = "Persona.findByPerNumeroDocumento", query = "SELECT p FROM Persona p WHERE p.perNumeroDocumento = :perNumeroDocumento"),
    @NamedQuery(name = "Persona.findByPerPrimerNombre", query = "SELECT p FROM Persona p WHERE p.perPrimerNombre = :perPrimerNombre"),
    @NamedQuery(name = "Persona.findByPerPrimerApelido", query = "SELECT p FROM Persona p WHERE p.perPrimerApelido = :perPrimerApelido"),
    @NamedQuery(name = "Persona.findByPerEmail", query = "SELECT p FROM Persona p WHERE p.perEmail = :perEmail"),
    @NamedQuery(name = "Persona.findByPerDireccion", query = "SELECT p FROM Persona p WHERE p.perDireccion = :perDireccion")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "per_id")
    private Integer perId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "per_tipo_documento")
    private String perTipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "per_numero_documento")
    private String perNumeroDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "per_primer_nombre")
    private String perPrimerNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "per_primer_apelido")
    private String perPrimerApelido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "per_email")
    private String perEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "per_direccion")
    private String perDireccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perId")
    private Collection<Usuario> usuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private Collection<Tarjetacredito> tarjetacreditoCollection;

    public Persona() {
    }

    public Persona(Integer perId) {
        this.perId = perId;
    }

    public Persona(Integer perId, String perTipoDocumento, String perNumeroDocumento, String perPrimerNombre, String perPrimerApelido, String perEmail, String perDireccion) {
        this.perId = perId;
        this.perTipoDocumento = perTipoDocumento;
        this.perNumeroDocumento = perNumeroDocumento;
        this.perPrimerNombre = perPrimerNombre;
        this.perPrimerApelido = perPrimerApelido;
        this.perEmail = perEmail;
        this.perDireccion = perDireccion;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getPerTipoDocumento() {
        return perTipoDocumento;
    }

    public void setPerTipoDocumento(String perTipoDocumento) {
        this.perTipoDocumento = perTipoDocumento;
    }

    public String getPerNumeroDocumento() {
        return perNumeroDocumento;
    }

    public void setPerNumeroDocumento(String perNumeroDocumento) {
        this.perNumeroDocumento = perNumeroDocumento;
    }

    public String getPerPrimerNombre() {
        return perPrimerNombre;
    }

    public void setPerPrimerNombre(String perPrimerNombre) {
        this.perPrimerNombre = perPrimerNombre;
    }

    public String getPerPrimerApelido() {
        return perPrimerApelido;
    }

    public void setPerPrimerApelido(String perPrimerApelido) {
        this.perPrimerApelido = perPrimerApelido;
    }

    public String getPerEmail() {
        return perEmail;
    }

    public void setPerEmail(String perEmail) {
        this.perEmail = perEmail;
    }

    public String getPerDireccion() {
        return perDireccion;
    }

    public void setPerDireccion(String perDireccion) {
        this.perDireccion = perDireccion;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Tarjetacredito> getTarjetacreditoCollection() {
        return tarjetacreditoCollection;
    }

    public void setTarjetacreditoCollection(Collection<Tarjetacredito> tarjetacreditoCollection) {
        this.tarjetacreditoCollection = tarjetacreditoCollection;
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
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.perId == null && other.perId != null) || (this.perId != null && !this.perId.equals(other.perId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thinktanksoft.stampurestyle.Persona[ perId=" + perId + " ]";
    }
    
}
