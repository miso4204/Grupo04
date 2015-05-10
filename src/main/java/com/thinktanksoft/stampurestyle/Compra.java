/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinktanksoft.stampurestyle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
    @NamedQuery(name = "Compra.findByComId", query = "SELECT c FROM Compra c WHERE c.comId = :comId"),
    @NamedQuery(name = "Compra.findByComValor", query = "SELECT c FROM Compra c WHERE c.comValor = :comValor"),
    @NamedQuery(name = "Compra.findByComPais", query = "SELECT c FROM Compra c WHERE c.comPais = :comPais"),
    @NamedQuery(name = "Compra.findByComCiudad", query = "SELECT c FROM Compra c WHERE c.comCiudad = :comCiudad"),
    @NamedQuery(name = "Compra.findByComDireccion", query = "SELECT c FROM Compra c WHERE c.comDireccion = :comDireccion"),
    @NamedQuery(name = "Compra.findNextId", query = "SELECT max(c.comId)+1 FROM Compra c")})
public class Compra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "com_id")
    private Integer comId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "com_valor")
    private BigDecimal comValor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "com_pais")
    private String comPais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "com_ciudad")
    private String comCiudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "com_direccion")
    private String comDireccion;
    @JoinColumn(name = "usu_id", referencedColumnName = "usu_id")
    @ManyToOne(optional = false)
    private Usuario usuId;
    @JoinColumn(name = "tip_pag_id", referencedColumnName = "tip_pag_id")
    @ManyToOne(optional = false)
    private Tipopago tipPagId;
    @JoinColumns({
        @JoinColumn(name = "tar_id", referencedColumnName = "tar_id"),
        @JoinColumn(name = "per_id", referencedColumnName = "per_id")})
    @ManyToOne
    private Tarjetacredito tarjetacredito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comId")
    private Collection<Proddisxcompra> proddisxcompraCollection;
    @Basic(optional = true)
    @Column(name = "com_observ")
    private String comObserv;
     
    public Compra() {
    }

    public Compra(Integer comId) {
        this.comId = comId;
    }

    public Compra(Integer comId, BigDecimal comValor, String comPais, String comCiudad, String comDireccion) {
        this.comId = comId;
        this.comValor = comValor;
        this.comPais = comPais;
        this.comCiudad = comCiudad;
        this.comDireccion = comDireccion;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public BigDecimal getComValor() {
        return comValor;
    }

    public void setComValor(BigDecimal comValor) {
        this.comValor = comValor;
    }

    public String getComPais() {
        return comPais;
    }

    public void setComPais(String comPais) {
        this.comPais = comPais;
    }

    public String getComCiudad() {
        return comCiudad;
    }

    public void setComCiudad(String comCiudad) {
        this.comCiudad = comCiudad;
    }

    public String getComDireccion() {
        return comDireccion;
    }

    public void setComDireccion(String comDireccion) {
        this.comDireccion = comDireccion;
    }

    public Usuario getUsuId() {
        return usuId;
    }

    public void setUsuId(Usuario usuId) {
        this.usuId = usuId;
    }

    public Tipopago getTipPagId() {
        return tipPagId;
    }

    public void setTipPagId(Tipopago tipPagId) {
        this.tipPagId = tipPagId;
    }

    public Tarjetacredito getTarjetacredito() {
        return tarjetacredito;
    }

    public void setTarjetacredito(Tarjetacredito tarjetacredito) {
        this.tarjetacredito = tarjetacredito;
    }

    @XmlTransient
    public Collection<Proddisxcompra> getProddisxcompraCollection() {
        return proddisxcompraCollection;
    }

    public void setProddisxcompraCollection(Collection<Proddisxcompra> proddisxcompraCollection) {
        this.proddisxcompraCollection = proddisxcompraCollection;
    }

    public String getComObserv() {
        return comObserv;
    }

    public void setComObserv(String comObserv) {
        this.comObserv = comObserv;
    }   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comId != null ? comId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.comId == null && other.comId != null) || (this.comId != null && !this.comId.equals(other.comId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.thinktanksoft.stampurestyle.Compra[ comId=" + comId + " ]";
    }
    
}
