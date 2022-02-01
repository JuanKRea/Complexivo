
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
@Table(name = "medicamento")
@NamedQueries({
    @NamedQuery(name = "medicamento.findAll", query = "SELECT p FROM Medicamento p")})
public class Medicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idmedicamento")
    private Integer idmedica;
    @Column(name = "medicamento")
    private String medicamento;
    @Column(name = "laboratorio")
    private String medicalab;
    @Column(name = "presenta")
    private String presenta;

    public Integer getIdmedica() {
        return idmedica;
    }

    public void setIdmedica(Integer idmedica) {
        this.idmedica = idmedica;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

  

    public String getMedicalab() {
        return medicalab;
    }

    public void setMedicalab(String medicalab) {
        this.medicalab = medicalab;
    }

    public String getPresenta() {
        return presenta;
    }

    public void setPresenta(String presenta) {
        this.presenta = presenta;
    }


}
