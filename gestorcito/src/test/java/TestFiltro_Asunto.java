import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import gestorcito.filtros.Filtro_Asunto;
import gestorcito.interfac.FIltro_Base;
import gestorcito.objetos.Mensaje;
import gestorcito.objetos.Usuario;

public class TestFiltro_Asunto {
    @Test
    public void testFiltrarMensajesPorContenido() {
    
    // Crear usuarios
        Usuario usuario1 = new Usuario("Usuario1", "usuario1@gmail.com", "contrasenia1");
        Usuario usuario2 = new Usuario("Usuario2", "usuario2@gmail.com", "contrasenia2");
        Usuario usuario3 = new Usuario("Usuario3", "usuario3@gmail.com", "contrasenia3");

        // Crear mensajes dirigidos a distintos destinatarios
        Mensaje mensaje1 = new Mensaje(usuario1, usuario2, "Maradona", "Cr7");
        Mensaje mensaje2 = new Mensaje(usuario2, usuario1, "Asunto 2", "Contenido 2");
        Mensaje mensaje3 = new Mensaje(usuario1, usuario3, "Asunto 3", "Cr7");
        Mensaje mensaje4 = new Mensaje(usuario2, usuario1, "Maradona", "Contenido 4");

        // Crear una lista de mensajes
        List<Mensaje> mensajes = new ArrayList<>();
        mensajes.add(mensaje1);
        mensajes.add(mensaje2);
        mensajes.add(mensaje3);
        mensajes.add(mensaje4);

        // Crear un filtro de destinatario para buscar los mensajes dirigidos a usuario1
        FIltro_Base filtroContenido= new Filtro_Asunto("Maradona");

        // Aplicar el filtro
        List<Mensaje> mensajesFiltrados = filtroContenido.aplicoFiltro(mensajes);

        // Verificar que solo haya 2 mensajes en la lista resultante
        assertEquals(2, mensajesFiltrados.size());

        // Verificar que los mensajes sean los esperados
        assertTrue(mensajesFiltrados.contains(mensaje1));
        assertTrue(mensajesFiltrados.contains(mensaje4));

        
    }
}
