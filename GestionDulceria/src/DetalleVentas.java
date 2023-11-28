import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DetalleVentas {

	Connection con;
	Conexion cn = new Conexion();
	PreparedStatement ps;
	ResultSet rs;
	int respuesta;

	int id;
	int idVentas;
	int idProducto;
	int cantidad;
	double precioVenta;

	public DetalleVentas() {

	}

	public DetalleVentas(int id, int idVentas, int idProducto, int cantidad, double precioVenta) {
		super();
		this.id = id;
		this.idVentas = idVentas;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precioVenta = precioVenta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdVentas() {
		return idVentas;
	}

	public void setIdVentas(int idVentas) {
		this.idVentas = idVentas;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public List listar() {
		List<DetalleVentas> lista = new ArrayList<>();
		String sql = "SELECT * FROM detalle_ventas";
		try {
			con = cn.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				DetalleVentas dVentas = new DetalleVentas();
				dVentas.setId(rs.getInt(1));
				dVentas.setIdVentas(rs.getInt(2));
				dVentas.setIdProducto(rs.getInt(3));
				dVentas.setCantidad(rs.getInt(4));
				dVentas.setPrecioVenta(rs.getDouble(5));
				lista.add(dVentas);
			}
		} catch (Exception e) {
		}
		return lista;
	}
}
