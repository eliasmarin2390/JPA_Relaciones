package run;

import entities.Autor;
import entities.Categoria;
import entities.Libro;
import dao.LibroDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexion");
        EntityManager em = emf.createEntityManager();

        LibroDao libroDao = new LibroDao(em);

        try {
            Autor autor = new Autor();
            autor.setNombre("Gabriel García Márquez");
            autor.setNacionalidad("Colombiana");
            autor.setFechaNac("1927-03-06");

            Categoria categoria1 = new Categoria();
            categoria1.setNombre("Realismo mágico");

            Categoria categoria2 = new Categoria();
            categoria2.setNombre("Literatura Latinoamericana");

            Libro libro = new Libro();
            libro.setTitulo("Cien años de soledad");
            libro.setAnioPublicacion(1967);
            libro.setAutor(autor);
            libro.setCategorias((java.util.Set<Categoria>) Arrays.asList(categoria1, categoria2));

            em.getTransaction().begin();
            em.persist(autor);
            em.persist(categoria1);
            em.persist(categoria2);
            em.getTransaction().commit();

            libroDao.guardar(libro);

            List<Libro> libros = libroDao.listar();
            System.out.println("\n📚 Libros guardados en la base de datos:");
            for (Libro l : libros) {
                System.out.println(l);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
