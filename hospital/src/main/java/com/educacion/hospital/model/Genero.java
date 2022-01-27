
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
@Table(name = "genero")
@NamedQueries({
    @NamedQuery(name = "genero.findAll", query = "SELECT r FROM Genero r")})
public class Genero implements Serializable {

    @Id
    @Column(name = "idgenero")
    private Integer idgenero;

    @Column(name = "genero")
    private String genero;

 /*   @OneToMany(mappedBy = "persona")
    private List<Persona> personas;
*/
    public Integer getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(Integer idgenero) {
        this.idgenero = idgenero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    
}
