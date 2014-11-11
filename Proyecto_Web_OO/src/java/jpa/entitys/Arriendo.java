/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entitys;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Javier
 */
@Entity
@Table(name = "arriendo", catalog = "proyectoweboo", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arriendo.findAll", query = "SELECT a FROM Arriendo a"),
    @NamedQuery(name = "Arriendo.findByIdArriendo", query = "SELECT a FROM Arriendo a WHERE a.idArriendo = :idArriendo"),
    @NamedQuery(name = "Arriendo.findByFechaInicio", query = "SELECT a FROM Arriendo a WHERE a.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Arriendo.findByFechaTermino", query = "SELECT a FROM Arriendo a WHERE a.fechaTermino = :fechaTermino"),
    @NamedQuery(name = "Arriendo.findByPatente", query = "SELECT a FROM Arriendo a WHERE a.patente = :patente"),
    @NamedQuery(name = "Arriendo.findByPrecio", query = "SELECT a FROM Arriendo a WHERE a.precio = :precio")})
public class Arriendo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Arriendo", nullable = false)
    private Integer idArriendo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_Inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_Termino", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaTermino;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "patente", nullable = false, length = 45)
    private String patente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio", nullable = false)
    private int precio;
    @JoinColumn(name = "rut_Usuario", referencedColumnName = "rut_Usuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario rutUsuario;
    @JoinColumn(name = "id_Oferta", referencedColumnName = "id_Oferta", nullable = false)
    @ManyToOne(optional = false)
    private Oferta idOferta;

    public Arriendo() {
    }

    public Arriendo(Integer idArriendo) {
        this.idArriendo = idArriendo;
    }

    public Arriendo(Integer idArriendo, Date fechaInicio, Date fechaTermino, String patente, int precio) {
        this.idArriendo = idArriendo;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.patente = patente;
        this.precio = precio;
    }

    public Integer getIdArriendo() {
        return idArriendo;
    }

    public void setIdArriendo(Integer idArriendo) {
        this.idArriendo = idArriendo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Usuario getRutUsuario() {
        return rutUsuario;
    }

    public void setRutUsuario(Usuario rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public Oferta getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Oferta idOferta) {
        this.idOferta = idOferta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArriendo != null ? idArriendo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arriendo)) {
            return false;
        }
        Arriendo other = (Arriendo) object;
        if ((this.idArriendo == null && other.idArriendo != null) || (this.idArriendo != null && !this.idArriendo.equals(other.idArriendo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entitys.Arriendo[ idArriendo=" + idArriendo + " ]";
    }
    
}
