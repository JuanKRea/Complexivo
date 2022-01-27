
package com.educacion.hospital.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "persona")
@NamedQueries({@NamedQuery(name = "persona.findAll", query = "SELECT p FROM Persona p")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_per")
    private String cedula;
    @Column(name = "fec_nac")
    private Date fechaNacimiento;
    @Column(name = "nom_per")
    private String nombres;
    @Column(name = "dir_dom")
    private String direccion;
    @Column(name = "dir_cor")
    private String correo;
    @Column(name = "num_tel")
    private String telefono;
   
     
    @ManyToOne
    private Genero genero;
    
    @ManyToOne
    private Ciudad ciudad;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

}
