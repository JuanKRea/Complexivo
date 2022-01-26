
package com.educacion.hospital.dao;

import com.educacion.hospital.exception.TransaccionExcepcion;
import com.educacion.hospital.model.Rol;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class RolDao extends GenericoDao<Rol, Integer> {

    public List<Rol> obtenerAllRoles() throws TransaccionExcepcion {
        StringBuilder sql = new StringBuilder("SELECT r FROM Rol r");
        Query query = this.em.createQuery(sql.toString());
        return query.getResultList();
    }
}
