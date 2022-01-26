
package com.educacion.hospital.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "medico_especialidad")
@NamedQuery(name = "MedicoEspecialidad.findAll", query = "SELECT m FROM MedicoEspecialidad m")
public class MedicoEspecialidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private MedicoEspecialidadPK id;

    public MedicoEspecialidad() {
    }

    public MedicoEspecialidadPK getId() {
        return id;
    }

    public void setId(MedicoEspecialidadPK id) {
        this.id = id;
    }

}
