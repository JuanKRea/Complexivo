
package com.educacion.hospital.dao;

import com.educacion.hospital.exception.TransaccionExcepcion;
import com.educacion.hospital.model.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;


@Stateless
public class PersonaDao extends GenericoDao<Persona, String> {

    public List<Persona> obtenerAllPersonas() throws TransaccionExcepcion {
        StringBuilder sql = new StringBuilder("SELECT p FROM Persona p");
        Query query = this.em.createQuery(sql.toString());
        return query.getResultList();
    }
}
