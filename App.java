import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcionPrincipal;

        do{
            System.out.println("====Biblioteca====");
            System.out.println("1. Usuario ");
            System.out.println("2. Administrador");
            System.out.println("3. Salir");
            System.out.println("Elija una opcion");
            opcionPrincipal = scanner.nextInt(); 

            switch (opcionPrincipal) {
                case 1:
                    menuUsarioNormal(scanner);
                    break;
                case 2:
                    menuAdministrador(scanner);
                    break;
                case 3:
                    System.out.println("¡Gracias por usar la biblioteca, que tengas un buen dia!.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcionPrincipal != 3);

        scanner.close();
    }

        public static void menuUsarioNormal(Scanner scanner){
            int opcion;
            do{
                System.out.println("\n--- Menú Usuario Normal ---");
                System.out.println("1. Buscar libro");
                System.out.println("2. Ver libros prestados");
                System.out.println("3. Volver al menú principal");
                System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Buscando libros... (Aquí iría la lógica para buscar libros)");
                    break;
                case 2:
                    System.out.println("Mostrando libros prestados... (Aquí iría la lógica para mostrar libros prestados)");
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 3);
    }

    public static void menuAdministrador(Scanner scanner){
        int opcion;

        do{
            System.out.println("\n--- Menú Administrador ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Ver usuarios registrados");
            System.out.println("4. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Agregando un libro... (Aquí iría la lógica para agregar libros)");
                    break;
                case 2:
                    System.out.println("Eliminando un libro... (Aquí iría la lógica para eliminar libros)");
                    break;
                case 3:
                    System.out.println("Mostrando usuarios registrados... (Aquí iría la lógica para mostrar usuarios)");
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 4);
    }
}

      









    















    

