import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import gestorcito.objetos.BandejaSalida;
import gestorcito.objetos.Mensaje;
import gestorcito.objetos.Usuario;

public class Bandeja_Salida_Test {
    @Test
    public void enviarMensaje() {
        Usuario remitente = new Usuario("Remitente", "remitente@example.com", "contrasenia1");
        Usuario destinatario = new Usuario("Destinatario", "destinatario@example.com", "contrasenia2");

        Mensaje mensaje = new Mensaje(remitente, destinatario, "Prueba", "Hola, esto es un mensaje de prueba.");

        BandejaSalida bandejaSalida = new BandejaSalida();
        bandejaSalida.enviarMensaje(mensaje);

        List<Mensaje> mensajes = bandejaSalida.getMensajes();

        // Verificar que el mensaje se haya agregado correctamente
        assertEquals(1, mensajes.size());
        assertEquals(mensaje, mensajes.get(0));
    }
}
