import java.util.Scanner;

public class GestionLibros {
    private GestionLibros[] libros;
        private static int contadorLibros = 0;
        private String NombreLibro;
        private Genero genero;
        private int ISBN;
        private String NombreAutor;
    
        public GestionLibros[] getLibros() {
            return libros;
        }   
    public GestionLibros(int capacidad) {
        libros = new GestionLibros[capacidad];
        contadorLibros = 0;
    }

    public GestionLibros(String NombreLibro, Genero genero, int ISBN, String NombreAutor) {
        this.NombreLibro = NombreLibro;
        this.genero = genero;
        this.ISBN = ISBN;
        this.NombreAutor = NombreAutor;
    }

    public String getNombreLibro() {
        return this.NombreLibro;
    }

    public void setNombreLibro(String NombreLibro) {
        this.NombreLibro = NombreLibro;
    }

    public Genero getGenero() {
        return this.genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getISBN() {
        return this.ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getNombreAutor() {
        return this.NombreAutor;
    }

    public void setNombreAutor(String NombreAutor) {
        this.NombreAutor = NombreAutor;
    }
    @Override
    public String toString() {
        return "Título: " + NombreLibro + ", Autor: " + NombreAutor + ", ISBN: " + ISBN;
    }

    public void agregarlibro(String nombre, Genero genero, int isbn, String autor) {
        if (contadorLibros == libros.length) {
            aumentarCapacidad(); 
        }
        libros[contadorLibros] = new GestionLibros(nombre, genero, isbn, autor);
        contadorLibros++;
        System.out.println("Libro agregado con éxito.");
    }
    public void agregarLibroConScanner(Scanner scanner) {
        System.out.print("Introduce el nombre del libro: ");
        String nombre = scanner.next();
        System.out.print("Introduce el género del libro (Aventura, Comedia, Terror, Misterio): ");
        String generoStr = scanner.next().toUpperCase(); 
        Genero genero = Genero.valueOf(generoStr);
        System.out.print("Introduce el ISBN del libro: ");
        int isbn = scanner.nextInt();
        System.out.print("Introduce el autor del libro: ");
        String autor = scanner.next();

        agregarlibro(nombre, genero, isbn, autor);
    }
  
    public void eliminarLibro(Scanner scanner) {
        System.out.print("Introduce el ISBN del libro a eliminar: ");
        int isbn = scanner.nextInt();

        for (int i = 0; i < contadorLibros; i++) {
            if (libros[i].getISBN() == isbn) {
                
                for (int j = i; j < contadorLibros - 1; j++) {
                    libros[j] = libros[j + 1];
                }
                libros[contadorLibros - 1] = null;
                contadorLibros--;
                System.out.println("Libro eliminado con éxito.");
                return;
            }
        }
        System.out.println("No se encontró el libro con ese ISBN.");
    }

    // Buscar libro
    public void buscarLibro(Scanner scanner) {
        System.out.print("Introduce el título, autor o categoría para buscar: ");
        scanner.nextLine(); 
        String busqueda = scanner.nextLine();  
        boolean encontrado = false;
    
        for (int i = 0; i < contadorLibros; i++) {
            GestionLibros libro = libros[i]; 
            String textoBusqueda = libro.getNombreLibro() + " " + libro.getNombreAutor() + " " + libro.getGenero().name();
            if (textoBusqueda.toLowerCase().contains(busqueda.toLowerCase())) {
                System.out.println(libro); 
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron resultados para la búsqueda.");
        }
    }

   
    public void mostrarLibros() {
        boolean hayLibros = false;
        if (contadorLibros == 0) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            for (int i = 0; i < contadorLibros; i++) {
                System.out.println(libros[i]);
                hayLibros = true;
            }
        }
    
        if (!hayLibros) {
            System.out.println("No se encontraron libros para mostrar.");
        }
    }

    
    private void aumentarCapacidad() {
     
        GestionLibros[] librosTemp = new GestionLibros[libros.length * 2];
        System.arraycopy(libros, 0, librosTemp, 0, libros.length);
        libros = librosTemp;
    }
}
