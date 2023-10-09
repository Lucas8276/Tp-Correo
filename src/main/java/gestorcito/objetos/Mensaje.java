package gestorcito.objetos;

public class Mensaje {
    private Usuario remitente;
    private Usuario destinatario;
    private String asunto;
    private String contenido;
    public Mensaje(Usuario remitente, Usuario destinatario,String asunto, String contenido){
        this.remitente=remitente;
        this.destinatario=destinatario;
        //Verifico que si el asunto esta vacio, si es asi relleno con "Sin asunto"
        if(asunto==null || asunto.isEmpty()){
        this.asunto="Sin asunto";
        }
        else{
        this.asunto=asunto;
        }
        this.contenido=contenido;   
    }
    
    public Usuario getRemitente(){
        return remitente;
    }
    public Usuario getDestinatario(){
        return destinatario;
    }
    public String getContenido(){
        return contenido;
    }
    public String getAsunto(){
        return asunto;
    }
}
