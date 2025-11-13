package modelos;

/**
 *
 * @author STEVEN AF
 */
//Clase que representa una venta individual.
public class Venta {
    private int id;                 
    private String producto;        
    private int cantidad;           
    private double precioUnitario;  

    //Constructor con parámetros.
    public Venta(int id, String producto, int cantidad, double precioUnitario) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    //Calcula el total de la venta.
    public double getTotal() {
        return cantidad * precioUnitario;
    }

    //Getters y Setters.
    public int getId() { return id; }
    public String getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public double getPrecioUnitario() { return precioUnitario; }

    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    @Override
    public String toString() {
        return "Venta{id=" + id + ", producto='" + producto + "', cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario + ", total=" + getTotal() + "}";
    }
}
