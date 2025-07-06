package avl;

/**
 * Esta clase representa un nodo del Árbol AVL.
 * Cada nodo guarda una clave, unos datos asociados,
 * y referencias a sus hijos izquierdo y derecho.
 * También guarda su altura, que es necesaria para poder balancear el árbol.
 */

public class AVLNode {
    int key;              // La clave que se usará para ordenar los nodos
    String data;          // Información adicional que se asocia a la clave
    AVLNode left;         // Hijo izquierdo
    AVLNode right;        // Hijo derecho
    int height;           // Altura del nodo dentro del árbol

    // Constructor del nodo
    public AVLNode(int key, String data) {
        this.key = key;
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1; // Un nodo nuevo tiene altura 1
    }
}

