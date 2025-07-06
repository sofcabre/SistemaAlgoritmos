package main;

import hash.HashTableEncadenamiento;
import modelo.Registro;

/**
 * Esta clase prueba la tabla hash con encadenamiento.
 * Inserta registros, busca y muestra el contenido de la tabla.
 */

public class TestHashEncadenamiento {
    public static void main(String[] args) {
        HashTableEncadenamiento tabla = new HashTableEncadenamiento(5);

        // Crear registros
        Registro r1 = new Registro(105, "Mouse", "Mouse inalámbrico", 20);
        Registro r2 = new Registro(210, "Teclado", "Teclado mecánico", 15);
        Registro r3 = new Registro(315, "Pantalla", "Monitor LED", 10);
        Registro r4 = new Registro(110, "Cámara", "Webcam HD", 5);

        // Insertar
        tabla.insert(r1.getCodigo(), r1.toString());
        tabla.insert(r2.getCodigo(), r2.toString());
        tabla.insert(r3.getCodigo(), r3.toString());
        tabla.insert(r4.getCodigo(), r4.toString());

        // Mostrar tabla
        System.out.println("Contenido de la tabla hash (encadenamiento):");
        tabla.display();

        // Buscar
        System.out.println("\nBuscando clave 210:");
        String res = tabla.search(210);
        System.out.println(res != null ? res : "No encontrado");
    }
}

