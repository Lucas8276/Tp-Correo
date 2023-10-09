import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import gestorcito.filtros.Filtro_Contenido;
import gestorcito.interfac.FIltro_Base;
import gestorcito.objetos.Mensaje;
import gestorcito.objetos.Usuario;
public class TestFiltro {
    @Test
    public void testFiltrarMensajesPorAsunto() {
        FIltro_Base filtro = new Filtro_Contenido();

        Mensaje mensaje1=new Mensaje(new Usuario("Bob", "Elcapo", "Limado34"),
        new Usuario("Roberto","robertocarlo", "koala123"),"Asunto xd","hola@gmail.com");
        Mensaje mensaje2=new Mensaje(new Usuario("Pablo", "Elcapopablo", "Limado345"),
        new Usuario("Robert","robert25", "koala123"),"Asunto xd","cr7@gmail.com");
        Mensaje mensaje3=new Mensaje(new Usuario("Rambo", "Elcaporambo", "Limado34"),
        new Usuario("Melisa","meli", "koala1235"),"Asunto xd","maradona@gmail.com");
        List <Mensaje> mensajes= new ArrayList<>();
        mensajes.add(mensaje1);
        mensajes.add(mensaje2);
        mensajes.add(mensaje3);
        
        //Aplico Filtro
        List<Mensaje> mensajesFiltraditos= filtro.aplicoFiltro(mensajes);
        assertEquals(3,mensajesFiltraditos.size());
        assertTrue(mensajesFiltraditos.contains(mensaje1)); // Comprobar que el mensaje1 está en la lista filtrada.
        assertTrue(mensajesFiltraditos.contains(mensaje3)); // Comprobar que el mensaje3 está en la lista filtrada.
        assertTrue(mensajesFiltraditos.contains(mensaje2));
    }
}
