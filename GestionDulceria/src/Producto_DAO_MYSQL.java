import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Producto_DAO_MYSQL implements ProductosDAO {
    private final String url = "jdbc:mariadb://localhost:3306/Ventas";
    private final String user = "root";
    private final String password = "";

    @Override
    public void crearProducto(Productos producto) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO Productos (ProductoID, Nombre, Descripcion, Precio, Stock) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, producto.getProductoID());
            pstmt.setString(2, producto.getNombre());
            pstmt.setString(3, producto.getDescripcion());
            pstmt.setDouble(4, producto.getPrecio());
            pstmt.setInt(5, producto.getStock());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    @Override
    public Productos obtenerProductoPorId(int id) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM Productos WHERE ProductoID = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Productos(rs.getInt("ProductoID"), rs.getString("Nombre"), rs.getString("Descripcion"), rs.getDouble("Precio"), rs.getInt("Stock"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    

    @Override
    public List<Productos> obtenerTodosLosProductos() {
        List<Productos> Productos = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM Productos";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Productos.add(new Productos(rs.getInt("ProductoID"), rs.getString("Nombre"), rs.getString("Descripcion"), rs.getDouble("Precio"), rs.getInt("Stock")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Productos;
    }
    

    @Override
    public void actualizarProducto(Productos producto) {
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                String query = "UPDATE Productos SET (ProductoID, Nombre, Descripcion, Precio, Stock) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setInt(1, producto.getProductoID());
                pstmt.setString(2, producto.getNombre());
                pstmt.setString(3, producto.getDescripcion());
                pstmt.setDouble(4, producto.getPrecio());
                pstmt.setInt(5, producto.getStock());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    @Override
    public void eliminarProducto(int id) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM Productos WHERE ProductoID = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
}