
package com.educacion.hospital.view;

import com.educacion.hospital.dto.Mensaje;
import com.educacion.hospital.dao.ExamenDao;
import com.educacion.hospital.model.Examen;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;


@ManagedBean
@ViewScoped
public class ExamenView implements Serializable {

    private static final long serialVersionUID = 5443351151396868724L;
    //@EJB
    private ExamenDao examenDao;
    private Examen examen;
    private Mensaje mensaje;
    private List<Examen> listExamen;
    private boolean found;
    private Examen examenSearch;

    public ExamenView() {
        examen = new Examen();
        examenSearch = new Examen();
        listExamen = new ArrayList<>();
        examenDao = new ExamenDao();
    }

    public void crear() {
        try {
            examenDao.crear(examen);
            examen = new Examen();
            mostarConfirmacion("Examen", "Registro creado correctamente");
        } catch (Exception ex) {
            mostarConfirmacion("Examen", "No se creó el registro " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
    }

    public void consultarExamen() {
        try {
            this.examen = examenDao.obtener(examenSearch.getIdexa());
            if (null == this.examen) {
                this.examen = new Examen();
                this.examenSearch = new Examen();
                this.found = false;
                mostarConfirmacion("Examen", "No existe código ingresado");
            } else {
                this.found = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void consultarAllExamen() {
        try {
            this.listExamen = examenDao.obtenerExamen();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void modificarExamen() {
        try {
            examenDao.actualiza(examen);
            this.examen = new Examen();
            this.examenSearch = new Examen();
            this.found = false;
            mostarConfirmacion("Examen", "Registro modificado correctamente");
        } catch (Exception ex) {
            mostarConfirmacion("Examen", "No se modificó el registro " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
    }

    public void eliminarExamen() {
        try {
            if (null != examen) {
                examenDao = new ExamenDao();
                examenDao.eliminar(examen);
                this.examen = new Examen();
                this.examenSearch = new Examen();
                this.found = false;
                mostarConfirmacion("Examen", "Registro eliminado correctamente");
            } else {
                mostarConfirmacion("Examen", "Debe buscar el registro para eliminar");
            }
        } catch (Exception ex) {
            mostarConfirmacion("Examen", "No se eliminó el registro " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
    }

    public void mostarConfirmacion(String header, String descripcion) {
        mensaje = new Mensaje();
        mensaje.setHeader(header);
        mensaje.setDescripcion(descripcion);
        PrimeFaces.current().executeScript("PF('confirmDialogwidget').show();");
    }

    public ExamenDao getExamenDao() {
        return examenDao;
    }

    public void setExamenDao(ExamenDao examenDao) {
        this.examenDao = examenDao;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    public List<Examen> getListExamen() {
        return listExamen;
    }

    public void setListExamen(List<Examen> listExamen) {
        this.listExamen = listExamen;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public Examen getExamenSearch() {
        return examenSearch;
    }

    public void setExamenSearch(Examen examenSearch) {
        this.examenSearch = examenSearch;
    }

}
