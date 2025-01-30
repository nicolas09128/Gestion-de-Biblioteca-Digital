public class Libro {
    private String nombreLibro;
    private String nombreAutor;
    private Genero genero;
    private int isbn;

    public Libro(String nombreLibro, String nombreAutor, Genero genero, int isbn) {
        this.nombreLibro = nombreLibro;
        this.nombreAutor = nombreAutor;
        this.genero = genero;
        this.isbn = isbn;
    }

    public Libro(String nombre, Genero genero, int isbn, String autor) {
        this.nombreLibro = nombre;
        this.genero = genero;
        this.isbn = isbn;
        this.nombreAutor = autor;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public Genero getGenero() {
        return genero;
    }

    public int getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Título: " + nombreLibro + ", Autor: " + nombreAutor + ", Género: " + genero + ", ISBN: " + isbn;
    }
}
