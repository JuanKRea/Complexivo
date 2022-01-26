
package com.educacion.hospital.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "cita")
@NamedQueries({
    @NamedQuery(name = "cita.findAll", query = "SELECT c FROM Cita c")})
public class Cita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_Cita")
    private Integer idCita;
    @Temporal(TemporalType.DATE)
    @Column(name = "fec_cit")
    private Date fechaCita;
    @Column(name = "hor_cit")
    private Time horaCita;
    @Column(name = "num_fac")
    private Integer numFac;
    @Column(name = "est_cit")
    private String estCit;
    @Column(name = "diagnostico")
    private String diagnostico;
    @Column(name = "tratamiento")
    private String tratamiento;
    @Column(name = "observaciones")
    private String observaciones;
//bi-directional many-to-one association to Historia
    //@ManyToOne
    //private Historia historia;

    //bi-directional many-to-one association to Especialidad
    @ManyToOne
    private Especialidad especialidad;

    //bi-directional many-to-one association to Medico
    @ManyToOne
    private Medico medico;

    //bi-directional many-to-one association to Persona
    @ManyToOne
    private Persona persona;

    //bi-directional many-to-one association to Usuario
    //@ManyToOne
    //private Usuario usuario;
    //bi-directional many-to-one association to Factura
    //@OneToMany(mappedBy="cita")
    //private List<Factura> facturas;
    public Cita() {
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Time getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(Time horaCita) {
        this.horaCita = horaCita;
    }

    public Integer getNumFac() {
        return numFac;
    }

    public void setNumFac(Integer numFac) {
        this.numFac = numFac;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getEstCit() {
        return estCit;
    }

    public void setEstCit(String estCit) {
        this.estCit = estCit;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
