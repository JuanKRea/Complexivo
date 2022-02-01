
package com.educacion.hospital.dao;

import com.educacion.hospital.exception.TransaccionExcepcion;
import com.educacion.hospital.model.Medicamento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author User
 */
@Stateless
public class MedicamentoDao extends GenericoDao<Medicamento, Integer> {

    public List<Medicamento> obtenerMedicamento() throws TransaccionExcepcion {
        StringBuilder sql = new StringBuilder("SELECT p FROM Medicamento p");
        Query query = this.em.createQuery(sql.toString());
        return query.getResultList();
    }

   
}
