public class Vendedores {
    private int VendedorID;
    private String Nombre;
    private String Puesto;
    private double Salario;
    public Vendedores(int vendedorID, String nombre, String puesto, double salario) {
        this.VendedorID = vendedorID;
        this.Nombre = nombre;
        this.Puesto = puesto;
        this.Salario = salario;
    }
    public int getVendedorID() {
        return VendedorID;
    }
    public void setVendedorID(int vendedorID) {
        VendedorID = vendedorID;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getPuesto() {
        return Puesto;
    }
    public void setPuesto(String puesto) {
        Puesto = puesto;
    }
    public double getSalario() {
        return Salario;
    }
    public void setSalario(double salario) {
        Salario = salario;
    }
    
}
