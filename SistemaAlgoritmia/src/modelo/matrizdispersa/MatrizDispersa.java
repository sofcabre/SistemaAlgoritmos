package modelo.matrizdispersa;

import java.util.ArrayList;

/**
 * Esta clase representa una matriz dispersa usando listas enlazadas por filas y columnas.
 * Sirve para almacenar datos donde la mayoría son ceros y solo se guardan los valores no nulos.
 * En nuestro proyecto la usamos para controlar disponibilidad de productos en sucursales.
 */

public class MatrizDispersa {
    private int filas;   // Número total de filas de la matriz
    private int columnas; // Número total de columnas de la matriz

    // Listas de encabezados para filas y columnas, cada uno apunta al primer nodo no vacío
    private ArrayList<NodoMatriz> encabezadosFila;
    private ArrayList<NodoMatriz> encabezadosColumna;

    // Constructor para inicializar la matriz con tamaño definido
    public MatrizDispersa(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        encabezadosFila = new ArrayList<>(filas);
        encabezadosColumna = new ArrayList<>(columnas);

        // Inicializar con nulls para cada encabezado
        for (int i = 0; i < filas; i++) {
            encabezadosFila.add(null);
        }
        for (int j = 0; j < columnas; j++) {
            encabezadosColumna.add(null);
        }
    }

    /**
     * Método para insertar o actualizar un valor en la matriz.
     * Solo guarda nodos si el valor es distinto de cero.
     * Si el valor es cero, elimina el nodo si existe.
     */
    
    public void insertar(int fila, int columna, int valor) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            System.out.println("Error: índices fuera de rango.");
            return;
        }

        if (valor == 0) {
            eliminar(fila, columna);
            return;
        }

        // Primero, buscamos si ya existe un nodo en esa posición para actualizarlo
        NodoMatriz nodoExistente = buscarNodo(fila, columna);
        if (nodoExistente != null) {
            nodoExistente.valor = valor; // Actualizamos el valor
            return;
        }

        // Si no existe, creamos un nuevo nodo
        NodoMatriz nuevoNodo = new NodoMatriz(fila, columna, valor);

        // Insertar en la lista enlazada de la fila
        if (encabezadosFila.get(fila) == null || encabezadosFila.get(fila).columna > columna) {
            // Insertar al inicio de la fila
            nuevoNodo.siguienteFila = encabezadosFila.get(fila);
            encabezadosFila.set(fila, nuevoNodo);
        } else {
            NodoMatriz actual = encabezadosFila.get(fila);
            while (actual.siguienteFila != null && actual.siguienteFila.columna < columna) {
                actual = actual.siguienteFila;
            }
            nuevoNodo.siguienteFila = actual.siguienteFila;
            actual.siguienteFila = nuevoNodo;
        }

        // Insertar en la lista enlazada de la columna
        if (encabezadosColumna.get(columna) == null || encabezadosColumna.get(columna).fila > fila) {
            // Insertar al inicio de la columna
            nuevoNodo.siguienteColumna = encabezadosColumna.get(columna);
            encabezadosColumna.set(columna, nuevoNodo);
        } else {
            NodoMatriz actual = encabezadosColumna.get(columna);
            while (actual.siguienteColumna != null && actual.siguienteColumna.fila < fila) {
                actual = actual.siguienteColumna;
            }
            nuevoNodo.siguienteColumna = actual.siguienteColumna;
            actual.siguienteColumna = nuevoNodo;
        }
    }

    /**
     * Busca y devuelve el nodo en la posición indicada, o null si no existe.
     */
    
    private NodoMatriz buscarNodo(int fila, int columna) {
        NodoMatriz actual = encabezadosFila.get(fila);
        while (actual != null && actual.columna <= columna) {
            if (actual.columna == columna) {
                return actual;
            }
            actual = actual.siguienteFila;
        }
        return null;
    }

    /**
     * Elimina un nodo en la posición dada si existe.
     */
    
    public void eliminar(int fila, int columna) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            System.out.println("Error: índices fuera de rango.");
            return;
        }

        // Eliminar de la lista fila
        NodoMatriz actualFila = encabezadosFila.get(fila);
        NodoMatriz anteriorFila = null;

        while (actualFila != null && actualFila.columna < columna) {
            anteriorFila = actualFila;
            actualFila = actualFila.siguienteFila;
        }

        if (actualFila != null && actualFila.columna == columna) {
            if (anteriorFila == null) {
                // Nodo es el primero en la fila
                encabezadosFila.set(fila, actualFila.siguienteFila);
            } else {
                anteriorFila.siguienteFila = actualFila.siguienteFila;
            }
        } else {
            // No existe nodo en esa posición
            return;
        }

        // Eliminar de la lista columna
        NodoMatriz actualCol = encabezadosColumna.get(columna);
        NodoMatriz anteriorCol = null;

        while (actualCol != null && actualCol.fila < fila) {
            anteriorCol = actualCol;
            actualCol = actualCol.siguienteColumna;
        }

        if (actualCol != null && actualCol.fila == fila) {
            if (anteriorCol == null) {
                // Nodo es el primero en la columna
                encabezadosColumna.set(columna, actualCol.siguienteColumna);
            } else {
                anteriorCol.siguienteColumna = actualCol.siguienteColumna;
            }
        }
    }

    /**
     * Método para obtener el valor en una posición dada.
     * Si no hay nodo almacenado, se asume que es 0.
     */
    
    public int obtenerValor(int fila, int columna) {
        NodoMatriz nodo = buscarNodo(fila, columna);
        if (nodo != null) {
            return nodo.valor;
        }
        return 0;
    }

    /**
     * Imprime toda la matriz dispersa mostrando solo los valores no cero
     */
    
    public void imprimir() {
        System.out.println("Matriz Dispersa (solo valores no cero):");
        for (int i = 0; i < filas; i++) {
            NodoMatriz actual = encabezadosFila.get(i);
            int colActual = 0;
            while (actual != null) {
                // Imprimimos ceros hasta la columna del nodo actual
                while (colActual < actual.columna) {
                    System.out.print("0 ");
                    colActual++;
                }
                // Imprimimos el valor real
                System.out.print(actual.valor + " ");
                colActual++;
                actual = actual.siguienteFila;
            }
            // Imprimir ceros restantes al final de la fila
            while (colActual < columnas) {
                System.out.print("0 ");
                colActual++;
            }
            System.out.println();
        }
    }
}

