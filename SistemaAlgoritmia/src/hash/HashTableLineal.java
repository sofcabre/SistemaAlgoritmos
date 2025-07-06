package hash;

/**
 * Esta clase implementa una tabla hash usando sondeo lineal como método de resolución de colisiones.
 * Si una posición está ocupada, se busca la siguiente libre hacia la derecha (de forma circular).
 */

public class HashTableLineal {
    private int size;          // Tamaño de la tabla
    private Entry[] table;     // Arreglo donde se almacenan las entradas

    // Constructor
    public HashTableLineal(int size) {
        this.size = size;
        this.table = new Entry[size]; // Crear el arreglo de entradas
    }

    // Función hash simple usando el módulo
    private int hashFunction(int key) {
        return key % size;
    }

    // Método para insertar una clave y sus datos
    public void insert(int key, String data) {
        int index = hashFunction(key);

        for (int i = 0; i < size; i++) {
            int pos = (index + i) % size;

            // Si está vacío o previamente eliminado, insertamos aquí
            if (table[pos] == null || table[pos].isDeleted) {
                table[pos] = new Entry(key, data);
                return;
            }

            // Si ya existe la clave, no insertamos duplicado
            if (table[pos].key == key && !table[pos].isDeleted) {
                return;
            }
        }

        System.out.println("Error: la tabla está llena y no se pudo insertar.");
    }

    // Método para buscar un dato por su clave
    public String search(int key) {
        int index = hashFunction(key);

        for (int i = 0; i < size; i++) {
            int pos = (index + i) % size;

            if (table[pos] == null) {
                return null; // No está
            }

            if (table[pos].key == key && !table[pos].isDeleted) {
                return table[pos].data;
            }
        }

        return null; // No se encontró
    }

    // Método para eliminar una clave
    public void delete(int key) {
        int index = hashFunction(key);

        for (int i = 0; i < size; i++) {
            int pos = (index + i) % size;

            if (table[pos] == null) {
                return; // No se encontró
            }

            if (table[pos].key == key && !table[pos].isDeleted) {
                table[pos].isDeleted = true; // Marcamos como eliminado
                return;
            }
        }
    }

    // Método para mostrar el contenido de la tabla
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Posición " + i + ": ");
            if (table[i] == null || table[i].isDeleted) {
                System.out.println("vacío");
            } else {
                System.out.println("[" + table[i].key + " -> " + table[i].data + "]");
            }
        }
    }
}

