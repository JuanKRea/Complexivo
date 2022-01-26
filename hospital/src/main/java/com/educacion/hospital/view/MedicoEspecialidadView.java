
package com.educacion.hospital.view;

import com.educacion.hospital.dao.EspecialidadDao;
import com.educacion.hospital.dao.MedicoDao;
import com.educacion.hospital.dao.MedicoEspecialidadDao;
import com.educacion.hospital.dto.Mensaje;
import com.educacion.hospital.exception.TransaccionExcepcion;
import com.educacion.hospital.model.Especialidad;
import com.educacion.hospital.model.Medico;
import com.educacion.hospital.model.MedicoEspecialidad;
import com.educacion.hospital.model.MedicoEspecialidadPK;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;
import org.primefaces.model.DualListModel;


@ManagedBean
@ViewScoped
public class MedicoEspecialidadView implements Serializable {

    private static final long serialVersionUID = 5443351151396868724L;
    private DualListModel<Especialidad> especialidades;
    private EspecialidadDao especialidadDao;
    private MedicoDao medicoDao;
    private MedicoEspecialidadDao medEspeDao;

    private Medico medico;
    private Medico medicoSearch;
    private boolean found;
    private Mensaje mensaje;

    public MedicoEspecialidadView() {
        medicoDao = new MedicoDao();
        especialidadDao = new EspecialidadDao();
        medEspeDao = new MedicoEspecialidadDao();
        medico = new Medico();
        medicoSearch = new Medico();
        especialidades = new DualListModel<>();
    }

    @PostConstruct
    public void init() {

    }

    public void consultarMedico() {
        try {
            this.medico = null;
            this.medico = medicoDao.obtener(medicoSearch.getIdmedico());
            if (null == this.medico) {
                this.medico = new Medico();
                this.medicoSearch = new Medico();
                this.especialidades = new DualListModel<>();
                this.found = false;
                mostarConfirmacion("Asignación Médico - Especialidad", "No existe la identificación ingresada");
            } else {
                this.found = true;
                List<Especialidad> especialidadSource = especialidadDao.obtenerEspecialidadesPendientesbyMedico(this.medicoSearch.getIdmedico());
                List<Especialidad> especilidadTarget = this.medico.getEspecialidades();
                especialidades = new DualListModel<>();
                especialidades = new DualListModel<>(especialidadSource, especilidadTarget);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void asignarEspecilidades() {
        try {
            medEspeDao.eliminarEspecilidadesbyMedico(this.medico.getIdmedico());
            for (Especialidad e : this.especialidades.getTarget()) {
                System.out.println("" + e.getNombre());
                try {
                    MedicoEspecialidadPK medEspPK = new MedicoEspecialidadPK();
                    medEspPK.setIdEspecialidad(e.getIdesp());
                    medEspPK.setIdMedico(this.medico.getIdmedico());
                    MedicoEspecialidad medEsp = new MedicoEspecialidad();
                    medEsp.setId(medEspPK);
                    medEspeDao.crear(medEsp);
                } catch (TransaccionExcepcion ex) {
                    ex.printStackTrace();
                }
            }
            this.medico = new Medico();
            this.medicoSearch = new Medico();
            this.especialidades = new DualListModel<>();
            this.found = false;
            medicoDao = new MedicoDao();
            especialidadDao = new EspecialidadDao();
            medEspeDao = new MedicoEspecialidadDao();
            mostarConfirmacion("Asignación Médico - Especialidad", "Asignación generada correctamente");
        } catch (TransaccionExcepcion ex) {
            mostarConfirmacion("Asignación Médico - Especialidad", "No se asignó el registro " + ex.getCause().getMessage());
            ex.printStackTrace();
        }

    }

    public void mostarConfirmacion(String header, String descripcion) {
        mensaje = new Mensaje();
        mensaje.setHeader(header);
        mensaje.setDescripcion(descripcion);
        PrimeFaces.current().executeScript("PF('confirmDialogwidget').show();");
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

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    public DualListModel<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(DualListModel<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

}
