
package com.educacion.hospital.dao;

import com.educacion.hospital.exception.TransaccionExcepcion;
import com.educacion.hospital.model.Genero;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class GeneroDao extends GenericoDao<Genero, Integer> {

    public List<Genero> obtenerAllGenero() throws TransaccionExcepcion {
        StringBuilder sql = new StringBuilder("SELECT r FROM Genero r");
        Query query = this.em.createQuery(sql.toString());
        return query.getResultList();
    }
}
