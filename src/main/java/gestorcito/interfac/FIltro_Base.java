package gestorcito.interfac;

import java.util.List;
import gestorcito.objetos.Mensaje;
public interface FIltro_Base {
    List<Mensaje> aplicoFiltro(List <Mensaje>mensajes);
}


