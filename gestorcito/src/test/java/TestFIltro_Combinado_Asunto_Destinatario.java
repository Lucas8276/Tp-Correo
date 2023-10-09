import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import gestorcito.filtros.Filtro_Asunto;
import gestorcito.filtros.Filtro_Combinado_Destinatario_Asunto;
import gestorcito.filtros.Filtro_Destinatario;
import gestorcito.objetos.Mensaje;

public class TestFIltro_Combinado_Asunto_Destinatario {
    @Test
    public void testFiltrarMensajesPorAsuntoYContenido() {
        // Crear mensajes con diferentes asuntos y contenidos
        Mensaje mensaje1 = new Mensaje(null, null, "Vacaciones", "Plan para las vacaciones.");
        Mensaje mensaje2 = new Mensaje(null, null, "Trabajo", "Reunión importante en la oficina.");
        Mensaje mensaje3 = new Mensaje(null, null, "Vacaciones", "Compra de boletos para las vacaciones.");

        // Crear una lista de mensajes
        List<Mensaje> mensajes = new ArrayList<>();
        mensajes.add(mensaje1);
        mensajes.add(mensaje2);
        mensajes.add(mensaje3);

        // Crear filtros de asunto y contenido
        Filtro_Asunto filtro_Asunto = new Filtro_Asunto("Vacaciones");
        Filtro_Destinatario = new Filtro_Destinatario("Plan");

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
