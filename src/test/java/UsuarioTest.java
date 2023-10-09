
import java.io.ByteArrayInputStream;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.*;

import gestorcito.objetos.Mensaje;
import gestorcito.objetos.Usuario;
public class UsuarioTest {
    @Test
    public void enviarMensajeAVariosDestinatarios() {
        // Crear usuarios
        Usuario remitente = new Usuario("Remitente", "remitente@example.com", "contrasenia1");
        Usuario destinatario1 = new Usuario("Destinatario1", "destinatario1@example.com", "contrasenia2");
        Usuario destinatario2 = new Usuario("Destinatario2", "destinatario2@example.com", "contrasenia3");

        // Agregar usuarios a la lista de contactos del remitente
        remitente.agregarAContactos(destinatario1);
        remitente.agregarAContactos(destinatario2);

        // Enviar mensaje a varios destinatarios
        List<Usuario> destinatarios = new ArrayList<>();
        destinatarios.add(destinatario1);
        destinatarios.add(destinatario2);

        String asunto = "Prueba";
        String contenido = "Hola, esto es un mensaje de prueba.";

        remitente.enviarMensaje(destinatarios, asunto, contenido);

        // Verificar que el mensaje se envió correctamente
        List<Mensaje> bandejaEntradaDest1 = destinatario1.getBandejaEntrada().getMensajes();
        List<Mensaje> bandejaEntradaDest2 = destinatario2.getBandejaEntrada().getMensajes();

        assertEquals(1, bandejaEntradaDest1.size());
        assertEquals(1, bandejaEntradaDest2.size());

        Mensaje mensajeDest1 = bandejaEntradaDest1.get(0);
        Mensaje mensajeDest2 = bandejaEntradaDest2.get(0);

        assertEquals(remitente, mensajeDest1.getRemitente());
        assertEquals(remitente, mensajeDest2.getRemitente());
        assertEquals(destinatario1, mensajeDest1.getDestinatario());
        assertEquals(destinatario2, mensajeDest2.getDestinatario());
        assertEquals(asunto, mensajeDest1.getAsunto());
        assertEquals(asunto, mensajeDest2.getAsunto());
        assertEquals(contenido, mensajeDest1.getContenido());
        assertEquals(contenido, mensajeDest2.getContenido());
    }

    

    @Test
    public void testCrearCorreo() {
        Usuario usuario = new Usuario("UsuarioPrueba", "", "contrasenia");

        // Simular entrada de usuario para la dirección de correo
        String input = "correo@example.com\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        usuario.crear_correo();

        // Verificar que la dirección de correo se haya establecido correctamente
        assertEquals("correo@example.com", usuario.getDireccion_Corrreo());
    }

    @Test
    public void testCrearNombre() {
        Usuario usuario = new Usuario("", "correo@example.com", "contrasenia");

        // Simular entrada de usuario para el nombre
        String input = "UsuarioNuevo\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        usuario.crear_nombre();

        // Verificar que el nombre se haya establecido correctamente
        assertEquals("UsuarioNuevo", usuario.getNombre());
    }

    @Test
    public void testSetDireccionCorreo() {
        Usuario usuario = new Usuario("UsuarioPrueba", "correo@example.com", "contrasenia");

        usuario.setDireccion_Correo("correo_nuevo@example.com");

        // Verificar que la dirección de correo se haya establecido correctamente
        assertEquals("correo_nuevo@example.com", usuario.getDireccion_Corrreo());
    }

    @Test
    public void testSetNombre() {
        Usuario usuario = new Usuario("UsuarioPrueba", "correo@example.com", "contrasenia");

        usuario.setNombre("NuevoNombre");

        // Verificar que el nombre se haya establecido correctamente
        assertEquals("NuevoNombre", usuario.getNombre());
    }

    @Test
    public void testSetContrasenia() {
        Usuario usuario = new Usuario("UsuarioPrueba", "correo@example.com", "contraseniaAntigua");

        usuario.setContrasenia("contraseniaNueva");

        // Verificar que la contraseña se haya establecido correctamente
        assertEquals("contraseniaNueva", usuario.getContrasenia());
    }
    

    }

