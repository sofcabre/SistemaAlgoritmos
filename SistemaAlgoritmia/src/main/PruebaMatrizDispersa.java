package main;

/**Esta parte sirve para probar cómo funciona la matriz dispersa que representa
*la disponibilidad de productos por sucursal. Usamos una matriz de 3x3 como ejemplo.
*Cada fila representa una sucursal y cada columna un producto distinto.
*/

import modelo.matrizdispersa.MatrizDispersa;

public class PruebaMatrizDispersa {
 public static void main(String[] args) {
     // Creamos una matriz de 3 filas (sucursales) y 3 columnas (productos)
     MatrizDispersa matriz = new MatrizDispersa(3, 3);

     // Insertamos algunos valores de disponibilidad
     // Por ejemplo: en la sucursal 0, el producto 1 tiene 5 unidades
     matriz.insertar(0, 1, 5);
     matriz.insertar(1, 0, 3);
     matriz.insertar(2, 2, 7);

     // Intentamos actualizar un valor
     matriz.insertar(0, 1, 8); // Cambiamos de 5 a 8 unidades

     // Intentamos eliminar un valor colocando 0
     matriz.insertar(1, 0, 0); // Se elimina ese nodo

     // Obtenemos un valor específico
     int valor = matriz.obtenerValor(0, 1); // Debería ser 8
     System.out.println("Disponibilidad en sucursal 0, producto 1: " + valor);

     // Imprimimos la matriz entera mostrando solo los valores no cero
     matriz.imprimir();
 }
}
