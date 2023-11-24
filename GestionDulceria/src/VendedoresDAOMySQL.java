import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendedoresDAOMySQL implements VendedoresDAO {
    private final String url = "jdbc:mariadb://localhost:3306/Ventas";
    private final String user = "root";
    private final String password = "";

    @Override
    public void crearVendedores(Vendedores Vendedores) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO Vendedores (EmpleadoID , Nombre , Puesto , Salario ) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, Vendedores.getVendedorID());
            pstmt.setString(2, Vendedores.getNombre());
            pstmt.setString(3, Vendedores.getPuesto());
            pstmt.setDouble(4, Vendedores.getSalario());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Vendedores obtenerVendedoresPorId(int id) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM Vendedores WHERE EmpleadoID = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Vendedores(rs.getInt("EmpleadoID"), rs.getString("Nombre"), rs.getString("Puesto"), rs.getDouble("Salario"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Vendedores> obtenerTodosLosVendedores() {
        List<Vendedores> Vendedores = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM Vendedores";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Vendedores.add(new Vendedores(rs.getInt("EmpleadoID"), rs.getString("Nombre"), rs.getString("Puesto"), rs.getDouble("Salario")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Vendedores;
    }

    @Override
    public void actualizarVendedores(Vendedores Vendedores) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE Vendedores SET Nombre = ?, Puesto = ?, Salario = ? WHERE EmpleadoID = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, Vendedores.getVendedorID());
            pstmt.setString(2, Vendedores.getNombre());
            pstmt.setString(3, Vendedores.getPuesto());
            pstmt.setDouble(4, Vendedores.getSalario());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarVendedores(int id) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM Vendedores WHERE EmpleadoID = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
