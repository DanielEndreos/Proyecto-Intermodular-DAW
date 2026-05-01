package service;

import dao.ClienteDAO;
import model.Cliente;

import java.sql.SQLException;
import java.util.List;

public class ClienteService {
    private final ClienteDAO clienteDAO = new ClienteDAO();

    public List<Cliente> listar() throws SQLException {
        return clienteDAO.listar();
    }

    public Cliente buscarPorId(int idCliente) throws SQLException {
        return clienteDAO.buscarPorId(idCliente);
    }

    public boolean crearCliente(Cliente cliente) throws SQLException {
        validarCliente(cliente);
        return clienteDAO.insertar(cliente);
    }

    public boolean actualizarCliente(Cliente cliente) throws SQLException {
        if (cliente.getIdCliente() <= 0) {
            throw new IllegalArgumentException("El id del cliente no es valido.");
        }
        validarCliente(cliente);
        return clienteDAO.actualizar(cliente);
    }

    public boolean eliminarCliente(int idCliente) throws SQLException {
        if (idCliente <= 0) {
            throw new IllegalArgumentException("El id del cliente no es valido.");
        }
        return clienteDAO.eliminar(idCliente);
    }

    private void validarCliente(Cliente cliente) {
        if (cliente.getNombre() == null || cliente.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio.");
        }
        if (cliente.getApellidos() == null || cliente.getApellidos().isBlank()) {
            throw new IllegalArgumentException("Los apellidos no pueden estar vacios.");
        }
        if (cliente.getEmail() == null || !cliente.getEmail().contains("@")) {
            throw new IllegalArgumentException("El email no es valido.");
        }
    }
}
