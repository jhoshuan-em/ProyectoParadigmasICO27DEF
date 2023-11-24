import java.util.List;

public interface VendedoresDAO {
    void crearVendedores(Vendedores Vendedores);
    Vendedores obtenerVendedoresPorId(int id);
    List<Vendedores> obtenerTodosLosVendedores();
    void actualizarVendedores(Vendedores Vendedores);
    void eliminarVendedores(int id);
}

