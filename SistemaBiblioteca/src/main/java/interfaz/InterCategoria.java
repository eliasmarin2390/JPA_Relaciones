package interfaz;
import entities.Autor;
import entities.Categoria;
import java.util.List;

public interface InterCategoria {
    Categoria guardar(Categoria categoria);
    List<Autor> listar();
}
