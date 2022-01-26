
package com.educacion.hospital.dao;

import com.educacion.hospital.model.Usuario;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class LoginDao extends GenericoDao<Usuario, String> {

    public Usuario validarUsuario(String usuario, String password) {
        Usuario user = null;
        StringBuilder sql = new StringBuilder("SELECT u FROM Usuario u ");
        sql.append("WHERE u.idUsr=:idUsr AND u.pasUsr=:pasUsr");
        Query query = this.em.createQuery(sql.toString());
        query.setParameter("idUsr", usuario);
        query.setParameter("pasUsr", password);
        if (!query.getResultList().isEmpty()) {
            user = (Usuario)query.getResultList().get(0);
        }
        return user;
    }
    public int validarRol(String usuario) {
        
        int rol=5;
        StringBuilder sql = new StringBuilder("SELECT u FROM Usuario u");
        sql.append("WHERE u.idUsr=:idUsr");
        Query query = this.em.createQuery(sql.toString());
        query.setParameter("idUsr", usuario);
        
        if (!query.getResultList().isEmpty()) {
            rol = (int)query.getResultList().get(7);
            
        }
        return rol;
    }

}
