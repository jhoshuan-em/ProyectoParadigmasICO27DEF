import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO implements CRUD {
	Connection con;
	Conexion cn = new Conexion();
	PreparedStatement ps;
	ResultSet rs;
	int respuesta;

	public Producto listarID(int id) {
		Producto producto = new Producto();
		String sql = "SELECT * FROM producto WHERE IdProducto=?";
		try {
			con = cn.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				producto.setId(rs.getInt(1));
				producto.setNombre(rs.getString(2));
				producto.setPrecio(rs.getDouble(3));
				producto.setStock(rs.getInt(4));
				producto.setEstado(rs.getString(5));
			}
		} catch (Exception e) {
		}
		return producto;
	}

	@Override
	public List listar() {
		List<Producto> lista = new ArrayList<>();
		String sql = "SELECT * FROM producto";
		try {
			con = cn.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Producto producto = new Producto();
				producto.setId(rs.getInt(1));
				producto.setNombre(rs.getString(2));
				producto.setPrecio(rs.getInt(3));
				producto.setStock(rs.getInt(4));
				producto.setEstado(rs.getString(5));
				lista.add(producto);
			}
		} catch (Exception e) {
		}
		return lista;
	}

	@Override
	public int add(Object[] o) {
		int respuesta = 0;
		String sql = "INSERT INTO producto (IdProducto, Nombre, Precio, Stock, Estado) VALUES (?,?,?,?,?)";
		try {
			con = cn.conectar();
			ps = con.prepareStatement(sql);
			ps.setObject(1, o[0]);
			ps.setObject(2, o[1]);
			ps.setObject(3, o[2]);
			ps.setObject(4, o[3]);
			ps.setObject(5, o[4]);
			respuesta = ps.executeUpdate();
		} catch (Exception e) {
		}
		return respuesta;
	}

	@Override
	public int actualizar(Object[] o) {
		int respuesta = 0;
		String sql = "UPDATE Producto SET Nombre=?,Precio=?,Stock=?,Estado=? WHERE IdProducto=?";
		try {
			con = cn.conectar();
			ps = con.prepareStatement(sql);
			ps.setObject(1, o[0]);
			ps.setObject(2, o[1]);
			ps.setObject(3, o[2]);
			ps.setObject(4, o[3]);
			ps.setObject(5, o[4]);
			respuesta = ps.executeUpdate();
		} catch (Exception e) {
		}
		return respuesta;
	}

	@Override
	public void eliminar(int id) {
		String sql = "DELETE FROM producto WHERE IdProducto = ?";
		try {
			con = cn.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {

		}

	}

	public int actualizarStock(int cantidad, int idProducto) {
		String sql = "UPDATE producto set Stock=? WHERE idProducto=?";
		try {
			con = cn.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, cantidad);
			ps.setInt(2, idProducto);
			ps.executeUpdate();
		} catch (Exception e) {

		}
		return respuesta;
	}

}