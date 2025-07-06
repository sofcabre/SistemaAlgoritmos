package main;

import btree.BTree;

public class TestBTree {

    public static void main(String[] args) {
        // Crear un árbol B con grado mínimo 3 
        BTree arbol = new BTree(3);

        // pueden ser datos o nombres
        arbol.insert(10, "Dato10");
        arbol.insert(20, "Dato20");
        arbol.insert(5, "Dato5");
        arbol.insert(6, "Dato6");
        arbol.insert(12, "Dato12");
        arbol.insert(30, "Dato30");
        arbol.insert(7, "Dato7");
        arbol.insert(17, "Dato17");

        // Mostrar el árbol en consola
        System.out.println("Contenido del Árbol B (recorrido ordenado):");
        arbol.display();

        // Buscar algunas claves
        System.out.println("\nBuscando claves:");
        int[] clavesBuscar = {6, 15, 17};
        for (int clave : clavesBuscar) {
            String resultado = arbol.search(clave);
            if (resultado != null) {
                System.out.println("Clave " + clave + " encontrada con valor: " + resultado);
            } else {
                System.out.println("Clave " + clave + " NO encontrada en el árbol.");
            }
        }
    }
}

