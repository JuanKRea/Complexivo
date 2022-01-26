
package com.educacion.hospital.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Serializable {

    @Id
    @Column(name = "id_usr")
    private String idUsr;

    @Column(name = "cor_usr")
    private String corUsr;

    @Temporal(TemporalType.DATE)
    @Column(name = "fec_ing")
    private Date fecIng;

    @Column(name = "name_usr")
    private String nameUsr;

    @Column(name = "nom_usr")
    private String nomUsr;

    @Column(name = "pas_usr")
    private String pasUsr;

    @Column(name = "tel_usr")
    private String telUsr;

    @ManyToOne
    private Rol rol;

    public String getIdUsr() {
        return idUsr;
    }

    public void setIdUsr(String idUsr) {
        this.idUsr = idUsr;
    }

    public String getCorUsr() {
        return corUsr;
    }

    public void setCorUsr(String corUsr) {
        this.corUsr = corUsr;
    }

    public Date getFecIng() {
        return fecIng;
    }

    public void setFecIng(Date fecIng) {
        this.fecIng = fecIng;
    }

    public String getNameUsr() {
        return nameUsr;
    }

    public void setNameUsr(String nameUsr) {
        this.nameUsr = nameUsr;
    }

    public String getNomUsr() {
        return nomUsr;
    }

    public void setNomUsr(String nomUsr) {
        this.nomUsr = nomUsr;
    }

    public String getPasUsr() {
        return pasUsr;
    }

    public void setPasUsr(String pasUsr) {
        this.pasUsr = pasUsr;
    }

    public String getTelUsr() {
        return telUsr;
    }

    public void setTelUsr(String telUsr) {
        this.telUsr = telUsr;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

}
