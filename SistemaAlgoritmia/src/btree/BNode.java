package btree;

/**
 * Esta clase representa un nodo del Árbol B.
 * Cada nodo puede tener varias claves y varios hijos.
 * La cantidad de claves depende del grado mínimo del árbol (t).
 */

public class BNode {
    int[] keys;             // Arreglo de claves
    String[] data;          // Arreglo con la información asociada a cada clave
    BNode[] children;       // Hijos del nodo
    int numKeys;            // Cuántas claves tiene actualmente
    boolean isLeaf;         // Indica si el nodo es hoja

    // Constructor
    public BNode(int t, boolean isLeaf) {
        this.keys = new int[2 * t - 1];          // Máximo número de claves
        this.data = new String[2 * t - 1];       // Datos asociados
        this.children = new BNode[2 * t];        // Máximo número de hijos
        this.numKeys = 0;
        this.isLeaf = isLeaf;
    }
}

