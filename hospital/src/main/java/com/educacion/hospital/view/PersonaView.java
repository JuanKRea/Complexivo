
package com.educacion.hospital.view;

import com.educacion.hospital.dto.Mensaje;
import com.educacion.hospital.dao.PersonaDao;
import com.educacion.hospital.model.Persona;
import com.educacion.hospital.dao.GeneroDao;
import com.educacion.hospital.model.Genero;
import com.educacion.hospital.dao.CiudadDao;
import com.educacion.hospital.model.Ciudad;
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
    private Genero generoSelected;
    private List<Genero> listGenero;
    private Ciudad ciudadSelected;
    private List<Ciudad> listCiudad;
    private CiudadDao ciudadDao;
    private GeneroDao generoDao;

    public PersonaView() {
        persona = new Persona();
        personaSearch = new Persona();
        listPersona = new ArrayList<>();
        personaDao = new PersonaDao();
        listGenero = new ArrayList<>();
        generoDao = new GeneroDao();
        generoSelected = new Genero();
        listCiudad = new ArrayList<>();
        ciudadDao = new CiudadDao();
        ciudadSelected = new Ciudad();
        this.consultarAllGenero();
        this.consultarAllCiudad();
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

    public void consultarAllGenero() {
        try {
            this.listGenero= generoDao.obtenerAllGenero();
            if (null != this.listGenero) {
                this.generoSelected = this.listGenero.get(0);
                            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void consultarAllCiudad() {
        try {
            this.listCiudad= ciudadDao.obtenerAllCiudad();
            if (null != this.listCiudad) {
                this.ciudadSelected = this.listCiudad.get(0);
                            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void crearPersona() {
        try {
            this.persona.setGenero(this.generoSelected);
               this.persona.setCiudad(this.ciudadSelected);
            
            personaDao.crear(this.persona);
            this.persona = new Persona();
            
             mostarConfirmacion("Persona", "Registro creado correctamente");
        } catch (Exception ex) {
            mostarConfirmacion("Persona", "No se creó el registro " + ex.getCause().getMessage());
            ex.printStackTrace();
        }
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

    public PersonaDao getPersonaDao() {
        return personaDao;
    }

    public void setPersonaDao(PersonaDao personaDao) {
        this.personaDao = personaDao;
    }

    public Genero getGeneroSelected() {
        return generoSelected;
    }

    public void setGeneroSelected(Genero generoSelected) {
        this.generoSelected = generoSelected;
    }

    public List<Genero> getListGenero() {
        return listGenero;
    }

    public void setListGenero(List<Genero> listGenero) {
        this.listGenero = listGenero;
    }

    public Ciudad getCiudadSelected() {
        return ciudadSelected;
    }

    public void setCiudadSelected(Ciudad ciudadSelected) {
        this.ciudadSelected = ciudadSelected;
    }

    public List<Ciudad> getListCiudad() {
        return listCiudad;
    }

    public void setListCiudad(List<Ciudad> listCiudad) {
        this.listCiudad = listCiudad;
    }

    public CiudadDao getCiudadDao() {
        return ciudadDao;
    }

    public void setCiudadDao(CiudadDao ciudadDao) {
        this.ciudadDao = ciudadDao;
    }

    public GeneroDao getGeneroDao() {
        return generoDao;
    }

    public void setGeneroDao(GeneroDao generoDao) {
        this.generoDao = generoDao;
    }

}
