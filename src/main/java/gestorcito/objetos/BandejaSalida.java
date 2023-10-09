package gestorcito.objetos;

import java.util.ArrayList;
import java.util.List;

public class BandejaSalida {
    private List<Mensaje> mensajes;

    public BandejaSalida(){
        mensajes= new ArrayList<>();
    }
    public void enviarMensaje(Mensaje mensaje){
    mensajes.add(mensaje);
    }
    public List<Mensaje> getMensajes() {
        return mensajes;
    }
}
