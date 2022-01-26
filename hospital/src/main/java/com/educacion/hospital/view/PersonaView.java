
package com.educacion.hospital.view;

import com.educacion.hospital.dto.Mensaje;
import com.educacion.hospital.dao.PersonaDao;
import com.educacion.hospital.model.Persona;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;


@ManagedBean
@ViewScoped
public class PersonaView implements Serializable {

    private static final long serialVersionUID = 5443351151396868724L;
    //@EJB
    private PersonaDao personaDao;
    private Persona persona;
    private Persona personaSearch;
    private Mensaje mensaje;
    private List<Persona> listPersona;
    private boolean found;

    public PersonaView() {
        persona = new Persona();
        personaSearch = new Persona();
        listPersona = new ArrayList<>();
        personaDao = new PersonaDao();
    }

    public void crear() {
        try {
            personaDao.crear(persona);
            persona = new Persona();
            mostarConfirmacion("Persona", "Registro creado correctamente");
        } catch (Exception ex) {
            mostarConfirmacion("Persona", "No se creó el registro " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
    }

    public void consultarPersona() {
        try {
            this.persona = personaDao.obtener(personaSearch.getCedula());
            if (null == this.persona) {
                this.persona = new Persona();
                this.personaSearch = new Persona();
                this.found = false;
                mostarConfirmacion("Persona", "No existe la cedula ingresada");
            } else {
                this.found = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void consultarAllPersona() {
        try {
            this.listPersona = personaDao.obtenerAllPersonas();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void modificarPersona() {
        try {
            personaDao.actualiza(persona);
            this.persona = new Persona();
            this.personaSearch = new Persona();
            this.found = false;
            mostarConfirmacion("Persona", "Registro modificado correctamente");
        } catch (Exception ex) {
            mostarConfirmacion("Persona", "No se modificó el registro " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
    }

    public void eliminarPersona() {
        try {
            if (null != persona || persona.getCedula().equals("")) {
                personaDao = new PersonaDao();
                personaDao.eliminar(persona);
                this.persona = new Persona();
                this.personaSearch = new Persona();
                this.found = false;
                mostarConfirmacion("Persona", "Registro eliminado correctamente");
            } else {
                mostarConfirmacion("Persona", "Debe buscar el registro para eliminar");
            }
        } catch (Exception ex) {
            mostarConfirmacion("Persona", "No se eliminó el registro " + ex.getCause().getMessage());
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

}
