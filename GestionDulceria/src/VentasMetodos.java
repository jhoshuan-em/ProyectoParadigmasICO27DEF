
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VentasMetodos {
	Conexion cn=new Conexion();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int respuesta;
	
	public String idVentas() {
		String IdVen="";
		String sql="SELECT MAX(IdVenta) FROM ventas";
		try {
			con=cn.conectar();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				IdVen=rs.getString(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return IdVen;
	}
	public int GuardarVentas(Ventas v) {
		Ventas venta = new Ventas();
		String sql="INSERT INTO ventas(Cliente_IdCliente, Vendedor_IdVendedor, NumeroSerie, FechaVenta, Monto, Estado)VALUES(?,?,?,?,?,?)";
		try {
			con=cn.conectar();
			ps=con.prepareStatement(sql);
			ps.setInt(1, v.getIdCliente());
			ps.setInt(2, v.getIdVendedor());
			ps.setString(3, v.getSerie());
			ps.setString(4, v.getFecha());
			ps.setDouble(5, v.getMonnto());
			ps.setString(6, v.getEstado());
			respuesta=ps.executeUpdate();
		}catch (Exception e) {
		}
		return respuesta;
	}
	public int GuardarDetlleVentas(DetalleVentas dV) {
		String sql="INSERT INTO detalle_ventas(Ventas_IdVenta, Producto_IdProducto, Cantidad, PrecioVenta) VALUES (?,?,?,?)";
		try {
			con=cn.conectar();
			ps=con.prepareStatement(sql);
			ps.setInt(1, dV.getIdVentas());
			ps.setInt(2, dV.getIdProducto());
			ps.setInt(3, dV.getCantidad());
			ps.setDouble(4, dV.getPrecioVenta());
			ps.executeUpdate();
		}catch(Exception e) {
		}
		return respuesta;
	}
	public String NoSerie() {
		String serie="0";
		String sql="SELECT max(NumeroSerie) FROM ventas";
		try {
			con=cn.conectar();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				serie=rs.getString(1);
			}
		}catch(Exception e) {
		}
		return serie;
	}
}
