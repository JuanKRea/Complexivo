
package com.educacion.hospital.dao;

import com.educacion.hospital.exception.TransaccionExcepcion;
import com.educacion.hospital.model.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;


@Stateless
public class UsuarioDao extends GenericoDao<Usuario, String> {

    public List<Usuario> obtenerAllUsuarios() throws TransaccionExcepcion {
        StringBuilder sql = new StringBuilder("SELECT u FROM Usuario u");
        Query query = this.em.createQuery(sql.toString());
        return query.getResultList();
    }
}
