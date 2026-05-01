package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {
    private int idPedido;
    private int idCliente;
    private LocalDate fechaPedido;
    private String estado;
    private BigDecimal total;

    public Pedido(int idPedido, int idCliente, LocalDate fechaPedido, String estado, BigDecimal total) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
        this.total = total;
    }

    public int getIdPedido() { return idPedido; }
    public void setIdPedido(int idPedido) { this.idPedido = idPedido; }
    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
    public LocalDate getFechaPedido() { return fechaPedido; }
    public void setFechaPedido(LocalDate fechaPedido) { this.fechaPedido = fechaPedido; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    @Override
    public String toString() {
        return idPedido + " | Cliente: " + idCliente + " | " + fechaPedido + " | " + estado + " | Total: " + total + " €";
    }
}
