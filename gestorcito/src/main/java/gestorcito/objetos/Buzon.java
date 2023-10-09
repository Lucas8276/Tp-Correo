
package gestorcito.objetos;

import java.util.ArrayList;
import java.util.List;

public class Buzon {
    private List<Mensaje> mensajes;
    public Buzon(){
        mensajes= new ArrayList<>();
    }
    
    public void enviarMensaje(Usuario remitente, Usuario destinatario,String asunto,String contenido){
    //Aca hago lo mismo si asunto no tiene nada
        if(asunto== null || asunto.isEmpty()){
        asunto="Sin asunto";
    }
        Mensaje mensaje_usuario= new Mensaje(remitente,destinatario,asunto,contenido);
    mensajes.add(mensaje_usuario);
    }
    public List<Mensaje> getMensajes(){
        return mensajes;
    }
}
