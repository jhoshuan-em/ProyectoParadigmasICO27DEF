import java.util.List;

public interface ProductosDAO {
    void crearProducto(Productos producto);
    Productos obtenerProductoPorId(int id);
    List<Productos> obtenerTodosLosProductos();
    void actualizarProducto(Productos producto);
    void eliminarProducto(int id);
}

