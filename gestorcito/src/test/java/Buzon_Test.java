import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import gestorcito.objetos.Buzon;
import gestorcito.objetos.Mensaje;
import gestorcito.objetos.Usuario;

public class Buzon_Test {
     @Test
    public void enviarMensajeConAsuntoVacio() {
        Usuario remitente = new Usuario("Remitente", "remitente@example.com", "contrasenia1");
        Usuario destinatario = new Usuario("Destinatario", "destinatario@example.com", "contrasenia2");

        Buzon buzon = new Buzon();
        String asuntoVacio = "";
        String contenido = "Hola, esto es un mensaje de prueba.";

        buzon.enviarMensaje(remitente, destinatario, asuntoVacio, contenido);

        List<Mensaje> mensajes = buzon.getMensajes();

        // Verificar que el asunto se haya establecido correctamente como "Sin asunto"
        assertEquals(1, mensajes.size());
        Mensaje mensaje = mensajes.get(0);
        assertEquals("Sin asunto", mensaje.getAsunto());
        assertEquals(remitente, mensaje.getRemitente());
        assertEquals(destinatario, mensaje.getDestinatario());
        assertEquals(contenido, mensaje.getContenido());
    }

    @Test
    public void enviarMensajeConAsuntoNoVacio() {
        Usuario remitente = new Usuario("Remitente", "remitente@example.com", "contrasenia1");
        Usuario destinatario = new Usuario("Destinatario", "destinatario@example.com", "contrasenia2");

        Buzon buzon = new Buzon();
        String asunto = "Prueba";
        String contenido = "Hola, esto es un mensaje de prueba.";

        buzon.enviarMensaje(remitente, destinatario, asunto, contenido);

        List<Mensaje> mensajes = buzon.getMensajes();

        // Verificar que el asunto se haya establecido correctamente
        assertEquals(1, mensajes.size());
        Mensaje mensaje = mensajes.get(0);
        assertEquals(asunto, mensaje.getAsunto());
        assertEquals(remitente, mensaje.getRemitente());
        assertEquals(destinatario, mensaje.getDestinatario());
        assertEquals(contenido, mensaje.getContenido());
    }
}
