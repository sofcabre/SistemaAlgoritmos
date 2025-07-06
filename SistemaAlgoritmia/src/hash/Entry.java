package hash;

/**
 * Esta clase representa una entrada en la tabla hash con sondeo lineal.
 * Guarda la clave, los datos, y un indicador para saber si fue eliminada.
 */

public class Entry {
    int key;              // Clave del dato
    String data;          // Información asociada
    boolean isDeleted;    // Marca si este espacio fue eliminado

    // Constructor
    public Entry(int key, String data) {
        this.key = key;
        this.data = data;
        this.isDeleted = false;
    }
}
