package btree;

/**
 * Esta clase representa un Árbol B.
 * Soporta inserciones y búsquedas manteniendo las claves ordenadas.
 * El árbol se balancea automáticamente al dividir nodos llenos.
 */

public class BTree {
    private BNode root;     // Nodo raíz
    private int t;          // Grado mínimo

    
    public BTree(int t) {
        this.t = t;
        root = new BNode(t, true); // Al principio, la raíz es hoja
    }

    // Método para buscar un dato por su clave
    public String search(int key) {
        return searchRecursive(root, key);
    }

    private String searchRecursive(BNode node, int key) {
        int i = 0;

        // Buscar la posición de la clave en este nodo
        while (i < node.numKeys && key > node.keys[i]) {
            i++;
        }

        if (i < node.numKeys && key == node.keys[i]) {
            return node.data[i]; // Se encontró la clave
        }

        if (node.isLeaf) {
            return null; // No se encontró
        } else {
            return searchRecursive(node.children[i], key); // Buscar en el hijo correspondiente
        }
    }

    // Método para insertar una clave con su dato
    public void insert(int key, String value) {
        BNode r = root;

        if (r.numKeys == 2 * t - 1) {
            // La raíz está llena, hay que dividir
            BNode s = new BNode(t, false);
            s.children[0] = r;
            splitChild(s, 0, r);
            root = s;
            insertNonFull(s, key, value);
        } else {
            insertNonFull(r, key, value);
        }
    }

    // Inserta una clave en un nodo que no está lleno
    private void insertNonFull(BNode node, int key, String value) {
        int i = node.numKeys - 1;

        if (node.isLeaf) {
            // Mover las claves para hacer espacio
            while (i >= 0 && key < node.keys[i]) {
                node.keys[i + 1] = node.keys[i];
                node.data[i + 1] = node.data[i];
                i--;
            }

            // Insertar la nueva clave
            node.keys[i + 1] = key;
            node.data[i + 1] = value;
            node.numKeys++;
        } else {
            // Buscar el hijo correcto
            while (i >= 0 && key < node.keys[i]) {
                i--;
            }
            i++;

            // Si el hijo está lleno, se divide
            if (node.children[i].numKeys == 2 * t - 1) {
                splitChild(node, i, node.children[i]);

                if (key > node.keys[i]) {
                    i++;
                }
            }

            insertNonFull(node.children[i], key, value);
        }
    }

    // Divide un hijo lleno en dos y sube la clave del medio
    private void splitChild(BNode parent, int index, BNode fullChild) {
        BNode newChild = new BNode(t, fullChild.isLeaf);
        newChild.numKeys = t - 1;

        // Copiar las claves y datos al nuevo hijo
        for (int j = 0; j < t - 1; j++) {
            newChild.keys[j] = fullChild.keys[j + t];
            newChild.data[j] = fullChild.data[j + t];
        }

        // Si no es hoja, copiar los hijos también
        if (!fullChild.isLeaf) {
            for (int j = 0; j < t; j++) {
                newChild.children[j] = fullChild.children[j + t];
            }
        }

        fullChild.numKeys = t - 1;

        // Mover los hijos del padre para hacer espacio
        for (int j = parent.numKeys; j >= index + 1; j--) {
            parent.children[j + 1] = parent.children[j];
        }
        parent.children[index + 1] = newChild;

        // Mover las claves del padre
        for (int j = parent.numKeys - 1; j >= index; j--) {
            parent.keys[j + 1] = parent.keys[j];
            parent.data[j + 1] = parent.data[j];
        }

        // Subir la clave del medio
        parent.keys[index] = fullChild.keys[t - 1];
        parent.data[index] = fullChild.data[t - 1];
        parent.numKeys++;
    }

    // Método para mostrar el árbol (recorrido en orden)
    public void display() {
        displayRecursive(root, 0);
    }

    private void displayRecursive(BNode node, int level) {
        for (int i = 0; i < node.numKeys; i++) {
            if (!node.isLeaf) {
                displayRecursive(node.children[i], level + 1);
            }
            System.out.println("Nivel " + level + " | Clave: " + node.keys[i] + " -> " + node.data[i]);
        }

        if (!node.isLeaf) {
            displayRecursive(node.children[node.numKeys], level + 1);
        }
    }
}

