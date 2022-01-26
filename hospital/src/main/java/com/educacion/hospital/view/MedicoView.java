
package com.educacion.hospital.view;

import com.educacion.hospital.dao.MedicoDao;
import com.educacion.hospital.dto.Mensaje;
import com.educacion.hospital.model.Medico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;


@ManagedBean
@ViewScoped
public class MedicoView implements Serializable {

    private static final long serialVersionUID = 5443351151396868724L;
    //@EJB
    private MedicoDao medicoDao;
    private Medico medico;
    private Medico medicoSearch;
    private Mensaje mensaje;
    private List<Medico> listMedico;
    private boolean found;

    public MedicoView() {
        medico = new Medico();
        medicoSearch = new Medico();
        listMedico = new ArrayList<>();
        medicoDao = new MedicoDao();
    }

    public void crear() {
        try {
            medicoDao.crear(medico);
            medico = new Medico();
            mostarConfirmacion("Médico", "Registro creado correctamente");
        } catch (Exception ex) {
            mostarConfirmacion("Médico", "No se creó el registro " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
    }

    public void consultarMedico() {
        try {
            this.medico = medicoDao.obtener(medicoSearch.getIdmedico());
            if (null == this.medico) {
                this.medico = new Medico();
                this.medicoSearch = new Medico();
                this.found = false;
                mostarConfirmacion("Médico", "No existe la identificación ingresada");
            } else {
                this.found = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void consultarAllMedico() {
        try {
            this.listMedico = medicoDao.obtenerAllMedicos();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void modificarMedico() {
        try {
            medicoDao.actualiza(medico);
            this.medico = new Medico();
            this.medicoSearch = new Medico();
            this.found = false;
            mostarConfirmacion("Médico", "Registro modificado correctamente");
        } catch (Exception ex) {
            mostarConfirmacion("Médico", "No se modificó el registro " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
    }

    public void eliminarMedico() {
        try {
            if (null != medico) {
                medicoDao = new MedicoDao();
                medicoDao.eliminar(medico);
                this.medico = new Medico();
                this.medicoSearch = new Medico();
                this.found = false;
                mostarConfirmacion("Médico", "Registro eliminado correctamente");
            } else {
                mostarConfirmacion("Médico", "Debe buscar el registro para eliminar");
            }
        } catch (Exception ex) {
            mostarConfirmacion("Médico", "No se eliminó el registro " + ex.getCause().getMessage());
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

    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    public List<Medico> getListMedico() {
        return listMedico;
    }

    public void setListMedico(List<Medico> listMedico) {
        this.listMedico = listMedico;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

}
