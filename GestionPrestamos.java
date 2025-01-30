import java.util.Arrays;

public class GestionPrestamos {
    private LibroPrestado[] prestamos;
    private int contadorPrestamos;

    public GestionPrestamos(int capacidadInicial) {
        prestamos = new LibroPrestado[capacidadInicial];
        contadorPrestamos = 0;
    }
    public GestionPrestamos(GestionLibros gestionLibros, int capacidadInicial) {
 
        this.prestamos = new LibroPrestado[capacidadInicial];
        this.contadorPrestamos = 0;
    }
    public void mostrarLibrosPrestados() {
        if (contadorPrestamos == 0) {
            System.out.println("No hay libros prestados.");
        } else {
            for (int i = 0; i < contadorPrestamos; i++) {
                System.out.println(prestamos[i]);
            }
        }
    }

    public void realizarPrestamo(String usuario, GestionLibros libro) {
 
        if (contadorPrestamos >= prestamos.length) {
            aumentarCapacidad();
        }

     
        if (libro != null && !esLibroPrestado(libro)) {
            prestamos[contadorPrestamos] = new LibroPrestado(usuario, libro);
            contadorPrestamos++;
            System.out.println("Libro prestado a: " + usuario);
        } else {
            System.out.println("No se pudo realizar el préstamo, el libro ya está prestado o es inválido.");
        }
    }

    private boolean esLibroPrestado(GestionLibros libro) {
        for (int i = 0; i < contadorPrestamos; i++) {
            if (prestamos[i].getLibro().equals(libro)) {
                return true;
            }
        }
        return false;
    }

    public void devolverLibro(GestionLibros libro) {
        boolean libroEncontrado = false;
        for (int i = 0; i < contadorPrestamos; i++) {
            if (prestamos[i].getLibro().equals(libro)) {
                for (int j = i; j < contadorPrestamos - 1; j++) {
                    prestamos[j] = prestamos[j + 1];
                }
                contadorPrestamos--;
                libroEncontrado = true;
                System.out.println("Libro devuelto: " + libro.getNombreLibro());
                break;
            }
        }
        if (!libroEncontrado) {
            System.out.println("El libro no está prestado.");
        }
    }


    public void mostrarLibrosDisponibles(GestionLibros[] libros) {
        boolean hayLibrosDisponibles = false;
    
     
        for (int i = 0; i < libros.length; i++) {
            if (libros[i] != null) {
                boolean libroPrestado = false;
    
                for (int j = 0; j < contadorPrestamos; j++) {
                    if (prestamos[j].getLibro().getISBN() == libros[i].getISBN()) {
                        libroPrestado = true;
                        break; 
                    }
                }
    
                if (!libroPrestado) {
                    System.out.println(libros[i]); 
                    hayLibrosDisponibles = true;
                }
            }
        }
    
        if (!hayLibrosDisponibles) {
            System.out.println("No hay libros disponibles para mostrar.");
        }
    }
    
    
    
    public GestionLibros buscarLibroPorISBN(int isbn) {
        for (int i = 0; i < contadorPrestamos; i++) {
            if (prestamos[i].getLibro().getISBN() == isbn) {
                return prestamos[i].getLibro(); 
            }
        }
        return null; 
    }

   private void aumentarCapacidad() {

    prestamos = Arrays.copyOf(prestamos, prestamos.length * 2);
}

    public static class LibroPrestado {
        private String usuario;
        private GestionLibros libro;

        public LibroPrestado(String usuario, GestionLibros libro) {
            this.usuario = usuario;
            this.libro = libro;
        }

        public GestionLibros getLibro() {
            return libro;
        }

        public String getUsuario() {
            return usuario;
        }

        @Override
        public String toString() {
            return "Libro: " + libro.getNombreLibro() + " - Usuario: " + usuario;
        }
    }

    public LibroPrestado[] getPrestamos() {
        return this.prestamos;
    }

    public void setPrestamos(LibroPrestado[] prestamos) {
        this.prestamos = prestamos;
    }

    public int getContadorPrestamos() {
        return this.contadorPrestamos;
    }

    public void setContadorPrestamos(int contadorPrestamos) {
        this.contadorPrestamos = contadorPrestamos;
    }

}
