import java.util.Scanner;

public class App {
    public static GestionUsuarios gestionUsuarios = new GestionUsuarios(null, null);
    public static GestionLibros gestionLibros = new GestionLibros(10);
    public static GestionPrestamos gestionPrestamos = new GestionPrestamos(gestionLibros, 10); // Cambia la capacidad inicial a 10
    public static EstadisticasReportes estadisticasReportes = new EstadisticasReportes(gestionPrestamos);
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcionPrincipal;

        // Crear usuarios
        gestionUsuarios.agregarUsuario(new Usuario("admin",  "admin123", "12345678A"), null);
        gestionUsuarios.agregarUsuario(new Usuario("usuario", "usuario123", "87654321B"), null);

        // Crear libros
        gestionLibros.agregarlibro("Harry Potter", Genero.AVENTURA, 123456, "J.K. Rowling");
        gestionLibros.agregarlibro("Dracula", Genero.TERROR, 654321, "Bram Stoker");

        do {
            System.out.println("====Biblioteca====");
            System.out.println("1. Iniciar sesión como Usuario");
            System.out.println("2. Iniciar sesión como Administrador");
            System.out.println("3. Salir");
            System.out.println("Elija una opción: ");
            opcionPrincipal = scanner.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    if (login(scanner)) {
                        menuUsuarioNormal(scanner);
                    }
                    break;
                case 2:
                    if (login(scanner)) {
                        menuAdministrador(scanner);
                    }
                    break;
                case 3:
                    System.out.println("¡Gracias por usar la biblioteca, que tengas un buen día!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcionPrincipal != 3);

        scanner.close();
    }

    public static boolean login(Scanner scanner) {
        System.out.print("Introduce tu nombre de usuario: ");
        String usuario = scanner.next();
        System.out.print("Introduce tu contraseña: ");
        String contraseña = scanner.next();

        return gestionUsuarios.verificarLogin(usuario, contraseña);
    }

    public static void menuUsuarioNormal(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Menú Usuario Normal ---");
            System.out.println("1. Buscar libro");
            System.out.println("2. Realizar prestamo:");
            System.out.println("3. Ver libros disponibles");
            System.out.println("4. Devolver libro prestado");
            System.out.println("5. Volver al menú principal");
            System.out.println("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    gestionLibros.buscarLibro(scanner);
                    break;
                case 2:
                System.out.print("Introduce tu nombre de usuario: ");
                String usuario = scanner.next();  
                System.out.print("Introduce el ISBN del libro que deseas pedir prestado: ");
                int isbn = scanner.nextInt();
            
                // Buscar el libro por ISBN
                GestionLibros libro = null;
                for (int i = 0; i < gestionLibros.getLibros().length; i++) {  
                    if (gestionLibros.getLibros()[i] != null && gestionLibros.getLibros()[i].getISBN() == isbn) {  
                        libro = gestionLibros.getLibros()[i];  
                         
                    }
                }
            
                if (libro != null) {
                    gestionPrestamos.realizarPrestamo(usuario, libro); 
                    System.out.println("Préstamo realizado con éxito.");
                } else {
                    System.out.println("No se encontró el libro con ese ISBN.");
                }
                break;
                case 3:
                gestionPrestamos.mostrarLibrosDisponibles(gestionLibros.getLibros());
                    break;
                case 4:
                System.out.print("Introduce el ISBN del libro a devolver: ");
                isbn = scanner.nextInt();
                GestionLibros libroADevolver = gestionPrestamos.buscarLibroPorISBN(isbn); 
                if (libroADevolver != null) {
                    gestionPrestamos.devolverLibro(libroADevolver);
                } else {
                    System.out.println("No se encontró el libro con ese ISBN.");
                }
                break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 5);
    }

    public static void menuAdministrador(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Menú Administrador ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Añadir un nuevo usuario");
            System.out.println("4. Ver usuarios registrados");
            System.out.println("5. Mostrar libros actualmente prestados");
            System.out.println("6.Mostrar número de préstamos totales y activos.");
            System.out.println("7.Listar los libros más prestados.");
            System.out.println("8.Mostrar qué usuario tiene más préstamos activos.");
            System.out.println("9. Volver al menú principal");
            System.out.println("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    gestionLibros.agregarLibroConScanner(scanner);
                    break;
                case 2:
                scanner.nextLine();
                    gestionLibros.eliminarLibro(scanner);
                    break;
                case 3:
                    System.out.println("Digame su nombre de usuario:");
                    scanner.next();
                    String usuario1 = scanner.nextLine();
                    System.out.println("Ahora toca la contraseña:");
                    String contraseña1 = scanner.nextLine();
                    System.out.println("Ahora toca el DNI:");
                    String dni = scanner.nextLine();
                    gestionUsuarios.agregarUsuario(usuario1, contraseña1, dni);
                    break;
                case 4:
                    gestionUsuarios.mostrarUsuarios();
                    break;
                case 5:
                gestionPrestamos.mostrarLibrosPrestados();
                break;
                case 6:
                    estadisticasReportes.mostrarPrestamosTotalesYActivos();
                    break;
                case 7:
                     estadisticasReportes.mostrarLibrosMasPrestados();
                     break;
                case 8:
                    estadisticasReportes.mostrarUsuarioConMasPrestamos();
                    break;
                case 9:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 9);
    }
}