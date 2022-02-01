
package com.educacion.hospital.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class CitaMedicamentoPK implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "cita_id_Cita")
    private Integer idCita;

    @Column(name = "medicamento_idmedicamento")
    private Integer idMedicamento;

    @Column(name = "cantidad")
    private Integer cantidad;
    
    @Column(name = "detalle")
    private String detalle;

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
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
    

    public Integer getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

  
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CitaMedicamentoPK)) {
            return false;
        }
        CitaMedicamentoPK castOther = (CitaMedicamentoPK) other;
        return this.idCita.equals(castOther.idCita)
                && (this.idMedicamento == castOther.idMedicamento);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.idCita.hashCode();
        hash = hash * prime + ((int) this.idMedicamento);

        return hash;
    }
}
