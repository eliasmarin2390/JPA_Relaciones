package interfaz;
import entities.Libro;
import java.util.List;

public interface InterLibro {
    Libro guardar(Libro libro);
    List<Libro> listar();
}
