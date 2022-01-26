
package com.educacion.hospital.view;

import com.educacion.hospital.dao.CitaDao;
import com.educacion.hospital.dao.EspecialidadDao;
import com.educacion.hospital.dao.MedicoDao;
import com.educacion.hospital.dto.Mensaje;
import com.educacion.hospital.dao.PersonaDao;
import com.educacion.hospital.model.Cita;
import com.educacion.hospital.model.Especialidad;
import com.educacion.hospital.model.Medico;
import com.educacion.hospital.model.Persona;
import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;


@ManagedBean
@ViewScoped
public class CitaView implements Serializable {

    private static final long serialVersionUID = 5443351151396868724L;
    //@EJB
    private PersonaDao personaDao;
    private MedicoDao medicoDao;
    private EspecialidadDao especialidadDao;
    private CitaDao citaDao;
    private Persona persona;
    private Persona personaSearch;
    private Mensaje mensaje;
    private List<Persona> listPersona;
    private Medico medicoSelected;
    private Especialidad especialidadSelected;
    private List<Medico> listMedico;
    private List<Cita> listCita;
    private List<Especialidad> listEspecialidad;
    private Cita cita;
    private Cita citaSearch;
    private Date horaCit;
    private boolean found;

    public CitaView() {
        persona = new Persona();
        personaSearch = new Persona();
        listPersona = new ArrayList<>();
        personaDao = new PersonaDao();
        listMedico = new ArrayList<>();
        medicoDao = new MedicoDao();
        medicoSelected = new Medico();
        especialidadSelected = new Especialidad();
        listEspecialidad = new ArrayList<>();
        especialidadDao = new EspecialidadDao();
        cita = new Cita();
        citaSearch = new Cita();
        citaDao = new CitaDao();
    }

    public void consultarPersona() {
        try {
            this.persona = personaDao.obtener(personaSearch.getCedula());
            if (null == this.persona) {
                this.persona = new Persona();
                this.personaSearch = new Persona();
                this.listMedico = new ArrayList<>();
                this.medicoSelected = new Medico();
                this.listEspecialidad = new ArrayList<>();
                this.especialidadSelected = new Especialidad();
                this.cita = new Cita();
                this.horaCit = new Date();
                this.found = false;
                mostarConfirmacion("Citas", "No existe la cédula ingresada");
            } else {
                this.found = true;
                this.consultarAllEspecialidad();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void consultarAllMedico() {
        try {
            this.listMedico = medicoDao.obtenerAllMedicos();
            if (null != this.listMedico) {
                this.medicoSelected = this.listMedico.get(0);
                this.listEspecialidad = especialidadDao.obtenerEspecialidadesbyMedico(this.listMedico.get(0).getIdmedico());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
public void consultarAllEspecialidad() {
        try {
            this.listEspecialidad= especialidadDao.obtenerEspecialidades();
            if (null != this.listEspecialidad) {
                this.especialidadSelected = this.listEspecialidad.get(0);
                this.listMedico = medicoDao.obtenerMedicobyEspecialidades(this.listEspecialidad.get(0).getIdesp());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void cargarEspecialidad() {
        try {
            if (null != this.medicoSelected) {
                this.listEspecialidad = especialidadDao.obtenerEspecialidadesbyMedico(this.medicoSelected.getIdmedico());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

        public void cargarMedico() {
        try {
            if (null != this.especialidadSelected) {
                this.listMedico = medicoDao.obtenerMedicobyEspecialidades(this.especialidadSelected.getIdesp());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
    public void crearCita() {
        try {
            Integer lastId = citaDao.getLastIdCita();
            this.cita.setIdCita(lastId + 1);
            this.cita.setPersona(this.persona);
            this.cita.setMedico(this.medicoSelected);
            this.cita.setEspecialidad(this.especialidadSelected);
            Time time = new Time(this.horaCit.getTime());
            this.cita.setHoraCita(time);
            this.cita.setEstCit("A");
            citaDao.crear(this.cita);
            this.persona = new Persona();
            this.personaSearch = new Persona();
            this.listMedico = new ArrayList<>();
            this.medicoSelected = new Medico();
            this.listEspecialidad = new ArrayList<>();
            this.especialidadSelected = new Especialidad();
            this.cita = new Cita();
            this.horaCit = new Date();
            mostarConfirmacion("Citas", "Cita generada correctamente");
        } catch (Exception ex) {
            mostarConfirmacion("Citas", "No se creó la cita " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
    }

    public void consultarCitas() {
        try {
            this.listCita = citaDao.obtenerAllCitas();
        } catch (Exception ex) {
            mostarConfirmacion("Citas", "Error a consultar " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
    }

    public void consultarNumeroCita() {
        try {
            this.cita = citaDao.obtenerCitabyId(this.citaSearch.getIdCita());
            if (null == this.cita) {
                this.cita = new Cita();
                this.citaSearch = new Cita();
                this.found = false;
                mostarConfirmacion("Cita", "No existe la cita ingresada");
            } else {
                this.found = true;
            }
        } catch (Exception ex) {
            mostarConfirmacion("Citas", "Error a consultar " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
    }

    public void gestionarCita() {
        try {
            this.cita.setEstCit("P");
            citaDao.actualiza(this.cita);
            mostarConfirmacion("Cita", "Cita gestionada correctamente");
            this.cita = new Cita();
            this.citaSearch = new Cita();
            this.found = false;
        } catch (Exception ex) {
            mostarConfirmacion("Citas", "Error al gestionar Cita " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
    }

    public void mostarConfirmacion(String header, String descripcion) {
        mensaje = new Mensaje();
        mensaje.setHeader(header);
        mensaje.setDescripcion(descripcion);
        PrimeFaces.current().executeScript("PF('confirmDialogwidget').show();");
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    public List<Persona> getListPersona() {
        return listPersona;
    }

    public void setListPersona(List<Persona> listPersona) {
        this.listPersona = listPersona;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public Persona getPersonaSearch() {
        return personaSearch;
    }

    public void setPersonaSearch(Persona personaSearch) {
        this.personaSearch = personaSearch;
    }

    public List<Medico> getListMedico() {
        return listMedico;
    }

    public void setListMedico(List<Medico> listMedico) {
        this.listMedico = listMedico;
    }

    public List<Especialidad> getListEspecialidad() {
        return listEspecialidad;
    }

    public void setListEspecialidad(List<Especialidad> listEspecialidad) {
        this.listEspecialidad = listEspecialidad;
    }

    public Medico getMedicoSelected() {
        return medicoSelected;
    }

    public void setMedicoSelected(Medico medicoSelected) {
        this.medicoSelected = medicoSelected;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public Especialidad getEspecialidadSelected() {
        return especialidadSelected;
    }

    public void setEspecialidadSelected(Especialidad especialidadSelected) {
        this.especialidadSelected = especialidadSelected;
    }

    public Date getHoraCit() {
        return horaCit;
    }

    public void setHoraCit(Date horaCit) {
        this.horaCit = horaCit;
    }

    public List<Cita> getListCita() {
        return listCita;
    }

    public void setListCita(List<Cita> listCita) {
        this.listCita = listCita;
    }

    public Cita getCitaSearch() {
        return citaSearch;
    }

    public void setCitaSearch(Cita citaSearch) {
        this.citaSearch = citaSearch;
    }

}
