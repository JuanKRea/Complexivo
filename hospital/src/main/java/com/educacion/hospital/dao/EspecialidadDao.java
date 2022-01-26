
package com.educacion.hospital.dao;

import com.educacion.hospital.exception.TransaccionExcepcion;
import com.educacion.hospital.model.Especialidad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author User
 */
@Stateless
public class EspecialidadDao extends GenericoDao<Especialidad, Integer> {

    public List<Especialidad> obtenerEspecialidades() throws TransaccionExcepcion {
        StringBuilder sql = new StringBuilder("SELECT p FROM Especialidad p");
        Query query = this.em.createQuery(sql.toString());
        return query.getResultList();
    }

    public List<Especialidad> obtenerEspecialidadesPendientesbyMedico(String idMedico) throws TransaccionExcepcion {
        StringBuilder sql = new StringBuilder("SELECT p FROM Especialidad p ");
        sql.append("WHERE p.idesp NOT IN (SELECT m.id.idEspecialidad FROM MedicoEspecialidad m WHERE m.id.idMedico=:idMedico)");
        Query query = this.em.createQuery(sql.toString());
        query.setParameter("idMedico", idMedico);
        return query.getResultList();
    }

    public List<Especialidad> obtenerEspecialidadesbyMedico(String idMedico) throws TransaccionExcepcion {
        StringBuilder sql = new StringBuilder("SELECT p FROM Especialidad p ");
        sql.append("WHERE p.idesp IN (SELECT m.id.idEspecialidad FROM MedicoEspecialidad m WHERE m.id.idMedico=:idMedico)");
        Query query = this.em.createQuery(sql.toString());
        query.setParameter("idMedico", idMedico);
        return query.getResultList();
    }
}
