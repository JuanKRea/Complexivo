
package com.educacion.hospital.view;

import com.educacion.hospital.dto.Mensaje;
import com.educacion.hospital.dao.RolDao;
import com.educacion.hospital.model.Rol;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;


@ManagedBean
@ViewScoped
public class RolView implements Serializable {

    private static final long serialVersionUID = 5443351151396868724L;
    //@EJB
    private RolDao rolDao;
    private Rol rol;
    private Rol rolSearch;
    private Mensaje mensaje;
    private List<Rol> listRol;
    private boolean found;

    public RolView() {
        rol = new Rol();
        rolSearch = new Rol();
        listRol = new ArrayList<>();
        rolDao = new RolDao();
    }

    public void crearRol() {
        try {
            rolDao.crear(rol);
            rol = new Rol();
            mostarConfirmacion("Rol", "Rol creado correctamente");
        } catch (Exception ex) {
            mostarConfirmacion("Rol", "No se creó el registro " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
    }

    public void consultarRol() {
        try {
            this.rol = rolDao.obtener(rolSearch.getIdRol());
            if (null == this.rol) {
                this.rol = new Rol();
                this.rolSearch = new Rol();
                this.found = false;
                mostarConfirmacion("Rol", "No existe el identificador ingresado");
            } else {
                this.found = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void consultarAllRol() {
        try {
            this.listRol = rolDao.obtenerAllRoles();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void modificarRol() {
        try {
            rolDao.actualiza(rol);
            this.rol = new Rol();
            this.rolSearch = new Rol();
            this.found = false;
            mostarConfirmacion("Rol", "Registro modificado correctamente");
        } catch (Exception ex) {
            mostarConfirmacion("Rol", "No se modificó el registro " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
    }

    public void eliminarRol() {
        try {
            if (null != this.rol) {
                rolDao = new RolDao();
                rolDao.eliminar(rol);
                this.rol = new Rol();
                this.rolSearch = new Rol();
                this.found = false;
                mostarConfirmacion("Rol", "Registro eliminado correctamente");
            } else {
                mostarConfirmacion("Rol", "Debe buscar el registro para eliminar");
            }
        } catch (Exception ex) {
            mostarConfirmacion("Rol", "No se eliminó el registro " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
    }

    public void mostarConfirmacion(String header, String descripcion) {
        mensaje = new Mensaje();
        mensaje.setHeader(header);
        mensaje.setDescripcion(descripcion);
        PrimeFaces.current().executeScript("PF('confirmDialogwidget').show();");
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Rol getRolSearch() {
        return rolSearch;
    }

    public void setRolSearch(Rol rolSearch) {
        this.rolSearch = rolSearch;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    public List<Rol> getListRol() {
        return listRol;
    }

    public void setListRol(List<Rol> listRol) {
        this.listRol = listRol;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

}
