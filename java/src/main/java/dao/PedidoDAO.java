package dao;

import model.DetallePedido;
import model.Pedido;
import util.ConexionBD;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    public List<Pedido> listar() throws SQLException {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedidos ORDER BY id_pedido";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                pedidos.add(mapearPedido(rs));
            }
        }
        return pedidos;
    }

    public List<Pedido> listarPorCliente(int idCliente) throws SQLException {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedidos WHERE id_cliente = ? ORDER BY fecha_pedido DESC";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idCliente);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    pedidos.add(mapearPedido(rs));
                }
            }
        }
        return pedidos;
    }

    public boolean actualizarEstado(int idPedido, String estado) throws SQLException {
        String sql = "UPDATE pedidos SET estado = ? WHERE id_pedido = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, estado);
            ps.setInt(2, idPedido);
            return ps.executeUpdate() > 0;
        }
    }

    public int crearPedido(int idCliente, List<DetallePedido> detalles) throws SQLException {
        String sqlPedido = "INSERT INTO pedidos (id_cliente, fecha_pedido, estado, total) VALUES (?, ?, ?, ?)";
        String sqlDetalle = "INSERT INTO detalle_pedido (id_pedido, id_producto, cantidad, precio_unitario, subtotal) VALUES (?, ?, ?, ?, ?)";
        String sqlStock = "UPDATE productos SET stock = stock - ? WHERE id_producto = ? AND stock >= ?";

        BigDecimal total = detalles.stream()
                .map(DetallePedido::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        try (Connection conexion = ConexionBD.conectar()) {
            conexion.setAutoCommit(false);

            try (PreparedStatement psPedido = conexion.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS)) {
                psPedido.setInt(1, idCliente);
                psPedido.setDate(2, Date.valueOf(LocalDate.now()));
                psPedido.setString(3, "Pendiente");
                psPedido.setBigDecimal(4, total);
                psPedido.executeUpdate();

                int idPedido;
                try (ResultSet claves = psPedido.getGeneratedKeys()) {
                    if (!claves.next()) {
                        throw new SQLException("No se pudo obtener el id del pedido.");
                    }
                    idPedido = claves.getInt(1);
                }

                try (PreparedStatement psDetalle = conexion.prepareStatement(sqlDetalle);
                     PreparedStatement psStock = conexion.prepareStatement(sqlStock)) {

                    for (DetallePedido detalle : detalles) {
                        psStock.setInt(1, detalle.getCantidad());
                        psStock.setInt(2, detalle.getIdProducto());
                        psStock.setInt(3, detalle.getCantidad());

                        if (psStock.executeUpdate() == 0) {
                            throw new SQLException("Stock insuficiente para el producto " + detalle.getIdProducto());
                        }

                        psDetalle.setInt(1, idPedido);
                        psDetalle.setInt(2, detalle.getIdProducto());
                        psDetalle.setInt(3, detalle.getCantidad());
                        psDetalle.setBigDecimal(4, detalle.getPrecioUnitario());
                        psDetalle.setBigDecimal(5, detalle.getSubtotal());
                        psDetalle.addBatch();
                    }
                    psDetalle.executeBatch();
                }

                conexion.commit();
                return idPedido;
            } catch (SQLException e) {
                conexion.rollback();
                throw e;
            } finally {
                conexion.setAutoCommit(true);
            }
        }
    }

    public boolean eliminarPedido(int idPedido) throws SQLException {
        String sqlDetalle = "DELETE FROM detalle_pedido WHERE id_pedido = ?";
        String sqlPago = "DELETE FROM pagos WHERE id_pedido = ?";
        String sqlPedido = "DELETE FROM pedidos WHERE id_pedido = ?";

        try (Connection conexion = ConexionBD.conectar()) {
            conexion.setAutoCommit(false);
            try (PreparedStatement psDetalle = conexion.prepareStatement(sqlDetalle);
                 PreparedStatement psPago = conexion.prepareStatement(sqlPago);
                 PreparedStatement psPedido = conexion.prepareStatement(sqlPedido)) {

                psDetalle.setInt(1, idPedido);
                psDetalle.executeUpdate();

                psPago.setInt(1, idPedido);
                psPago.executeUpdate();

                psPedido.setInt(1, idPedido);
                boolean eliminado = psPedido.executeUpdate() > 0;
                conexion.commit();
                return eliminado;
            } catch (SQLException e) {
                conexion.rollback();
                throw e;
            } finally {
                conexion.setAutoCommit(true);
            }
        }
    }

    private Pedido mapearPedido(ResultSet rs) throws SQLException {
        return new Pedido(
                rs.getInt("id_pedido"),
                rs.getInt("id_cliente"),
                rs.getDate("fecha_pedido").toLocalDate(),
                rs.getString("estado"),
                rs.getBigDecimal("total")
        );
    }
}
