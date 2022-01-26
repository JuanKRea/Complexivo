
package com.educacion.hospital.view;

import com.educacion.hospital.dao.RolDao;
import com.educacion.hospital.dto.Mensaje;
import com.educacion.hospital.dao.UsuarioDao;
import com.educacion.hospital.model.Rol;
import com.educacion.hospital.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;


@ManagedBean
@ViewScoped
public class UsuarioView implements Serializable {

    private static final long serialVersionUID = 5443351151396868724L;
    //@EJB
    private UsuarioDao usuarioDao;
    private RolDao rolDao;
    private Usuario usuario;
    private Usuario usuarioSearch;
    private Mensaje mensaje;
    private List<Usuario> listUsuario;
    private List<Rol> listRol;
    private Rol rolSelected;
    private boolean found;

    public UsuarioView() {
        usuario = new Usuario();
        usuarioSearch = new Usuario();
        listUsuario = new ArrayList<>();
        usuarioDao = new UsuarioDao();
        rolDao = new RolDao();
        listRol = obtenerRoles();
    }

    public List<Rol> obtenerRoles() {
        List<Rol> rol = null;
        try {
            rol = rolDao.obtenerAllRoles();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rol;
    }

    public void crearUsuario() {
        try {
            this.usuario.setRol(this.rolSelected);
            usuarioDao.crear(this.usuario);
            this.usuario = new Usuario();
            mostarConfirmacion("Usuario", "Registro creado correctamente");
        } catch (Exception ex) {
            mostarConfirmacion("Usuario", "No se creó el registro " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
    }

    public void consultarUsuario() {
        try {
            this.usuario = usuarioDao.obtener(usuarioSearch.getIdUsr());
            if (null == this.usuario) {
                this.usuario = new Usuario();
                this.usuarioSearch = new Usuario();
                this.found = false;
                mostarConfirmacion("Usuario", "No existe el usuario ingresado");
            } else {
                this.rolSelected = this.usuario.getRol();
                System.out.println("xxxx " + this.rolSelected.getIdRol());
                this.found = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void modificarRol() {
        try {
            this.usuario.setRol(this.rolSelected);
            usuarioDao.actualiza(this.usuario);
            this.usuario = new Usuario();
            this.usuarioSearch = new Usuario();
            this.found = false;
            mostarConfirmacion("Usuario", "Registro modificado correctamente");
        } catch (Exception ex) {
            mostarConfirmacion("Usuario", "No se modificó el registro " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
    }

    public void eliminarUsuario() {
        try {
            if (null != this.usuario) {
                usuarioDao = new UsuarioDao();
                usuarioDao.eliminar(this.usuario);
                this.usuario = new Usuario();
                this.usuarioSearch = new Usuario();
                this.found = false;
                mostarConfirmacion("Usuario", "Registro eliminado correctamente");
            } else {
                mostarConfirmacion("Usuario", "Debe buscar el registro para eliminar");
            }
        } catch (Exception ex) {
            mostarConfirmacion("Usuario", "No se eliminó el registro " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
    }

    public void consultarAllUsuario() {
        try {
            this.listUsuario = usuarioDao.obtenerAllUsuarios();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void mostarConfirmacion(String header, String descripcion) {
        mensaje = new Mensaje();
        mensaje.setHeader(header);
        mensaje.setDescripcion(descripcion);
        PrimeFaces.current().executeScript("PF('confirmDialogwidget').show();");
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioSearch() {
        return usuarioSearch;
    }

    public void setUsuarioSearch(Usuario usuarioSearch) {
        this.usuarioSearch = usuarioSearch;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    public List<Usuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<Usuario> listUsuario) {
        this.listUsuario = listUsuario;
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

    public Rol getRolSelected() {
        return rolSelected;
    }

    public void setRolSelected(Rol rolSelected) {
        this.rolSelected = rolSelected;
    }

}
