package service;

import dao.PagoDAO;
import model.Pago;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class PagoService {
    private final PagoDAO pagoDAO = new PagoDAO();

    public List<Pago> listar() throws SQLException {
        return pagoDAO.listar();
    }

    public boolean registrarPago(int idPedido, String metodoPago, BigDecimal importe) throws SQLException {
        if (idPedido <= 0) {
            throw new IllegalArgumentException("El id del pedido no es valido.");
        }
        if (metodoPago == null || metodoPago.isBlank()) {
            throw new IllegalArgumentException("El metodo de pago no puede estar vacio.");
        }
        if (importe == null || importe.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El importe debe ser mayor que 0.");
        }
        return pagoDAO.registrarPago(idPedido, metodoPago, importe);
    }
}
