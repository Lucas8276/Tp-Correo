import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import gestorcito.objetos.BandejaEntrada;
import gestorcito.objetos.Mensaje;
import gestorcito.objetos.Usuario;

public class Bandeja_Entrada_Test {
     @Test
    public void recibirMensaje() {
        Usuario remitente = new Usuario("Remitente", "remitente@example.com", "contrasenia1");
        Usuario destinatario = new Usuario("Destinatario", "destinatario@example.com", "contrasenia2");

        Mensaje mensaje = new Mensaje(remitente, destinatario, "Prueba", "Hola, esto es un mensaje de prueba.");

        BandejaEntrada bandejaEntrada = new BandejaEntrada();
        bandejaEntrada.recibirMensaje(mensaje);

        List<Mensaje> mensajes = bandejaEntrada.getMensajes();

        // Verificar que el mensaje se haya recibido y agregado correctamente
        assertEquals(1, mensajes.size());
        assertEquals(mensaje, mensajes.get(0));
    }
}
