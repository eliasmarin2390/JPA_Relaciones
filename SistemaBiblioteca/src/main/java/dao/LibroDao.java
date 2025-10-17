package dao;

import entities.Libro;
import interfaz.InterLibro;
import interfaz.InterLibro;
import jakarta.persistence.EntityManager;

import java.util.List;

public class LibroDao implements InterLibro {
    private final EntityManager em;

    public LibroDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Libro guardar(Libro entities) {
        if(entities.getId()==null){
            em.getTransaction().begin();
            em.persist(entities);
            em.getTransaction().commit();
            return entities;
        }
        return em.merge(entities);
    }

    @Override
    public List<Libro> listar() {
        return em.createQuery("from Libro", Libro.class).getResultList();
    }
}