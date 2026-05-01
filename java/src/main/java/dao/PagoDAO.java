package dao;

import model.Pago;
import util.ConexionBD;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PagoDAO {

    public List<Pago> listar() throws SQLException {
        List<Pago> pagos = new ArrayList<>();
        String sql = "SELECT * FROM pagos ORDER BY id_pago";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                pagos.add(mapearPago(rs));
            }
        }
        return pagos;
    }

    public boolean registrarPago(int idPedido, String metodoPago, BigDecimal importe) throws SQLException {
        String sql = "INSERT INTO pagos (id_pedido, fecha_pago, metodo_pago, importe, estado_pago) VALUES (?, ?, ?, ?, ?)";
        String sqlPedido = "UPDATE pedidos SET estado = ? WHERE id_pedido = ?";

        try (Connection conexion = ConexionBD.conectar()) {
            conexion.setAutoCommit(false);
            try (PreparedStatement ps = conexion.prepareStatement(sql);
                 PreparedStatement psPedido = conexion.prepareStatement(sqlPedido)) {

                ps.setInt(1, idPedido);
                ps.setDate(2, Date.valueOf(LocalDate.now()));
                ps.setString(3, metodoPago);
                ps.setBigDecimal(4, importe);
                ps.setString(5, "Pagado");
                ps.executeUpdate();

                psPedido.setString(1, "Pagado");
                psPedido.setInt(2, idPedido);
                psPedido.executeUpdate();

                conexion.commit();
                return true;
            } catch (SQLException e) {
                conexion.rollback();
                throw e;
            } finally {
                conexion.setAutoCommit(true);
            }
        }
    }

    private Pago mapearPago(ResultSet rs) throws SQLException {
        return new Pago(
                rs.getInt("id_pago"),
                rs.getInt("id_pedido"),
                rs.getDate("fecha_pago") == null ? null : rs.getDate("fecha_pago").toLocalDate(),
                rs.getString("metodo_pago"),
                rs.getBigDecimal("importe"),
                rs.getString("estado_pago")
        );
    }
}
