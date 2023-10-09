
import java.io.ByteArrayInputStream;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.*;
import gestorcito.objetos.Usuario;
public class UsuarioTest {
    @Test
    public void ObtenerCorreo(){
    //Establezco mi ejemplo 
    String entradaUsuario="rolanditopp@gmail.com\n";
    String nombre= "Rolo";
    String contra= "PerritoMalvado";
    
    Usuario u1 = new Usuario(nombre, nombre, contra);
    assertEquals(nombre,u1.getNombre());
    assertEquals(contra,u1.getContrasenia());

    
    }
}