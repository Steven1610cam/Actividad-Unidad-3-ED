package principal;

import java.util.*;

/**
 *
 * @author STEVEN AF
 */
//Comparación de rendimiento entre diferentes colecciones.
public class ComparacionColecciones {

    public static void main(String[] args) {

        System.out.println("\n--- Comparación de rendimiento entre colecciones ---");

        int N = 100000; //Cantidad de elementos para la prueba.

        //ArrayList vs LinkedList
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long inicio = System.currentTimeMillis();
        for (int i = 0; i < N; i++) arrayList.add(i);
        long fin = System.currentTimeMillis();
        System.out.println("ArrayList (inserción): " + (fin - inicio) + " ms");

        inicio = System.currentTimeMillis();
        for (int i = 0; i < N; i++) linkedList.add(i);
        fin = System.currentTimeMillis();
        System.out.println("LinkedList (inserción): " + (fin - inicio) + " ms");

        //Prueba de acceso aleatorio
        Random rand = new Random();
        inicio = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) arrayList.get(rand.nextInt(N));
        fin = System.currentTimeMillis();
        System.out.println("ArrayList (acceso aleatorio): " + (fin - inicio) + " ms");

        inicio = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) linkedList.get(rand.nextInt(N));
        fin = System.currentTimeMillis();
        System.out.println("LinkedList (acceso aleatorio): " + (fin - inicio) + " ms");

        System.out.println("\n---------------------------------------------");

        //HashSet vs TreeSet
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        inicio = System.currentTimeMillis();
        for (int i = 0; i < N; i++) hashSet.add(i);
        fin = System.currentTimeMillis();
        System.out.println("HashSet (inserción): " + (fin - inicio) + " ms");

        inicio = System.currentTimeMillis();
        for (int i = 0; i < N; i++) treeSet.add(i);
        fin = System.currentTimeMillis();
        System.out.println("TreeSet (inserción): " + (fin - inicio) + " ms");

        System.out.println("\n---------------------------------------------");

        //HashMap vs TreeMap
        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();

        inicio = System.currentTimeMillis();
        for (int i = 0; i < N; i++) hashMap.put(i, "valor" + i);
        fin = System.currentTimeMillis();
        System.out.println("HashMap (inserción): " + (fin - inicio) + " ms");

        inicio = System.currentTimeMillis();
        for (int i = 0; i < N; i++) treeMap.put(i, "valor" + i);
        fin = System.currentTimeMillis();
        System.out.println("TreeMap (inserción): " + (fin - inicio) + " ms");
    }
}

