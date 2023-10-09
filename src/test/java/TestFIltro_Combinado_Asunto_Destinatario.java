import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import gestorcito.filtros.Filtro_Asunto;
import gestorcito.filtros.Filtro_Combinado_Destinatario_Asunto;
import gestorcito.filtros.Filtro_Destinatario;
import gestorcito.objetos.Mensaje;
import gestorcito.objetos.Usuario;

public class TestFIltro_Combinado_Asunto_Destinatario {
    @Test
    public void testFiltrarMensajesPorAsuntoYContenido() {
        // Crear usuarios
        Usuario usuario1 = new Usuario("Usuario1", "usuario1@gmail.com", "contrasenia1");
        Usuario usuario2 = new Usuario("Usuario2", "Plan@gmail.com", "contrasenia2");
        Usuario usuario3 = new Usuario("Usuario3", "usuario3@gmail.com", "contrasenia3");

        // Crear mensajes dirigidos a distintos destinatarios
        Mensaje mensaje1 = new Mensaje(usuario1, usuario2, "Vacaciones", "Contenido 1");
        Mensaje mensaje2 = new Mensaje(usuario2, usuario1, "Asunto 2", "Contenido 2");
        Mensaje mensaje3 = new Mensaje(usuario1, usuario3, "Asunto 3", "Contenido 3");
        Mensaje mensaje4 = new Mensaje(usuario2, usuario1, "Asunto 4", "Contenido 4");

        List<Mensaje> mensajes = new ArrayList<>();
        mensajes.add(mensaje1);
        mensajes.add(mensaje2);
        mensajes.add(mensaje3);
        mensajes.add(mensaje4);

        // Crear filtros de asunto y contenido
        Filtro_Asunto filtro_Asunto = new Filtro_Asunto("Vacaciones");
        Filtro_Destinatario filtro_Destinatario= new Filtro_Destinatario("Plan@gmail.com");

        // Crear un filtro combinado para buscar mensajes con asunto "Vacaciones" y contenido "Plan"
        Filtro_Combinado_Destinatario_Asunto filtroCombinado = new Filtro_Combinado_Destinatario_Asunto(filtro_Asunto,filtro_Destinatario);

        // Aplicar el filtro combinado
        List<Mensaje> mensajesFiltrados = filtroCombinado.aplicoFiltro(mensajes);

        // Verificar que solo haya 1 mensaje en la lista resultante
        assertEquals(1, mensajesFiltrados.size());

        // Verificar que el mensaje1 sea el esperado
        assertTrue(mensajesFiltrados.contains(mensaje1));
    }
}
