package avl;

/**
 * Esta clase representa al Árbol AVL.
 * Permite insertar, buscar y eliminar claves manteniendo el balance del árbol.
 * utiliza un balanceo automático con rotaciones después de insertar o eliminar.
 */
public class AVLTree {
    AVLNode root; // Nodo raíz del árbol

    // Método público para insertar una clave con sus datos
    public void insert(int key, String data) {
        root = insertRecursive(root, key, data);
    }

    // Método recursivo que hace la inserción y balancea el árbol
    private AVLNode insertRecursive(AVLNode node, int key, String data) {
        if (node == null) {
            return new AVLNode(key, data); // Caso base: se crea un nuevo nodo
        }

        if (key < node.key) {
            node.left = insertRecursive(node.left, key, data); // Insertar a la izquierda
        } else if (key > node.key) {
            node.right = insertRecursive(node.right, key, data); // Insertar a la derecha
        } else {
            return node; // Si la clave ya existe, no se inserta de nuevo
        }

        // Actualizar la altura del nodo
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // Obtener el factor de balance para verificar si está desbalanceado
        int balance = getBalance(node);

        // Caso 1: rotación simple a la derecha (izquierda izquierda)
        if (balance > 1 && key < node.left.key) {
            return rotateRight(node);
        }

        // Caso 2: rotación simple a la izquierda (derecha derecha)
        if (balance < -1 && key > node.right.key) {
            return rotateLeft(node);
        }

        // Caso 3: rotación doble izquierda-derecha
        if (balance > 1 && key > node.left.key) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Caso 4: rotación doble derecha-izquierda
        if (balance < -1 && key < node.right.key) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node; // Si está balanceado, se devuelve el nodo tal cual
    }

    // Obtener la altura de un nodo (si es null, es 0)
    private int getHeight(AVLNode node) {
        if (node == null) return 0;
        return node.height;
    }

    // Obtener el factor de balance de un nodo
    private int getBalance(AVLNode node) {
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    // Rotación simple a la derecha
    private AVLNode rotateRight(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Realizar rotación
        x.right = y;
        y.left = T2;

        // Actualizar alturas
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        // Devolver nueva raíz
        return x;
    }

    // Rotación simple a la izquierda
    private AVLNode rotateLeft(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Realizar rotación
        y.left = x;
        x.right = T2;

        // Actualizar alturas
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        // Devolver nueva raíz
        return y;
    }

    // Método para mostrar el árbol en orden (izquierda, raíz, derecha)
    public void inOrder() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(AVLNode node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.println("Clave: " + node.key + ", Dato: " + node.data);
            inOrderRecursive(node.right);
        }
    }

    // Método para buscar un nodo por su clave
    public String search(int key) {
        AVLNode result = searchRecursive(root, key);
        if (result != null) {
            return result.data;
        }
        return null;
    }

    private AVLNode searchRecursive(AVLNode node, int key) {
        if (node == null || node.key == key) {
            return node;
        }

        if (key < node.key) {
            return searchRecursive(node.left, key);
        } else {
            return searchRecursive(node.right, key);
        }
    }
}

