package service;

import dao.PedidoDAO;
import model.DetallePedido;
import model.Pedido;

import java.sql.SQLException;
import java.util.List;

public class PedidoService {
    private final PedidoDAO pedidoDAO = new PedidoDAO();

    public List<Pedido> listar() throws SQLException {
        return pedidoDAO.listar();
    }

    public List<Pedido> listarPorCliente(int idCliente) throws SQLException {
        if (idCliente <= 0) {
            throw new IllegalArgumentException("El id del cliente no es valido.");
        }
        return pedidoDAO.listarPorCliente(idCliente);
    }

    public int crearPedido(int idCliente, List<DetallePedido> detalles) throws SQLException {
        if (idCliente <= 0) {
            throw new IllegalArgumentException("El id del cliente no es valido.");
        }
        if (detalles == null || detalles.isEmpty()) {
            throw new IllegalArgumentException("El pedido debe tener al menos un producto.");
        }
        return pedidoDAO.crearPedido(idCliente, detalles);
    }

    public boolean cambiarEstado(int idPedido, String estado) throws SQLException {
        if (idPedido <= 0) {
            throw new IllegalArgumentException("El id del pedido no es valido.");
        }
        if (estado == null || estado.isBlank()) {
            throw new IllegalArgumentException("El estado no puede estar vacio.");
        }
        return pedidoDAO.actualizarEstado(idPedido, estado);
    }

    public boolean eliminarPedido(int idPedido) throws SQLException {
        if (idPedido <= 0) {
            throw new IllegalArgumentException("El id del pedido no es valido.");
        }
        return pedidoDAO.eliminarPedido(idPedido);
    }
}
