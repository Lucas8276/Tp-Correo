package gestorcito.filtros;

import java.util.List;
import java.util.stream.Collectors;

import gestorcito.interfac.FIltro_Base;
import gestorcito.objetos.Mensaje;

public class Filtro_Combinado_Destinatario_Asunto implements FIltro_Base {
    private Filtro_Asunto filtro_Asunto;
    private Filtro_Destinatario filtro_Destinatario;

    public Filtro_Combinado_Destinatario_Asunto(Filtro_Asunto filtro_Asunto,Filtro_Destinatario filtro_Destinatario){
        this.filtro_Asunto=filtro_Asunto;
        this.filtro_Destinatario=filtro_Destinatario;
    }

    @Override
    public List<Mensaje> aplicoFiltro(List <Mensaje> mensajes){
        List<Mensaje> mensajesFiltradoAsunto=filtro_Asunto.aplicoFiltro(mensajes);
        return filtro_Destinatario.aplicoFiltro(mensajesFiltradoAsunto);
        }
        }

