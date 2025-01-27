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

    public static void menuPrincipal(){
        Scanner scanner = new Scanner(System.in);
        int opcionPrincipal;

        do{
            System.out.println("====Menu Genereal====");
            System.out.println("1. Gestion de Libro ");
            System.out.println("2. Gestion de Usuarios");
            System.out.println("3. Gestion de Prestamos");
            System.out.println("4. Estadisticas y Reportes");
            System.out.println("5. Salir");
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

    public void nuevousuario(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre del usuario");
        String usuario = scanner.nextLine();
        System.out.println("Introduce la contraseña del usuario elegido");
        String contraseña = scanner.nextLine();
        System.out.println("Introduce el dni");
        String dni = scanner.nextLine();
        if (dni.matches("^[0-9]{8}[A-Za-z]$")) {
            System.out.println("El DNI es válido.");
        } else {
            System.out.println("El DNI no es válido.");
            do {
                System.out.println("El dni no es valido, introducelo de nuevo");
                dni = scanner.nextLine();
                
            } while (!dni.matches("^[0-9]{8}[A-Za-z]$"));
        }


        GestionUsuarios u = new GestionUsuarios(usuario, contraseña, dni);

        scanner.close();
        
    }






}

      









    















    

