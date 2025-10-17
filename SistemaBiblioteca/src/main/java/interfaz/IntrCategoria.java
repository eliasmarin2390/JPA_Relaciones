package interfaz;
import entities.Categoria;
import java.util.List;

public interface IntrCategoria {
    Categoria guardar(Categoria categoria);
    List<Categoria> listar();
}
