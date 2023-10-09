package gestorcito.filtros;
import java.util.stream.Collectors;

import java.util.List;

import gestorcito.interfac.FIltro_Base;
import gestorcito.objetos.Mensaje;

public class Filtro_Contenido implements FIltro_Base {  
    private String contenido;
    public Filtro_Contenido(String contenido){
        this.contenido= contenido;
        }
@Override
public List<Mensaje>aplicoFiltro (List <Mensaje> mensajes){
    return mensajes.stream()
                    .filter(mensaje->mensaje.getContenido().contains(contenido))// despues del contains puedo poner lo que quisiera que busque
                    .collect(Collectors.toList());
                                }

}
