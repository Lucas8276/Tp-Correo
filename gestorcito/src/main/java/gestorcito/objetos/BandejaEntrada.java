package gestorcito.objetos;
import java.util.ArrayList;
import java.util.List;
public class BandejaEntrada {
    private List<Mensaje> mensajes;
    public BandejaEntrada(){
    mensajes=new ArrayList<>();
    }
    public void recibirMensaje(Mensaje mensaje){
    mensajes.add(mensaje);
    }
}
