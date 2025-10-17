package dao;

import java.util.List;
import interfaz.InterAutor;
import jakarta.persistence.EntityManager;
import entities.Autor;

public class AutorDao implements InterAutor {
    private final EntityManager em;

    public AutorDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Autor guardar(Autor entities) {
        if(entities.getId()==null){
            em.getTransaction().begin();
            em.persist(entities);
            em.getTransaction().commit();
            return entities;
        }
        return em.merge(entities);
    }

    @Override
    public List<Autor> listar() {
        return em.createQuery("from Autor", Autor.class).getResultList();
    }
}