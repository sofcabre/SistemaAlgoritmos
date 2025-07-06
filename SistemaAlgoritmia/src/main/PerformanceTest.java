package main;

import avl.AVLTree;
import btree.BTree;
import hash.HashTableEncadenamiento;

public class PerformanceTest {

    public static void main(String[] args) {
        AVLTree avl = new AVLTree();
        BTree btree = new BTree(3);
        HashTableEncadenamiento hash = new HashTableEncadenamiento(1000);

        int[] sizes = {100, 1000, 5000};

        for (int size : sizes) {
            System.out.println("Pruebas con tamaño: " + size);

            // Inserción
            long start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                avl.insert(i, "valor" + i);
            }
            long end = System.nanoTime();
            System.out.println("AVL insert: " + (end - start) / 1_000_000.0 + " ms");

            start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                btree.insert(i, "valor" + i);
            }
            end = System.nanoTime();
            System.out.println("BTree insert: " + (end - start) / 1_000_000.0 + " ms");

            start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                hash.insert(i, "valor" + i);
            }
            end = System.nanoTime();
            System.out.println("HashTable insert: " + (end - start) / 1_000_000.0 + " ms");

            // Búsqueda
            start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                avl.search(i);
            }
            end = System.nanoTime();
            System.out.println("AVL search: " + (end - start) / 1_000_000.0 + " ms");

            start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                btree.search(i);
            }
            end = System.nanoTime();
            System.out.println("BTree search: " + (end - start) / 1_000_000.0 + " ms");

            start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                hash.search(i);
            }
            end = System.nanoTime();
            System.out.println("HashTable search: " + (end - start) / 1_000_000.0 + " ms");

            // Eliminación (solo AVL y Hash, ya que BTree no tiene)
            // AVL no tiene delete implementado, lo omitimos

            start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                hash.delete(i);
            }
            end = System.nanoTime();
            System.out.println("HashTable delete: " + (end - start) / 1_000_000.0 + " ms");

            System.out.println("-----------------------------");
        }
    }
}
