package dao;

import entities.Autor;
import entities.Categoria;
import interfaz.InterCategoria;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CategoriaDao implements InterCategoria {
    private final EntityManager em;
    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    @Override
    public Categoria guardar(Categoria entities) {
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
        return em.createQuery("from Categoria", Autor.class).getResultList();
    }
}
