
public class Cliente {
	int id;
	String dni;
	String nombre;
	String direccion;
	String metodoPago;
	
	public Cliente () {
		
	}

	public Cliente(int id, String dni, String nombre, String direccion, String metodoPago) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.metodoPago = metodoPago;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	
}
