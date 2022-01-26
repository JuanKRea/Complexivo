
package com.educacion.hospital.dao;

import com.educacion.hospital.exception.TransaccionExcepcion;
import com.educacion.hospital.model.Cita;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class CitaDao extends GenericoDao<Cita, Integer> {

    public Integer getLastIdCita() {
        Integer lastId = 0;
        StringBuilder sql = new StringBuilder("SELECT MAX(c.idCita) FROM Cita c");
        Query query = this.em.createQuery(sql.toString());
        Object result = query.getSingleResult();
        if (null != result) {
            lastId = Integer.valueOf(result.toString());
        }
        return lastId;
    }

    public List<Cita> obtenerAllCitas() throws TransaccionExcepcion {
        StringBuilder sql = new StringBuilder("SELECT c FROM Cita c");
        Query query = this.em.createQuery(sql.toString());
        return query.getResultList();
    }

    public Cita obtenerCitabyId(Integer idCita) throws TransaccionExcepcion {
        Cita cita = null;
        StringBuilder sql = new StringBuilder("SELECT c FROM Cita c ");
        sql.append("WHERE c.idCita=:idCita");
        Query query = this.em.createQuery(sql.toString());
        query.setParameter("idCita", idCita);
        if (!query.getResultList().isEmpty()) {
            cita = (Cita) query.getResultList().get(0);
        }
        return cita;
    }

    public List<Cita> obtenerCitasbyPaciente(String idPaciente) throws TransaccionExcepcion {
        StringBuilder sql = new StringBuilder("SELECT c FROM Cita c ");
        sql.append("WHERE c.persona.cedula=:idPaciente");
        Query query = this.em.createQuery(sql.toString());
        query.setParameter("idPaciente", idPaciente);
        return query.getResultList();
    }

    public List<Cita> obtenerCitasbyMedico(String idMedico) throws TransaccionExcepcion {
        StringBuilder sql = new StringBuilder("SELECT c FROM Cita c ");
        sql.append("WHERE c.medico.idmedico=:idmedico");
        Query query = this.em.createQuery(sql.toString());
        query.setParameter("idmedico", idMedico);
        return query.getResultList();
    }

}
