import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gestorcito.objetos.Mensaje;
import gestorcito.objetos.Usuario;

public class Mensaje_Test {
    @Test
    public void crearMensajeConAsuntoVacio() {
        Usuario remitente = new Usuario("Remitente", "remitente@example.com", "contrasenia1");
        Usuario destinatario = new Usuario("Destinatario", "destinatario@example.com", "contrasenia2");

        String asuntoVacio = "";
        String contenido = "Hola, esto es un mensaje de prueba.";

        Mensaje mensaje = new Mensaje(remitente, destinatario, asuntoVacio, contenido);

        // Verificar que el asunto se haya establecido correctamente como "Sin asunto"
        assertEquals("Sin asunto", mensaje.getAsunto());
        assertEquals(remitente, mensaje.getRemitente());
        assertEquals(destinatario, mensaje.getDestinatario());
        assertEquals(contenido, mensaje.getContenido());
    }

    @Test
    public void crearMensajeConAsuntoNoVacio() {
        Usuario remitente = new Usuario("Remitente", "remitente@example.com", "contrasenia1");
        Usuario destinatario = new Usuario("Destinatario", "destinatario@example.com", "contrasenia2");

        String asunto = "Prueba";
        String contenido = "Hola, esto es un mensaje de prueba.";

        Mensaje mensaje = new Mensaje(remitente, destinatario, asunto, contenido);

        // Verificar que el asunto se haya establecido correctamente
        assertEquals(asunto, mensaje.getAsunto());
        assertEquals(remitente, mensaje.getRemitente());
        assertEquals(destinatario, mensaje.getDestinatario());
        assertEquals(contenido, mensaje.getContenido());
    }

}
