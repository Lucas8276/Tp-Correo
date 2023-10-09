package gestorcito.objetos;


import java.util.List;
import java.util.Scanner;

public class Usuario{
    private String nombre;
    private String contrasenia;
    private BandejaEntrada bandejaEntrada;
    private BandejaSalida bandejaSalida;
    private String direccion_correo;
    private Contacto contactos;


    public Usuario(String nombre,String direccion_correo,String contrasenia){
    this.nombre=nombre;
    this.direccion_correo=direccion_correo;
    this.contrasenia= contrasenia;
    this.bandejaEntrada=new BandejaEntrada();
    this.bandejaSalida=new BandejaSalida();
    this.contactos= new Contacto();
    }
    
    public String getDireccion_Corrreo(){
        return direccion_correo;
     }
    
    public BandejaEntrada getBandejaEntrada(){
    return bandejaEntrada;
    }
    public BandejaSalida getBandejaSalida(){
    return bandejaSalida;
    }
    public String getNombre() {
        return nombre;
    }
    public void setDireccion_Correo(String direccion_correo){
        this.direccion_correo= direccion_correo;
     }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void enviarMensaje(List<Usuario>destinatarios,String asunto,String contenido ){
        //Aca hago lo mismo si asunto no tiene nada
        if(asunto== null || asunto.isEmpty()){
            asunto="Sin asunto";
        }

        for(Usuario destinatario: destinatarios){
            Mensaje mensaje= new Mensaje(this, destinatario, asunto, contenido);
            destinatario.getBandejaEntrada().recibirMensaje(mensaje);
            this.getBandejaSalida().enviarMensaje(mensaje);
        }
    }

    public void agregarAContactos(Usuario contacto){
    contactos.agrego_Usuario(contacto);
    }

    public void crear_correo(){
        Scanner escaneado= new Scanner(System.in);
        System.out.print("Ingrese la direccion de correo electronico" );
        String tomadeentrada = escaneado.nextLine();
        setDireccion_Correo(tomadeentrada);
        escaneado.close();
        }

    public void crear_nombre(){
    Scanner escaneado= new Scanner(System.in);
    System.out.print("Ingrese su nombre" );
    String tomadeentrada = escaneado.nextLine();
    this.nombre= tomadeentrada;
    escaneado.close();
    }
    
}
