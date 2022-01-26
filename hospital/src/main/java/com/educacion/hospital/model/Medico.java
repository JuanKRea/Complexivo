
package com.educacion.hospital.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "medico")
@NamedQueries({
    @NamedQuery(name = "medico.findAll", query = "SELECT p FROM Medico p")})
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_med")
    private String idmedico;
    @Column(name = "nom_med")
    private String nombre;
    @Column(name = "cor_med")
    private String correo;
    @Column(name = "tel_med")
    private String telefono;
    @ManyToMany
    @JoinTable(
            name = "medico_especialidad",
            joinColumns = {
                @JoinColumn(name = "medico_id_med")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "especialidad_est_esp")
            }
    )
    private List<Especialidad> especialidades;

    public String getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(String idmedico) {
        this.idmedico = idmedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

}
