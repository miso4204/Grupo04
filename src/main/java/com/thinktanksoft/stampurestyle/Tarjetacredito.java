/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinktanksoft.stampurestyle;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yerson
 */
@Entity
@Table(name = "tarjetacredito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarjetacredito.findAll", query = "SELECT t FROM Tarjetacredito t"),
    @NamedQuery(name = "Tarjetacredito.findByTarId", query = "SELECT t FROM Tarjetacredito t WHERE t.tarjetacreditoPK.tarId = :tarId"),
    @NamedQuery(name = "Tarjetacredito.findByTarNumero", query = "SELECT t FROM Tarjetacredito t WHERE t.tarNumero = :tarNumero"),
    @NamedQuery(name = "Tarjetacredito.findByTarFechaExpiracion", query = "SELECT t FROM Tarjetacredito t WHERE t.tarFechaExpiracion = :tarFechaExpiracion"),
    @NamedQuery(name = "Tarjetacredito.findByTarCodigoSeguridad", query = "SELECT t FROM Tarjetacredito t WHERE t.tarCodigoSeguridad = :tarCodigoSeguridad"),
    @NamedQuery(name = "Tarjetacredito.findByTarTipo", query = "SELECT t FROM Tarjetacredito t WHERE t.tarTipo = :tarTipo"),
    @NamedQuery(name = "Tarjetacredito.findByPerId", query = "SELECT t FROM Tarjetacredito t WHERE t.tarjetacreditoPK.perId = :perId"),
    @NamedQuery(name = "Tarjetacredito.findNextId", query = "SELECT max(t.tarjetacreditoPK.tarId)+1 FROM Tarjetacredito t")})
public class Tarjetacredito implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TarjetacreditoPK tarjetacreditoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "tar_numero")
    private String tarNumero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tar_fecha_expiracion")
    @Temporal(TemporalType.DATE)
    private Date tarFechaExpiracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tar_codigo_seguridad")
    private int tarCodigoSeguridad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tar_tipo")
    private String tarTipo;
    @OneToMany(mappedBy = "tarjetacredito")
    private Collection<Compra> compraCollection;
    @JoinColumn(name = "per_id", referencedColumnName = "per_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;

    public Tarjetacredito() {
    }

    public Tarjetacredito(TarjetacreditoPK tarjetacreditoPK) {
        this.tarjetacreditoPK = tarjetacreditoPK;
    }

    public Tarjetacredito(TarjetacreditoPK tarjetacreditoPK, String tarNumero, Date tarFechaExpiracion, int tarCodigoSeguridad, String tarTipo) {
        this.tarjetacreditoPK = tarjetacreditoPK;
        this.tarNumero = tarNumero;
        this.tarFechaExpiracion = tarFechaExpiracion;
        this.tarCodigoSeguridad = tarCodigoSeguridad;
        this.tarTipo = tarTipo;
    }

    public Tarjetacredito(int tarId, int perId) {
        this.tarjetacreditoPK = new TarjetacreditoPK(tarId, perId);
    }

    public TarjetacreditoPK getTarjetacreditoPK() {
        return tarjetacreditoPK;
    }

    public void setTarjetacreditoPK(TarjetacreditoPK tarjetacreditoPK) {
        this.tarjetacreditoPK = tarjetacreditoPK;
    }

    public String getTarNumero() {
        return tarNumero;
    }

    public void setTarNumero(String tarNumero) {
        this.tarNumero = tarNumero;
    }

    public Date getTarFechaExpiracion() {
        return tarFechaExpiracion;
    }

    public void setTarFechaExpiracion(Date tarFechaExpiracion) {
        this.tarFechaExpiracion = tarFechaExpiracion;
    }

    public int getTarCodigoSeguridad() {
        return tarCodigoSeguridad;
    }

    public void setTarCodigoSeguridad(int tarCodigoSeguridad) {
        this.tarCodigoSeguridad = tarCodigoSeguridad;
    }

    public String getTarTipo() {
        return tarTipo;
    }

    public void setTarTipo(String tarTipo) {
        this.tarTipo = tarTipo;
    }

    @XmlTransient
    public Collection<Compra> getCompraCollection() {
        return compraCollection;
    }

    public void setCompraCollection(Collection<Compra> compraCollection) {
        this.compraCollection = compraCollection;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tarjetacreditoPK != null ? tarjetacreditoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarjetacredito)) {
            return false;
        }
        Tarjetacredito other = (Tarjetacredito) object;
        if ((this.tarjetacreditoPK == null && other.tarjetacreditoPK != null) || (this.tarjetacreditoPK != null && !this.tarjetacreditoPK.equals(other.tarjetacreditoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thinktanksoft.stampurestyle.Tarjetacredito[ tarjetacreditoPK=" + tarjetacreditoPK + " ]";
    }
    
}
