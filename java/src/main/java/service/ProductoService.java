package service;

import dao.ProductoDAO;
import model.Producto;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class ProductoService {
    private final ProductoDAO productoDAO = new ProductoDAO();

    public List<Producto> listar() throws SQLException {
        return productoDAO.listar();
    }

    public List<Producto> buscarPorNombre(String texto) throws SQLException {
        return productoDAO.buscarPorNombre(texto);
    }

    public Producto buscarPorId(int idProducto) throws SQLException {
        return productoDAO.buscarPorId(idProducto);
    }

    public boolean crearProducto(Producto producto) throws SQLException {
        validarProducto(producto);
        return productoDAO.insertar(producto);
    }

    public boolean actualizarProducto(Producto producto) throws SQLException {
        if (producto.getIdProducto() <= 0) {
            throw new IllegalArgumentException("El id del producto no es valido.");
        }
        validarProducto(producto);
        return productoDAO.actualizar(producto);
    }

    public boolean eliminarProducto(int idProducto) throws SQLException {
        if (idProducto <= 0) {
            throw new IllegalArgumentException("El id del producto no es valido.");
        }
        return productoDAO.eliminar(idProducto);
    }

    private void validarProducto(Producto producto) {
        if (producto.getIdCategoria() <= 0) {
            throw new IllegalArgumentException("La categoria no es valida.");
        }
        if (producto.getNombre() == null || producto.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacio.");
        }
        if (producto.getPrecio() == null || producto.getPrecio().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que 0.");
        }
        if (producto.getStock() < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
    }
}
