
package com.educacion.hospital.dao;

import com.educacion.hospital.exception.TransaccionExcepcion;
import com.educacion.hospital.model.Examen;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class ExamenDao extends GenericoDao<Examen, Integer> {

    public List<Examen> obtenerExamen() throws TransaccionExcepcion {
        StringBuilder sql = new StringBuilder("SELECT p FROM Examen p");
        Query query = this.em.createQuery(sql.toString());
        return query.getResultList();
    }

   
}
