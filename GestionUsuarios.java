public class GestionUsuarios {
    
    public static Usuario[] usuarios = new Usuario[10]; 
    public static Usuario[] contraseñas = new Usuario[10]; 
    private int contador = 0; 

    private String usuario;
    private String contraseña;

    public GestionUsuarios(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public boolean verificarLogin(String usuario, String contraseña) {
        for (int i = 0; i < contador; i++) {
            if (usuarios[i].getUsuario().equals(usuario) && usuarios[i].getContraseña().equals(contraseña)) {
                System.out.println("Login exitoso.");
                return true;
            }
        }
        System.out.println("Usuario o contraseña incorrectos.");
        return false;
    }

    public void mostrarUsuarios() {
        for (int i = 0; i < contador; i++) {
            System.out.println(usuarios[i]);
        }
    }

    public void agregarUsuario(Usuario usuario, Usuario contraseña ) {
        if (contador < usuarios.length) {
            usuarios[contador] = usuario;
            contraseñas[contador] = contraseña;
            contador++; 
        } else {
            System.out.println("No hay espacio para más usuarios.");
        }
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void agregarUsuario(String usuario1, String contraseña1, String dni) {
        if (contador < usuarios.length) {
            usuarios[contador] = new Usuario(usuario1, contraseña1, dni); 
            contador++;
            System.out.println("Usuario agregado con éxito.");
        } else {
            System.out.println("No hay espacio para más usuarios.");
        }
    }
}

class Usuario {
    private String usuario;
    private String contraseña;
    private String dni;

    public Usuario(String usuario, String contraseña, String dni) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.dni = dni;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    @Override
    public String toString() {
        return "Usuario: " + usuario + ", DNI: " + dni;
    }
}
