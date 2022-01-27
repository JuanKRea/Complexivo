
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
@Table(name = "ciudad")
@NamedQueries({
    @NamedQuery(name = "ciudad.findAll", query = "SELECT r FROM Ciudad r")})
public class Ciudad implements Serializable {

    @Id
    @Column(name = "idciudad")
    private Integer idciudad;

    @Column(name = "nom_ciudad")
    private String ciudad;
/*
    @OneToMany(mappedBy = "persona")
    private List<Persona> personas;
*/
    public Integer getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Integer idciudad) {
        this.idciudad = idciudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

  

    

    
}
