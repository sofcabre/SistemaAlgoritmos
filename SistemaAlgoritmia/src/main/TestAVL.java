package main;

import avl.AVLTree;
import modelo.Registro;

/**
 * Esta clase sirve para probar cómo funciona el Árbol AVL.
 * Se insertan varios registros y se imprime el recorrido en orden.
 */

public class TestAVL {
    public static void main(String[] args) {
        AVLTree arbol = new AVLTree();

        Registro r1 = new Registro(30, "Lápiz", "Lápiz de grafito", 100);
        Registro r2 = new Registro(10, "Cuaderno", "Cuaderno de 100 hojas", 50);
        Registro r3 = new Registro(20, "Borrador", "Borrador blanco", 40);
        Registro r4 = new Registro(40, "Regla", "Regla de 30cm", 25);

        arbol.insert(r1.getCodigo(), r1.toString());
        arbol.insert(r2.getCodigo(), r2.toString());
        arbol.insert(r3.getCodigo(), r3.toString());
        arbol.insert(r4.getCodigo(), r4.toString());

        // Mostrar el contenido del árbol
        System.out.println("Recorrido inorden del Árbol AVL:");
        arbol.inOrder();

        // Buscar un registro
        System.out.println("\nBuscando clave 20:");
        String resultado = arbol.search(20);
        System.out.println(resultado != null ? resultado : "No encontrado");
    }
}
