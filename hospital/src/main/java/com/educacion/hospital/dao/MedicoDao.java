
package com.educacion.hospital.dao;

import com.educacion.hospital.exception.TransaccionExcepcion;
import com.educacion.hospital.model.Medico;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;


 
@Stateless
public class MedicoDao extends GenericoDao<Medico, String> {

    public List<Medico> obtenerAllMedicos() throws TransaccionExcepcion {
        StringBuilder sql = new StringBuilder("SELECT p FROM Medico p");
        Query query = this.em.createQuery(sql.toString());
        return query.getResultList();
    }

 public List<Medico> obtenerMedicobyEspecialidades(Integer idEspecialidad) throws TransaccionExcepcion {
        StringBuilder sql = new StringBuilder("SELECT p FROM Medico p ");
        sql.append("WHERE p.idmedico IN (SELECT m.id.idMedico FROM MedicoEspecialidad m WHERE m.id.idEspecialidad=:idEspecialidad)");
        Query query = this.em.createQuery(sql.toString());
        query.setParameter("idEspecialidad", idEspecialidad);
        return query.getResultList();
    }

}

