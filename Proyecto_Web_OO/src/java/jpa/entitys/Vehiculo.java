/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entitys;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
 * @author Javier
 */
@Entity
@Table(name = "vehiculo", catalog = "proyectoweboo", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v"),
    @NamedQuery(name = "Vehiculo.findByPatente", query = "SELECT v FROM Vehiculo v WHERE v.patente = :patente"),
    @NamedQuery(name = "Vehiculo.findByMarca", query = "SELECT v FROM Vehiculo v WHERE v.marca = :marca"),
    @NamedQuery(name = "Vehiculo.findByModelo", query = "SELECT v FROM Vehiculo v WHERE v.modelo = :modelo"),
    @NamedQuery(name = "Vehiculo.findByKm", query = "SELECT v FROM Vehiculo v WHERE v.km = :km"),
    @NamedQuery(name = "Vehiculo.findByA\u00f1o", query = "SELECT v FROM Vehiculo v WHERE v.a\u00f1o = :a\u00f1o"),
    @NamedQuery(name = "Vehiculo.findByPrecio", query = "SELECT v FROM Vehiculo v WHERE v.precio = :precio"),
    @NamedQuery(name = "Vehiculo.findByColor", query = "SELECT v FROM Vehiculo v WHERE v.color = :color"),
    @NamedQuery(name = "Vehiculo.findByCilindrada", query = "SELECT v FROM Vehiculo v WHERE v.cilindrada = :cilindrada"),
    @NamedQuery(name = "Vehiculo.findByTransmision", query = "SELECT v FROM Vehiculo v WHERE v.transmision = :transmision"),
    @NamedQuery(name = "Vehiculo.findByAirbag", query = "SELECT v FROM Vehiculo v WHERE v.airbag = :airbag"),
    @NamedQuery(name = "Vehiculo.findBySistemaAbs", query = "SELECT v FROM Vehiculo v WHERE v.sistemaAbs = :sistemaAbs"),
    @NamedQuery(name = "Vehiculo.findByAireAcondicionado", query = "SELECT v FROM Vehiculo v WHERE v.aireAcondicionado = :aireAcondicionado"),
    @NamedQuery(name = "Vehiculo.findByNumeroChasis", query = "SELECT v FROM Vehiculo v WHERE v.numeroChasis = :numeroChasis"),
    @NamedQuery(name = "Vehiculo.findByEstado", query = "SELECT v FROM Vehiculo v WHERE v.estado = :estado")})
public class Vehiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "patente", nullable = false, length = 20)
    private String patente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "marca", nullable = false, length = 45)
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "modelo", nullable = false, length = 45)
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "km", nullable = false)
    private int km;
    @Basic(optional = false)
    @NotNull
    @Column(name = "a\u00f1o", nullable = false)
    private int año;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio", nullable = false)
    private int precio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "color", nullable = false, length = 45)
    private String color;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cilindrada", nullable = false)
    private int cilindrada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "transmision", nullable = false, length = 45)
    private String transmision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "airbag", nullable = false)
    private boolean airbag;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sistema_Abs", nullable = false)
    private boolean sistemaAbs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aire_Acondicionado", nullable = false)
    private boolean aireAcondicionado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "numero_Chasis", nullable = false, length = 45)
    private String numeroChasis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado", nullable = false)
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patente")
    private Collection<Oferta> ofertaCollection;
    @JoinColumn(name = "id_Tipo_Vehiculo", referencedColumnName = "id_Tipo_Vehiculo", nullable = false)
    @ManyToOne(optional = false)
    private Tipovehiculo idTipoVehiculo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patente")
    private Collection<Reserva> reservaCollection;

    public Vehiculo() {
    }

    public Vehiculo(String patente) {
        this.patente = patente;
    }

    public Vehiculo(String patente, String marca, String modelo, int km, int año, int precio, String color, int cilindrada, String transmision, boolean airbag, boolean sistemaAbs, boolean aireAcondicionado, String numeroChasis, boolean estado) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.km = km;
        this.año = año;
        this.precio = precio;
        this.color = color;
        this.cilindrada = cilindrada;
        this.transmision = transmision;
        this.airbag = airbag;
        this.sistemaAbs = sistemaAbs;
        this.aireAcondicionado = aireAcondicionado;
        this.numeroChasis = numeroChasis;
        this.estado = estado;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public String getAirbag() {
        return airbag ? "Si" : "No";
    }

    public void setAirbag(boolean airbag) {
        this.airbag = airbag;
    }

    public String getSistemaAbs() {
        return sistemaAbs ? "Si" : "No";
    }

    public void setSistemaAbs(boolean sistemaAbs) {
        this.sistemaAbs = sistemaAbs;
    }

    public String getAireAcondicionado() {
        return aireAcondicionado ? "Si" : "No";
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public String getNumeroChasis() {
        return numeroChasis;
    }

    public void setNumeroChasis(String numeroChasis) {
        this.numeroChasis = numeroChasis;
    }

    public String getEstado() {
        return  estado ? "Activo" : "Inactivo";
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Oferta> getOfertaCollection() {
        return ofertaCollection;
    }

    public void setOfertaCollection(Collection<Oferta> ofertaCollection) {
        this.ofertaCollection = ofertaCollection;
    }

    public Tipovehiculo getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(Tipovehiculo idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patente != null ? patente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.patente == null && other.patente != null) || (this.patente != null && !this.patente.equals(other.patente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return patente;
    }
    
}
