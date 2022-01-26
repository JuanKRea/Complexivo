
package com.educacion.hospital.dao;

import com.educacion.hospital.exception.TransaccionExcepcion;
import com.educacion.hospital.model.MedicoEspecialidad;
import com.educacion.hospital.model.MedicoEspecialidadPK;
import javax.ejb.Stateless;

@Stateless
public class MedicoEspecialidadDao extends GenericoDao<MedicoEspecialidad, MedicoEspecialidadPK> {

    public boolean eliminarEspecilidadesbyMedico(String idMedico) throws TransaccionExcepcion {
        StringBuilder sql = new StringBuilder("DELETE FROM MedicoEspecialidad m ");
        sql.append("WHERE m.id.idMedico=:idMedico");
        em.getTransaction().begin();
        this.em.createQuery(sql.toString())
                .setParameter("idMedico", idMedico)
                .executeUpdate();
        em.getTransaction().commit();
        return true;
    }

}
