package model;

import java.math.BigDecimal;

public class Producto {
    private int idProducto;
    private int idCategoria;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private int stock;

    public Producto() {
    }

    public Producto(int idProducto, int idCategoria, String nombre, String descripcion, BigDecimal precio, int stock) {
        this.idProducto = idProducto;
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public Producto(int idCategoria, String nombre, String descripcion, BigDecimal precio, int stock) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }
    public int getIdCategoria() { return idCategoria; }
    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return idProducto + " | " + nombre + " | " + precio + " € | Stock: " + stock + " | Categoria: " + idCategoria;
    }
}
