public class EstadisticasReportes {

    private GestionPrestamos gestionPrestamos;

    public EstadisticasReportes(GestionPrestamos gestionPrestamos) {
        this.gestionPrestamos = gestionPrestamos;
    }

   
    public void mostrarPrestamosTotalesYActivos() {
        int prestamosTotales = gestionPrestamos.getContadorPrestamos();
        int prestamosActivos = prestamosTotales; 
if ((prestamosTotales>0 && prestamosActivos >0)|| (prestamosTotales==0 && prestamosActivos>0)|| (prestamosTotales >0 && prestamosActivos==0)){
    System.out.println("Número total de préstamos: " + prestamosTotales);
    System.out.println("Número de préstamos activos: " + prestamosActivos);
}else{
    System.out.println("Usted tiene 0 de ambos");
}  

      
}

   
    public void mostrarLibrosMasPrestados() {
        if (gestionPrestamos.getContadorPrestamos() == 0) {
            System.out.println("No hay préstamos registrados.");
        } else {
            GestionLibros[] librosContados = new GestionLibros[gestionPrestamos.getContadorPrestamos()];
            int contadorLibros = 0;
            int i = 0;
            while (i < gestionPrestamos.getContadorPrestamos()) {
                GestionLibros libro = gestionPrestamos.getPrestamos()[i].getLibro();
                
                boolean yaContado = false;
                int k = 0;
                while (k < contadorLibros && !yaContado) {
                    if (librosContados[k].equals(libro)) {
                        yaContado = true;
                    }
                    k++;
                }
                
                if (!yaContado) {
                    int contador = 0;
                    int j = 0;
                    while (j < gestionPrestamos.getContadorPrestamos()) {
                        if (gestionPrestamos.getPrestamos()[j].getLibro().equals(libro)) {
                            contador++;
                        }
                        j++;
                    }
                    librosContados[contadorLibros] = libro;
                    contadorLibros++;
                    System.out.println("Libro: " + libro.getNombreLibro() + " - Veces prestado: " + contador);
                }
                i++;
            }
        }
    }

   
    public void mostrarUsuarioConMasPrestamos() {
        int maxPrestamos = 0;
        String usuarioConMasPrestamos = "";

      
        for (int i = 0; i < gestionPrestamos.getContadorPrestamos(); i++) {
            String usuario = gestionPrestamos.getPrestamos()[i].getUsuario(); 
            int contador = 0;

      
            for (int j = 0; j < gestionPrestamos.getContadorPrestamos(); j++) {
                String usuarioAux = gestionPrestamos.getPrestamos()[j].getUsuario(); 
                if (usuarioAux.equals(usuario)) {
                    contador++;
                }
            }

          
            if (contador > maxPrestamos) {
                maxPrestamos = contador;
                usuarioConMasPrestamos = usuario;
            }
        }

        System.out.println("Usuario con más préstamos activos: " + usuarioConMasPrestamos + " - Préstamos activos: " + maxPrestamos);
    }
}
