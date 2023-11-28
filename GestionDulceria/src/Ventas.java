
public class Ventas {
	int id;
	int idCliente;
	int idVendedor;
	String Serie;
	String Fecha;
	double Monnto;
	String estado;
	
	public Ventas() {
		
	}

	public Ventas(int id, int idCliente, int idVendedor, String serie, String fecha, double monnto, String estado) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.idVendedor = idVendedor;
		Serie = serie;
		Fecha = fecha;
		Monnto = monnto;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getSerie() {
		return Serie;
	}

	public void setSerie(String serie) {
		Serie = serie;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public double getMonnto() {
		return Monnto;
	}

	public void setMonnto(double monnto) {
		Monnto = monnto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
