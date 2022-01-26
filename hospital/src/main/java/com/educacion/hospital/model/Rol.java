
package com.educacion.hospital.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "rol")
@NamedQueries({
    @NamedQuery(name = "rol.findAll", query = "SELECT r FROM Rol r")})
public class Rol implements Serializable {

    @Id
    @Column(name = "id_Rol")
    private Integer idRol;

    @Column(name = "nom_Rol")
    private String nombreRol;

    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuarios;

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
