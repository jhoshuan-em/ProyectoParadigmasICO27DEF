public class Ventas {
    private int ventasID;
    private String clienteID;
    private String FechaVenta;
    private String TotalVenta;
    public Ventas(int ventasID, String clienteID, String fechaVenta, String totalVenta) {
        this.ventasID = ventasID;
        this.clienteID = clienteID;
        this.FechaVenta = fechaVenta;
        this.TotalVenta = totalVenta;
    }
    public int getVentasID() {
        return ventasID;
    }
    public void setVentasID(int ventasID) {
        this.ventasID = ventasID;
    }
    public String getClienteID() {
        return clienteID;
    }
    public void setClienteID(String clienteID) {
        this.clienteID = clienteID;
    }
    public String getFechaVenta() {
        return FechaVenta;
    }
    public void setFechaVenta(String fechaVenta) {
        FechaVenta = fechaVenta;
    }
    public String getTotalVenta() {
        return TotalVenta;
    }
    public void setTotalVenta(String totalVenta) {
        TotalVenta = totalVenta;
    }
    
    
}
