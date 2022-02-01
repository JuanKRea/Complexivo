
package com.educacion.hospital.view;

import com.educacion.hospital.dto.Mensaje;
import com.educacion.hospital.dao.MedicamentoDao;
import com.educacion.hospital.model.Medicamento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;


@ManagedBean
@ViewScoped
public class MedicamentoView implements Serializable {

    private static final long serialVersionUID = 5443351151396868724L;
    //@EJB
    private MedicamentoDao medicamentoDao;
    private Medicamento medicamento;
    private Mensaje mensaje;
    private List<Medicamento> listMedicamento;
    private boolean found;
    private Medicamento medicamentoSearch;

    public MedicamentoView() {
        medicamento = new Medicamento();
        medicamentoSearch = new Medicamento();
        listMedicamento = new ArrayList<>();
        medicamentoDao = new MedicamentoDao();
    }

    public void crear() {
        try {
            medicamentoDao.crear(medicamento);
            medicamento = new Medicamento();
            mostarConfirmacion("Medicamento", "Registro creado correctamente");
        } catch (Exception ex) {
            mostarConfirmacion("Medicamento", "No se creó el registro " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
    }

    public void consultarMedicamento() {
        try {
            this.medicamento = medicamentoDao.obtener(medicamentoSearch.getIdmedica());
            if (null == this.medicamento) {
                this.medicamento = new Medicamento();
                this.medicamentoSearch = new Medicamento();
                this.found = false;
                mostarConfirmacion("Medicamento", "No existe código ingresado");
            } else {
                this.found = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void consultarAllMedicamento() {
        try {
            this.listMedicamento = medicamentoDao.obtenerMedicamento();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void modificarMedicamento() {
        try {
            medicamentoDao.actualiza(medicamento);
            this.medicamento = new Medicamento();
            this.medicamentoSearch = new Medicamento();
            this.found = false;
            mostarConfirmacion("Medicamento", "Registro modificado correctamente");
        } catch (Exception ex) {
            mostarConfirmacion("Medicamento", "No se modificó el registro " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
    }

    public void eliminarMedicamento() {
        try {
            if (null != medicamento) {
                medicamentoDao = new MedicamentoDao();
                medicamentoDao.eliminar(medicamento);
                this.medicamento = new Medicamento();
                this.medicamentoSearch = new Medicamento();
                this.found = false;
                mostarConfirmacion("Medicamento", "Registro eliminado correctamente");
            } else {
                mostarConfirmacion("Medicamento", "Debe buscar el registro para eliminar");
            }
        } catch (Exception ex) {
            mostarConfirmacion("Medicamento", "No se eliminó el registro " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
    }

    public void mostarConfirmacion(String header, String descripcion) {
        mensaje = new Mensaje();
        mensaje.setHeader(header);
        mensaje.setDescripcion(descripcion);
        PrimeFaces.current().executeScript("PF('confirmDialogwidget').show();");
    }

    public MedicamentoDao getMedicamentoDao() {
        return medicamentoDao;
    }

    public void setMedicamentoDao(MedicamentoDao medicamentoDao) {
        this.medicamentoDao = medicamentoDao;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    public List<Medicamento> getListMedicamento() {
        return listMedicamento;
    }

    public void setListMedicamento(List<Medicamento> listMedicamento) {
        this.listMedicamento = listMedicamento;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public Medicamento getMedicamentoSearch() {
        return medicamentoSearch;
    }

    public void setMedicamentoSearch(Medicamento medicamentoSearch) {
        this.medicamentoSearch = medicamentoSearch;
    }

}
