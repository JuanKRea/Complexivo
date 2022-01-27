
package com.educacion.hospital.dao;

import com.educacion.hospital.exception.TransaccionExcepcion;
import com.educacion.hospital.model.Ciudad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class CiudadDao extends GenericoDao<Ciudad, Integer> {

    public List<Ciudad> obtenerAllCiudad() throws TransaccionExcepcion {
        StringBuilder sql = new StringBuilder("SELECT r FROM Ciudad r");
        Query query = this.em.createQuery(sql.toString());
        return query.getResultList();
    }
}
