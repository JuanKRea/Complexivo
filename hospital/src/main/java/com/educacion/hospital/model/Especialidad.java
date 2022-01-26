
package com.educacion.hospital.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "especialidad")
@NamedQueries({
    @NamedQuery(name = "especialidad.findAll", query = "SELECT p FROM Especialidad p")})
public class Especialidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "est_esp")
    private Integer idesp;
    @Column(name = "fec_cre")
    private Date fecha;
    @Column(name = "nom_esp")
    private String nombre;

    public Integer getIdesp() {
        return idesp;
    }

    public void setIdesp(Integer idesp) {
        this.idesp = idesp;
    }

    public Date getFecha() {

        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
