package gestorcito.filtros;

import java.util.List;
import java.util.stream.Collectors;

import gestorcito.interfac.FIltro_Base;
import gestorcito.objetos.Mensaje;

public class Filtro_Destinatario implements FIltro_Base{
    private String destinatario;
    public Filtro_Destinatario(String destinatario){
    this.destinatario= destinatario;
    }

    @Override
    public List<Mensaje>aplicoFiltro (List <Mensaje> mensajes){
        return mensajes.stream()
                .filter(mensaje->mensaje.getDestinatario().getDireccion_Corrreo().contains(destinatario))// despues del contains puedo poner lo que quisiera que busque
                .collect(Collectors.toList());
    }
}
