import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VendedorDAO implements CRUD_DAO{
	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	Vendedor vendedor = new Vendedor();
	Conexion conn = new Conexion();
	
	Connection acceso;
	
	public Vendedor ValidarVendedor(String dni, String user) {
		String sql = "SELECT * FROM Vendedor WHERE Dni=? and User=?";
		try {
			acceso=conn.conectar();
			ps=acceso.prepareStatement(sql);
			ps.setString(1, dni);
			ps.setString(2, user);
			rs=ps.executeQuery();
			while (rs.next()) {
				vendedor.setId(rs.getInt(1));
				vendedor.setDni(rs.getString(2));
				vendedor.setNombre(rs.getString(3));
				vendedor.setTelefono(rs.getString(4));
				vendedor.setEstado(rs.getString(5));
				vendedor.setUser(rs.getString(6));
				}
		}catch (Exception e) {
		}
		return vendedor;
	}

	@Override
	public List listar() {
		List<Vendedor> lista = new ArrayList<>();
		String sql = "SELECT * FROM vendedor";
		try {
			con = conn.conectar();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				Vendedor vendedor = new Vendedor();
				vendedor.setId(rs.getInt(1));
				vendedor.setDni(rs.getString(2));
				vendedor.setNombre(rs.getString(3));
				vendedor.setTelefono(rs.getString(4));
				vendedor.setEstado(rs.getString(5));
				vendedor.setUser(rs.getString(6));
				lista.add(vendedor);
			}
		}catch (Exception e) {
		}
		return lista;
	}

	@Override
	public int add(Object[] o) {
		int respuesta = 0;
		String sql = "INSERT INTO vendedor (IdVendedor, Dni, Nombre, Telefono, Estado, User) VALUES (?,?,?,?,?,?)";
		try {
			con = conn.conectar();
			ps = con.prepareStatement(sql);
			ps.setObject(1, o[0]);
			ps.setObject(2, o[1]);
			ps.setObject(3, o[2]);
			ps.setObject(4, o[3]);
			ps.setObject(5, o[4]);
			ps.setObject(6, o[5]);
			respuesta = ps.executeUpdate();
		}catch (Exception e) {
		}
		return respuesta;
	}

	@Override
	public int actualizar(Object[] o) {
		int respuesta = 0;
		String sql = "UPDATE Vendedor SET Dni=?,Nombre=?,Telefono=?,Estado=?,User=? WHERE IdVendedor=?";
		try {
			con = conn.conectar();
			ps = con.prepareStatement(sql);
			ps.setObject(1, o[0]);
			ps.setObject(2, o[1]);
			ps.setObject(3, o[2]);
			ps.setObject(4, o[3]);
			ps.setObject(5, o[4]);
			ps.setObject(6, o[5]);
			respuesta = ps.executeUpdate();
		}catch(Exception e) {
		}
		return respuesta;
	}

	@Override
	public void eliminar(int id) {
		String sql = "DELETE FROM vendedor WHERE IdVendedor = ?";
		try {
			con = conn.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(Exception e) {
			
		}
		
	}
}
