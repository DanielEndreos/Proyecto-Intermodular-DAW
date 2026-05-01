package view;

import model.Cliente;
import model.DetallePedido;
import model.Producto;
import service.ClienteService;
import service.PagoService;
import service.PedidoService;
import service.ProductoService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final ClienteService clienteService = new ClienteService();
    private final ProductoService productoService = new ProductoService();
    private final PedidoService pedidoService = new PedidoService();
    private final PagoService pagoService = new PagoService();

    public void iniciar() {
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = leerEntero("Elige una opcion: ");

            try {
                switch (opcion) {
                    case 1 -> menuProductos();
                    case 2 -> menuClientes();
                    case 3 -> menuPedidos();
                    case 4 -> menuPagos();
                    case 0 -> System.out.println("Saliendo de ElectroHogar...");
                    default -> System.out.println("Opcion no valida.");
                }
            } catch (SQLException e) {
                System.out.println("Error de base de datos: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Dato incorrecto: " + e.getMessage());
            }
        } while (opcion != 0);
    }

    private void mostrarMenuPrincipal() {
        System.out.println("\n===== ELECTROHOGAR =====");
        System.out.println("1. Gestionar productos");
        System.out.println("2. Gestionar clientes");
        System.out.println("3. Gestionar pedidos");
        System.out.println("4. Gestionar pagos");
        System.out.println("0. Salir");
    }

    private void menuProductos() throws SQLException {
        int opcion;
        do {
            System.out.println("\n--- PRODUCTOS ---");
            System.out.println("1. Listar productos");
            System.out.println("2. Buscar producto por nombre");
            System.out.println("3. Crear producto");
            System.out.println("4. Modificar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("0. Volver");
            opcion = leerEntero("Elige una opcion: ");

            switch (opcion) {
                case 1 -> productoService.listar().forEach(System.out::println);
                case 2 -> buscarProducto();
                case 3 -> crearProducto();
                case 4 -> modificarProducto();
                case 5 -> eliminarProducto();
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    private void buscarProducto() throws SQLException {
        String texto = leerTexto("Texto a buscar: ");
        productoService.buscarPorNombre(texto).forEach(System.out::println);
    }

    private void crearProducto() throws SQLException {
        Producto producto = pedirDatosProducto(0);
        if (productoService.crearProducto(producto)) {
            System.out.println("Producto creado correctamente.");
        }
    }

    private void modificarProducto() throws SQLException {
        int id = leerEntero("Id producto a modificar: ");
        Producto producto = productoService.buscarPorId(id);
        if (producto == null) {
            System.out.println("No existe ese producto.");
            return;
        }
        Producto nuevo = pedirDatosProducto(id);
        if (productoService.actualizarProducto(nuevo)) {
            System.out.println("Producto actualizado correctamente.");
        }
    }

    private void eliminarProducto() throws SQLException {
        int id = leerEntero("Id producto a eliminar: ");
        if (productoService.eliminarProducto(id)) {
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("No se ha eliminado ningun producto.");
        }
    }

    private Producto pedirDatosProducto(int idProducto) {
        int idCategoria = leerEntero("Id categoria: ");
        String nombre = leerTexto("Nombre: ");
        String descripcion = leerTexto("Descripcion: ");
        BigDecimal precio = leerDecimal("Precio: ");
        int stock = leerEntero("Stock: ");
        return new Producto(idProducto, idCategoria, nombre, descripcion, precio, stock);
    }

    private void menuClientes() throws SQLException {
        int opcion;
        do {
            System.out.println("\n--- CLIENTES ---");
            System.out.println("1. Listar clientes");
            System.out.println("2. Crear cliente");
            System.out.println("3. Modificar cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("0. Volver");
            opcion = leerEntero("Elige una opcion: ");

            switch (opcion) {
                case 1 -> clienteService.listar().forEach(System.out::println);
                case 2 -> crearCliente();
                case 3 -> modificarCliente();
                case 4 -> eliminarCliente();
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    private void crearCliente() throws SQLException {
        Cliente cliente = pedirDatosCliente(0);
        if (clienteService.crearCliente(cliente)) {
            System.out.println("Cliente creado correctamente.");
        }
    }

    private void modificarCliente() throws SQLException {
        int id = leerEntero("Id cliente a modificar: ");
        Cliente cliente = clienteService.buscarPorId(id);
        if (cliente == null) {
            System.out.println("No existe ese cliente.");
            return;
        }
        Cliente nuevo = pedirDatosCliente(id);
        if (clienteService.actualizarCliente(nuevo)) {
            System.out.println("Cliente actualizado correctamente.");
        }
    }

    private void eliminarCliente() throws SQLException {
        int id = leerEntero("Id cliente a eliminar: ");
        if (clienteService.eliminarCliente(id)) {
            System.out.println("Cliente eliminado correctamente.");
        } else {
            System.out.println("No se ha eliminado ningun cliente.");
        }
    }

    private Cliente pedirDatosCliente(int idCliente) {
        String nombre = leerTexto("Nombre: ");
        String apellidos = leerTexto("Apellidos: ");
        String email = leerTexto("Email: ");
        String telefono = leerTexto("Telefono: ");
        String direccion = leerTexto("Direccion: ");
        Cliente cliente = new Cliente(nombre, apellidos, email, telefono, direccion);
        cliente.setIdCliente(idCliente);
        return cliente;
    }

    private void menuPedidos() throws SQLException {
        int opcion;
        do {
            System.out.println("\n--- PEDIDOS ---");
            System.out.println("1. Listar pedidos");
            System.out.println("2. Listar pedidos por cliente");
            System.out.println("3. Crear pedido");
            System.out.println("4. Cambiar estado de pedido");
            System.out.println("5. Eliminar pedido");
            System.out.println("0. Volver");
            opcion = leerEntero("Elige una opcion: ");

            switch (opcion) {
                case 1 -> pedidoService.listar().forEach(System.out::println);
                case 2 -> listarPedidosCliente();
                case 3 -> crearPedido();
                case 4 -> cambiarEstadoPedido();
                case 5 -> eliminarPedido();
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    private void listarPedidosCliente() throws SQLException {
        int idCliente = leerEntero("Id cliente: ");
        pedidoService.listarPorCliente(idCliente).forEach(System.out::println);
    }

    private void crearPedido() throws SQLException {
        int idCliente = leerEntero("Id cliente: ");
        List<DetallePedido> detalles = new ArrayList<>();
        String continuar;

        do {
            productoService.listar().forEach(System.out::println);
            int idProducto = leerEntero("Id producto: ");
            int cantidad = leerEntero("Cantidad: ");

            Producto producto = productoService.buscarPorId(idProducto);
            if (producto == null) {
                System.out.println("Ese producto no existe.");
            } else {
                detalles.add(new DetallePedido(idProducto, cantidad, producto.getPrecio()));
                System.out.println("Producto anadido al pedido.");
            }
            continuar = leerTexto("Anadir otro producto? (s/n): ");
        } while (continuar.equalsIgnoreCase("s"));

        int idPedido = pedidoService.crearPedido(idCliente, detalles);
        System.out.println("Pedido creado correctamente con id: " + idPedido);
    }

    private void cambiarEstadoPedido() throws SQLException {
        int idPedido = leerEntero("Id pedido: ");
        String estado = leerTexto("Nuevo estado: ");
        if (pedidoService.cambiarEstado(idPedido, estado)) {
            System.out.println("Estado actualizado correctamente.");
        }
    }

    private void eliminarPedido() throws SQLException {
        int idPedido = leerEntero("Id pedido: ");
        if (pedidoService.eliminarPedido(idPedido)) {
            System.out.println("Pedido eliminado correctamente.");
        } else {
            System.out.println("No se ha eliminado ningun pedido.");
        }
    }

    private void menuPagos() throws SQLException {
        int opcion;
        do {
            System.out.println("\n--- PAGOS ---");
            System.out.println("1. Listar pagos");
            System.out.println("2. Registrar pago");
            System.out.println("0. Volver");
            opcion = leerEntero("Elige una opcion: ");

            switch (opcion) {
                case 1 -> pagoService.listar().forEach(System.out::println);
                case 2 -> registrarPago();
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    private void registrarPago() throws SQLException {
        int idPedido = leerEntero("Id pedido: ");
        String metodo = leerTexto("Metodo de pago: ");
        BigDecimal importe = leerDecimal("Importe: ");
        if (pagoService.registrarPago(idPedido, metodo, importe)) {
            System.out.println("Pago registrado correctamente.");
        }
    }

    private int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduce un numero valido.");
            }
        }
    }

    private BigDecimal leerDecimal(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return new BigDecimal(scanner.nextLine().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Introduce un importe valido.");
            }
        }
    }

    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }
}
