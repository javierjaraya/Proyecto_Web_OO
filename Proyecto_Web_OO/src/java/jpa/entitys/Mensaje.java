/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entitys;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
@Table(name = "mensaje", catalog = "proyectoweboo", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensaje.findAll", query = "SELECT m FROM Mensaje m"),
    @NamedQuery(name = "Mensaje.findByIdMensaje", query = "SELECT m FROM Mensaje m WHERE m.idMensaje = :idMensaje"),
    @NamedQuery(name = "Mensaje.findByFecha", query = "SELECT m FROM Mensaje m WHERE m.fecha = :fecha"),
    @NamedQuery(name = "Mensaje.findByHora", query = "SELECT m FROM Mensaje m WHERE m.hora = :hora"),
    @NamedQuery(name = "Mensaje.findByAsunto", query = "SELECT m FROM Mensaje m WHERE m.asunto = :asunto"),
    @NamedQuery(name = "Mensaje.findByMensaje", query = "SELECT m FROM Mensaje m WHERE m.mensaje = :mensaje"),
    @NamedQuery(name = "Mensaje.findByEstado", query = "SELECT m FROM Mensaje m WHERE m.estado = :estado")})
public class Mensaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Mensaje", nullable = false)
    private Integer idMensaje;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "asunto", nullable = false, length = 50)
    private String asunto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "mensaje", nullable = false, length = 200)
    private String mensaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado", nullable = false)
    private boolean estado;
    @JoinColumn(name = "rut_Origen", referencedColumnName = "rut_Usuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario rutOrigen;
    @JoinColumn(name = "rut_Destino", referencedColumnName = "rut_Usuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario rutDestino;

    public Mensaje() {
        Calendar cal =  new GregorianCalendar();
        this.fecha = cal.getTime();
        this.hora = cal.getTime();
    }

    public Mensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public Mensaje(Integer idMensaje, String asunto, String mensaje, boolean estado) {
        this.idMensaje = idMensaje;
        this.asunto = asunto;
        this.mensaje = mensaje;
        this.estado = estado;
    }

    public Integer getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Usuario getRutOrigen() {
        return rutOrigen;
    }

    public void setRutOrigen(Usuario rutOrigen) {
        this.rutOrigen = rutOrigen;
    }

    public Usuario getRutDestino() {
        return rutDestino;
    }

    public void setRutDestino(Usuario rutDestino) {
        this.rutDestino = rutDestino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMensaje != null ? idMensaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensaje)) {
            return false;
        }
        Mensaje other = (Mensaje) object;
        if ((this.idMensaje == null && other.idMensaje != null) || (this.idMensaje != null && !this.idMensaje.equals(other.idMensaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entitys.Mensaje[ idMensaje=" + idMensaje + " ]";
    }
    
}
