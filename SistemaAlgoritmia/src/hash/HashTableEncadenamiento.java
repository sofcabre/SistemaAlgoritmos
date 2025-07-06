package hash;

/**
 * Esta clase implementa una tabla hash utilizando encadenamiento para manejar colisiones.
 * Cada posición de la tabla contiene una lista enlazada donde se almacenan los elementos con la misma clave hash.
 */

public class HashTableEncadenamiento {
    private int size;                // Tamaño de la tabla
    private HashNode[] table;       // Arreglo de listas (cabezas de listas enlazadas)

    // Constructor que recibe el tamaño de la tabla
    public HashTableEncadenamiento(int size) {
        this.size = size;
        table = new HashNode[size]; // Se crea el arreglo de tamaño fijo
    }

    // Función hash básica (módulo)
    private int hashFunction(int key) {
        return key % size;
    }

    // Método para insertar una clave y su dato
    public void insert(int key, String data) {
        int index = hashFunction(key);
        HashNode newNode = new HashNode(key, data);

        // Si la posición está vacía, se pone directamente
        if (table[index] == null) {
            table[index] = newNode;
        } else {
            // Si ya hay elementos, se agrega al inicio de la lista (puede ser al final también si prefieres)
            newNode.next = table[index];
            table[index] = newNode;
        }
    }

    // Método para buscar un dato por su clave
    public String search(int key) {
        int index = hashFunction(key);
        HashNode current = table[index];

        while (current != null) {
            if (current.key == key) {
                return current.data; // Se encontró la clave
            }
            current = current.next;
        }

        return null; // No se encontró
    }

    // Método para eliminar un elemento por su clave
    public void delete(int key) {
        int index = hashFunction(key);
        HashNode current = table[index];
        HashNode prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    // Es el primer nodo de la lista
                    table[index] = current.next;
                } else {
                    // Nodo intermedio o final
                    prev.next = current.next;
                }
                return; // Elemento eliminado
            }
            prev = current;
            current = current.next;
        }
    }

    // Método para mostrar el contenido completo de la tabla hash
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Índice " + i + ": ");
            HashNode current = table[i];

            if (current == null) {
                System.out.println("vacío");
            } else {
                while (current != null) {
                    System.out.print("[" + current.key + " -> " + current.data + "] ");
                    current = current.next;
                }
                System.out.println();
            }
        }
    }
}

