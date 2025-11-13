package principal;

import modelos.Venta;
import java.util.*;

/**
 *
 * @author STEVEN AF
 */
//Ejemplo de buenas prácticas con colecciones.
public class BuenasPracticasColecciones {

    public static void main(String[] args) {

        System.out.println("\n--- Buenas prácticas con colecciones ---");

        //Lista genérica correctamente tipada.
        List<Venta> ventas = new ArrayList<>();

        ventas.add(new Venta(1, "Bollo", 2, 1000));
        ventas.add(new Venta(2, "Suero", 1, 2500));
        ventas.add(new Venta(3, "Queso", 1, 25000));

        //Uso de forEach con expresiones lambda.
        ventas.forEach(v -> System.out.println(v));

        //Creación de una lista inmutable (no puede modificarse).
        List<Venta> ventasInmutables = Collections.unmodifiableList(ventas);

        System.out.println("\nIntentando acceder a lista inmutable...");
        System.out.println("Tamaño de la lista: " + ventasInmutables.size());

        try {
            //Intentar modificar lanza excepción.
            ventasInmutables.add(new Venta(4, "Chicha", 3, 1500));
        } catch (UnsupportedOperationException e) {
            System.out.println("No se puede modificar una lista inmutable.");
        }

        //Uso de un mapa genérico correctamente tipado.
        Map<Integer, Venta> mapaVentas = new HashMap<>();
        for (Venta v : ventas) {
            mapaVentas.put(v.getId(), v);
        }

        System.out.println("\nMapa de ventas (id → venta):");
        mapaVentas.forEach((id, v) -> System.out.println(id + " → " + v));

        //Acceso seguro mediante containsKey().
        int buscarId = 2;
        if (mapaVentas.containsKey(buscarId)) {
            System.out.println("\nVenta encontrada con id " + buscarId + ": " + mapaVentas.get(buscarId));
        } else {
            System.out.println("\nNo existe una venta con id " + buscarId);
        }
    }
}