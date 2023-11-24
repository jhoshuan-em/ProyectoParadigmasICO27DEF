import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentasDAOMySQL implements VentasDAO {
    private final String url = "jdbc:mariadb://localhost:3306/Ventas";
    private final String user = "root";
    private final String password = "";

    @Override
    public void crearVentas(Ventas Ventas) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO Ventas (VentaID, ClienteID, FechaVenta, TotalVenta) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, Ventas.getVentasID());
            pstmt.setString(2, Ventas.getClienteID());
            pstmt.setString(3, Ventas.getFechaVenta());
            pstmt.setString(4, Ventas.getTotalVenta());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Ventas obtenerVentasPorId(int id) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM Ventas WHERE VentaID = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Ventas(rs.getInt("VentaID"), rs.getString("ClienteID"), rs.getString("FechaVenta"), rs.getString("TotalVenta"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Ventas> obtenerTodosLosVentas() {
        List<Ventas> Ventas = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM Ventas";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Ventas.add(new Ventas(rs.getInt("VentaID"), rs.getString("ClienteID"), rs.getString("FechaVenta"), rs.getString("TotalVenta")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Ventas;
    }

    @Override
    public void actualizarVentas(Ventas Ventas) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE Ventas SET ClienteID = ?, FechaVenta = ?, TotalVenta = ? WHERE VentaID = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, Ventas.getVentasID());
            pstmt.setString(2, Ventas.getClienteID());
            pstmt.setString(3, Ventas.getFechaVenta());
            pstmt.setString(4, Ventas.getTotalVenta());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarVentas(int id) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM Ventas WHERE VentaID = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
