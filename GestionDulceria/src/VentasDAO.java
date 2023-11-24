import java.util.List;

public interface VentasDAO {
    void crearVentas(Ventas Ventas);
    Ventas obtenerVentasPorId(int id);
    List<Ventas> obtenerTodosLosVentas();
    void actualizarVentas(Ventas Ventas);
    void eliminarVentas(int id);
}

