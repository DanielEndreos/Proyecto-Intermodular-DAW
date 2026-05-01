package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pago {
    private int idPago;
    private int idPedido;
    private LocalDate fechaPago;
    private String metodoPago;
    private BigDecimal importe;
    private String estadoPago;

    public Pago(int idPago, int idPedido, LocalDate fechaPago, String metodoPago, BigDecimal importe, String estadoPago) {
        this.idPago = idPago;
        this.idPedido = idPedido;
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
        this.importe = importe;
        this.estadoPago = estadoPago;
    }

    public int getIdPago() { return idPago; }
    public int getIdPedido() { return idPedido; }
    public LocalDate getFechaPago() { return fechaPago; }
    public String getMetodoPago() { return metodoPago; }
    public BigDecimal getImporte() { return importe; }
    public String getEstadoPago() { return estadoPago; }

    @Override
    public String toString() {
        return idPago + " | Pedido: " + idPedido + " | " + fechaPago + " | " + metodoPago + " | " + importe + " € | " + estadoPago;
    }
}
