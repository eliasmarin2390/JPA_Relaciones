package interfaz;
import entities.Autor;
import java.util.List;

public interface InterAutor {
    Autor guardar(Autor autor);
    List<Autor> listar();
}
