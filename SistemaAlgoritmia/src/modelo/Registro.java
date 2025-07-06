package modelo;

/**
 * Esta clase simula un registro de producto para el sistema de inventario.
 * Cada producto tiene un código como clave, un nombre, una descripción y una cantidad.
 */

public class Registro {
    int codigo;           // Clave principal (puede ser usado por el árbol o hash)
    String nombre;        // Nombre del producto
    String descripcion;   // Descripción breve
    int cantidad;         // Cantidad en inventario

    
    public Registro(int codigo, String nombre, String descripcion, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    // Método para convertir a String 
    public String toString() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", Desc: " + descripcion + ", Cantidad: " + cantidad;
    }

    // Getters para usar desde otras estructuras si se necesita
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }
}
