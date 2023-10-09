package gestorcito.filtros;

import java.util.List;
import java.util.stream.Collectors;

import gestorcito.interfac.FIltro_Base;
import gestorcito.objetos.Mensaje;

public class Filtro_Asunto implements FIltro_Base{
    private String asunto;
    public Filtro_Asunto(String asunto){
        this.asunto= asunto;
        }
@Override
public List<Mensaje>aplicoFiltro (List <Mensaje> mensajes){
    return mensajes.stream()
                    .filter(mensaje->mensaje.getAsunto().contains(asunto))// despues del contains puedo poner lo que quisiera que busque
                    .collect(Collectors.toList());
                                }

}
