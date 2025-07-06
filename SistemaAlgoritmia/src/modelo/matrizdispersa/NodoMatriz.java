package modelo.matrizdispersa;

/**
 * Esta clase representa un nodo no vacío en la matriz dispersa.
 * Cada nodo guarda la fila, columna y el valor (por ejemplo, cantidad de producto)
 * Además tiene referencias a los nodos siguiente en fila y en columna para poder recorrer la matriz.
 */

public class NodoMatriz {
    int fila;          // Índice de la fila del nodo
    int columna;       // Índice de la columna del nodo
    int valor;         // Valor almacenado (cantidad o dato relevante)
    NodoMatriz siguienteFila;     // Referencia al siguiente nodo en la misma fila
    NodoMatriz siguienteColumna;  // Referencia al siguiente nodo en la misma columna

    // Constructor para crear un nodo nuevo con sus datos y sin referencias aún
    public NodoMatriz(int fila, int columna, int valor) {
        this.fila = fila;
        this.columna = columna;
        this.valor = valor;
        this.siguienteFila = null;
        this.siguienteColumna = null;
    }
}

