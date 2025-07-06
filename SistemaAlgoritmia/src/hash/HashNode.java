package hash;

/**
 * Esta clase representa un nodo dentro de una lista enlazada usada en la tabla hash con encadenamiento.
 * Cada nodo guarda una clave, los datos asociados y una referencia al siguiente nodo.
 */

public class HashNode {
    int key;               // Clave con la que se accede al dato
    String data;           // Información asociada a esa clave
    HashNode next;         // Apunta al siguiente nodo en la lista (en caso de colisión)

    // Constructor
    public HashNode(int key, String data) {
        this.key = key;
        this.data = data;
        this.next = null;
    }
}

