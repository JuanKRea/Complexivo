package com.educacion.hospital.dao;

import com.educacion.hospital.exception.TransaccionExcepcion;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class GenericoDao<T, PK extends Serializable> {

    //@PersistenceContext(unitName = "hospital")
    protected EntityManager em;

    private Class<T> type;

    /**
     * Contructor por defecto
     */
    @SuppressWarnings("unchecked")
    public GenericoDao() {
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.type = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospital");
        this.em = emf.createEntityManager();
    }

    
    public T crear(T o) throws TransaccionExcepcion {
        try {
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
            return o;
        } catch (Exception e) {
            throw new TransaccionExcepcion(e);
        }

    }

    
    public void crear(List<T> o) throws TransaccionExcepcion {
        try {
            for (T objeto : o) {
                em.getTransaction().begin();
                em.persist(o);
                em.getTransaction().commit();
            }

        } catch (EntityExistsException e) {
            throw new TransaccionExcepcion("1001DPLCD");
        } catch (Exception e) {
            throw new TransaccionExcepcion(e);
        }

    }

  
    public void actualiza(T o) throws TransaccionExcepcion {
        em.getTransaction().begin();
        em.merge(o);
        em.getTransaction().commit();
    }

  
    public void eliminar(T o) throws TransaccionExcepcion {
        em.getTransaction().begin();
        o = em.merge(o);
        em.remove(o);
        em.flush();
        em.getTransaction().commit();
    }

   
    public T obtener(PK id) throws TransaccionExcepcion {
        return (T) em.find(type, id);
    }

}
