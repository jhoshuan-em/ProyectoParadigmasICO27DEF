import java.util.List;

public interface VendedoresDAO {
    void crearVendeores(Vendedores Vendeores);
    Vendedores obtenerVendeoresPorId(int id);
    List<Vendedores> obtenerTodosLosVendedores();
    void actualizarVendeores(Vendedores Vendeores);
    void eliminarVendeores(int id);
}

