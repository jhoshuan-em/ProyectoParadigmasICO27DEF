public class Productos{
    private int productoID;
    private String Nombre;
    private String Descripcion;
    private double Precio;
    private int Stock;
    public Productos(int productoID, String nombre, String descripcion, double precio, int stock) {
        this.productoID = productoID;
        this.Nombre = nombre;
        this.Descripcion = descripcion;
        this.Precio = precio;
        this.Stock = stock;
    }
    public int getProductoID() {
        return productoID;
    }
    public void setProductoID(int productoID) {
        this.productoID = productoID;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
    public double getPrecio() {
        return Precio;
    }
    public void setPrecio(double precio) {
        Precio = precio;
    }
    public int getStock() {
        return Stock;
    }
    public void setStock(int stock) {
        Stock = stock;
    }
}