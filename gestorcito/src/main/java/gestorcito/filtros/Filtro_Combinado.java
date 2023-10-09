package gestorcito.filtros;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import gestorcito.interfac.FIltro_Base;
import gestorcito.objetos.Mensaje;

public class Filtro_Combinado implements FIltro_Base {
    private String criterioAsunto;
    private String criterioContenido;

    public Filtro_Combinado(String criterioAsunto,String criterioContenido){
        this.criterioAsunto=criterioAsunto;
        this.criterioContenido=criterioContenido;
    }
    @Override
    public List<Mensaje> aplicoFiltro(List <Mensaje> mensajes){
    return mensajes.stream()
            .filter(mensaje->cumpleCriterios(mensaje))
            .collect(Collectors.toList());
        }
        private boolean cumpleCriterios(Mensaje mensaje) {
            boolean cumpleAsunto = true;
            boolean cumpleContenido = true;
    
            if (criterioAsunto != null && !criterioAsunto.isEmpty()) {
                cumpleAsunto = mensaje.getAsunto().contains(criterioAsunto);
            }
            if (criterioContenido != null && !criterioContenido.isEmpty()) {
                cumpleContenido = mensaje.getContenido().contains(criterioContenido);
            }
            return cumpleAsunto && cumpleContenido;
        }
    }
        


