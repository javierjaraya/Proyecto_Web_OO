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
@Table(name = "usuario", catalog = "proyectoweboo", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByRutUsuario", query = "SELECT u FROM Usuario u WHERE u.rutUsuario = :rutUsuario"),
    @NamedQuery(name = "Usuario.findByNombres", query = "SELECT u FROM Usuario u WHERE u.nombres = :nombres"),
    @NamedQuery(name = "Usuario.findByApellidos", query = "SELECT u FROM Usuario u WHERE u.apellidos = :apellidos"),
    @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findByDireccion", query = "SELECT u FROM Usuario u WHERE u.direccion = :direccion"),
    @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password"),
    @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "rut_Usuario", nullable = false, length = 20)
    private String rutUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono", nullable = false)
    private int telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "password", nullable = false, length = 20)
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado", nullable = false)
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutUsuario")
    private Collection<Arriendo> arriendoCollection;
    @JoinColumn(name = "id_Perfil", referencedColumnName = "id_perfil", nullable = false)
    @ManyToOne(optional = false)
    private Perfil idPerfil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutOrigen")
    private Collection<Mensaje> mensajeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutDestino")
    private Collection<Mensaje> mensajeCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutUsuario")
    private Collection<Reserva> reservaCollection;

    public Usuario() {
    }

    public Usuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public Usuario(String rutUsuario, String nombres, String apellidos, int telefono, String email, String direccion, String password, boolean estado) {
        this.rutUsuario = rutUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.password = password;
        this.estado = estado;
    }

    public String getRutUsuario() {
        return rutUsuario;
    }

    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Arriendo> getArriendoCollection() {
        return arriendoCollection;
    }

    public void setArriendoCollection(Collection<Arriendo> arriendoCollection) {
        this.arriendoCollection = arriendoCollection;
    }

    public Perfil getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Perfil idPerfil) {
        this.idPerfil = idPerfil;
    }

    @XmlTransient
    public Collection<Mensaje> getMensajeCollection() {
        return mensajeCollection;
    }

    public void setMensajeCollection(Collection<Mensaje> mensajeCollection) {
        this.mensajeCollection = mensajeCollection;
    }

    @XmlTransient
    public Collection<Mensaje> getMensajeCollection1() {
        return mensajeCollection1;
    }

    public void setMensajeCollection1(Collection<Mensaje> mensajeCollection1) {
        this.mensajeCollection1 = mensajeCollection1;
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
        hash += (rutUsuario != null ? rutUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.rutUsuario == null && other.rutUsuario != null) || (this.rutUsuario != null && !this.rutUsuario.equals(other.rutUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return rutUsuario;
    }
    
}
