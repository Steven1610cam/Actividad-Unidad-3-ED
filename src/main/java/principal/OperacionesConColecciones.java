package principal;

import modelos.Venta;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author STEVEN AF
 */
//Operaciones avanzadas con colecciones usando Streams.
public class OperacionesConColecciones {

    public static void main(String[] args) {

        System.out.println("\n--- Operaciones avanzadas con colecciones ---");

        //Lista de productos y precios.
        String[] productos = {"Bollo", "Suero", "Queso", "Yuca", "Chicha"};
        double[] precios = {1000, 2500, 25000, 2500, 1500};

        //Generar ventas aleatorias.
        List<Venta> ventas = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            int idx = (int) (Math.random() * productos.length);
            int cantidad = 1 + (int) (Math.random() * 5);
            ventas.add(new Venta(i, productos[idx], cantidad, precios[idx]));
        }

        System.out.println("\n--- Ventas registradas ---");
        ventas.forEach(System.out::println);

        //1️⃣ MAP → transformar las ventas en nombres de producto.
        List<String> nombresProductos = ventas.stream()
                .map(Venta::getProducto)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("\nProductos distintos vendidos:");
        nombresProductos.forEach(System.out::println);

        //2️⃣ FILTER → ventas cuyo total supera $10.000.
        List<Venta> ventasAltas = ventas.stream()
                .filter(v -> v.getTotal() > 10000)
                .collect(Collectors.toList());

        System.out.println("\nVentas mayores a $10.000:");
        ventasAltas.forEach(System.out::println);

        //3️⃣ SORTED → ordenar ventas por total descendente.
        List<Venta> ventasOrdenadas = ventas.stream()
                .sorted((a, b) -> Double.compare(b.getTotal(), a.getTotal()))
                .collect(Collectors.toList());

        System.out.println("\nVentas ordenadas por total descendente:");
        ventasOrdenadas.forEach(System.out::println);

        //4️⃣ GROUPING → agrupar por producto y sumar cantidad total.
        Map<String, Integer> resumen = ventas.stream()
                .collect(Collectors.groupingBy(
                        Venta::getProducto,
                        Collectors.summingInt(Venta::getCantidad)
                ));

        System.out.println("\nCantidad total vendida por producto:");
        resumen.forEach((prod, cant) ->
                System.out.println(prod + ": " + cant + " unidades"));
    }
}

