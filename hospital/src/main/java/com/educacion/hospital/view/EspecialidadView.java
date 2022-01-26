
package com.educacion.hospital.view;

import com.educacion.hospital.dto.Mensaje;
import com.educacion.hospital.dao.EspecialidadDao;
import com.educacion.hospital.model.Especialidad;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;


@ManagedBean
@ViewScoped
public class EspecialidadView implements Serializable {

    private static final long serialVersionUID = 5443351151396868724L;
    //@EJB
    private EspecialidadDao especialidadDao;
    private Especialidad especialidad;
    private Mensaje mensaje;
    private List<Especialidad> listEspecialidad;
    private boolean found;
    private Especialidad especialidadSearch;

    public EspecialidadView() {
        especialidad = new Especialidad();
        especialidadSearch = new Especialidad();
        listEspecialidad = new ArrayList<>();
        especialidadDao = new EspecialidadDao();
    }

    public void crear() {
        try {
            especialidadDao.crear(especialidad);
            especialidad = new Especialidad();
            mostarConfirmacion("Especialidad", "Registro creado correctamente");
        } catch (Exception ex) {
            mostarConfirmacion("Especialidad", "No se creó el registro " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
    }

    public void consultarEspecialidad() {
        try {
            this.especialidad = especialidadDao.obtener(especialidadSearch.getIdesp());
            if (null == this.especialidad) {
                this.especialidad = new Especialidad();
                this.especialidadSearch = new Especialidad();
                this.found = false;
                mostarConfirmacion("Especialidad", "No existe código ingresado");
            } else {
                this.found = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void consultarAllEspecialidad() {
        try {
            this.listEspecialidad = especialidadDao.obtenerEspecialidades();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void modificarEspecialidad() {
        try {
            especialidadDao.actualiza(especialidad);
            this.especialidad = new Especialidad();
            this.especialidadSearch = new Especialidad();
            this.found = false;
            mostarConfirmacion("Especialidad", "Registro modificado correctamente");
        } catch (Exception ex) {
            mostarConfirmacion("Especialidad", "No se modificó el registro " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
    }

    public void eliminarEspecialidad() {
        try {
            if (null != especialidad) {
                especialidadDao = new EspecialidadDao();
                especialidadDao.eliminar(especialidad);
                this.especialidad = new Especialidad();
                this.especialidadSearch = new Especialidad();
                this.found = false;
                mostarConfirmacion("Especialidad", "Registro eliminado correctamente");
            } else {
                mostarConfirmacion("Especialidad", "Debe buscar el registro para eliminar");
            }
        } catch (Exception ex) {
            mostarConfirmacion("Especialidad", "No se eliminó el registro " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
    }

    public void mostarConfirmacion(String header, String descripcion) {
        mensaje = new Mensaje();
        mensaje.setHeader(header);
        mensaje.setDescripcion(descripcion);
        PrimeFaces.current().executeScript("PF('confirmDialogwidget').show();");
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad Especialidad) {
        this.especialidad = Especialidad;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    public List<Especialidad> getListEspecialidad() {
        return listEspecialidad;
    }

    public void setListEspecialidad(List<Especialidad> listEspecialidad) {
        this.listEspecialidad = listEspecialidad;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public Especialidad getEspecialidadSearch() {
        return especialidadSearch;
    }

    public void setEspecialidadSearch(Especialidad especialidadSearch) {
        this.especialidadSearch = especialidadSearch;
    }

}
