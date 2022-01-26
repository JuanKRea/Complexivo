
package com.educacion.hospital.view;

import com.educacion.hospital.dao.CitaDao;
import com.educacion.hospital.dao.MedicoDao;
import com.educacion.hospital.dao.PersonaDao;
import com.educacion.hospital.dto.Mensaje;
import com.educacion.hospital.model.Cita;
import com.educacion.hospital.model.Medico;
import com.educacion.hospital.model.Persona;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;


@ManagedBean
@ViewScoped
public class HistorialView implements Serializable {

    private static final long serialVersionUID = 5443351151396868724L;
    //@EJB
    private Mensaje mensaje;
    private Persona personaSearch;
    private Persona persona;
    private boolean found;
    private PersonaDao personaDao;
    private List<Cita> listCita;
    private CitaDao citaDao;
    private Cita citaSelected;
    private Medico medico;
    private Medico medicoSearch;
    private MedicoDao medicoDao;

    public HistorialView() {
        personaSearch = new Persona();
        persona = new Persona();
        personaDao = new PersonaDao();
        listCita = new ArrayList<>();
        citaDao = new CitaDao();
        medico = new Medico();
        medicoSearch = new Medico();
        medicoDao = new MedicoDao();
    }

    public void consultarPaciente() {
        try {
            this.persona = personaDao.obtener(personaSearch.getCedula());
            if (null == this.persona) {
                this.persona = new Persona();
                this.personaSearch = new Persona();
                this.listCita = new ArrayList<>();
                this.found = false;
                mostarConfirmacion("Paciente", "No existe la cédula ingresada");
            } else {
                this.found = true;
                consultarCitabyPaciente(this.persona.getCedula());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void consultarCitabyPaciente(String idPaciente) {
        try {
            this.listCita = citaDao.obtenerCitasbyPaciente(idPaciente);
        } catch (Exception ex) {
            mostarConfirmacion("Citas", "Error a consultar " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
    }

    public void verDetalleCita(Cita cita) {
        System.out.println("com.educacion.hospital.view.HistorialView.verDetalleCita()");
        this.citaSelected = cita;
        PrimeFaces.current().executeScript("PF('dlg1').show();");
    }

    public void consultarMedico() {
        try {
            this.medico = medicoDao.obtener(medicoSearch.getIdmedico());
            if (null == this.medico) {
                this.medico = new Medico();
                this.medicoSearch = new Medico();
                this.listCita = new ArrayList<>();
                this.found = false;
                mostarConfirmacion("Médico", "No existe la identificación ingresada");
            } else {
                this.found = true;
                consultarCitabyMedico(this.medico.getIdmedico());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void consultarCitabyMedico(String idMedico) {
        try {
            this.listCita = citaDao.obtenerCitasbyMedico(idMedico);
        } catch (Exception ex) {
            mostarConfirmacion("Citas", "Error a consultar " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
    }

    public void mostarConfirmacion(String header, String descripcion) {
        mensaje = new Mensaje();
        mensaje.setHeader(header);
        mensaje.setDescripcion(descripcion);
        PrimeFaces.current().executeScript("PF('confirmDialogwidget').show();");
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    public Persona getPersonaSearch() {
        return personaSearch;
    }

    public void setPersonaSearch(Persona personaSearch) {
        this.personaSearch = personaSearch;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public List<Cita> getListCita() {
        return listCita;
    }

    public void setListCita(List<Cita> listCita) {
        this.listCita = listCita;
    }

    public Cita getCitaSelected() {
        return citaSelected;
    }

    public void setCitaSelected(Cita citaSelected) {
        this.citaSelected = citaSelected;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Medico getMedicoSearch() {
        return medicoSearch;
    }

    public void setMedicoSearch(Medico medicoSearch) {
        this.medicoSearch = medicoSearch;
    }

}
