package gestorcito.filtros;

import java.util.List;

import gestorcito.interfac.FIltro_Base;
import gestorcito.objetos.Mensaje;

public class Filtro_Destinatario_Asunto_Contenido implements FIltro_Base{
    private Filtro_Combinado_Destinatario_Asunto filtro_Combinado_Destinatario_Asunto;
    private Filtro_Contenido filtro_Contenido;

    public Filtro_Destinatario_Asunto_Contenido(Filtro_Combinado_Destinatario_Asunto filtro_Combinado_Destinatario_Asunto,Filtro_Contenido filtro_Contenido){
        this.filtro_Combinado_Destinatario_Asunto=filtro_Combinado_Destinatario_Asunto;
        this.filtro_Contenido=filtro_Contenido;
    }

    @Override
     public List<Mensaje> aplicoFiltro(List<Mensaje> mensajes) {
        List<Mensaje> mensajesFiltradosPorCombinado = filtro_Combinado_Destinatario_Asunto.aplicoFiltro(mensajes);
        return filtro_Contenido.aplicoFiltro(mensajesFiltradosPorCombinado);
     }
    
}
