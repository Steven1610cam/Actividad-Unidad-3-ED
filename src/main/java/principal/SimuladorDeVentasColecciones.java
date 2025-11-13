package principal;

import java.util.*;
import modelos.Venta;

/**
 *
 * @author STEVEN AF
 */
//Simulador de ventas usando colecciones modernas de Java.
public class SimuladorDeVentasColecciones {

    public static void main(String[] args) {

        System.out.println("\n--- Simulador de Ventas con Colecciones Modernas ---");

        //Lista de productos y precios.
        String[] productos = {"Bollo", "Suero", "Queso", "Yuca", "Chicha"};
        double[] precios = {1000, 2500, 25000, 2500, 1500};

        //Colecciones principales.
        List<Venta> ventas = new ArrayList<>();        
        Set<String> productosVendidos = new HashSet<>(); 
        Map<String, Integer> resumenVentas = new HashMap<>(); 

        //Simular 10 ventas
        for (int i = 1; i <= 10; i++) {
            int idx = (int) (Math.random() * productos.length);
            int cantidad = 1 + (int) (Math.random() * 5);
            Venta v = new Venta(i, productos[idx], cantidad, precios[idx]);
            ventas.add(v);
            productosVendidos.add(v.getProducto());

            resumenVentas.put(v.getProducto(),
                    resumenVentas.getOrDefault(v.getProducto(), 0) + v.getCantidad());
        }

        //Mostrar todas las ventas.
        System.out.println("\n--- Ventas registradas (ArrayList) ---");
        ventas.forEach(System.out::println);

        //Mostrar productos únicos vendidos.
        System.out.println("\n--- Productos únicos vendidos (HashSet) ---");
        productosVendidos.forEach(System.out::println);

        //Mostrar resumen de ventas.
        System.out.println("\n--- Cantidades totales por producto (HashMap) ---");
        resumenVentas.forEach((prod, cant) ->
                System.out.println(prod + ": " + cant + " unidades"));
    }
}

