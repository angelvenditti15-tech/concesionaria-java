import concesionaria.Concesionaria;
import modelo.*;

import java.util.Scanner;

public class Main {

    private static Concesionaria concesionaria = new Concesionaria();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = -1;
        do {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un numero valido.");
                continue;
            }
            procesarOpcion(opcion);
        } while (opcion != 0);

        concesionaria.guardarDatos();
        System.out.println("Hasta luego!");
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n======= CONCESIONARIA =======");
        System.out.println("1. Agregar vehiculo");
        System.out.println("2. Registrar cliente");
        System.out.println("3. Vender vehiculo");
        System.out.println("4. Realizar test drive");
        System.out.println("5. Mostrar vehiculos disponibles");
        System.out.println("6. Mostrar inventario ordenado por precio");
        System.out.println("7. Mostrar precio promedio del inventario");
        System.out.println("0. Salir");
        System.out.print("Opcion: ");
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> agregarVehiculo();
            case 2 -> registrarCliente();
            case 3 -> venderVehiculo();
            case 4 -> hacerTestDrive();
            case 5 -> concesionaria.mostrarVehiculosDisponibles();
            case 6 -> concesionaria.mostrarInventarioOrdenadoPorPrecio();
            case 7 -> concesionaria.mostrarPrecioPromedio();
            case 0 -> {}
            default -> System.out.println("Opcion no valida.");
        }
    }

    private static void agregarVehiculo() {
        System.out.println("Tipo de vehiculo: 1) Auto  2) Moto  3) Camion");
        int tipo;
        try {
            tipo = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Tipo no valido.");
            return;
        }

        System.out.print("Marca: ");    String marca  = scanner.nextLine();
        System.out.print("Modelo: ");   String modelo = scanner.nextLine();
        System.out.print("Anio: ");     int anio      = Integer.parseInt(scanner.nextLine());
        System.out.print("Precio: ");   double precio = Double.parseDouble(scanner.nextLine());

        switch (tipo) {
            case 1 -> {
                System.out.print("Cantidad de puertas: ");
                int puertas = Integer.parseInt(scanner.nextLine());
                concesionaria.agregarVehiculo(new Auto(marca, modelo, anio, precio, puertas));
            }
            case 2 -> {
                System.out.print("Tipo de moto (deportiva/scooter/etc): ");
                String tipoMoto = scanner.nextLine();
                concesionaria.agregarVehiculo(new Moto(marca, modelo, anio, precio, tipoMoto));
            }
            case 3 -> {
                System.out.print("Capacidad de carga (tn): ");
                double carga = Double.parseDouble(scanner.nextLine());
                concesionaria.agregarVehiculo(new Camion(marca, modelo, anio, precio, carga));
            }
            default -> System.out.println("Tipo no valido.");
        }
    }

    private static void registrarCliente() {
        System.out.print("Nombre: ");   String nombre   = scanner.nextLine();
        System.out.print("Apellido: "); String apellido = scanner.nextLine();
        System.out.print("DNI: ");      int dni         = Integer.parseInt(scanner.nextLine());
        concesionaria.registrarCliente(new Cliente(nombre, apellido, dni));
    }

    private static void venderVehiculo() {
        System.out.print("Modelo del vehiculo a vender: ");
        String modelo = scanner.nextLine();
        System.out.print("DNI del cliente: ");
        int dni = Integer.parseInt(scanner.nextLine());
        concesionaria.venderVehiculo(modelo, dni);
    }

    private static void hacerTestDrive() {
        System.out.print("Modelo del vehiculo para test drive: ");
        String modelo = scanner.nextLine();
        concesionaria.hacerTestDrive(modelo);
    }
}
