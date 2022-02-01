
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
@Table(name = "examen")
@NamedQueries({
    @NamedQuery(name = "examen.findAll", query = "SELECT p FROM Examen p")})
public class Examen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idexamen")
    private Integer idexa;
    @Column(name = "examen")
    private String examen;
    @Column(name = "laboratorio")
    private String exalab;

    public Integer getIdexa() {
        return idexa;
    }

    public void setIdexa(Integer idexa) {
        this.idexa = idexa;
    }

    public String getExamen() {
        return examen;
    }

    public void setExamen(String examen) {
        this.examen = examen;
    }

  

    public String getExalab() {
        return exalab;
    }

    public void setExalab(String exalab) {
        this.exalab = exalab;
    }

}
