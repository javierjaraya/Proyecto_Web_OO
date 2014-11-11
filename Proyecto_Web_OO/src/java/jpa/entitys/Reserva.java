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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Javier
 */
@Entity
@Table(name = "reserva", catalog = "proyectoweboo", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r"),
    @NamedQuery(name = "Reserva.findByIdReserva", query = "SELECT r FROM Reserva r WHERE r.idReserva = :idReserva"),
    @NamedQuery(name = "Reserva.findByFechaInicio", query = "SELECT r FROM Reserva r WHERE r.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Reserva.findByFechaTermino", query = "SELECT r FROM Reserva r WHERE r.fechaTermino = :fechaTermino"),
    @NamedQuery(name = "Reserva.findByAbono", query = "SELECT r FROM Reserva r WHERE r.abono = :abono"),
    @NamedQuery(name = "Reserva.findByEstado", query = "SELECT r FROM Reserva r WHERE r.estado = :estado")})
public class Reserva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Reserva", nullable = false)
    private Integer idReserva;
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
    @Column(name = "abono")
    private Integer abono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado", nullable = false)
    private boolean estado;
    @JoinColumn(name = "rut_Usuario", referencedColumnName = "rut_Usuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario rutUsuario;
    @JoinColumn(name = "patente", referencedColumnName = "patente", nullable = false)
    @ManyToOne(optional = false)
    private Vehiculo patente;

    public Reserva() {
    }

    public Reserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Reserva(Integer idReserva, Date fechaInicio, Date fechaTermino, boolean estado) {
        this.idReserva = idReserva;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.estado = estado;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
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

    public Integer getAbono() {
        return abono;
    }

    public void setAbono(Integer abono) {
        this.abono = abono;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Usuario getRutUsuario() {
        return rutUsuario;
    }

    public void setRutUsuario(Usuario rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public Vehiculo getPatente() {
        return patente;
    }

    public void setPatente(Vehiculo patente) {
        this.patente = patente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReserva != null ? idReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.idReserva == null && other.idReserva != null) || (this.idReserva != null && !this.idReserva.equals(other.idReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entitys.Reserva[ idReserva=" + idReserva + " ]";
    }
    
}
