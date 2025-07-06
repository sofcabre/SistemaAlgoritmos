package main;

import hash.HashTableLineal;
import modelo.Registro;

/**
 * Esta clase prueba la tabla hash con sondeo lineal.
 * Inserta registros, muestra la tabla y busca uno.
 */

public class TestHashLineal {
    public static void main(String[] args) {
        HashTableLineal tabla = new HashTableLineal(5);

        Registro r1 = new Registro(1, "USB", "Memoria USB 16GB", 12);
        Registro r2 = new Registro(6, "Router", "Router WiFi", 7);
        Registro r3 = new Registro(11, "Disco Duro", "Disco 1TB", 3);
        Registro r4 = new Registro(16, "Tablet", "Tablet Android", 4);

        tabla.insert(r1.getCodigo(), r1.toString());
        tabla.insert(r2.getCodigo(), r2.toString());
        tabla.insert(r3.getCodigo(), r3.toString());
        tabla.insert(r4.getCodigo(), r4.toString());

        System.out.println("Contenido de la tabla hash (sondeo lineal):");
        tabla.display();

        System.out.println("\nBuscando clave 11:");
        String res = tabla.search(11);
        System.out.println(res != null ? res : "No encontrado");
    }
}

