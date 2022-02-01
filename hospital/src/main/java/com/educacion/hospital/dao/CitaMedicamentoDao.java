
package com.educacion.hospital.dao;

import com.educacion.hospital.exception.TransaccionExcepcion;
import com.educacion.hospital.model.CitaMedicamento;
import com.educacion.hospital.model.CitaMedicamentoPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class CitaMedicamentoDao extends GenericoDao<CitaMedicamento, CitaMedicamentoPK> {

    public boolean eliminarMedicamentobyCita(Integer idCita) throws TransaccionExcepcion {
        StringBuilder sql = new StringBuilder("DELETE FROM CitaMedicamento m ");
        sql.append("WHERE m.id.idCita=:idCita");
        em.getTransaction().begin();
        this.em.createQuery(sql.toString())
                .setParameter("idCita", idCita)
                .executeUpdate();
        em.getTransaction().commit();
        return true;
    }
public List<CitaMedicamento> obtenerRecetabyCita(Integer idCita) throws TransaccionExcepcion {
         StringBuilder sql = new StringBuilder("SELECT m FROM CitaMedicamento m ");
        sql.append("WHERE m.id.idCita=:idCita");
         //sql.append("WHERE p.idCita IN (SELECT m.idCita FROM CitaMedicamento m WHERE m.idCita=:idCita)");
        Query query = this.em.createQuery(sql.toString());
        query.setParameter("idCita", idCita);
        return query.getResultList();
    }
}
