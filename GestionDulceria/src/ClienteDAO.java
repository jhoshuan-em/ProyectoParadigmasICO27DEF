import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements CRUD_DAO {
	Connection con;
	Conexion cn = new Conexion();
	PreparedStatement ps;
	ResultSet rs;
	
	public Cliente listarID(String dni) {
		Cliente cli = new Cliente ();
		String sql = "SELECT * FROM cliente WHERE Dni=?";
		try {
			con=cn.conectar();
			ps=con.prepareStatement(sql);
			ps.setString(1, dni);
			rs=ps.executeQuery();
			while (rs.next()) {
				cli.setId(rs.getInt(1));
				cli.setDni(rs.getString(2));
				cli.setNombre(rs.getString(3));
				cli.setDireccion(rs.getString(4));
				cli.setMetodoPago(rs.getString(5));
			}
		}catch (Exception e) {
			
		}return cli;
	}
	
	@Override
	public List listar() {
		List<Cliente> lista = new ArrayList<>();
		String sql = "SELECT * FROM cliente";
		try {
			con = cn.conectar();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente ();
				cliente.setId(rs.getInt(1));
				cliente.setDni(rs.getString(2));
				cliente.setNombre(rs.getString(3));
				cliente.setDireccion(rs.getString(4));
				cliente.setMetodoPago(rs.getString(5));
				lista.add(cliente);
			}
		}catch (Exception e) {
		}
		return lista;
	}
	
	@Override
	public int add(Object[] o) {
		int respuesta = 0;
		String sql = "INSERT INTO cliente (IdCliente, Dni, Nombre, Direccion, MetodoPago) VALUES (?,?,?,?,?)";
		try {
			con = cn.conectar();
			ps = con.prepareStatement(sql);
			ps.setObject(1, o[0]);
			ps.setObject(2, o[1]);
			ps.setObject(3, o[2]);
			ps.setObject(4, o[3]);
			ps.setObject(5, o[4]);
			respuesta = ps.executeUpdate();
		}catch (Exception e) {
		}
		return respuesta;
	}
	@Override
	public int actualizar(Object[] o) {
		int respuesta = 0;
		String sql = "UPDATE Cliente SET Dni=?,Nombre=?,Direccion=?,MetodoPago=? WHERE IdCliente=?";
		try {
			con = cn.conectar();
			ps = con.prepareStatement(sql);
			ps.setObject(1, o[0]);
			ps.setObject(2, o[1]);
			ps.setObject(3, o[2]);
			ps.setObject(4, o[3]);
			ps.setObject(5, o[4]);
			respuesta = ps.executeUpdate();
		}catch(Exception e) {
		}
		return respuesta;
	}
	@Override
	public void eliminar(int id) {
		String sql = "DELETE FROM cliente WHERE IdCliente = ?";
		try {
			con = cn.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(Exception e) {
			
		}
	}
}

