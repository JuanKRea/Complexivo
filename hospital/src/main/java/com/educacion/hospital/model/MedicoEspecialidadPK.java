
package com.educacion.hospital.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class MedicoEspecialidadPK implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "medico_id_med")
    private String idMedico;

    @Column(name = "especialidad_est_esp")
    private Integer idEspecialidad;

    public MedicoEspecialidadPK() {
    }

    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MedicoEspecialidadPK)) {
            return false;
        }
        MedicoEspecialidadPK castOther = (MedicoEspecialidadPK) other;
        return this.idMedico.equals(castOther.idMedico)
                && (this.idEspecialidad == castOther.idEspecialidad);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.idMedico.hashCode();
        hash = hash * prime + ((int) this.idEspecialidad);

        return hash;
    }
}
