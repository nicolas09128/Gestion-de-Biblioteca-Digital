public class GestionUsuarios {
   private String usuario;
   private String contraseña;
   private String dni;

   public GestionUsuarios(String usuario, String contraseña,  String dni){
    this.usuario = usuario;
    this.contraseña = contraseña;
    this.dni = dni;
   }
   public String getusuario(){
    return this.usuario;


   }

   public void setusuario(String usuario){
    this.usuario = usuario;
    
   }

   public String getcontraseña(){
    return this.contraseña;


   }

   public void setcontraseña(String contraseña){
    this.contraseña = contraseña;
    
   }

   public String getdni(){
    return this.dni;


   }

   public void setdni(String dni){
    this.dni = dni;
    
   }

  



    
}
