import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import gestorcito.filtros.Filtro_Combinado;
import gestorcito.interfac.FIltro_Base;
import gestorcito.objetos.Mensaje;

public class TestFiltro_Combinado {
     @Test
    public void testFiltrarMensajesPorAsuntoYContenido() {
        // Crear mensajes con diferentes asuntos y contenidos
        Mensaje mensaje1 = new Mensaje(null, null, "Vacaciones", "Hola, estoy planeando mis vacaciones.");
        Mensaje mensaje2 = new Mensaje(null, null, "Trabajo", "Reunión importante en la oficina.");
        Mensaje mensaje3 = new Mensaje(null, null, "Ventas", "Informe de ventas del último trimestre.");

        // Crear una lista de mensajes
        List<Mensaje> mensajes = new ArrayList<>();
        mensajes.add(mensaje1);
        mensajes.add(mensaje2);
        mensajes.add(mensaje3);

        // Crear un filtro combinado para buscar mensajes con asunto "Vacaciones" y contenido "plan"
        FIltro_Base filtroCombinado = new Filtro_Combinado("Vacaciones", "plan");

        // Aplicar el filtro
        List<Mensaje> mensajesFiltrados = filtroCombinado.aplicoFiltro(mensajes);

        // Verificar que solo haya 1 mensaje en la lista resultante
        assertEquals(1, mensajesFiltrados.size());

        // Verificar que el mensaje1 sea el esperado
        assertTrue(mensajesFiltrados.contains(mensaje1));
    }
}
