
package com.educacion.hospital.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "cita_medicamento")
@NamedQuery(name = "CitaMedicamento.findAll", query = "SELECT m FROM CitaMedicamento m")
public class CitaMedicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private CitaMedicamentoPK id;

       @Column(name = "cantidad")
    private Integer cantidad;
    
    @Column(name = "detalle")
    private String detalle;
    
   

    public CitaMedicamento() {
    }

    public CitaMedicamentoPK getId() {
        return id;
    }

    public void setId(CitaMedicamentoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

  


}
