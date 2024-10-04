import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String[][] infoPlantas = new String[10][2];

    public static void main(String[] args) {
        menu();
        scanner.close();
    }

    public static void menu() {
        int opcion;
        do {
            mostrarMenu();
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            procesarOpcion(opcion);
        } while (opcion != 6);
    }

    public static void procesarOpcion(int opcion) {
        String nombre;

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el nombre de la planta: ");
                nombre = scanner.nextLine();
                registrarPlanta(infoPlantas, nombre);
                break;
            case 2:
                mostrarPlantas(infoPlantas);  // Pasar infoPlantas
                break;
            case 3:
                System.out.print("Ingrese el nombre de la planta a buscar: ");
                nombre = scanner.nextLine();
                buscarPlanta(infoPlantas, nombre);  // Pasar infoPlantas
                break;
            case 4:
                System.out.print("Ingrese el nombre de la planta a regar: ");
                nombre = scanner.nextLine();
                regarPlanta(infoPlantas, nombre);  // Pasar infoPlantas
                break;
            case 5:
                diaSiguiente(infoPlantas);  // Pasar infoPlantas
                break;
            case 6:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción inválida. Intente de nuevo.");
        }
    }



    public static void mostrarMenu() {
        System.out.println("\n1. Registrar planta");
        System.out.println("2. Mostrar plantas");
        System.out.println("3. Buscar planta");
        System.out.println("4. Regar planta");
        System.out.println("5. Avanzar un día");
        System.out.println("6. Salir\n");

    }

    public static void registrarPlanta(String[][] plantas, String nombre) {
        for (int i = 0; i < plantas.length; i++) {
            if (plantas[i][0] == null) {
                plantas[i][0] = nombre;
                plantas[i][1] = "0"; // Días sin regar comienza en 0
                System.out.println("Planta " + nombre + " registrada.");
                return;
            }
        }
        System.out.println("El jardín está lleno. No se pueden registrar más plantas.");
    }

    public static void mostrarPlantas(String[][] plantas) {
        System.out.println("\nPlantas en el jardín:");
        for (String[] planta : plantas) {
            if (planta[0] != null) {
                System.out.println("Planta: " + planta[0] + " - Días sin regar: " + planta[1]);
            }
        }
    }

    public static void buscarPlanta(String[][] plantas, String nombre) {
        for (String[] planta : plantas) {
            if (planta[0] != null && planta[0].equalsIgnoreCase(nombre)) {
                System.out.println("Planta encontrada: " + planta[0] + " - Días sin regar: " + planta[1]);
                return;
            }
        }
        System.out.println("Planta " + nombre + " no encontrada.");
    }

    public static void regarPlanta(String[][] plantas, String nombre) {
        for (int i = 0; i < plantas.length; i++) {
            if (plantas[i][0] != null && plantas[i][0].equalsIgnoreCase(nombre)) {
                plantas[i][1] = "0";
                System.out.println("La planta " + nombre + " ha sido regada.");
                return;
            }
        }
        System.out.println("Planta " + nombre + " no encontrada.");
    }

    public static void diaSiguiente(String[][] plantas) {
        for (int i = 0; i < plantas.length; i++) {
            if (plantas[i][0] != null) {
                int diasSinRegar = Integer.parseInt(plantas[i][1]);
                diasSinRegar++;
                if (diasSinRegar >= 5) {
                    System.out.println("La planta " + plantas[i][0] + " se ha secado y ha sido eliminada.");
                    plantas[i][0] = null;
                    plantas[i][1] = null;
                } else {
                    plantas[i][1] = String.valueOf(diasSinRegar);
                }
            }
        }
    }
}