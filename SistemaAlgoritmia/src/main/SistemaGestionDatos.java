package main;

import avl.AVLTree;
import btree.BTree;
import hash.HashTableEncadenamiento;
import hash.HashTableLineal;
import modelo.Registro;

import java.util.Scanner;

/**
 * Se incluye un menú para facilitar las pruebas del sistema por consola.
 * Esto permite al usuario interactuar con las estructuras de datos sin modificar el código fuente.
 * También es útil para simular cómo funcionaría el sistema si tuviera una interfaz gráfica o de usuario real.
 * El menú ofrece opciones para insertar nuevos registros, buscar claves, mostrar estructuras o salir.
 */

public class SistemaGestionDatos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AVLTree avl = new AVLTree();
        BTree btree = new BTree(2);
        HashTableEncadenamiento hashEnc = new HashTableEncadenamiento(7);
        HashTableLineal hashLineal = new HashTableLineal(7);

        boolean salir = false;

        while (!salir) {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Insertar nuevo registro");
            System.out.println("2. Buscar registro por clave");
            System.out.println("3. Mostrar contenido de las estructuras");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese código (int): ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine(); // limpiar buffer

                    System.out.print("Nombre del producto: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Descripción: ");
                    String desc = scanner.nextLine();

                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine(); // limpiar buffer

                    Registro nuevo = new Registro(codigo, nombre, desc, cantidad);

                    avl.insert(codigo, nuevo.toString());
                    btree.insert(codigo, nuevo.toString());
                    hashEnc.insert(codigo, nuevo.toString());
                    hashLineal.insert(codigo, nuevo.toString());

                    System.out.println("Registro insertado en todas las estructuras.");
                    break;

                case 2:
                    System.out.print("Ingrese clave a buscar: ");
                    int claveBuscar = scanner.nextInt();
                    scanner.nextLine(); // limpiar buffer

                    String r1 = avl.search(claveBuscar);
                    String r2 = btree.search(claveBuscar);
                    String r3 = hashEnc.search(claveBuscar);
                    String r4 = hashLineal.search(claveBuscar);

                    System.out.println("\n--- Resultados ---");
                    System.out.println("AVL: " + (r1 != null ? r1 : "No encontrado"));
                    System.out.println("BTree: " + (r2 != null ? r2 : "No encontrado"));
                    System.out.println("Hash Encadenamiento: " + (r3 != null ? r3 : "No encontrado"));
                    System.out.println("Hash Lineal: " + (r4 != null ? r4 : "No encontrado"));
                    break;

                case 3:
                    System.out.println("\n=== AVL ===");
                    avl.inOrder();

                    System.out.println("\n=== BTree ===");
                    btree.display();

                    System.out.println("\n=== Hash Encadenamiento ===");
                    hashEnc.display();

                    System.out.println("\n=== Hash Sondeo Lineal ===");
                    hashLineal.display();
                    break;

                case 4:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }

        scanner.close();
    }
}

